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

package org.bithon.server.collector.sink;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.bithon.server.sink.metrics.IMetricMessageSink;

import java.io.IOException;
import java.util.Map;

/**
 * @author frank.chen021@outlook.com
 * @date 9/12/21 4:48 PM
 */
@Data
public class SinkConfig {
    private String type;
    private Map<String, Object> props;

    /**
     * Create instance of one of following by leveraging jackson JSON deserialization
     * {@link IMetricMessageSink}
     * {@link org.bithon.server.sink.event.IEventMessageSink}
     * {@link org.bithon.server.sink.tracing.ITraceMessageSink}
     */
    public <T> T createSink(ObjectMapper mapper, Class<T> clazz) throws IOException {
        String sinkConfig = mapper.writeValueAsString(this);
        return mapper.readValue(sinkConfig, clazz);
    }
}
