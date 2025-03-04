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

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.bithon.server.sink.common.handler.AbstractThreadPoolMessageHandler;
import org.bithon.server.sink.tracing.index.TagIndexGenerator;
import org.bithon.server.sink.tracing.mapping.TraceMappingFactory;
import org.bithon.server.sink.tracing.sanitization.SanitizerFactory;
import org.bithon.server.storage.tracing.ITraceStorage;
import org.bithon.server.storage.tracing.ITraceWriter;
import org.bithon.server.storage.tracing.TraceSpan;
import org.bithon.server.storage.tracing.TraceStorageConfig;
import org.bithon.server.storage.tracing.mapping.TraceIdMapping;
import org.springframework.context.ApplicationContext;

import java.io.IOException;
import java.time.Duration;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;

/**
 * @author frank.chen021@outlook.com
 * @date 2021/2/4 8:21 下午
 */
@Slf4j
public class TraceSinkHandler extends AbstractThreadPoolMessageHandler<List<TraceSpan>> {

    private final ITraceWriter traceWriter;
    private final Function<Collection<TraceSpan>, List<TraceIdMapping>> mappingExtractor;
    private final SanitizerFactory sanitizerFactory;
    private final TagIndexGenerator tagIndexBuilder;

    public TraceSinkHandler(ApplicationContext applicationContext) {
        super("trace-message-handler", 2, 10, Duration.ofMinutes(1), 1024);

        TraceSinkConfig sinkConfig = applicationContext.getBean(TraceSinkConfig.class);
        this.traceWriter = new TraceBatchWriter(applicationContext.getBean(ITraceStorage.class).createWriter(),
                                                sinkConfig);

        this.mappingExtractor = TraceMappingFactory.create(applicationContext);
        this.sanitizerFactory = new SanitizerFactory(applicationContext.getBean(ObjectMapper.class),
                                                     sinkConfig);
        this.tagIndexBuilder = new TagIndexGenerator(applicationContext.getBean(TraceStorageConfig.class));
    }

    @Override
    protected void onMessage(List<TraceSpan> spans) throws IOException {
        if (spans.isEmpty()) {
            return;
        }

        sanitizerFactory.sanitize(spans);

        traceWriter.write(spans,
                          mappingExtractor.apply(spans),
                          tagIndexBuilder.generate(spans));
    }

    @Override
    public String getType() {
        return "trace";
    }

    @Override
    public void close() throws Exception {
        super.close();
        this.traceWriter.close();
    }
}
