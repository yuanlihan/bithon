/**
 * Autogenerated by Thrift Compiler (0.14.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.sbss.bithon.agent.rpc.thrift.service.metric.message;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.14.1)", date = "2021-03-21")
public class GcEntity implements org.apache.thrift.TBase<GcEntity, GcEntity._Fields>, java.io.Serializable, Cloneable, Comparable<GcEntity> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("GcEntity");

  private static final org.apache.thrift.protocol.TField GC_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("gcName", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField GENERATION_FIELD_DESC = new org.apache.thrift.protocol.TField("generation", org.apache.thrift.protocol.TType.I32, (short)2);
  private static final org.apache.thrift.protocol.TField GC_COUNT_FIELD_DESC = new org.apache.thrift.protocol.TField("gcCount", org.apache.thrift.protocol.TType.I64, (short)3);
  private static final org.apache.thrift.protocol.TField GC_TIME_FIELD_DESC = new org.apache.thrift.protocol.TField("gcTime", org.apache.thrift.protocol.TType.I64, (short)4);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new GcEntityStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new GcEntityTupleSchemeFactory();

  public @org.apache.thrift.annotation.Nullable java.lang.String gcName; // optional
  public int generation; // required
  public long gcCount; // required
  public long gcTime; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    GC_NAME((short)1, "gcName"),
    GENERATION((short)2, "generation"),
    GC_COUNT((short)3, "gcCount"),
    GC_TIME((short)4, "gcTime");

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
        case 1: // GC_NAME
          return GC_NAME;
        case 2: // GENERATION
          return GENERATION;
        case 3: // GC_COUNT
          return GC_COUNT;
        case 4: // GC_TIME
          return GC_TIME;
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
  private static final int __GENERATION_ISSET_ID = 0;
  private static final int __GCCOUNT_ISSET_ID = 1;
  private static final int __GCTIME_ISSET_ID = 2;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.GC_NAME};
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.GC_NAME, new org.apache.thrift.meta_data.FieldMetaData("gcName", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.GENERATION, new org.apache.thrift.meta_data.FieldMetaData("generation", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.GC_COUNT, new org.apache.thrift.meta_data.FieldMetaData("gcCount", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.GC_TIME, new org.apache.thrift.meta_data.FieldMetaData("gcTime", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(GcEntity.class, metaDataMap);
  }

  public GcEntity() {
  }

  public GcEntity(
    int generation,
    long gcCount,
    long gcTime)
  {
    this();
    this.generation = generation;
    setGenerationIsSet(true);
    this.gcCount = gcCount;
    setGcCountIsSet(true);
    this.gcTime = gcTime;
    setGcTimeIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public GcEntity(GcEntity other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetGcName()) {
      this.gcName = other.gcName;
    }
    this.generation = other.generation;
    this.gcCount = other.gcCount;
    this.gcTime = other.gcTime;
  }

  public GcEntity deepCopy() {
    return new GcEntity(this);
  }

  @Override
  public void clear() {
    this.gcName = null;
    setGenerationIsSet(false);
    this.generation = 0;
    setGcCountIsSet(false);
    this.gcCount = 0;
    setGcTimeIsSet(false);
    this.gcTime = 0;
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getGcName() {
    return this.gcName;
  }

  public GcEntity setGcName(@org.apache.thrift.annotation.Nullable java.lang.String gcName) {
    this.gcName = gcName;
    return this;
  }

  public void unsetGcName() {
    this.gcName = null;
  }

  /** Returns true if field gcName is set (has been assigned a value) and false otherwise */
  public boolean isSetGcName() {
    return this.gcName != null;
  }

  public void setGcNameIsSet(boolean value) {
    if (!value) {
      this.gcName = null;
    }
  }

  public int getGeneration() {
    return this.generation;
  }

  public GcEntity setGeneration(int generation) {
    this.generation = generation;
    setGenerationIsSet(true);
    return this;
  }

  public void unsetGeneration() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __GENERATION_ISSET_ID);
  }

  /** Returns true if field generation is set (has been assigned a value) and false otherwise */
  public boolean isSetGeneration() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __GENERATION_ISSET_ID);
  }

  public void setGenerationIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __GENERATION_ISSET_ID, value);
  }

  public long getGcCount() {
    return this.gcCount;
  }

  public GcEntity setGcCount(long gcCount) {
    this.gcCount = gcCount;
    setGcCountIsSet(true);
    return this;
  }

  public void unsetGcCount() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __GCCOUNT_ISSET_ID);
  }

  /** Returns true if field gcCount is set (has been assigned a value) and false otherwise */
  public boolean isSetGcCount() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __GCCOUNT_ISSET_ID);
  }

  public void setGcCountIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __GCCOUNT_ISSET_ID, value);
  }

  public long getGcTime() {
    return this.gcTime;
  }

  public GcEntity setGcTime(long gcTime) {
    this.gcTime = gcTime;
    setGcTimeIsSet(true);
    return this;
  }

  public void unsetGcTime() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __GCTIME_ISSET_ID);
  }

  /** Returns true if field gcTime is set (has been assigned a value) and false otherwise */
  public boolean isSetGcTime() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __GCTIME_ISSET_ID);
  }

  public void setGcTimeIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __GCTIME_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case GC_NAME:
      if (value == null) {
        unsetGcName();
      } else {
        setGcName((java.lang.String)value);
      }
      break;

    case GENERATION:
      if (value == null) {
        unsetGeneration();
      } else {
        setGeneration((java.lang.Integer)value);
      }
      break;

    case GC_COUNT:
      if (value == null) {
        unsetGcCount();
      } else {
        setGcCount((java.lang.Long)value);
      }
      break;

    case GC_TIME:
      if (value == null) {
        unsetGcTime();
      } else {
        setGcTime((java.lang.Long)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case GC_NAME:
      return getGcName();

    case GENERATION:
      return getGeneration();

    case GC_COUNT:
      return getGcCount();

    case GC_TIME:
      return getGcTime();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case GC_NAME:
      return isSetGcName();
    case GENERATION:
      return isSetGeneration();
    case GC_COUNT:
      return isSetGcCount();
    case GC_TIME:
      return isSetGcTime();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that instanceof GcEntity)
      return this.equals((GcEntity)that);
    return false;
  }

  public boolean equals(GcEntity that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_gcName = true && this.isSetGcName();
    boolean that_present_gcName = true && that.isSetGcName();
    if (this_present_gcName || that_present_gcName) {
      if (!(this_present_gcName && that_present_gcName))
        return false;
      if (!this.gcName.equals(that.gcName))
        return false;
    }

    boolean this_present_generation = true;
    boolean that_present_generation = true;
    if (this_present_generation || that_present_generation) {
      if (!(this_present_generation && that_present_generation))
        return false;
      if (this.generation != that.generation)
        return false;
    }

    boolean this_present_gcCount = true;
    boolean that_present_gcCount = true;
    if (this_present_gcCount || that_present_gcCount) {
      if (!(this_present_gcCount && that_present_gcCount))
        return false;
      if (this.gcCount != that.gcCount)
        return false;
    }

    boolean this_present_gcTime = true;
    boolean that_present_gcTime = true;
    if (this_present_gcTime || that_present_gcTime) {
      if (!(this_present_gcTime && that_present_gcTime))
        return false;
      if (this.gcTime != that.gcTime)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetGcName()) ? 131071 : 524287);
    if (isSetGcName())
      hashCode = hashCode * 8191 + gcName.hashCode();

    hashCode = hashCode * 8191 + generation;

    hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(gcCount);

    hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(gcTime);

    return hashCode;
  }

  @Override
  public int compareTo(GcEntity other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.compare(isSetGcName(), other.isSetGcName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetGcName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.gcName, other.gcName);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetGeneration(), other.isSetGeneration());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetGeneration()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.generation, other.generation);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetGcCount(), other.isSetGcCount());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetGcCount()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.gcCount, other.gcCount);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetGcTime(), other.isSetGcTime());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetGcTime()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.gcTime, other.gcTime);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("GcEntity(");
    boolean first = true;

    if (isSetGcName()) {
      sb.append("gcName:");
      if (this.gcName == null) {
        sb.append("null");
      } else {
        sb.append(this.gcName);
      }
      first = false;
    }
    if (!first) sb.append(", ");
    sb.append("generation:");
    sb.append(this.generation);
    first = false;
    if (!first) sb.append(", ");
    sb.append("gcCount:");
    sb.append(this.gcCount);
    first = false;
    if (!first) sb.append(", ");
    sb.append("gcTime:");
    sb.append(this.gcTime);
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

  private static class GcEntityStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public GcEntityStandardScheme getScheme() {
      return new GcEntityStandardScheme();
    }
  }

  private static class GcEntityStandardScheme extends org.apache.thrift.scheme.StandardScheme<GcEntity> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, GcEntity struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // GC_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.gcName = iprot.readString();
              struct.setGcNameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // GENERATION
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.generation = iprot.readI32();
              struct.setGenerationIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // GC_COUNT
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.gcCount = iprot.readI64();
              struct.setGcCountIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // GC_TIME
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.gcTime = iprot.readI64();
              struct.setGcTimeIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, GcEntity struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.gcName != null) {
        if (struct.isSetGcName()) {
          oprot.writeFieldBegin(GC_NAME_FIELD_DESC);
          oprot.writeString(struct.gcName);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldBegin(GENERATION_FIELD_DESC);
      oprot.writeI32(struct.generation);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(GC_COUNT_FIELD_DESC);
      oprot.writeI64(struct.gcCount);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(GC_TIME_FIELD_DESC);
      oprot.writeI64(struct.gcTime);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class GcEntityTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public GcEntityTupleScheme getScheme() {
      return new GcEntityTupleScheme();
    }
  }

  private static class GcEntityTupleScheme extends org.apache.thrift.scheme.TupleScheme<GcEntity> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, GcEntity struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetGcName()) {
        optionals.set(0);
      }
      if (struct.isSetGeneration()) {
        optionals.set(1);
      }
      if (struct.isSetGcCount()) {
        optionals.set(2);
      }
      if (struct.isSetGcTime()) {
        optionals.set(3);
      }
      oprot.writeBitSet(optionals, 4);
      if (struct.isSetGcName()) {
        oprot.writeString(struct.gcName);
      }
      if (struct.isSetGeneration()) {
        oprot.writeI32(struct.generation);
      }
      if (struct.isSetGcCount()) {
        oprot.writeI64(struct.gcCount);
      }
      if (struct.isSetGcTime()) {
        oprot.writeI64(struct.gcTime);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, GcEntity struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(4);
      if (incoming.get(0)) {
        struct.gcName = iprot.readString();
        struct.setGcNameIsSet(true);
      }
      if (incoming.get(1)) {
        struct.generation = iprot.readI32();
        struct.setGenerationIsSet(true);
      }
      if (incoming.get(2)) {
        struct.gcCount = iprot.readI64();
        struct.setGcCountIsSet(true);
      }
      if (incoming.get(3)) {
        struct.gcTime = iprot.readI64();
        struct.setGcTimeIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

