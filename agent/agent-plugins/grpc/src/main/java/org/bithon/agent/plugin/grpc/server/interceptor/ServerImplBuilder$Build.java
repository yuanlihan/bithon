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

package org.bithon.agent.plugin.grpc.server.interceptor;

import org.bithon.agent.configuration.ConfigurationManager;
import org.bithon.agent.instrumentation.aop.context.AopContext;
import org.bithon.agent.instrumentation.aop.interceptor.declaration.BeforeInterceptor;
import org.bithon.agent.instrumentation.bytecode.ClassCopier;
import org.bithon.agent.observability.tracing.config.TraceSamplingConfig;
import org.bithon.agent.observability.tracing.context.propagation.ChainedTraceContextExtractor;
import org.bithon.agent.observability.tracing.context.propagation.ITraceContextExtractor;
import org.bithon.agent.observability.tracing.sampler.SamplerFactory;
import org.bithon.agent.plugin.grpc.ShadedGrpcList;
import org.bithon.agent.plugin.grpc.client.interceptor.ManagedChannelImplBuilder$Build;
import org.bithon.component.commons.logging.LoggerFactory;
import org.bithon.component.commons.utils.StringUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Interceptor for {@link io.grpc.internal.ServerImplBuilder#build()}
 *
 * @author Frank Chen
 * @date 22/12/22 3:54 pm
 */
public class ServerImplBuilder$Build extends BeforeInterceptor {

    private final Map<String, String> shadedGrpcClassMap = new HashMap<>();
    private final List<String> shadedGrpcList;
    private final ChainedTraceContextExtractor contextExtractor;

    public ServerImplBuilder$Build() {
        shadedGrpcList = ConfigurationManager.getInstance().getConfig(ShadedGrpcList.class);
        contextExtractor = new ChainedTraceContextExtractor(SamplerFactory.createSampler(ConfigurationManager.getInstance()
                                                                                                             .getDynamicConfig("tracing.samplingConfigs.grpc",
                                                                                                                               TraceSamplingConfig.class)));
    }

    @Override
    public void before(AopContext aopContext) {
        String targetClazzName = aopContext.getTargetClass().getName();
        if (shadedGrpcList.isEmpty() || targetClazzName.startsWith("io.grpc.")) {
            // No shaded gRPC or current target is not a shaded one, then create a default interceptor
            // Note: use string name instead of class name because this class might be executed in a shaded grpc lib
            createInterceptor(aopContext, "org.bithon.agent.plugin.grpc.server.interceptor.ServerCallInterceptor");
            return;
        }

        String interceptor = shadedGrpcClassMap.get(targetClazzName);
        if (interceptor != null) {
            // Know the interceptor for this target, then create it by its name
            createInterceptor(aopContext, interceptor);
            return;
        }

        // Current target is a shaded gRPC, we need to create a ClientCallInterceptor class for this shaded gRPC
        synchronized (shadedGrpcClassMap) {
            // double check
            if (!shadedGrpcClassMap.containsKey(targetClazzName)) {

                //
                // First, find the shaded package name by current target class name
                //
                // io.grpc.internal.ServerImplBuilder
                // ab.cd.ef.internal.ServerImplBuilder
                String[] parts = targetClazzName.split("\\.");
                int i = parts.length - 1 - 1;
                for (; i >= 0; i--) {
                    if ("internal".equals(parts[i])) {
                        break;
                    }
                }
                StringBuilder shadedPackage = new StringBuilder(32);
                for (int j = 0; j < i; j++) {
                    if (shadedPackage.length() > 0) {
                        shadedPackage.append('.');
                    }
                    shadedPackage.append(parts[j]);
                }

                String currentPackage = ServerImplBuilder$Build.class.getPackage().getName();
                String serverInterceptor = currentPackage + "." + shadedPackage + ".ShadedServerCallInterceptor";
                try {
                    new ClassCopier()
                        .changePackage("io.grpc", shadedPackage.toString())
                        .copyClass(currentPackage + ".ServerCallInterceptor$TracedServerCallListener",
                                   currentPackage + "." + shadedPackage + ".ShadedTracedServerCallListener")
                        .copyClass(currentPackage + ".ServerCallInterceptor$TracedServerCall", currentPackage + "." + shadedPackage + ".ShadedTracedServerCall")
                        .copyClass(currentPackage + ".ServerCallInterceptor", serverInterceptor)
                        .to(this.getClass().getClassLoader());

                    // Save for future use
                    shadedGrpcClassMap.put(targetClazzName, serverInterceptor);
                } catch (IOException e) {
                    LoggerFactory.getLogger(ManagedChannelImplBuilder$Build.class)
                                 .error("Error when creating class [{}], error: {}", serverInterceptor, e.getMessage());
                }
            }
        }

        createInterceptor(aopContext, shadedGrpcClassMap.get(targetClazzName));
    }

    private void createInterceptor(AopContext aopContext, String interceptorClassName) {
        try {
            Object builder = aopContext.getTarget();

            // Create server call interceptor object
            Class<?> interceptorClazz = Class.forName(interceptorClassName, true, this.getClass().getClassLoader());
            Object interceptor = interceptorClazz.getConstructor(ITraceContextExtractor.class).newInstance(contextExtractor);

            // Hook the interceptor
            Optional<Method> interceptMethod = Stream.of(builder.getClass().getDeclaredMethods())
                                                     .filter(m -> "intercept".equals(m.getName())
                                                                  && m.getParameterCount() == 1
                                                                  && "ServerInterceptor".equals(m.getParameters()[0].getType().getSimpleName()))
                                                     .findFirst();
            if (interceptMethod.isPresent()) {
                interceptMethod.get().invoke(builder, interceptor);
            } else {
                throw new RuntimeException(StringUtils.format("No intercept method found on [%s]", aopContext.getTargetClass().getName()));
            }
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e.getCause());
        }
    }
}
