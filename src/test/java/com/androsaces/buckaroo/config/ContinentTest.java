/*
 * Copyright © 2018 androsaces. All rights reserved.
 */

package com.androsaces.buckaroo.config;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Unit test for the {@link Continent} class.
 *
 * @author Andrew Kearney
 */
class ContinentTest {
    @Test
    void testGetDescription() {
        Assertions.assertEquals("Africa", Continent.Africa.toString());
        Assertions.assertEquals("NorthAmerica", Continent.NorthAmerica.toString());
        Assertions.assertEquals("SouthAmerica", Continent.SouthAmerica.toString());
        Assertions.assertEquals("Antarctica", Continent.Antarctica.toString());
        Assertions.assertEquals("Asia", Continent.Asia.toString());
        Assertions.assertEquals("Australia", Continent.Australia.toString());
        Assertions.assertEquals("Europe", Continent.Europe.toString());
        Assertions.assertEquals("Oceania", Continent.Oceania.toString());
    }
}