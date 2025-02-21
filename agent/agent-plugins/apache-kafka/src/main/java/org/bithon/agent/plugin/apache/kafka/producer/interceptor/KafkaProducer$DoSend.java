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

package org.bithon.agent.plugin.apache.kafka.producer.interceptor;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.Header;
import org.bithon.agent.configuration.ConfigurationManager;
import org.bithon.agent.instrumentation.aop.IBithonObject;
import org.bithon.agent.instrumentation.aop.context.AopContext;
import org.bithon.agent.instrumentation.aop.interceptor.InterceptionDecision;
import org.bithon.agent.instrumentation.aop.interceptor.declaration.AroundInterceptor;
import org.bithon.agent.observability.tracing.context.ITraceSpan;
import org.bithon.agent.observability.tracing.context.TraceSpanFactory;
import org.bithon.agent.plugin.apache.kafka.KafkaPluginContext;
import org.bithon.agent.plugin.apache.kafka.producer.KafkaProducerTracingConfig;
import org.bithon.component.commons.tracing.Components;
import org.bithon.component.commons.tracing.SpanKind;
import org.bithon.component.commons.tracing.Tags;
import org.bithon.component.commons.utils.ReflectionUtils;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

/**
 * {@link org.apache.kafka.clients.producer.KafkaProducer#send(ProducerRecord)}
 * @author Frank Chen
 * @date 18/11/22 10:33 am
 */
public class KafkaProducer$DoSend extends AroundInterceptor {

    private final KafkaProducerTracingConfig tracingConfig = ConfigurationManager.getInstance()
                                                                                 .getConfig(KafkaProducerTracingConfig.class);

    @Override
    public InterceptionDecision before(AopContext aopContext) {
        ITraceSpan span = TraceSpanFactory.newSpan(Components.KAFKA);
        if (span == null) {
            return InterceptionDecision.SKIP_LEAVE;
        }

        ProducerRecord<?, ?> record = aopContext.getArgAs(0);

        // record headers
        for (String key : tracingConfig.getHeaders()) {
            Header header = record.headers().lastHeader(key);
            if (header != null) {
                span.tag(Tags.Messaging.KAFKA_HEADER_PREFIX + key, new String(header.value(), StandardCharsets.UTF_8));
            }
        }

        // message size
        Integer size = null;
        if (record.value() instanceof String) {
            size = ((String) record.value()).length();
        } else if (record.value() instanceof byte[]) {
            size = ((byte[]) record.value()).length;
        } else if (record.value() instanceof ByteBuffer) {
            size = ((ByteBuffer) record.value()).remaining();
        }

        IBithonObject bithonObject = aopContext.getTargetAs();
        KafkaPluginContext pluginContext = (KafkaPluginContext) bithonObject.getInjectedObject();

        aopContext.setUserContext(span.method(aopContext.getTargetClass(), aopContext.getMethod())
                                      .kind(SpanKind.PRODUCER)
                                      .tag(Tags.Net.PEER, pluginContext.clusterSupplier.get())
                                      .tag(Tags.Messaging.KAFKA_CLIENT_ID, pluginContext.clientId)
                                      .tag(Tags.Messaging.KAFKA_TOPIC, record.topic())
                                      .tag(Tags.Messaging.KAFKA_SOURCE_PARTITION, record.partition())
                                      .tag(Tags.Messaging.BYTES, size)
                                      .start());

        return InterceptionDecision.CONTINUE;
    }

    @Override
    public void after(AopContext aopContext) {
        ITraceSpan span = aopContext.getUserContextAs();
        if (aopContext.hasException()) {
            span.tag(aopContext.getException());
        } else {
            Object returning = aopContext.getReturning();
            if (returning != null) {
                if ("org.apache.kafka.clients.producer.KafkaProducer$FutureFailure".equals(returning.getClass()
                                                                                                    .getName())) {
                    Exception exception = (Exception) ReflectionUtils.getFieldValue(returning, "exception");
                    if (exception != null) {
                        span.tag(exception.getCause());
                    }
                }
            }
        }
        span.finish();
    }
}
