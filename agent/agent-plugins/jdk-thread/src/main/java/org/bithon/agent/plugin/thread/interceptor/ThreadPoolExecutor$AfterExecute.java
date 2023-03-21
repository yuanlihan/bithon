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

package org.bithon.agent.plugin.thread.interceptor;

import org.bithon.agent.instrumentation.aop.context.AopContext;
import org.bithon.agent.instrumentation.aop.interceptor.AfterInterceptor;
import org.bithon.agent.plugin.thread.metrics.ThreadPoolMetricRegistry;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author frank.chen021@outlook.com
 * @date 2021/2/25 9:08 下午
 */
public class ThreadPoolExecutor$AfterExecute extends AfterInterceptor {

    @Override
    public void after(AopContext aopContext) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) aopContext.getTarget();
        Throwable exception = (Throwable) aopContext.getArgs()[1];
        ThreadPoolMetricRegistry.getInstance().addRunCount(executor, exception != null);
    }
}
