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

package com.sbss.bithon.server.tracing.handler;

import com.sbss.bithon.agent.rpc.thrift.service.MessageHeader;
import com.sbss.bithon.agent.rpc.thrift.service.trace.TraceSpanMessage;
import lombok.Data;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author frank.chen021@outlook.com
 * @date 2021/2/4 8:28 下午
 */
@Data
public class TraceSpan {
    public String appName;
    public String instanceName;
    public String traceId;
    public String spanId;
    public String kind;
    public String parentSpanId;
    public String parentApplication;
    public Map<String, String> tags;
    public long costTime;
    public long startTime;
    public long endTime;
    public String name;
    public String clazz;
    public String method;

    public static List<TraceSpan> from(MessageHeader header, List<TraceSpanMessage> message) {
        if (CollectionUtils.isEmpty(message)) {
            return Collections.emptyList();
        }

        List<TraceSpan> spans = new ArrayList<>();
        message.forEach((spanMessage) -> {
            TraceSpan traceSpan = new TraceSpan();
            traceSpan.appName = header.appName;
            traceSpan.instanceName = header.instanceName;
            traceSpan.kind = spanMessage.kind;
            traceSpan.name = spanMessage.name;
            traceSpan.traceId = spanMessage.traceId;
            traceSpan.spanId = spanMessage.spanId;
            traceSpan.parentSpanId = spanMessage.parentSpanId == null ? "" : spanMessage.parentSpanId;
            traceSpan.parentApplication = spanMessage.parentAppName;
            traceSpan.startTime = spanMessage.startTime;
            traceSpan.endTime = spanMessage.endTime;
            traceSpan.costTime = spanMessage.endTime - spanMessage.startTime;
            traceSpan.tags = spanMessage.tags;
            traceSpan.clazz = spanMessage.clazz;
            traceSpan.method = spanMessage.method;
            spans.add(traceSpan);
        });
        return spans;
    }
}
