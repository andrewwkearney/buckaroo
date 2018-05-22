/*
 * Copyright © 2018 androsaces. All rights reserved.
 */

package com.androsaces.buckaroo.config;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Andrew Kearney
 */
class CountryTest {
    @Test
    void testGetRegion() {
        // America
        assertEquals(Region.AMER, Country.BRA.getRegion());
        assertEquals(Region.AMER, Country.CAN.getRegion());
        assertEquals(Region.AMER, Country.CUB.getRegion());
        assertEquals(Region.AMER, Country.URY.getRegion());
        assertEquals(Region.AMER, Country.USA.getRegion());
        // Asia Pacific
        assertEquals(Region.APAC, Country.AFG.getRegion());
        assertEquals(Region.APAC, Country.AUS.getRegion());
        assertEquals(Region.APAC, Country.CCK.getRegion());
        assertEquals(Region.APAC, Country.JPN.getRegion());
        assertEquals(Region.APAC, Country.NZL.getRegion());
        // Europe
        assertEquals(Region.EMEA, Country.FRA.getRegion());
        assertEquals(Region.EMEA, Country.GBR.getRegion());
        assertEquals(Region.EMEA, Country.IRL.getRegion());
        assertEquals(Region.EMEA, Country.IRN.getRegion());
        assertEquals(Region.EMEA, Country.IRQ.getRegion());
        // Global
        assertEquals(Region.GLOB, Country.BVT.getRegion());
        assertEquals(Region.GLOB, Country.SGS.getRegion());
    }

    @Test
    void testGetContinentName() {
        // North America
        assertEquals(Continent.NorthAmerica, Country.CAN.getContinent());
        assertEquals(Continent.NorthAmerica, Country.CUB.getContinent());
        assertEquals(Continent.NorthAmerica, Country.LCA.getContinent());
        assertEquals(Continent.NorthAmerica, Country.MEX.getContinent());
        assertEquals(Continent.NorthAmerica, Country.USA.getContinent());
        // South America
        assertEquals(Continent.SouthAmerica, Country.BRA.getContinent());
        assertEquals(Continent.SouthAmerica, Country.CHL.getContinent());
        assertEquals(Continent.SouthAmerica, Country.ECU.getContinent());
        assertEquals(Continent.SouthAmerica, Country.PER.getContinent());
        assertEquals(Continent.SouthAmerica, Country.URY.getContinent());
        // Antarctica
        assertEquals(Continent.Antarctica, Country.ATA.getContinent());
        assertEquals(Continent.Antarctica, Country.BVT.getContinent());
        assertEquals(Continent.Antarctica, Country.SGS.getContinent());
        // Asia
        assertEquals(Continent.Asia, Country.AFG.getContinent());
        assertEquals(Continent.Asia, Country.CCK.getContinent());
        assertEquals(Continent.Asia, Country.IND.getContinent());
        assertEquals(Continent.Asia, Country.JPN.getContinent());
        assertEquals(Continent.Asia, Country.SYR.getContinent());
        // Australia
        assertEquals(Continent.Australia, Country.AUS.getContinent());
        // Europe
        assertEquals(Continent.Europe, Country.FRA.getContinent());
        assertEquals(Continent.Europe, Country.GBR.getContinent());
        assertEquals(Continent.Europe, Country.IRL.getContinent());
        assertEquals(Continent.Europe, Country.JEY.getContinent());
        assertEquals(Continent.Europe, Country.LTU.getContinent());
        // Oceania
        assertEquals(Continent.Oceania, Country.ASM.getContinent());
        assertEquals(Continent.Oceania, Country.COK.getContinent());
        assertEquals(Continent.Oceania, Country.FJI.getContinent());
        assertEquals(Continent.Oceania, Country.GUM.getContinent());
        assertEquals(Continent.Oceania, Country.NZL.getContinent());
    }

    @Test
    void testGetDisplayName() {
        assertEquals("Australia", Country.AUS.getName());
        assertEquals("Finland", Country.FIN.getName());
        assertEquals("England", Country.ENG.getName());
        assertEquals("United Kingdom", Country.GBR.getName());
        assertEquals("United States", Country.USA.getName());
    }
}