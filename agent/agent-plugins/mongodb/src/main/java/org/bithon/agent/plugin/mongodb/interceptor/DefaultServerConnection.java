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

package org.bithon.agent.plugin.mongodb.interceptor;

import com.mongodb.async.SingleResultCallback;
import com.mongodb.connection.Connection;
import org.bithon.agent.instrumentation.aop.IBithonObject;
import org.bithon.agent.instrumentation.aop.context.AopContext;
import org.bithon.agent.instrumentation.aop.interceptor.InterceptionDecision;
import org.bithon.agent.instrumentation.aop.interceptor.declaration.AroundInterceptor;
import org.bithon.agent.instrumentation.aop.interceptor.declaration.BeforeInterceptor;
import org.bithon.agent.observability.context.InterceptorContext;
import org.bithon.agent.observability.metric.domain.mongo.MongoCommand;
import org.bithon.agent.observability.metric.domain.mongo.MongoDbMetricRegistry;
import org.bithon.agent.observability.tracing.context.ITraceSpan;
import org.bithon.agent.observability.tracing.context.TraceSpanFactory;
import org.bithon.component.commons.logging.ILogAdaptor;
import org.bithon.component.commons.logging.LoggerFactory;
import org.bithon.component.commons.tracing.SpanKind;
import org.bithon.component.commons.tracing.Tags;

/**
 * @author frankchen
 * @date 2021-03-27 16:30
 */
public class DefaultServerConnection {
    static ILogAdaptor log = LoggerFactory.getLogger(DefaultServerConnection.class);

    /**
     * {@link com.mongodb.connection.DefaultServerConnection#executeProtocol(com.mongodb.connection.Protocol)}
     */
    public static class ExecuteProtocol extends AroundInterceptor {
        private final MongoDbMetricRegistry metricRegistry = MongoDbMetricRegistry.get();

        @Override
        public InterceptionDecision before(AopContext aopContext) {
            //
            // set command to thread context so that the size of sent/received could be associated with the command
            //
            Object protocol = aopContext.getArgs()[0];
            if ((protocol instanceof IBithonObject)) {
                IBithonObject bithonObject = (IBithonObject) protocol;
                MongoCommand command = (MongoCommand) bithonObject.getInjectedObject();

                InterceptorContext.set("mongo-3.x-command", command);
            } else {
                InterceptorContext.set("mongo-3.x-command", null);
            }

            // create a span and save it in user-context
            ITraceSpan span = TraceSpanFactory.newSpan("mongodb");
            if (span != null) {
                aopContext.setUserContext(span.method(aopContext.getTargetClass(), aopContext.getMethod())
                                              .kind(SpanKind.CLIENT)
                                              .start());
            }

            return InterceptionDecision.CONTINUE;
        }

        @Override
        public void after(AopContext aopContext) {
            Connection connection = aopContext.getTargetAs();
            String hostAndPort = connection.getDescription().getServerAddress().toString();

            MongoCommand command = null;
            Object protocol = aopContext.getArgs()[0];
            if ((protocol instanceof IBithonObject)) {
                IBithonObject bithonObject = (IBithonObject) protocol;
                command = (MongoCommand) bithonObject.getInjectedObject();
            } else {
                log.warn("No worry. This exception is printed only for problem addressing. No Real exception happens.",
                         new RuntimeException());
            }

            //
            // trace
            //
            ITraceSpan span = aopContext.getUserContextAs();
            if (span != null) {
                span.tag(aopContext.getException())
                    .tag(Tags.Net.PEER, hostAndPort)
                    .tag(Tags.Database.NAME, command == null ? null : command.getDatabase())
                    .finish();
            }

            //
            // metric
            //
            if (command != null) {
                int exceptionCount = aopContext.hasException() ? 0 : 1;
                metricRegistry.getOrCreateMetric(hostAndPort,
                                                 command.getDatabase(),
                                                 command.getCollection(),
                                                 command.getCommand())
                              .add(aopContext.getExecutionTime(), exceptionCount);
            }
        }
    }

    /**
     * {@link com.mongodb.connection.DefaultServerConnection#executeProtocolAsync(com.mongodb.connection.Protocol, SingleResultCallback)}
     */
    public static class ExecuteProtocolAsync extends BeforeInterceptor {
        private final MongoDbMetricRegistry metricRegistry = MongoDbMetricRegistry.get();

        /**
         * {@link com.mongodb.connection.DefaultServerConnection#executeProtocolAsync(com.mongodb.connection.Protocol, com.mongodb.async.SingleResultCallback)}
         */
        @Override
        public void before(AopContext aopContext) throws Exception {
            Object protocol = aopContext.getArgs()[0];
            if (!(protocol instanceof IBithonObject)) {
                log.warn("Unknown Command", new RuntimeException());
                return;
            }

            //TODO: wrap callback and exception callback
            /*
             * IBithonObject bithonObject = (IBithonObject) protocol;
             * MongoCommand command = (MongoCommand) bithonObject.getInjectedObject();
             * SingleResultCallback callback = (SingleResultCallback) aopContext.getArgs()[1];
             */
        }
    }
}
