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

package org.bithon.agent.dispatcher.brpc;

import org.bithon.agent.core.dispatcher.IMessageConverter;
import org.bithon.agent.core.event.EventMessage;
import org.bithon.agent.core.metric.collector.IMeasurement;
import org.bithon.agent.core.metric.domain.exception.ExceptionMetrics;
import org.bithon.agent.core.metric.domain.jdbc.JdbcPoolMetrics;
import org.bithon.agent.core.metric.domain.jvm.GcMetrics;
import org.bithon.agent.core.metric.domain.jvm.JvmMetrics;
import org.bithon.agent.core.metric.domain.mongo.MongoDbMetrics;
import org.bithon.agent.core.metric.domain.redis.RedisClientMetrics;
import org.bithon.agent.core.metric.domain.sql.SQLMetrics;
import org.bithon.agent.core.metric.domain.sql.SQLStatementMetrics;
import org.bithon.agent.core.metric.domain.thread.ThreadPoolMetrics;
import org.bithon.agent.core.metric.domain.web.WebServerMetrics;
import org.bithon.agent.core.metric.model.schema.Schema;
import org.bithon.agent.core.metric.model.schema.Schema2;
import org.bithon.agent.core.tracing.context.ITraceSpan;
import org.bithon.agent.rpc.brpc.event.BrpcEventMessage;
import org.bithon.agent.rpc.brpc.metrics.BrpcExceptionMetricMessage;
import org.bithon.agent.rpc.brpc.metrics.BrpcGenericDimensionSpec;
import org.bithon.agent.rpc.brpc.metrics.BrpcGenericMeasurement;
import org.bithon.agent.rpc.brpc.metrics.BrpcGenericMetricMessage;
import org.bithon.agent.rpc.brpc.metrics.BrpcGenericMetricMessageV2;
import org.bithon.agent.rpc.brpc.metrics.BrpcGenericMetricSchema;
import org.bithon.agent.rpc.brpc.metrics.BrpcGenericMetricSchemaV2;
import org.bithon.agent.rpc.brpc.metrics.BrpcGenericMetricSpec;
import org.bithon.agent.rpc.brpc.metrics.BrpcJdbcPoolMetricMessage;
import org.bithon.agent.rpc.brpc.metrics.BrpcJvmGcMetricMessage;
import org.bithon.agent.rpc.brpc.metrics.BrpcJvmMetricMessage;
import org.bithon.agent.rpc.brpc.metrics.BrpcRedisMetricMessage;
import org.bithon.agent.rpc.brpc.metrics.BrpcThreadPoolMetricMessage;
import org.bithon.agent.rpc.brpc.metrics.BrpcWebServerMetricMessage;
import org.bithon.agent.rpc.brpc.tracing.BrpcTraceSpanMessage;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author frank.chen021@outlook.com
 * @date 2021/6/27 20:13
 */
public class BrpcMessageConverter implements IMessageConverter {

    @Override
    public Object from(long timestamp, int interval, JdbcPoolMetrics metrics) {
        return BrpcJdbcPoolMetricMessage.newBuilder()
                                        .setTimestamp(timestamp)
                                        .setInterval(interval)
                                        .setConnectionString(metrics.getConnectionString())
                                        .setDriverClass(metrics.getDriverClass())
                                        .setActiveCount(metrics.activeCount.get())
                                        .setActivePeak(metrics.activePeak.get())
                                        .setPoolingCount(metrics.poolingCount.get())
                                        .setPoolingPeak(metrics.poolingPeak.get())
                                        .setCreateCount(metrics.createCount.get())
                                        .setDestroyCount(metrics.destroyCount.get())
                                        .setLogicCloseCount(metrics.logicCloseCount.get())
                                        .setLogicCloseCount(metrics.logicCloseCount.get())
                                        .setCreateErrorCount(metrics.createErrorCount.get())
                                        .setExecuteCount(metrics.executeCount.get())
                                        .setCommitCount(metrics.commitCount.get())
                                        .setRollbackCount(metrics.rollbackCount.get())
                                        .setStartTransactionCount(metrics.startTransactionCount.get())
                                        .setWaitThreadCount(metrics.waitThreadCount.get())
                                        .build();
    }

    @Override
    public Object from(long timestamp, int interval, List<String> dimensions, SQLMetrics metrics) {
        return null;
    }

    @Override
    public Object from(long timestamp, int interval, List<String> dimensions, MongoDbMetrics metrics) {
        return null;
    }

    @Override
    public Object from(long timestamp, int interval, JvmMetrics metrics) {
        BrpcJvmMetricMessage.Builder builder = BrpcJvmMetricMessage.newBuilder();
        builder.setInterval(interval);
        builder.setTimestamp(timestamp);
        builder.setInstanceStartTime(metrics.startTime);
        builder.setInstanceUpTime(metrics.upTime);
        builder.setProcessors(metrics.cpu.processorNumber);
        builder.setProcessCpuLoad(metrics.cpu.processCpuLoad);
        builder.setProcessCpuTime(metrics.cpu.processCpuTime);
        builder.setSystemLoadAvg(metrics.cpu.avgSystemLoad);
        builder.setTotalMemBytes(metrics.memory.allocatedBytes);
        builder.setFreeMemBytes(metrics.memory.freeBytes);
        builder.setHeapMax(metrics.heap.max);
        builder.setHeapInit(metrics.heap.init);
        builder.setHeapCommitted(metrics.heap.committed);
        builder.setHeapUsed(metrics.heap.used);
        builder.setNonHeapMax(metrics.nonHeap.max);
        builder.setNonHeapInit(metrics.nonHeap.init);
        builder.setNonHeapCommitted(metrics.nonHeap.committed);
        builder.setNonHeapUsed(metrics.nonHeap.used);
        builder.setPeakThreads(metrics.thread.peakActiveCount);
        builder.setActiveThreads(metrics.thread.activeThreadsCount);
        builder.setDaemonThreads(metrics.thread.activeDaemonCount);
        builder.setTotalThreads(metrics.thread.totalCreatedCount);
        builder.setClassLoaded(metrics.clazz.currentLoadedClasses);
        builder.setClassUnloaded(metrics.clazz.totalUnloadedClasses);
        builder.setMetaspaceCommitted(metrics.metaspace.committed);
        builder.setMetaspaceUsed(metrics.metaspace.used);
        builder.setMetaspaceInit(metrics.metaspace.init);
        builder.setMetaspaceMax(metrics.metaspace.max);
        builder.setDirectMax(metrics.directMemory.max);
        builder.setDirectUsed(metrics.directMemory.used);
        return builder.build();
    }

    @Override
    public Object from(long timestamp, int interval, WebServerMetrics metrics) {
        return BrpcWebServerMetricMessage.newBuilder()
                                         .setTimestamp(timestamp)
                                         .setInterval(interval)
                                         .setActiveThreads(metrics.getActiveThreads())
                                         .setConnectionCount(metrics.getConnectionCount())
                                         .setMaxConnections(metrics.getMaxConnections())
                                         .setMaxThreads(metrics.getMaxThreads())
                                         .setType(metrics.getServerType().toString())
                                         .build();
    }

    @Override
    public Object from(long timestamp, int interval, SQLStatementMetrics metrics) {
        return null;
    }

    @Override
    public Object from(long timestamp, int interval, List<String> dimensions, RedisClientMetrics metrics) {
        return BrpcRedisMetricMessage.newBuilder()
                                     .setTimestamp(timestamp)
                                     .setInterval(interval)
                                     .setUri(dimensions.get(0))
                                     .setCommand(dimensions.get(1))
                                     .setMinRequestTime(metrics.getRequestTime().getMin().get())
                                     .setRequestTime(metrics.getRequestTime().getSum().get())
                                     .setMaxRequestTime(metrics.getRequestTime().getMax().get())
                                     .setMinResponseTime(metrics.getResponseTime().getMin().get())
                                     .setResponseTime(metrics.getResponseTime().getSum().get())
                                     .setMaxResponseTime(metrics.getResponseTime().getMax().get())
                                     .setTotalCount(metrics.getCallCount())
                                     .setExceptionCount(metrics.getExceptionCount())
                                     .setRequestBytes(metrics.getRequestBytes())
                                     .setResponseBytes(metrics.getResponseBytes())
                                     .build();
    }

    @Override
    public Object from(long timestamp, int interval, ExceptionMetrics metrics) {
        BrpcExceptionMetricMessage.Builder builder = BrpcExceptionMetricMessage.newBuilder()
                                                                               .setTimestamp(timestamp)
                                                                               .setInterval(interval);
        if (metrics.getUri() != null) {
            builder.setUri(metrics.getUri());
        }
        if (metrics.getMessage() != null) {
            builder.setMessage(metrics.getMessage());
        }
        return builder.setExceptionCount(metrics.getCount())
                      .setClassName(metrics.getExceptionClass())
                      .build();
    }

    @Override
    public Object from(long timestamp, int interval, ThreadPoolMetrics metrics) {
        return BrpcThreadPoolMetricMessage.newBuilder().setTimestamp(timestamp)
                                          .setInterval(interval)
                                          .setExecutorClass(metrics.getExecutorClass())
                                          .setPoolName(metrics.getThreadPoolName())
                                          // task
                                          .setCallerRunTaskCount(metrics.getCallerRunTaskCount())
                                          .setAbortedTaskCount(metrics.getAbortedTaskCount())
                                          .setDiscardedOldestTaskCount(metrics.getDiscardedOldestTaskCount())
                                          .setDiscardedTaskCount(metrics.getDiscardedTaskCount())
                                          .setExceptionTaskCount(metrics.getExceptionTaskCount())
                                          .setSuccessfulTaskCount(metrics.getSuccessfulTaskCount())
                                          .setTotalTaskCount(metrics.getTotalTaskCount())
                                          // thread pool
                                          .setActiveThreads(metrics.getActiveThreads())
                                          .setCurrentPoolSize(metrics.getCurrentPoolSize())
                                          .setMaxPoolSize(metrics.getMaxPoolSize())
                                          .setLargestPoolSize(metrics.getLargestPoolSize())
                                          .build();
    }

    @Override
    public Object from(ITraceSpan span) {
        BrpcTraceSpanMessage.Builder builder = BrpcTraceSpanMessage.newBuilder()
                                                                   .setTraceId(span.traceId())
                                                                   .setSpanId(span.spanId())
                                                                   .setStartTime(span.startTime())
                                                                   .setEndTime(span.endTime())
                                                                   .setKind(span.kind().toString())
                                                                   .setName(span.component())
                                                                   .setClazz(span.clazz())
                                                                   .setMethod(span.method())
                                                                   .putAllTags(span.tags());
        if (span.parentApplication() != null) {
            builder.setParentAppName(span.parentApplication());
        }
        if (span.parentSpanId() != null) {
            builder.setParentSpanId(span.parentSpanId());
        }
        return builder.build();
    }

    @Override
    public Object from(EventMessage event) {
        return BrpcEventMessage.newBuilder()
                               .setTimestamp(System.currentTimeMillis())
                               .setEventType(event.getMessageType())
                               .putAllArguments(event.getArgs() == null ? Collections.emptyMap() : event.getArgs())
                               .build();
    }

    @Override
    public Object from(Map<String, String> log) {
        return null;
    }

    @Override
    public Object from(long timestamp, int interval, GcMetrics metrics) {
        return BrpcJvmGcMetricMessage.newBuilder().setTimestamp(timestamp)
                                     .setInterval(interval)
                                     .setGcName(metrics.getGcName())
                                     .setGeneration(metrics.getGeneration())
                                     .setGcTime(metrics.getGcTime())
                                     .setGcCount(metrics.getGcCount())
                                     .build();
    }

    @Override
    public Object from(Schema schema,
                       Collection<IMeasurement> measurementList,
                       long timestamp,
                       int interval) {
        BrpcGenericMetricSchema.Builder schemaBuilder = BrpcGenericMetricSchema.newBuilder()
                                                                               .setName(schema.getName());
        schema.getDimensionsSpec()
              .forEach(dimensionSpec -> schemaBuilder.addDimensionsSpec(BrpcGenericDimensionSpec.newBuilder()
                                                                                                .setName(dimensionSpec.getName())
                                                                                                .setType(dimensionSpec.getType())
                                                                                                .build()));
        schema.getMetricsSpec().forEach(metricSpec -> schemaBuilder.addMetricsSpec(BrpcGenericMetricSpec.newBuilder()
                                                                                                        .setName(
                                                                                                            metricSpec.getName())
                                                                                                        .setType(
                                                                                                            metricSpec.getType())
                                                                                                        .build()));

        BrpcGenericMetricMessage.Builder messageBuilder = BrpcGenericMetricMessage.newBuilder();
        messageBuilder.setSchema(schemaBuilder.build());
        messageBuilder.setInterval(interval);
        messageBuilder.setTimestamp(timestamp);

        measurementList.forEach(metricSet -> {
            BrpcGenericMeasurement.Builder measurement = BrpcGenericMeasurement.newBuilder();
            // although dimensions are defined as List<String>
            // but it could also store Object
            // we use Object.toString here to get right value
            for (Object dimension : metricSet.getDimensions()) {
                measurement.addDimension(dimension.toString());
            }
            for (int i = 0, size = metricSet.getMetricCount(); i < size; i++) {
                measurement.addMetric(metricSet.getMetricValue(i));
            }
            messageBuilder.addMeasurement(measurement.build());
        });

        return messageBuilder.build();
    }

    @Override
    public Object from(Schema2 schema, Collection<IMeasurement> measurementList, long timestamp, int interval) {
        BrpcGenericMetricSchemaV2.Builder schemaBuilder = BrpcGenericMetricSchemaV2.newBuilder()
                                                                                   .setName(schema.getName());
        schema.getDimensionsSpec().forEach(schemaBuilder::addDimensionsSpec);
        schema.getMetricsSpec().forEach(schemaBuilder::addMetricsSpec);

        BrpcGenericMetricMessageV2.Builder messageBuilder = BrpcGenericMetricMessageV2.newBuilder();
        messageBuilder.setSchema(schemaBuilder.build());
        messageBuilder.setInterval(interval);
        messageBuilder.setTimestamp(timestamp);

        measurementList.forEach(metricSet -> {
            BrpcGenericMeasurement.Builder measurement = BrpcGenericMeasurement.newBuilder();
            // although dimensions are defined as List<String>
            // but it could also store Object
            // we use Object.toString here to get right value
            for (Object dimension : metricSet.getDimensions()) {
                measurement.addDimension(dimension.toString());
            }
            for (int i = 0, size = metricSet.getMetricCount(); i < size; i++) {
                measurement.addMetric(metricSet.getMetricValue(i));
            }
            messageBuilder.addMeasurement(measurement.build());
        });

        return messageBuilder.build();
    }
}
