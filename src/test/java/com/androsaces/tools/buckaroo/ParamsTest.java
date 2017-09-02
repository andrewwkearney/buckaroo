package com.androsaces.tools.buckaroo;

import com.sun.org.glassfish.gmbal.Description;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParamsTest {
    @Test
    @Description("notNull() provided null object")
    void testNotNullWithNullObject() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> Params.notNull(null, "null"));
        assertEquals("null cannot be null", exception.getMessage());
    }

    @Test
    @Description("notNull() provided non-null object")
    void testNotNullWithNonNullObject() {
        String expected = "expected";
        assertSame(expected, Params.notNull(expected, "expected"));
    }
}