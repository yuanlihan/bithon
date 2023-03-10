/*
 * This file is generated by jOOQ.
 */
package org.bithon.server.storage.jdbc.jooq;


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
import org.jooq.Index;
import org.jooq.OrderField;
import org.jooq.impl.Internal;


/**
 * A class modelling indexes of tables of the <code></code> schema.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Indexes {

    // -------------------------------------------------------------------------
    // INDEX definitions
    // -------------------------------------------------------------------------

    public static final Index BITHON_AGENT_SETTING_KEY_APPNAME = Indexes0.BITHON_AGENT_SETTING_KEY_APPNAME;
    public static final Index BITHON_APPLICATION_INSTANCE_IDX_APP_INSTANCE_TIMESTAMP = Indexes0.BITHON_APPLICATION_INSTANCE_IDX_APP_INSTANCE_TIMESTAMP;
    public static final Index BITHON_APPLICATION_INSTANCE_UQ_NAME_TYPE_INSTANCE = Indexes0.BITHON_APPLICATION_INSTANCE_UQ_NAME_TYPE_INSTANCE;
    public static final Index BITHON_EVENT_IDX_EVENT_1_TIMESTAMP = Indexes0.BITHON_EVENT_IDX_EVENT_1_TIMESTAMP;
    public static final Index BITHON_EVENT_IDX_EVENT_APPNAME = Indexes0.BITHON_EVENT_IDX_EVENT_APPNAME;
    public static final Index BITHON_EVENT_IDX_EVENT_INSTANCENAME = Indexes0.BITHON_EVENT_IDX_EVENT_INSTANCENAME;
    public static final Index BITHON_EVENT_IDX_EVENT_TYPE = Indexes0.BITHON_EVENT_IDX_EVENT_TYPE;
    public static final Index BITHON_META_APPLICATION_METRIC_MAP_IDX_META_APPLICATION_METRIC_MAP = Indexes0.BITHON_META_APPLICATION_METRIC_MAP_IDX_META_APPLICATION_METRIC_MAP;
    public static final Index BITHON_META_APPLICATION_METRIC_MAP_IDX_META_APPLICATION_METRIC_MAP_TIMESTAMP = Indexes0.BITHON_META_APPLICATION_METRIC_MAP_IDX_META_APPLICATION_METRIC_MAP_TIMESTAMP;
    public static final Index BITHON_META_SCHEMA_IDX_META_SCHEMA_NAME = Indexes0.BITHON_META_SCHEMA_IDX_META_SCHEMA_NAME;
    public static final Index BITHON_META_SCHEMA_IDX_META_SCHEMA_TIMESTAMP = Indexes0.BITHON_META_SCHEMA_IDX_META_SCHEMA_TIMESTAMP;
    public static final Index BITHON_TRACE_MAPPING_IDX_TRACE_MAPPING_USER_TX_ID = Indexes0.BITHON_TRACE_MAPPING_IDX_TRACE_MAPPING_USER_TX_ID;
    public static final Index BITHON_TRACE_SPAN_IDX_TS_1_TIMESTAMP = Indexes0.BITHON_TRACE_SPAN_IDX_TS_1_TIMESTAMP;
    public static final Index BITHON_TRACE_SPAN_IDX_TS_APP_NAME = Indexes0.BITHON_TRACE_SPAN_IDX_TS_APP_NAME;
    public static final Index BITHON_TRACE_SPAN_IDX_TS_INSTANCENAME = Indexes0.BITHON_TRACE_SPAN_IDX_TS_INSTANCENAME;
    public static final Index BITHON_TRACE_SPAN_IDX_TS_KEY = Indexes0.BITHON_TRACE_SPAN_IDX_TS_KEY;
    public static final Index BITHON_TRACE_SPAN_SUMMARY_IDX_TSS_1_TIMESTAMP = Indexes0.BITHON_TRACE_SPAN_SUMMARY_IDX_TSS_1_TIMESTAMP;
    public static final Index BITHON_TRACE_SPAN_SUMMARY_IDX_TSS_APP_NAME = Indexes0.BITHON_TRACE_SPAN_SUMMARY_IDX_TSS_APP_NAME;
    public static final Index BITHON_TRACE_SPAN_SUMMARY_IDX_TSS_INSTANCENAME = Indexes0.BITHON_TRACE_SPAN_SUMMARY_IDX_TSS_INSTANCENAME;
    public static final Index BITHON_TRACE_SPAN_SUMMARY_IDX_TSS_KEY = Indexes0.BITHON_TRACE_SPAN_SUMMARY_IDX_TSS_KEY;
    public static final Index BITHON_TRACE_SPAN_TAG_INDEX_IDX_TSTI_TIMESTAMP = Indexes0.BITHON_TRACE_SPAN_TAG_INDEX_IDX_TSTI_TIMESTAMP;
    public static final Index BITHON_WEB_DASHBOARD_IDX_WEB_DASHBOARD_NAME = Indexes0.BITHON_WEB_DASHBOARD_IDX_WEB_DASHBOARD_NAME;
    public static final Index BITHON_WEB_DASHBOARD_IDX_WEB_DASHBOARD_TIMESTAMP = Indexes0.BITHON_WEB_DASHBOARD_IDX_WEB_DASHBOARD_TIMESTAMP;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Indexes0 {
        public static Index BITHON_AGENT_SETTING_KEY_APPNAME = Internal.createIndex("key_appName", BithonAgentSetting.BITHON_AGENT_SETTING, new OrderField[] { BithonAgentSetting.BITHON_AGENT_SETTING.APPNAME, BithonAgentSetting.BITHON_AGENT_SETTING.SETTINGNAME }, true);
        public static Index BITHON_APPLICATION_INSTANCE_IDX_APP_INSTANCE_TIMESTAMP = Internal.createIndex("idx_app_instance_timestamp", BithonApplicationInstance.BITHON_APPLICATION_INSTANCE, new OrderField[] { BithonApplicationInstance.BITHON_APPLICATION_INSTANCE.TIMESTAMP }, false);
        public static Index BITHON_APPLICATION_INSTANCE_UQ_NAME_TYPE_INSTANCE = Internal.createIndex("uq_name_type_instance", BithonApplicationInstance.BITHON_APPLICATION_INSTANCE, new OrderField[] { BithonApplicationInstance.BITHON_APPLICATION_INSTANCE.APPNAME, BithonApplicationInstance.BITHON_APPLICATION_INSTANCE.APPTYPE, BithonApplicationInstance.BITHON_APPLICATION_INSTANCE.INSTANCENAME }, true);
        public static Index BITHON_EVENT_IDX_EVENT_1_TIMESTAMP = Internal.createIndex("idx_event_1_timestamp", BithonEvent.BITHON_EVENT, new OrderField[] { BithonEvent.BITHON_EVENT.TIMESTAMP }, false);
        public static Index BITHON_EVENT_IDX_EVENT_APPNAME = Internal.createIndex("idx_event_appName", BithonEvent.BITHON_EVENT, new OrderField[] { BithonEvent.BITHON_EVENT.APPNAME }, false);
        public static Index BITHON_EVENT_IDX_EVENT_INSTANCENAME = Internal.createIndex("idx_event_instanceName", BithonEvent.BITHON_EVENT, new OrderField[] { BithonEvent.BITHON_EVENT.INSTANCENAME }, false);
        public static Index BITHON_EVENT_IDX_EVENT_TYPE = Internal.createIndex("idx_event_type", BithonEvent.BITHON_EVENT, new OrderField[] { BithonEvent.BITHON_EVENT.TYPE }, false);
        public static Index BITHON_META_APPLICATION_METRIC_MAP_IDX_META_APPLICATION_METRIC_MAP = Internal.createIndex("idx_meta_application_metric_map", BithonMetaApplicationMetricMap.BITHON_META_APPLICATION_METRIC_MAP, new OrderField[] { BithonMetaApplicationMetricMap.BITHON_META_APPLICATION_METRIC_MAP.APPLICATION, BithonMetaApplicationMetricMap.BITHON_META_APPLICATION_METRIC_MAP.SCHEMA }, false);
        public static Index BITHON_META_APPLICATION_METRIC_MAP_IDX_META_APPLICATION_METRIC_MAP_TIMESTAMP = Internal.createIndex("idx_meta_application_metric_map_timestamp", BithonMetaApplicationMetricMap.BITHON_META_APPLICATION_METRIC_MAP, new OrderField[] { BithonMetaApplicationMetricMap.BITHON_META_APPLICATION_METRIC_MAP.TIMESTAMP }, false);
        public static Index BITHON_META_SCHEMA_IDX_META_SCHEMA_NAME = Internal.createIndex("idx_meta_schema_name", BithonMetaSchema.BITHON_META_SCHEMA, new OrderField[] { BithonMetaSchema.BITHON_META_SCHEMA.NAME }, true);
        public static Index BITHON_META_SCHEMA_IDX_META_SCHEMA_TIMESTAMP = Internal.createIndex("idx_meta_schema_timestamp", BithonMetaSchema.BITHON_META_SCHEMA, new OrderField[] { BithonMetaSchema.BITHON_META_SCHEMA.TIMESTAMP }, false);
        public static Index BITHON_TRACE_MAPPING_IDX_TRACE_MAPPING_USER_TX_ID = Internal.createIndex("idx_trace_mapping_user_tx_id", BithonTraceMapping.BITHON_TRACE_MAPPING, new OrderField[] { BithonTraceMapping.BITHON_TRACE_MAPPING.USER_TX_ID }, false);
        public static Index BITHON_TRACE_SPAN_IDX_TS_1_TIMESTAMP = Internal.createIndex("idx_ts_1_timestamp", BithonTraceSpan.BITHON_TRACE_SPAN, new OrderField[] { BithonTraceSpan.BITHON_TRACE_SPAN.TIMESTAMP }, false);
        public static Index BITHON_TRACE_SPAN_IDX_TS_APP_NAME = Internal.createIndex("idx_ts_app_name", BithonTraceSpan.BITHON_TRACE_SPAN, new OrderField[] { BithonTraceSpan.BITHON_TRACE_SPAN.APPNAME }, false);
        public static Index BITHON_TRACE_SPAN_IDX_TS_INSTANCENAME = Internal.createIndex("idx_ts_instanceName", BithonTraceSpan.BITHON_TRACE_SPAN, new OrderField[] { BithonTraceSpan.BITHON_TRACE_SPAN.INSTANCENAME }, false);
        public static Index BITHON_TRACE_SPAN_IDX_TS_KEY = Internal.createIndex("idx_ts_key", BithonTraceSpan.BITHON_TRACE_SPAN, new OrderField[] { BithonTraceSpan.BITHON_TRACE_SPAN.TRACEID }, false);
        public static Index BITHON_TRACE_SPAN_SUMMARY_IDX_TSS_1_TIMESTAMP = Internal.createIndex("idx_tss_1_timestamp", BithonTraceSpanSummary.BITHON_TRACE_SPAN_SUMMARY, new OrderField[] { BithonTraceSpanSummary.BITHON_TRACE_SPAN_SUMMARY.TIMESTAMP }, false);
        public static Index BITHON_TRACE_SPAN_SUMMARY_IDX_TSS_APP_NAME = Internal.createIndex("idx_tss_app_name", BithonTraceSpanSummary.BITHON_TRACE_SPAN_SUMMARY, new OrderField[] { BithonTraceSpanSummary.BITHON_TRACE_SPAN_SUMMARY.APPNAME }, false);
        public static Index BITHON_TRACE_SPAN_SUMMARY_IDX_TSS_INSTANCENAME = Internal.createIndex("idx_tss_instanceName", BithonTraceSpanSummary.BITHON_TRACE_SPAN_SUMMARY, new OrderField[] { BithonTraceSpanSummary.BITHON_TRACE_SPAN_SUMMARY.INSTANCENAME }, false);
        public static Index BITHON_TRACE_SPAN_SUMMARY_IDX_TSS_KEY = Internal.createIndex("idx_tss_key", BithonTraceSpanSummary.BITHON_TRACE_SPAN_SUMMARY, new OrderField[] { BithonTraceSpanSummary.BITHON_TRACE_SPAN_SUMMARY.TRACEID }, false);
        public static Index BITHON_TRACE_SPAN_TAG_INDEX_IDX_TSTI_TIMESTAMP = Internal.createIndex("idx_tsti_timestamp", BithonTraceSpanTagIndex.BITHON_TRACE_SPAN_TAG_INDEX, new OrderField[] { BithonTraceSpanTagIndex.BITHON_TRACE_SPAN_TAG_INDEX.TIMESTAMP }, false);
        public static Index BITHON_WEB_DASHBOARD_IDX_WEB_DASHBOARD_NAME = Internal.createIndex("idx_web_dashboard_name", BithonWebDashboard.BITHON_WEB_DASHBOARD, new OrderField[] { BithonWebDashboard.BITHON_WEB_DASHBOARD.NAME }, true);
        public static Index BITHON_WEB_DASHBOARD_IDX_WEB_DASHBOARD_TIMESTAMP = Internal.createIndex("idx_web_dashboard_timestamp", BithonWebDashboard.BITHON_WEB_DASHBOARD, new OrderField[] { BithonWebDashboard.BITHON_WEB_DASHBOARD.TIMESTAMP }, false);
    }
}
