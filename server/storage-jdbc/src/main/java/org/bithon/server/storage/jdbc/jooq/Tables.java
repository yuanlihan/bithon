/*
 * This file is generated by jOOQ.
 */
package org.bithon.server.storage.jdbc.jooq;


import org.bithon.server.storage.jdbc.jooq.tables.BithonAgentSetting;
import org.bithon.server.storage.jdbc.jooq.tables.BithonApplicationInstance;
import org.bithon.server.storage.jdbc.jooq.tables.BithonEvent;
import org.bithon.server.storage.jdbc.jooq.tables.BithonTraceSpan;


/**
 * Convenience access to all tables in 
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables {

    /**
     * 配置
     */
    public static final BithonAgentSetting BITHON_AGENT_SETTING = BithonAgentSetting.BITHON_AGENT_SETTING;

    /**
     * 应用
     */
    public static final BithonApplicationInstance BITHON_APPLICATION_INSTANCE = BithonApplicationInstance.BITHON_APPLICATION_INSTANCE;

    /**
     * The table <code>bithon_event</code>.
     */
    public static final BithonEvent BITHON_EVENT = BithonEvent.BITHON_EVENT;

    /**
     * The table <code>bithon_trace_span</code>.
     */
    public static final BithonTraceSpan BITHON_TRACE_SPAN = BithonTraceSpan.BITHON_TRACE_SPAN;
}
