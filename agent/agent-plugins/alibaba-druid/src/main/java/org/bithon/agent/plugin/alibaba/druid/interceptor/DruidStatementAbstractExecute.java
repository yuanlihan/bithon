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

package org.bithon.agent.plugin.alibaba.druid.interceptor;

import org.bithon.agent.configuration.ConfigurationManager;
import org.bithon.agent.instrumentation.aop.context.AopContext;
import org.bithon.agent.instrumentation.aop.interceptor.InterceptionDecision;
import org.bithon.agent.instrumentation.aop.interceptor.declaration.AroundInterceptor;
import org.bithon.agent.observability.metric.domain.sql.SqlMetricRegistry;
import org.bithon.agent.observability.tracing.context.ITraceSpan;
import org.bithon.agent.observability.tracing.context.TraceSpanFactory;
import org.bithon.agent.observability.utils.MiscUtils;
import org.bithon.agent.plugin.alibaba.druid.DruidPlugin;
import org.bithon.agent.plugin.alibaba.druid.config.DruidPluginConfig;
import org.bithon.component.commons.logging.ILogAdaptor;
import org.bithon.component.commons.logging.LoggerFactory;
import org.bithon.component.commons.tracing.SpanKind;
import org.bithon.component.commons.tracing.Tags;

import java.sql.Statement;

/**
 * @author frankchen
 */
public abstract class DruidStatementAbstractExecute extends AroundInterceptor {
    static class UserContext {
        String uri;
        ITraceSpan span;

        public UserContext(String uri, ITraceSpan span) {
            this.uri = uri;
            this.span = span;
        }
    }

    private static final ILogAdaptor log = LoggerFactory.getLogger(DruidStatementAbstractExecute.class);

    private final SqlMetricRegistry metricRegistry;
    private final boolean isSQLMetricEnabled;

    public DruidStatementAbstractExecute() {
        DruidPluginConfig config = ConfigurationManager.getInstance().getConfig(DruidPluginConfig.class);
        isSQLMetricEnabled = config.isSQLMetricEnabled();
        if (isSQLMetricEnabled) {
            metricRegistry = SqlMetricRegistry.get();
        } else {
            metricRegistry = null;
        }
    }

    @Override
    public InterceptionDecision before(AopContext aopContext) throws Exception {
        Statement statement = aopContext.getTargetAs();

        // TODO: cache the cleaned-up connection string in IBithonObject after connection object instantiation
        // to improve performance
        //
        // Get connection string before a SQL execution
        // In some cases, a connection might be aborted by server
        // then, a getConnection() call would throw an exception saying that connection has been closed
        String connectionString = MiscUtils.cleanupConnectionString(statement.getConnection()
                                                                             .getMetaData()
                                                                             .getURL());
        ITraceSpan span = TraceSpanFactory.newSpan("alibaba-druid");
        if (span != null) {
            span.method(aopContext.getTargetClass(), aopContext.getMethod())
                .kind(SpanKind.CLIENT)
                .tag(Tags.Database.CONNECTION_STRING, connectionString)
                .start();
        }

        aopContext.setUserContext(new UserContext(connectionString, span));

        return InterceptionDecision.CONTINUE;
    }

    @Override
    public void after(AopContext aopContext) {
        UserContext context = aopContext.getUserContextAs();
        if (context.span != null) {
            try {
                context.span.tag(Tags.Database.STATEMENT, getExecutingSql(aopContext))
                            .tag(aopContext.getException());

                if (DruidPlugin.METHOD_EXECUTE_BATCH.equals(aopContext.getMethod())) {
                    if (aopContext.getReturning() != null) {
                        context.span.tag(Tags.Database.PREFIX + "rows", Integer.toString(((int[]) aopContext.getReturning()).length));
                    }
                }
            } finally {
                context.span.finish();
            }
        }

        if (context.uri != null && isSQLMetricEnabled) {

            String methodName = aopContext.getMethod();

            // check if the metrics provider for this driver exists
            Boolean isQuery = null;
            if (DruidPlugin.METHOD_EXECUTE_UPDATE.equals(methodName)
                    || DruidPlugin.METHOD_EXECUTE_BATCH.equals(methodName)) {
                isQuery = false;
            } else if (DruidPlugin.METHOD_EXECUTE.equals(methodName)) {
                /*
                 * execute method return true if the first result is a ResultSet
                 */
                isQuery = aopContext.getReturning() == null ? null : (boolean) aopContext.getReturningAs();
            } else if (DruidPlugin.METHOD_EXECUTE_QUERY.equals(methodName)) {
                isQuery = true;
            } else {
                //TODO: parse the SQL to check if it's a SELECT
                log.warn("unknown method intercepted by druid-sql-counter : {}", methodName);
            }

            metricRegistry.getOrCreateMetrics(context.uri).update(isQuery, aopContext.hasException(), aopContext.getExecutionTime());
        }
    }

    protected abstract String getExecutingSql(AopContext aopContext);
}
