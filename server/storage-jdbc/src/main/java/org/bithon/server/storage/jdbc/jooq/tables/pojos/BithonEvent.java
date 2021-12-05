/*
 * This file is generated by jOOQ.
 */
package org.bithon.server.storage.jdbc.jooq.tables.pojos;


import java.io.Serializable;
import java.sql.Timestamp;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class BithonEvent implements Serializable {

    private static final long serialVersionUID = -1726595684;

    private Timestamp timestamp;
    private String    appname;
    private String    instancename;
    private String    type;
    private String    arguments;

    public BithonEvent() {}

    public BithonEvent(BithonEvent value) {
        this.timestamp = value.timestamp;
        this.appname = value.appname;
        this.instancename = value.instancename;
        this.type = value.type;
        this.arguments = value.arguments;
    }

    public BithonEvent(
        Timestamp timestamp,
        String    appname,
        String    instancename,
        String    type,
        String    arguments
    ) {
        this.timestamp = timestamp;
        this.appname = appname;
        this.instancename = instancename;
        this.type = type;
        this.arguments = arguments;
    }

    public Timestamp getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getAppname() {
        return this.appname;
    }

    public void setAppname(String appname) {
        this.appname = appname;
    }

    public String getInstancename() {
        return this.instancename;
    }

    public void setInstancename(String instancename) {
        this.instancename = instancename;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getArguments() {
        return this.arguments;
    }

    public void setArguments(String arguments) {
        this.arguments = arguments;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("BithonEvent (");

        sb.append(timestamp);
        sb.append(", ").append(appname);
        sb.append(", ").append(instancename);
        sb.append(", ").append(type);
        sb.append(", ").append(arguments);

        sb.append(")");
        return sb.toString();
    }
}
