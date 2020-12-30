/**
 * Autogenerated by Thrift Compiler (0.11.0)
 * <p>
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *
 * @generated
 */
package com.keruyun.commons.agent.collector.entity;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.11.0)", date = "2020-06-10")
public class CpuEntity implements org.apache.thrift.TBase<CpuEntity, CpuEntity._Fields>, java.io.Serializable, Cloneable, Comparable<CpuEntity> {
    private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("CpuEntity");

    private static final org.apache.thrift.protocol.TField PROCESSORS_FIELD_DESC = new org.apache.thrift.protocol.TField("processors", org.apache.thrift.protocol.TType.I32, (short) 1);
    private static final org.apache.thrift.protocol.TField SYSTEMLOAD_AVERAGE_FIELD_DESC = new org.apache.thrift.protocol.TField("systemloadAverage", org.apache.thrift.protocol.TType.DOUBLE, (short) 2);
    private static final org.apache.thrift.protocol.TField PROCESS_CPU_TIME_FIELD_DESC = new org.apache.thrift.protocol.TField("processCpuTime", org.apache.thrift.protocol.TType.I64, (short) 3);
    private static final org.apache.thrift.protocol.TField PROCESS_CPU_LOAD_FIELD_DESC = new org.apache.thrift.protocol.TField("processCpuLoad", org.apache.thrift.protocol.TType.DOUBLE, (short) 4);

    private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new CpuEntityStandardSchemeFactory();
    private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new CpuEntityTupleSchemeFactory();

    public int processors; // required
    public double systemloadAverage; // required
    public long processCpuTime; // required
    public double processCpuLoad; // required

    /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
    public enum _Fields implements org.apache.thrift.TFieldIdEnum {
        PROCESSORS((short) 1, "processors"),
        SYSTEMLOAD_AVERAGE((short) 2, "systemloadAverage"),
        PROCESS_CPU_TIME((short) 3, "processCpuTime"),
        PROCESS_CPU_LOAD((short) 4, "processCpuLoad");

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
            switch (fieldId) {
                case 1: // PROCESSORS
                    return PROCESSORS;
                case 2: // SYSTEMLOAD_AVERAGE
                    return SYSTEMLOAD_AVERAGE;
                case 3: // PROCESS_CPU_TIME
                    return PROCESS_CPU_TIME;
                case 4: // PROCESS_CPU_LOAD
                    return PROCESS_CPU_LOAD;
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
    private static final int __PROCESSORS_ISSET_ID = 0;
    private static final int __SYSTEMLOADAVERAGE_ISSET_ID = 1;
    private static final int __PROCESSCPUTIME_ISSET_ID = 2;
    private static final int __PROCESSCPULOAD_ISSET_ID = 3;
    private byte __isset_bitfield = 0;
    public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;

    static {
        java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
        tmpMap.put(_Fields.PROCESSORS, new org.apache.thrift.meta_data.FieldMetaData("processors", org.apache.thrift.TFieldRequirementType.DEFAULT,
                                                                                     new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
        tmpMap.put(_Fields.SYSTEMLOAD_AVERAGE, new org.apache.thrift.meta_data.FieldMetaData("systemloadAverage", org.apache.thrift.TFieldRequirementType.DEFAULT,
                                                                                             new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE)));
        tmpMap.put(_Fields.PROCESS_CPU_TIME, new org.apache.thrift.meta_data.FieldMetaData("processCpuTime", org.apache.thrift.TFieldRequirementType.DEFAULT,
                                                                                           new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
        tmpMap.put(_Fields.PROCESS_CPU_LOAD, new org.apache.thrift.meta_data.FieldMetaData("processCpuLoad", org.apache.thrift.TFieldRequirementType.DEFAULT,
                                                                                           new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE)));
        metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
        org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(CpuEntity.class, metaDataMap);
    }

    public CpuEntity() {
    }

    public CpuEntity(
        int processors,
        double systemloadAverage,
        long processCpuTime,
        double processCpuLoad) {
        this();
        this.processors = processors;
        setProcessorsIsSet(true);
        this.systemloadAverage = systemloadAverage;
        setSystemloadAverageIsSet(true);
        this.processCpuTime = processCpuTime;
        setProcessCpuTimeIsSet(true);
        this.processCpuLoad = processCpuLoad;
        setProcessCpuLoadIsSet(true);
    }

    /**
     * Performs a deep copy on <i>other</i>.
     */
    public CpuEntity(CpuEntity other) {
        __isset_bitfield = other.__isset_bitfield;
        this.processors = other.processors;
        this.systemloadAverage = other.systemloadAverage;
        this.processCpuTime = other.processCpuTime;
        this.processCpuLoad = other.processCpuLoad;
    }

    public CpuEntity deepCopy() {
        return new CpuEntity(this);
    }

    @Override
    public void clear() {
        setProcessorsIsSet(false);
        this.processors = 0;
        setSystemloadAverageIsSet(false);
        this.systemloadAverage = 0.0;
        setProcessCpuTimeIsSet(false);
        this.processCpuTime = 0;
        setProcessCpuLoadIsSet(false);
        this.processCpuLoad = 0.0;
    }

    public int getProcessors() {
        return this.processors;
    }

    public CpuEntity setProcessors(int processors) {
        this.processors = processors;
        setProcessorsIsSet(true);
        return this;
    }

    public void unsetProcessors() {
        __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __PROCESSORS_ISSET_ID);
    }

    /** Returns true if field processors is set (has been assigned a value) and false otherwise */
    public boolean isSetProcessors() {
        return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __PROCESSORS_ISSET_ID);
    }

    public void setProcessorsIsSet(boolean value) {
        __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __PROCESSORS_ISSET_ID, value);
    }

    public double getSystemloadAverage() {
        return this.systemloadAverage;
    }

    public CpuEntity setSystemloadAverage(double systemloadAverage) {
        this.systemloadAverage = systemloadAverage;
        setSystemloadAverageIsSet(true);
        return this;
    }

    public void unsetSystemloadAverage() {
        __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __SYSTEMLOADAVERAGE_ISSET_ID);
    }

    /** Returns true if field systemloadAverage is set (has been assigned a value) and false otherwise */
    public boolean isSetSystemloadAverage() {
        return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __SYSTEMLOADAVERAGE_ISSET_ID);
    }

    public void setSystemloadAverageIsSet(boolean value) {
        __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __SYSTEMLOADAVERAGE_ISSET_ID, value);
    }

    public long getProcessCpuTime() {
        return this.processCpuTime;
    }

    public CpuEntity setProcessCpuTime(long processCpuTime) {
        this.processCpuTime = processCpuTime;
        setProcessCpuTimeIsSet(true);
        return this;
    }

    public void unsetProcessCpuTime() {
        __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __PROCESSCPUTIME_ISSET_ID);
    }

    /** Returns true if field processCpuTime is set (has been assigned a value) and false otherwise */
    public boolean isSetProcessCpuTime() {
        return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __PROCESSCPUTIME_ISSET_ID);
    }

    public void setProcessCpuTimeIsSet(boolean value) {
        __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __PROCESSCPUTIME_ISSET_ID, value);
    }

    public double getProcessCpuLoad() {
        return this.processCpuLoad;
    }

    public CpuEntity setProcessCpuLoad(double processCpuLoad) {
        this.processCpuLoad = processCpuLoad;
        setProcessCpuLoadIsSet(true);
        return this;
    }

    public void unsetProcessCpuLoad() {
        __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __PROCESSCPULOAD_ISSET_ID);
    }

    /** Returns true if field processCpuLoad is set (has been assigned a value) and false otherwise */
    public boolean isSetProcessCpuLoad() {
        return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __PROCESSCPULOAD_ISSET_ID);
    }

    public void setProcessCpuLoadIsSet(boolean value) {
        __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __PROCESSCPULOAD_ISSET_ID, value);
    }

    public void setFieldValue(_Fields field, Object value) {
        switch (field) {
            case PROCESSORS:
                if (value == null) {
                    unsetProcessors();
                } else {
                    setProcessors((Integer) value);
                }
                break;

            case SYSTEMLOAD_AVERAGE:
                if (value == null) {
                    unsetSystemloadAverage();
                } else {
                    setSystemloadAverage((Double) value);
                }
                break;

            case PROCESS_CPU_TIME:
                if (value == null) {
                    unsetProcessCpuTime();
                } else {
                    setProcessCpuTime((Long) value);
                }
                break;

            case PROCESS_CPU_LOAD:
                if (value == null) {
                    unsetProcessCpuLoad();
                } else {
                    setProcessCpuLoad((Double) value);
                }
                break;

        }
    }

    public Object getFieldValue(_Fields field) {
        switch (field) {
            case PROCESSORS:
                return getProcessors();

            case SYSTEMLOAD_AVERAGE:
                return getSystemloadAverage();

            case PROCESS_CPU_TIME:
                return getProcessCpuTime();

            case PROCESS_CPU_LOAD:
                return getProcessCpuLoad();

        }
        throw new IllegalStateException();
    }

    /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
    public boolean isSet(_Fields field) {
        if (field == null) {
            throw new IllegalArgumentException();
        }

        switch (field) {
            case PROCESSORS:
                return isSetProcessors();
            case SYSTEMLOAD_AVERAGE:
                return isSetSystemloadAverage();
            case PROCESS_CPU_TIME:
                return isSetProcessCpuTime();
            case PROCESS_CPU_LOAD:
                return isSetProcessCpuLoad();
        }
        throw new IllegalStateException();
    }

    @Override
    public boolean equals(Object that) {
        if (that == null)
            return false;
        if (that instanceof CpuEntity)
            return this.equals((CpuEntity) that);
        return false;
    }

    public boolean equals(CpuEntity that) {
        if (that == null)
            return false;
        if (this == that)
            return true;

        boolean this_present_processors = true;
        boolean that_present_processors = true;
        if (this_present_processors || that_present_processors) {
            if (!(this_present_processors && that_present_processors))
                return false;
            if (this.processors != that.processors)
                return false;
        }

        boolean this_present_systemloadAverage = true;
        boolean that_present_systemloadAverage = true;
        if (this_present_systemloadAverage || that_present_systemloadAverage) {
            if (!(this_present_systemloadAverage && that_present_systemloadAverage))
                return false;
            if (this.systemloadAverage != that.systemloadAverage)
                return false;
        }

        boolean this_present_processCpuTime = true;
        boolean that_present_processCpuTime = true;
        if (this_present_processCpuTime || that_present_processCpuTime) {
            if (!(this_present_processCpuTime && that_present_processCpuTime))
                return false;
            if (this.processCpuTime != that.processCpuTime)
                return false;
        }

        boolean this_present_processCpuLoad = true;
        boolean that_present_processCpuLoad = true;
        if (this_present_processCpuLoad || that_present_processCpuLoad) {
            if (!(this_present_processCpuLoad && that_present_processCpuLoad))
                return false;
            if (this.processCpuLoad != that.processCpuLoad)
                return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int hashCode = 1;

        hashCode = hashCode * 8191 + processors;

        hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(systemloadAverage);

        hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(processCpuTime);

        hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(processCpuLoad);

        return hashCode;
    }

    @Override
    public int compareTo(CpuEntity other) {
        if (!getClass().equals(other.getClass())) {
            return getClass().getName().compareTo(other.getClass().getName());
        }

        int lastComparison = 0;

        lastComparison = Boolean.valueOf(isSetProcessors()).compareTo(other.isSetProcessors());
        if (lastComparison != 0) {
            return lastComparison;
        }
        if (isSetProcessors()) {
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.processors, other.processors);
            if (lastComparison != 0) {
                return lastComparison;
            }
        }
        lastComparison = Boolean.valueOf(isSetSystemloadAverage()).compareTo(other.isSetSystemloadAverage());
        if (lastComparison != 0) {
            return lastComparison;
        }
        if (isSetSystemloadAverage()) {
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.systemloadAverage, other.systemloadAverage);
            if (lastComparison != 0) {
                return lastComparison;
            }
        }
        lastComparison = Boolean.valueOf(isSetProcessCpuTime()).compareTo(other.isSetProcessCpuTime());
        if (lastComparison != 0) {
            return lastComparison;
        }
        if (isSetProcessCpuTime()) {
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.processCpuTime, other.processCpuTime);
            if (lastComparison != 0) {
                return lastComparison;
            }
        }
        lastComparison = Boolean.valueOf(isSetProcessCpuLoad()).compareTo(other.isSetProcessCpuLoad());
        if (lastComparison != 0) {
            return lastComparison;
        }
        if (isSetProcessCpuLoad()) {
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.processCpuLoad, other.processCpuLoad);
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
        StringBuilder sb = new StringBuilder("CpuEntity(");
        boolean first = true;

        sb.append("processors:");
        sb.append(this.processors);
        first = false;
        if (!first) sb.append(", ");
        sb.append("systemloadAverage:");
        sb.append(this.systemloadAverage);
        first = false;
        if (!first) sb.append(", ");
        sb.append("processCpuTime:");
        sb.append(this.processCpuTime);
        first = false;
        if (!first) sb.append(", ");
        sb.append("processCpuLoad:");
        sb.append(this.processCpuLoad);
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

    private static class CpuEntityStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
        public CpuEntityStandardScheme getScheme() {
            return new CpuEntityStandardScheme();
        }
    }

    private static class CpuEntityStandardScheme extends org.apache.thrift.scheme.StandardScheme<CpuEntity> {

        public void read(org.apache.thrift.protocol.TProtocol iprot, CpuEntity struct) throws org.apache.thrift.TException {
            org.apache.thrift.protocol.TField schemeField;
            iprot.readStructBegin();
            while (true) {
                schemeField = iprot.readFieldBegin();
                if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {
                    break;
                }
                switch (schemeField.id) {
                    case 1: // PROCESSORS
                        if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
                            struct.processors = iprot.readI32();
                            struct.setProcessorsIsSet(true);
                        } else {
                            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                        }
                        break;
                    case 2: // SYSTEMLOAD_AVERAGE
                        if (schemeField.type == org.apache.thrift.protocol.TType.DOUBLE) {
                            struct.systemloadAverage = iprot.readDouble();
                            struct.setSystemloadAverageIsSet(true);
                        } else {
                            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                        }
                        break;
                    case 3: // PROCESS_CPU_TIME
                        if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
                            struct.processCpuTime = iprot.readI64();
                            struct.setProcessCpuTimeIsSet(true);
                        } else {
                            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                        }
                        break;
                    case 4: // PROCESS_CPU_LOAD
                        if (schemeField.type == org.apache.thrift.protocol.TType.DOUBLE) {
                            struct.processCpuLoad = iprot.readDouble();
                            struct.setProcessCpuLoadIsSet(true);
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

        public void write(org.apache.thrift.protocol.TProtocol oprot, CpuEntity struct) throws org.apache.thrift.TException {
            struct.validate();

            oprot.writeStructBegin(STRUCT_DESC);
            oprot.writeFieldBegin(PROCESSORS_FIELD_DESC);
            oprot.writeI32(struct.processors);
            oprot.writeFieldEnd();
            oprot.writeFieldBegin(SYSTEMLOAD_AVERAGE_FIELD_DESC);
            oprot.writeDouble(struct.systemloadAverage);
            oprot.writeFieldEnd();
            oprot.writeFieldBegin(PROCESS_CPU_TIME_FIELD_DESC);
            oprot.writeI64(struct.processCpuTime);
            oprot.writeFieldEnd();
            oprot.writeFieldBegin(PROCESS_CPU_LOAD_FIELD_DESC);
            oprot.writeDouble(struct.processCpuLoad);
            oprot.writeFieldEnd();
            oprot.writeFieldStop();
            oprot.writeStructEnd();
        }

    }

    private static class CpuEntityTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
        public CpuEntityTupleScheme getScheme() {
            return new CpuEntityTupleScheme();
        }
    }

    private static class CpuEntityTupleScheme extends org.apache.thrift.scheme.TupleScheme<CpuEntity> {

        @Override
        public void write(org.apache.thrift.protocol.TProtocol prot, CpuEntity struct) throws org.apache.thrift.TException {
            org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
            java.util.BitSet optionals = new java.util.BitSet();
            if (struct.isSetProcessors()) {
                optionals.set(0);
            }
            if (struct.isSetSystemloadAverage()) {
                optionals.set(1);
            }
            if (struct.isSetProcessCpuTime()) {
                optionals.set(2);
            }
            if (struct.isSetProcessCpuLoad()) {
                optionals.set(3);
            }
            oprot.writeBitSet(optionals, 4);
            if (struct.isSetProcessors()) {
                oprot.writeI32(struct.processors);
            }
            if (struct.isSetSystemloadAverage()) {
                oprot.writeDouble(struct.systemloadAverage);
            }
            if (struct.isSetProcessCpuTime()) {
                oprot.writeI64(struct.processCpuTime);
            }
            if (struct.isSetProcessCpuLoad()) {
                oprot.writeDouble(struct.processCpuLoad);
            }
        }

        @Override
        public void read(org.apache.thrift.protocol.TProtocol prot, CpuEntity struct) throws org.apache.thrift.TException {
            org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
            java.util.BitSet incoming = iprot.readBitSet(4);
            if (incoming.get(0)) {
                struct.processors = iprot.readI32();
                struct.setProcessorsIsSet(true);
            }
            if (incoming.get(1)) {
                struct.systemloadAverage = iprot.readDouble();
                struct.setSystemloadAverageIsSet(true);
            }
            if (incoming.get(2)) {
                struct.processCpuTime = iprot.readI64();
                struct.setProcessCpuTimeIsSet(true);
            }
            if (incoming.get(3)) {
                struct.processCpuLoad = iprot.readDouble();
                struct.setProcessCpuLoadIsSet(true);
            }
        }
    }

    private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
        return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
    }
}

