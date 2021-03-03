package com.sbss.bithon.collector.common.message.handlers;

import com.sbss.bithon.agent.rpc.thrift.service.metric.message.JvmMessage;
import com.sbss.bithon.collector.common.utils.ReflectionUtils;
import com.sbss.bithon.collector.common.utils.datetime.DateTimeUtils;
import com.sbss.bithon.collector.datasource.DataSourceSchemaManager;
import com.sbss.bithon.collector.datasource.storage.IMetricStorage;
import com.sbss.bithon.collector.meta.IMetaStorage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

/**
 * @author frank.chen021@outlook.com
 * @date 2021/1/10 4:31 下午
 */
@Slf4j
@Service
public class JvmMessageHandler extends AbstractMetricMessageHandler<JvmMessage> {

    public JvmMessageHandler(IMetaStorage metaStorage,
                             IMetricStorage metricStorage,
                             DataSourceSchemaManager dataSourceSchemaManager) throws IOException {
        super("jvm-metrics",
              metaStorage,
              metricStorage,
              dataSourceSchemaManager,
              5,
              20,
              Duration.ofSeconds(60),
              4096);
    }

    @Override
    SizedIterator toIterator(JvmMessage message) {
        Map<String, Object> metrics = new HashMap<>();
        metrics.put("appName", message.getAppName());
        metrics.put("instanceName", message.getHostName() + ":" + message.getPort());
        metrics.put("interval", message.getInterval());
        metrics.put("timestamp", DateTimeUtils.dropMilliseconds(message.getTimestamp()));

        ReflectionUtils.getFields(message.getClassesEntity(), metrics);
        ReflectionUtils.getFields(message.getCpuEntity(), metrics);
        ReflectionUtils.getFields(message.getHeapEntity(), metrics);
        ReflectionUtils.getFields(message.getNonHeapEntity(), metrics);
        ReflectionUtils.getFields(message.getMemoryEntity(), metrics);
        ReflectionUtils.getFields(message.getThreadEntity(), metrics);
        ReflectionUtils.getFields(message.getInstanceTimeEntity(), metrics);
        ReflectionUtils.getFields(message.getMetaspaceEntity(), metrics);
        return new SizedIterator() {
            @Override
            public int size() {
                return 1;
            }

            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Map<String, Object> next() {
                return metrics;
            }
        };
    }
}
