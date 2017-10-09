package com.androsaces.tools.buckaroo.collection;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static com.androsaces.tools.buckaroo.collection.Sets.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SetsTest {
    private static final Set a = set(1, 2, 3, 4, 5, 6, 7, 8);
    private static final Set b = set(2, 3, 5, 7, 11, 13, 17);
    private static final Set c = set(1, 2, 3, 5, 8, 13, 21);
    private static final Set empty = Collections.emptySet();

    private static Set set(Object... items) {
        return Collections.unmodifiableSet(new HashSet<>(Arrays.asList(items)));
    }

    @Test
    @DisplayName("Test set union")
    void testUnion() {
        assertEquals(set(1, 2, 3, 4, 5, 6, 7, 8, 11, 13, 17), union(a, b));
        assertEquals(set(1, 2, 3, 5, 7, 8, 11, 13, 17, 21), union(b, c));
        assertEquals(set(1, 2, 3, 4, 5, 6, 7, 8, 13, 21), union(a, c));
    }

    @Test
    @DisplayName("Test set union with itself")
    void testUnionWithSelf() {
        assertEquals(a, union(a, a));
        assertEquals(b, union(b, b));
        assertEquals(c, union(c, c));
    }

    @Test
    @DisplayName("Test set union with empty")
    void testUnionWithEmpty() {
        assertEquals(a, union(a, empty));
        assertEquals(b, union(b, empty));
        assertEquals(c, union(c, empty));
        assertEquals(a, union(empty, a));
        assertEquals(b, union(empty, b));
        assertEquals(c, union(empty, c));
    }

    @Test
    @DisplayName("Test set union commutativity")
    void testUnionCommutativity() {
        assertEquals(union(a, b), union(b, a));
        assertEquals(union(b, c), union(c, b));
        assertEquals(union(a, c), union(c, a));
    }

    @Test
    @DisplayName("Test set intersection")
    void testIntersection() {
        assertEquals(set(2, 3, 5, 7), intersection(a, b));
        assertEquals(set(2, 3, 5, 13), intersection(b, c));
        assertEquals(set(1, 2, 3, 5, 8), intersection(a, c));
    }

    @Test
    @DisplayName("Test set intersection itself")
    void testIntersectionWithSelf() {
        assertEquals(a, intersection(a, a));
        assertEquals(b, intersection(b, b));
        assertEquals(c, intersection(c, c));
    }

    @Test
    @DisplayName("Test set intersection with empty")
    void testIntersectionWithEmpty() {
        assertEquals(empty, intersection(a, empty));
        assertEquals(empty, intersection(b, empty));
        assertEquals(empty, intersection(c, empty));
    }

    @Test
    @DisplayName("Test set intersection commutativity")
    void testIntersectionCommutativity() {
        assertEquals(intersection(b, a), intersection(a, b));
        assertEquals(intersection(c, b), intersection(b, c));
        assertEquals(intersection(c, a), intersection(a, c));
    }

    @Test
    @DisplayName("Test symmetric difference")
    void testSymmetricDifference() {
        assertEquals(set(1, 4, 6, 8, 11, 13, 17), symmetricDifference(a, b));
        assertEquals(set(1, 7, 8, 11, 17, 21), Sets.symmetricDifference(b, c));
        assertEquals(set(4, 6, 7, 13, 21), Sets.symmetricDifference(a, c));
    }

    @Test
    @DisplayName("Test symmetrical difference with self")
    void testSymmetricDifferenceWithSelf() {
        assertEquals(empty, symmetricDifference(a, a));
        assertEquals(empty, symmetricDifference(b, b));
        assertEquals(empty, symmetricDifference(c, c));
    }

    @Test
    @DisplayName("Test symmetrical difference with empty")
    void testSymmetricalDifferenceWithEmpty() {
        assertEquals(a, symmetricDifference(empty, a));
        assertEquals(b, symmetricDifference(empty, b));
        assertEquals(c, symmetricDifference(empty, c));
        assertEquals(a, symmetricDifference(a, empty));
        assertEquals(b, symmetricDifference(b, empty));
        assertEquals(c, symmetricDifference(c, empty));
    }

    @Test
    @DisplayName("Test difference")
    void testDifference() {
        assertEquals(set(11, 13, 17), difference(a, b));
        assertEquals(set(1, 4, 6, 8), difference(b, a));
        assertEquals(set(4, 6, 7), difference(c, a));
        assertEquals(set(13, 21), difference(a, c));
        assertEquals(set(1, 8, 21), difference(b, c));
        assertEquals(set(7, 11, 17), difference(c, b));
    }

    @Test
    @DisplayName("Test difference with empty")
    void testDifferenceWithEmpty() {
        assertEquals(a, difference(empty, a));
        assertEquals(b, difference(empty, b));
        assertEquals(c, difference(empty, c));
        assertEquals(empty, difference(a, empty));
        assertEquals(empty, difference(b, empty));
        assertEquals(empty, difference(c, empty));
    }
}