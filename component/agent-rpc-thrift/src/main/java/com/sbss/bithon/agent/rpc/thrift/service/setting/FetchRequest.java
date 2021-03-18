/**
 * Autogenerated by Thrift Compiler (0.14.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.sbss.bithon.agent.rpc.thrift.service.setting;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.14.1)", date = "2021-03-18")
public class FetchRequest implements org.apache.thrift.TBase<FetchRequest, FetchRequest._Fields>, java.io.Serializable, Cloneable, Comparable<FetchRequest> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("FetchRequest");

  private static final org.apache.thrift.protocol.TField APP_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("appName", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField ENV_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("envName", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField SINCE_FIELD_DESC = new org.apache.thrift.protocol.TField("since", org.apache.thrift.protocol.TType.I64, (short)3);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new FetchRequestStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new FetchRequestTupleSchemeFactory();

  public @org.apache.thrift.annotation.Nullable java.lang.String appName; // required
  public @org.apache.thrift.annotation.Nullable java.lang.String envName; // required
  public long since; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    APP_NAME((short)1, "appName"),
    ENV_NAME((short)2, "envName"),
    SINCE((short)3, "since");

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
        case 1: // APP_NAME
          return APP_NAME;
        case 2: // ENV_NAME
          return ENV_NAME;
        case 3: // SINCE
          return SINCE;
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
  private static final int __SINCE_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.APP_NAME, new org.apache.thrift.meta_data.FieldMetaData("appName", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.ENV_NAME, new org.apache.thrift.meta_data.FieldMetaData("envName", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.SINCE, new org.apache.thrift.meta_data.FieldMetaData("since", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(FetchRequest.class, metaDataMap);
  }

  public FetchRequest() {
  }

  public FetchRequest(
    java.lang.String appName,
    java.lang.String envName,
    long since)
  {
    this();
    this.appName = appName;
    this.envName = envName;
    this.since = since;
    setSinceIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public FetchRequest(FetchRequest other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetAppName()) {
      this.appName = other.appName;
    }
    if (other.isSetEnvName()) {
      this.envName = other.envName;
    }
    this.since = other.since;
  }

  public FetchRequest deepCopy() {
    return new FetchRequest(this);
  }

  @Override
  public void clear() {
    this.appName = null;
    this.envName = null;
    setSinceIsSet(false);
    this.since = 0;
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getAppName() {
    return this.appName;
  }

  public FetchRequest setAppName(@org.apache.thrift.annotation.Nullable java.lang.String appName) {
    this.appName = appName;
    return this;
  }

  public void unsetAppName() {
    this.appName = null;
  }

  /** Returns true if field appName is set (has been assigned a value) and false otherwise */
  public boolean isSetAppName() {
    return this.appName != null;
  }

  public void setAppNameIsSet(boolean value) {
    if (!value) {
      this.appName = null;
    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getEnvName() {
    return this.envName;
  }

  public FetchRequest setEnvName(@org.apache.thrift.annotation.Nullable java.lang.String envName) {
    this.envName = envName;
    return this;
  }

  public void unsetEnvName() {
    this.envName = null;
  }

  /** Returns true if field envName is set (has been assigned a value) and false otherwise */
  public boolean isSetEnvName() {
    return this.envName != null;
  }

  public void setEnvNameIsSet(boolean value) {
    if (!value) {
      this.envName = null;
    }
  }

  public long getSince() {
    return this.since;
  }

  public FetchRequest setSince(long since) {
    this.since = since;
    setSinceIsSet(true);
    return this;
  }

  public void unsetSince() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __SINCE_ISSET_ID);
  }

  /** Returns true if field since is set (has been assigned a value) and false otherwise */
  public boolean isSetSince() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __SINCE_ISSET_ID);
  }

  public void setSinceIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __SINCE_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case APP_NAME:
      if (value == null) {
        unsetAppName();
      } else {
        setAppName((java.lang.String)value);
      }
      break;

    case ENV_NAME:
      if (value == null) {
        unsetEnvName();
      } else {
        setEnvName((java.lang.String)value);
      }
      break;

    case SINCE:
      if (value == null) {
        unsetSince();
      } else {
        setSince((java.lang.Long)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case APP_NAME:
      return getAppName();

    case ENV_NAME:
      return getEnvName();

    case SINCE:
      return getSince();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case APP_NAME:
      return isSetAppName();
    case ENV_NAME:
      return isSetEnvName();
    case SINCE:
      return isSetSince();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that instanceof FetchRequest)
      return this.equals((FetchRequest)that);
    return false;
  }

  public boolean equals(FetchRequest that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_appName = true && this.isSetAppName();
    boolean that_present_appName = true && that.isSetAppName();
    if (this_present_appName || that_present_appName) {
      if (!(this_present_appName && that_present_appName))
        return false;
      if (!this.appName.equals(that.appName))
        return false;
    }

    boolean this_present_envName = true && this.isSetEnvName();
    boolean that_present_envName = true && that.isSetEnvName();
    if (this_present_envName || that_present_envName) {
      if (!(this_present_envName && that_present_envName))
        return false;
      if (!this.envName.equals(that.envName))
        return false;
    }

    boolean this_present_since = true;
    boolean that_present_since = true;
    if (this_present_since || that_present_since) {
      if (!(this_present_since && that_present_since))
        return false;
      if (this.since != that.since)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetAppName()) ? 131071 : 524287);
    if (isSetAppName())
      hashCode = hashCode * 8191 + appName.hashCode();

    hashCode = hashCode * 8191 + ((isSetEnvName()) ? 131071 : 524287);
    if (isSetEnvName())
      hashCode = hashCode * 8191 + envName.hashCode();

    hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(since);

    return hashCode;
  }

  @Override
  public int compareTo(FetchRequest other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.compare(isSetAppName(), other.isSetAppName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAppName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.appName, other.appName);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetEnvName(), other.isSetEnvName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetEnvName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.envName, other.envName);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetSince(), other.isSetSince());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSince()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.since, other.since);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("FetchRequest(");
    boolean first = true;

    sb.append("appName:");
    if (this.appName == null) {
      sb.append("null");
    } else {
      sb.append(this.appName);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("envName:");
    if (this.envName == null) {
      sb.append("null");
    } else {
      sb.append(this.envName);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("since:");
    sb.append(this.since);
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

  private static class FetchRequestStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public FetchRequestStandardScheme getScheme() {
      return new FetchRequestStandardScheme();
    }
  }

  private static class FetchRequestStandardScheme extends org.apache.thrift.scheme.StandardScheme<FetchRequest> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, FetchRequest struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // APP_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.appName = iprot.readString();
              struct.setAppNameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // ENV_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.envName = iprot.readString();
              struct.setEnvNameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // SINCE
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.since = iprot.readI64();
              struct.setSinceIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, FetchRequest struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.appName != null) {
        oprot.writeFieldBegin(APP_NAME_FIELD_DESC);
        oprot.writeString(struct.appName);
        oprot.writeFieldEnd();
      }
      if (struct.envName != null) {
        oprot.writeFieldBegin(ENV_NAME_FIELD_DESC);
        oprot.writeString(struct.envName);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(SINCE_FIELD_DESC);
      oprot.writeI64(struct.since);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class FetchRequestTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public FetchRequestTupleScheme getScheme() {
      return new FetchRequestTupleScheme();
    }
  }

  private static class FetchRequestTupleScheme extends org.apache.thrift.scheme.TupleScheme<FetchRequest> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, FetchRequest struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetAppName()) {
        optionals.set(0);
      }
      if (struct.isSetEnvName()) {
        optionals.set(1);
      }
      if (struct.isSetSince()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetAppName()) {
        oprot.writeString(struct.appName);
      }
      if (struct.isSetEnvName()) {
        oprot.writeString(struct.envName);
      }
      if (struct.isSetSince()) {
        oprot.writeI64(struct.since);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, FetchRequest struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        struct.appName = iprot.readString();
        struct.setAppNameIsSet(true);
      }
      if (incoming.get(1)) {
        struct.envName = iprot.readString();
        struct.setEnvNameIsSet(true);
      }
      if (incoming.get(2)) {
        struct.since = iprot.readI64();
        struct.setSinceIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

