/*
 *    Copyright 2020 bithon.cn
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.sbss.bithon.server.metric.storage.jdbc;

import com.google.common.collect.ImmutableMap;
import com.sbss.bithon.server.common.matcher.AntPathMatcher;
import com.sbss.bithon.server.common.matcher.ContainsMatcher;
import com.sbss.bithon.server.common.matcher.EndwithMatcher;
import com.sbss.bithon.server.common.matcher.EqualMatcher;
import com.sbss.bithon.server.common.matcher.IContainsMatcher;
import com.sbss.bithon.server.common.matcher.IMatcherVisitor;
import com.sbss.bithon.server.common.matcher.RegexMatcher;
import com.sbss.bithon.server.common.matcher.StartwithMatcher;
import com.sbss.bithon.server.common.utils.datetime.TimeSpan;
import com.sbss.bithon.server.metric.DataSourceSchema;
import com.sbss.bithon.server.metric.aggregator.spec.CountMetricSpec;
import com.sbss.bithon.server.metric.aggregator.spec.DoubleLastMetricSpec;
import com.sbss.bithon.server.metric.aggregator.spec.DoubleSumMetricSpec;
import com.sbss.bithon.server.metric.aggregator.spec.IMetricSpec;
import com.sbss.bithon.server.metric.aggregator.spec.IMetricSpecVisitor;
import com.sbss.bithon.server.metric.aggregator.spec.LongLastMetricSpec;
import com.sbss.bithon.server.metric.aggregator.spec.LongMaxMetricSpec;
import com.sbss.bithon.server.metric.aggregator.spec.LongMinMetricSpec;
import com.sbss.bithon.server.metric.aggregator.spec.LongSumMetricSpec;
import com.sbss.bithon.server.metric.aggregator.spec.PostAggregatorExpressionVisitor;
import com.sbss.bithon.server.metric.aggregator.spec.PostAggregatorMetricSpec;
import com.sbss.bithon.server.metric.storage.DimensionCondition;
import com.sbss.bithon.server.metric.storage.IMetricReader;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Record;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author frank.chen021@outlook.com
 * @date 2021/1/31 1:39 下午
 */
@Slf4j
class MetricJdbcReader implements IMetricReader {
    private final DSLContext dsl;

    public MetricJdbcReader(DSLContext dsl) {
        this.dsl = dsl;
    }

    // TODO: 具有多个纬度的聚合条件下，last/first应该按多个纬度分组求last/first，再聚合求和
    @Override
    public List<Map<String, Object>> timeseries(TimeSpan start,
                                                TimeSpan end,
                                                DataSourceSchema dataSourceSchema,
                                                Collection<DimensionCondition> filters,
                                                Collection<String> metrics,
                                                int interval) {
        String sqlTableName = "bithon_" + dataSourceSchema.getName().replace("-", "_");
        MetricFieldsClauseBuilder metricFieldsBuilder = new MetricFieldsClauseBuilder(sqlTableName,
                                                                                      "OUTER",
                                                                                      dataSourceSchema,
                                                                                      ImmutableMap.of("interval",
                                                                                                      interval));

        String groupByExpression = String.format("UNIX_TIMESTAMP(\"timestamp\") / %d * %d", interval, interval);
        String metricList = metrics.stream()
                                   .map(m -> dataSourceSchema.getMetricSpecByName(m).accept(metricFieldsBuilder))
                                   .collect(Collectors.joining(", "));

        String condition = filters.stream()
                                  .map(dimension -> dimension.getMatcher()
                                                             .accept(new SqlConditionBuilder(dimension.getDimension())))
                                  .collect(Collectors.joining(" AND "));
        String sql = String.format(
            "SELECT %s \"timestamp\", %s FROM \"%s\" %s WHERE %s AND \"timestamp\" >= '%s' AND \"timestamp\" <= '%s' GROUP BY %s",
            groupByExpression,
            metricList,
            sqlTableName,
            "OUTER",
            condition,
            start.toISO8601(),
            end.toISO8601(),
            "\"timestamp\""
        );

        List<Map<String, Object>> queryResult = executeSql(sql);

        //
        // fill empty
        //
        List<Map<String, Object>> returns = new ArrayList<>();
        int j = 0;
        for (long slot = start.toSeconds() / interval * interval, endSlot = end.toSeconds() / interval * interval;
             slot < endSlot;
             slot += interval) {
            if (j < queryResult.size()) {
                long nextSlot = ((Number) queryResult.get(j).get("timestamp")).longValue();
                while (slot < nextSlot) {
                    Map<String, Object> empty = new HashMap<>(metrics.size());
                    empty.put("timestamp", slot * 1000);
                    metrics.forEach((metric) -> empty.put(metric, 0));
                    returns.add(empty);
                    slot += interval;
                }
                queryResult.get(j).put("timestamp", nextSlot * 1000);
                returns.add(queryResult.get(j++));
            } else {
                Map<String, Object> empty = new HashMap<>(metrics.size());
                empty.put("timestamp", slot * 1000);
                metrics.forEach((metric) -> empty.put(metric, 0));
                returns.add(empty);
            }
        }
        return returns;
    }

    @Override
    public Map<String, Object> getMetricValue(TimeSpan start,
                                              TimeSpan end,
                                              DataSourceSchema dataSourceSchema,
                                              Collection<DimensionCondition> dimensions,
                                              Collection<String> metrics) {
        String sqlTableName = "bithon_" + dataSourceSchema.getName().replace("-", "_");
        MetricFieldsClauseBuilder metricFieldsBuilder = new MetricFieldsClauseBuilder(sqlTableName,
                                                                                      "OUTER",
                                                                                      dataSourceSchema,
                                                                                      ImmutableMap.of("interval",
                                                                                                      (end.getMilliseconds()
                                                                                                       - start.getMilliseconds())
                                                                                                      / 1000));
        String metricList = metrics.stream()
                                   .map(m -> dataSourceSchema.getMetricSpecByName(m).accept(metricFieldsBuilder))
                                   .collect(Collectors.joining(", "));

        String condition = dimensions.stream()
                                     .map(dimension -> dimension.getMatcher()
                                                                .accept(new SqlConditionBuilder(dimension.getDimension())))
                                     .collect(Collectors.joining(" AND "));
        String sql = String.format(
            "SELECT %s FROM \"%s\" %s WHERE %s AND \"timestamp\" >= '%s' AND \"timestamp\" <= '%s'",
            metricList,
            sqlTableName,
            "OUTER",
            condition,
            start.toISO8601(),
            end.toISO8601()
        );
        List<Map<String, Object>> values = executeSql(sql);
        return CollectionUtils.isEmpty(values) ? Collections.emptyMap() : values.get(0);
    }

    @Override
    public List<Map<String, Object>> groupBy(TimeSpan start,
                                             TimeSpan end,
                                             DataSourceSchema dataSourceSchema,
                                             Collection<DimensionCondition> filter,
                                             Collection<String> metrics,
                                             Collection<String> groupBy) {
        String sqlTableName = "bithon_" + dataSourceSchema.getName().replace("-", "_");
        MetricFieldsClauseBuilder metricFieldsBuilder = new MetricFieldsClauseBuilder(sqlTableName,
                                                                                      "OUTER",
                                                                                      dataSourceSchema,
                                                                                      ImmutableMap.of("interval",
                                                                                                      (end.getMilliseconds()
                                                                                                       - start.getMilliseconds())
                                                                                                      / 1000));
        String metricList = metrics.stream()
                                   .map(m -> dataSourceSchema.getMetricSpecByName(m).accept(metricFieldsBuilder))
                                   .collect(Collectors.joining(", "));

        String condition = filter.stream()
                                 .map(dimension -> dimension.getMatcher()
                                                            .accept(new SqlConditionBuilder(dimension.getDimension())))
                                 .collect(Collectors.joining(" AND "));

        String groupByFields = groupBy.stream().map(f -> "\"" + f + "\"").collect(Collectors.joining(","));

        String sql = String.format(
            "SELECT %s, %s FROM \"%s\" %s WHERE %s AND \"timestamp\" >= '%s' AND \"timestamp\" <= '%s' GROUP BY %s",
            groupByFields,
            metricList,
            sqlTableName,
            "OUTER",
            condition,
            start.toISO8601(),
            end.toISO8601(),
            groupByFields
        );
        return executeSql(sql);
    }

    @Override
    public List<Map<String, Object>> executeSql(String sql) {
        log.info("Executing {}", sql);

        List<Record> records = dsl.fetch(sql);

        // PAY ATTENTION:
        //  although the explicit cast seems unnecessary, it must be kept so that compilation can pass
        //  this is might be a bug of JDK
        return (List<Map<String, Object>>) records.stream().map(record -> {
            Map<String, Object> mapObject = new HashMap<>();
            for (Field<?> field : record.fields()) {
                mapObject.put(field.getName(), record.get(field));
            }
            return mapObject;
        }).collect(Collectors.toList());
    }

    @Override
    public List<Map<String, String>> getDimensionValueList(TimeSpan start,
                                                           TimeSpan end,
                                                           DataSourceSchema dataSourceSchema,
                                                           Collection<DimensionCondition> conditions,
                                                           String dimension) {
        String condition = conditions.stream()
                                     .map(d -> d.getMatcher().accept(new SqlConditionBuilder(d.getDimension())))
                                     .collect(Collectors.joining(" AND "));
        String sql = String.format(
            "SELECT DISTINCT(\"%s\") \"%s\" FROM \"%s\" WHERE %s AND \"timestamp\" >= '%s' AND \"timestamp\" <= '%s' ",
            dimension,
            dimension,
            "bithon_" + dataSourceSchema.getName().replace("-", "_"),
            condition,
            start.toISO8601(),
            end.toISO8601()
        );

        log.info("Executing {}", sql);
        List<Record> records = dsl.fetch(sql);
        return records.stream().map(record -> {
            Map<String, String> mapObject = new HashMap<>();
            for (Field<?> field : record.fields()) {
                mapObject.put("value", record.get(field).toString());
            }
            return mapObject;
        }).collect(Collectors.toList());
    }

    /**
     * build SQL where clause
     */
    static class SqlConditionBuilder implements IMatcherVisitor<String> {
        private final String name;

        SqlConditionBuilder(String name) {
            this.name = name;
        }

        @Override
        public String visit(EqualMatcher matcher) {
            StringBuilder sb = new StringBuilder(64);
            sb.append("\"");
            sb.append(name);
            sb.append("\"");
            sb.append("=");
            sb.append('\'');
            sb.append(matcher.getPattern());
            sb.append('\'');
            return sb.toString();
        }

        @Override
        public String visit(AntPathMatcher antPathMatcher) {
            return null;
        }

        @Override
        public String visit(ContainsMatcher containsMatcher) {
            return null;
        }

        @Override
        public String visit(EndwithMatcher endwithMatcher) {
            return null;
        }

        @Override
        public String visit(IContainsMatcher iContainsMatcher) {
            return null;
        }

        @Override
        public String visit(RegexMatcher regexMatcher) {
            return null;
        }

        @Override
        public String visit(StartwithMatcher startwithMatcher) {
            return null;
        }
    }

    /**
     * build SQL clause which aggregates specified metric
     */
    public static class MetricFieldsClauseBuilder implements IMetricSpecVisitor<String> {

        private final String sqlTableName;
        private final String tableAlias;
        private final DataSourceSchema dataSource;
        private final boolean addAlias;
        private final Map<String, Object> variables;

        public MetricFieldsClauseBuilder(String sqlTableName,
                                         String tableAlias,
                                         DataSourceSchema dataSource,
                                         Map<String, Object> variables) {
            this(sqlTableName, tableAlias, dataSource, variables, true);
        }

        public MetricFieldsClauseBuilder(String sqlTableName,
                                         String tableAlias,
                                         DataSourceSchema dataSource,
                                         Map<String, Object> variables,
                                         boolean addAlias) {
            this.sqlTableName = sqlTableName;
            this.tableAlias = tableAlias;
            this.dataSource = dataSource;
            this.variables = variables;
            this.addAlias = addAlias;
        }

        @Override
        public String visit(LongSumMetricSpec metricSpec) {
            StringBuilder sb = new StringBuilder();
            sb.append(String.format("sum(\"%s\")", metricSpec.getName()));
            if (addAlias) {
                sb.append(String.format(" \"%s\"", metricSpec.getName()));
            }
            return sb.toString();
        }

        @Override
        public String visit(DoubleSumMetricSpec metricSpec) {
            StringBuilder sb = new StringBuilder();
            sb.append(String.format("sum(\"%s\")", metricSpec.getName()));
            if (addAlias) {
                sb.append(String.format(" \"%s\"", metricSpec.getName()));
            }
            return sb.toString();
        }

        @Override
        public String visit(PostAggregatorMetricSpec metricSpec) {
            StringBuilder sb = new StringBuilder();
            metricSpec.visitExpression(new PostAggregatorExpressionVisitor() {
                @Override
                public void visitMetric(IMetricSpec metricSpec) {
                    sb.append(metricSpec.accept(new MetricFieldsClauseBuilder(null,
                                                                              null,
                                                                              dataSource,
                                                                              variables,
                                                                              false)));
                }

                @Override
                public void visitNumber(String number) {
                    sb.append(number);
                }

                @Override
                public void visitorOperator(String operator) {
                    sb.append(operator);
                }

                @Override
                public void startBrace() {
                    sb.append('(');
                }

                @Override
                public void endBrace() {
                    sb.append(')');
                }

                @Override
                public void visitVariable(String variable) {
                    Object variableValue = variables.get(variable);
                    if (variableValue == null) {
                        throw new RuntimeException(String.format("variable (%s) not provided in context", variable));
                    }
                    sb.append(variableValue);
                }
            });
            sb.append(String.format(" \"%s\"", metricSpec.getName()));
            return sb.toString();
        }

        @Override
        public String visit(CountMetricSpec metricSpec) {
            StringBuilder sb = new StringBuilder();
            sb.append(String.format("sum(\"%s\")", metricSpec.getName()));
            if (addAlias) {
                sb.append(String.format(" \"%s\"", metricSpec.getName()));
            }
            return sb.toString();
        }

        /**
         * Since FIRST/LAST aggregators are not supported in many SQL databases,
         * A embedded query is created to simulate FIRST/LAST
         */
        @Override
        public String visit(LongLastMetricSpec metricSpec) {
            return visitLast(metricSpec.getName());
        }

        @Override
        public String visit(DoubleLastMetricSpec metricSpec) {
            return visitLast(metricSpec.getName());
        }

        @Override
        public String visit(LongMinMetricSpec metricSpec) {
            StringBuilder sb = new StringBuilder();
            sb.append(String.format("min(\"%s\")", metricSpec.getName()));
            if (addAlias) {
                sb.append(String.format(" \"%s\"", metricSpec.getName()));
            }
            return sb.toString();
        }

        @Override
        public String visit(LongMaxMetricSpec metricSpec) {
            StringBuilder sb = new StringBuilder();
            sb.append(String.format("max(\"%s\")", metricSpec.getName()));
            if (addAlias) {
                sb.append(String.format(" \"%s\"", metricSpec.getName()));
            }
            return sb.toString();
        }

        private String visitLast(String metricName) {
            StringBuilder sb = new StringBuilder();
            sb.append(String.format(
                "(SELECT \"%s\" FROM \"%s\" B WHERE B.\"timestamp\" = \"%s\".\"timestamp\" ORDER BY \"timestamp\" DESC LIMIT 1)",
                metricName,
                sqlTableName,
                tableAlias));

            if (addAlias) {
                sb.append(' ');
                sb.append('"');
                sb.append(metricName);
                sb.append('"');
            }
            return sb.toString();
        }
    }
}
