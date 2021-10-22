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

package org.bithon.agent.core.dispatcher;


import org.bithon.agent.core.context.AppInstance;
import org.bithon.agent.core.dispatcher.channel.IMessageChannel;
import org.bithon.agent.core.dispatcher.channel.IMessageChannelFactory;
import org.bithon.agent.core.dispatcher.config.DispatcherConfig;
import org.bithon.agent.core.dispatcher.task.BlockingQueue;
import org.bithon.agent.core.dispatcher.task.DispatchTask;
import org.bithon.agent.core.dispatcher.task.IMessageQueue;
import shaded.org.slf4j.Logger;
import shaded.org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * @author frankchen
 */
public class Dispatcher {
    private static final Logger log = LoggerFactory.getLogger(Dispatcher.class);

    private final String dispatcherName;
    private final IMessageConverter messageConverter;
    private final IMessageChannel dispatcher;
    private final DispatcherConfig dispatcherConfig;
    private int appPort;
    private DispatchTask task;

    Dispatcher(String dispatcherName,
               AppInstance appInstance,
               DispatcherConfig dispatcherConfig) throws Exception {
        this.dispatcherName = dispatcherName;
        this.dispatcherConfig = dispatcherConfig;

        //
        // create dispatcher instance by config
        //
        IMessageChannelFactory factory = createDispatcherFactory(dispatcherConfig);
        Method createMethod = IMessageChannelFactory.class.getMethod("create" + capitalize(dispatcherName) + "Channel",
                                                                     DispatcherConfig.class);
        this.dispatcher = (IMessageChannel) createMethod.invoke(factory, dispatcherConfig);
        this.messageConverter = factory.createMessageConverter();

        if (appInstance.getPort() == 0) {
            appInstance.addListener(this::startTask);
        }
        startTask(appInstance.getPort());
    }

    public boolean isReady() {
        return task != null;
    }

    public IMessageConverter getMessageConverter() {
        return this.messageConverter;
    }

    public void sendMessage(Object message) {
        if (task != null && message != null) {
            task.sendMessage(message);
        }
    }

    private String capitalize(String s) {
        if (Character.isLowerCase(s.charAt(0))) {
            return (char) (s.charAt(0) - 'a' + 'A') + s.substring(1);
        } else {
            return s;
        }
    }

    private IMessageChannelFactory createDispatcherFactory(DispatcherConfig config) throws Exception {
        return (IMessageChannelFactory) Class.forName(config.getClient().getFactory())
                                             .getDeclaredConstructor()
                                             .newInstance();
    }

    private synchronized void startTask(int port) {
        if (appPort != 0 || port == 0) {
            return;
        }
        this.appPort = port;

        log.info("Application port updated to {}, {} will soon be at work",
                 port,
                 this.dispatcherName);

        task = new DispatchTask(dispatcherName,
                                createQueue(),
                                dispatcherConfig,
                                dispatcher::sendMessage);
    }

    private IMessageQueue createQueue() {
        return new BlockingQueue();
        /*
            return new FileQueueImpl(agentPath
                                     + separator
                                     + AgentContext.TMP_DIR
                                     + separator
                                     + dispatcherName
                                     + separator
                                     + appName,
                                     String.valueOf(appPort));*/
    }
}
