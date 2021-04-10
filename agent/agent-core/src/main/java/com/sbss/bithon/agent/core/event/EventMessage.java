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

package com.sbss.bithon.agent.core.event;

import java.util.Map;

/**
 * @author frank.chen021@outlook.com
 * @date 2021/2/14 4:44 下午
 */
public class EventMessage {
    private final String messageType;
    private final Map<String, String> args;

    public EventMessage(String messageType, Map<String, String> args) {
        this.messageType = messageType;
        this.args = args;
    }

    public String getMessageType() {
        return messageType;
    }

    public Map<String, String> getArgs() {
        return args;
    }
}
