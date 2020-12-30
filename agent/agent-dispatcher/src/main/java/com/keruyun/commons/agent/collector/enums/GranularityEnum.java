/**
 * Autogenerated by Thrift Compiler (0.11.0)
 * <p>
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *
 * @generated
 */
package com.keruyun.commons.agent.collector.enums;


/**
 * 聚合粒度类型
 */
public enum GranularityEnum implements org.apache.thrift.TEnum {
    TEN_MINUTES(0),
    THIRTY_MINUTES(1),
    ONE_HOUR(2),
    ONE_DAY(3);

    private final int value;

    private GranularityEnum(int value) {
        this.value = value;
    }

    /**
     * Get the integer value of this enum value, as defined in the Thrift IDL.
     */
    public int getValue() {
        return value;
    }

    /**
     * Find a the enum type by its integer value, as defined in the Thrift IDL.
     * @return null if the value is not found.
     */
    public static GranularityEnum findByValue(int value) {
        switch (value) {
            case 0:
                return TEN_MINUTES;
            case 1:
                return THIRTY_MINUTES;
            case 2:
                return ONE_HOUR;
            case 3:
                return ONE_DAY;
            default:
                return null;
        }
    }
}
