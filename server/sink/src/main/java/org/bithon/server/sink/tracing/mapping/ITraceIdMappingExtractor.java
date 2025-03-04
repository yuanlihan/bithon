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

package org.bithon.server.sink.tracing.mapping;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.bithon.server.storage.tracing.TraceSpan;

import java.util.function.BiConsumer;

/**
 * @author frank.chen021@outlook.com
 * @date 10/12/21 3:12 PM
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes(value = {
    @JsonSubTypes.Type(name = "uri", value = URIParameterExtractor.class),
    @JsonSubTypes.Type(name = "name", value = NameValueExtractor.class),
})
public interface ITraceIdMappingExtractor {
    /**
     * @param callback once a user id is successfully extracted from given span, this callback will be invoked
     */
    void extract(TraceSpan span, BiConsumer<TraceSpan, String> callback);
}
