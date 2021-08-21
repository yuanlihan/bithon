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

package com.sbss.bithon.agent.plugin.tomcat.metric;

import com.sbss.bithon.agent.core.dispatcher.IMessageConverter;
import com.sbss.bithon.agent.core.metric.collector.IntervalMetricCollector;
import com.sbss.bithon.agent.core.metric.domain.web.WebRequestCompositeMetric;
import com.sbss.bithon.agent.core.tracing.propagation.ITracePropagator;
import org.apache.coyote.Request;
import org.apache.coyote.Response;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author frankchen
 */
public class WebRequestMetricCollector extends IntervalMetricCollector<WebRequestCompositeMetric> {

    public void update(Request request, Response response, long responseTime) {
        String uri = request.requestURI().toString();
        if (uri == null) {
            return;
        }

        String srcApplication = request.getHeader(ITracePropagator.BITHON_SRC_APPLICATION);

        int httpStatus = response.getStatus();
        int count4xx = httpStatus >= 400 && httpStatus < 500 ? 1 : 0;
        int count5xx = httpStatus >= 500 ? 1 : 0;
        long requestByteSize = request.getBytesRead();
        long responseByteSize = response.getBytesWritten(false);

        WebRequestCompositeMetric metric = getOrCreateMetric(srcApplication == null ? "" : srcApplication, uri);
        metric.updateRequest(responseTime, count4xx, count5xx);
        metric.updateBytes(requestByteSize, responseByteSize);
    }

    @Override
    protected WebRequestCompositeMetric newMetrics() {
        return new WebRequestCompositeMetric();
    }

    @Override
    protected Object toMessage(IMessageConverter messageConverter,
                               int interval,
                               long timestamp,
                               List<String> dimensions,
                               WebRequestCompositeMetric metric) {
        return messageConverter.from(timestamp, interval, dimensions, metric);
    }

    public WebRequestCompositeMetric getOrCreate(HttpServletRequest request) {
        String uri = request.getRequestURI();
        String srcApplication = request.getHeader(ITracePropagator.BITHON_SRC_APPLICATION);
        return getOrCreateMetric(srcApplication == null ? "" : srcApplication, uri);
    }
}
