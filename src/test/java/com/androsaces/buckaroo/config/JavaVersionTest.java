/*
 * Copyright © 2018 androsaces. All rights reserved.
 */

package com.androsaces.buckaroo.config;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Unit test for the {@link JavaVersion} class.
 *
 * @author Andrew Kearney
 */
class JavaVersionTest {
    @Test
    void testGetName() {
        Assertions.assertEquals("1.1", JavaVersion.JAVA_1_1.getName());
        Assertions.assertEquals("1.2", JavaVersion.JAVA_1_2.getName());
        Assertions.assertEquals("1.3", JavaVersion.JAVA_1_3.getName());
        Assertions.assertEquals("1.4", JavaVersion.JAVA_1_4.getName());
        Assertions.assertEquals("1.5", JavaVersion.JAVA_1_5.getName());
        Assertions.assertEquals("6",   JavaVersion.JAVA_1_6.getName());
        Assertions.assertEquals("7",   JavaVersion.JAVA_1_7.getName());
        Assertions.assertEquals("8",   JavaVersion.JAVA_1_8.getName());
        Assertions.assertEquals("9",   JavaVersion.JAVA_9.getName());
        Assertions.assertEquals("10",  JavaVersion.JAVA_10.getName());
    }

    @Test
    void testGetValue() {
        Assertions.assertEquals(1.1f,  JavaVersion.JAVA_1_1.getValue());
        Assertions.assertEquals(1.2f,  JavaVersion.JAVA_1_2.getValue());
        Assertions.assertEquals(1.3f,  JavaVersion.JAVA_1_3.getValue());
        Assertions.assertEquals(1.4f,  JavaVersion.JAVA_1_4.getValue());
        Assertions.assertEquals(1.5f,  JavaVersion.JAVA_1_5.getValue());
        Assertions.assertEquals(1.6f,  JavaVersion.JAVA_1_6.getValue());
        Assertions.assertEquals(1.7f,  JavaVersion.JAVA_1_7.getValue());
        Assertions.assertEquals(1.8f,  JavaVersion.JAVA_1_8.getValue());
        Assertions.assertEquals(9.0f,  JavaVersion.JAVA_9.getValue());
        Assertions.assertEquals(10.0f, JavaVersion.JAVA_10.getValue());
    }

    @Test
    void testToString() {
        Assertions.assertEquals("1.1", JavaVersion.JAVA_1_1.toString());
        Assertions.assertEquals("1.2", JavaVersion.JAVA_1_2.toString());
        Assertions.assertEquals("1.3", JavaVersion.JAVA_1_3.toString());
        Assertions.assertEquals("1.4", JavaVersion.JAVA_1_4.toString());
        Assertions.assertEquals("1.5", JavaVersion.JAVA_1_5.toString());
        Assertions.assertEquals("6",   JavaVersion.JAVA_1_6.toString());
        Assertions.assertEquals("7",   JavaVersion.JAVA_1_7.toString());
        Assertions.assertEquals("8",   JavaVersion.JAVA_1_8.toString());
        Assertions.assertEquals("9",   JavaVersion.JAVA_9.toString());
        Assertions.assertEquals("10",  JavaVersion.JAVA_10.toString());
    }

    @Test
    void testGetVersion() {
        Assertions.assertEquals(JavaVersion.JAVA_1_1, JavaVersion.get("1.1"));
        Assertions.assertEquals(JavaVersion.JAVA_1_2, JavaVersion.get("1.2"));
        Assertions.assertEquals(JavaVersion.JAVA_1_3, JavaVersion.get("1.3"));
        Assertions.assertEquals(JavaVersion.JAVA_1_4, JavaVersion.get("1.4"));
        Assertions.assertEquals(JavaVersion.JAVA_1_5, JavaVersion.get("1.5"));
        Assertions.assertEquals(JavaVersion.JAVA_1_6, JavaVersion.get("1.6"));
        Assertions.assertEquals(JavaVersion.JAVA_1_7, JavaVersion.get("1.7"));
        Assertions.assertEquals(JavaVersion.JAVA_1_8, JavaVersion.get("1.8"));
        Assertions.assertEquals(JavaVersion.JAVA_9,   JavaVersion.get("9"));
        Assertions.assertEquals(JavaVersion.JAVA_10,  JavaVersion.get("10"));
        assertNull(JavaVersion.get("2017"));
    }

    @Test
    void testAtLeast() {
        Assertions.assertTrue(JavaVersion.JAVA_1_1.atLeast(JavaVersion.JAVA_1_1));
        Assertions.assertFalse(JavaVersion.JAVA_1_1.atLeast(JavaVersion.JAVA_1_2));
        Assertions.assertFalse(JavaVersion.JAVA_1_1.atLeast(JavaVersion.JAVA_1_3));
        Assertions.assertFalse(JavaVersion.JAVA_1_1.atLeast(JavaVersion.JAVA_1_4));
        Assertions.assertFalse(JavaVersion.JAVA_1_1.atLeast(JavaVersion.JAVA_1_5));
        Assertions.assertFalse(JavaVersion.JAVA_1_1.atLeast(JavaVersion.JAVA_1_6));
        Assertions.assertFalse(JavaVersion.JAVA_1_1.atLeast(JavaVersion.JAVA_1_7));
        Assertions.assertFalse(JavaVersion.JAVA_1_1.atLeast(JavaVersion.JAVA_1_8));
        Assertions.assertFalse(JavaVersion.JAVA_1_1.atLeast(JavaVersion.JAVA_9));
        Assertions.assertFalse(JavaVersion.JAVA_1_1.atLeast(JavaVersion.JAVA_10));

        Assertions.assertTrue(JavaVersion.JAVA_10.atLeast(JavaVersion.JAVA_1_1));
        Assertions.assertTrue(JavaVersion.JAVA_10.atLeast(JavaVersion.JAVA_1_2));
        Assertions.assertTrue(JavaVersion.JAVA_10.atLeast(JavaVersion.JAVA_1_3));
        Assertions.assertTrue(JavaVersion.JAVA_10.atLeast(JavaVersion.JAVA_1_4));
        Assertions.assertTrue(JavaVersion.JAVA_10.atLeast(JavaVersion.JAVA_1_5));
        Assertions.assertTrue(JavaVersion.JAVA_10.atLeast(JavaVersion.JAVA_1_6));
        Assertions.assertTrue(JavaVersion.JAVA_10.atLeast(JavaVersion.JAVA_1_7));
        Assertions.assertTrue(JavaVersion.JAVA_10.atLeast(JavaVersion.JAVA_1_8));
        Assertions.assertTrue(JavaVersion.JAVA_10.atLeast(JavaVersion.JAVA_9));
        Assertions.assertTrue(JavaVersion.JAVA_10.atLeast(JavaVersion.JAVA_10));
    }
}