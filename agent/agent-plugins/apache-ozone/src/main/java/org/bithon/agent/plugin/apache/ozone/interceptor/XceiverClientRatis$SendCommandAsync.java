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

package org.bithon.agent.plugin.apache.ozone.interceptor;

import org.apache.hadoop.hdds.protocol.DatanodeDetails;
import org.apache.hadoop.hdds.protocol.datanode.proto.ContainerProtos;
import org.bithon.agent.instrumentation.aop.IBithonObject;
import org.bithon.agent.instrumentation.aop.context.AopContext;
import org.bithon.agent.instrumentation.aop.interceptor.InterceptionDecision;
import org.bithon.agent.instrumentation.aop.interceptor.declaration.AroundInterceptor;
import org.bithon.agent.observability.tracing.context.ITraceSpan;
import org.bithon.agent.observability.tracing.context.TraceSpanFactory;

/**
 * {@link org.apache.hadoop.hdds.scm.XceiverClientRatis#sendCommandAsync(ContainerProtos.ContainerCommandRequestProto)}
 *
 * @author Frank Chen
 * @date 21/12/22 5:08 pm
 */
public class XceiverClientRatis$SendCommandAsync extends AroundInterceptor {

    @Override
    public InterceptionDecision before(AopContext aopContext) {
        ITraceSpan span = TraceSpanFactory.newSpan("ozone-hdds");
        if (span == null) {
            return InterceptionDecision.SKIP_LEAVE;
        }

        ContainerProtos.ContainerCommandRequestProto request = aopContext.getArgAs(0);

        // injected in Connect interceptor
        IBithonObject bithonObject = aopContext.getTargetAs();
        DatanodeDetails dn = (DatanodeDetails) bithonObject.getInjectedObject();

        aopContext.setUserContext(span.method(aopContext.getTargetClass(), aopContext.getMethod())
                                      .tag("request", request.getCmdType().name())
                                      .tag("datanode.host", dn == null ? null : dn.getHostName())
                                      .tag("datanode.ip", dn == null ? null : dn.getIpAddress())
                                      .start());

        return InterceptionDecision.CONTINUE;
    }

    @Override
    public void after(AopContext aopContext) {
        ITraceSpan span = aopContext.getUserContextAs();
        span.tag(aopContext.getException()).finish();
    }
}
