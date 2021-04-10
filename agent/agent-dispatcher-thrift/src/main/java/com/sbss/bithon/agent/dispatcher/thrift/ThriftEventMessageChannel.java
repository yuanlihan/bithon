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

package com.sbss.bithon.agent.dispatcher.thrift;

import com.sbss.bithon.agent.core.config.DispatcherConfig;
import com.sbss.bithon.agent.core.context.AgentContext;
import com.sbss.bithon.agent.core.context.AppInstance;
import com.sbss.bithon.agent.core.dispatcher.channel.IMessageChannel;
import com.sbss.bithon.agent.rpc.thrift.service.MessageHeader;
import com.sbss.bithon.agent.rpc.thrift.service.event.IEventCollector;
import com.sbss.bithon.agent.rpc.thrift.service.event.ThriftEventMessage;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TProtocol;

/**
 * @author frank.chen021@outlook.com
 * @date 2021/2/14 3:46 下午
 */
public class ThriftEventMessageChannel implements IMessageChannel {

    private static final int MAX_RETRY = 3;

    private final AbstractThriftClient<IEventCollector.Client> client;
    private final MessageHeader header;

    public ThriftEventMessageChannel(DispatcherConfig dispatcherConfig) {
        client = new AbstractThriftClient<IEventCollector.Client>("event",
                                                                  dispatcherConfig.getServers(),
                                                                  dispatcherConfig.getClient().getTimeout()) {
            @Override
            protected IEventCollector.Client createClient(TProtocol protocol) {
                return new IEventCollector.Client(protocol);
            }
        };

        AppInstance appInstance = AgentContext.getInstance().getAppInstance();
        this.header = new MessageHeader();
        this.header.setAppName(appInstance.getAppName());
        this.header.setEnv(appInstance.getEnv());
        this.header.setInstanceName(appInstance.getHostIp() + ":" + appInstance.getPort());
        this.header.setHostIp(appInstance.getHostIp());
        this.header.setPort(appInstance.getPort());
        appInstance.addListener(port -> {
            this.header.setPort(appInstance.getPort());
            this.header.setInstanceName(appInstance.getHostIp() + ":" + appInstance.getPort());
        });
    }

    @Override
    public void sendMessage(Object message) {
        client.ensureClient((client) -> {
            try {
                client.sendEvent(this.header, (ThriftEventMessage) message);
                return null;
            } catch (TException e) {
                throw new RuntimeException(e);
            }
        }, MAX_RETRY);
    }
}
