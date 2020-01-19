/*
 * Copyright &copy; 2018 androsaces. All rights reserved.
 */

package com.androsaces.buckaroo.pattern;

/**
 * This interface should be implemented by any class that requires multiple
 * steps to have the object in a usable or complete state. For example if by
 * calling {@code new Clazz()} still requires the implementing class to have
 * additional configuration, then this interface should be used to indicate a
 * requirement for configuration.
 *
 * @author Andrew Kearney
 * @since 2.1.0
 */
@FunctionalInterface
public interface Configurable {
    /**
     * Configures an object.
     */
    void config();
}
