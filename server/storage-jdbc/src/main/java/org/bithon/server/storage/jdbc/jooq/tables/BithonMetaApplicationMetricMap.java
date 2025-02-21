/*
 * This file is generated by jOOQ.
 */
package org.bithon.server.storage.jdbc.jooq.tables;


import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.bithon.server.storage.jdbc.jooq.DefaultSchema;
import org.bithon.server.storage.jdbc.jooq.Indexes;
import org.bithon.server.storage.jdbc.jooq.tables.records.BithonMetaApplicationMetricMapRecord;
import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row3;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class BithonMetaApplicationMetricMap extends TableImpl<BithonMetaApplicationMetricMapRecord> {

    private static final long serialVersionUID = 561106419;

    /**
     * The reference instance of <code>bithon_meta_application_metric_map</code>
     */
    public static final BithonMetaApplicationMetricMap BITHON_META_APPLICATION_METRIC_MAP = new BithonMetaApplicationMetricMap();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<BithonMetaApplicationMetricMapRecord> getRecordType() {
        return BithonMetaApplicationMetricMapRecord.class;
    }

    /**
     * The column <code>bithon_meta_application_metric_map.timestamp</code>. update time
     */
    public final TableField<BithonMetaApplicationMetricMapRecord, LocalDateTime> TIMESTAMP = createField(DSL.name("timestamp"), org.jooq.impl.SQLDataType.LOCALDATETIME.nullable(false), this, "update time");

    /**
     * The column <code>bithon_meta_application_metric_map.application</code>.
     */
    public final TableField<BithonMetaApplicationMetricMapRecord, String> APPLICATION = createField(DSL.name("application"), org.jooq.impl.SQLDataType.VARCHAR(128).nullable(false), this, "");

    /**
     * The column <code>bithon_meta_application_metric_map.schema</code>. name in bithon_metric_schema
     */
    public final TableField<BithonMetaApplicationMetricMapRecord, String> SCHEMA = createField(DSL.name("schema"), org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false), this, "name in bithon_metric_schema");

    /**
     * Create a <code>bithon_meta_application_metric_map</code> table reference
     */
    public BithonMetaApplicationMetricMap() {
        this(DSL.name("bithon_meta_application_metric_map"), null);
    }

    /**
     * Create an aliased <code>bithon_meta_application_metric_map</code> table reference
     */
    public BithonMetaApplicationMetricMap(String alias) {
        this(DSL.name(alias), BITHON_META_APPLICATION_METRIC_MAP);
    }

    /**
     * Create an aliased <code>bithon_meta_application_metric_map</code> table reference
     */
    public BithonMetaApplicationMetricMap(Name alias) {
        this(alias, BITHON_META_APPLICATION_METRIC_MAP);
    }

    private BithonMetaApplicationMetricMap(Name alias, Table<BithonMetaApplicationMetricMapRecord> aliased) {
        this(alias, aliased, null);
    }

    private BithonMetaApplicationMetricMap(Name alias, Table<BithonMetaApplicationMetricMapRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> BithonMetaApplicationMetricMap(Table<O> child, ForeignKey<O, BithonMetaApplicationMetricMapRecord> key) {
        super(child, key, BITHON_META_APPLICATION_METRIC_MAP);
    }

    @Override
    public Schema getSchema() {
        return DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.BITHON_META_APPLICATION_METRIC_MAP_IDX_META_APPLICATION_METRIC_MAP, Indexes.BITHON_META_APPLICATION_METRIC_MAP_IDX_META_APPLICATION_METRIC_MAP_TIMESTAMP);
    }

    @Override
    public BithonMetaApplicationMetricMap as(String alias) {
        return new BithonMetaApplicationMetricMap(DSL.name(alias), this);
    }

    @Override
    public BithonMetaApplicationMetricMap as(Name alias) {
        return new BithonMetaApplicationMetricMap(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public BithonMetaApplicationMetricMap rename(String name) {
        return new BithonMetaApplicationMetricMap(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public BithonMetaApplicationMetricMap rename(Name name) {
        return new BithonMetaApplicationMetricMap(name, null);
    }

    // -------------------------------------------------------------------------
    // Row3 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row3<LocalDateTime, String, String> fieldsRow() {
        return (Row3) super.fieldsRow();
    }
}
