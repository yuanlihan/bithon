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

package org.bithon.agent.plugin.jedis.interceptor;

import org.bithon.agent.instrumentation.aop.context.AopContext;
import org.bithon.agent.instrumentation.aop.interceptor.InterceptionDecision;
import org.bithon.agent.instrumentation.aop.interceptor.declaration.AroundInterceptor;
import org.bithon.agent.observability.tracing.context.ITraceSpan;
import org.bithon.agent.observability.tracing.context.TraceSpanFactory;
import org.bithon.component.commons.tracing.SpanKind;
import org.bithon.component.commons.tracing.Tags;
import redis.clients.jedis.Client;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author frankchen
 */
public class JedisClientTraceHandler extends AroundInterceptor {
    //TODO: move the configuration
    private final Set<String> ignoreCommands = new HashSet<>(Arrays.asList(
        "AUTH",
        "Protocol.Command.SELECT",
        "Protocol.Command.ECHO",
        "Protocol.Command.QUIT"
    ));

    @Override
    public InterceptionDecision before(AopContext aopContext) {
        String command = aopContext.getArgs()[0].toString();
        if (ignoreCommand(command)) {
            return InterceptionDecision.SKIP_LEAVE;
        }

        ITraceSpan span = TraceSpanFactory.newSpan("jedis");
        if (span == null) {
            return InterceptionDecision.SKIP_LEAVE;
        }

        Client redisClient = aopContext.getTargetAs();
        String uri = "redis://" + redisClient.getHost() + ":" + redisClient.getPort();

        aopContext.setUserContext(span.method(aopContext.getTargetClass().getName(), command)
                                      .kind(SpanKind.CLIENT)
                                      .tag(Tags.REMOTE_TARGET, uri)
                                      .start());

        return InterceptionDecision.CONTINUE;
    }

    @Override
    public void after(AopContext aopContext) {
        ITraceSpan span = aopContext.getUserContextAs();
        span.finish();
    }

    private boolean ignoreCommand(String command) {
        return this.ignoreCommands.contains(command);
    }
}
