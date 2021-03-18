/**
 * Autogenerated by Thrift Compiler (0.14.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.sbss.bithon.agent.rpc.thrift.service.metric.message;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
/**
 * *********************** Web Server Metrics *****************************
 */
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.14.1)", date = "2021-03-18")
public class WebServerMetricMessage implements org.apache.thrift.TBase<WebServerMetricMessage, WebServerMetricMessage._Fields>, java.io.Serializable, Cloneable, Comparable<WebServerMetricMessage> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("WebServerMetricMessage");

  private static final org.apache.thrift.protocol.TField INTERVAL_FIELD_DESC = new org.apache.thrift.protocol.TField("interval", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField TIMESTAMP_FIELD_DESC = new org.apache.thrift.protocol.TField("timestamp", org.apache.thrift.protocol.TType.I64, (short)2);
  private static final org.apache.thrift.protocol.TField TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField("type", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField CONNECTION_COUNT_FIELD_DESC = new org.apache.thrift.protocol.TField("connectionCount", org.apache.thrift.protocol.TType.I64, (short)4);
  private static final org.apache.thrift.protocol.TField MAX_CONNECTIONS_FIELD_DESC = new org.apache.thrift.protocol.TField("maxConnections", org.apache.thrift.protocol.TType.I64, (short)5);
  private static final org.apache.thrift.protocol.TField ACTIVE_THREADS_FIELD_DESC = new org.apache.thrift.protocol.TField("activeThreads", org.apache.thrift.protocol.TType.I64, (short)6);
  private static final org.apache.thrift.protocol.TField MAX_THREADS_FIELD_DESC = new org.apache.thrift.protocol.TField("maxThreads", org.apache.thrift.protocol.TType.I64, (short)7);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new WebServerMetricMessageStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new WebServerMetricMessageTupleSchemeFactory();

  public int interval; // required
  public long timestamp; // required
  public @org.apache.thrift.annotation.Nullable java.lang.String type; // required
  public long connectionCount; // required
  public long maxConnections; // required
  public long activeThreads; // required
  public long maxThreads; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    INTERVAL((short)1, "interval"),
    TIMESTAMP((short)2, "timestamp"),
    TYPE((short)3, "type"),
    CONNECTION_COUNT((short)4, "connectionCount"),
    MAX_CONNECTIONS((short)5, "maxConnections"),
    ACTIVE_THREADS((short)6, "activeThreads"),
    MAX_THREADS((short)7, "maxThreads");

    private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    @org.apache.thrift.annotation.Nullable
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // INTERVAL
          return INTERVAL;
        case 2: // TIMESTAMP
          return TIMESTAMP;
        case 3: // TYPE
          return TYPE;
        case 4: // CONNECTION_COUNT
          return CONNECTION_COUNT;
        case 5: // MAX_CONNECTIONS
          return MAX_CONNECTIONS;
        case 6: // ACTIVE_THREADS
          return ACTIVE_THREADS;
        case 7: // MAX_THREADS
          return MAX_THREADS;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    @org.apache.thrift.annotation.Nullable
    public static _Fields findByName(java.lang.String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final java.lang.String _fieldName;

    _Fields(short thriftId, java.lang.String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public java.lang.String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __INTERVAL_ISSET_ID = 0;
  private static final int __TIMESTAMP_ISSET_ID = 1;
  private static final int __CONNECTIONCOUNT_ISSET_ID = 2;
  private static final int __MAXCONNECTIONS_ISSET_ID = 3;
  private static final int __ACTIVETHREADS_ISSET_ID = 4;
  private static final int __MAXTHREADS_ISSET_ID = 5;
  private byte __isset_bitfield = 0;
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.INTERVAL, new org.apache.thrift.meta_data.FieldMetaData("interval", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.TIMESTAMP, new org.apache.thrift.meta_data.FieldMetaData("timestamp", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.TYPE, new org.apache.thrift.meta_data.FieldMetaData("type", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.CONNECTION_COUNT, new org.apache.thrift.meta_data.FieldMetaData("connectionCount", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.MAX_CONNECTIONS, new org.apache.thrift.meta_data.FieldMetaData("maxConnections", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.ACTIVE_THREADS, new org.apache.thrift.meta_data.FieldMetaData("activeThreads", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.MAX_THREADS, new org.apache.thrift.meta_data.FieldMetaData("maxThreads", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(WebServerMetricMessage.class, metaDataMap);
  }

  public WebServerMetricMessage() {
  }

  public WebServerMetricMessage(
    int interval,
    long timestamp,
    java.lang.String type,
    long connectionCount,
    long maxConnections,
    long activeThreads,
    long maxThreads)
  {
    this();
    this.interval = interval;
    setIntervalIsSet(true);
    this.timestamp = timestamp;
    setTimestampIsSet(true);
    this.type = type;
    this.connectionCount = connectionCount;
    setConnectionCountIsSet(true);
    this.maxConnections = maxConnections;
    setMaxConnectionsIsSet(true);
    this.activeThreads = activeThreads;
    setActiveThreadsIsSet(true);
    this.maxThreads = maxThreads;
    setMaxThreadsIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public WebServerMetricMessage(WebServerMetricMessage other) {
    __isset_bitfield = other.__isset_bitfield;
    this.interval = other.interval;
    this.timestamp = other.timestamp;
    if (other.isSetType()) {
      this.type = other.type;
    }
    this.connectionCount = other.connectionCount;
    this.maxConnections = other.maxConnections;
    this.activeThreads = other.activeThreads;
    this.maxThreads = other.maxThreads;
  }

  public WebServerMetricMessage deepCopy() {
    return new WebServerMetricMessage(this);
  }

  @Override
  public void clear() {
    setIntervalIsSet(false);
    this.interval = 0;
    setTimestampIsSet(false);
    this.timestamp = 0;
    this.type = null;
    setConnectionCountIsSet(false);
    this.connectionCount = 0;
    setMaxConnectionsIsSet(false);
    this.maxConnections = 0;
    setActiveThreadsIsSet(false);
    this.activeThreads = 0;
    setMaxThreadsIsSet(false);
    this.maxThreads = 0;
  }

  public int getInterval() {
    return this.interval;
  }

  public WebServerMetricMessage setInterval(int interval) {
    this.interval = interval;
    setIntervalIsSet(true);
    return this;
  }

  public void unsetInterval() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __INTERVAL_ISSET_ID);
  }

  /** Returns true if field interval is set (has been assigned a value) and false otherwise */
  public boolean isSetInterval() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __INTERVAL_ISSET_ID);
  }

  public void setIntervalIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __INTERVAL_ISSET_ID, value);
  }

  public long getTimestamp() {
    return this.timestamp;
  }

  public WebServerMetricMessage setTimestamp(long timestamp) {
    this.timestamp = timestamp;
    setTimestampIsSet(true);
    return this;
  }

  public void unsetTimestamp() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __TIMESTAMP_ISSET_ID);
  }

  /** Returns true if field timestamp is set (has been assigned a value) and false otherwise */
  public boolean isSetTimestamp() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __TIMESTAMP_ISSET_ID);
  }

  public void setTimestampIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __TIMESTAMP_ISSET_ID, value);
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getType() {
    return this.type;
  }

  public WebServerMetricMessage setType(@org.apache.thrift.annotation.Nullable java.lang.String type) {
    this.type = type;
    return this;
  }

  public void unsetType() {
    this.type = null;
  }

  /** Returns true if field type is set (has been assigned a value) and false otherwise */
  public boolean isSetType() {
    return this.type != null;
  }

  public void setTypeIsSet(boolean value) {
    if (!value) {
      this.type = null;
    }
  }

  public long getConnectionCount() {
    return this.connectionCount;
  }

  public WebServerMetricMessage setConnectionCount(long connectionCount) {
    this.connectionCount = connectionCount;
    setConnectionCountIsSet(true);
    return this;
  }

  public void unsetConnectionCount() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __CONNECTIONCOUNT_ISSET_ID);
  }

  /** Returns true if field connectionCount is set (has been assigned a value) and false otherwise */
  public boolean isSetConnectionCount() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __CONNECTIONCOUNT_ISSET_ID);
  }

  public void setConnectionCountIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __CONNECTIONCOUNT_ISSET_ID, value);
  }

  public long getMaxConnections() {
    return this.maxConnections;
  }

  public WebServerMetricMessage setMaxConnections(long maxConnections) {
    this.maxConnections = maxConnections;
    setMaxConnectionsIsSet(true);
    return this;
  }

  public void unsetMaxConnections() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __MAXCONNECTIONS_ISSET_ID);
  }

  /** Returns true if field maxConnections is set (has been assigned a value) and false otherwise */
  public boolean isSetMaxConnections() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __MAXCONNECTIONS_ISSET_ID);
  }

  public void setMaxConnectionsIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __MAXCONNECTIONS_ISSET_ID, value);
  }

  public long getActiveThreads() {
    return this.activeThreads;
  }

  public WebServerMetricMessage setActiveThreads(long activeThreads) {
    this.activeThreads = activeThreads;
    setActiveThreadsIsSet(true);
    return this;
  }

  public void unsetActiveThreads() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __ACTIVETHREADS_ISSET_ID);
  }

  /** Returns true if field activeThreads is set (has been assigned a value) and false otherwise */
  public boolean isSetActiveThreads() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __ACTIVETHREADS_ISSET_ID);
  }

  public void setActiveThreadsIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __ACTIVETHREADS_ISSET_ID, value);
  }

  public long getMaxThreads() {
    return this.maxThreads;
  }

  public WebServerMetricMessage setMaxThreads(long maxThreads) {
    this.maxThreads = maxThreads;
    setMaxThreadsIsSet(true);
    return this;
  }

  public void unsetMaxThreads() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __MAXTHREADS_ISSET_ID);
  }

  /** Returns true if field maxThreads is set (has been assigned a value) and false otherwise */
  public boolean isSetMaxThreads() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __MAXTHREADS_ISSET_ID);
  }

  public void setMaxThreadsIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __MAXTHREADS_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case INTERVAL:
      if (value == null) {
        unsetInterval();
      } else {
        setInterval((java.lang.Integer)value);
      }
      break;

    case TIMESTAMP:
      if (value == null) {
        unsetTimestamp();
      } else {
        setTimestamp((java.lang.Long)value);
      }
      break;

    case TYPE:
      if (value == null) {
        unsetType();
      } else {
        setType((java.lang.String)value);
      }
      break;

    case CONNECTION_COUNT:
      if (value == null) {
        unsetConnectionCount();
      } else {
        setConnectionCount((java.lang.Long)value);
      }
      break;

    case MAX_CONNECTIONS:
      if (value == null) {
        unsetMaxConnections();
      } else {
        setMaxConnections((java.lang.Long)value);
      }
      break;

    case ACTIVE_THREADS:
      if (value == null) {
        unsetActiveThreads();
      } else {
        setActiveThreads((java.lang.Long)value);
      }
      break;

    case MAX_THREADS:
      if (value == null) {
        unsetMaxThreads();
      } else {
        setMaxThreads((java.lang.Long)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case INTERVAL:
      return getInterval();

    case TIMESTAMP:
      return getTimestamp();

    case TYPE:
      return getType();

    case CONNECTION_COUNT:
      return getConnectionCount();

    case MAX_CONNECTIONS:
      return getMaxConnections();

    case ACTIVE_THREADS:
      return getActiveThreads();

    case MAX_THREADS:
      return getMaxThreads();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case INTERVAL:
      return isSetInterval();
    case TIMESTAMP:
      return isSetTimestamp();
    case TYPE:
      return isSetType();
    case CONNECTION_COUNT:
      return isSetConnectionCount();
    case MAX_CONNECTIONS:
      return isSetMaxConnections();
    case ACTIVE_THREADS:
      return isSetActiveThreads();
    case MAX_THREADS:
      return isSetMaxThreads();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that instanceof WebServerMetricMessage)
      return this.equals((WebServerMetricMessage)that);
    return false;
  }

  public boolean equals(WebServerMetricMessage that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_interval = true;
    boolean that_present_interval = true;
    if (this_present_interval || that_present_interval) {
      if (!(this_present_interval && that_present_interval))
        return false;
      if (this.interval != that.interval)
        return false;
    }

    boolean this_present_timestamp = true;
    boolean that_present_timestamp = true;
    if (this_present_timestamp || that_present_timestamp) {
      if (!(this_present_timestamp && that_present_timestamp))
        return false;
      if (this.timestamp != that.timestamp)
        return false;
    }

    boolean this_present_type = true && this.isSetType();
    boolean that_present_type = true && that.isSetType();
    if (this_present_type || that_present_type) {
      if (!(this_present_type && that_present_type))
        return false;
      if (!this.type.equals(that.type))
        return false;
    }

    boolean this_present_connectionCount = true;
    boolean that_present_connectionCount = true;
    if (this_present_connectionCount || that_present_connectionCount) {
      if (!(this_present_connectionCount && that_present_connectionCount))
        return false;
      if (this.connectionCount != that.connectionCount)
        return false;
    }

    boolean this_present_maxConnections = true;
    boolean that_present_maxConnections = true;
    if (this_present_maxConnections || that_present_maxConnections) {
      if (!(this_present_maxConnections && that_present_maxConnections))
        return false;
      if (this.maxConnections != that.maxConnections)
        return false;
    }

    boolean this_present_activeThreads = true;
    boolean that_present_activeThreads = true;
    if (this_present_activeThreads || that_present_activeThreads) {
      if (!(this_present_activeThreads && that_present_activeThreads))
        return false;
      if (this.activeThreads != that.activeThreads)
        return false;
    }

    boolean this_present_maxThreads = true;
    boolean that_present_maxThreads = true;
    if (this_present_maxThreads || that_present_maxThreads) {
      if (!(this_present_maxThreads && that_present_maxThreads))
        return false;
      if (this.maxThreads != that.maxThreads)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + interval;

    hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(timestamp);

    hashCode = hashCode * 8191 + ((isSetType()) ? 131071 : 524287);
    if (isSetType())
      hashCode = hashCode * 8191 + type.hashCode();

    hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(connectionCount);

    hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(maxConnections);

    hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(activeThreads);

    hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(maxThreads);

    return hashCode;
  }

  @Override
  public int compareTo(WebServerMetricMessage other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.compare(isSetInterval(), other.isSetInterval());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetInterval()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.interval, other.interval);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetTimestamp(), other.isSetTimestamp());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTimestamp()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.timestamp, other.timestamp);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetType(), other.isSetType());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetType()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.type, other.type);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetConnectionCount(), other.isSetConnectionCount());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetConnectionCount()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.connectionCount, other.connectionCount);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetMaxConnections(), other.isSetMaxConnections());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMaxConnections()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.maxConnections, other.maxConnections);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetActiveThreads(), other.isSetActiveThreads());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetActiveThreads()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.activeThreads, other.activeThreads);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetMaxThreads(), other.isSetMaxThreads());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMaxThreads()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.maxThreads, other.maxThreads);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  @org.apache.thrift.annotation.Nullable
  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    scheme(iprot).read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    scheme(oprot).write(oprot, this);
  }

  @Override
  public java.lang.String toString() {
    java.lang.StringBuilder sb = new java.lang.StringBuilder("WebServerMetricMessage(");
    boolean first = true;

    sb.append("interval:");
    sb.append(this.interval);
    first = false;
    if (!first) sb.append(", ");
    sb.append("timestamp:");
    sb.append(this.timestamp);
    first = false;
    if (!first) sb.append(", ");
    sb.append("type:");
    if (this.type == null) {
      sb.append("null");
    } else {
      sb.append(this.type);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("connectionCount:");
    sb.append(this.connectionCount);
    first = false;
    if (!first) sb.append(", ");
    sb.append("maxConnections:");
    sb.append(this.maxConnections);
    first = false;
    if (!first) sb.append(", ");
    sb.append("activeThreads:");
    sb.append(this.activeThreads);
    first = false;
    if (!first) sb.append(", ");
    sb.append("maxThreads:");
    sb.append(this.maxThreads);
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class WebServerMetricMessageStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public WebServerMetricMessageStandardScheme getScheme() {
      return new WebServerMetricMessageStandardScheme();
    }
  }

  private static class WebServerMetricMessageStandardScheme extends org.apache.thrift.scheme.StandardScheme<WebServerMetricMessage> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, WebServerMetricMessage struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // INTERVAL
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.interval = iprot.readI32();
              struct.setIntervalIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // TIMESTAMP
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.timestamp = iprot.readI64();
              struct.setTimestampIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // TYPE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.type = iprot.readString();
              struct.setTypeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // CONNECTION_COUNT
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.connectionCount = iprot.readI64();
              struct.setConnectionCountIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // MAX_CONNECTIONS
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.maxConnections = iprot.readI64();
              struct.setMaxConnectionsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // ACTIVE_THREADS
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.activeThreads = iprot.readI64();
              struct.setActiveThreadsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 7: // MAX_THREADS
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.maxThreads = iprot.readI64();
              struct.setMaxThreadsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, WebServerMetricMessage struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(INTERVAL_FIELD_DESC);
      oprot.writeI32(struct.interval);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(TIMESTAMP_FIELD_DESC);
      oprot.writeI64(struct.timestamp);
      oprot.writeFieldEnd();
      if (struct.type != null) {
        oprot.writeFieldBegin(TYPE_FIELD_DESC);
        oprot.writeString(struct.type);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(CONNECTION_COUNT_FIELD_DESC);
      oprot.writeI64(struct.connectionCount);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(MAX_CONNECTIONS_FIELD_DESC);
      oprot.writeI64(struct.maxConnections);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(ACTIVE_THREADS_FIELD_DESC);
      oprot.writeI64(struct.activeThreads);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(MAX_THREADS_FIELD_DESC);
      oprot.writeI64(struct.maxThreads);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class WebServerMetricMessageTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public WebServerMetricMessageTupleScheme getScheme() {
      return new WebServerMetricMessageTupleScheme();
    }
  }

  private static class WebServerMetricMessageTupleScheme extends org.apache.thrift.scheme.TupleScheme<WebServerMetricMessage> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, WebServerMetricMessage struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetInterval()) {
        optionals.set(0);
      }
      if (struct.isSetTimestamp()) {
        optionals.set(1);
      }
      if (struct.isSetType()) {
        optionals.set(2);
      }
      if (struct.isSetConnectionCount()) {
        optionals.set(3);
      }
      if (struct.isSetMaxConnections()) {
        optionals.set(4);
      }
      if (struct.isSetActiveThreads()) {
        optionals.set(5);
      }
      if (struct.isSetMaxThreads()) {
        optionals.set(6);
      }
      oprot.writeBitSet(optionals, 7);
      if (struct.isSetInterval()) {
        oprot.writeI32(struct.interval);
      }
      if (struct.isSetTimestamp()) {
        oprot.writeI64(struct.timestamp);
      }
      if (struct.isSetType()) {
        oprot.writeString(struct.type);
      }
      if (struct.isSetConnectionCount()) {
        oprot.writeI64(struct.connectionCount);
      }
      if (struct.isSetMaxConnections()) {
        oprot.writeI64(struct.maxConnections);
      }
      if (struct.isSetActiveThreads()) {
        oprot.writeI64(struct.activeThreads);
      }
      if (struct.isSetMaxThreads()) {
        oprot.writeI64(struct.maxThreads);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, WebServerMetricMessage struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(7);
      if (incoming.get(0)) {
        struct.interval = iprot.readI32();
        struct.setIntervalIsSet(true);
      }
      if (incoming.get(1)) {
        struct.timestamp = iprot.readI64();
        struct.setTimestampIsSet(true);
      }
      if (incoming.get(2)) {
        struct.type = iprot.readString();
        struct.setTypeIsSet(true);
      }
      if (incoming.get(3)) {
        struct.connectionCount = iprot.readI64();
        struct.setConnectionCountIsSet(true);
      }
      if (incoming.get(4)) {
        struct.maxConnections = iprot.readI64();
        struct.setMaxConnectionsIsSet(true);
      }
      if (incoming.get(5)) {
        struct.activeThreads = iprot.readI64();
        struct.setActiveThreadsIsSet(true);
      }
      if (incoming.get(6)) {
        struct.maxThreads = iprot.readI64();
        struct.setMaxThreadsIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

