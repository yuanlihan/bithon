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

package org.bithon.agent.plugin.httpclient.jdk.interceptor;

import org.bithon.agent.bootstrap.aop.AbstractInterceptor;
import org.bithon.agent.bootstrap.aop.AopContext;
import org.bithon.agent.bootstrap.aop.IBithonObject;
import org.bithon.agent.bootstrap.aop.InterceptionDecision;
import org.bithon.agent.core.tracing.context.ITraceSpan;
import org.bithon.agent.core.tracing.context.TraceSpanFactory;
import org.bithon.component.commons.tracing.SpanKind;
import org.bithon.component.commons.tracing.Tags;
import sun.net.www.MessageHeader;

/**
 * Starts a trace span but do not finish it when the function completes.
 * Instead of, it will be closed in {@link HttpClient$ParseHTTP}
 *
 * @author frankchen
 */
public class HttpClient$WriteRequests extends AbstractInterceptor {

    @Override
    public InterceptionDecision onMethodEnter(AopContext aopContext) {
        IBithonObject injectedObject = aopContext.castTargetAs();
        HttpClientContext clientContext = (HttpClientContext) injectedObject.getInjectedObject();

        clientContext.setWriteAt(System.nanoTime());

        ITraceSpan span = TraceSpanFactory.newSpan("httpClient-jdk");
        if (span == null) {
            return InterceptionDecision.SKIP_LEAVE;
        }

        MessageHeader headers = (MessageHeader) aopContext.getArgs()[0];
        /*
         * starts a span which will be finished after HttpClient.parseHttp
         */
        span.method(aopContext.getMethod())
            .kind(SpanKind.CLIENT)
            .tag(Tags.HTTP_URI, clientContext.getUrl())
            .tag(Tags.HTTP_METHOD, clientContext.getMethod())
            .propagate(headers, (headersArgs, key, value) -> headersArgs.set(key, value))
            .start();

        return InterceptionDecision.CONTINUE;
    }
}
