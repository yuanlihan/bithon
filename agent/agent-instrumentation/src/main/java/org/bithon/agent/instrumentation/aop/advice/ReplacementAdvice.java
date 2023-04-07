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

package org.bithon.agent.instrumentation.aop.advice;

import org.bithon.agent.instrumentation.aop.interceptor.IInterceptor;
import org.bithon.agent.instrumentation.aop.interceptor.ReplaceInterceptor;
import org.bithon.shaded.net.bytebuddy.asm.Advice;
import org.bithon.shaded.net.bytebuddy.implementation.bytecode.assign.Assigner;

/**
 * @author frank.chen021@outlook.com
 * @date 22/2/22 11:25 PM
 */
public class ReplacementAdvice {
    /**
     * This method is only used for byte-buddy method advice. Have no use during the execution since the code has been injected into target class
     */
    @Advice.OnMethodExit
    public static void onExecute(@AdviceAnnotation.Interceptor IInterceptor interceptor,
                                 @Advice.AllArguments Object[] args,
                                 @Advice.Return(typing = Assigner.Typing.DYNAMIC, readOnly = false) Object returning) {
        if (interceptor != null) {
            returning = ((ReplaceInterceptor) interceptor).execute(args);
        }
    }
}
