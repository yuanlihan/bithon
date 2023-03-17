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

import org.bithon.agent.bootstrap.aop.AbstractInterceptor;
import org.bithon.agent.bootstrap.aop.AopContext;
import org.bithon.agent.bootstrap.aop.IBithonObject;
import org.bithon.agent.bootstrap.aop.InterceptionDecision;
import org.bithon.agent.core.config.ConfigurationManager;
import org.bithon.agent.core.context.InterceptorContext;
import org.bithon.agent.core.metric.domain.web.HttpIncomingFilter;
import org.bithon.agent.core.tracing.Tracer;
import org.bithon.agent.core.tracing.config.TraceConfig;
import org.bithon.agent.core.tracing.context.ITraceContext;
import org.bithon.agent.core.tracing.context.TraceContextHolder;
import org.bithon.agent.core.tracing.context.propagation.TraceMode;
import org.bithon.agent.plugin.jetty.context.RequestContext;
import org.bithon.component.commons.tracing.SpanKind;
import org.bithon.component.commons.tracing.Tags;
import org.bithon.component.commons.utils.StringUtils;
import org.eclipse.jetty.server.HttpChannel;
import org.eclipse.jetty.server.HttpChannelState;
import org.eclipse.jetty.server.Request;

/**
 * {@link org.eclipse.jetty.server.HttpChannel#handle()}
 *
 * @author frankchen
 */
public class HttpChannel$Handle extends AbstractInterceptor {
    private HttpIncomingFilter requestFilter;
    private TraceConfig traceConfig;

    @Override
    public boolean initialize() {
        requestFilter = new HttpIncomingFilter();
        traceConfig = ConfigurationManager.getInstance().getConfig(TraceConfig.class);
        return true;
    }

    @Override
    public InterceptionDecision onMethodEnter(AopContext aopContext) {
        TraceContextHolder.remove();
        InterceptorContext.remove(InterceptorContext.KEY_TRACEID);

        HttpChannel httpChannel = aopContext.getTargetAs();

        Request request = httpChannel.getRequest();

        if (httpChannel.getState().getState() == HttpChannelState.State.IDLE) {
            boolean filtered = this.requestFilter.shouldBeExcluded(request.getRequestURI(), request.getHeader("User-Agent"));
            if (filtered) {
                return InterceptionDecision.SKIP_LEAVE;
            }

            ITraceContext traceContext = Tracer.get().propagator().extract(request, Request::getHeader);
            if (traceContext != null) {
                TraceContextHolder.set(traceContext);
                InterceptorContext.set(InterceptorContext.KEY_TRACEID, traceContext.traceId());

                traceContext.currentSpan()
                            .component("jetty")
                            .tag("remote.address", request.getRemoteAddr())
                            .tag(Tags.HTTP_URI, request.getRequestURI())
                            .tag(Tags.HTTP_METHOD, request.getMethod())
                            .tag(Tags.HTTP_VERSION, request.getHttpVersion().toString())
                            .tag((span) -> traceConfig.getHeaders()
                                                      .getRequest()
                                                      .forEach((header) -> span.tag("http.header." + header, request.getHeader(header))))
                            .method(aopContext.getMethod())
                            .kind(SpanKind.SERVER)
                            .start();

                // put the trace id in the header so that the applications have chance to know whether this request is being sampled
                if (traceContext.traceMode().equals(TraceMode.TRACE)) {
                    request.setAttribute("X-Bithon-TraceId", traceContext.traceId());

                    String traceIdHeader = traceConfig.getTraceIdInResponse();
                    if (StringUtils.hasText(traceIdHeader)) {
                        httpChannel.getResponse().addHeader(traceIdHeader, traceContext.traceId());
                    }
                }
            }

            ((IBithonObject) request).setInjectedObject(new RequestContext(System.nanoTime(), traceContext));
        }

        InterceptorContext.set(InterceptorContext.KEY_URI, request.getRequestURI());

        RequestContext requestContext = (RequestContext) ((IBithonObject) request).getInjectedObject();
        if (requestContext != null) {
            ITraceContext traceContext = requestContext.getTraceContext();
            if (traceContext != null) {
                TraceContextHolder.set(traceContext);
                InterceptorContext.set(InterceptorContext.KEY_TRACEID, traceContext.traceId());
            }
        }

        return InterceptionDecision.CONTINUE;
    }

    @Override
    public void onMethodLeave(AopContext aopContext) {
        InterceptorContext.remove(InterceptorContext.KEY_URI);
        InterceptorContext.remove(InterceptorContext.KEY_TRACEID);
        TraceContextHolder.remove();
    }
}
