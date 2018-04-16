/*
 * Copyright © 2018 androsaces. All rights reserved.
 */

package com.androsaces.tools.buckaroo.config;

import org.junit.jupiter.api.Test;

import static com.androsaces.tools.buckaroo.config.JavaVersion.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for the {@link JavaVersion} class.
 *
 * @author Andrew Kearney
 */
class JavaVersionTest {
    @Test
    void testGetName() {
        assertEquals("1.1", JAVA_1_1.getName());
        assertEquals("1.2", JAVA_1_2.getName());
        assertEquals("1.3", JAVA_1_3.getName());
        assertEquals("1.4", JAVA_1_4.getName());
        assertEquals("1.5", JAVA_1_5.getName());
        assertEquals("6",   JAVA_1_6.getName());
        assertEquals("7",   JAVA_1_7.getName());
        assertEquals("8",   JAVA_1_8.getName());
        assertEquals("9",   JAVA_9.getName());
        assertEquals("10",  JAVA_10.getName());
    }

    @Test
    void testGetValue() {
        assertEquals(1.1f,  JAVA_1_1.getValue());
        assertEquals(1.2f,  JAVA_1_2.getValue());
        assertEquals(1.3f,  JAVA_1_3.getValue());
        assertEquals(1.4f,  JAVA_1_4.getValue());
        assertEquals(1.5f,  JAVA_1_5.getValue());
        assertEquals(1.6f,  JAVA_1_6.getValue());
        assertEquals(1.7f,  JAVA_1_7.getValue());
        assertEquals(1.8f,  JAVA_1_8.getValue());
        assertEquals(9.0f,  JAVA_9.getValue());
        assertEquals(10.0f, JAVA_10.getValue());
    }

    @Test
    void testToString() {
        assertEquals("1.1", JAVA_1_1.toString());
        assertEquals("1.2", JAVA_1_2.toString());
        assertEquals("1.3", JAVA_1_3.toString());
        assertEquals("1.4", JAVA_1_4.toString());
        assertEquals("1.5", JAVA_1_5.toString());
        assertEquals("6",   JAVA_1_6.toString());
        assertEquals("7",   JAVA_1_7.toString());
        assertEquals("8",   JAVA_1_8.toString());
        assertEquals("9",   JAVA_9.toString());
        assertEquals("10",  JAVA_10.toString());
    }

    @Test
    void testGetVersion() {
        assertEquals(JAVA_1_1, JavaVersion.get("1.1"));
        assertEquals(JAVA_1_2, JavaVersion.get("1.2"));
        assertEquals(JAVA_1_3, JavaVersion.get("1.3"));
        assertEquals(JAVA_1_4, JavaVersion.get("1.4"));
        assertEquals(JAVA_1_5, JavaVersion.get("1.5"));
        assertEquals(JAVA_1_6, JavaVersion.get("1.6"));
        assertEquals(JAVA_1_7, JavaVersion.get("1.7"));
        assertEquals(JAVA_1_8, JavaVersion.get("1.8"));
        assertEquals(JAVA_9,   JavaVersion.get("9"));
        assertEquals(JAVA_10,  JavaVersion.get("10"));
        assertNull(JavaVersion.get("2017"));
    }

    @Test
    void testAtLeast() {
        assertTrue(JAVA_1_1.atLeast(JAVA_1_1));
        assertFalse(JAVA_1_1.atLeast(JAVA_1_2));
        assertFalse(JAVA_1_1.atLeast(JAVA_1_3));
        assertFalse(JAVA_1_1.atLeast(JAVA_1_4));
        assertFalse(JAVA_1_1.atLeast(JAVA_1_5));
        assertFalse(JAVA_1_1.atLeast(JAVA_1_6));
        assertFalse(JAVA_1_1.atLeast(JAVA_1_7));
        assertFalse(JAVA_1_1.atLeast(JAVA_1_8));
        assertFalse(JAVA_1_1.atLeast(JAVA_9));
        assertFalse(JAVA_1_1.atLeast(JAVA_10));

        assertTrue(JAVA_10.atLeast(JAVA_1_1));
        assertTrue(JAVA_10.atLeast(JAVA_1_2));
        assertTrue(JAVA_10.atLeast(JAVA_1_3));
        assertTrue(JAVA_10.atLeast(JAVA_1_4));
        assertTrue(JAVA_10.atLeast(JAVA_1_5));
        assertTrue(JAVA_10.atLeast(JAVA_1_6));
        assertTrue(JAVA_10.atLeast(JAVA_1_7));
        assertTrue(JAVA_10.atLeast(JAVA_1_8));
        assertTrue(JAVA_10.atLeast(JAVA_9));
        assertTrue(JAVA_10.atLeast(JAVA_10));
    }
}