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

package com.sbss.bithon.agent.core.tracing.propagation.extractor;

import com.sbss.bithon.agent.core.tracing.Tracer;
import com.sbss.bithon.agent.core.tracing.context.TraceContext;
import com.sbss.bithon.agent.core.tracing.propagation.ITracePropagator;

/**
 * @author frank.chen021@outlook.com
 * @date 2021/2/6 10:00 上午
 */
public class BithonExtractor implements ITraceContextExtractor {

    @Override
    public <R> TraceContext extract(R request, PropagationGetter<R> getter) {
        if (request == null) {
            return null;
        }

        String traceId = getter.get(request, ITracePropagator.BITHON_TRACE_ID);
        if (traceId == null) {
            return null;
        }

        String spanIds = getter.get(request, ITracePropagator.BITHON_SPAN_IDS);
        if (spanIds == null) {
            return null;
        }

        String[] ids = spanIds.split(ITracePropagator.BITHON_ID_SEPARATOR);
        if (ids.length != 2) {
            return null;
        }

        TraceContext context = new TraceContext(traceId,
                                                ids[0],
                                                ids[1],
                                                Tracer.get().reporter(),
                                                Tracer.get().traceIdGenerator());
        context.currentSpan()
               .parentApplication(getter.get(request, ITracePropagator.BITHON_SOURCE_APPLICATION));
        return context;
    }
}
