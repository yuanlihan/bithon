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

package org.bithon.agent.plugin.jedis.interceptor;

import org.bithon.agent.observability.metric.domain.redis.RedisClientMetrics;

/**
 * @author frank.chen021@outlook.com
 * @date 22/1/22 6:02 PM
 */
public class JedisContext {

    private final RedisClientMetrics metrics;

    public JedisContext(RedisClientMetrics metrics) {
        this.metrics = metrics;
    }

    public RedisClientMetrics getMetrics() {
        return metrics;
    }
}
