package com.androsaces.tools.buckaroo;

/**
 * This class provides utility methods that will validate the parameters passed
 * to methods. It is intended to clean up a lot of boiler plate parameter
 * guard code.
 *
 * @author Andrew Kearney
 * @version 1.0
 */
@SuppressWarnings("ALL")
public class Params {
    private Params() {
    }

    /**
     * Checks to ensure that the given parameter is not null.
     *
     * @param param     the parameter being checked.
     * @param paramName the name of the parameter.
     * @return the parameter value.
     * @throws IllegalArgumentException if the given parameter is null.
     */
    public static <T> T notNull(T param, String paramName) {
        if (param == null) throw new IllegalArgumentException(paramName + " cannot be null");
        return param;
    }

    /**
     * Checks to ensure that the given parameter is not null.
     *
     * @param param the parameter being checked.
     * @return the parameter value.
     * @throws IllegalArgumentException if the given parameter is null.
     */
    public static <T> T notNull(T param) {
        if (param == null) throw new IllegalArgumentException("param cannot be null");
        return param;
    }

    /**
     * Checks to ensure that the string parameter is not an empty string.
     *
     * @param param the string being checked.
     * @return the parameter value.
     * @throws IllegalArgumentException if the given parameter is null or an empty string.
     */
    public static String notEmpty(String param) {
        if (notNull(param).isEmpty()) throw new IllegalArgumentException("method parameter cannot be an empty string");
        return param;
    }

    /**
     * Checks to ensure the value passed in is within the given minimum and
     * maximum values.
     *
     * @param p   the number to be checked.
     * @param min the minimum bound.
     * @param max the maximum bound.
     * @return the parameter value.
     * @throws IllegalArgumentException if the given parameter is not with the range.
     */
    public static int inRange(int p, int min, int max) {
        if (p < min || p > max)
            throw new IllegalArgumentException("parameter " + p + " not in the range [" + min + ", " + max + ']');
        return p;
    }

    /**
     * Checks to ensure the value passed in is within the given minimum and
     * maximum values.
     *
     * @param p   the number to be checked.
     * @param min the minimum bound.
     * @param max the maximum bound.
     * @return the parameter value.
     * @throws IllegalArgumentException if the given parameter is not with the range.
     */
    public static long inRange(long p, long min, long max) {
        if (p < min || p > max)
            throw new IllegalArgumentException("parameter " + p + " not in the range [" + min + ", " + max + ']');
        return p;
    }

    /**
     * Checks to ensure the value passed in is not less than zero.
     *
     * @param p the number to be checked.
     * @return the parameter value.
     * @throws IllegalArgumentException if the given parameter is less than zero.
     */
    public static int notNegative(int p) {
        if (p < 0) throw new IllegalArgumentException("parameter " + p + " cannot be less than zero");
        return p;
    }

    /**
     * Checks to ensure the value passed in is not less than zero.
     *
     * @param p the number to be checked.
     * @return the parameter value.
     * @throws IllegalArgumentException if the given parameter is less than zero.
     */
    public static long notNegative(long p) {
        if (p < 0) throw new IllegalArgumentException("parameter " + p + " cannot be less than zero");
        return p;
    }
}
