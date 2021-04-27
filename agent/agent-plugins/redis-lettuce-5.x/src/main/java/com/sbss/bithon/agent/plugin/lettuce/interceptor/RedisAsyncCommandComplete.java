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

package com.sbss.bithon.agent.plugin.lettuce.interceptor;

import com.sbss.bithon.agent.bootstrap.aop.AbstractInterceptor;
import com.sbss.bithon.agent.bootstrap.aop.AopContext;
import com.sbss.bithon.agent.bootstrap.aop.IBithonObject;
import com.sbss.bithon.agent.core.metric.collector.MetricCollectorManager;
import com.sbss.bithon.agent.core.metric.domain.redis.RedisMetricCollector;
import com.sbss.bithon.agent.plugin.lettuce.LettuceAsyncContext;
import io.lettuce.core.protocol.AsyncCommand;

/**
 * @author frankchen
 */
public class RedisAsyncCommandComplete extends AbstractInterceptor {

    private RedisMetricCollector metricProvider;

    @Override
    public boolean initialize() {
        metricProvider = MetricCollectorManager.getInstance().getOrRegister("lettuce", RedisMetricCollector.class);
        return true;
    }

    @Override
    public void onMethodLeave(AopContext aopContext) {
        if (!(aopContext.getTarget() instanceof IBithonObject)) {
            return;
        }

        LettuceAsyncContext asyncContext = (LettuceAsyncContext) ((IBithonObject) aopContext.getTarget()).getInjectedObject();

        if (asyncContext != null &&
            asyncContext.getEndpoint() != null &&
            asyncContext.getStartTime() != null) {
            AsyncCommand asyncCommand = (AsyncCommand) aopContext.getTarget();

            boolean fail = "cancel".equalsIgnoreCase(aopContext.getMethod().getName()) || asyncCommand.getOutput()
                                                                                                      .hasError();

            //TODO: read/write
            //TODO: bytes
            this.metricProvider.addWrite(asyncContext.getEndpoint(),
                                         asyncCommand.getType().name(),
                                         System.nanoTime() - (long) asyncContext.getStartTime(),
                                         fail);
        }
    }
}
