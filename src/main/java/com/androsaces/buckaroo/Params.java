/*
 * Copyright © 2018 androsaces. All rights reserved.
 */

package com.androsaces.buckaroo;

import java.util.List;

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
     * @param <T>       the type of the parameter being checked.
     * @return the parameter value.
     * @throws IllegalArgumentException if the given parameter is null.
     * @since 1.0.0
     */
    public static <T> T notNull(T param, String paramName) {
        if (param == null) throw new IllegalArgumentException(paramName + " cannot be null");
        return param;
    }

    /**
     * Checks to ensure that the given parameter is not null.
     *
     * @param param the parameter being checked.
     * @param <T>   the type of the parameter being checked.
     * @return the parameter value.
     * @throws IllegalArgumentException if the given parameter is null.
     * @since 1.0.0
     */
    public static <T> T notNull(T param) {
        if (param == null) throw new IllegalArgumentException("parameter cannot be null");
        return param;
    }

    /**
     * Checks to ensure that the string parameter is not an empty string.
     *
     * @param param the string being checked.
     * @return the parameter value.
     * @throws IllegalArgumentException if the given parameter is null or an empty string.
     * @since 1.0.0
     */
    public static String notEmpty(String param) {
        if (notNull(param).trim().isEmpty()) throw new IllegalArgumentException("method parameter cannot be an empty string");
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
     * @since 1.0.0
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
     * @since 1.0.0
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
     * @since 1.0.0
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
     * @since 1.0.0
     */
    public static long notNegative(long p) {
        if (p < 0) throw new IllegalArgumentException("parameter " + p + " cannot be less than zero");
        return p;
    }

    /**
     * Checks to ensure the {@link List} passed in is not empty.
     *
     * @param p   the list to be checked.
     * @param <T> the type of the list being checked.
     * @return the parameter value.
     * @throws IllegalArgumentException if the given list is empty.
     * @since 1.1.0
     */
    public static <T> List<T> notEmptyList(List<T> p) {
        if (p.isEmpty()) throw new IllegalArgumentException("list cannot be empty");
        return p;
    }

    /**
     * Checks to ensure the {@link List} provided does not contain the value
     * provided in the second parameter. It will also check to make sure the
     * list is not empty using {@link #notEmptyList(List)}.
     *
     * @param p   the list to be checked.
     * @param t   the value not allowed to be in the list.
     * @param <T> the type of values being checked.
     * @return the parameter value.
     * @throws IllegalArgumentException if the given list contains the given value.
     * @since 1.1.0
     */
    public static <T> List<T> listCannotContain(List<T> p, T t) {
        if (notEmptyList(p).contains(t)) throw new IllegalArgumentException("list cannot contain " + t);
        return p;
    }
}
