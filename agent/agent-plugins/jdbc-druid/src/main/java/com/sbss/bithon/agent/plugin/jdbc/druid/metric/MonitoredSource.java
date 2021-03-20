package com.sbss.bithon.agent.plugin.jdbc.druid.metric;

import com.alibaba.druid.pool.DruidDataSource;
import com.sbss.bithon.agent.core.metric.jdbc.JdbcPoolMetric;
import com.sbss.bithon.agent.core.metric.sql.SqlMetric;

/**
 * @author frank.chen021@outlook.com
 * @date 2021/2/27 11:32 上午
 */
public class MonitoredSource {
    private final DruidDataSource dataSource;
    private final String driverClass;

    // dimension
    private final String connectionString;

    // metrics
    private final JdbcPoolMetric jdbcPoolMetric;
    private final SqlMetric sqlMetric;

    MonitoredSource(String driverClass,
                    String connectionString,
                    DruidDataSource dataSource) {
        this.dataSource = dataSource;
        this.driverClass = driverClass;
        this.connectionString = connectionString;
        this.jdbcPoolMetric = new JdbcPoolMetric(connectionString, driverClass);
        this.sqlMetric = new SqlMetric(connectionString, driverClass);
    }

    public DruidDataSource getDataSource() {
        return dataSource;
    }

    public String getDriverClass() {
        return driverClass;
    }

    public String getConnectionString() {
        return connectionString;
    }

    public JdbcPoolMetric getJdbcMetric() {
        return jdbcPoolMetric;
    }

    public SqlMetric getSqlMetric() {
        return sqlMetric;
    }
}
