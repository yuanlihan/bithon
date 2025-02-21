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

package org.bithon.agent.plugin.log4j2.interceptor;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.spi.StandardLevel;
import org.bithon.agent.instrumentation.aop.context.AopContext;
import org.bithon.agent.instrumentation.aop.interceptor.declaration.BeforeInterceptor;
import org.bithon.agent.observability.event.ExceptionCollector;

/**
 * @author frankchen
 */
public class Logger$LogMessage extends BeforeInterceptor {

    @Override
    public void before(AopContext aopContext) {
        Level logLevel = (Level) aopContext.getArgs()[1];
        Throwable exception = (Throwable) aopContext.getArgs()[4];
        if (exception == null || !StandardLevel.ERROR.equals(logLevel.getStandardLevel())) {
            return;
        }

        ExceptionCollector.collect(exception);
    }
}
