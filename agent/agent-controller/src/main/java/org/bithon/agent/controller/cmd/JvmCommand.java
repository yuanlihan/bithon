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

package org.bithon.agent.controller.cmd;

import com.sun.management.HotSpotDiagnosticMXBean;
import org.bithon.agent.instrumentation.aop.InstrumentationHelper;
import org.bithon.agent.rpc.brpc.cmd.IJvmCommand;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author frank.chen021@outlook.com
 * @date 2021/7/2 4:38 下午
 */
public class JvmCommand implements IJvmCommand, IAgentCommand {
    @Override
    public List<ThreadInfo> dumpThreads() {
        ThreadMXBean threadMxBean = ManagementFactory.getThreadMXBean();
        boolean cpuTimeEnabled = threadMxBean.isThreadCpuTimeSupported() && threadMxBean.isThreadCpuTimeEnabled();

        // It's not efficient enough since the stack trace are retrieved twice,
        // One is here, the other one is the getThreadInfo below.
        // The reason is that under JDK 8, the ThreadInfo does not include priority/daemon properties which can only be found on Thread object.
        Map<Long, Thread> threads = Thread.getAllStackTraces()
                                          .keySet()
                                          .stream()
                                          .collect(Collectors.toMap(Thread::getId, v -> v));
        long[] threadIds = threads.keySet().stream().mapToLong(Long::longValue).toArray();

        java.lang.management.ThreadInfo[] threadInfos;
        if (threadIds == null) {
            threadInfos = ManagementFactory.getThreadMXBean().dumpAllThreads(true, true);
        } else {
            threadInfos = ManagementFactory.getThreadMXBean().getThreadInfo(threadIds, true, true);
        }

        return Arrays.stream(threadInfos)
                     .map((threadInfo) -> {
                         Thread thread = threads.get(threadInfo.getThreadId());
                         if (thread == null) {
                             return null;
                         }
                         return toThreadInfo(threadMxBean, cpuTimeEnabled, thread, threadInfo);
                     })
                     .filter(Objects::nonNull)
                     .collect(Collectors.toList());
    }

    @Override
    public List<ClassInfo> getLoadedClassList() {
        return Arrays.stream(InstrumentationHelper.getInstance().getAllLoadedClasses())
                     // It does not make any sense to return anonymous class or lambda class
                     .filter(clazz -> !isAnonymousClassOrLambda(clazz))
                     .map((clazz) -> {
                         ClassInfo classInfo = new ClassInfo();
                         classInfo.name = clazz.getTypeName();
                         classInfo.classLoader = (clazz.getClassLoader() == null ? "bootstrap" : clazz.getClassLoader().getClass().getName());
                         classInfo.isAnnotation = (clazz.isAnnotation());
                         classInfo.isInterface = (clazz.isInterface());
                         classInfo.isSynthetic = (clazz.isSynthetic());
                         classInfo.isEnum = (clazz.isEnum());
                         return classInfo;
                     })
                     .collect(Collectors.toList());
    }

    @Override
    public List<VMOption> getVMOptions() {
        HotSpotDiagnosticMXBean bean = ManagementFactory.getPlatformMXBean(HotSpotDiagnosticMXBean.class);
        if (bean != null) {
            return bean.getDiagnosticOptions().stream()
                       .map((option) -> {
                           IJvmCommand.VMOption op = new IJvmCommand.VMOption();
                           op.name = option.getName();
                           op.value = option.getValue();
                           op.isWriteable = option.isWriteable();
                           op.origin = option.getOrigin().toString();
                           return op;
                       })
                       .collect(Collectors.toList());
        } else {
            return Collections.emptyList();
        }
    }

    private static ThreadInfo toThreadInfo(ThreadMXBean threadMxBean,
                                           boolean cpuTimeEnabled,
                                           Thread thread,
                                           java.lang.management.ThreadInfo info) {
        StringBuilder sb = new StringBuilder(512);
        for (StackTraceElement stack : info.getStackTrace()) {
            sb.append(stack.getClassName());
            sb.append('#');
            sb.append(stack.getMethodName());
            if (stack.getFileName() != null) {
                sb.append('(');
                sb.append(stack.getFileName());
                sb.append(':');
                sb.append(stack.getLineNumber());
                sb.append(')');
            }
            sb.append('\n');
        }

        ThreadInfo threadInfo = new ThreadInfo();
        threadInfo.name = (thread.getName());
        threadInfo.threadId = (thread.getId());
        threadInfo.isDaemon = (thread.isDaemon());
        threadInfo.priority = (thread.getPriority());
        threadInfo.state = (thread.getState().toString());
        threadInfo.cpuTime = (cpuTimeEnabled ? threadMxBean.getThreadCpuTime(thread.getId()) : -1);
        threadInfo.userTime = (cpuTimeEnabled ? threadMxBean.getThreadUserTime(thread.getId()) : -1);

        threadInfo.blockedCount = (info.getBlockedCount());
        threadInfo.blockedTime = (info.getBlockedTime());

        threadInfo.waitedCount = (info.getWaitedCount());
        threadInfo.waitedTime = (info.getWaitedTime());

        threadInfo.inNative = (info.isInNative() ? 1 : 0);
        threadInfo.suspended = (info.isSuspended() ? 1 : 0);

        threadInfo.lockName = (info.getLockName());
        threadInfo.lockOwnerId = (info.getLockOwnerId());
        threadInfo.lockOwnerName = (info.getLockOwnerName());

        threadInfo.stack = (sb.toString());
        return threadInfo;
    }

    private boolean isAnonymousClassOrLambda(Class<?> clazz) {
        try {
            return clazz.getName().indexOf('/') > 0 || clazz.isAnonymousClass();
        } catch (Throwable e) {
            // Sometime is throws IllegalAccessError internally, need to catch and ignore it
            return false;
        }
    }
}
