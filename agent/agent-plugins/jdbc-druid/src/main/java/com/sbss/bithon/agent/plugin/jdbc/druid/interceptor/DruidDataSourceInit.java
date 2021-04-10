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

package com.sbss.bithon.agent.plugin.jdbc.druid.interceptor;

import com.sbss.bithon.agent.boot.aop.AbstractInterceptor;
import com.sbss.bithon.agent.boot.aop.AopContext;
import com.sbss.bithon.agent.boot.aop.IBithonObject;
import com.sbss.bithon.agent.boot.aop.InterceptionDecision;
import com.sbss.bithon.agent.plugin.jdbc.druid.metric.DruidJdbcMetricCollector;
import com.sbss.bithon.agent.plugin.jdbc.druid.metric.MonitoredSourceManager;

/**
 * @author frankchen
 */
public class DruidDataSourceInit extends AbstractInterceptor {

    @Override
    public boolean initialize() {
        DruidJdbcMetricCollector.getOrCreateInstance();
        return true;
    }

    @Override
    public InterceptionDecision onMethodEnter(AopContext aopContext) throws Exception {
        IBithonObject obj = aopContext.castTargetAs();
        Boolean initialized = (Boolean) obj.getInjectedObject();
        if (initialized != null && initialized) {
            return InterceptionDecision.SKIP_LEAVE;
        }

        return InterceptionDecision.CONTINUE;
    }

    @Override
    public void onMethodLeave(AopContext aopContext) throws Exception {
        if (aopContext.hasException()) {
            return;
        }

        IBithonObject obj = aopContext.castTargetAs();
        boolean initialized = MonitoredSourceManager.getInstance().addDataSource(aopContext.castTargetAs());
        obj.setInjectedObject(initialized);
    }
}
