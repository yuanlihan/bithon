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

package com.sbss.bithon.agent.core.plugin;

import com.sbss.bithon.agent.bootstrap.aop.IBithonObject;
import com.sbss.bithon.agent.core.plugin.descriptor.BithonClassDescriptor;
import com.sbss.bithon.agent.core.plugin.descriptor.InterceptorDescriptor;
import com.sbss.bithon.agent.core.plugin.precondition.IPluginInstallationChecker;

import java.util.Collections;
import java.util.List;

/**
 * @author frankchen
 * @date 2020-12-31 22:29:55
 */
public abstract class AbstractPlugin {

    public List<IPluginInstallationChecker> getCheckers() {
        return Collections.emptyList();
    }

    /**
     * ALL classes in {@link #getInterceptors()} will be transformed as {@link IBithonObject} automatically.
     * But some classes needs to be transformed too to support passing objects especially those which provide ASYNC ability
     */
    public BithonClassDescriptor getBithonClassDescriptor() {
        return null;
    }

    /**
     * A list, each element of which is an interceptor for a specific method of class
     * NOTE, the target class will be instrumented as {@link IBithonObject}
     */
    public List<InterceptorDescriptor> getInterceptors() {
        return Collections.emptyList();
    }

    public void start() {
    }

    public void stop() {
    }
}
