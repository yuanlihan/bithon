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

package com.sbss.bithon.agent.plugin.mongodb;

import com.sbss.bithon.agent.core.plugin.AbstractPlugin;
import com.sbss.bithon.agent.core.plugin.descriptor.InterceptorDescriptor;
import com.sbss.bithon.agent.core.plugin.descriptor.MethodPointCutDescriptorBuilder;

import java.util.Arrays;
import java.util.List;

import static com.sbss.bithon.agent.core.plugin.descriptor.InterceptorDescriptorBuilder.forClass;

/**
 * @author frankchen
 */
public class MongoDbPlugin extends AbstractPlugin {

    @Override
    public List<InterceptorDescriptor> getInterceptors() {
        return Arrays.asList(
            /**
             * See CommandHelper$ExecuteCommand
             * Since this class is internal, and we need to call its method,
             * one way is to turn it into IBithonObject and cache the value we need in the injected object
             */
            forClass("com.mongodb.connection.InternalStreamConnection")
                .debug()
                .methods(
                    MethodPointCutDescriptorBuilder.build()
                                                   .onAllConstructor()
                                                   .to("com.sbss.bithon.agent.plugin.mongodb.interceptor.InternalStreamConnection$Constructor")),

            forClass("com.mongodb.connection.DefaultServerConnection")
                .methods(
                    MethodPointCutDescriptorBuilder.build()
                                                   .onMethodAndArgs("executeProtocol",
                                                                    "com.mongodb.connection.Protocol<T>")
                                                   .to("com.sbss.bithon.agent.plugin.mongodb.interceptor.DefaultServerConnection$ExecuteProtocol"),

                    MethodPointCutDescriptorBuilder.build()
                                                   .onMethodAndArgs("executeProtocolAsync",
                                                                    "com.mongodb.connection.Protocol<T>",
                                                                    "com.mongodb.async.SingleResultCallback<T>")
                                                   .to("com.sbss.bithon.agent.plugin.mongodb.interceptor.DefaultServerConnection$ExecuteProtocolAsync")
                ),

            forClass("com.mongodb.connection.CommandHelper")
                .debug()
                .methods(
                    MethodPointCutDescriptorBuilder.build()
                                                   .onAllMethods("executeCommand")
                                                   .to("com.sbss.bithon.agent.plugin.mongodb.interceptor.CommandHelper$ExecuteCommand"),

                    MethodPointCutDescriptorBuilder.build()
                                                   .onAllMethods("executeCommandAsync")
                                                   .to("com.sbss.bithon.agent.plugin.mongodb.interceptor.CommandHelper$ExecuteCommandAsync")
                ),


            forClass("com.mongodb.event.ConnectionMessagesSentEvent")
                .debug()
                .methods(
                    MethodPointCutDescriptorBuilder.build()
                                                   .onConstructor("com.mongodb.connection.ConnectionId",
                                                                  "int",
                                                                  "int")
                                                   .to("com.sbss.bithon.agent.plugin.mongodb.interceptor.ConnectionMessagesSentEvent$Constructor")
                ),

            forClass("com.mongodb.event.ConnectionMessageReceivedEvent")
                .debug()
                .methods(
                    MethodPointCutDescriptorBuilder.build()
                                                   .onConstructor("com.mongodb.connection.ConnectionId",
                                                                  "int",
                                                                  "int")
                                                   .to("com.sbss.bithon.agent.plugin.mongodb.interceptor.ConnectionMessageReceivedEvent$Constructor")
                ),

            forClass("com.mongodb.connection.CommandProtocol")
                .methods(
                    MethodPointCutDescriptorBuilder.build()
                                                   .onAllConstructor()
                                                   .to("com.sbss.bithon.agent.plugin.mongodb.interceptor.Protocol$CommandProtocol")
                ),

            forClass("com.mongodb.connection.DeleteCommandProtocol")
                .methods(
                    MethodPointCutDescriptorBuilder.build()
                                                   .onAllConstructor()
                                                   .to("com.sbss.bithon.agent.plugin.mongodb.interceptor.Protocol$DeleteCommandProtocol")
                ),

            forClass("com.mongodb.connection.DeleteProtocol")
                .methods(
                    MethodPointCutDescriptorBuilder.build()
                                                   .onAllConstructor()
                                                   .to("com.sbss.bithon.agent.plugin.mongodb.interceptor.Protocol$DeleteProtocol")
                ),

            forClass("com.mongodb.connection.GetMoreProtocol")
                .methods(
                    MethodPointCutDescriptorBuilder.build()
                                                   .onAllConstructor()
                                                   .to("com.sbss.bithon.agent.plugin.mongodb.interceptor.Protocol$GetMoreProtocol")
                ),

            forClass("com.mongodb.connection.InsertCommandProtocol")
                .methods(
                    MethodPointCutDescriptorBuilder.build()
                                                   .onAllConstructor()
                                                   .to("com.sbss.bithon.agent.plugin.mongodb.interceptor.Protocol$InsertCommandProtocol")
                ),

            forClass("com.mongodb.connection.InsertProtocol")
                .methods(
                    MethodPointCutDescriptorBuilder.build()
                                                   .onAllConstructor()
                                                   .to("com.sbss.bithon.agent.plugin.mongodb.interceptor.Protocol$InsertProtocol")
                ),

            forClass("com.mongodb.connection.KillCursorProtocol")
                .methods(
                    MethodPointCutDescriptorBuilder.build()
                                                   .onAllConstructor()
                                                   .to("com.sbss.bithon.agent.plugin.mongodb.interceptor.Protocol$KillCursorProtocol")
                ),

            forClass("com.mongodb.connection.QueryProtocol")
                .methods(
                    MethodPointCutDescriptorBuilder.build()
                                                   .onAllConstructor()
                                                   .to("com.sbss.bithon.agent.plugin.mongodb.interceptor.Protocol$QueryProtocol")
                ),

            forClass("com.mongodb.connection.UpdateCommandProtocol")
                .methods(
                    MethodPointCutDescriptorBuilder.build()
                                                   .onAllConstructor()
                                                   .to("com.sbss.bithon.agent.plugin.mongodb.interceptor.Protocol$UpdateCommandProtocol")
                ),

            forClass("com.mongodb.connection.UpdateProtocol")
                .methods(
                    MethodPointCutDescriptorBuilder.build()
                                                   .onAllConstructor()
                                                   .to("com.sbss.bithon.agent.plugin.mongodb.interceptor.Protocol$UpdateProtocol")
                )
        );
    }
}
