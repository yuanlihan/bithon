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

package org.bithon.agent.plugin.httpclient.jdk.interceptor;

import org.bithon.agent.core.metric.model.Sum;

/**
 * @author frank.chen021@outlook.com
 * @date 2022/8/21 15:19
 */
public class HttpClientContext {
    private String url;
    private String method;
    private final Sum sentBytes;
    private final Sum receiveBytes;

    public Sum getSentBytes() {
        return sentBytes;
    }

    public Sum getReceiveBytes() {
        return receiveBytes;
    }

    private long writeAt;

    public String getUrl() {
        return url;
    }

    public String getMethod() {
        return method;
    }

    public HttpClientContext() {
        this.sentBytes = new Sum();
        this.receiveBytes = new Sum();
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public long getWriteAt() {
        return writeAt;
    }

    public void setWriteAt(long writeAt) {
        this.writeAt = writeAt;
    }
}
