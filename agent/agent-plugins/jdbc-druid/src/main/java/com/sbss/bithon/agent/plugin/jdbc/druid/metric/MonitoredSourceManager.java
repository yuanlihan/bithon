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

package com.sbss.bithon.agent.plugin.jdbc.druid.metric;

import com.alibaba.druid.pool.DruidDataSource;
import com.sbss.bithon.agent.core.utils.MiscUtils;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author frankchen
 */
public class MonitoredSourceManager {

    static final MonitoredSourceManager INSTANCE = new MonitoredSourceManager();
    private final Map<String, MonitoredSource> connectionMap = new ConcurrentHashMap<>();
    private final Map<DruidDataSource, MonitoredSource> dataSourceMap = new ConcurrentHashMap<>();

    public static MonitoredSourceManager getInstance() {
        return INSTANCE;
    }

    public boolean addDataSource(DruidDataSource dataSource) {
        String connectionString = MiscUtils.cleanupConnectionString(dataSource.getRawJdbcUrl());
        if (connectionMap.containsKey(connectionString) && dataSourceMap.containsKey(dataSource)) {
            return false;
        }

        MonitoredSource monitoredSource = new MonitoredSource(dataSource.getDriverClassName(),
                                                              connectionString,
                                                              dataSource);
        connectionMap.putIfAbsent(connectionString, monitoredSource);
        dataSourceMap.putIfAbsent(dataSource, monitoredSource);
        return true;
    }

    public void rmvDataSource(DruidDataSource dataSource) {
        MonitoredSource monitoredSource = dataSourceMap.remove(dataSource);
        if (monitoredSource != null) {
            connectionMap.remove(monitoredSource.getConnectionString());
        }
    }

    public MonitoredSource getMonitoredDataSource(DruidDataSource dataSource) {
        return dataSourceMap.get(dataSource);
    }

    public MonitoredSource getMonitoredDataSource(String key) {
        return connectionMap.get(key);
    }

    public Collection<MonitoredSource> getMonitoredSources() {
        return connectionMap.values();
    }

    public boolean isEmpty() {
        return connectionMap.isEmpty();
    }
}
