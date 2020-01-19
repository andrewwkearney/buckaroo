/*
 * Copyright &copy; 2018 androsaces. All rights reserved.
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
        Assertions.assertEquals("Africa", Continent.AFRICA.toString());
        Assertions.assertEquals("North America", Continent.NORTH_AMERICA.toString());
        Assertions.assertEquals("South America", Continent.SOUTH_AMERICA.toString());
        Assertions.assertEquals("Antarctica", Continent.ANTARCTICA.toString());
        Assertions.assertEquals("Asia", Continent.ASIA.toString());
        Assertions.assertEquals("Australia", Continent.AUSTRALIA.toString());
        Assertions.assertEquals("Europe", Continent.EUROPE.toString());
        Assertions.assertEquals("Oceania", Continent.OCEANIA.toString());
    }
}