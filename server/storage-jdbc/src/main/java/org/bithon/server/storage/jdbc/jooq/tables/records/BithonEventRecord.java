/*
 * This file is generated by jOOQ.
 */
package org.bithon.server.storage.jdbc.jooq.tables.records;


import java.time.LocalDateTime;

import org.bithon.server.storage.jdbc.jooq.tables.BithonEvent;
import org.jooq.Field;
import org.jooq.Record5;
import org.jooq.Row5;
import org.jooq.impl.TableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class BithonEventRecord extends TableRecordImpl<BithonEventRecord> implements Record5<LocalDateTime, String, String, String, String> {

    private static final long serialVersionUID = -1930551035;

    /**
     * Setter for <code>bithon_event.timestamp</code>. reported Timestamp
     */
    public void setTimestamp(LocalDateTime value) {
        set(0, value);
    }

    /**
     * Getter for <code>bithon_event.timestamp</code>. reported Timestamp
     */
    public LocalDateTime getTimestamp() {
        return (LocalDateTime) get(0);
    }

    /**
     * Setter for <code>bithon_event.appName</code>.
     */
    public void setAppname(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>bithon_event.appName</code>.
     */
    public String getAppname() {
        return (String) get(1);
    }

    /**
     * Setter for <code>bithon_event.instanceName</code>.
     */
    public void setInstancename(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>bithon_event.instanceName</code>.
     */
    public String getInstancename() {
        return (String) get(2);
    }

    /**
     * Setter for <code>bithon_event.type</code>. type of event
     */
    public void setType(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>bithon_event.type</code>. type of event
     */
    public String getType() {
        return (String) get(3);
    }

    /**
     * Setter for <code>bithon_event.arguments</code>. JSON formatted Map&lt;String, String&gt;
     */
    public void setArguments(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>bithon_event.arguments</code>. JSON formatted Map&lt;String, String&gt;
     */
    public String getArguments() {
        return (String) get(4);
    }

    // -------------------------------------------------------------------------
    // Record5 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row5<LocalDateTime, String, String, String, String> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    @Override
    public Row5<LocalDateTime, String, String, String, String> valuesRow() {
        return (Row5) super.valuesRow();
    }

    @Override
    public Field<LocalDateTime> field1() {
        return BithonEvent.BITHON_EVENT.TIMESTAMP;
    }

    @Override
    public Field<String> field2() {
        return BithonEvent.BITHON_EVENT.APPNAME;
    }

    @Override
    public Field<String> field3() {
        return BithonEvent.BITHON_EVENT.INSTANCENAME;
    }

    @Override
    public Field<String> field4() {
        return BithonEvent.BITHON_EVENT.TYPE;
    }

    @Override
    public Field<String> field5() {
        return BithonEvent.BITHON_EVENT.ARGUMENTS;
    }

    @Override
    public LocalDateTime component1() {
        return getTimestamp();
    }

    @Override
    public String component2() {
        return getAppname();
    }

    @Override
    public String component3() {
        return getInstancename();
    }

    @Override
    public String component4() {
        return getType();
    }

    @Override
    public String component5() {
        return getArguments();
    }

    @Override
    public LocalDateTime value1() {
        return getTimestamp();
    }

    @Override
    public String value2() {
        return getAppname();
    }

    @Override
    public String value3() {
        return getInstancename();
    }

    @Override
    public String value4() {
        return getType();
    }

    @Override
    public String value5() {
        return getArguments();
    }

    @Override
    public BithonEventRecord value1(LocalDateTime value) {
        setTimestamp(value);
        return this;
    }

    @Override
    public BithonEventRecord value2(String value) {
        setAppname(value);
        return this;
    }

    @Override
    public BithonEventRecord value3(String value) {
        setInstancename(value);
        return this;
    }

    @Override
    public BithonEventRecord value4(String value) {
        setType(value);
        return this;
    }

    @Override
    public BithonEventRecord value5(String value) {
        setArguments(value);
        return this;
    }

    @Override
    public BithonEventRecord values(LocalDateTime value1, String value2, String value3, String value4, String value5) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached BithonEventRecord
     */
    public BithonEventRecord() {
        super(BithonEvent.BITHON_EVENT);
    }

    /**
     * Create a detached, initialised BithonEventRecord
     */
    public BithonEventRecord(LocalDateTime timestamp, String appname, String instancename, String type, String arguments) {
        super(BithonEvent.BITHON_EVENT);

        set(0, timestamp);
        set(1, appname);
        set(2, instancename);
        set(3, type);
        set(4, arguments);
    }
}
