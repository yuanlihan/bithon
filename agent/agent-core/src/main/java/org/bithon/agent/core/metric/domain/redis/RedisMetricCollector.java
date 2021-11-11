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

package org.bithon.agent.core.metric.domain.redis;

import org.bithon.agent.core.dispatcher.IMessageConverter;
import org.bithon.agent.core.metric.collector.IntervalMetricCollector;

import java.util.List;

/**
 * @author frankchen
 */
public class RedisMetricCollector extends IntervalMetricCollector<RedisClientMetrics> {

    public void addWrite(String endpoint,
                         String command,
                         long responseTime,
                         boolean hasException) {
        int exceptionCount = hasException ? 1 : 0;

        getOrCreateMetrics(endpoint, command).addRequest(responseTime, exceptionCount);
    }

    public void addRead(String endpoint,
                        String command,
                        long responseTime,
                        boolean hasException) {
        int exceptionCount = hasException ? 1 : 0;

        getOrCreateMetrics(endpoint, command).addResponse(responseTime, exceptionCount);
    }

    public void addOutputBytes(String endpoint,
                               String command,
                               int bytesOut) {
        getOrCreateMetrics(endpoint, command).addRequestBytes(bytesOut);
    }

    public void addInputBytes(String endpoint,
                              String command,
                              int bytesIn) {
        getOrCreateMetrics(endpoint, command).addResponseBytes(bytesIn);
    }

    @Override
    protected RedisClientMetrics newMetrics() {
        return new RedisClientMetrics();
    }

    @Override
    protected Object toMessage(IMessageConverter messageConverter,
                               int interval,
                               long timestamp,
                               List<String> dimensions,
                               RedisClientMetrics metric) {
        return messageConverter.from(timestamp, interval, dimensions, metric);
    }
}
