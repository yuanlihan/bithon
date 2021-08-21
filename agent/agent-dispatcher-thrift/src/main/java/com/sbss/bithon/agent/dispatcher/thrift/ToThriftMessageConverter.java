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

package com.sbss.bithon.agent.dispatcher.thrift;

import com.sbss.bithon.agent.core.dispatcher.IMessageConverter;
import com.sbss.bithon.agent.core.event.EventMessage;
import com.sbss.bithon.agent.core.metric.domain.exception.ExceptionMetricSet;
import com.sbss.bithon.agent.core.metric.domain.http.HttpOutgoingMetrics;
import com.sbss.bithon.agent.core.metric.domain.jdbc.JdbcPoolMetricSet;
import com.sbss.bithon.agent.core.metric.domain.jvm.GcCompositeMetric;
import com.sbss.bithon.agent.core.metric.domain.jvm.JvmMetricSet;
import com.sbss.bithon.agent.core.metric.domain.mongo.MongoDbCompositeMetric;
import com.sbss.bithon.agent.core.metric.domain.redis.RedisClientCompositeMetric;
import com.sbss.bithon.agent.core.metric.domain.sql.SqlCompositeMetric;
import com.sbss.bithon.agent.core.metric.domain.sql.SqlStatementCompositeMetric;
import com.sbss.bithon.agent.core.metric.domain.thread.ThreadPoolCompositeMetric;
import com.sbss.bithon.agent.core.metric.domain.web.HttpIncomingMetrics;
import com.sbss.bithon.agent.core.metric.domain.web.WebServerMetricSet;
import com.sbss.bithon.agent.core.tracing.context.ITraceSpan;
import com.sbss.bithon.agent.rpc.thrift.service.event.ThriftEventMessage;
import com.sbss.bithon.agent.rpc.thrift.service.metric.message.ExceptionMetricMessage;
import com.sbss.bithon.agent.rpc.thrift.service.metric.message.HttpIncomingMetricMessage;
import com.sbss.bithon.agent.rpc.thrift.service.metric.message.HttpOutgoingMetricMessage;
import com.sbss.bithon.agent.rpc.thrift.service.metric.message.JdbcPoolMetricMessage;
import com.sbss.bithon.agent.rpc.thrift.service.metric.message.JvmGcMetricMessage;
import com.sbss.bithon.agent.rpc.thrift.service.metric.message.JvmMetricMessage;
import com.sbss.bithon.agent.rpc.thrift.service.metric.message.MongoDbMetricMessage;
import com.sbss.bithon.agent.rpc.thrift.service.metric.message.RedisMetricMessage;
import com.sbss.bithon.agent.rpc.thrift.service.metric.message.SqlMetricMessage;
import com.sbss.bithon.agent.rpc.thrift.service.metric.message.ThreadPoolMetricMessage;
import com.sbss.bithon.agent.rpc.thrift.service.metric.message.WebServerMetricMessage;
import com.sbss.bithon.agent.rpc.thrift.service.trace.TraceSpanMessage;

import java.util.List;
import java.util.Map;

/**
 * @author frank.chen021@outlook.com
 * @date 2021/1/6 11:39 下午
 */
public class ToThriftMessageConverter implements IMessageConverter {

    @Override
    public Object from(long timestamp,
                       int interval,
                       List<String> dimensions,
                       HttpOutgoingMetrics metric) {
        HttpOutgoingMetricMessage message = new HttpOutgoingMetricMessage();
        message.setInterval(interval);
        message.setTimestamp(timestamp);
        message.setUri(dimensions.get(0));
        message.setMethod(dimensions.get(1));
        message.setResponseTime(metric.getResponseTime().getSum().get());
        message.setMinResponseTime(metric.getResponseTime().getMin().get());
        message.setMaxResponseTime(metric.getResponseTime().getMax().get());
        message.setCount4xx(metric.getCount4xx());
        message.setCount5xx(metric.getCount5xx());
        message.setRequestCount(metric.getRequestCount());
        message.setRequestBytes(metric.getRequestBytes());
        message.setResponseBytes(metric.getResponseBytes());
        message.setExceptionCount(metric.getExceptionCount());
        return message;
    }

    @Override
    public Object from(long timestamp, int interval, JdbcPoolMetricSet metric) {
        JdbcPoolMetricMessage message = new JdbcPoolMetricMessage();
        message.setTimestamp(timestamp);
        message.setInterval(interval);
        message.setConnectionString(metric.getConnectionString());
        message.setDriverClass(metric.getDriverClass());
        message.setActiveCount(metric.activeCount.get());
        message.setCreateCount(metric.createCount.get());
        message.setDestroyCount(metric.destroyCount.get());
        message.setPoolingCount(metric.poolingCount.get());
        message.setPoolingPeak(metric.poolingPeak.get());
        message.setActivePeak(metric.activePeak.get());
        message.setLogicConnectCount(metric.logicConnectionCount.get());
        message.setLogicCloseCount(metric.logicCloseCount.get());
        message.setCreateErrorCount(metric.createErrorCount.get());
        message.setExecuteCount(metric.executeCount.get());
        message.setCommitCount(metric.commitCount.get());
        message.setRollbackCount(metric.rollbackCount.get());
        message.setStartTransactionCount(metric.startTransactionCount.get());
        message.setWaitThreadCount(metric.waitThreadCount.get());
        return message;
    }

    @Override
    public Object from(long timestamp, int interval, List<String> dimensions, SqlCompositeMetric metric) {
        SqlMetricMessage message = new SqlMetricMessage();
        message.setTimestamp(timestamp);
        message.setConnectionString(dimensions.get(0));
        message.setInterval(interval);
        message.setCallCount(metric.getCallCount().get());
        message.setResponseTime(metric.getResponseTime().getSum().get());
        message.setMinResponseTime(metric.getResponseTime().getMin().get());
        message.setMaxResponseTime(metric.getResponseTime().getMax().get());
        message.setErrorCount(metric.getErrorCount().get());
        message.setQueryCount(metric.getQueryCount().get());
        message.setUpdateCount(metric.getUpdateCount().get());
        return message;
    }

    @Override
    public Object from(long timestamp,
                       int interval,
                       List<String> dimensions,
                       MongoDbCompositeMetric metric) {
        MongoDbMetricMessage message = new MongoDbMetricMessage();
        message.setInterval(interval);
        message.setTimestamp(timestamp);
        message.setServer(dimensions.get(0));
        message.setDatabase(dimensions.get(1));
        message.setCollection(null);
        message.setCommand(null);
        message.setResponseTime(metric.getResponseTime().getSum().get());
        message.setMaxResponseTime(metric.getResponseTime().getMax().get());
        message.setMinResponseTime(metric.getResponseTime().getMin().get());
        message.setCallCount(metric.getCallCount().get());
        message.setExceptionCount(metric.getExceptionCount().get());
        message.setRequestBytes(metric.getRequestBytes().get());
        message.setResponseBytes(metric.getResponseBytes().get());
        return message;
    }

    @Override
    public Object from(long timestamp,
                       int interval,
                       List<String> dimensions,
                       HttpIncomingMetrics metric) {
        HttpIncomingMetricMessage message = new HttpIncomingMetricMessage();
        message.setInterval(interval);
        message.setTimestamp(timestamp);
        message.setSrcApplication(dimensions.get(0));
        message.setUri(dimensions.get(1));
        message.setResponseTime(metric.getResponseTime().getSum().get());
        message.setMaxResponseTime(metric.getResponseTime().getMax().get());
        message.setMinResponseTime(metric.getResponseTime().getMin().get());
        message.setCallCount(metric.getRequestCount().get());
        message.setErrorCount(metric.getErrorCount().get());
        message.setOkCount(metric.getOkCount().get());
        message.setCount4xx(metric.getCount4xx().get());
        message.setCount5xx(metric.getCount5xx().get());
        message.setRequestBytes(metric.getRequestBytes().get());
        message.setResponseBytes(metric.getResponseBytes().get());
        message.setFlowedCount(metric.getFlowedCount().get());
        message.setDegradedCount(metric.getDegradedCount().get());
        return message;
    }

    @Override
    public Object from(long timestamp, int interval, JvmMetricSet metric) {
        JvmMetricMessage message = new JvmMetricMessage();
        message.setInterval(interval);
        message.setTimestamp(timestamp);

        message.instanceStartTime = metric.startTime;
        message.instanceUpTime = metric.upTime;

        message.processors = metric.cpuMetricSet.processorNumber;
        message.processCpuLoad = metric.cpuMetricSet.processCpuLoad;
        message.processCpuTime = metric.cpuMetricSet.processCpuTime;
        message.systemLoadAvg = metric.cpuMetricSet.avgSystemLoad;

        message.totalMemBytes = metric.memoryMetricSet.allocatedBytes;
        message.freeMemBytes = metric.memoryMetricSet.freeBytes;

        message.heapMax = metric.heapMetricSet.max;
        message.heapInit = metric.heapMetricSet.init;
        message.heapCommitted = metric.heapMetricSet.committed;
        message.heapUsed = metric.heapMetricSet.used;

        message.nonHeapMax = metric.nonHeapMetricSet.max;
        message.nonHeapInit = metric.nonHeapMetricSet.init;
        message.nonHeapCommitted = metric.nonHeapMetricSet.committed;
        message.nonHeapUsed = metric.nonHeapMetricSet.used;

        message.peakThreads = metric.threadMetricSet.peakActiveCount;
        message.activeThreads = metric.threadMetricSet.activeThreadsCount;
        message.daemonThreads = metric.threadMetricSet.activeDaemonCount;
        message.totalThreads = metric.threadMetricSet.totalCreatedCount;

        message.classLoaded = metric.classMetricSet.currentLoadedClasses;
        message.classUnloaded = metric.classMetricSet.totalUnloadedClasses;

        message.metaspaceCommitted = metric.metaspaceMetricSet.committed;
        message.metaspaceUsed = metric.metaspaceMetricSet.used;
        message.metaspaceInit = metric.metaspaceMetricSet.init;
        message.metaspaceMax = metric.metaspaceMetricSet.max;

        message.directMax = metric.directMemMetricSet.max;
        message.directUsed = metric.directMemMetricSet.used;
        return message;
    }

    @Override
    public Object from(long timestamp,
                       int interval,
                       WebServerMetricSet metric) {
        WebServerMetricMessage message = new WebServerMetricMessage();
        message.setInterval(interval);
        message.setTimestamp(timestamp);
        message.setConnectionCount(metric.getConnectionCount());
        message.setMaxConnections(metric.getMaxConnections());
        message.setActiveThreads(metric.getActiveThreads());
        message.setMaxThreads(metric.getMaxThreads());
        message.setType(metric.getServerType().type());
        return message;
    }

    @Override
    public Object from(long timestamp, int interval, SqlStatementCompositeMetric counter) {
        return null;
    }

    @Override
    public Object from(long timestamp,
                       int interval,
                       List<String> dimensions,
                       RedisClientCompositeMetric metric) {
        RedisMetricMessage message = new RedisMetricMessage();
        message.setInterval(interval);
        message.setTimestamp(timestamp);
        message.setUri(dimensions.get(0));
        message.setCommand(dimensions.get(1));
        message.setExceptionCount(metric.getExceptionCount());
        message.setTotalCount(metric.getCallCount());
        message.setRequestTime(metric.getRequestTime().getSum().get());
        message.setResponseTime(metric.getResponseTime().getSum().get());
        message.setRequestBytes(metric.getRequestBytes());
        message.setResponseBytes(metric.getResponseBytes());
        return message;
    }

    @Override
    public Object from(long timestamp,
                       int interval,
                       ExceptionMetricSet metric) {
        ExceptionMetricMessage message = new ExceptionMetricMessage();
        message.setInterval(interval);
        message.setTimestamp(timestamp);
        message.setUri(metric.getUri());
        message.setMessage(metric.getMessage());
        message.setClassName(metric.getExceptionClass());
        message.setStackTrace(metric.getStackTrace());
        message.setExceptionCount(metric.getCount());
        return message;
    }

    @Override
    public Object from(ITraceSpan span) {
        TraceSpanMessage spanMessage = new TraceSpanMessage();
        spanMessage.setTraceId(span.traceId());
        spanMessage.setSpanId(span.spanId());
        spanMessage.setParentSpanId(span.parentSpanId());
        spanMessage.setStartTime(span.startTime());
        spanMessage.setEndTime(span.endTime());
        spanMessage.setKind(span.kind().toString());
        spanMessage.setName(span.component());
        spanMessage.setClazz(span.clazz());
        spanMessage.setMethod(span.method());
        spanMessage.setTags(span.tags());
        spanMessage.setParentAppName(span.parentApplication());
        return spanMessage;
    }

    @Override
    public Object from(EventMessage event) {
        ThriftEventMessage message = new ThriftEventMessage();
        message.setTimestamp(System.currentTimeMillis());
        message.setEventType(event.getMessageType());
        message.setArguments(event.getArgs());
        return message;
    }

    @Override
    public Object from(Map<String, String> log) {
        return null;
    }

    @Override
    public Object from(long timestamp, int interval, GcCompositeMetric metrics) {
        JvmGcMetricMessage message = new JvmGcMetricMessage();
        message.setInterval(interval);
        message.setTimestamp(timestamp);
        message.setInterval(interval);
        message.setTimestamp(timestamp);
        message.setGcName(metrics.getGcName());
        message.setGeneration(metrics.getGeneration());
        message.setGcCount(metrics.getGcCount());
        message.setGcTime(metrics.getGcTime());
        return message;
    }

    @Override
    public Object from(long timestamp,
                       int interval,
                       ThreadPoolCompositeMetric metric) {
        ThreadPoolMetricMessage message = new ThreadPoolMetricMessage();
        message.setInterval(interval);
        message.setTimestamp(timestamp);
        message.setExecutorClass(metric.getExecutorClass());
        message.setPoolName(metric.getThreadPoolName());

        message.setActiveThreads(metric.getActiveThreads());
        message.setCurrentPoolSize(metric.getCurrentPoolSize());
        message.setMaxPoolSize(metric.getMaxPoolSize());
        message.setLargestPoolSize(metric.getLargestPoolSize());
        message.setQueuedTaskCount(metric.getQueuedTaskCount());
        message.setCallerRunTaskCount(metric.getCallerRunTaskCount());
        message.setAbortedTaskCount(metric.getAbortedTaskCount());
        message.setDiscardedTaskCount(metric.getDiscardedTaskCount());
        message.setDiscardedOldestTaskCount(metric.getDiscardedOldestTaskCount());
        message.setExceptionTaskCount(metric.getExceptionTaskCount());
        message.setSuccessfulTaskCount(metric.getSuccessfulTaskCount());
        message.setTotalTaskCount(metric.getTotalTaskCount());

        return message;
    }
}

