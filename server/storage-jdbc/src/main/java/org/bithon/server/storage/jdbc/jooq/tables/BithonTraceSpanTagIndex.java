/*
 * This file is generated by jOOQ.
 */
package org.bithon.server.storage.jdbc.jooq.tables;


import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.bithon.server.storage.jdbc.jooq.DefaultSchema;
import org.bithon.server.storage.jdbc.jooq.Indexes;
import org.bithon.server.storage.jdbc.jooq.tables.records.BithonTraceSpanTagIndexRecord;
import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row18;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class BithonTraceSpanTagIndex extends TableImpl<BithonTraceSpanTagIndexRecord> {

    private static final long serialVersionUID = -869643258;

    /**
     * The reference instance of <code>bithon_trace_span_tag_index</code>
     */
    public static final BithonTraceSpanTagIndex BITHON_TRACE_SPAN_TAG_INDEX = new BithonTraceSpanTagIndex();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<BithonTraceSpanTagIndexRecord> getRecordType() {
        return BithonTraceSpanTagIndexRecord.class;
    }

    /**
     * The column <code>bithon_trace_span_tag_index.timestamp</code>. Milli Seconds
     */
    public final TableField<BithonTraceSpanTagIndexRecord, LocalDateTime> TIMESTAMP = createField(DSL.name("timestamp"), org.jooq.impl.SQLDataType.LOCALDATETIME.nullable(false), this, "Milli Seconds");

    /**
     * The column <code>bithon_trace_span_tag_index.f1</code>. tag value1
     */
    public final TableField<BithonTraceSpanTagIndexRecord, String> F1 = createField(DSL.name("f1"), org.jooq.impl.SQLDataType.VARCHAR(64).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "tag value1");

    /**
     * The column <code>bithon_trace_span_tag_index.f2</code>. tag value2
     */
    public final TableField<BithonTraceSpanTagIndexRecord, String> F2 = createField(DSL.name("f2"), org.jooq.impl.SQLDataType.VARCHAR(64).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "tag value2");

    /**
     * The column <code>bithon_trace_span_tag_index.f3</code>. tag value3
     */
    public final TableField<BithonTraceSpanTagIndexRecord, String> F3 = createField(DSL.name("f3"), org.jooq.impl.SQLDataType.VARCHAR(64).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "tag value3");

    /**
     * The column <code>bithon_trace_span_tag_index.f4</code>. tag value4
     */
    public final TableField<BithonTraceSpanTagIndexRecord, String> F4 = createField(DSL.name("f4"), org.jooq.impl.SQLDataType.VARCHAR(64).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "tag value4");

    /**
     * The column <code>bithon_trace_span_tag_index.f5</code>. tag value5
     */
    public final TableField<BithonTraceSpanTagIndexRecord, String> F5 = createField(DSL.name("f5"), org.jooq.impl.SQLDataType.VARCHAR(64).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "tag value5");

    /**
     * The column <code>bithon_trace_span_tag_index.f6</code>. tag value6
     */
    public final TableField<BithonTraceSpanTagIndexRecord, String> F6 = createField(DSL.name("f6"), org.jooq.impl.SQLDataType.VARCHAR(64).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "tag value6");

    /**
     * The column <code>bithon_trace_span_tag_index.f7</code>. tag value7
     */
    public final TableField<BithonTraceSpanTagIndexRecord, String> F7 = createField(DSL.name("f7"), org.jooq.impl.SQLDataType.VARCHAR(64).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "tag value7");

    /**
     * The column <code>bithon_trace_span_tag_index.f8</code>. tag value8
     */
    public final TableField<BithonTraceSpanTagIndexRecord, String> F8 = createField(DSL.name("f8"), org.jooq.impl.SQLDataType.VARCHAR(64).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "tag value8");

    /**
     * The column <code>bithon_trace_span_tag_index.f9</code>. tag value9
     */
    public final TableField<BithonTraceSpanTagIndexRecord, String> F9 = createField(DSL.name("f9"), org.jooq.impl.SQLDataType.VARCHAR(64).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "tag value9");

    /**
     * The column <code>bithon_trace_span_tag_index.f10</code>. tag value10
     */
    public final TableField<BithonTraceSpanTagIndexRecord, String> F10 = createField(DSL.name("f10"), org.jooq.impl.SQLDataType.VARCHAR(64).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "tag value10");

    /**
     * The column <code>bithon_trace_span_tag_index.f11</code>. tag value11
     */
    public final TableField<BithonTraceSpanTagIndexRecord, String> F11 = createField(DSL.name("f11"), org.jooq.impl.SQLDataType.VARCHAR(64).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "tag value11");

    /**
     * The column <code>bithon_trace_span_tag_index.f12</code>. tag value12
     */
    public final TableField<BithonTraceSpanTagIndexRecord, String> F12 = createField(DSL.name("f12"), org.jooq.impl.SQLDataType.VARCHAR(64).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "tag value12");

    /**
     * The column <code>bithon_trace_span_tag_index.f13</code>. tag value13
     */
    public final TableField<BithonTraceSpanTagIndexRecord, String> F13 = createField(DSL.name("f13"), org.jooq.impl.SQLDataType.VARCHAR(64).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "tag value13");

    /**
     * The column <code>bithon_trace_span_tag_index.f14</code>. tag value14
     */
    public final TableField<BithonTraceSpanTagIndexRecord, String> F14 = createField(DSL.name("f14"), org.jooq.impl.SQLDataType.VARCHAR(64).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "tag value14");

    /**
     * The column <code>bithon_trace_span_tag_index.f15</code>. tag value15
     */
    public final TableField<BithonTraceSpanTagIndexRecord, String> F15 = createField(DSL.name("f15"), org.jooq.impl.SQLDataType.VARCHAR(64).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "tag value15");

    /**
     * The column <code>bithon_trace_span_tag_index.f16</code>. tag value16
     */
    public final TableField<BithonTraceSpanTagIndexRecord, String> F16 = createField(DSL.name("f16"), org.jooq.impl.SQLDataType.VARCHAR(64).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "tag value16");

    /**
     * The column <code>bithon_trace_span_tag_index.traceId</code>.
     */
    public final TableField<BithonTraceSpanTagIndexRecord, String> TRACEID = createField(DSL.name("traceId"), org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false), this, "");

    /**
     * Create a <code>bithon_trace_span_tag_index</code> table reference
     */
    public BithonTraceSpanTagIndex() {
        this(DSL.name("bithon_trace_span_tag_index"), null);
    }

    /**
     * Create an aliased <code>bithon_trace_span_tag_index</code> table reference
     */
    public BithonTraceSpanTagIndex(String alias) {
        this(DSL.name(alias), BITHON_TRACE_SPAN_TAG_INDEX);
    }

    /**
     * Create an aliased <code>bithon_trace_span_tag_index</code> table reference
     */
    public BithonTraceSpanTagIndex(Name alias) {
        this(alias, BITHON_TRACE_SPAN_TAG_INDEX);
    }

    private BithonTraceSpanTagIndex(Name alias, Table<BithonTraceSpanTagIndexRecord> aliased) {
        this(alias, aliased, null);
    }

    private BithonTraceSpanTagIndex(Name alias, Table<BithonTraceSpanTagIndexRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> BithonTraceSpanTagIndex(Table<O> child, ForeignKey<O, BithonTraceSpanTagIndexRecord> key) {
        super(child, key, BITHON_TRACE_SPAN_TAG_INDEX);
    }

    @Override
    public Schema getSchema() {
        return DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.BITHON_TRACE_SPAN_TAG_INDEX_IDX_TSTI_TIMESTAMP);
    }

    @Override
    public BithonTraceSpanTagIndex as(String alias) {
        return new BithonTraceSpanTagIndex(DSL.name(alias), this);
    }

    @Override
    public BithonTraceSpanTagIndex as(Name alias) {
        return new BithonTraceSpanTagIndex(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public BithonTraceSpanTagIndex rename(String name) {
        return new BithonTraceSpanTagIndex(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public BithonTraceSpanTagIndex rename(Name name) {
        return new BithonTraceSpanTagIndex(name, null);
    }

    // -------------------------------------------------------------------------
    // Row18 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row18<LocalDateTime, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String> fieldsRow() {
        return (Row18) super.fieldsRow();
    }
}
