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

package org.bithon.agent.plugin.mysql8;

import org.bithon.agent.instrumentation.aop.context.AopContext;
import org.bithon.agent.instrumentation.aop.interceptor.InterceptionDecision;
import org.bithon.agent.instrumentation.aop.interceptor.declaration.AroundInterceptor;
import org.bithon.agent.observability.metric.domain.sql.SQLMetrics;
import org.bithon.agent.observability.metric.domain.sql.SqlMetricRegistry;
import org.bithon.agent.observability.utils.MiscUtils;

import java.sql.Statement;

/**
 * @author frankchen
 */
public class PreparedStatementInterceptor extends AroundInterceptor {
    private final SqlMetricRegistry metricRegistry = SqlMetricRegistry.get();
    private final SqlStatementMetricCollector statementCollector = SqlStatementMetricCollector.getInstance();

    @Override
    public InterceptionDecision before(AopContext aopContext) throws Exception {
        Statement statement = (Statement) aopContext.getTarget();

        // get the connection info before execution since the connection might be closed during execution
        aopContext.setUserContext(MiscUtils.cleanupConnectionString(statement.getConnection()
                                                                             .getMetaData()
                                                                             .getURL()));
        return InterceptionDecision.CONTINUE;
    }

    @Override
    public void after(AopContext aopContext) {
        String methodName = aopContext.getMethod();
        String connectionString = aopContext.getUserContextAs();

        SQLMetrics metric = metricRegistry.getOrCreateMetrics(connectionString);
        boolean isQuery = true;
        if (MySql8Plugin.METHOD_EXECUTE_UPDATE.equals(methodName)
            || MySql8Plugin.METHOD_EXECUTE_UPDATE_INTERNAL.equals(methodName)) {
            isQuery = false;
        } else if ((MySql8Plugin.METHOD_EXECUTE.equals(methodName) || MySql8Plugin.METHOD_EXECUTE_INTERNAL.equals(
            methodName))) {
            Object result = aopContext.getReturning();
            if (result instanceof Boolean && !(boolean) result) {
                isQuery = false;
            }
        }
        metric.update(isQuery, aopContext.hasException(), aopContext.getExecutionTime());


        statementCollector.update(aopContext);
    }
}
