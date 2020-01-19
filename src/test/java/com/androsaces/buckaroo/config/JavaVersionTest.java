/*
 * Copyright &copy; 2018 androsaces. All rights reserved.
 */

package com.androsaces.buckaroo.config;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Unit test for the {@link JavaVersion} class.
 *
 * @author Andrew Kearney
 */
class JavaVersionTest {
    @Test
    void testGetName() {
        assertEquals("1.1", JavaVersion.JAVA_1_1.getName());
        assertEquals("1.2", JavaVersion.JAVA_1_2.getName());
        assertEquals("1.3", JavaVersion.JAVA_1_3.getName());
        assertEquals("1.4", JavaVersion.JAVA_1_4.getName());
        assertEquals("1.5", JavaVersion.JAVA_1_5.getName());
        assertEquals("6",   JavaVersion.JAVA_1_6.getName());
        assertEquals("7",   JavaVersion.JAVA_1_7.getName());
        assertEquals("8",   JavaVersion.JAVA_1_8.getName());
        assertEquals("9",   JavaVersion.JAVA_9.getName());
        assertEquals("10",  JavaVersion.JAVA_10.getName());
        assertEquals("11",  JavaVersion.JAVA_11.getName());
    }

    @Test
    void testGetValue() {
        assertEquals(1.1f,  JavaVersion.JAVA_1_1.getValue());
        assertEquals(1.2f,  JavaVersion.JAVA_1_2.getValue());
        assertEquals(1.3f,  JavaVersion.JAVA_1_3.getValue());
        assertEquals(1.4f,  JavaVersion.JAVA_1_4.getValue());
        assertEquals(1.5f,  JavaVersion.JAVA_1_5.getValue());
        assertEquals(1.6f,  JavaVersion.JAVA_1_6.getValue());
        assertEquals(1.7f,  JavaVersion.JAVA_1_7.getValue());
        assertEquals(1.8f,  JavaVersion.JAVA_1_8.getValue());
        assertEquals(9.0f,  JavaVersion.JAVA_9.getValue());
        assertEquals(10.0f, JavaVersion.JAVA_10.getValue());
        assertEquals(11.0f, JavaVersion.JAVA_11.getValue());
    }

    @Test
    void testToString() {
        assertEquals("1.1", JavaVersion.JAVA_1_1.toString());
        assertEquals("1.2", JavaVersion.JAVA_1_2.toString());
        assertEquals("1.3", JavaVersion.JAVA_1_3.toString());
        assertEquals("1.4", JavaVersion.JAVA_1_4.toString());
        assertEquals("1.5", JavaVersion.JAVA_1_5.toString());
        assertEquals("6",   JavaVersion.JAVA_1_6.toString());
        assertEquals("7",   JavaVersion.JAVA_1_7.toString());
        assertEquals("8",   JavaVersion.JAVA_1_8.toString());
        assertEquals("9",   JavaVersion.JAVA_9.toString());
        assertEquals("10",  JavaVersion.JAVA_10.toString());
        assertEquals("11",  JavaVersion.JAVA_11.toString());
    }

    @Test
    void testGetVersion() {
        assertEquals(JavaVersion.JAVA_1_1, JavaVersion.get("1.1"));
        assertEquals(JavaVersion.JAVA_1_2, JavaVersion.get("1.2"));
        assertEquals(JavaVersion.JAVA_1_3, JavaVersion.get("1.3"));
        assertEquals(JavaVersion.JAVA_1_4, JavaVersion.get("1.4"));
        assertEquals(JavaVersion.JAVA_1_5, JavaVersion.get("1.5"));
        assertEquals(JavaVersion.JAVA_1_6, JavaVersion.get("1.6"));
        assertEquals(JavaVersion.JAVA_1_7, JavaVersion.get("1.7"));
        assertEquals(JavaVersion.JAVA_1_8, JavaVersion.get("1.8"));
        assertEquals(JavaVersion.JAVA_9,   JavaVersion.get("9"));
        assertEquals(JavaVersion.JAVA_10,  JavaVersion.get("10"));
        assertEquals(JavaVersion.JAVA_11,  JavaVersion.get("11"));
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
        Assertions.assertFalse(JavaVersion.JAVA_1_1.atLeast(JavaVersion.JAVA_11));

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
        Assertions.assertFalse(JavaVersion.JAVA_10.atLeast(JavaVersion.JAVA_11));
    }
}