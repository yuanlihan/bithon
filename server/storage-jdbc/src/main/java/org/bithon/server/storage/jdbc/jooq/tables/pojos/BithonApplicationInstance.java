/*
 * This file is generated by jOOQ.
 */
package org.bithon.server.storage.jdbc.jooq.tables.pojos;


import java.io.Serializable;
import java.sql.Timestamp;


/**
 * 应用
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class BithonApplicationInstance implements Serializable {

    private static final long serialVersionUID = 1556528010;

    private Timestamp timestamp;
    private String    appname;
    private String    apptype;
    private String    instancename;

    public BithonApplicationInstance() {}

    public BithonApplicationInstance(BithonApplicationInstance value) {
        this.timestamp = value.timestamp;
        this.appname = value.appname;
        this.apptype = value.apptype;
        this.instancename = value.instancename;
    }

    public BithonApplicationInstance(
        Timestamp timestamp,
        String    appname,
        String    apptype,
        String    instancename
    ) {
        this.timestamp = timestamp;
        this.appname = appname;
        this.apptype = apptype;
        this.instancename = instancename;
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

    public String getApptype() {
        return this.apptype;
    }

    public void setApptype(String apptype) {
        this.apptype = apptype;
    }

    public String getInstancename() {
        return this.instancename;
    }

    public void setInstancename(String instancename) {
        this.instancename = instancename;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("BithonApplicationInstance (");

        sb.append(timestamp);
        sb.append(", ").append(appname);
        sb.append(", ").append(apptype);
        sb.append(", ").append(instancename);

        sb.append(")");
        return sb.toString();
    }
}
