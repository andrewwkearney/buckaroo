/*
 * Copyright © 2018 androsaces. All rights reserved.
 */

package com.androsaces.tools.buckaroo.config;

import org.junit.jupiter.api.Test;

import static com.androsaces.tools.buckaroo.config.Continent.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for the {@link Continent} class.
 *
 * @author Andrew Kearney
 */
class ContinentTest {
    @Test
    void testGetDescription() {
        assertEquals("Africa", Africa.toString());
        assertEquals("NorthAmerica", NorthAmerica.toString());
        assertEquals("SouthAmerica", SouthAmerica.toString());
        assertEquals("Antarctica", Antarctica.toString());
        assertEquals("Asia", Asia.toString());
        assertEquals("Australia", Australia.toString());
        assertEquals("Europe", Europe.toString());
        assertEquals("Oceania", Oceania.toString());
    }
}