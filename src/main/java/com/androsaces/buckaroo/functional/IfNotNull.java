package com.androsaces.buckaroo.functional;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * This class provides a set of helper methods for setting values when they are
 * not {@code null}.
 *
 * @author Andrew Kearney
 */
public class IfNotNull {

    /**
     * Private constructor.
     */
    private IfNotNull() {
    }

    /**
     * Sets the value provided into the consumer if it is not {@code null}.
     *
     * @param setter the method reference of the object
     * @param value  the value that will be set
     */
    public static <V> void setIfNotNull(Consumer<V> setter, V value) {
        if (value != null) {
            setter.accept(value);
        }
    }

    /**
     * Sets the value provided into the consumer if it is not {@code null} by
     * using the {@code transform} object.
     *
     * @param setter    the method reference of the object
     * @param value     the value that will be set
     * @param transform the transformer
     */
    public static <K, V> void setIfNotNull(Consumer<V> setter, K value, Function<K, V> transform) {
        if (value != null) {
            setter.accept(transform.apply(value));
        }
    }
}
