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

package org.bithon.server.collector.source.brpc;

import lombok.extern.slf4j.Slf4j;
import org.bithon.agent.rpc.brpc.BrpcMessageHeader;
import org.bithon.agent.rpc.brpc.event.BrpcEventMessage;
import org.bithon.agent.rpc.brpc.event.IEventCollector;
import org.bithon.component.commons.collection.IteratorableCollection;
import org.bithon.component.commons.utils.CollectionUtils;
import org.bithon.server.sink.event.IEventMessageSink;
import org.bithon.server.storage.event.EventMessage;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @author frank.chen021@outlook.com
 * @date 2021/2/14 3:59 下午
 */
@Slf4j
public class BrpcEventCollector implements IEventCollector, AutoCloseable {

    private final IEventMessageSink eventSink;

    public BrpcEventCollector(IEventMessageSink eventSink) {
        this.eventSink = eventSink;
    }

    @Override
    public void sendEvent(BrpcMessageHeader header, BrpcEventMessage message) {
        EventMessage eventMessage = EventMessage.builder()
                                                .appName(header.getAppName())
                                                .instanceName(header.getInstanceName())
                                                .timestamp(message.getTimestamp())
                                                .type(message.getEventType())
                                                .jsonArgs(message.getJsonArguments())
                                                .build();
        Iterator<EventMessage> delegate = Collections.singletonList(eventMessage).iterator();
        eventSink.process("event", IteratorableCollection.of(delegate));
    }

    @Override
    public void sendEvent2(BrpcMessageHeader header, List<BrpcEventMessage> messages) {
        if (CollectionUtils.isEmpty(messages)) {
            return;
        }
        Iterator<EventMessage> iterator = new Iterator<EventMessage>() {
            private final Iterator<BrpcEventMessage> delegation = messages.iterator();

            @Override
            public boolean hasNext() {
                return delegation.hasNext();
            }

            @Override
            public EventMessage next() {
                BrpcEventMessage message = delegation.next();
                return EventMessage.builder()
                                   .appName(header.getAppName())
                                   .instanceName(header.getInstanceName())
                                   .timestamp(message.getTimestamp())
                                   .type(message.getEventType())
                                   .jsonArgs(message.getJsonArguments())
                                   .build();
            }
        };
        eventSink.process("event", IteratorableCollection.of(iterator));
    }

    @Override
    public void close() throws Exception {
        eventSink.close();
    }
}
