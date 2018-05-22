/*
 * Copyright © 2018 androsaces. All rights reserved.
 */

package com.androsaces.buckaroo.config;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Andrew Kearney
 */
class SystemInfoTest {
    private static final String OS_NAME = "os.name";
    private static final String OS_VERSION = "os.version";

    private String oldOsName;
    private String oldOsVersion;
    private String newOsName;
    private String newOsVersion;

    @Test
    void testAtLeast() {
        assertTrue(SystemInfo.isJavaVersionAtLeast(JavaVersion.JAVA_1_1));
        assertTrue(SystemInfo.isJavaVersionAtLeast(JavaVersion.JAVA_1_2));
        assertTrue(SystemInfo.isJavaVersionAtLeast(JavaVersion.JAVA_1_3));
    }
}