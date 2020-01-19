/*
 * Copyright &copy; 2018 androsaces. All rights reserved.
 */

package com.androsaces.buckaroo.pattern;

/**
 * This interface should be implemented by any class that conforms to the
 * builder pattern. The class may be created in an inconsistent state, however
 * once the {@code build()} method is called, a consistent and preferably
 * immutable version should be created.
 * <p>
 * A preferred solution that provides thread-safety and immutability is:
 * <pre>
 *   T t = new T(this);
 *   if (t.getMethod() == null) {
 *     throw new IllegalStateException(message); // thread-safe
 *   }
 *   return t;
 * </pre>
 *
 * @author Andrew Kearney
 * @since 2.0.x
 */
@FunctionalInterface
public interface Build<T> {
    /**
     * This method should build a new consistently formed version of the typed
     * class.
     *
     * @return an instance of {@code T}.
     */
    T build();
}
