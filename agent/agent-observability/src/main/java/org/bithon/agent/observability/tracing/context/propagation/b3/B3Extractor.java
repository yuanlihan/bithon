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

package org.bithon.agent.observability.tracing.context.propagation.b3;

import org.bithon.agent.observability.tracing.context.ITraceContext;
import org.bithon.agent.observability.tracing.context.TraceContextFactory;
import org.bithon.agent.observability.tracing.context.propagation.ITraceContextExtractor;
import org.bithon.agent.observability.tracing.context.propagation.PropagationGetter;
import org.bithon.agent.observability.tracing.sampler.SamplingMode;

/**
 * Transplanted from brave to support trace propagation from systems such as zipkin
 *
 * @author frank.chen021@outlook.com
 * @date 2021/2/6 9:38 上午
 */
public class B3Extractor implements ITraceContextExtractor {
    static final String SAMPLED = "X-B3-Sampled";
    /**
     * 128 or 64-bit trace ID lower-hex encoded into 32 or 16 characters (required)
     */
    static final String TRACE_ID = "X-B3-TraceId";
    /**
     * 64-bit span ID lower-hex encoded into 16 characters (required)
     */
    static final String SPAN_ID = "X-B3-SpanId";
    /**
     * 64-bit parent span ID lower-hex encoded into 16 characters (absent on root span)
     */
    static final String PARENT_SPAN_ID = "X-B3-ParentSpanId";

    @Override
    public <R> ITraceContext extract(R request, PropagationGetter<R> getter) {
        if (request == null) {
            return null;
        }

        String b3TraceId = getter.get(request, TRACE_ID);
        if (b3TraceId == null) {
            return null;
        }

        String spanId = getter.get(request, SPAN_ID);
        if (spanId == null) {
            return null;
        }

        String parentSpanId = getter.get(request, PARENT_SPAN_ID);
        if (parentSpanId == null) {
            return null;
        }

        return TraceContextFactory.create(SamplingMode.FULL,
                                          b3TraceId,
                                          parentSpanId,
                                          spanId);
    }
}
