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
}
