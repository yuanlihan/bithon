package com.sbss.bithon.agent.plugin.jvm;

import com.sbss.bithon.agent.core.context.AgentContext;
import com.sbss.bithon.agent.core.context.AppInstance;
import com.sbss.bithon.agent.core.dispatcher.Dispatcher;
import com.sbss.bithon.agent.core.dispatcher.Dispatchers;
import com.sbss.bithon.agent.core.dispatcher.IMessageConverter;
import com.sbss.bithon.agent.core.event.EventMessage;
import com.sbss.bithon.agent.core.metric.IMetricCollector;
import com.sbss.bithon.agent.core.metric.MetricCollectorManager;
import com.sbss.bithon.agent.core.metric.jvm.JvmMetrics;
import com.sbss.bithon.agent.core.utils.time.DateTime;
import com.sun.management.UnixOperatingSystemMXBean;
import shaded.com.alibaba.fastjson.JSON;
import shaded.org.slf4j.Logger;
import shaded.org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.TreeMap;

import static com.sbss.bithon.agent.plugin.jvm.JmxBeans.osBean;
import static com.sbss.bithon.agent.plugin.jvm.JmxBeans.runtimeBean;

/**
 * @author frankchen
 */
public class JvmMetricService {
    private static final Logger log = LoggerFactory.getLogger(JvmMetricService.class);

    private CpuMetricBuilder cpuMetricBuilder;
    private GcMetricBuilder gcMetricBuilder;

    public void start() {
        gcMetricBuilder = new GcMetricBuilder();
        cpuMetricBuilder = new CpuMetricBuilder();

        //
        // start timer to send event
        //
        Timer sendEventTimer = new Timer("bithon-event-sender");
        sendEventTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (sendJvmStartedEvent()) {
                    sendEventTimer.cancel();
                }
            }
        }, 1000, 5);

        //
        // register collector
        //
        MetricCollectorManager.getInstance().register("jvm-metrics", new IMetricCollector() {
            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public List<Object> collect(IMessageConverter messageConverter,
                                        AppInstance appInstance,
                                        int interval,
                                        long timestamp) {
                return Collections.singletonList(messageConverter.from(AgentContext.getInstance().getAppInstance(),
                                                                       timestamp,
                                                                       interval,
                                                                       buildJvmMetrics()));
            }
        });
    }

    private JvmMetrics buildJvmMetrics() {
        JvmMetrics jvmMetrics = new JvmMetrics(runtimeBean.getUptime(),
                                               runtimeBean.getStartTime());
        jvmMetrics.cpuMetrics = cpuMetricBuilder.build();
        jvmMetrics.memoryMetrics = MemoryMetricBuilder.buildMemoryMetrics();
        jvmMetrics.heapMetrics = MemoryMetricBuilder.buildHeapMetrics();
        jvmMetrics.nonHeapMetrics = MemoryMetricBuilder.buildNonHeapMetrics();
        jvmMetrics.metaspaceMetrics = MemoryMetricBuilder.buildMetaspaceMetrics();
        jvmMetrics.gcMetrics = gcMetricBuilder.build();
        jvmMetrics.threadMetrics = ThreadMetricBuilder.build();
        jvmMetrics.classMetrics = ClassMetricBuilder.build();
        return jvmMetrics;
    }

    private boolean sendJvmStartedEvent() {
        Dispatcher dispatcher = Dispatchers.getOrCreate(Dispatchers.DISPATCHER_NAME_EVNETS);
        if (!dispatcher.isReady()) {
            return false;
        }

        IMessageConverter converter = dispatcher.getMessageConverter();
        dispatcher.sendMessage(converter.from(AgentContext.getInstance().getAppInstance(),
                                              buildJvmStartedEventMessage()));
        return true;
    }

    private EventMessage buildJvmStartedEventMessage() {
        Map<String, String> args = new TreeMap<>();

        args.put("os.arch", osBean.getArch());
        args.put("os.version", osBean.getVersion());
        args.put("os.name", osBean.getName());
        args.put("os.committedVirtualMemorySize", String.valueOf(osBean.getCommittedVirtualMemorySize()));
        args.put("os.totalPhysicalMemorySize", String.valueOf(osBean.getTotalPhysicalMemorySize()));
        args.put("os.totalSwapSpaceSize", String.valueOf(osBean.getTotalSwapSpaceSize()));
        if (osBean instanceof UnixOperatingSystemMXBean) {
            UnixOperatingSystemMXBean unixOperatingSystemMXBean = (UnixOperatingSystemMXBean) osBean;
            args.put("os.maxFileDescriptorCount",
                     String.valueOf(unixOperatingSystemMXBean.getMaxFileDescriptorCount()));
        }

        //TODO: remove JSON dependency by manual serialization
        args.put("runtime.bootClassPath", JSON.toJSONString(runtimeBean.getBootClassPath().split(File.pathSeparator)));
        args.put("runtime.classPath", JSON.toJSONString(runtimeBean.getClassPath().split(File.pathSeparator)));
        args.put("runtime.arguments", JSON.toJSONString(runtimeBean.getInputArguments()));
        args.put("runtime.libraryPath", JSON.toJSONString(runtimeBean.getLibraryPath().split(File.pathSeparator)));
        args.put("runtime.systemProperties", JSON.toJSONString(runtimeBean.getSystemProperties()));
        args.put("runtime.managementSpecVersion", runtimeBean.getManagementSpecVersion());
        args.put("runtime.name", runtimeBean.getName());
        args.put("runtime.java.name", runtimeBean.getSpecName());
        args.put("runtime.java.vendor", runtimeBean.getSpecVendor());
        args.put("runtime.java.version", runtimeBean.getSpecVersion());
        args.put("runtime.java.vm.name", runtimeBean.getVmName());
        args.put("runtime.java.vm.vendor", runtimeBean.getVmVendor());
        args.put("runtime.java.vm.version", runtimeBean.getVmVersion());
        args.put("runtime.startTime", DateTime.toISO8601(runtimeBean.getStartTime()));

        args.put("mem.heap.initial", String.valueOf(JmxBeans.memoryBean.getHeapMemoryUsage().getInit()));
        args.put("mem.heap.max", String.valueOf(JmxBeans.memoryBean.getHeapMemoryUsage().getMax()));

        return new EventMessage("jvm.started", args);
    }
}
