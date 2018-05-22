/*
 * Copyright © 2018 androsaces. All rights reserved.
 */

package com.androsaces.buckaroo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// @SuppressWarnings("ResultOfMethodCallIgnored")
class ParamsTest {
    @Test
    @DisplayName("two parameter notNull() provided null object")
    void testTwoElementNotNullWithNullObject() {
        String expected = "null cannot be null";
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> Params.notNull(null, "null"));
        assertEquals(expected, exception.getMessage());
    }

    @Test
    @DisplayName("two parameter notNull() provided non-null object")
    void testTwoElementNotNullWithNonNullObject() {
        String expected = "expected";
        assertSame(expected, Params.notNull(expected, "expected"));
    }

    @Test
    @DisplayName("one parameter notNull() provided null object")
    void testOneElementNotNullWithNullObject() {
        String expected = "parameter cannot be null";
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> Params.notNull(null));
        assertEquals(expected, exception.getMessage());
    }

    @Test
    @DisplayName("one parameter notNull() provided non-null object")
    void testOneElementNotNullWithNonNullObject() {
        String expected = "expected";
        assertSame(expected, Params.notNull(expected));
    }

    @Test
    @DisplayName("notEmpty() provided with an empty string")
    void testEmptyStringWithAnEmptyString() {
        String expected = "";
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> Params.notEmpty(expected));
        assertEquals("method parameter cannot be an empty string", exception.getMessage());
    }

    @Test
    @DisplayName("notEmpty() provided a non-empty string")
    void testEmptyStringWithNonEmptyString() {
        String expected = "Test String";
        assertSame(expected, Params.notEmpty(expected));
    }

    @Test
    @DisplayName("inRange() provided invalid integer values")
    void testIntInRangeMethod() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> Params.inRange(0, 1, 2));
        assertEquals("parameter 0 not in the range [1, 2]", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> Params.inRange(-1, -2, -4));
        assertEquals("parameter -1 not in the range [-2, -4]", exception.getMessage());
    }

    @Test
    @DisplayName("inRange() provided valid integer value")
    void testIntInRangeWithValidValue() {
        int expected = 10;
        assertSame(expected, Params.inRange(expected, 0, Integer.MAX_VALUE));
    }

    @Test
    @DisplayName("inRange() provided invalid long values")
    void testLongInRangeMethod() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> Params.inRange(0L, 1L, 2L));
        assertEquals("parameter 0 not in the range [1, 2]", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> Params.inRange(-1L, -2L, -4L));
        assertEquals("parameter -1 not in the range [-2, -4]", exception.getMessage());
    }

    @Test
    @DisplayName("inRange() provided valid integer value")
    void testLongInRangeWithValidValue() {
        long expected = 10L;
        assertSame(expected, Params.inRange(expected, 0L, Long.MAX_VALUE));
    }

    @Test
    @DisplayName("notNegative() provided invalid int values")
    void testIntNotNegative() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> Params.notNegative(-1));
        assertEquals("parameter -1 cannot be less than zero", exception.getMessage());
    }

    @Test
    @DisplayName("notNegative() provided positive value")
    void testIntNotNegativeWithPositiveValue() {
        int expected = 10;
        assertSame(expected, Params.notNegative(expected));
    }

    @Test
    @DisplayName("notNegative() provided invalid long values")
    void testLongNotNegative() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> Params.notNegative(-1L));
        assertEquals("parameter -1 cannot be less than zero", exception.getMessage());
    }

    @Test
    @DisplayName("notNegative() provided positive value")
    void testLongNotNegativeWithPositiveValue() {
        long expected = 10L;
        assertSame(expected, Params.notNegative(expected));
    }

    @Test
    @DisplayName("notEmptyList() provided empty list")
    void testNotEmptyList() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> Params.notEmptyList(Collections.emptyList()));
        assertEquals("list cannot be empty", exception.getMessage());
    }

    @Test
    @DisplayName("notEmptyList() returns a non-empty list")
    void testNotEmptyListWithNotEmptyList() {
        var stringList = Arrays.asList("Test", "String", "goes here");
        List<String> expected = Params.notEmptyList(stringList);
        assertEquals(expected, stringList);
        assertFalse(expected.isEmpty());
    }

    @Test
    @DisplayName("listCannotContain() provided a list that doesn't contain element")
    void testListCannotContainWithExcludedString() {
        Throwable excludedString = assertThrows(IllegalArgumentException.class, () -> Params.listCannotContain(Arrays.asList("test", "string", "example"), "example"));
        assertEquals("list cannot contain example", excludedString.getMessage());
        Throwable excludedInteger = assertThrows(IllegalArgumentException.class, () -> Params.listCannotContain(Arrays.asList(1, 2, 3, 4), 4));
        assertEquals("list cannot contain 4", excludedInteger.getMessage());
        Throwable excludedChar = assertThrows(IllegalArgumentException.class, () -> Params.listCannotContain(Arrays.asList('a', 'b', 'c', 'd'), 'a'));
        assertEquals("list cannot contain a", excludedChar.getMessage());
    }

    @Test
    @DisplayName("listCannotContain() provided a list that doesn't contain element")
    void testListCannotContain() {
        var stringList = Arrays.asList("test", "string");
        List<String> expected = Params.listCannotContain(stringList, "example");
        assertNotNull(expected);
        assertFalse(expected.isEmpty());
    }
}