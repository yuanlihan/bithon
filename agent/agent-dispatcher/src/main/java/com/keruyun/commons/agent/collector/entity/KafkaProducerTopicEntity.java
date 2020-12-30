/**
 * Autogenerated by Thrift Compiler (0.11.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.keruyun.commons.agent.collector.entity;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.11.0)", date = "2020-06-10")
public class KafkaProducerTopicEntity implements org.apache.thrift.TBase<KafkaProducerTopicEntity, KafkaProducerTopicEntity._Fields>, java.io.Serializable, Cloneable, Comparable<KafkaProducerTopicEntity> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("KafkaProducerTopicEntity");

  private static final org.apache.thrift.protocol.TField CLUSTER_FIELD_DESC = new org.apache.thrift.protocol.TField("cluster", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField CLIENT_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("clientId", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField TOPIC_FIELD_DESC = new org.apache.thrift.protocol.TField("topic", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField BYTE_RATE_FIELD_DESC = new org.apache.thrift.protocol.TField("byteRate", org.apache.thrift.protocol.TType.DOUBLE, (short)4);
  private static final org.apache.thrift.protocol.TField COMPRESSION_RATE_FIELD_DESC = new org.apache.thrift.protocol.TField("compressionRate", org.apache.thrift.protocol.TType.DOUBLE, (short)5);
  private static final org.apache.thrift.protocol.TField RECORD_ERROR_RATE_FIELD_DESC = new org.apache.thrift.protocol.TField("recordErrorRate", org.apache.thrift.protocol.TType.DOUBLE, (short)6);
  private static final org.apache.thrift.protocol.TField RECORD_RETRY_RATE_FIELD_DESC = new org.apache.thrift.protocol.TField("recordRetryRate", org.apache.thrift.protocol.TType.DOUBLE, (short)7);
  private static final org.apache.thrift.protocol.TField RECORD_SEND_RATE_FIELD_DESC = new org.apache.thrift.protocol.TField("recordSendRate", org.apache.thrift.protocol.TType.DOUBLE, (short)8);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new KafkaProducerTopicEntityStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new KafkaProducerTopicEntityTupleSchemeFactory();

  public String cluster; // required
  public String clientId; // required
  public String topic; // required
  public double byteRate; // required
  public double compressionRate; // required
  public double recordErrorRate; // required
  public double recordRetryRate; // required
  public double recordSendRate; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    CLUSTER((short)1, "cluster"),
    CLIENT_ID((short)2, "clientId"),
    TOPIC((short)3, "topic"),
    BYTE_RATE((short)4, "byteRate"),
    COMPRESSION_RATE((short)5, "compressionRate"),
    RECORD_ERROR_RATE((short)6, "recordErrorRate"),
    RECORD_RETRY_RATE((short)7, "recordRetryRate"),
    RECORD_SEND_RATE((short)8, "recordSendRate");

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
        case 1: // CLUSTER
          return CLUSTER;
        case 2: // CLIENT_ID
          return CLIENT_ID;
        case 3: // TOPIC
          return TOPIC;
        case 4: // BYTE_RATE
          return BYTE_RATE;
        case 5: // COMPRESSION_RATE
          return COMPRESSION_RATE;
        case 6: // RECORD_ERROR_RATE
          return RECORD_ERROR_RATE;
        case 7: // RECORD_RETRY_RATE
          return RECORD_RETRY_RATE;
        case 8: // RECORD_SEND_RATE
          return RECORD_SEND_RATE;
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
  private static final int __BYTERATE_ISSET_ID = 0;
  private static final int __COMPRESSIONRATE_ISSET_ID = 1;
  private static final int __RECORDERRORRATE_ISSET_ID = 2;
  private static final int __RECORDRETRYRATE_ISSET_ID = 3;
  private static final int __RECORDSENDRATE_ISSET_ID = 4;
  private byte __isset_bitfield = 0;
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.CLUSTER, new org.apache.thrift.meta_data.FieldMetaData("cluster", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.CLIENT_ID, new org.apache.thrift.meta_data.FieldMetaData("clientId", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.TOPIC, new org.apache.thrift.meta_data.FieldMetaData("topic", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.BYTE_RATE, new org.apache.thrift.meta_data.FieldMetaData("byteRate", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE)));
    tmpMap.put(_Fields.COMPRESSION_RATE, new org.apache.thrift.meta_data.FieldMetaData("compressionRate", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE)));
    tmpMap.put(_Fields.RECORD_ERROR_RATE, new org.apache.thrift.meta_data.FieldMetaData("recordErrorRate", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE)));
    tmpMap.put(_Fields.RECORD_RETRY_RATE, new org.apache.thrift.meta_data.FieldMetaData("recordRetryRate", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE)));
    tmpMap.put(_Fields.RECORD_SEND_RATE, new org.apache.thrift.meta_data.FieldMetaData("recordSendRate", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(KafkaProducerTopicEntity.class, metaDataMap);
  }

  public KafkaProducerTopicEntity() {
  }

  public KafkaProducerTopicEntity(
    String cluster,
    String clientId,
    String topic,
    double byteRate,
    double compressionRate,
    double recordErrorRate,
    double recordRetryRate,
    double recordSendRate)
  {
    this();
    this.cluster = cluster;
    this.clientId = clientId;
    this.topic = topic;
    this.byteRate = byteRate;
    setByteRateIsSet(true);
    this.compressionRate = compressionRate;
    setCompressionRateIsSet(true);
    this.recordErrorRate = recordErrorRate;
    setRecordErrorRateIsSet(true);
    this.recordRetryRate = recordRetryRate;
    setRecordRetryRateIsSet(true);
    this.recordSendRate = recordSendRate;
    setRecordSendRateIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public KafkaProducerTopicEntity(KafkaProducerTopicEntity other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetCluster()) {
      this.cluster = other.cluster;
    }
    if (other.isSetClientId()) {
      this.clientId = other.clientId;
    }
    if (other.isSetTopic()) {
      this.topic = other.topic;
    }
    this.byteRate = other.byteRate;
    this.compressionRate = other.compressionRate;
    this.recordErrorRate = other.recordErrorRate;
    this.recordRetryRate = other.recordRetryRate;
    this.recordSendRate = other.recordSendRate;
  }

  public KafkaProducerTopicEntity deepCopy() {
    return new KafkaProducerTopicEntity(this);
  }

  @Override
  public void clear() {
    this.cluster = null;
    this.clientId = null;
    this.topic = null;
    setByteRateIsSet(false);
    this.byteRate = 0.0;
    setCompressionRateIsSet(false);
    this.compressionRate = 0.0;
    setRecordErrorRateIsSet(false);
    this.recordErrorRate = 0.0;
    setRecordRetryRateIsSet(false);
    this.recordRetryRate = 0.0;
    setRecordSendRateIsSet(false);
    this.recordSendRate = 0.0;
  }

  public String getCluster() {
    return this.cluster;
  }

  public KafkaProducerTopicEntity setCluster(String cluster) {
    this.cluster = cluster;
    return this;
  }

  public void unsetCluster() {
    this.cluster = null;
  }

  /** Returns true if field cluster is set (has been assigned a value) and false otherwise */
  public boolean isSetCluster() {
    return this.cluster != null;
  }

  public void setClusterIsSet(boolean value) {
    if (!value) {
      this.cluster = null;
    }
  }

  public String getClientId() {
    return this.clientId;
  }

  public KafkaProducerTopicEntity setClientId(String clientId) {
    this.clientId = clientId;
    return this;
  }

  public void unsetClientId() {
    this.clientId = null;
  }

  /** Returns true if field clientId is set (has been assigned a value) and false otherwise */
  public boolean isSetClientId() {
    return this.clientId != null;
  }

  public void setClientIdIsSet(boolean value) {
    if (!value) {
      this.clientId = null;
    }
  }

  public String getTopic() {
    return this.topic;
  }

  public KafkaProducerTopicEntity setTopic(String topic) {
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

  public double getByteRate() {
    return this.byteRate;
  }

  public KafkaProducerTopicEntity setByteRate(double byteRate) {
    this.byteRate = byteRate;
    setByteRateIsSet(true);
    return this;
  }

  public void unsetByteRate() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __BYTERATE_ISSET_ID);
  }

  /** Returns true if field byteRate is set (has been assigned a value) and false otherwise */
  public boolean isSetByteRate() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __BYTERATE_ISSET_ID);
  }

  public void setByteRateIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __BYTERATE_ISSET_ID, value);
  }

  public double getCompressionRate() {
    return this.compressionRate;
  }

  public KafkaProducerTopicEntity setCompressionRate(double compressionRate) {
    this.compressionRate = compressionRate;
    setCompressionRateIsSet(true);
    return this;
  }

  public void unsetCompressionRate() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __COMPRESSIONRATE_ISSET_ID);
  }

  /** Returns true if field compressionRate is set (has been assigned a value) and false otherwise */
  public boolean isSetCompressionRate() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __COMPRESSIONRATE_ISSET_ID);
  }

  public void setCompressionRateIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __COMPRESSIONRATE_ISSET_ID, value);
  }

  public double getRecordErrorRate() {
    return this.recordErrorRate;
  }

  public KafkaProducerTopicEntity setRecordErrorRate(double recordErrorRate) {
    this.recordErrorRate = recordErrorRate;
    setRecordErrorRateIsSet(true);
    return this;
  }

  public void unsetRecordErrorRate() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __RECORDERRORRATE_ISSET_ID);
  }

  /** Returns true if field recordErrorRate is set (has been assigned a value) and false otherwise */
  public boolean isSetRecordErrorRate() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __RECORDERRORRATE_ISSET_ID);
  }

  public void setRecordErrorRateIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __RECORDERRORRATE_ISSET_ID, value);
  }

  public double getRecordRetryRate() {
    return this.recordRetryRate;
  }

  public KafkaProducerTopicEntity setRecordRetryRate(double recordRetryRate) {
    this.recordRetryRate = recordRetryRate;
    setRecordRetryRateIsSet(true);
    return this;
  }

  public void unsetRecordRetryRate() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __RECORDRETRYRATE_ISSET_ID);
  }

  /** Returns true if field recordRetryRate is set (has been assigned a value) and false otherwise */
  public boolean isSetRecordRetryRate() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __RECORDRETRYRATE_ISSET_ID);
  }

  public void setRecordRetryRateIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __RECORDRETRYRATE_ISSET_ID, value);
  }

  public double getRecordSendRate() {
    return this.recordSendRate;
  }

  public KafkaProducerTopicEntity setRecordSendRate(double recordSendRate) {
    this.recordSendRate = recordSendRate;
    setRecordSendRateIsSet(true);
    return this;
  }

  public void unsetRecordSendRate() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __RECORDSENDRATE_ISSET_ID);
  }

  /** Returns true if field recordSendRate is set (has been assigned a value) and false otherwise */
  public boolean isSetRecordSendRate() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __RECORDSENDRATE_ISSET_ID);
  }

  public void setRecordSendRateIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __RECORDSENDRATE_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case CLUSTER:
      if (value == null) {
        unsetCluster();
      } else {
        setCluster((String)value);
      }
      break;

    case CLIENT_ID:
      if (value == null) {
        unsetClientId();
      } else {
        setClientId((String)value);
      }
      break;

    case TOPIC:
      if (value == null) {
        unsetTopic();
      } else {
        setTopic((String)value);
      }
      break;

    case BYTE_RATE:
      if (value == null) {
        unsetByteRate();
      } else {
        setByteRate((Double)value);
      }
      break;

    case COMPRESSION_RATE:
      if (value == null) {
        unsetCompressionRate();
      } else {
        setCompressionRate((Double)value);
      }
      break;

    case RECORD_ERROR_RATE:
      if (value == null) {
        unsetRecordErrorRate();
      } else {
        setRecordErrorRate((Double)value);
      }
      break;

    case RECORD_RETRY_RATE:
      if (value == null) {
        unsetRecordRetryRate();
      } else {
        setRecordRetryRate((Double)value);
      }
      break;

    case RECORD_SEND_RATE:
      if (value == null) {
        unsetRecordSendRate();
      } else {
        setRecordSendRate((Double)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case CLUSTER:
      return getCluster();

    case CLIENT_ID:
      return getClientId();

    case TOPIC:
      return getTopic();

    case BYTE_RATE:
      return getByteRate();

    case COMPRESSION_RATE:
      return getCompressionRate();

    case RECORD_ERROR_RATE:
      return getRecordErrorRate();

    case RECORD_RETRY_RATE:
      return getRecordRetryRate();

    case RECORD_SEND_RATE:
      return getRecordSendRate();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case CLUSTER:
      return isSetCluster();
    case CLIENT_ID:
      return isSetClientId();
    case TOPIC:
      return isSetTopic();
    case BYTE_RATE:
      return isSetByteRate();
    case COMPRESSION_RATE:
      return isSetCompressionRate();
    case RECORD_ERROR_RATE:
      return isSetRecordErrorRate();
    case RECORD_RETRY_RATE:
      return isSetRecordRetryRate();
    case RECORD_SEND_RATE:
      return isSetRecordSendRate();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof KafkaProducerTopicEntity)
      return this.equals((KafkaProducerTopicEntity)that);
    return false;
  }

  public boolean equals(KafkaProducerTopicEntity that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_cluster = true && this.isSetCluster();
    boolean that_present_cluster = true && that.isSetCluster();
    if (this_present_cluster || that_present_cluster) {
      if (!(this_present_cluster && that_present_cluster))
        return false;
      if (!this.cluster.equals(that.cluster))
        return false;
    }

    boolean this_present_clientId = true && this.isSetClientId();
    boolean that_present_clientId = true && that.isSetClientId();
    if (this_present_clientId || that_present_clientId) {
      if (!(this_present_clientId && that_present_clientId))
        return false;
      if (!this.clientId.equals(that.clientId))
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

    boolean this_present_byteRate = true;
    boolean that_present_byteRate = true;
    if (this_present_byteRate || that_present_byteRate) {
      if (!(this_present_byteRate && that_present_byteRate))
        return false;
      if (this.byteRate != that.byteRate)
        return false;
    }

    boolean this_present_compressionRate = true;
    boolean that_present_compressionRate = true;
    if (this_present_compressionRate || that_present_compressionRate) {
      if (!(this_present_compressionRate && that_present_compressionRate))
        return false;
      if (this.compressionRate != that.compressionRate)
        return false;
    }

    boolean this_present_recordErrorRate = true;
    boolean that_present_recordErrorRate = true;
    if (this_present_recordErrorRate || that_present_recordErrorRate) {
      if (!(this_present_recordErrorRate && that_present_recordErrorRate))
        return false;
      if (this.recordErrorRate != that.recordErrorRate)
        return false;
    }

    boolean this_present_recordRetryRate = true;
    boolean that_present_recordRetryRate = true;
    if (this_present_recordRetryRate || that_present_recordRetryRate) {
      if (!(this_present_recordRetryRate && that_present_recordRetryRate))
        return false;
      if (this.recordRetryRate != that.recordRetryRate)
        return false;
    }

    boolean this_present_recordSendRate = true;
    boolean that_present_recordSendRate = true;
    if (this_present_recordSendRate || that_present_recordSendRate) {
      if (!(this_present_recordSendRate && that_present_recordSendRate))
        return false;
      if (this.recordSendRate != that.recordSendRate)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetCluster()) ? 131071 : 524287);
    if (isSetCluster())
      hashCode = hashCode * 8191 + cluster.hashCode();

    hashCode = hashCode * 8191 + ((isSetClientId()) ? 131071 : 524287);
    if (isSetClientId())
      hashCode = hashCode * 8191 + clientId.hashCode();

    hashCode = hashCode * 8191 + ((isSetTopic()) ? 131071 : 524287);
    if (isSetTopic())
      hashCode = hashCode * 8191 + topic.hashCode();

    hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(byteRate);

    hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(compressionRate);

    hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(recordErrorRate);

    hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(recordRetryRate);

    hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(recordSendRate);

    return hashCode;
  }

  @Override
  public int compareTo(KafkaProducerTopicEntity other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetCluster()).compareTo(other.isSetCluster());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCluster()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.cluster, other.cluster);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetClientId()).compareTo(other.isSetClientId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetClientId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.clientId, other.clientId);
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
    lastComparison = Boolean.valueOf(isSetByteRate()).compareTo(other.isSetByteRate());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetByteRate()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.byteRate, other.byteRate);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetCompressionRate()).compareTo(other.isSetCompressionRate());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCompressionRate()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.compressionRate, other.compressionRate);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetRecordErrorRate()).compareTo(other.isSetRecordErrorRate());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetRecordErrorRate()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.recordErrorRate, other.recordErrorRate);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetRecordRetryRate()).compareTo(other.isSetRecordRetryRate());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetRecordRetryRate()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.recordRetryRate, other.recordRetryRate);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetRecordSendRate()).compareTo(other.isSetRecordSendRate());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetRecordSendRate()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.recordSendRate, other.recordSendRate);
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
    StringBuilder sb = new StringBuilder("KafkaProducerTopicEntity(");
    boolean first = true;

    sb.append("cluster:");
    if (this.cluster == null) {
      sb.append("null");
    } else {
      sb.append(this.cluster);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("clientId:");
    if (this.clientId == null) {
      sb.append("null");
    } else {
      sb.append(this.clientId);
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
    sb.append("byteRate:");
    sb.append(this.byteRate);
    first = false;
    if (!first) sb.append(", ");
    sb.append("compressionRate:");
    sb.append(this.compressionRate);
    first = false;
    if (!first) sb.append(", ");
    sb.append("recordErrorRate:");
    sb.append(this.recordErrorRate);
    first = false;
    if (!first) sb.append(", ");
    sb.append("recordRetryRate:");
    sb.append(this.recordRetryRate);
    first = false;
    if (!first) sb.append(", ");
    sb.append("recordSendRate:");
    sb.append(this.recordSendRate);
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

  private static class KafkaProducerTopicEntityStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public KafkaProducerTopicEntityStandardScheme getScheme() {
      return new KafkaProducerTopicEntityStandardScheme();
    }
  }

  private static class KafkaProducerTopicEntityStandardScheme extends org.apache.thrift.scheme.StandardScheme<KafkaProducerTopicEntity> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, KafkaProducerTopicEntity struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // CLUSTER
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.cluster = iprot.readString();
              struct.setClusterIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // CLIENT_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.clientId = iprot.readString();
              struct.setClientIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // TOPIC
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.topic = iprot.readString();
              struct.setTopicIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // BYTE_RATE
            if (schemeField.type == org.apache.thrift.protocol.TType.DOUBLE) {
              struct.byteRate = iprot.readDouble();
              struct.setByteRateIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // COMPRESSION_RATE
            if (schemeField.type == org.apache.thrift.protocol.TType.DOUBLE) {
              struct.compressionRate = iprot.readDouble();
              struct.setCompressionRateIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // RECORD_ERROR_RATE
            if (schemeField.type == org.apache.thrift.protocol.TType.DOUBLE) {
              struct.recordErrorRate = iprot.readDouble();
              struct.setRecordErrorRateIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 7: // RECORD_RETRY_RATE
            if (schemeField.type == org.apache.thrift.protocol.TType.DOUBLE) {
              struct.recordRetryRate = iprot.readDouble();
              struct.setRecordRetryRateIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 8: // RECORD_SEND_RATE
            if (schemeField.type == org.apache.thrift.protocol.TType.DOUBLE) {
              struct.recordSendRate = iprot.readDouble();
              struct.setRecordSendRateIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, KafkaProducerTopicEntity struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.cluster != null) {
        oprot.writeFieldBegin(CLUSTER_FIELD_DESC);
        oprot.writeString(struct.cluster);
        oprot.writeFieldEnd();
      }
      if (struct.clientId != null) {
        oprot.writeFieldBegin(CLIENT_ID_FIELD_DESC);
        oprot.writeString(struct.clientId);
        oprot.writeFieldEnd();
      }
      if (struct.topic != null) {
        oprot.writeFieldBegin(TOPIC_FIELD_DESC);
        oprot.writeString(struct.topic);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(BYTE_RATE_FIELD_DESC);
      oprot.writeDouble(struct.byteRate);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(COMPRESSION_RATE_FIELD_DESC);
      oprot.writeDouble(struct.compressionRate);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(RECORD_ERROR_RATE_FIELD_DESC);
      oprot.writeDouble(struct.recordErrorRate);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(RECORD_RETRY_RATE_FIELD_DESC);
      oprot.writeDouble(struct.recordRetryRate);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(RECORD_SEND_RATE_FIELD_DESC);
      oprot.writeDouble(struct.recordSendRate);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class KafkaProducerTopicEntityTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public KafkaProducerTopicEntityTupleScheme getScheme() {
      return new KafkaProducerTopicEntityTupleScheme();
    }
  }

  private static class KafkaProducerTopicEntityTupleScheme extends org.apache.thrift.scheme.TupleScheme<KafkaProducerTopicEntity> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, KafkaProducerTopicEntity struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetCluster()) {
        optionals.set(0);
      }
      if (struct.isSetClientId()) {
        optionals.set(1);
      }
      if (struct.isSetTopic()) {
        optionals.set(2);
      }
      if (struct.isSetByteRate()) {
        optionals.set(3);
      }
      if (struct.isSetCompressionRate()) {
        optionals.set(4);
      }
      if (struct.isSetRecordErrorRate()) {
        optionals.set(5);
      }
      if (struct.isSetRecordRetryRate()) {
        optionals.set(6);
      }
      if (struct.isSetRecordSendRate()) {
        optionals.set(7);
      }
      oprot.writeBitSet(optionals, 8);
      if (struct.isSetCluster()) {
        oprot.writeString(struct.cluster);
      }
      if (struct.isSetClientId()) {
        oprot.writeString(struct.clientId);
      }
      if (struct.isSetTopic()) {
        oprot.writeString(struct.topic);
      }
      if (struct.isSetByteRate()) {
        oprot.writeDouble(struct.byteRate);
      }
      if (struct.isSetCompressionRate()) {
        oprot.writeDouble(struct.compressionRate);
      }
      if (struct.isSetRecordErrorRate()) {
        oprot.writeDouble(struct.recordErrorRate);
      }
      if (struct.isSetRecordRetryRate()) {
        oprot.writeDouble(struct.recordRetryRate);
      }
      if (struct.isSetRecordSendRate()) {
        oprot.writeDouble(struct.recordSendRate);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, KafkaProducerTopicEntity struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(8);
      if (incoming.get(0)) {
        struct.cluster = iprot.readString();
        struct.setClusterIsSet(true);
      }
      if (incoming.get(1)) {
        struct.clientId = iprot.readString();
        struct.setClientIdIsSet(true);
      }
      if (incoming.get(2)) {
        struct.topic = iprot.readString();
        struct.setTopicIsSet(true);
      }
      if (incoming.get(3)) {
        struct.byteRate = iprot.readDouble();
        struct.setByteRateIsSet(true);
      }
      if (incoming.get(4)) {
        struct.compressionRate = iprot.readDouble();
        struct.setCompressionRateIsSet(true);
      }
      if (incoming.get(5)) {
        struct.recordErrorRate = iprot.readDouble();
        struct.setRecordErrorRateIsSet(true);
      }
      if (incoming.get(6)) {
        struct.recordRetryRate = iprot.readDouble();
        struct.setRecordRetryRateIsSet(true);
      }
      if (incoming.get(7)) {
        struct.recordSendRate = iprot.readDouble();
        struct.setRecordSendRateIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

