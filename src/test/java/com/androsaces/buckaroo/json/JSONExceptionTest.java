/*
 * Copyright &copy; 2019 androsaces. All rights reserved.
 */

package com.androsaces.buckaroo.json;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Unit test for {@link JSONException} class.
 *
 * @author Andrew Kearney
 */
class JSONExceptionTest {
    @Test
    void test_message_with_no_truncation() {
        JSONException exception = new JSONException("expected colon after map key", 2, "0xFF");

        assertEquals("com.androsaces.buckaroo.json.JSONException: expected colon after map key at position 2 line number 0:\n"
                        + "'0xFF'\n"
                        + "   ^",
                exception.toString());

        assertEquals("expected colon after map key at position 2 line number 0", exception.getMessage());
    }

    @Test
    void test_first_index() {
        JSONException exception = new JSONException("expected colon after map key", 0, "0xFF");

        assertEquals("com.androsaces.buckaroo.json.JSONException: expected colon after map key at position 0 line number 0:\n"
                        + "'0xFF'\n"
                        + " ^",
                exception.toString());

        assertEquals("expected colon after map key at position 0 line number 0", exception.getMessage());
    }

    @Test
    void test_last_index() {
        JSONException exception = new JSONException("expected colon after map key", 3, "0xFF");

        assertEquals("com.androsaces.buckaroo.json.JSONException: expected colon after map key at position 3 line number 0:\n"
                        + "'0xFF'\n"
                        + "    ^",
                exception.toString());

        assertEquals("expected colon after map key at position 3 line number 0", exception.getMessage());
    }

    @Test
    void test_message_with_no_truncation_with_index_out_of_bound() {
        JSONException exception = new JSONException("expected colon after map key", 8, "0xFF");

        assertEquals("com.androsaces.buckaroo.json.JSONException: expected colon after map key at position 8 line number 0:\n"
                        + "'0xFF'\n"
                        + "     ^",
                exception.toString());

        assertEquals("expected colon after map key at position 8 line number 0", exception.getMessage());
    }


    @Test
    void negative_sequence_is_illegal() {
        assertThrows(IllegalArgumentException.class, () -> new JSONException("expected colon after map key", -1, "0xFF"));
    }

    @Test
    void test_message_with_no_line() {
        JSONException exception = new JSONException("expected colon after map key", 2);

        assertEquals("com.androsaces.buckaroo.json.JSONException: expected colon after map key at position 2 line number 0",
                exception.toString());

        assertEquals("expected colon after map key at position 2 line number 0", exception.getMessage());

    }

    @Test
    void test_message_with_start_truncation() {
        JSONException exception = new JSONException("expected colon after map key", 48, "{\"menu\": {\"id\": \"file\",\"value\": \"File\",\"popup\": {\"menuitem\": [{\"value\": \"New\", \"onclick\": \"CreateNewDoc()\"},]}}}");


        assertEquals("com.androsaces.buckaroo.json.JSONException: expected colon after map key at position 48 line number 0:\n"
                        + "'... {\"id\": \"file\",\"value\": \"File\",\"popup\": {\"menuitem\": [{\"value\": \"New\", \"onclick\":...'\n"
                        + "                                            ^",
                exception.toString());

        assertEquals("expected colon after map key at position 48 line number 0", exception.getMessage());
    }

    @Test
    void test_message_with_start_truncation_and_out_of_bound() {
        JSONException exception = new JSONException("expected colon after map key", 93, "{\"menu\": {\"id\": \"file\",\"value\": \"File\",\"popup\": {\"menuitem\": [{\"value\": \"New\", \"onclick\": \"CreateNewDoc()\"},]}}}");


        assertEquals("com.androsaces.buckaroo.json.JSONException: expected colon after map key at position 93 line number 0:\n"
                        + "'...uitem\": [{\"value\": \"New\", \"onclick\": \"CreateNewDoc()\"},]}}}'\n"
                        + "                                            ^",
                exception.toString());

        assertEquals("expected colon after map key at position 93 line number 0", exception.getMessage());
    }

    @Test
    void test_message_with_end_truncation() {
        JSONException exception = new JSONException("expected colon after map key", 5, "{\"menu\": {\"id\": \"file\",\"value\": \"File\",\"popup\": {\"menuitem\": [{\"value\": \"New\", \"onclick\": \"CreateNewDoc()\"},]}}}");

        assertEquals("com.androsaces.buckaroo.json.JSONException: expected colon after map key at position 5 line number 0:\n"
                        + "'{\"menu\": {\"id\": \"file\",\"value\": \"File\",\"popup\"...'\n"
                        + "      ^",
                exception.toString());

        assertEquals("expected colon after map key at position 5 line number 0", exception.getMessage());
    }

    @Test
    void test_message_with_start_truncation_with_exactly_40_characters_at_the_end() {
        JSONException exception = new JSONException("expected colon after map key", 42, "{\"menu\": {\"id\": \"file\",\"value\": \"File\",\"popup\": {\"menuitem\": [{\"value\": \"New\", \"onclick\": \"CreateNewDoc()\"},]}}}");


        assertEquals("com.androsaces.buckaroo.json.JSONException: expected colon after map key at position 42 line number 0:\n"
                        + "'...menu\": {\"id\": \"file\",\"value\": \"File\",\"popup\": {\"menuitem\": [{\"value\": \"New\", \"onc...'\n"
                        + "                                            ^",
                exception.toString());

        assertEquals("expected colon after map key at position 42 line number 0", exception.getMessage());

    }

    @Test
    void test_message_with_end_truncation_with_exactly_40_characters_at_the_beginning() {
        JSONException exception = new JSONException("expected colon after map key", 40, "{\"menu\": {\"id\": \"file\",\"value\": \"File\",\"popup\": {\"menuitem\": [{\"value\": \"New\", \"onclick\": \"CreateNewDoc()\"},]}}}");

        assertEquals("com.androsaces.buckaroo.json.JSONException: expected colon after map key at position 40 line number 0:\n"
                        + "'{\"menu\": {\"id\": \"file\",\"value\": \"File\",\"popup\": {\"menuitem\": [{\"value\": \"New\", \"o...'\n"
                        + "                                         ^",
                exception.toString());

        assertEquals("expected colon after map key at position 40 line number 0", exception.getMessage());
    }

    @Test
    void test_message_with_start_and_end_truncation() {
        JSONException exception = new JSONException("expected colon after map key", 45, "{\"menu\": {\"id\": \"file\",\"value\": \"File\",\"popup\": {\"menuitem\": [{\"value\": \"New\", \"onclick\": \"CreateNewDoc()\"},]}}}");

        assertEquals("com.androsaces.buckaroo.json.JSONException: expected colon after map key at position 45 line number 0:\n"
                        + "'...u\": {\"id\": \"file\",\"value\": \"File\",\"popup\": {\"menuitem\": [{\"value\": \"New\", \"onclic...'\n"
                        + "                                            ^",
                exception.toString());

        assertEquals("expected colon after map key at position 45 line number 0", exception.getMessage());

    }

    @Test
    void by_default_line_number_is_0() {
        JSONException exception = new JSONException("expected colon after map key", 40);
        assertEquals(0, exception.getLineNumber());
    }

    @Test
    void test_set_line_number() {
        JSONException exception = new JSONException("expected colon after map key", 40);
        exception.setLineNumber(11);
        assertEquals(11, exception.getLineNumber());
    }

    @Test
    void test_message_with_empty_line() {
        JSONException exception = new JSONException("expected colon after map key", 0, "");

        assertEquals("com.androsaces.buckaroo.json.JSONException: expected colon after map key at position 0 line number 0:\n"
                        + "''\n"
                        + " ^",
                exception.toString());

        assertEquals("expected colon after map key at position 0 line number 0", exception.getMessage());
    }

    @Test
    void test_default_constructor() {
        JSONException exception = new JSONException();

        assertEquals("com.androsaces.buckaroo.json.JSONException:  line number 0",
                exception.toString());

        assertEquals(" line number 0", exception.getMessage());
    }

    @Test
    void test_constructor_with_message() {
        JSONException exception = new JSONException("an error has occurred");

        assertEquals("com.androsaces.buckaroo.json.JSONException: an error has occurred line number 0",
                exception.toString());

        assertEquals("an error has occurred line number 0", exception.getMessage());
    }

    @Test
    void test_constructor_with_message_and_cause() {
        Exception cause = new IllegalStateException("bad error");
        JSONException exception = new JSONException("an error has occurred", cause);
        assertEquals(cause, exception.getCause());

        assertEquals("com.androsaces.buckaroo.json.JSONException: an error has occurred line number 0",
                exception.toString());

        assertEquals("an error has occurred line number 0", exception.getMessage());
    }

    @Test
    void test_constructor_with_and_cause() {
        Exception cause = new IllegalStateException("an error has occurred");
        JSONException exception = new JSONException(cause);
        assertEquals(cause, exception.getCause());

        assertEquals("com.androsaces.buckaroo.json.JSONException: java.lang.IllegalStateException: an error has occurred line number 0",
                exception.toString());

        assertEquals("java.lang.IllegalStateException: an error has occurred line number 0", exception.getMessage());
    }
}
