/*
 *    Copyright 2020 bithon.org
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

package org.bithon.server.storage.jdbc.clickhouse;

import org.bithon.component.commons.utils.StringUtils;
import org.bithon.server.commons.time.TimeSpan;
import org.bithon.server.storage.jdbc.metric.ISqlExpressionFormatter;

/**
 * @author frank.chen021@outlook.com
 * @date 1/11/21 5:21 pm
 */
class ClickHouseSqlExpressionFormatter implements ISqlExpressionFormatter {

    @Override
    public String timeFloor(String field, long interval) {
        return StringUtils.format("CAST(toUnixTimestamp(\"%s\")/ %d AS Int64) * %d", field, interval, interval);
    }

    @Override
    public boolean groupByUseRawExpression() {
        return false;
    }

    @Override
    public boolean allowSameAggregatorExpression() {
        return false;
    }

    /**
     * ClickHouse does not support ISO8601 very well, we treat it as timestamp, which only accepts timestamp in seconds not milli-seconds
     */
    @Override
    public String formatTimestamp(TimeSpan timeSpan) {
        return StringUtils.format("fromUnixTimestamp(%d)", timeSpan.getMilliseconds() / 1000);
    }

    @Override
    public String orderByTimestamp(String timestampField) {
        return "ORDER BY \"" + timestampField + "\"";
    }

    @Override
    public String stringAggregator(String dimension, String name) {
        return StringUtils.format("arrayStringConcat(arrayCompact(groupArray(%s)), ',') AS %s",
                                  dimension,
                                  name);
    }
}
