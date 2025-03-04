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

package org.bithon.agent.plugin.apache.kafka.network.interceptor;

import org.apache.kafka.clients.ClientResponse;
import org.bithon.agent.instrumentation.aop.context.AopContext;
import org.bithon.agent.instrumentation.aop.interceptor.declaration.AfterInterceptor;
import org.bithon.agent.observability.metric.collector.MetricRegistryFactory;
import org.bithon.agent.plugin.apache.kafka.KafkaPluginContext;
import org.bithon.agent.plugin.apache.kafka.network.metrics.NetworkMetricRegistry;
import org.bithon.agent.plugin.apache.kafka.network.metrics.NetworkMetrics;

import java.util.List;

/**
 * @author frank.chen021@outlook.com
 * @date 2022/12/4 17:13
 */
public class NetworkClient$CompleteResponses extends AfterInterceptor {

    private final NetworkMetricRegistry metricRegistry;

    public NetworkClient$CompleteResponses() {
        metricRegistry = MetricRegistryFactory.getOrCreateRegistry("kafka-network",
                                                                   NetworkMetricRegistry::new);
    }

    @Override
    public void after(AopContext aopContext) throws Exception {
        KafkaPluginContext pluginContext = aopContext.getInjectedOnTargetAs();

        List<ClientResponse> responses = aopContext.getArgAs(0);
        for (ClientResponse response : responses) {

            String messageType = "";
            if (response.hasResponse()) {
                messageType = response.responseBody().getClass().getSimpleName();
                if (messageType.endsWith("Response")) {
                    messageType = messageType.substring(0, messageType.length() - "Response".length());
                }
            }

            String exceptionName = response.wasDisconnected() ? "Disconnected" : "";
            Exception exception = response.authenticationException();
            if (exception == null) {
                exception = response.versionMismatch();
            }
            if (exception != null) {
                exceptionName = exception.getClass().getSimpleName();
            }

            NetworkMetrics metrics = metricRegistry.getOrCreateMetrics(messageType,
                                                                       pluginContext.clusterSupplier.get(),
                                                                       response.destination(),
                                                                       pluginContext.groupId,
                                                                       pluginContext.clientId,
                                                                       exceptionName);

            long latency = response.requestLatencyMs();
            metrics.requestCount.update(1);
            metrics.minResponseTime.update(latency);
            metrics.responseTime.update(latency);
            metrics.maxResponseTime.update(latency);
        }
    }
}
