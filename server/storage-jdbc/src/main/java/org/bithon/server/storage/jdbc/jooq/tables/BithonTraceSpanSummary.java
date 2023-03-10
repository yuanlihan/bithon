/*
 * This file is generated by jOOQ.
 */
package org.bithon.server.storage.jdbc.jooq.tables;


import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.bithon.server.storage.jdbc.jooq.DefaultSchema;
import org.bithon.server.storage.jdbc.jooq.Indexes;
import org.bithon.server.storage.jdbc.jooq.tables.records.BithonTraceSpanSummaryRecord;
import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row16;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class BithonTraceSpanSummary extends TableImpl<BithonTraceSpanSummaryRecord> {

    private static final long serialVersionUID = -1208433690;

    /**
     * The reference instance of <code>bithon_trace_span_summary</code>
     */
    public static final BithonTraceSpanSummary BITHON_TRACE_SPAN_SUMMARY = new BithonTraceSpanSummary();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<BithonTraceSpanSummaryRecord> getRecordType() {
        return BithonTraceSpanSummaryRecord.class;
    }

    /**
     * The column <code>bithon_trace_span_summary.timestamp</code>. Milli Seconds
     */
    public final TableField<BithonTraceSpanSummaryRecord, LocalDateTime> TIMESTAMP = createField(DSL.name("timestamp"), org.jooq.impl.SQLDataType.LOCALDATETIME.nullable(false), this, "Milli Seconds");

    /**
     * The column <code>bithon_trace_span_summary.appName</code>.
     */
    public final TableField<BithonTraceSpanSummaryRecord, String> APPNAME = createField(DSL.name("appName"), org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false), this, "");

    /**
     * The column <code>bithon_trace_span_summary.instanceName</code>.
     */
    public final TableField<BithonTraceSpanSummaryRecord, String> INSTANCENAME = createField(DSL.name("instanceName"), org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false), this, "");

    /**
     * The column <code>bithon_trace_span_summary.name</code>.
     */
    public final TableField<BithonTraceSpanSummaryRecord, String> NAME = createField(DSL.name("name"), org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false), this, "");

    /**
     * The column <code>bithon_trace_span_summary.clazz</code>.
     */
    public final TableField<BithonTraceSpanSummaryRecord, String> CLAZZ = createField(DSL.name("clazz"), org.jooq.impl.SQLDataType.VARCHAR(128).nullable(false), this, "");

    /**
     * The column <code>bithon_trace_span_summary.method</code>.
     */
    public final TableField<BithonTraceSpanSummaryRecord, String> METHOD = createField(DSL.name("method"), org.jooq.impl.SQLDataType.VARCHAR(128).nullable(false), this, "");

    /**
     * The column <code>bithon_trace_span_summary.traceId</code>.
     */
    public final TableField<BithonTraceSpanSummaryRecord, String> TRACEID = createField(DSL.name("traceId"), org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false), this, "");

    /**
     * The column <code>bithon_trace_span_summary.spanId</code>.
     */
    public final TableField<BithonTraceSpanSummaryRecord, String> SPANID = createField(DSL.name("spanId"), org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false), this, "");

    /**
     * The column <code>bithon_trace_span_summary.parentSpanId</code>.
     */
    public final TableField<BithonTraceSpanSummaryRecord, String> PARENTSPANID = createField(DSL.name("parentSpanId"), org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false), this, "");

    /**
     * The column <code>bithon_trace_span_summary.kind</code>.
     */
    public final TableField<BithonTraceSpanSummaryRecord, String> KIND = createField(DSL.name("kind"), org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false), this, "");

    /**
     * The column <code>bithon_trace_span_summary.costTimeMs</code>. Milli Second
     */
    public final TableField<BithonTraceSpanSummaryRecord, Long> COSTTIMEMS = createField(DSL.name("costTimeMs"), org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "Milli Second");

    /**
     * The column <code>bithon_trace_span_summary.startTimeUs</code>. Micro Second
     */
    public final TableField<BithonTraceSpanSummaryRecord, Long> STARTTIMEUS = createField(DSL.name("startTimeUs"), org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "Micro Second");

    /**
     * The column <code>bithon_trace_span_summary.endTimeUs</code>. Micro Second
     */
    public final TableField<BithonTraceSpanSummaryRecord, Long> ENDTIMEUS = createField(DSL.name("endTimeUs"), org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "Micro Second");

    /**
     * The column <code>bithon_trace_span_summary.tags</code>.
     */
    public final TableField<BithonTraceSpanSummaryRecord, String> TAGS = createField(DSL.name("tags"), org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>bithon_trace_span_summary.normalizedUrl</code>.
     */
    public final TableField<BithonTraceSpanSummaryRecord, String> NORMALIZEDURL = createField(DSL.name("normalizedUrl"), org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>bithon_trace_span_summary.status</code>.
     */
    public final TableField<BithonTraceSpanSummaryRecord, String> STATUS = createField(DSL.name("status"), org.jooq.impl.SQLDataType.VARCHAR(32).nullable(false), this, "");

    /**
     * Create a <code>bithon_trace_span_summary</code> table reference
     */
    public BithonTraceSpanSummary() {
        this(DSL.name("bithon_trace_span_summary"), null);
    }

    /**
     * Create an aliased <code>bithon_trace_span_summary</code> table reference
     */
    public BithonTraceSpanSummary(String alias) {
        this(DSL.name(alias), BITHON_TRACE_SPAN_SUMMARY);
    }

    /**
     * Create an aliased <code>bithon_trace_span_summary</code> table reference
     */
    public BithonTraceSpanSummary(Name alias) {
        this(alias, BITHON_TRACE_SPAN_SUMMARY);
    }

    private BithonTraceSpanSummary(Name alias, Table<BithonTraceSpanSummaryRecord> aliased) {
        this(alias, aliased, null);
    }

    private BithonTraceSpanSummary(Name alias, Table<BithonTraceSpanSummaryRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> BithonTraceSpanSummary(Table<O> child, ForeignKey<O, BithonTraceSpanSummaryRecord> key) {
        super(child, key, BITHON_TRACE_SPAN_SUMMARY);
    }

    @Override
    public Schema getSchema() {
        return DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.BITHON_TRACE_SPAN_SUMMARY_IDX_TSS_1_TIMESTAMP, Indexes.BITHON_TRACE_SPAN_SUMMARY_IDX_TSS_APP_NAME, Indexes.BITHON_TRACE_SPAN_SUMMARY_IDX_TSS_INSTANCENAME, Indexes.BITHON_TRACE_SPAN_SUMMARY_IDX_TSS_KEY);
    }

    @Override
    public BithonTraceSpanSummary as(String alias) {
        return new BithonTraceSpanSummary(DSL.name(alias), this);
    }

    @Override
    public BithonTraceSpanSummary as(Name alias) {
        return new BithonTraceSpanSummary(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public BithonTraceSpanSummary rename(String name) {
        return new BithonTraceSpanSummary(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public BithonTraceSpanSummary rename(Name name) {
        return new BithonTraceSpanSummary(name, null);
    }

    // -------------------------------------------------------------------------
    // Row16 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row16<LocalDateTime, String, String, String, String, String, String, String, String, String, Long, Long, Long, String, String, String> fieldsRow() {
        return (Row16) super.fieldsRow();
    }
}
