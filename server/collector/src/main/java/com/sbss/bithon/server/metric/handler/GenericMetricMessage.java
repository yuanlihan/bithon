package com.sbss.bithon.server.metric.handler;

import com.sbss.bithon.agent.rpc.thrift.service.MessageHeader;
import com.sbss.bithon.agent.rpc.thrift.service.metric.message.ExceptionMetricMessage;
import com.sbss.bithon.agent.rpc.thrift.service.metric.message.GcEntity;
import com.sbss.bithon.agent.rpc.thrift.service.metric.message.HttpClientMetricMessage;
import com.sbss.bithon.agent.rpc.thrift.service.metric.message.JdbcPoolMetricMessage;
import com.sbss.bithon.agent.rpc.thrift.service.metric.message.JvmMetricMessage;
import com.sbss.bithon.agent.rpc.thrift.service.metric.message.RedisMetricMessage;
import com.sbss.bithon.agent.rpc.thrift.service.metric.message.ThreadPoolMetricMessage;
import com.sbss.bithon.agent.rpc.thrift.service.metric.message.WebRequestMetricMessage;
import com.sbss.bithon.agent.rpc.thrift.service.metric.message.WebServerMetricMessage;
import com.sbss.bithon.server.common.utils.ReflectionUtils;

import java.util.HashMap;

/**
 * TODO: cache reflection results
 *
 * @author frank.chen021@outlook.com
 * @date 2021/3/15
 */
public class GenericMetricMessage extends HashMap<String, Object> {

    public static GenericMetricMessage of(MessageHeader header, WebRequestMetricMessage message) {
        GenericMetricMessage metricMessage = new GenericMetricMessage();
        ReflectionUtils.getFields(header, metricMessage);
        ReflectionUtils.getFields(message, metricMessage);
        return metricMessage;
    }

    public static GenericMetricMessage of(MessageHeader header, JvmMetricMessage message) {
        GenericMetricMessage metricMessage = new GenericMetricMessage();
        ReflectionUtils.getFields(header, metricMessage);
        ReflectionUtils.getFields(message.classesEntity, metricMessage);
        ReflectionUtils.getFields(message.cpuEntity, metricMessage);
        ReflectionUtils.getFields(message.heapEntity, metricMessage);
        ReflectionUtils.getFields(message.instanceTimeEntity, metricMessage);
        ReflectionUtils.getFields(message.memoryEntity, metricMessage);
        ReflectionUtils.getFields(message.nonHeapEntity, metricMessage);
        ReflectionUtils.getFields(message.metaspaceEntity, metricMessage);
        ReflectionUtils.getFields(message.threadEntity, metricMessage);

        metricMessage.put("interval", message.interval);
        metricMessage.put("timestamp", message.timestamp);
        return metricMessage;
    }

    public static GenericMetricMessage of(MessageHeader header, ExceptionMetricMessage message) {
        GenericMetricMessage metricMessage = new GenericMetricMessage();
        ReflectionUtils.getFields(header, metricMessage);
        ReflectionUtils.getFields(message, metricMessage);
        return metricMessage;
    }

    public static GenericMetricMessage of(MessageHeader header, HttpClientMetricMessage message) {
        GenericMetricMessage metricMessage = new GenericMetricMessage();
        ReflectionUtils.getFields(header, metricMessage);
        ReflectionUtils.getFields(message, metricMessage);
        return metricMessage;
    }

    public static GenericMetricMessage of(MessageHeader header, WebServerMetricMessage message) {
        GenericMetricMessage metricMessage = new GenericMetricMessage();
        ReflectionUtils.getFields(header, metricMessage);
        ReflectionUtils.getFields(message, metricMessage);
        return metricMessage;
    }

    public static GenericMetricMessage of(MessageHeader header, JdbcPoolMetricMessage message) {
        GenericMetricMessage metricMessage = new GenericMetricMessage();
        ReflectionUtils.getFields(header, metricMessage);
        ReflectionUtils.getFields(message, metricMessage);
        return metricMessage;
    }

    public static GenericMetricMessage of(MessageHeader header, RedisMetricMessage message) {
        GenericMetricMessage metricMessage = new GenericMetricMessage();
        ReflectionUtils.getFields(header, metricMessage);
        ReflectionUtils.getFields(message, metricMessage);
        return metricMessage;
    }

    public static GenericMetricMessage of(MessageHeader header, ThreadPoolMetricMessage message) {
        GenericMetricMessage metricMessage = new GenericMetricMessage();
        ReflectionUtils.getFields(header, metricMessage);
        ReflectionUtils.getFields(message, metricMessage);
        return metricMessage;
    }

    public static GenericMetricMessage of(MessageHeader header, GcEntity gc) {
        GenericMetricMessage metricMessage = new GenericMetricMessage();
        ReflectionUtils.getFields(header, metricMessage);
        ReflectionUtils.getFields(gc, metricMessage);
        return metricMessage;
    }

    public long getTimestamp() {
        return (long) this.get("timestamp");
    }

    public String getApplicationName() {
        return (String) this.get("appName");
    }

    public String getApplicationEnv() {
        return (String) this.get("env");
    }

    public String getInstanceName() {
        return (String) this.get("instanceName");
    }

    public long getLong(String prop) {
        return ((Number) this.getOrDefault(prop, 0L)).longValue();
    }

    public <T> T getAs(String prop) {
        return (T) this.get(prop);
    }

    public void set(String prop, Object value) {
        this.put(prop, value);
    }

    public String getString(String prop) {
        return (String) this.get(prop);
    }
}
