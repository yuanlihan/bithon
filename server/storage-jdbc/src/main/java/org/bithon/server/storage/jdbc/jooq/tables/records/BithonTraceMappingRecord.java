/*
 * This file is generated by jOOQ.
 */
package org.bithon.server.storage.jdbc.jooq.tables.records;


import java.time.LocalDateTime;

import org.bithon.server.storage.jdbc.jooq.tables.BithonTraceMapping;
import org.jooq.Field;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.TableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class BithonTraceMappingRecord extends TableRecordImpl<BithonTraceMappingRecord> implements Record3<LocalDateTime, String, String> {

    private static final long serialVersionUID = 813207940;

    /**
     * Setter for <code>bithon_trace_mapping.timestamp</code>. Milli Seconds
     */
    public void setTimestamp(LocalDateTime value) {
        set(0, value);
    }

    /**
     * Getter for <code>bithon_trace_mapping.timestamp</code>. Milli Seconds
     */
    public LocalDateTime getTimestamp() {
        return (LocalDateTime) get(0);
    }

    /**
     * Setter for <code>bithon_trace_mapping.user_tx_id</code>. user side transaction id
     */
    public void setUserTxId(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>bithon_trace_mapping.user_tx_id</code>. user side transaction id
     */
    public String getUserTxId() {
        return (String) get(1);
    }

    /**
     * Setter for <code>bithon_trace_mapping.trace_id</code>. trace id in bithon
     */
    public void setTraceId(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>bithon_trace_mapping.trace_id</code>. trace id in bithon
     */
    public String getTraceId() {
        return (String) get(2);
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row3<LocalDateTime, String, String> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    @Override
    public Row3<LocalDateTime, String, String> valuesRow() {
        return (Row3) super.valuesRow();
    }

    @Override
    public Field<LocalDateTime> field1() {
        return BithonTraceMapping.BITHON_TRACE_MAPPING.TIMESTAMP;
    }

    @Override
    public Field<String> field2() {
        return BithonTraceMapping.BITHON_TRACE_MAPPING.USER_TX_ID;
    }

    @Override
    public Field<String> field3() {
        return BithonTraceMapping.BITHON_TRACE_MAPPING.TRACE_ID;
    }

    @Override
    public LocalDateTime component1() {
        return getTimestamp();
    }

    @Override
    public String component2() {
        return getUserTxId();
    }

    @Override
    public String component3() {
        return getTraceId();
    }

    @Override
    public LocalDateTime value1() {
        return getTimestamp();
    }

    @Override
    public String value2() {
        return getUserTxId();
    }

    @Override
    public String value3() {
        return getTraceId();
    }

    @Override
    public BithonTraceMappingRecord value1(LocalDateTime value) {
        setTimestamp(value);
        return this;
    }

    @Override
    public BithonTraceMappingRecord value2(String value) {
        setUserTxId(value);
        return this;
    }

    @Override
    public BithonTraceMappingRecord value3(String value) {
        setTraceId(value);
        return this;
    }

    @Override
    public BithonTraceMappingRecord values(LocalDateTime value1, String value2, String value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached BithonTraceMappingRecord
     */
    public BithonTraceMappingRecord() {
        super(BithonTraceMapping.BITHON_TRACE_MAPPING);
    }

    /**
     * Create a detached, initialised BithonTraceMappingRecord
     */
    public BithonTraceMappingRecord(LocalDateTime timestamp, String userTxId, String traceId) {
        super(BithonTraceMapping.BITHON_TRACE_MAPPING);

        set(0, timestamp);
        set(1, userTxId);
        set(2, traceId);
    }
}
