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

import com.alibaba.druid.pool.DruidDataSource;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.Module;
import org.bithon.server.storage.jdbc.clickhouse.exception.ClickHouseExceptionTranslator;
import org.bithon.server.storage.jdbc.clickhouse.storage.EventStorage;
import org.bithon.server.storage.jdbc.clickhouse.storage.MetadataStorage;
import org.bithon.server.storage.jdbc.clickhouse.storage.MetricStorage;
import org.bithon.server.storage.jdbc.clickhouse.storage.SchemaStorage;
import org.bithon.server.storage.jdbc.clickhouse.storage.SettingStorage;
import org.bithon.server.storage.jdbc.clickhouse.storage.TraceStorage;
import org.bithon.server.storage.jdbc.clickhouse.storage.web.DashboardStorage;
import org.jooq.impl.DSL;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultExecuteListenerProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jooq.JooqAutoConfiguration;
import org.springframework.boot.autoconfigure.jooq.JooqProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author frank.chen021@outlook.com
 * @date 27/10/21 9:45 pm
 */
@Configuration
@ConditionalOnProperty(prefix = "bithon.storage.providers.clickhouse", name = "enabled", havingValue = "true")
public class ClickHouseStorageAutoConfiguration {

    @Bean("bithon-clickhouse-dataSource")
    @ConfigurationProperties(prefix = "bithon.storage.providers.clickhouse")
    DataSource createDataSource() {
        return new DruidDataSource();
    }

    @Bean
    @ConfigurationProperties(prefix = "bithon.storage.providers.clickhouse")
    ClickHouseConfig clickHouseConfig() {
        return new ClickHouseConfig();
    }

    @Bean
    ClickHouseJooqContextHolder clickHouseDSLContextHolder(@Qualifier("bithon-clickhouse-dataSource") DataSource dataSource) {
        JooqAutoConfiguration autoConfiguration = new JooqAutoConfiguration();
        return new ClickHouseJooqContextHolder(DSL.using(new DefaultConfiguration().set(autoConfiguration.dataSourceConnectionProvider(dataSource))
                                                                                   .set(new JooqProperties().determineSqlDialect(dataSource))
                                                                                   .set(new DefaultExecuteListenerProvider(new ClickHouseExceptionTranslator()))));
    }

    @Bean
    public Module clickHouseStorageModule() {
        return new Module() {
            @Override
            public String getModuleName() {
                return "storage-jdbc-clickhouse";
            }

            @Override
            public Version version() {
                return Version.unknownVersion();
            }

            @Override
            public void setupModule(SetupContext context) {
                context.registerSubtypes(TraceStorage.class,
                                         MetricStorage.class,
                                         EventStorage.class,
                                         MetadataStorage.class,
                                         SchemaStorage.class,
                                         SettingStorage.class,
                                         DashboardStorage.class,
                                         ClickHouseSqlDialect.class);
            }
        };
    }
}
