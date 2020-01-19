/*
 * Copyright &copy; 2019 androsaces. All rights reserved.
 */

package com.androsaces.buckaroo.config;

import com.androsaces.buckaroo.Params;

import java.util.StringTokenizer;

import static com.androsaces.buckaroo.config.UnitOfTime.*;

/**
 * This is a utility class that allows for converting to and from Java time
 * intervals specified in milliseconds and Strings with human parsable units
 * such as days, hours, minutes, etc.
 *
 * @author Andrew Kearney
 * @since 2.0.1
 */
public class TimeInterval {
    private static final String[] UNIT_NAME = {"millisecond", "second", "minute", "hour", "day", "week", "year", "calendar-year"};
    private static final String NEVER_NAME = "never";
    private static final UnitOfTime[] UNIT_VALUE = {MILLISECOND, SECOND, MINUTE, HOUR, DAY, WEEK, YEAR, CALENDAR_YEAR};

    /**
     * Parse a String that contains a time in a similar format to that produced
     * by {@link #toString()} and convert it into a time in milliseconds. The
     * given time should be a space separated list of time values in the form
     * of {@code value name} where {@code value} is a numeric value and {@code name}
     * is a value from the list of {@link UnitOfTime}.
     * The value should be an unsigned int but can also be a valid signed
     * double. The names of the units of time may be singular or plural and
     * their case is ignored.
     *
     * @param timeWords the time string to be parsed.
     * @return the corresponding value in milliseconds.
     */
    public static long parse(String timeWords) {
        Params.notEmpty(timeWords);
        StringTokenizer tokenizer = new StringTokenizer(stripPunctuation(timeWords.toLowerCase()));
        int tokens = tokenizer.countTokens();
        if (tokens == 1) {
            return parseSingleToken(tokenizer.nextToken());
        }
        if (tokens == 0 || tokens % 2 == 1) {
            throw new IllegalArgumentException("invalid time string: " + timeWords);
        }
        return parseTokens(tokenizer);
    }

    private static String stripPunctuation(String timeWords) {
        String stripped = timeWords.replaceAll(",\\s*", " ");
        stripped = stripped.replace(" and ", " ");
        stripped = stripped.replaceFirst("\\.\\s*$", "");
        return stripped;
    }

    private static long parseSingleToken(String name) {
        if (name.equals(NEVER_NAME)) return NEVER.getUnitOfTime();
        for (int resolution = MILLISECOND.ordinal(); resolution <= CALENDAR_YEAR.ordinal(); ++resolution) {
            if (name.equals(UNIT_NAME[resolution]))
                return UNIT_VALUE[resolution].getUnitOfTime();
        }
        return Long.parseLong(name);
    }

    private static long parseTokens(StringTokenizer tokenizer) {
        long milliseconds = 0;
        int tokens = tokenizer.countTokens() >> 1;
        while (tokens-- > 0) {
            String value = tokenizer.nextToken();
            String name = tokenizer.nextToken();
            milliseconds += Double.parseDouble(value) * timeIntervalByName(name);
        }
        return milliseconds;
    }

    private static long timeIntervalByName(String name) {
        return UNIT_VALUE[getUnitByName(name)].getUnitOfTime();
    }

    /**
     * Returns a string representation of a time by calling {@link #toString(long, int)}
     * with a depth sufficient to show the interval to millisecond precision.
     *
     * @param milliseconds the time interval given in milliseconds.
     * @return the formatted string.
     */
    public static String toLongString(long milliseconds) {
        return toString(milliseconds, UNIT_NAME.length);
    }

    /**
     * Returns a string representation of the time with a depth of two.
     *
     * @param milliseconds the time given in milliseconds.
     * @return the formatted string.
     */
    public static String toString(long milliseconds) {
        return toString(milliseconds, 2);
    }

    /**
     * Returns a string representation of a time but will show milliseconds
     * with seconds.
     *
     * @param javaTime the time given in milliseconds.
     * @param depth    the number of times to drill down to express the time
     *                 accurately.
     * @return the formatted string.
     */
    public static String toString(long javaTime, int depth) {
        return toString(javaTime, depth, true);
    }

    /**
     * Return a string representation of a time, given in milliseconds. The
     * string will be formatted in the most appropriate units for the given
     * time.  A time less than one second is formatted in milliseconds, whereas
     * a time time greater than one second but less than one minute is
     * formatted as seconds, and so on.
     * For example, 22 ms will be formatted as "22 milliseconds", 1234 ms as
     * "1.234 seconds", 59000 ms as "59 seconds", 60000 ms as "1 minute", 70000 ms
     * as "1 minute 10 seconds", and 5400000 ms as "1 hour 30 minutes".
     *
     * @param javaTime   a Java epoch time in milliseconds.
     * @param depth      the number of time units to drill into to express the time accurately.
     * @param withMillis true if milliseconds should be shown with seconds, eg "12.500", or false otherwise.
     * @return the formatted ISO string.
     */
    public static String toString(long javaTime, int depth, boolean withMillis) {
        if (javaTime == NEVER.getUnitOfTime()) return NEVER_NAME;
        StringBuilder stringBuilder = new StringBuilder();
        if (javaTime < SECOND.getUnitOfTime()) {
            whole(stringBuilder, javaTime, MILLISECOND);
        } else {
            if (javaTime < MINUTE.getUnitOfTime()) {
                format(stringBuilder, javaTime, SECOND, withMillis ? depth : 1);
            } else if (javaTime < HOUR.getUnitOfTime()) {
                format(stringBuilder, javaTime, MINUTE, depth);
            } else if (javaTime < DAY.getUnitOfTime()) {
                format(stringBuilder, javaTime, HOUR, depth);
            } else if (javaTime < CALENDAR_YEAR.getUnitOfTime()) {
                format(stringBuilder, javaTime, WEEK, depth);
            } else if (javaTime % CALENDAR_YEAR.getUnitOfTime() == 0) {
                format(stringBuilder, javaTime, CALENDAR_YEAR, depth);
            } else {
                format(stringBuilder, javaTime, YEAR, depth);
            }
        }
        return stringBuilder.toString();
    }

    /**
     * Returns a string representation of a time given in milliseconds but
     * formatted as a fraction in seconds.
     *
     * @param milliseconds the time given in milliseconds.
     * @return a formatted string with a three digit fraction part.
     */
    public static String toSeconds(long milliseconds) {
        if (milliseconds == NEVER.getUnitOfTime()) return NEVER_NAME;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(milliseconds);
        int length = stringBuilder.length();
        if (length > 3) {
            stringBuilder.insert(length - 3, '.');
        } else {
            stringBuilder.insert(0, "0.00".substring(0, 5 - length));
        }
        stringBuilder.append(" seconds");
        return stringBuilder.toString();
    }

    private static void whole(StringBuilder stringBuilder, long javaTime, UnitOfTime unitOfTime) {
        stringBuilder.append(javaTime)
                .append(' ')
                .append(UNIT_NAME[unitOfTime.ordinal()]);
        if (javaTime != 1L) stringBuilder.append('s');
    }

    private static void format(StringBuilder stringBuilder, long milliseconds, UnitOfTime unitOfTime, int depth) {
        long divider = milliseconds / unitOfTime.getUnitOfTime();
        long remainder = milliseconds - divider * unitOfTime.getUnitOfTime();
        if (divider == 0L) {
            format(stringBuilder, remainder, UnitOfTime.nextSmallestResolution(unitOfTime), depth);
        } else if (depth > 1 && unitOfTime == SECOND && remainder > 0L) {
            stringBuilder.append(toSeconds(milliseconds));
        } else {
            whole(stringBuilder, divider, unitOfTime);
            if (depth > 1 && remainder > 0L) {
                stringBuilder.append(' ');
                format(stringBuilder, remainder, UnitOfTime.nextSmallestResolution(unitOfTime), depth - 1);
            }
        }
    }

    private static int getUnitByName(String name) {
        for (int resolution = MILLISECOND.ordinal(); resolution <= CALENDAR_YEAR.ordinal(); resolution++) {
            if (name.startsWith(UNIT_NAME[resolution])) return resolution;
        }
        throw new IllegalArgumentException("Unknown time unit: " + name);
    }
}
