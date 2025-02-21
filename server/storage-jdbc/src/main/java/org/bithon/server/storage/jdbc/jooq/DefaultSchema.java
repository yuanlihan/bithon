/*
 * This file is generated by jOOQ.
 */
package org.bithon.server.storage.jdbc.jooq;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bithon.server.storage.jdbc.jooq.tables.BithonAgentSetting;
import org.bithon.server.storage.jdbc.jooq.tables.BithonApplicationInstance;
import org.bithon.server.storage.jdbc.jooq.tables.BithonEvent;
import org.bithon.server.storage.jdbc.jooq.tables.BithonMetaApplicationMetricMap;
import org.bithon.server.storage.jdbc.jooq.tables.BithonMetaSchema;
import org.bithon.server.storage.jdbc.jooq.tables.BithonTraceMapping;
import org.bithon.server.storage.jdbc.jooq.tables.BithonTraceSpan;
import org.bithon.server.storage.jdbc.jooq.tables.BithonTraceSpanSummary;
import org.bithon.server.storage.jdbc.jooq.tables.BithonTraceSpanTagIndex;
import org.bithon.server.storage.jdbc.jooq.tables.BithonWebDashboard;
import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class DefaultSchema extends SchemaImpl {

    private static final long serialVersionUID = 593373252;

    /**
     * The reference instance of <code></code>
     */
    public static final DefaultSchema DEFAULT_SCHEMA = new DefaultSchema();

    /**
     * The table <code>bithon_agent_setting</code>.
     */
    public final BithonAgentSetting BITHON_AGENT_SETTING = org.bithon.server.storage.jdbc.jooq.tables.BithonAgentSetting.BITHON_AGENT_SETTING;

    /**
     * The table <code>bithon_application_instance</code>.
     */
    public final BithonApplicationInstance BITHON_APPLICATION_INSTANCE = org.bithon.server.storage.jdbc.jooq.tables.BithonApplicationInstance.BITHON_APPLICATION_INSTANCE;

    /**
     * The table <code>bithon_event</code>.
     */
    public final BithonEvent BITHON_EVENT = org.bithon.server.storage.jdbc.jooq.tables.BithonEvent.BITHON_EVENT;

    /**
     * The table <code>bithon_meta_application_metric_map</code>.
     */
    public final BithonMetaApplicationMetricMap BITHON_META_APPLICATION_METRIC_MAP = org.bithon.server.storage.jdbc.jooq.tables.BithonMetaApplicationMetricMap.BITHON_META_APPLICATION_METRIC_MAP;

    /**
     * The table <code>bithon_meta_schema</code>.
     */
    public final BithonMetaSchema BITHON_META_SCHEMA = org.bithon.server.storage.jdbc.jooq.tables.BithonMetaSchema.BITHON_META_SCHEMA;

    /**
     * The table <code>bithon_trace_mapping</code>.
     */
    public final BithonTraceMapping BITHON_TRACE_MAPPING = org.bithon.server.storage.jdbc.jooq.tables.BithonTraceMapping.BITHON_TRACE_MAPPING;

    /**
     * The table <code>bithon_trace_span</code>.
     */
    public final BithonTraceSpan BITHON_TRACE_SPAN = org.bithon.server.storage.jdbc.jooq.tables.BithonTraceSpan.BITHON_TRACE_SPAN;

    /**
     * The table <code>bithon_trace_span_summary</code>.
     */
    public final BithonTraceSpanSummary BITHON_TRACE_SPAN_SUMMARY = org.bithon.server.storage.jdbc.jooq.tables.BithonTraceSpanSummary.BITHON_TRACE_SPAN_SUMMARY;

    /**
     * The table <code>bithon_trace_span_tag_index</code>.
     */
    public final BithonTraceSpanTagIndex BITHON_TRACE_SPAN_TAG_INDEX = org.bithon.server.storage.jdbc.jooq.tables.BithonTraceSpanTagIndex.BITHON_TRACE_SPAN_TAG_INDEX;

    /**
     * The table <code>bithon_web_dashboard</code>.
     */
    public final BithonWebDashboard BITHON_WEB_DASHBOARD = org.bithon.server.storage.jdbc.jooq.tables.BithonWebDashboard.BITHON_WEB_DASHBOARD;

    /**
     * No further instances allowed
     */
    private DefaultSchema() {
        super("", null);
    }


    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        List result = new ArrayList();
        result.addAll(getTables0());
        return result;
    }

    private final List<Table<?>> getTables0() {
        return Arrays.<Table<?>>asList(
            BithonAgentSetting.BITHON_AGENT_SETTING,
            BithonApplicationInstance.BITHON_APPLICATION_INSTANCE,
            BithonEvent.BITHON_EVENT,
            BithonMetaApplicationMetricMap.BITHON_META_APPLICATION_METRIC_MAP,
            BithonMetaSchema.BITHON_META_SCHEMA,
            BithonTraceMapping.BITHON_TRACE_MAPPING,
            BithonTraceSpan.BITHON_TRACE_SPAN,
            BithonTraceSpanSummary.BITHON_TRACE_SPAN_SUMMARY,
            BithonTraceSpanTagIndex.BITHON_TRACE_SPAN_TAG_INDEX,
            BithonWebDashboard.BITHON_WEB_DASHBOARD);
    }
}
