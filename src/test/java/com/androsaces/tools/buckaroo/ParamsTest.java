package com.androsaces.tools.buckaroo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("ResultOfMethodCallIgnored")
class ParamsTest {
    @Test
    @DisplayName("notNull() provided null object")
    void testNotNullWithNullObject() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> Params.notNull(null, "null"));
        assertEquals("null cannot be null", exception.getMessage());
    }

    @Test
    @DisplayName("notNull() provided non-null object")
    void testNotNullWithNonNullObject() {
        String expected = "expected";
        assertSame(expected, Params.notNull(expected, "expected"));
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
    @DisplayName("inRange() provided invalid long values")
    void testLongInRangeMethod() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> Params.inRange(0L, 1L, 2L));
        assertEquals("parameter 0 not in the range [1, 2]", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> Params.inRange(-1L, -2L, -4L));
        assertEquals("parameter -1 not in the range [-2, -4]", exception.getMessage());
    }

    @Test
    @DisplayName("notNegative() provided invalid int values")
    void testIntNotNegative() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> Params.notNegative(-1));
        assertEquals("parameter -1 cannot be less than zero", exception.getMessage());
    }

    @Test
    @DisplayName("notNegative() provided invalid long values")
    void testLongNotNegative() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> Params.notNegative(-1L));
        assertEquals("parameter -1 cannot be less than zero", exception.getMessage());
    }
}