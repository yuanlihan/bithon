package com.sbss.bithon.server.metric.collector;

import com.sbss.bithon.agent.rpc.thrift.service.MessageHeader;
import com.sbss.bithon.agent.rpc.thrift.service.metric.message.JdbcPoolMetricMessage;
import com.sbss.bithon.component.db.dao.EndPointType;
import com.sbss.bithon.server.meta.storage.IMetaStorage;
import com.sbss.bithon.server.metric.DataSourceSchemaManager;
import com.sbss.bithon.server.metric.storage.IMetricStorage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.Duration;

/**
 * @author frank.chen021@outlook.com
 * @date 2021/1/10 4:31 下午
 */
@Slf4j
@Service
public class JdbcPoolMessageHandler extends AbstractMetricMessageHandler<MessageHeader, JdbcPoolMetricMessage> {

    private enum DriverType {
        MYSQL("com.mysql", "mysql"),
        KYLIN("org.apache.kylin", "kylin"),
        UNKNOWN("unknown", "unknown_jdbc");

        private final String classIdentifier;
        private final String driverType;

        DriverType(String classIdentifier, String driverType) {
            this.classIdentifier = classIdentifier;
            this.driverType = driverType;
        }
    }

    public JdbcPoolMessageHandler(IMetaStorage metaStorage,
                                  IMetricStorage metricStorage,
                                  DataSourceSchemaManager dataSourceSchemaManager) throws IOException {
        super("jdbc-pool-metrics",
              metaStorage,
              metricStorage,
              dataSourceSchemaManager,
              2,
              20,
              Duration.ofSeconds(60),
              4096);
    }

    @Override
    GenericMetricObject toMetricObject(MessageHeader header, JdbcPoolMetricMessage message) {

        GenericMetricObject metrics = new GenericMetricObject(message.getTimestamp(),
                                                              header.getAppName(),
                                                              header.getHostName(),
                                                              message);
        metrics.setEndpointLink(EndPointType.APPLICATION,
                                header.getAppName(),
                                EndPointType.MYSQL,

                                //TODO: extract host and port
                                message.getConnectionString());
        return metrics;
    }
}
