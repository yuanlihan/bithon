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

package org.bithon.agent.observability.tracing.context.propagation;

import org.bithon.agent.observability.tracing.Tracer;
import org.bithon.agent.observability.tracing.context.ITraceContext;
import org.bithon.agent.observability.tracing.context.TraceContextFactory;
import org.bithon.agent.observability.tracing.context.propagation.b3.B3Extractor;
import org.bithon.agent.observability.tracing.context.propagation.pinpoint.PinpointExtractor;
import org.bithon.agent.observability.tracing.context.propagation.w3c.W3CTraceContextExtractor;
import org.bithon.agent.observability.tracing.sampler.ISampler;

/**
 * @author frank.chen021@outlook.com
 * @date 2021/2/5 9:59 下午
 */
public class ChainedTraceContextExtractor implements ITraceContextExtractor {

    private final ITraceContextExtractor[] extractors = new ITraceContextExtractor[]{
            new B3Extractor(),
            new PinpointExtractor(),
            new W3CTraceContextExtractor(),
    };

    private final ISampler sampler;

    public ChainedTraceContextExtractor(ISampler sampler) {
        this.sampler = sampler;
    }

    @Override
    public <R> ITraceContext extract(R request, PropagationGetter<R> getter) {
        //
        // extract trace context based on upstream service request
        //
        for (ITraceContextExtractor extractor : extractors) {
            ITraceContext context = extractor.extract(request, getter);
            if (context != null) {
                return context;
            }
        }

        //
        // no trace context,
        // then handle to sampling decision maker to decide whether this request should be sampled
        //
        return TraceContextFactory.create(sampler.decideSamplingMode(request),
                                          Tracer.get().traceIdGenerator().newTraceId())
                                  .currentSpan()
                                  .parentApplication(getter.get(request, ITracePropagator.TRACE_HEADER_SRC_APPLICATION))
                                  .context();
    }
}
