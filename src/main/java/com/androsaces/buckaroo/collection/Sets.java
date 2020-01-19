/*
 * Copyright &copy; 2018 androsaces. All rights reserved.
 */

package com.androsaces.buckaroo.collection;

import java.util.HashSet;
import java.util.Set;

/**
 * This class provides basic methods to provide mathematical set operations.
 *
 * @author Andrew Kearney
 */
@SuppressWarnings("WeakerAccess")
public class Sets {
    private Sets() {}

    /**
     * Returns the union (&cup;) of the two sets - the elements that are a
     * member of both sets.
     *
     * @param a   the first set.
     * @param b   the second set.
     * @param <T> the type of the parameter.
     * @return a new set that is the union of a and b.
     */
    public static <T> Set<T> union(Set<? extends T> a, Set<? extends T> b) {
        Set<T> set = createSet(a);
        set.addAll(b);
        return set;
    }

    /**
     * Returns the intersection (&cap;) of the two sets - the elements that are
     * common to both.
     *
     * @param a   the first set.
     * @param b   the second set.
     * @param <T> the type of the parameter.
     * @return a new set that is the intersection of a and b.
     */
    public static <T> Set<T> intersection(Set<? extends T> a, Set<? extends T> b) {
        Set<T> set = createSet(a);
        set.retainAll(b);
        return set;
    }

    /**
     * Returns the symmetric difference (⊖) of two sets - set of elements which are
     * in one of the sets, but not in both.
     *
     * @param a   the first set.
     * @param b   the second set.
     * @param <T> the type of the parameter.
     * @return a new set that is the difference of A and B.
     */
    public static <T> Set<T> symmetricDifference(Set<? extends T> a, Set<? extends T> b) {
        return union(difference(a, b), difference(b, a));
    }

    /**
     * Returns the relative complement of A in B, also known as the
     * set-theoretical difference of B and A - the set of elements in B, but
     * not in A.
     *
     * @param a   the first set.
     * @param b   the second set.
     * @param <T> the type of the parameter.
     * @return a new set that contains the relative complement of A and B.
     */
    public static <T> Set<T> difference(Set<? extends T> a, Set<? extends T> b) {
        Set<T> set = createSet(b);
        set.removeAll(a);
        return set;
    }

    private static <T> Set<T> createSet(Set<? extends T> b) {
        return new HashSet<>(b);
    }
}
