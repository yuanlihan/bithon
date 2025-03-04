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

package org.bithon.agent.plugin.apache.kafka.consumer.interceptor;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.bithon.agent.instrumentation.aop.IBithonObject;
import org.bithon.agent.instrumentation.aop.context.AopContext;
import org.bithon.agent.instrumentation.aop.interceptor.declaration.AfterInterceptor;
import org.bithon.agent.plugin.apache.kafka.KafkaPluginContext;
import org.bithon.component.commons.utils.ReflectionUtils;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.support.TopicPartitionOffset;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * {@link org.springframework.kafka.listener.KafkaMessageListenerContainer$ListenerConsumer}
 *
 * @author Frank Chen
 * @date 28/11/22 8:47 pm
 */
public class ListenerConsumer$Ctor extends AfterInterceptor {

    /**
     * Keep topic information on injected fields for further use
     */
    @Override
    public void after(AopContext aopContext) {
        KafkaConsumer<?, ?> consumer = (KafkaConsumer<?, ?>) ReflectionUtils.getFieldValue(aopContext.getTarget(),
                                                                                           "consumer");
        if (consumer == null) {
            return;
        }

        ContainerProperties properties = (ContainerProperties) ReflectionUtils.getFieldValue(aopContext.getTarget(),
                                                                                             "containerProperties");
        if (properties == null) {
            return;
        }

        KafkaPluginContext pluginContext = ((KafkaPluginContext) ((IBithonObject) consumer).getInjectedObject());
        {
            String topicString = null;
            String[] topics = properties.getTopics();
            if (topics != null) {
                topicString = String.join(",", topics);
            } else if (properties.getTopicPattern() != null) {
                topicString = properties.getTopicPattern().pattern();
            } else {
                TopicPartitionOffset[] partitions = properties.getTopicPartitions();
                if (partitions != null) {
                    topicString = Stream.of(partitions)
                                        .map(TopicPartitionOffset::getTopic)
                                        .collect(Collectors.joining(","));
                }
            }
            String cluster = pluginContext.clusterSupplier.get();
            pluginContext.uri = "kafka://" + cluster + (topicString == null ? "" : "?topic=" + topicString);
            pluginContext.topic = topicString;
        }

        // Keep the uri for further use
        IBithonObject bithonObject = aopContext.getTargetAs();
        bithonObject.setInjectedObject(pluginContext);
    }
}
