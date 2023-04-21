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

package org.bithon.agent.plugin.jetty.interceptor;

import org.bithon.agent.instrumentation.aop.context.AopContext;
import org.bithon.agent.instrumentation.aop.interceptor.declaration.BeforeInterceptor;
import org.bithon.agent.observability.event.ExceptionCollector;

/**
 * @author Frank Chen
 * @date 27/12/22 2:11 pm
 */
public class HttpChannel$HandleException extends BeforeInterceptor {

    @Override
    public void before(AopContext context) {
        Throwable exception = context.getArgAs(0);
        if (exception == null) {
            return;
        }

        ExceptionCollector.collect(exception);
    }
}
