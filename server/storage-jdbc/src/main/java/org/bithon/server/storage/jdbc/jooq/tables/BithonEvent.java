/*
 * This file is generated by jOOQ.
 */
package org.bithon.server.storage.jdbc.jooq.tables;


import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import org.bithon.server.storage.jdbc.jooq.DefaultSchema;
import org.bithon.server.storage.jdbc.jooq.Indexes;
import org.bithon.server.storage.jdbc.jooq.tables.records.BithonEventRecord;
import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row5;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class BithonEvent extends TableImpl<BithonEventRecord> {

    private static final long serialVersionUID = 2050969602;

    /**
     * The reference instance of <code>bithon_event</code>
     */
    public static final BithonEvent BITHON_EVENT = new BithonEvent();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<BithonEventRecord> getRecordType() {
        return BithonEventRecord.class;
    }

    /**
     * The column <code>bithon_event.timestamp</code>. reported Timestamp
     */
    public final TableField<BithonEventRecord, Timestamp> TIMESTAMP = createField(DSL.name("timestamp"), org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "reported Timestamp");

    /**
     * The column <code>bithon_event.appName</code>.
     */
    public final TableField<BithonEventRecord, String> APPNAME = createField(DSL.name("appName"), org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false), this, "");

    /**
     * The column <code>bithon_event.instanceName</code>.
     */
    public final TableField<BithonEventRecord, String> INSTANCENAME = createField(DSL.name("instanceName"), org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false), this, "");

    /**
     * The column <code>bithon_event.type</code>. type of event
     */
    public final TableField<BithonEventRecord, String> TYPE = createField(DSL.name("type"), org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false), this, "type of event");

    /**
     * The column <code>bithon_event.arguments</code>. JSON formatted Map&lt;String, String&gt;
     */
    public final TableField<BithonEventRecord, String> ARGUMENTS = createField(DSL.name("arguments"), org.jooq.impl.SQLDataType.CLOB, this, "JSON formatted Map<String, String>");

    /**
     * Create a <code>bithon_event</code> table reference
     */
    public BithonEvent() {
        this(DSL.name("bithon_event"), null);
    }

    /**
     * Create an aliased <code>bithon_event</code> table reference
     */
    public BithonEvent(String alias) {
        this(DSL.name(alias), BITHON_EVENT);
    }

    /**
     * Create an aliased <code>bithon_event</code> table reference
     */
    public BithonEvent(Name alias) {
        this(alias, BITHON_EVENT);
    }

    private BithonEvent(Name alias, Table<BithonEventRecord> aliased) {
        this(alias, aliased, null);
    }

    private BithonEvent(Name alias, Table<BithonEventRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> BithonEvent(Table<O> child, ForeignKey<O, BithonEventRecord> key) {
        super(child, key, BITHON_EVENT);
    }

    @Override
    public Schema getSchema() {
        return DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.BITHON_EVENT_IDX_EVENT_1_TIMESTAMP, Indexes.BITHON_EVENT_IDX_EVENT_APPNAME, Indexes.BITHON_EVENT_IDX_EVENT_INSTANCENAME, Indexes.BITHON_EVENT_IDX_EVENT_TYPE);
    }

    @Override
    public BithonEvent as(String alias) {
        return new BithonEvent(DSL.name(alias), this);
    }

    @Override
    public BithonEvent as(Name alias) {
        return new BithonEvent(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public BithonEvent rename(String name) {
        return new BithonEvent(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public BithonEvent rename(Name name) {
        return new BithonEvent(name, null);
    }

    // -------------------------------------------------------------------------
    // Row5 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row5<Timestamp, String, String, String, String> fieldsRow() {
        return (Row5) super.fieldsRow();
    }
}
