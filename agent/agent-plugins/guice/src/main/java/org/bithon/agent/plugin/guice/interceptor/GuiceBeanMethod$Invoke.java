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

package org.bithon.agent.plugin.guice.interceptor;

import org.bithon.agent.instrumentation.aop.context.AopContext;
import org.bithon.agent.instrumentation.aop.interceptor.InterceptionDecision;
import org.bithon.agent.instrumentation.aop.interceptor.declaration.AroundInterceptor;
import org.bithon.agent.observability.tracing.context.ITraceSpan;
import org.bithon.agent.observability.tracing.context.TraceSpanFactory;

/**
 *
 *
 * @author frank.chen021@outlook.com
 * @date 2021/7/10 18:46
 */
public class GuiceBeanMethod$Invoke extends AroundInterceptor {

    @Override
    public InterceptionDecision before(AopContext aopContext) {
        ITraceSpan span = TraceSpanFactory.newSpan("guice-bean");
        if (span == null) {
            return InterceptionDecision.SKIP_LEAVE;
        }

        aopContext.setUserContext(span.method(aopContext.getTargetClass(), aopContext.getMethod())
                                      .start());

        return InterceptionDecision.CONTINUE;
    }

    @Override
    public void after(AopContext aopContext) {
        ITraceSpan span = aopContext.getUserContextAs();
        span.tag(aopContext.getException()).finish();
    }
}
