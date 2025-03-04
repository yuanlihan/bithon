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

package org.bithon.agent.plugin.thread;

import org.bithon.agent.instrumentation.aop.interceptor.descriptor.InterceptorDescriptor;
import org.bithon.agent.instrumentation.aop.interceptor.descriptor.MethodPointCutDescriptorBuilder;
import org.bithon.agent.instrumentation.aop.interceptor.plugin.IPlugin;

import java.util.Arrays;
import java.util.List;

import static org.bithon.agent.instrumentation.aop.interceptor.descriptor.InterceptorDescriptorBuilder.forClass;

/**
 * @author frankchen
 */
public class ThreadPlugin implements IPlugin {

    @Override
    public List<InterceptorDescriptor> getInterceptors() {
        return Arrays.asList(
            forClass("java.util.concurrent.ThreadPoolExecutor")
                .methods(
                    MethodPointCutDescriptorBuilder.build()
                                                   .onConstructor(
                                                       "int",
                                                       "int",
                                                       "long",
                                                       "java.util.concurrent.TimeUnit",
                                                       "java.util.concurrent.BlockingQueue<java.lang.Runnable>",
                                                       "java.util.concurrent.ThreadFactory",
                                                       "java.util.concurrent.RejectedExecutionHandler")
                                                   .to("org.bithon.agent.plugin.thread.interceptor.ThreadPoolExecutor$Ctor"),

                    MethodPointCutDescriptorBuilder.build()
                                                   .onMethodAndArgs("execute", "java.lang.Runnable")
                                                   .to("org.bithon.agent.plugin.thread.interceptor.ThreadPoolExecutor$Execute"),

                    MethodPointCutDescriptorBuilder.build()
                                                   .onAllMethods("shutdown")
                                                   .to("org.bithon.agent.plugin.thread.interceptor.ThreadPoolExecutor$Shutdown")
                ),

            forClass("java.util.concurrent.ForkJoinPool")
                .methods(
                    MethodPointCutDescriptorBuilder.build()
                                                   .onConstructor("int",
                                                                  "java.util.concurrent.ForkJoinPool$ForkJoinWorkerThreadFactory",
                                                                  "java.lang.Thread$UncaughtExceptionHandler",
                                                                  "int",
                                                                  "java.lang.String")
                                                   .to("org.bithon.agent.plugin.thread.interceptor.ForkJoinPool$Ctor"),

                    MethodPointCutDescriptorBuilder.build()
                                                   .onAllMethods("tryTerminate")
                                                   .to("org.bithon.agent.plugin.thread.interceptor.ForkJoinPool$TryTerminate"),

                    MethodPointCutDescriptorBuilder.build()
                                                   .onAllMethods("externalPush")
                                                   .to("org.bithon.agent.plugin.thread.interceptor.ForkJoinPool$ExternalPush")
                )
        );
    }
}


