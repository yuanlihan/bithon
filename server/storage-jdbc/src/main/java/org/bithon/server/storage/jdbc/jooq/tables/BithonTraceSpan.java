/*
 * This file is generated by jOOQ.
 */
package org.bithon.server.storage.jdbc.jooq.tables;


import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.bithon.server.storage.jdbc.jooq.DefaultSchema;
import org.bithon.server.storage.jdbc.jooq.Indexes;
import org.bithon.server.storage.jdbc.jooq.tables.records.BithonTraceSpanRecord;
import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row17;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class BithonTraceSpan extends TableImpl<BithonTraceSpanRecord> {

    private static final long serialVersionUID = -1225452051;

    /**
     * The reference instance of <code>bithon_trace_span</code>
     */
    public static final BithonTraceSpan BITHON_TRACE_SPAN = new BithonTraceSpan();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<BithonTraceSpanRecord> getRecordType() {
        return BithonTraceSpanRecord.class;
    }

    /**
     * The column <code>bithon_trace_span.timestamp</code>. Milli Seconds
     */
    public final TableField<BithonTraceSpanRecord, LocalDateTime> TIMESTAMP = createField(DSL.name("timestamp"), org.jooq.impl.SQLDataType.LOCALDATETIME.nullable(false), this, "Milli Seconds");

    /**
     * The column <code>bithon_trace_span.appName</code>.
     */
    public final TableField<BithonTraceSpanRecord, String> APPNAME = createField(DSL.name("appName"), org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false), this, "");

    /**
     * The column <code>bithon_trace_span.instanceName</code>.
     */
    public final TableField<BithonTraceSpanRecord, String> INSTANCENAME = createField(DSL.name("instanceName"), org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false), this, "");

    /**
     * The column <code>bithon_trace_span.name</code>.
     */
    public final TableField<BithonTraceSpanRecord, String> NAME = createField(DSL.name("name"), org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false), this, "");

    /**
     * The column <code>bithon_trace_span.clazz</code>.
     */
    public final TableField<BithonTraceSpanRecord, String> CLAZZ = createField(DSL.name("clazz"), org.jooq.impl.SQLDataType.VARCHAR(128).nullable(false), this, "");

    /**
     * The column <code>bithon_trace_span.method</code>.
     */
    public final TableField<BithonTraceSpanRecord, String> METHOD = createField(DSL.name("method"), org.jooq.impl.SQLDataType.VARCHAR(128).nullable(false), this, "");

    /**
     * The column <code>bithon_trace_span.traceId</code>.
     */
    public final TableField<BithonTraceSpanRecord, String> TRACEID = createField(DSL.name("traceId"), org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false), this, "");

    /**
     * The column <code>bithon_trace_span.spanId</code>.
     */
    public final TableField<BithonTraceSpanRecord, String> SPANID = createField(DSL.name("spanId"), org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false), this, "");

    /**
     * The column <code>bithon_trace_span.parentSpanId</code>.
     */
    public final TableField<BithonTraceSpanRecord, String> PARENTSPANID = createField(DSL.name("parentSpanId"), org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false), this, "");

    /**
     * The column <code>bithon_trace_span.kind</code>.
     */
    public final TableField<BithonTraceSpanRecord, String> KIND = createField(DSL.name("kind"), org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false), this, "");

    /**
     * The column <code>bithon_trace_span.costTimeMs</code>. Micro Second, suffix is wrong
     */
    public final TableField<BithonTraceSpanRecord, Long> COSTTIMEMS = createField(DSL.name("costTimeMs"), org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "Micro Second, suffix is wrong");

    /**
     * The column <code>bithon_trace_span.startTimeUs</code>. Micro Second
     */
    public final TableField<BithonTraceSpanRecord, Long> STARTTIMEUS = createField(DSL.name("startTimeUs"), org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "Micro Second");

    /**
     * The column <code>bithon_trace_span.endTimeUs</code>. Micro Second
     */
    public final TableField<BithonTraceSpanRecord, Long> ENDTIMEUS = createField(DSL.name("endTimeUs"), org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "Micro Second");

    /**
     * The column <code>bithon_trace_span.tags</code>. Kept for compatibility
     */
    public final TableField<BithonTraceSpanRecord, String> TAGS = createField(DSL.name("tags"), org.jooq.impl.SQLDataType.CLOB, this, "Kept for compatibility");

    /**
     * The column <code>bithon_trace_span.attributes</code>.
     */
    public final TableField<BithonTraceSpanRecord, String> ATTRIBUTES = createField(DSL.name("attributes"), org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>bithon_trace_span.normalizedUrl</code>.
     */
    public final TableField<BithonTraceSpanRecord, String> NORMALIZEDURL = createField(DSL.name("normalizedUrl"), org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>bithon_trace_span.status</code>.
     */
    public final TableField<BithonTraceSpanRecord, String> STATUS = createField(DSL.name("status"), org.jooq.impl.SQLDataType.VARCHAR(32).nullable(false), this, "");

    /**
     * Create a <code>bithon_trace_span</code> table reference
     */
    public BithonTraceSpan() {
        this(DSL.name("bithon_trace_span"), null);
    }

    /**
     * Create an aliased <code>bithon_trace_span</code> table reference
     */
    public BithonTraceSpan(String alias) {
        this(DSL.name(alias), BITHON_TRACE_SPAN);
    }

    /**
     * Create an aliased <code>bithon_trace_span</code> table reference
     */
    public BithonTraceSpan(Name alias) {
        this(alias, BITHON_TRACE_SPAN);
    }

    private BithonTraceSpan(Name alias, Table<BithonTraceSpanRecord> aliased) {
        this(alias, aliased, null);
    }

    private BithonTraceSpan(Name alias, Table<BithonTraceSpanRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> BithonTraceSpan(Table<O> child, ForeignKey<O, BithonTraceSpanRecord> key) {
        super(child, key, BITHON_TRACE_SPAN);
    }

    @Override
    public Schema getSchema() {
        return DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.BITHON_TRACE_SPAN_IDX_TS_1_TRACEID, Indexes.BITHON_TRACE_SPAN_IDX_TS_2_TIMESTAMP, Indexes.BITHON_TRACE_SPAN_IDX_TS_3_APP_NAME, Indexes.BITHON_TRACE_SPAN_IDX_TS_4_INSTANCENAME, Indexes.BITHON_TRACE_SPAN_IDX_TS_5_NAME);
    }

    @Override
    public BithonTraceSpan as(String alias) {
        return new BithonTraceSpan(DSL.name(alias), this);
    }

    @Override
    public BithonTraceSpan as(Name alias) {
        return new BithonTraceSpan(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public BithonTraceSpan rename(String name) {
        return new BithonTraceSpan(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public BithonTraceSpan rename(Name name) {
        return new BithonTraceSpan(name, null);
    }

    // -------------------------------------------------------------------------
    // Row17 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row17<LocalDateTime, String, String, String, String, String, String, String, String, String, Long, Long, Long, String, String, String, String> fieldsRow() {
        return (Row17) super.fieldsRow();
    }
}
