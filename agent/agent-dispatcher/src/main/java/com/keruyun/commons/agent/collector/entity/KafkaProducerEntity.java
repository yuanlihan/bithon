/**
 * Autogenerated by Thrift Compiler (0.11.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.keruyun.commons.agent.collector.entity;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.11.0)", date = "2020-06-10")
public class KafkaProducerEntity implements org.apache.thrift.TBase<KafkaProducerEntity, KafkaProducerEntity._Fields>, java.io.Serializable, Cloneable, Comparable<KafkaProducerEntity> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("KafkaProducerEntity");

  private static final org.apache.thrift.protocol.TField TOPIC_FIELD_DESC = new org.apache.thrift.protocol.TField("topic", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField PARTITION_FIELD_DESC = new org.apache.thrift.protocol.TField("partition", org.apache.thrift.protocol.TType.I32, (short)2);
  private static final org.apache.thrift.protocol.TField SEND_COUNT_FIELD_DESC = new org.apache.thrift.protocol.TField("sendCount", org.apache.thrift.protocol.TType.I32, (short)3);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new KafkaProducerEntityStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new KafkaProducerEntityTupleSchemeFactory();

  public String topic; // required
  public int partition; // required
  public int sendCount; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    TOPIC((short)1, "topic"),
    PARTITION((short)2, "partition"),
    SEND_COUNT((short)3, "sendCount");

    private static final java.util.Map<String, _Fields> byName = new java.util.HashMap<String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // TOPIC
          return TOPIC;
        case 2: // PARTITION
          return PARTITION;
        case 3: // SEND_COUNT
          return SEND_COUNT;
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
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __PARTITION_ISSET_ID = 0;
  private static final int __SENDCOUNT_ISSET_ID = 1;
  private byte __isset_bitfield = 0;
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.TOPIC, new org.apache.thrift.meta_data.FieldMetaData("topic", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.PARTITION, new org.apache.thrift.meta_data.FieldMetaData("partition", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.SEND_COUNT, new org.apache.thrift.meta_data.FieldMetaData("sendCount", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(KafkaProducerEntity.class, metaDataMap);
  }

  public KafkaProducerEntity() {
  }

  public KafkaProducerEntity(
    String topic,
    int partition,
    int sendCount)
  {
    this();
    this.topic = topic;
    this.partition = partition;
    setPartitionIsSet(true);
    this.sendCount = sendCount;
    setSendCountIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public KafkaProducerEntity(KafkaProducerEntity other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetTopic()) {
      this.topic = other.topic;
    }
    this.partition = other.partition;
    this.sendCount = other.sendCount;
  }

  public KafkaProducerEntity deepCopy() {
    return new KafkaProducerEntity(this);
  }

  @Override
  public void clear() {
    this.topic = null;
    setPartitionIsSet(false);
    this.partition = 0;
    setSendCountIsSet(false);
    this.sendCount = 0;
  }

  public String getTopic() {
    return this.topic;
  }

  public KafkaProducerEntity setTopic(String topic) {
    this.topic = topic;
    return this;
  }

  public void unsetTopic() {
    this.topic = null;
  }

  /** Returns true if field topic is set (has been assigned a value) and false otherwise */
  public boolean isSetTopic() {
    return this.topic != null;
  }

  public void setTopicIsSet(boolean value) {
    if (!value) {
      this.topic = null;
    }
  }

  public int getPartition() {
    return this.partition;
  }

  public KafkaProducerEntity setPartition(int partition) {
    this.partition = partition;
    setPartitionIsSet(true);
    return this;
  }

  public void unsetPartition() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __PARTITION_ISSET_ID);
  }

  /** Returns true if field partition is set (has been assigned a value) and false otherwise */
  public boolean isSetPartition() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __PARTITION_ISSET_ID);
  }

  public void setPartitionIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __PARTITION_ISSET_ID, value);
  }

  public int getSendCount() {
    return this.sendCount;
  }

  public KafkaProducerEntity setSendCount(int sendCount) {
    this.sendCount = sendCount;
    setSendCountIsSet(true);
    return this;
  }

  public void unsetSendCount() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __SENDCOUNT_ISSET_ID);
  }

  /** Returns true if field sendCount is set (has been assigned a value) and false otherwise */
  public boolean isSetSendCount() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __SENDCOUNT_ISSET_ID);
  }

  public void setSendCountIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __SENDCOUNT_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case TOPIC:
      if (value == null) {
        unsetTopic();
      } else {
        setTopic((String)value);
      }
      break;

    case PARTITION:
      if (value == null) {
        unsetPartition();
      } else {
        setPartition((Integer)value);
      }
      break;

    case SEND_COUNT:
      if (value == null) {
        unsetSendCount();
      } else {
        setSendCount((Integer)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case TOPIC:
      return getTopic();

    case PARTITION:
      return getPartition();

    case SEND_COUNT:
      return getSendCount();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case TOPIC:
      return isSetTopic();
    case PARTITION:
      return isSetPartition();
    case SEND_COUNT:
      return isSetSendCount();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof KafkaProducerEntity)
      return this.equals((KafkaProducerEntity)that);
    return false;
  }

  public boolean equals(KafkaProducerEntity that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_topic = true && this.isSetTopic();
    boolean that_present_topic = true && that.isSetTopic();
    if (this_present_topic || that_present_topic) {
      if (!(this_present_topic && that_present_topic))
        return false;
      if (!this.topic.equals(that.topic))
        return false;
    }

    boolean this_present_partition = true;
    boolean that_present_partition = true;
    if (this_present_partition || that_present_partition) {
      if (!(this_present_partition && that_present_partition))
        return false;
      if (this.partition != that.partition)
        return false;
    }

    boolean this_present_sendCount = true;
    boolean that_present_sendCount = true;
    if (this_present_sendCount || that_present_sendCount) {
      if (!(this_present_sendCount && that_present_sendCount))
        return false;
      if (this.sendCount != that.sendCount)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetTopic()) ? 131071 : 524287);
    if (isSetTopic())
      hashCode = hashCode * 8191 + topic.hashCode();

    hashCode = hashCode * 8191 + partition;

    hashCode = hashCode * 8191 + sendCount;

    return hashCode;
  }

  @Override
  public int compareTo(KafkaProducerEntity other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetTopic()).compareTo(other.isSetTopic());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTopic()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.topic, other.topic);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetPartition()).compareTo(other.isSetPartition());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPartition()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.partition, other.partition);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetSendCount()).compareTo(other.isSetSendCount());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSendCount()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.sendCount, other.sendCount);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

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
  public String toString() {
    StringBuilder sb = new StringBuilder("KafkaProducerEntity(");
    boolean first = true;

    sb.append("topic:");
    if (this.topic == null) {
      sb.append("null");
    } else {
      sb.append(this.topic);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("partition:");
    sb.append(this.partition);
    first = false;
    if (!first) sb.append(", ");
    sb.append("sendCount:");
    sb.append(this.sendCount);
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

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class KafkaProducerEntityStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public KafkaProducerEntityStandardScheme getScheme() {
      return new KafkaProducerEntityStandardScheme();
    }
  }

  private static class KafkaProducerEntityStandardScheme extends org.apache.thrift.scheme.StandardScheme<KafkaProducerEntity> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, KafkaProducerEntity struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // TOPIC
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.topic = iprot.readString();
              struct.setTopicIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // PARTITION
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.partition = iprot.readI32();
              struct.setPartitionIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // SEND_COUNT
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.sendCount = iprot.readI32();
              struct.setSendCountIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, KafkaProducerEntity struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.topic != null) {
        oprot.writeFieldBegin(TOPIC_FIELD_DESC);
        oprot.writeString(struct.topic);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(PARTITION_FIELD_DESC);
      oprot.writeI32(struct.partition);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(SEND_COUNT_FIELD_DESC);
      oprot.writeI32(struct.sendCount);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class KafkaProducerEntityTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public KafkaProducerEntityTupleScheme getScheme() {
      return new KafkaProducerEntityTupleScheme();
    }
  }

  private static class KafkaProducerEntityTupleScheme extends org.apache.thrift.scheme.TupleScheme<KafkaProducerEntity> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, KafkaProducerEntity struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetTopic()) {
        optionals.set(0);
      }
      if (struct.isSetPartition()) {
        optionals.set(1);
      }
      if (struct.isSetSendCount()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetTopic()) {
        oprot.writeString(struct.topic);
      }
      if (struct.isSetPartition()) {
        oprot.writeI32(struct.partition);
      }
      if (struct.isSetSendCount()) {
        oprot.writeI32(struct.sendCount);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, KafkaProducerEntity struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        struct.topic = iprot.readString();
        struct.setTopicIsSet(true);
      }
      if (incoming.get(1)) {
        struct.partition = iprot.readI32();
        struct.setPartitionIsSet(true);
      }
      if (incoming.get(2)) {
        struct.sendCount = iprot.readI32();
        struct.setSendCountIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

