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

package org.bithon.agent.observability.tracing.context;

/**
 * @author frank.chen021@outlook.com
 * @date 2021/4/7 8:44 下午
 */
public class TraceSpanFactory {

    /**
     * Create a span based on current span on current thread
     */
    public static ITraceSpan newSpan(String name) {
        ITraceContext traceContext = TraceContextHolder.current();
        if (traceContext == null || traceContext.traceMode().equals(TraceMode.LOGGING)) {
            return null;
        }

        ITraceSpan parentSpan = traceContext.currentSpan();
        if (parentSpan == null) {
            return null;
        }

        // create a span and save it in user-context
        return parentSpan.newChildSpan(name);
    }

    /**
     * This method copies the current trace context so that it can be used in another thread.
     * Even current trace mode is {@link TraceMode#LOGGING}, it's still copied.
     *
     */
    public static ITraceSpan newAsyncSpan(String name) {
        ITraceContext traceContext = TraceContextHolder.current();
        if (traceContext == null) {
            return null;
        }

        ITraceSpan parentSpan = traceContext.currentSpan();
        if (parentSpan == null) {
            return null;
        }

        return traceContext.copy()
                           .reporter(traceContext.reporter())
                           .newSpan(parentSpan.spanId(), traceContext.spanIdGenerator().newSpanId())
                           .component(name);

    }
}
