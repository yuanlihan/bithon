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

package com.sbss.bithon.agent.core.metric.domain.web;

/**
 * @author frank.chen021@outlook.com
 * @date 2021/1/13 10:53 下午
 */
public enum WebServerType {
    TOMCAT("tomcat"),
    UNDERTOW("undertow"),
    JETTY("jetty");

    private final String type;

    WebServerType(String type) {
        this.type = type;
    }

    public String type() {
        return type;
    }
}
