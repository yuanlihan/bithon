/**
 * Autogenerated by Thrift Compiler (0.14.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.sbss.bithon.agent.rpc.thrift.service.metric.message;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.14.1)", date = "2021-03-21")
public class NonHeapEntity implements org.apache.thrift.TBase<NonHeapEntity, NonHeapEntity._Fields>, java.io.Serializable, Cloneable, Comparable<NonHeapEntity> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("NonHeapEntity");

  private static final org.apache.thrift.protocol.TField NON_HEAP_FIELD_DESC = new org.apache.thrift.protocol.TField("nonHeap", org.apache.thrift.protocol.TType.I64, (short)1);
  private static final org.apache.thrift.protocol.TField NON_HEAP_INIT_FIELD_DESC = new org.apache.thrift.protocol.TField("nonHeapInit", org.apache.thrift.protocol.TType.I64, (short)2);
  private static final org.apache.thrift.protocol.TField NON_HEAP_USED_FIELD_DESC = new org.apache.thrift.protocol.TField("nonHeapUsed", org.apache.thrift.protocol.TType.I64, (short)3);
  private static final org.apache.thrift.protocol.TField NON_HEAP_COMMITTED_FIELD_DESC = new org.apache.thrift.protocol.TField("nonHeapCommitted", org.apache.thrift.protocol.TType.I64, (short)4);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new NonHeapEntityStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new NonHeapEntityTupleSchemeFactory();

  public long nonHeap; // required
  public long nonHeapInit; // required
  public long nonHeapUsed; // required
  public long nonHeapCommitted; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    NON_HEAP((short)1, "nonHeap"),
    NON_HEAP_INIT((short)2, "nonHeapInit"),
    NON_HEAP_USED((short)3, "nonHeapUsed"),
    NON_HEAP_COMMITTED((short)4, "nonHeapCommitted");

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
        case 1: // NON_HEAP
          return NON_HEAP;
        case 2: // NON_HEAP_INIT
          return NON_HEAP_INIT;
        case 3: // NON_HEAP_USED
          return NON_HEAP_USED;
        case 4: // NON_HEAP_COMMITTED
          return NON_HEAP_COMMITTED;
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
  private static final int __NONHEAP_ISSET_ID = 0;
  private static final int __NONHEAPINIT_ISSET_ID = 1;
  private static final int __NONHEAPUSED_ISSET_ID = 2;
  private static final int __NONHEAPCOMMITTED_ISSET_ID = 3;
  private byte __isset_bitfield = 0;
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.NON_HEAP, new org.apache.thrift.meta_data.FieldMetaData("nonHeap", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.NON_HEAP_INIT, new org.apache.thrift.meta_data.FieldMetaData("nonHeapInit", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.NON_HEAP_USED, new org.apache.thrift.meta_data.FieldMetaData("nonHeapUsed", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.NON_HEAP_COMMITTED, new org.apache.thrift.meta_data.FieldMetaData("nonHeapCommitted", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(NonHeapEntity.class, metaDataMap);
  }

  public NonHeapEntity() {
  }

  public NonHeapEntity(
    long nonHeap,
    long nonHeapInit,
    long nonHeapUsed,
    long nonHeapCommitted)
  {
    this();
    this.nonHeap = nonHeap;
    setNonHeapIsSet(true);
    this.nonHeapInit = nonHeapInit;
    setNonHeapInitIsSet(true);
    this.nonHeapUsed = nonHeapUsed;
    setNonHeapUsedIsSet(true);
    this.nonHeapCommitted = nonHeapCommitted;
    setNonHeapCommittedIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public NonHeapEntity(NonHeapEntity other) {
    __isset_bitfield = other.__isset_bitfield;
    this.nonHeap = other.nonHeap;
    this.nonHeapInit = other.nonHeapInit;
    this.nonHeapUsed = other.nonHeapUsed;
    this.nonHeapCommitted = other.nonHeapCommitted;
  }

  public NonHeapEntity deepCopy() {
    return new NonHeapEntity(this);
  }

  @Override
  public void clear() {
    setNonHeapIsSet(false);
    this.nonHeap = 0;
    setNonHeapInitIsSet(false);
    this.nonHeapInit = 0;
    setNonHeapUsedIsSet(false);
    this.nonHeapUsed = 0;
    setNonHeapCommittedIsSet(false);
    this.nonHeapCommitted = 0;
  }

  public long getNonHeap() {
    return this.nonHeap;
  }

  public NonHeapEntity setNonHeap(long nonHeap) {
    this.nonHeap = nonHeap;
    setNonHeapIsSet(true);
    return this;
  }

  public void unsetNonHeap() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __NONHEAP_ISSET_ID);
  }

  /** Returns true if field nonHeap is set (has been assigned a value) and false otherwise */
  public boolean isSetNonHeap() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __NONHEAP_ISSET_ID);
  }

  public void setNonHeapIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __NONHEAP_ISSET_ID, value);
  }

  public long getNonHeapInit() {
    return this.nonHeapInit;
  }

  public NonHeapEntity setNonHeapInit(long nonHeapInit) {
    this.nonHeapInit = nonHeapInit;
    setNonHeapInitIsSet(true);
    return this;
  }

  public void unsetNonHeapInit() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __NONHEAPINIT_ISSET_ID);
  }

  /** Returns true if field nonHeapInit is set (has been assigned a value) and false otherwise */
  public boolean isSetNonHeapInit() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __NONHEAPINIT_ISSET_ID);
  }

  public void setNonHeapInitIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __NONHEAPINIT_ISSET_ID, value);
  }

  public long getNonHeapUsed() {
    return this.nonHeapUsed;
  }

  public NonHeapEntity setNonHeapUsed(long nonHeapUsed) {
    this.nonHeapUsed = nonHeapUsed;
    setNonHeapUsedIsSet(true);
    return this;
  }

  public void unsetNonHeapUsed() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __NONHEAPUSED_ISSET_ID);
  }

  /** Returns true if field nonHeapUsed is set (has been assigned a value) and false otherwise */
  public boolean isSetNonHeapUsed() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __NONHEAPUSED_ISSET_ID);
  }

  public void setNonHeapUsedIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __NONHEAPUSED_ISSET_ID, value);
  }

  public long getNonHeapCommitted() {
    return this.nonHeapCommitted;
  }

  public NonHeapEntity setNonHeapCommitted(long nonHeapCommitted) {
    this.nonHeapCommitted = nonHeapCommitted;
    setNonHeapCommittedIsSet(true);
    return this;
  }

  public void unsetNonHeapCommitted() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __NONHEAPCOMMITTED_ISSET_ID);
  }

  /** Returns true if field nonHeapCommitted is set (has been assigned a value) and false otherwise */
  public boolean isSetNonHeapCommitted() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __NONHEAPCOMMITTED_ISSET_ID);
  }

  public void setNonHeapCommittedIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __NONHEAPCOMMITTED_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case NON_HEAP:
      if (value == null) {
        unsetNonHeap();
      } else {
        setNonHeap((java.lang.Long)value);
      }
      break;

    case NON_HEAP_INIT:
      if (value == null) {
        unsetNonHeapInit();
      } else {
        setNonHeapInit((java.lang.Long)value);
      }
      break;

    case NON_HEAP_USED:
      if (value == null) {
        unsetNonHeapUsed();
      } else {
        setNonHeapUsed((java.lang.Long)value);
      }
      break;

    case NON_HEAP_COMMITTED:
      if (value == null) {
        unsetNonHeapCommitted();
      } else {
        setNonHeapCommitted((java.lang.Long)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case NON_HEAP:
      return getNonHeap();

    case NON_HEAP_INIT:
      return getNonHeapInit();

    case NON_HEAP_USED:
      return getNonHeapUsed();

    case NON_HEAP_COMMITTED:
      return getNonHeapCommitted();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case NON_HEAP:
      return isSetNonHeap();
    case NON_HEAP_INIT:
      return isSetNonHeapInit();
    case NON_HEAP_USED:
      return isSetNonHeapUsed();
    case NON_HEAP_COMMITTED:
      return isSetNonHeapCommitted();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that instanceof NonHeapEntity)
      return this.equals((NonHeapEntity)that);
    return false;
  }

  public boolean equals(NonHeapEntity that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_nonHeap = true;
    boolean that_present_nonHeap = true;
    if (this_present_nonHeap || that_present_nonHeap) {
      if (!(this_present_nonHeap && that_present_nonHeap))
        return false;
      if (this.nonHeap != that.nonHeap)
        return false;
    }

    boolean this_present_nonHeapInit = true;
    boolean that_present_nonHeapInit = true;
    if (this_present_nonHeapInit || that_present_nonHeapInit) {
      if (!(this_present_nonHeapInit && that_present_nonHeapInit))
        return false;
      if (this.nonHeapInit != that.nonHeapInit)
        return false;
    }

    boolean this_present_nonHeapUsed = true;
    boolean that_present_nonHeapUsed = true;
    if (this_present_nonHeapUsed || that_present_nonHeapUsed) {
      if (!(this_present_nonHeapUsed && that_present_nonHeapUsed))
        return false;
      if (this.nonHeapUsed != that.nonHeapUsed)
        return false;
    }

    boolean this_present_nonHeapCommitted = true;
    boolean that_present_nonHeapCommitted = true;
    if (this_present_nonHeapCommitted || that_present_nonHeapCommitted) {
      if (!(this_present_nonHeapCommitted && that_present_nonHeapCommitted))
        return false;
      if (this.nonHeapCommitted != that.nonHeapCommitted)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(nonHeap);

    hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(nonHeapInit);

    hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(nonHeapUsed);

    hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(nonHeapCommitted);

    return hashCode;
  }

  @Override
  public int compareTo(NonHeapEntity other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.compare(isSetNonHeap(), other.isSetNonHeap());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetNonHeap()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.nonHeap, other.nonHeap);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetNonHeapInit(), other.isSetNonHeapInit());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetNonHeapInit()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.nonHeapInit, other.nonHeapInit);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetNonHeapUsed(), other.isSetNonHeapUsed());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetNonHeapUsed()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.nonHeapUsed, other.nonHeapUsed);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetNonHeapCommitted(), other.isSetNonHeapCommitted());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetNonHeapCommitted()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.nonHeapCommitted, other.nonHeapCommitted);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("NonHeapEntity(");
    boolean first = true;

    sb.append("nonHeap:");
    sb.append(this.nonHeap);
    first = false;
    if (!first) sb.append(", ");
    sb.append("nonHeapInit:");
    sb.append(this.nonHeapInit);
    first = false;
    if (!first) sb.append(", ");
    sb.append("nonHeapUsed:");
    sb.append(this.nonHeapUsed);
    first = false;
    if (!first) sb.append(", ");
    sb.append("nonHeapCommitted:");
    sb.append(this.nonHeapCommitted);
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

  private static class NonHeapEntityStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public NonHeapEntityStandardScheme getScheme() {
      return new NonHeapEntityStandardScheme();
    }
  }

  private static class NonHeapEntityStandardScheme extends org.apache.thrift.scheme.StandardScheme<NonHeapEntity> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, NonHeapEntity struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // NON_HEAP
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.nonHeap = iprot.readI64();
              struct.setNonHeapIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // NON_HEAP_INIT
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.nonHeapInit = iprot.readI64();
              struct.setNonHeapInitIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // NON_HEAP_USED
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.nonHeapUsed = iprot.readI64();
              struct.setNonHeapUsedIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // NON_HEAP_COMMITTED
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.nonHeapCommitted = iprot.readI64();
              struct.setNonHeapCommittedIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, NonHeapEntity struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(NON_HEAP_FIELD_DESC);
      oprot.writeI64(struct.nonHeap);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(NON_HEAP_INIT_FIELD_DESC);
      oprot.writeI64(struct.nonHeapInit);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(NON_HEAP_USED_FIELD_DESC);
      oprot.writeI64(struct.nonHeapUsed);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(NON_HEAP_COMMITTED_FIELD_DESC);
      oprot.writeI64(struct.nonHeapCommitted);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class NonHeapEntityTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public NonHeapEntityTupleScheme getScheme() {
      return new NonHeapEntityTupleScheme();
    }
  }

  private static class NonHeapEntityTupleScheme extends org.apache.thrift.scheme.TupleScheme<NonHeapEntity> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, NonHeapEntity struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetNonHeap()) {
        optionals.set(0);
      }
      if (struct.isSetNonHeapInit()) {
        optionals.set(1);
      }
      if (struct.isSetNonHeapUsed()) {
        optionals.set(2);
      }
      if (struct.isSetNonHeapCommitted()) {
        optionals.set(3);
      }
      oprot.writeBitSet(optionals, 4);
      if (struct.isSetNonHeap()) {
        oprot.writeI64(struct.nonHeap);
      }
      if (struct.isSetNonHeapInit()) {
        oprot.writeI64(struct.nonHeapInit);
      }
      if (struct.isSetNonHeapUsed()) {
        oprot.writeI64(struct.nonHeapUsed);
      }
      if (struct.isSetNonHeapCommitted()) {
        oprot.writeI64(struct.nonHeapCommitted);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, NonHeapEntity struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(4);
      if (incoming.get(0)) {
        struct.nonHeap = iprot.readI64();
        struct.setNonHeapIsSet(true);
      }
      if (incoming.get(1)) {
        struct.nonHeapInit = iprot.readI64();
        struct.setNonHeapInitIsSet(true);
      }
      if (incoming.get(2)) {
        struct.nonHeapUsed = iprot.readI64();
        struct.setNonHeapUsedIsSet(true);
      }
      if (incoming.get(3)) {
        struct.nonHeapCommitted = iprot.readI64();
        struct.setNonHeapCommittedIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

