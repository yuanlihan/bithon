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

package org.bithon.agent.sentinel.flow;

import org.bithon.component.brpc.BrpcMethod;
import org.bithon.component.brpc.BrpcService;
import org.bithon.component.brpc.message.serializer.Serializer;

import java.util.Set;

/**
 * @author frank.chen021@outlook.com
 * @date 2021/7/5 7:50 下午
 */
@BrpcService
public interface IFlowRuleManager {

    @BrpcMethod(serializer = Serializer.JSON_SMILE)
    void create(FlowRuleDto request);

    @BrpcMethod(serializer = Serializer.JSON_SMILE)
    void update(FlowRuleDto request);

    void delete(String ruleId);

    void deleteAll();

    Set<String> getRules();
}
