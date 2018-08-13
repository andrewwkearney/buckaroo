/*
 * Copyright © 2018 androsaces. All rights reserved.
 */

package com.androsaces.buckaroo.config;

/**
 * An enum that represents the valid versions of the Java specification. This
 * is intended to mirror the versions available from the
 * {@code java.specification.version} System Property.
 *
 * @author Andrew Kearney
 * @since 1.0
 */
public enum JavaVersion {
    /**
     * JDK 1.1
     */
    JAVA_1_1(1.1f, "1.1"),

    /**
     * J2SE 1.2
     */
    JAVA_1_2(1.2f, "1.2"),

    /**
     * J2SE 1.3
     */
    JAVA_1_3(1.3f, "1.3"),

    /**
     * J2SE 1.4
     */
    JAVA_1_4(1.4f, "1.4"),

    /**
     * J2SE 5.0
     */
    JAVA_1_5(1.5f, "1.5"),

    /**
     * Java SE 6
     */
    JAVA_1_6(1.6f, "6"),

    /**
     * Java SE 7
     */
    JAVA_1_7(1.7f, "7"),

    /**
     * Java SE 8
     */
    JAVA_1_8(1.8f, "8"),

    /**
     * Java SE 9
     */
    JAVA_9(9.0f, "9"),

    /**
     * Java SE 10
     */
    JAVA_10(10.0f, "10"),

    /**
     * Java SE 11
     */
    JAVA_11(11.0f, "11");

    private final float value;
    private final String name;

    JavaVersion(float value, String name) {
        this.value = value;
        this.name = name;
    }

    public float getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public boolean atLeast(JavaVersion requiredVersion) {
        return this.value >= requiredVersion.value;
    }

    static JavaVersion get(String version) {
        if ("1.1".equals(version)) return JAVA_1_1;
        else if ("1.2".equals(version)) return JAVA_1_2;
        else if ("1.3".equals(version)) return JAVA_1_3;
        else if ("1.4".equals(version)) return JAVA_1_4;
        else if ("1.5".equals(version)) return JAVA_1_5;
        else if ("1.6".equals(version)) return JAVA_1_6;
        else if ("1.7".equals(version)) return JAVA_1_7;
        else if ("1.8".equals(version)) return JAVA_1_8;
        else if ("9".equals(version)) return JAVA_9;
        else if ("10".equals(version)) return JAVA_10;
        else if ("11".equals(version)) return JAVA_11;
        else return null;
    }
}
