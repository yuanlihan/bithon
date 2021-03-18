package com.sbss.bithon.agent.plugin.httpclient.jdk;

import com.sbss.bithon.agent.core.metric.MetricProviderManager;
import com.sbss.bithon.agent.core.metric.http.HttpClientMetricProvider;
import com.sbss.bithon.agent.core.plugin.aop.bootstrap.AbstractInterceptor;
import com.sbss.bithon.agent.core.plugin.aop.bootstrap.AopContext;
import com.sbss.bithon.agent.core.plugin.aop.bootstrap.IBithonObject;
import com.sbss.bithon.agent.core.tracing.context.TraceContext;
import com.sbss.bithon.agent.core.tracing.context.TraceContextHolder;
import com.sbss.bithon.agent.core.tracing.context.TraceSpan;
import com.sbss.bithon.agent.core.utils.StringUtils;
import sun.net.www.MessageHeader;
import sun.net.www.protocol.http.HttpURLConnection;

/**
 * @author frankchen
 */
public class HttpClientParseHttpInterceptor extends AbstractInterceptor {

    //TODO: jdk-http metrics
    HttpClientMetricProvider metricProvider;

    @Override
    public boolean initialize() throws Exception {
        metricProvider = MetricProviderManager.getInstance().register("jdk-httpclient", new HttpClientMetricProvider());
        return true;
    }

    @Override
    public void onMethodLeave(AopContext aopContext) {
        MessageHeader responseHeader = (MessageHeader) aopContext.getArgs()[0];
        String statusLine = responseHeader.getValue(0);
        Integer statusCode = parseStatusCode(statusLine);

        IBithonObject bithonObject = aopContext.castTargetAs();
        HttpURLConnection connection = (HttpURLConnection) bithonObject.getInjectedObject();
        String httpMethod = connection.getRequestMethod();
        String uri = connection.getURL().toString().split("\\?")[0];
        if (aopContext.hasException()) {
            // TODO: aopContext.getCostTime here only returns the execution time of HttpClient.parseHTTP
            metricProvider.addExceptionRequest(uri, httpMethod, aopContext.getCostTime());
        } else {
            metricProvider.addRequest(uri, httpMethod, statusCode, aopContext.getCostTime());
        }

        TraceContext traceContext = TraceContextHolder.get();
        if (traceContext == null) {
            return;
        }
        TraceSpan span = traceContext.currentSpan();
        if (span == null) {
            return;
        }

        span.tag("status", statusCode.toString()).finish();
    }

    /**
     * eg:
     * HTTP/1.0 200 OK
     * HTTP/1.0 401 Unauthorized
     * It will return 200 and 401 respectively. Returns -1 if no code can be discerned
     */
    private Integer parseStatusCode(String statusLine) {
        if (!StringUtils.isEmpty(statusLine)) {
            String[] results = statusLine.split(" ");
            if (results.length >= 1) {
                try {
                    return Integer.valueOf(results[1]);
                } catch (NumberFormatException ignored) {
                }
            }
        }
        return -1;
    }
}
