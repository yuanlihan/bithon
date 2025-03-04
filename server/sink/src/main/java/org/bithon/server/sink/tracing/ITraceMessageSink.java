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

package org.bithon.server.sink.tracing;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.bithon.server.storage.tracing.TraceSpan;

import java.util.List;

/**
 * @author frank.chen021@outlook.com
 * @date 9/12/21 2:22 PM
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes(value = {
    @JsonSubTypes.Type(name = "local", value = LocalTraceSink.class),
})
public interface ITraceMessageSink extends AutoCloseable {
    /**
     * process messages.
     * If it's closing, this process method won't be called again
     */
    void process(String messageType, List<TraceSpan> messages);
}
