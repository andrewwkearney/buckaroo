/*
 * Copyright &copy; 2018 androsaces. All rights reserved.
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
        // EUROPE
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
        assertEquals(Continent.NORTH_AMERICA, Country.CAN.getContinent());
        assertEquals(Continent.NORTH_AMERICA, Country.CUB.getContinent());
        assertEquals(Continent.NORTH_AMERICA, Country.LCA.getContinent());
        assertEquals(Continent.NORTH_AMERICA, Country.MEX.getContinent());
        assertEquals(Continent.NORTH_AMERICA, Country.USA.getContinent());
        // South America
        assertEquals(Continent.SOUTH_AMERICA, Country.BRA.getContinent());
        assertEquals(Continent.SOUTH_AMERICA, Country.CHL.getContinent());
        assertEquals(Continent.SOUTH_AMERICA, Country.ECU.getContinent());
        assertEquals(Continent.SOUTH_AMERICA, Country.PER.getContinent());
        assertEquals(Continent.SOUTH_AMERICA, Country.URY.getContinent());
        // Antarctica
        assertEquals(Continent.ANTARCTICA, Country.ATA.getContinent());
        assertEquals(Continent.ANTARCTICA, Country.BVT.getContinent());
        assertEquals(Continent.ANTARCTICA, Country.SGS.getContinent());
        // Asia
        assertEquals(Continent.ASIA, Country.AFG.getContinent());
        assertEquals(Continent.ASIA, Country.CCK.getContinent());
        assertEquals(Continent.ASIA, Country.IND.getContinent());
        assertEquals(Continent.ASIA, Country.JPN.getContinent());
        assertEquals(Continent.ASIA, Country.SYR.getContinent());
        // Australia
        assertEquals(Continent.AUSTRALIA, Country.AUS.getContinent());
        // EUROPE
        assertEquals(Continent.EUROPE, Country.FRA.getContinent());
        assertEquals(Continent.EUROPE, Country.GBR.getContinent());
        assertEquals(Continent.EUROPE, Country.IRL.getContinent());
        assertEquals(Continent.EUROPE, Country.JEY.getContinent());
        assertEquals(Continent.EUROPE, Country.LTU.getContinent());
        // Oceania
        assertEquals(Continent.OCEANIA, Country.ASM.getContinent());
        assertEquals(Continent.OCEANIA, Country.COK.getContinent());
        assertEquals(Continent.OCEANIA, Country.FJI.getContinent());
        assertEquals(Continent.OCEANIA, Country.GUM.getContinent());
        assertEquals(Continent.OCEANIA, Country.NZL.getContinent());
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