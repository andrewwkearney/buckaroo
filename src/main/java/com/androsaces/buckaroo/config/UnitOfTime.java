/*
 * Copyright &copy; 2019 androsaces. All rights reserved.
 */

package com.androsaces.buckaroo.config;

/**
 * A {@code UnitOfTime} represents millisecond constants that would allow a
 * user to perform timing and delay operations. A {@code UnitOfTime} does not
 * maintain time information, it only helps provide a consistent context time
 * representation across multiple contexts.
 * <p>
 * A {@code UnitOfTime} is mainly used to inform time based methods how the
 * timing parameter should be interpreted. As an example, the below snippet
 * would tell this method to retry every 100 milliseconds.
 * <pre>
 *     long retryInterval = 100 * MILLISECOND.getUnitOfTime();
 * </pre>
 * While this snippet would retry every minute.
 * <pre>
 *     long retryInterval = 1 * MINUTE.getUnitOfTime();
 * </pre>
 *
 * @author Andrew Kearney
 * @since 2.0.1
 */
public enum UnitOfTime {
    /**
     * The number of milliseconds in a millisecond.
     */
    MILLISECOND(1L),

    /**
     * The number of milliseconds in a second.
     */
    SECOND(1000L * MILLISECOND.getUnitOfTime()),

    /**
     * The number of milliseconds in a minute.
     */
    MINUTE(60L * SECOND.getUnitOfTime()),

    /**
     * The number of milliseconds in an hour.
     */
    HOUR(60L * MINUTE.getUnitOfTime()),

    /**
     * The number of milliseconds in a day.
     */
    DAY(24L * HOUR.getUnitOfTime()),

    /**
     * The number of milliseconds in a week.
     */
    WEEK(7L * DAY.getUnitOfTime()),

    /**
     * The number of milliseconds in a year.
     */
    YEAR(365L * DAY.getUnitOfTime() + 5 * HOUR.getUnitOfTime() + 48 * MINUTE.getUnitOfTime() + 45 * SECOND.getUnitOfTime()),

    /**
     * The number of milliseconds in a calendar year, i.e. a 365 day non-leap
     * year.
     */
    CALENDAR_YEAR(365L * DAY.getUnitOfTime()),

    /**
     * The number of milliseconds in a leap year, i.e. a year where February
     * has 29 days.
     */
    LEAP_YEAR(366L * DAY.getUnitOfTime()),

    /**
     * The number of milliseconds to a time that can never be reached.
     */
    NEVER(Long.MAX_VALUE);

    private final long unitOfTime;

    UnitOfTime(long unitOfTime) {
        this.unitOfTime = unitOfTime;
    }

    public static UnitOfTime nextLargestResolution(UnitOfTime unitOfTime) {
        switch (unitOfTime) {
            case MILLISECOND:
                return SECOND;
            case SECOND:
                return MINUTE;
            case MINUTE:
                return HOUR;
            case HOUR:
                return DAY;
            case DAY:
                return WEEK;
            case WEEK:
                return YEAR;
            case YEAR:
                return CALENDAR_YEAR;
            case CALENDAR_YEAR:
                return LEAP_YEAR;
            case LEAP_YEAR:
            case NEVER:
            default:
                return NEVER;
        }
    }

    public static UnitOfTime nextSmallestResolution(UnitOfTime unitOfTime) {
        switch (unitOfTime) {
            case LEAP_YEAR:
                return CALENDAR_YEAR;
            case CALENDAR_YEAR:
                return YEAR;
            case YEAR:
                return WEEK;
            case WEEK:
                return DAY;
            case DAY:
                return HOUR;
            case HOUR:
                return MINUTE;
            case MINUTE:
                return SECOND;
            case SECOND:
                return MILLISECOND;
            default:
                return NEVER;
        }
    }

    public long getUnitOfTime() {
        return unitOfTime;
    }
}

