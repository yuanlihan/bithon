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

package org.bithon.agent.plugin.mysql.trace;

import org.bithon.agent.instrumentation.aop.context.AopContext;
import org.bithon.agent.instrumentation.aop.interceptor.InterceptionDecision;
import org.bithon.agent.instrumentation.aop.interceptor.declaration.AroundInterceptor;
import org.bithon.agent.observability.context.InterceptorContext;
import org.bithon.agent.observability.tracing.context.ITraceSpan;
import org.bithon.agent.observability.tracing.context.TraceSpanFactory;
import org.bithon.component.commons.logging.ILogAdaptor;
import org.bithon.component.commons.logging.LoggerFactory;
import org.bithon.component.commons.tracing.SpanKind;
import org.bithon.component.commons.tracing.Tags;

/**
 * @author frankchen
 */
public class StatementTraceInterceptor extends AroundInterceptor {
    private static final ILogAdaptor log = LoggerFactory.getLogger(StatementTraceInterceptor.class);

    @Override
    public InterceptionDecision before(AopContext aopContext) {

        // TODO: filter "select @@session.tx_read_only"

        ITraceSpan span = TraceSpanFactory.newSpan("mysql");
        if (span == null) {
            return InterceptionDecision.SKIP_LEAVE;
        }

        aopContext.setUserContext(span.method(aopContext.getTargetClass(), aopContext.getMethod())
                                      .kind(SpanKind.CLIENT)
                                      //TODO: connection uri
                                      .start());

        return InterceptionDecision.CONTINUE;
    }

    @Override
    public void after(AopContext aopContext) {
        ITraceSpan span = aopContext.getUserContextAs();
        try {
            /*
            if (context.getArgs() != null && context.getArgs().length > 0 && needIgnore(context.getArgs()[0].toString())) {
                return;
            }*/

            String sql;
            if ((sql = (String) InterceptorContext.get(ConnectionTraceInterceptor.KEY)) != null) {
                span.tag(Tags.Database.STATEMENT, sql);
            }
        } finally {
            try {
                span.finish();
            } catch (Exception e) {
                log.warn(e.getMessage(), e);
            }

            InterceptorContext.remove(ConnectionTraceInterceptor.KEY);
        }
    }
}
