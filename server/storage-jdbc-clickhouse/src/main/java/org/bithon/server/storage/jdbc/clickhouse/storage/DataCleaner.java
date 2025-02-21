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

package org.bithon.server.storage.jdbc.clickhouse.storage;

import lombok.extern.slf4j.Slf4j;
import org.bithon.component.commons.time.DateTime;
import org.bithon.component.commons.utils.StringUtils;
import org.bithon.server.storage.jdbc.clickhouse.ClickHouseConfig;
import org.jooq.DSLContext;
import org.jooq.Table;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author frank.chen021@outlook.com
 * @date 28/7/22 1:15 PM
 */
@Slf4j
public class DataCleaner {

    private final ClickHouseConfig config;
    private final DSLContext dsl;

    public DataCleaner(ClickHouseConfig config, DSLContext dsl) {
        this.config = config;
        this.dsl = dsl;
    }

    /**
     * DELETE PARTITION is a very lightweight operation
     */
    @SuppressWarnings("unchecked")
    public void deleteFromPartition(String table, Timestamp before) {
        String fromTable;
        if (StringUtils.isEmpty(config.getCluster())) {
            fromTable = "system.parts";
        } else {
            fromTable = StringUtils.format("clusterAllReplicas('%s', system, parts)", config.getCluster());
        }

        String localTable = config.getLocalTableName(table);
        String selectPartitionSQL = StringUtils.format(
            "SELECT distinct partition FROM %s WHERE database = '%s' AND table = '%s' AND partition < '%s'",
            fromTable,
            config.getDatabase(),
            localTable,
            DateTime.toYYYYMMDD(before.getTime()));

        List<String> partitions = (List<String>) dsl.fetch(selectPartitionSQL)
                                                    .getValues(0);

        for (String partition : partitions) {
            log.info("\tDrop [{}] on [{}]", table, partition);
            dsl.execute(StringUtils.format("ALTER TABLE %s.%s %s DROP PARTITION %s;",
                                           config.getDatabase(),
                                           localTable,
                                           config.getOnClusterExpression(),
                                           partition));
        }
    }

    /**
     * Delete data from table is a heavy operation in ClickHouse
     */
    public void deleteFromTable(Table<?> table,
                                Timestamp before,
                                long deleteRowThreshold) {
        String beforeTimeText = DateTime.toYYYYMMDDhhmmss(before.getTime());
        try {
            long rowCount = dsl.fetchOne(StringUtils.format("SELECT count(1) FROM %s.%s WHERE timestamp < '%s'",
                                                            config.getDatabase(),
                                                            table.getName(),
                                                            beforeTimeText))
                               .getValue(0, Long.class);
            if (rowCount < deleteRowThreshold) {
                log.info("Expiration on table [{}] is skipped because only [{}] rows matches which is lower than the given threshold [{}].",
                         table.getName(),
                         rowCount,
                         deleteRowThreshold);
                return;
            }

            dsl.execute(StringUtils.format("ALTER TABLE %s.%s %s DELETE WHERE timestamp < '%s'",
                                           config.getDatabase(),
                                           config.getLocalTableName(table.getName()),
                                           config.getOnClusterExpression(),
                                           beforeTimeText));
        } catch (Throwable e) {
            log.error(StringUtils.format("Exception occurred when clean table[%s]:%s", table.getName(), e.getMessage()), e);
        }
    }
}
