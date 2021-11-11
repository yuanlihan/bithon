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

package org.bithon.agent.plugin.jvm.mem;

import org.bithon.agent.core.metric.domain.jvm.ClassMetrics;

import java.lang.management.ClassLoadingMXBean;
import java.lang.management.ManagementFactory;

/**
 * @author frank.chen021@outlook.com
 * @date 2021/2/14 8:29 下午
 */
public class ClassMetricCollector {
    public static ClassMetrics collect() {
        final ClassLoadingMXBean classLoadingMXBean = ManagementFactory.getClassLoadingMXBean();
        return new ClassMetrics(classLoadingMXBean.getTotalLoadedClassCount(),
                                classLoadingMXBean.getLoadedClassCount(),
                                classLoadingMXBean.getUnloadedClassCount());

    }
}
