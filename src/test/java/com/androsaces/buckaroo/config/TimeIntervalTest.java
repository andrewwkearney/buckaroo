/*
 * Copyright © 2019 androsaces. All rights reserved.
 */

package com.androsaces.buckaroo.config;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for {@link TimeInterval} class.
 *
 * @author Andrew Kearney
 */
class TimeIntervalTest {
    @Test
    @DisplayName("Tests the time interval by passing milliseconds into a string and back out again")
    void eachWay() {
        assertAll("",
                () -> assertTrue(eachWayTest(0L, "0 milliseconds")),
                () -> assertTrue(eachWayTest(1L, "1 millisecond")),
                () -> assertTrue(eachWayTest(5L, "5 milliseconds")),
                () -> assertTrue(eachWayTest(10L, "10 milliseconds")),
                () -> assertTrue(eachWayTest(20L, "20 milliseconds")),
                () -> assertTrue(eachWayTest(50L, "50 milliseconds")),
                () -> assertTrue(eachWayTest(75L, "75 milliseconds")),
                () -> assertTrue(eachWayTest(100L, "100 milliseconds")),
                () -> assertTrue(eachWayTest(200L, "200 milliseconds")),
                () -> assertTrue(eachWayTest(250L, "250 milliseconds")),
                () -> assertTrue(eachWayTest(333L, "333 milliseconds")),
                () -> assertTrue(eachWayTest(333L, "333 milliseconds")),
                () -> assertTrue(eachWayTest(500L, "500 milliseconds")),
                () -> assertTrue(eachWayTest(750L, "750 milliseconds")),
                () -> assertTrue(eachWayTest(1000L, "1 second")),
                () -> assertTrue(eachWayTest(1234L, "1.234 seconds")),
                () -> assertTrue(eachWayTest(1250L, "1.250 seconds")),
                () -> assertTrue(eachWayTest(1500L, "1.500 seconds")),
                () -> assertTrue(eachWayTest(1750L, "1.750 seconds")),
                () -> assertTrue(eachWayTest(2000L, "2 seconds")),
                () -> assertTrue(eachWayTest(3000L, "3 seconds")),
                () -> assertTrue(eachWayTest(5000L, "5 seconds")),
                () -> assertTrue(eachWayTest(6000L, "6 seconds")),
                () -> assertTrue(eachWayTest(10000L, "10 seconds")),
                () -> assertTrue(eachWayTest(10000L, "10 seconds")),
                () -> assertTrue(eachWayTest(12000L, "12 seconds")),
                () -> assertTrue(eachWayTest(15000L, "15 seconds")),
                () -> assertTrue(eachWayTest(20000L, "20 seconds")),
                () -> assertTrue(eachWayTest(30000L, "30 seconds")),
                () -> assertTrue(eachWayTest(50000L, "50 seconds")),
                () -> assertTrue(eachWayTest(60000L, "1 minute")),
                () -> assertTrue(eachWayTest(75000L, "1 minute 15 seconds")),
                () -> assertTrue(eachWayTest(90000L, "1 minute 30 seconds")),
                () -> assertTrue(eachWayTest(100000L, "1 minute 40 seconds")),
                () -> assertTrue(eachWayTest(105000L, "1 minute 45 seconds")),
                () -> assertTrue(eachWayTest(120000L, "2 minutes")),
                () -> assertTrue(eachWayTest(150000L, "2 minutes 30 seconds")),
                () -> assertTrue(eachWayTest(200000L, "3 minutes 20 seconds")),
                () -> assertTrue(eachWayTest(200010L, "3 minutes 20.010 seconds")),
                () -> assertTrue(eachWayTest(300000L, "5 minutes")),
                () -> assertTrue(eachWayTest(360000L, "6 minutes")),
                () -> assertTrue(eachWayTest(600000L, "10 minutes")),
                () -> assertTrue(eachWayTest(720000L, "12 minutes")),
                () -> assertTrue(eachWayTest(900000L, "15 minutes")),
                () -> assertTrue(eachWayTest(1200000L, "20 minutes")),
                () -> assertTrue(eachWayTest(1800000L, "30 minutes")),
                () -> assertTrue(eachWayTest(3000000L, "50 minutes")),
                () -> assertTrue(eachWayTest(3600000L, "1 hour")),
                () -> assertTrue(eachWayTest(4500000L, "1 hour 15 minutes")),
                () -> assertTrue(eachWayTest(5400000L, "1 hour 30 minutes")),
                () -> assertTrue(eachWayTest(6000000L, "1 hour 40 minutes")),
                () -> assertTrue(eachWayTest(6300000L, "1 hour 45 minutes")),
                () -> assertTrue(eachWayTest(7200000L, "2 hours")),
                () -> assertTrue(eachWayTest(8640000L, "2 hours 24 minutes")),
                () -> assertTrue(eachWayTest(9000000L, "2 hours 30 minutes")),
                () -> assertTrue(eachWayTest(12000000L, "3 hours 20 minutes")),
                () -> assertTrue(eachWayTest(12000010L, "3 hours 20 minutes 10 milliseconds")),
                () -> assertTrue(eachWayTest(17280000L, "4 hours 48 minutes")),
                () -> assertTrue(eachWayTest(18000000L, "5 hours")),
                () -> assertTrue(eachWayTest(21600000L, "6 hours")),
                () -> assertTrue(eachWayTest(28800000L, "8 hours")),
                () -> assertTrue(eachWayTest(36000000L, "10 hours")),
                () -> assertTrue(eachWayTest(43200000L, "12 hours")),
                () -> assertTrue(eachWayTest(60480000L, "16 hours 48 minutes")),
                () -> assertTrue(eachWayTest(72000000L, "20 hours")),
                () -> assertTrue(eachWayTest(82800000L, "23 hours")),
                () -> assertTrue(eachWayTest(86340000L, "23 hours 59 minutes")),
                () -> assertTrue(eachWayTest(86399000L, "23 hours 59 minutes 59 seconds")),
                () -> assertTrue(eachWayTest(86399999L, "23 hours 59 minutes 59.999 seconds")),
                () -> assertTrue(eachWayTest(86400000L, "1 day")),
                () -> assertTrue(eachWayTest(120960000L, "1 day 9 hours 36 minutes")),
                () -> assertTrue(eachWayTest(151200000L, "1 day 18 hours")),
                () -> assertTrue(eachWayTest(172800000L, "2 days")),
                () -> assertTrue(eachWayTest(180000000L, "2 days 2 hours")),
                () -> assertTrue(eachWayTest(201600000L, "2 days 8 hours")),
                () -> assertTrue(eachWayTest(216000000L, "2 days 12 hours")),
                () -> assertTrue(eachWayTest(270000000L, "3 days 3 hours")),
                () -> assertTrue(eachWayTest(302400000L, "3 days 12 hours")),
                () -> assertTrue(eachWayTest(360000000L, "4 days 4 hours")),
                () -> assertTrue(eachWayTest(432000000L, "5 days")),
                () -> assertTrue(eachWayTest(518400000L, "6 days")),
                () -> assertTrue(eachWayTest(540000000L, "6 days 6 hours")),
                () -> assertTrue(eachWayTest(601200000L, "6 days 23 hours")),
                () -> assertTrue(eachWayTest(604740000L, "6 days 23 hours 59 minutes")),
                () -> assertTrue(eachWayTest(604799000L, "6 days 23 hours 59 minutes 59 seconds")),
                () -> assertTrue(eachWayTest(604799999L, "6 days 23 hours 59 minutes 59.999 seconds")),
                () -> assertTrue(eachWayTest(604800000L, "1 week")),
                () -> assertTrue(eachWayTest(720000000L, "1 week 1 day 8 hours")),
                () -> assertTrue(eachWayTest(720000010L, "1 week 1 day 8 hours 10 milliseconds")),
                () -> assertTrue(eachWayTest(864000000L, "1 week 3 days")),
                () -> assertTrue(eachWayTest(1209600000L, "2 weeks")),
                () -> assertTrue(eachWayTest(1728000000L, "2 weeks 6 days")),
                () -> assertTrue(eachWayTest(3024000000L, "5 weeks")),
                () -> assertTrue(eachWayTest(3155692500L, "5 weeks 1 day 12 hours 34 minutes 52.500 seconds")),
                () -> assertTrue(eachWayTest(4320000000L, "7 weeks 1 day")),
                () -> assertTrue(eachWayTest(5184000000L, "8 weeks 4 days")),
                () -> assertTrue(eachWayTest(6048000000L, "10 weeks")),
                () -> assertTrue(eachWayTest(6311385000L, "10 weeks 3 days 1 hour 9 minutes 45 seconds")),
                () -> assertTrue(eachWayTest(6480000000L, "10 weeks 5 days")),
                () -> assertTrue(eachWayTest(7889231250L, "13 weeks 7 hours 27 minutes 11.250 seconds")),
                () -> assertTrue(eachWayTest(8640000000L, "14 weeks 2 days")),
                () -> assertTrue(eachWayTest(10368000000L, "17 weeks 1 day")),
                () -> assertTrue(eachWayTest(10518975000L, "17 weeks 2 days 17 hours 56 minutes 15 seconds")),
                () -> assertTrue(eachWayTest(12096000000L, "20 weeks")),
                () -> assertTrue(eachWayTest(12960000000L, "21 weeks 3 days")),
                () -> assertTrue(eachWayTest(15778462500L, "26 weeks 14 hours 54 minutes 22.500 seconds")),
                () -> assertTrue(eachWayTest(17280000000L, "28 weeks 4 days")),
                () -> assertTrue(eachWayTest(17280000010L, "28 weeks 4 days 10 milliseconds")),
                () -> assertTrue(eachWayTest(30240000000L, "50 weeks")),
                () -> assertTrue(eachWayTest(30952125000L, "51 weeks 1 day 5 hours 48 minutes 45 seconds")),
                () -> assertTrue(eachWayTest(31449600000L, "52 weeks")),
                () -> assertTrue(eachWayTest(31470525000L, "52 weeks 5 hours 48 minutes 45 seconds")),
                () -> assertTrue(eachWayTest(31556924999L, "52 weeks 1 day 5 hours 48 minutes 44.999 seconds")),
                () -> assertTrue(eachWayTest(31556925000L, "1 year")),
                () -> assertTrue(eachWayTest(31643325000L, "1 year 1 day")),
                () -> assertTrue(eachWayTest(31646925000L, "1 year 1 day 1 hour")),
                () -> assertTrue(eachWayTest(31646985000L, "1 year 1 day 1 hour 1 minute")),
                () -> assertTrue(eachWayTest(31646986000L, "1 year 1 day 1 hour 1 minute 1 second")),
                () -> assertTrue(eachWayTest(31646986001L, "1 year 1 day 1 hour 1 minute 1.001 seconds")),
                () -> assertTrue(eachWayTest(36288000000L, "1 year 7 weeks 5 days 18 hours 11 minutes 15 seconds")),
                () -> assertTrue(eachWayTest(45360000000L, "1 year 22 weeks 5 days 18 hours 11 minutes 15 seconds")),
                () -> assertTrue(eachWayTest(60480000000L, "1 year 47 weeks 5 days 18 hours 11 minutes 15 seconds")),
                () -> assertTrue(eachWayTest(63113850000L, "2 years")),
                () -> assertTrue(eachWayTest(63113850000L, "2 years")),
                () -> assertTrue(eachWayTest(72576000000L, "2 years 15 weeks 4 days 12 hours 22 minutes 30 seconds")),
                () -> assertTrue(eachWayTest(78892312500L, "2 years 26 weeks 14 hours 54 minutes 22.500 seconds")),
                () -> assertTrue(eachWayTest(90720000000L, "2 years 45 weeks 4 days 12 hours 22 minutes 30 seconds")),
                () -> assertTrue(eachWayTest(105189750000L, "3 years 17 weeks 2 days 17 hours 56 minutes 15 seconds")),
                () -> assertTrue(eachWayTest(120960000000L, "3 years 43 weeks 3 days 6 hours 33 minutes 45 seconds")),
                () -> assertTrue(eachWayTest(120960000010L, "3 years 43 weeks 3 days 6 hours 33 minutes 45.010 seconds")),
                () -> assertTrue(eachWayTest(157784625000L, "5 years")),
                () -> assertTrue(eachWayTest(157784625000L, "5 years")),
                () -> assertTrue(eachWayTest(315569250000L, "10 years")),
                () -> assertTrue(eachWayTest(315360000000L, "10 calendar-years")),
                () -> assertTrue(eachWayTest(631138500000L, "20 years")),
                () -> assertTrue(eachWayTest(1577846250000L, "50 years")),
                () -> assertTrue(eachWayTest(1893415500000L, "60 years")),
                () -> assertTrue(eachWayTest(2366769375000L, "75 years")),
                () -> assertTrue(eachWayTest(3155692500000L, "100 years")),
                () -> assertTrue(eachWayTest(3786831000000L, "120 years")),
                () -> assertTrue(eachWayTest(4733538750000L, "150 years")),
                () -> assertTrue(eachWayTest(6311385000000L, "200 years")),
                () -> assertTrue(eachWayTest(6311385000010L, "200 years 10 milliseconds")),
                () -> assertTrue(eachWayTest(31556925000000L, "1000 years")),
                () -> assertTrue(eachWayTest(63113850000000L, "2000 years")),
                () -> assertTrue(eachWayTest(315569250000000L, "10000 years")),
                () -> assertTrue(eachWayTest(UnitOfTime.NEVER.getUnitOfTime(), "never"))
        );
    }

    private boolean eachWayTest(long millis, String time) {
        assertEquals(time, TimeInterval.toLongString(millis));
        assertEquals(millis, TimeInterval.parse(time));
        return true;
    }

    @Test
    @DisplayName("null time throws exception")
    void nullCheck() {
        assertThrows(RuntimeException.class, () -> TimeInterval.parse(null));
    }

    @Test
    @DisplayName("blank time string throws exception")
    void blankCheck() {
        assertThrows(RuntimeException.class, () -> TimeInterval.parse(""));
    }

    @Test
    void testParse() {
        assertAll(
                () -> assertEquals(0L, TimeInterval.parse("0 milliseconds")),
                () -> assertEquals(0L, TimeInterval.parse("0 MILLISECONDS"))
        );
    }
}