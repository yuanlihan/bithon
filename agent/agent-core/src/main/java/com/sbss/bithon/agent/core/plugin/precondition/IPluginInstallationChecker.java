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

package com.sbss.bithon.agent.core.plugin.precondition;

import com.sbss.bithon.agent.core.plugin.AbstractPlugin;
import shaded.net.bytebuddy.description.type.TypeDescription;

/**
 * @author frank.chen021@outlook.com
 * @date 2021/1/17 8:13 下午
 */
public interface IPluginInstallationChecker {

    /**
     * Helper method
     */
    static IPluginInstallationChecker hasClass(String className) {
        return new HasClassChecker(className, false);
    }

    /**
     * Helper method
     */
    static IPluginInstallationChecker hasClass(String className, boolean debugging) {
        return new HasClassChecker(className, debugging);
    }

    static IPluginInstallationChecker or(IPluginInstallationChecker... checkers) {
        return new OrChecker(checkers);
    }

    /**
     * returns true if interceptors in this plugin can be installed
     *
     * @param plugin          plugin of which interceptors are being installed
     * @param typeDescription
     */
    boolean canInstall(AbstractPlugin plugin, ClassLoader classLoader, TypeDescription typeDescription);
}
