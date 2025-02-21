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

package org.bithon.server.collector.sink.kafka;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.OptBoolean;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableMap;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.Header;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.apache.kafka.common.record.AbstractRecords;
import org.apache.kafka.common.record.CompressionType;
import org.apache.kafka.common.record.RecordBatch;
import org.apache.kafka.common.serialization.ByteArraySerializer;
import org.bithon.component.commons.utils.CollectionUtils;
import org.bithon.component.commons.utils.Preconditions;
import org.bithon.server.sink.metrics.IMetricMessageSink;
import org.bithon.server.sink.metrics.SchemaMetricMessage;
import org.bithon.server.storage.datasource.input.IInputRow;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * Sink message to Kafka.
 * <p>
 * The instance is created by {@link org.bithon.server.collector.CollectorAutoConfiguration} and
 * {@link org.bithon.server.collector.sink.SinkConfig}
 *
 * @author frank.chen021@outlook.com
 * @date 2021/3/15
 */
@Slf4j
@JsonTypeName("kafka")
public class KafkaMetricSink implements IMetricMessageSink {

    private final KafkaTemplate<byte[], byte[]> producer;
    private final ObjectMapper objectMapper;
    private final String topic;
    private final ThreadLocal<FixedSizeBuffer> bufferThreadLocal;
    private final CompressionType compressionType;

    @JsonCreator
    public KafkaMetricSink(@JsonProperty("props") Map<String, Object> props,
                           @JacksonInject(useInput = OptBoolean.FALSE) ObjectMapper objectMapper) {
        this.topic = (String) props.remove("topic");
        Preconditions.checkNotNull(topic, "topic is not configured for metrics sink");

        int maxSizePerMessage = (int) props.getOrDefault(ProducerConfig.MAX_REQUEST_SIZE_CONFIG, ProducerConfig.configDef()
                                                                                                               .configKeys()
                                                                                                               .get(ProducerConfig.MAX_REQUEST_SIZE_CONFIG).defaultValue);
        Preconditions.checkIfTrue(maxSizePerMessage >= 1024, ProducerConfig.MAX_REQUEST_SIZE_CONFIG, "max request size must be >= 1024");

        this.compressionType = CompressionType.forName((String) props.getOrDefault(ProducerConfig.COMPRESSION_TYPE_CONFIG, "none"));
        this.bufferThreadLocal = ThreadLocal.withInitial(() -> new FixedSizeBuffer(maxSizePerMessage));

        this.producer = new KafkaTemplate<>(new DefaultKafkaProducerFactory<>(props,
                                                                              new ByteArraySerializer(),
                                                                              new ByteArraySerializer()),
                                            ImmutableMap.of(ProducerConfig.CLIENT_ID_CONFIG, "metrics"));

        this.objectMapper = objectMapper;
    }

    @Override
    public void process(String messageType, SchemaMetricMessage message) {
        if (CollectionUtils.isEmpty(message.getMetrics())) {
            return;
        }

        String appName = message.getMetrics().get(0).getColAsString("appName");
        String instanceName = message.getMetrics().get(0).getColAsString("instanceName");
        if (appName == null || instanceName == null) {
            return;
        }

        ByteBuffer messageKey = ByteBuffer.wrap((messageType + "/" + appName + "/" + instanceName).getBytes(StandardCharsets.UTF_8));
        RecordHeader header = new RecordHeader("type", messageType.getBytes(StandardCharsets.UTF_8));

        FixedSizeBuffer messageBuffer = this.bufferThreadLocal.get();
        messageBuffer.reset();
        messageBuffer.writeChar('{');
        if (message.getSchema() != null) {
            try {
                messageBuffer.writeString("\"schema\":");
                messageBuffer.writeBytes(this.objectMapper.writeValueAsBytes(message.getSchema()));
                messageBuffer.writeChar(',');
            } catch (JsonProcessingException ignored) {
            }
        }
        messageBuffer.writeString("\"metrics\": [");

        int metricStartOffset = messageBuffer.getOffset();

        for (IInputRow metric : message.getMetrics()) {
            byte[] metricBytes;
            try {
                metricBytes = objectMapper.writeValueAsBytes(metric);
            } catch (JsonProcessingException ignored) {
                continue;
            }

            int currentSize = AbstractRecords.estimateSizeInBytesUpperBound(RecordBatch.CURRENT_MAGIC_VALUE,
                                                                            this.compressionType,
                                                                            messageKey,
                                                                            messageBuffer.toByteBuffer(),
                                                                            new Header[]{header});

            // plus 3 to leave 3 bytes as margin
            if (currentSize + metricBytes.length + 3 > messageBuffer.limit()) {
                send(header, messageKey, messageBuffer);

                messageBuffer.reset(metricStartOffset);
            }

            messageBuffer.writeBytes(metricBytes);
            messageBuffer.writeChar(',');
        }

        send(header, messageKey, messageBuffer);
    }

    private void send(RecordHeader header, ByteBuffer messageKey, FixedSizeBuffer messageBuffer) {
        if (messageBuffer.size() <= 1) {
            return;
        }

        // Remove last separator
        messageBuffer.deleteFromEnd(1);

        // Close JSON objects
        messageBuffer.writeChar(']');
        messageBuffer.writeChar('}');

        ProducerRecord<byte[], byte[]> record = new ProducerRecord<>(topic, messageKey.array(), messageBuffer.toBytes());
        record.headers().add(header);
        try {
            producer.send(record);
        } catch (Exception e) {
            log.error("Error to send metric [{}]", new String(header.value(), StandardCharsets.UTF_8), e);
        }
    }

    @Override
    public void close() {
        this.producer.destroy();
        this.bufferThreadLocal.remove();
    }
}

