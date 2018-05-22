/*
 * Copyright © 2018 androsaces. All rights reserved.
 */

package com.androsaces.buckaroo.config;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for the {@link Region} class.
 *
 * @author Andrew Kearney
 */
class RegionTest {
    @Test
    void testGetDescription() {
        assertEquals("Americas", Region.AMER.getDescription());
        assertEquals("Asia Pacific", Region.APAC.getDescription());
        assertEquals("Europe, Middle East and Africa", Region.EMEA.getDescription());
        assertEquals("Global", Region.GLOB.getDescription());
    }
}