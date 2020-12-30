/**
 * Autogenerated by Thrift Compiler (0.11.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.keruyun.commons.agent.collector.entity;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.11.0)", date = "2020-06-10")
public class KafkaConsumerEntity implements org.apache.thrift.TBase<KafkaConsumerEntity, KafkaConsumerEntity._Fields>, java.io.Serializable, Cloneable, Comparable<KafkaConsumerEntity> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("KafkaConsumerEntity");

  private static final org.apache.thrift.protocol.TField GROUP_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("groupId", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField TOPIC_FIELD_DESC = new org.apache.thrift.protocol.TField("topic", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField PARTITION_FIELD_DESC = new org.apache.thrift.protocol.TField("partition", org.apache.thrift.protocol.TType.I32, (short)3);
  private static final org.apache.thrift.protocol.TField CONSUME_COUNT_FIELD_DESC = new org.apache.thrift.protocol.TField("consumeCount", org.apache.thrift.protocol.TType.I32, (short)4);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new KafkaConsumerEntityStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new KafkaConsumerEntityTupleSchemeFactory();

  public String groupId; // required
  public String topic; // required
  public int partition; // required
  public int consumeCount; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    GROUP_ID((short)1, "groupId"),
    TOPIC((short)2, "topic"),
    PARTITION((short)3, "partition"),
    CONSUME_COUNT((short)4, "consumeCount");

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
        case 1: // GROUP_ID
          return GROUP_ID;
        case 2: // TOPIC
          return TOPIC;
        case 3: // PARTITION
          return PARTITION;
        case 4: // CONSUME_COUNT
          return CONSUME_COUNT;
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
  private static final int __CONSUMECOUNT_ISSET_ID = 1;
  private byte __isset_bitfield = 0;
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.GROUP_ID, new org.apache.thrift.meta_data.FieldMetaData("groupId", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.TOPIC, new org.apache.thrift.meta_data.FieldMetaData("topic", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.PARTITION, new org.apache.thrift.meta_data.FieldMetaData("partition", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.CONSUME_COUNT, new org.apache.thrift.meta_data.FieldMetaData("consumeCount", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(KafkaConsumerEntity.class, metaDataMap);
  }

  public KafkaConsumerEntity() {
  }

  public KafkaConsumerEntity(
    String groupId,
    String topic,
    int partition,
    int consumeCount)
  {
    this();
    this.groupId = groupId;
    this.topic = topic;
    this.partition = partition;
    setPartitionIsSet(true);
    this.consumeCount = consumeCount;
    setConsumeCountIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public KafkaConsumerEntity(KafkaConsumerEntity other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetGroupId()) {
      this.groupId = other.groupId;
    }
    if (other.isSetTopic()) {
      this.topic = other.topic;
    }
    this.partition = other.partition;
    this.consumeCount = other.consumeCount;
  }

  public KafkaConsumerEntity deepCopy() {
    return new KafkaConsumerEntity(this);
  }

  @Override
  public void clear() {
    this.groupId = null;
    this.topic = null;
    setPartitionIsSet(false);
    this.partition = 0;
    setConsumeCountIsSet(false);
    this.consumeCount = 0;
  }

  public String getGroupId() {
    return this.groupId;
  }

  public KafkaConsumerEntity setGroupId(String groupId) {
    this.groupId = groupId;
    return this;
  }

  public void unsetGroupId() {
    this.groupId = null;
  }

  /** Returns true if field groupId is set (has been assigned a value) and false otherwise */
  public boolean isSetGroupId() {
    return this.groupId != null;
  }

  public void setGroupIdIsSet(boolean value) {
    if (!value) {
      this.groupId = null;
    }
  }

  public String getTopic() {
    return this.topic;
  }

  public KafkaConsumerEntity setTopic(String topic) {
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

  public KafkaConsumerEntity setPartition(int partition) {
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

  public int getConsumeCount() {
    return this.consumeCount;
  }

  public KafkaConsumerEntity setConsumeCount(int consumeCount) {
    this.consumeCount = consumeCount;
    setConsumeCountIsSet(true);
    return this;
  }

  public void unsetConsumeCount() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __CONSUMECOUNT_ISSET_ID);
  }

  /** Returns true if field consumeCount is set (has been assigned a value) and false otherwise */
  public boolean isSetConsumeCount() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __CONSUMECOUNT_ISSET_ID);
  }

  public void setConsumeCountIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __CONSUMECOUNT_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case GROUP_ID:
      if (value == null) {
        unsetGroupId();
      } else {
        setGroupId((String)value);
      }
      break;

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

    case CONSUME_COUNT:
      if (value == null) {
        unsetConsumeCount();
      } else {
        setConsumeCount((Integer)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case GROUP_ID:
      return getGroupId();

    case TOPIC:
      return getTopic();

    case PARTITION:
      return getPartition();

    case CONSUME_COUNT:
      return getConsumeCount();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case GROUP_ID:
      return isSetGroupId();
    case TOPIC:
      return isSetTopic();
    case PARTITION:
      return isSetPartition();
    case CONSUME_COUNT:
      return isSetConsumeCount();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof KafkaConsumerEntity)
      return this.equals((KafkaConsumerEntity)that);
    return false;
  }

  public boolean equals(KafkaConsumerEntity that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_groupId = true && this.isSetGroupId();
    boolean that_present_groupId = true && that.isSetGroupId();
    if (this_present_groupId || that_present_groupId) {
      if (!(this_present_groupId && that_present_groupId))
        return false;
      if (!this.groupId.equals(that.groupId))
        return false;
    }

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

    boolean this_present_consumeCount = true;
    boolean that_present_consumeCount = true;
    if (this_present_consumeCount || that_present_consumeCount) {
      if (!(this_present_consumeCount && that_present_consumeCount))
        return false;
      if (this.consumeCount != that.consumeCount)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetGroupId()) ? 131071 : 524287);
    if (isSetGroupId())
      hashCode = hashCode * 8191 + groupId.hashCode();

    hashCode = hashCode * 8191 + ((isSetTopic()) ? 131071 : 524287);
    if (isSetTopic())
      hashCode = hashCode * 8191 + topic.hashCode();

    hashCode = hashCode * 8191 + partition;

    hashCode = hashCode * 8191 + consumeCount;

    return hashCode;
  }

  @Override
  public int compareTo(KafkaConsumerEntity other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetGroupId()).compareTo(other.isSetGroupId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetGroupId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.groupId, other.groupId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
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
    lastComparison = Boolean.valueOf(isSetConsumeCount()).compareTo(other.isSetConsumeCount());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetConsumeCount()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.consumeCount, other.consumeCount);
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
    StringBuilder sb = new StringBuilder("KafkaConsumerEntity(");
    boolean first = true;

    sb.append("groupId:");
    if (this.groupId == null) {
      sb.append("null");
    } else {
      sb.append(this.groupId);
    }
    first = false;
    if (!first) sb.append(", ");
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
    sb.append("consumeCount:");
    sb.append(this.consumeCount);
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

  private static class KafkaConsumerEntityStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public KafkaConsumerEntityStandardScheme getScheme() {
      return new KafkaConsumerEntityStandardScheme();
    }
  }

  private static class KafkaConsumerEntityStandardScheme extends org.apache.thrift.scheme.StandardScheme<KafkaConsumerEntity> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, KafkaConsumerEntity struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // GROUP_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.groupId = iprot.readString();
              struct.setGroupIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // TOPIC
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.topic = iprot.readString();
              struct.setTopicIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // PARTITION
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.partition = iprot.readI32();
              struct.setPartitionIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // CONSUME_COUNT
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.consumeCount = iprot.readI32();
              struct.setConsumeCountIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, KafkaConsumerEntity struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.groupId != null) {
        oprot.writeFieldBegin(GROUP_ID_FIELD_DESC);
        oprot.writeString(struct.groupId);
        oprot.writeFieldEnd();
      }
      if (struct.topic != null) {
        oprot.writeFieldBegin(TOPIC_FIELD_DESC);
        oprot.writeString(struct.topic);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(PARTITION_FIELD_DESC);
      oprot.writeI32(struct.partition);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(CONSUME_COUNT_FIELD_DESC);
      oprot.writeI32(struct.consumeCount);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class KafkaConsumerEntityTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public KafkaConsumerEntityTupleScheme getScheme() {
      return new KafkaConsumerEntityTupleScheme();
    }
  }

  private static class KafkaConsumerEntityTupleScheme extends org.apache.thrift.scheme.TupleScheme<KafkaConsumerEntity> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, KafkaConsumerEntity struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetGroupId()) {
        optionals.set(0);
      }
      if (struct.isSetTopic()) {
        optionals.set(1);
      }
      if (struct.isSetPartition()) {
        optionals.set(2);
      }
      if (struct.isSetConsumeCount()) {
        optionals.set(3);
      }
      oprot.writeBitSet(optionals, 4);
      if (struct.isSetGroupId()) {
        oprot.writeString(struct.groupId);
      }
      if (struct.isSetTopic()) {
        oprot.writeString(struct.topic);
      }
      if (struct.isSetPartition()) {
        oprot.writeI32(struct.partition);
      }
      if (struct.isSetConsumeCount()) {
        oprot.writeI32(struct.consumeCount);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, KafkaConsumerEntity struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(4);
      if (incoming.get(0)) {
        struct.groupId = iprot.readString();
        struct.setGroupIdIsSet(true);
      }
      if (incoming.get(1)) {
        struct.topic = iprot.readString();
        struct.setTopicIsSet(true);
      }
      if (incoming.get(2)) {
        struct.partition = iprot.readI32();
        struct.setPartitionIsSet(true);
      }
      if (incoming.get(3)) {
        struct.consumeCount = iprot.readI32();
        struct.setConsumeCountIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

