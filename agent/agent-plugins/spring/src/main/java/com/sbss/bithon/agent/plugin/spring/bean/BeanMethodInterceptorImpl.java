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

package com.sbss.bithon.agent.plugin.spring.bean;

import com.sbss.bithon.agent.core.tracing.context.SpanKind;
import com.sbss.bithon.agent.core.tracing.context.TraceContext;
import com.sbss.bithon.agent.core.tracing.context.TraceContextHolder;
import com.sbss.bithon.agent.core.tracing.context.TraceSpan;

import java.lang.reflect.Method;

/**
 * NOTE:
 * Any update of class/package name of this class must be manually reflected to {@link BeanMethodInterceptorFactory#INTERCEPTOR_CLASS_NAME},
 * or the Bean interception WON'T WORK
 *
 * @author frank.chen021@outlook.com
 * @date 2021/7/10 18:46
 */
public class BeanMethodInterceptorImpl implements BeanMethodInterceptorIntf {

    @Override
    public Object onMethodEnter(
        final Method method,
        final Object target,
        final Object[] args
    ) {
        TraceContext traceContext = TraceContextHolder.get();
        if (traceContext == null) {
            return null;
        }
        TraceSpan span = traceContext.currentSpan();
        if (span == null) {
            return null;
        }

        return span.newChildSpan("springBean")
                   .kind(SpanKind.CLIENT)
                   .method(method)
                   .start();
    }

    @Override
    public void onMethodExit(final Method method,
                             final Object target,
                             final Object[] args,
                             final Throwable exception,
                             final Object context) {
        ((TraceSpan) context).tag(exception).finish();
    }
}
