/*
 * Copyright &copy; 2018 androsaces. All rights reserved.
 */

package com.androsaces.buckaroo.collection;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SetsTest {
    private static final Set<Integer> a = Set.of(1, 2, 3, 4, 5, 6, 7, 8);
    private static final Set<Integer> b = Set.of(2, 3, 5, 7, 11, 13, 17);
    private static final Set<Integer> c = Set.of(1, 2, 3, 5, 8, 13, 21);
    private static final Set<Integer> empty = Collections.emptySet();

    @Test
    @DisplayName("Test set union")
    void testUnion() {
        assertEquals(Set.of(1, 2, 3, 4, 5, 6, 7, 8, 11, 13, 17), Sets.union(a, b));
        assertEquals(Set.of(1, 2, 3, 5, 7, 8, 11, 13, 17, 21), Sets.union(b, c));
        assertEquals(Set.of(1, 2, 3, 4, 5, 6, 7, 8, 13, 21), Sets.union(a, c));
    }

    @Test
    @DisplayName("Test set union with itself")
    void testUnionWithSelf() {
        assertEquals(a, Sets.union(a, a));
        assertEquals(b, Sets.union(b, b));
        assertEquals(c, Sets.union(c, c));
    }

    @Test
    @DisplayName("Test set union with empty")
    void testUnionWithEmpty() {
        assertEquals(a, Sets.union(a, empty));
        assertEquals(b, Sets.union(b, empty));
        assertEquals(c, Sets.union(c, empty));
        assertEquals(a, Sets.union(empty, a));
        assertEquals(b, Sets.union(empty, b));
        assertEquals(c, Sets.union(empty, c));
    }

    @Test
    @DisplayName("Test set union commutativity")
    void testUnionCommutativity() {
        assertEquals(Sets.union(a, b), Sets.union(b, a));
        assertEquals(Sets.union(b, c), Sets.union(c, b));
        assertEquals(Sets.union(a, c), Sets.union(c, a));
    }

    @Test
    @DisplayName("Test set intersection")
    void testIntersection() {
        assertEquals(Set.of(2, 3, 5, 7), Sets.intersection(a, b));
        assertEquals(Set.of(2, 3, 5, 13), Sets.intersection(b, c));
        assertEquals(Set.of(1, 2, 3, 5, 8), Sets.intersection(a, c));
    }

    @Test
    @DisplayName("Test set intersection itself")
    void testIntersectionWithSelf() {
        assertEquals(a, Sets.intersection(a, a));
        assertEquals(b, Sets.intersection(b, b));
        assertEquals(c, Sets.intersection(c, c));
    }

    @Test
    @DisplayName("Test set intersection with empty")
    void testIntersectionWithEmpty() {
        assertEquals(empty, Sets.intersection(a, empty));
        assertEquals(empty, Sets.intersection(b, empty));
        assertEquals(empty, Sets.intersection(c, empty));
    }

    @Test
    @DisplayName("Test set intersection commutativity")
    void testIntersectionCommutativity() {
        assertEquals(Sets.intersection(b, a), Sets.intersection(a, b));
        assertEquals(Sets.intersection(c, b), Sets.intersection(b, c));
        assertEquals(Sets.intersection(c, a), Sets.intersection(a, c));
    }

    @Test
    @DisplayName("Test symmetric difference")
    void testSymmetricDifference() {
        assertEquals(Set.of(1, 4, 6, 8, 11, 13, 17), Sets.symmetricDifference(a, b));
        assertEquals(Set.of(1, 7, 8, 11, 17, 21), Sets.symmetricDifference(b, c));
        assertEquals(Set.of(4, 6, 7, 13, 21), Sets.symmetricDifference(a, c));
    }

    @Test
    @DisplayName("Test symmetrical difference with self")
    void testSymmetricDifferenceWithSelf() {
        assertEquals(empty, Sets.symmetricDifference(a, a));
        assertEquals(empty, Sets.symmetricDifference(b, b));
        assertEquals(empty, Sets.symmetricDifference(c, c));
    }

    @Test
    @DisplayName("Test symmetrical difference with empty")
    void testSymmetricalDifferenceWithEmpty() {
        assertEquals(a, Sets.symmetricDifference(empty, a));
        assertEquals(b, Sets.symmetricDifference(empty, b));
        assertEquals(c, Sets.symmetricDifference(empty, c));
        assertEquals(a, Sets.symmetricDifference(a, empty));
        assertEquals(b, Sets.symmetricDifference(b, empty));
        assertEquals(c, Sets.symmetricDifference(c, empty));
    }

    @Test
    @DisplayName("Test difference")
    void testDifference() {
        assertEquals(Set.of(11, 13, 17), Sets.difference(a, b));
        assertEquals(Set.of(1, 4, 6, 8), Sets.difference(b, a));
        assertEquals(Set.of(4, 6, 7), Sets.difference(c, a));
        assertEquals(Set.of(13, 21), Sets.difference(a, c));
        assertEquals(Set.of(1, 8, 21), Sets.difference(b, c));
        assertEquals(Set.of(7, 11, 17), Sets.difference(c, b));
    }

    @Test
    @DisplayName("Test difference with empty")
    void testDifferenceWithEmpty() {
        assertEquals(a, Sets.difference(empty, a));
        assertEquals(b, Sets.difference(empty, b));
        assertEquals(c, Sets.difference(empty, c));
        assertEquals(empty, Sets.difference(a, empty));
        assertEquals(empty, Sets.difference(b, empty));
        assertEquals(empty, Sets.difference(c, empty));
    }
}