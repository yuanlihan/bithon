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

package org.bithon.agent.plugin.mysql.metrics;

import org.bithon.agent.instrumentation.aop.context.AopContext;
import org.bithon.agent.instrumentation.aop.interceptor.InterceptionDecision;
import org.bithon.agent.instrumentation.aop.interceptor.declaration.AroundInterceptor;
import org.bithon.agent.observability.metric.domain.sql.SqlMetricRegistry;
import org.bithon.agent.observability.utils.MiscUtils;
import org.bithon.agent.plugin.mysql.MySqlPlugin;

import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author frankchen
 */
public class PreparedStatementInterceptor extends AroundInterceptor {
    private final SqlMetricRegistry metricRegistry = SqlMetricRegistry.get();
    private final StatementMetricCollector statementMetricCollector = StatementMetricCollector.getInstance();

    @Override
    public InterceptionDecision before(AopContext aopContext) {
        try {
            Statement statement = (Statement) aopContext.getTarget();
            String connectionString = statement.getConnection().getMetaData().getURL();

            aopContext.setUserContext(MiscUtils.cleanupConnectionString(connectionString));
        } catch (SQLException ignored) {
            return InterceptionDecision.SKIP_LEAVE;
        }
        return InterceptionDecision.CONTINUE;
    }

    @Override
    public void after(AopContext aopContext) {
        String connectionString = aopContext.getUserContextAs();
        if (connectionString == null) {
            return;
        }

        String methodName = aopContext.getMethod();
        boolean isQuery = true;
        if (MySqlPlugin.METHOD_EXECUTE_UPDATE.equals(methodName) ||
            MySqlPlugin.METHOD_EXECUTE_UPDATE_INTERNAL.equals(methodName)) {
            isQuery = false;
        } else if ((MySqlPlugin.METHOD_EXECUTE.equals(methodName) ||
                    MySqlPlugin.METHOD_EXECUTE_INTERNAL.equals(methodName))) {
            Object result = aopContext.getReturning();
            if (result instanceof Boolean && !(boolean) result) {
                isQuery = false;
            }
        }
        metricRegistry.getOrCreateMetrics(connectionString)
                      .update(isQuery, aopContext.hasException(), aopContext.getExecutionTime());


        statementMetricCollector.sqlStats(aopContext, (String) aopContext.getUserContext());
    }
}
