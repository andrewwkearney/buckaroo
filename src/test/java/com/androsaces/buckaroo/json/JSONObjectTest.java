package com.androsaces.buckaroo.json;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for {@link JSONObject} class.
 *
 * @author Andrew Kearney
 */
class JSONObjectTest {
    private static final String JSON = "[1,2,null,true,\"four\",5,6,[1,2,3,4,5],{\"bid\":22.3,\"ask\":3.45E13,\"size\":123456},\"{a:55,\\\"b:66\\n}\"]";
    private static final double DELTA = 0.000001;

    private static JSONObject createJSONMessage() {
        try {
            return new JSONObject(JSON);
        } catch (JSONException e) {
            throw new InternalError(e.toString());
        }
    }

    @Nested
    @DisplayName("Basic test cases")
    class BasicTestCases {
        private JSONObject mJSONObject = createJSONMessage();

        @Test
        void testJSONMessage() {
            mJSONObject.getJSONString();
        }

        @Test
        @DisplayName("Test getting java object")
        void testGetJavaObject() {
            Map<String, Object> map = new LinkedHashMap<>();
            map.put("bid", new BigDecimal("22.3"));
            map.put("ask", new BigDecimal("34.5e12"));
            map.put("size", 123456);
            Object object = Arrays.asList(
                    1, 2, null, true, "four", 5, 6,
                    Arrays.asList(1, 2, 3, 4, 5),
                    map,
                    "{a:55,\"b:66\n}");
            assertEquals(object, mJSONObject.getJavaObject());
        }

        @Test
        @DisplayName("toString test")
        void testToString() {
            assertEquals(JSON, mJSONObject.toString());
        }
    }

    @Nested
    @DisplayName("Numeric tests")
    class NumericTests {
        @Test
        @DisplayName("Integer tests")
        void testInteger() {
            assertAll(
                    () -> assertEquals(0, new JSONObject("0").getJavaObject()),
                    () -> assertEquals(10, new JSONObject("10").getJavaObject()),
                    () -> assertEquals(1234, new JSONObject("1234").getJavaObject()),
                    () -> assertEquals(-1234, new JSONObject("-1234").getJavaObject()),
                    () -> assertEquals(-10, new JSONObject("-10").getJavaObject())
            );
        }

        @Test
        @DisplayName("BigInteger tests")
        void testBigInteger() {
            assertAll(
                    () -> assertEquals(new BigInteger("1234567890123456789012"), new JSONObject("1234567890123456789012").getJavaObject()),
                    () -> assertEquals(new BigInteger("-1234567890123456789012"), new JSONObject("-1234567890123456789012").getJavaObject())
            );
        }

        @Test
        @DisplayName("Decimal tests")
        void testDecimal() {
            assertAll(
                    () -> assertEquals(new BigDecimal("1.1"), new JSONObject("1.1").getJavaObject()),
                    () -> assertEquals(new BigDecimal("1.02"), new JSONObject("1.02").getJavaObject()),
                    () -> assertEquals(new BigDecimal("-1.1"), new JSONObject("-1.1").getJavaObject())
            );
        }

        @Test
        @DisplayName("Double tests")
        void testDouble() {
            assertAll("Doubles",
                    () -> assertEquals(new BigDecimal("0.0"), new JSONObject("0.0").getJavaObject()),
                    () -> assertEquals(new BigDecimal("1.1"), new JSONObject("1.1").getJavaObject()),
                    () -> assertEquals(new BigDecimal("-1.1"), new JSONObject("-1.1").getJavaObject()),
                    () -> assertEquals(new BigDecimal("1.2345"), new JSONObject("1.2345").getJavaObject()),
                    () -> assertEquals(new BigDecimal("1.230005"), new JSONObject("1.230005").getJavaObject())
            );
            assertAll("Scientific Notation",
                    () -> assertEquals(new BigDecimal("1E7").doubleValue(), ((Number) new JSONObject("1E7").getJavaObject()).doubleValue(), DELTA),
                    () -> assertEquals(new BigDecimal("12E7").doubleValue(), ((Number) new JSONObject("12E7").getJavaObject()).doubleValue(), DELTA),
                    () -> assertEquals(new BigDecimal("12E-2").doubleValue(), ((Number) new JSONObject("12E-2").getJavaObject()).doubleValue(), DELTA),
                    () -> assertEquals(new BigDecimal("12e-2").doubleValue(), ((Number) new JSONObject("12e-2").getJavaObject()).doubleValue(), DELTA),
                    () -> assertEquals(new BigDecimal("-12E-2").doubleValue(), ((Number) new JSONObject("-12E-2").getJavaObject()).doubleValue(), DELTA),
                    () -> assertEquals(new BigDecimal("-12e-2").doubleValue(), ((Number) new JSONObject("-12e-2").getJavaObject()).doubleValue(), DELTA),
                    () -> assertEquals(new BigDecimal("1275e-2").doubleValue(), ((Number) new JSONObject("1275e-2").getJavaObject()).doubleValue(), DELTA)
            );
        }

        @Test
        @DisplayName("Long tests")
        void testLong() {
            assertAll(
                    () -> assertEquals(1234567891000L, new JSONObject("1234567891000").getJavaObject()),
                    () -> assertEquals(-1234567891000L, new JSONObject("-1234567891000").getJavaObject())
            );
        }

        @Test
        @DisplayName("Integer min value")
        void testIntegerMinValue() throws Exception {
            int expected = Integer.MIN_VALUE;
            Object actual = new JSONObject(String.valueOf(expected)).getJavaObject();
            assertEquals(expected, actual);
            assertEquals(Integer.class, actual.getClass());
        }

        @Test
        @DisplayName("Integer max value")
        void testIntegerMaxValue() throws Exception {
            int expected = Integer.MAX_VALUE;
            Object actual = new JSONObject(String.valueOf(expected)).getJavaObject();
            assertEquals(expected, actual);
            assertEquals(Integer.class, actual.getClass());
        }

        @Test
        @DisplayName("Long min value")
        void testLongMinValue() throws Exception {
            long expected = Long.MIN_VALUE;
            Object actual = new JSONObject(String.valueOf(expected)).getJavaObject();
            assertEquals(expected, actual);
            assertEquals(Long.class, actual.getClass());
        }

        @Test
        @DisplayName("Long max value")
        void testLongMaxValue() throws Exception {
            long expected = Long.MAX_VALUE;
            Object actual = new JSONObject(String.valueOf(expected)).getJavaObject();
            assertEquals(expected, actual);
            assertEquals(Long.class, actual.getClass());
        }

        @Test
        @DisplayName("Double min value")
        void testDoubleMinValue() throws Exception {
            double expected = Double.MIN_VALUE;
            Object actual = new JSONObject(String.valueOf(expected)).getJavaObject();
            assertEquals(BigDecimal.valueOf(expected), actual);
            assertEquals(BigDecimal.class, actual.getClass());
        }

        @Test
        @DisplayName("Double max value")
        void testDoubleMaxValue() throws Exception {
            double expected = Double.MAX_VALUE;
            Object actual = new JSONObject(String.valueOf(expected)).getJavaObject();
            assertEquals(BigDecimal.valueOf(expected), actual);
            assertEquals(BigDecimal.class, actual.getClass());
        }
    }

    @Nested
    @DisplayName("Null and boolean tests")
    class NullAndBooleanTests {
        @Test
        @DisplayName("Test null string")
        void testNull() throws Exception {
            assertNull(new JSONObject("null").getJavaObject());
        }

        @Test
        @DisplayName("Test true string")
        void testTrue() throws Exception {
            assertEquals(Boolean.TRUE, new JSONObject("true").getJavaObject());
        }

        @Test
        @DisplayName("Test false string")
        void testFalse() throws Exception {
            assertEquals(Boolean.FALSE, new JSONObject("false").getJavaObject());
        }
    }

    @Nested
    @DisplayName("Bad number value tests")
    class BadNumberValueTests {
        @Test
        @DisplayName("Bad doubles")
        void testBadDouble() {
            assertAll(
                    () -> assertThrows(JSONException.class, () -> new JSONObject("0xFF")),
                    () -> assertThrows(JSONException.class, () -> new JSONObject("1a")),
                    () -> assertThrows(JSONException.class, () -> new JSONObject("15d")),
                    () -> assertThrows(JSONException.class, () -> new JSONObject("15.")),
                    () -> assertThrows(JSONException.class, () -> new JSONObject("15[")),
                    () -> assertThrows(JSONException.class, () -> new JSONObject("15e")),
                    () -> assertThrows(JSONException.class, () -> new JSONObject("15e7.0"))
            );
        }
    }

    @Nested
    @DisplayName("String value tests")
    class StringValueTests {
        @Test
        @DisplayName("String tests")
        void testString() {
            assertAll(
                    () -> assertEquals("", new JSONObject("\"\"").getJavaObject()),
                    () -> assertEquals("a", new JSONObject("\"a\"").getJavaObject()),
                    () -> assertEquals("aBc", new JSONObject("\"aBc\"").getJavaObject()),
                    () -> assertEquals("testing one two three", new JSONObject("\"testing one two three\"").getJavaObject())
            );
        }

        @Test
        @DisplayName("Escaped string tests")
        void testStringEscape() {
            assertAll(
                    () -> assertEquals("\b", new JSONObject("\"\\b\"").getJavaObject()),
                    () -> assertEquals("\f", new JSONObject("\"\\f\"").getJavaObject()),
                    () -> assertEquals("\n", new JSONObject("\"\\n\"").getJavaObject()),
                    () -> assertEquals("\r", new JSONObject("\"\\r\"").getJavaObject()),
                    () -> assertEquals("\t", new JSONObject("\"\\t\"").getJavaObject()),
                    () -> assertEquals("\\", new JSONObject("\"\\\\\"").getJavaObject()),
                    () -> assertEquals("\"", new JSONObject("\"\\\"\"").getJavaObject()),
                    () -> assertEquals("first\nseconds\rthird", new JSONObject("\"first\\nseconds\\rthird\"").getJavaObject()),
                    () -> assertEquals("with 'single quote'", new JSONObject("\"with 'single quote'\"").getJavaObject()),
                    () -> assertEquals("with \"double quote\"", new JSONObject("\"with \\\"double quote\\\"\"").getJavaObject()),
                    () -> assertEquals("[braces],{curlies}", new JSONObject("\"[braces],{curlies}\"").getJavaObject()),
                    () -> assertEquals("\01\22\u0085", new JSONObject("\"\\u0001\\u0012\\u0085\"").getJavaObject()),
                    () -> assertEquals("one\ntwo\n", new JSONObject("\"one\\ntwo\\u000A\"").getJavaObject()),
                    () -> assertEquals("one\ntwo\n", new JSONObject("\"one\\u000Atwo\\n\"").getJavaObject()),
                    () -> assertEquals("one\ttwo\tthree", new JSONObject("\"one\\ttwo\\tthree\"").getJavaObject())
            );
        }

        @Test
        @DisplayName("Encoded characters")
        void testEncodedChar() {
            assertEquals('\n', JSONObject.encodedChar('n'));
            assertEquals('\t', JSONObject.encodedChar('t'));
            assertEquals('\f', JSONObject.encodedChar('f'));
            assertEquals('\r', JSONObject.encodedChar('r'));
            assertEquals('\\', JSONObject.encodedChar('\\'));
        }
    }

    @Nested
    @DisplayName("Bad string value tests")
    class BadStringValueTests {
        @Test
        @DisplayName("Bad strings")
        void testBadString() {
            assertAll(
                    () -> assertThrows(JSONException.class, () -> new JSONObject("\"")),
                    () -> assertThrows(JSONException.class, () -> new JSONObject("\"\\\"")),
                    () -> assertThrows(JSONException.class, () -> new JSONObject(""))
            );
        }
    }

    @Nested
    @DisplayName("List value tests")
    class ListValueTests {
        @Test
        @DisplayName("Empty list test")
        void testEmptyList() throws Exception {
            assertEquals(Collections.emptyList(), new JSONObject("[]").getJavaObject());
        }

        @Test
        @DisplayName("List tests")
        void testLists() {
            assertAll(
                    () -> assertEquals(Collections.singletonList(1), new JSONObject("[1]").getJavaObject()),
                    () -> assertEquals(Arrays.asList(1, 2, 3, 4), new JSONObject("[1,2,3,4]").getJavaObject()),
                    () -> assertEquals(Arrays.asList("one", "two", "three"), new JSONObject("[\"one\",\"two\",\"three\"]").getJavaObject()),
                    () -> assertEquals(Arrays.asList("one", 2, "three"), new JSONObject("[\"one\",2,\"three\"]").getJavaObject())
            );
        }
    }

    @Nested
    @DisplayName("Bad list tests")
    class BadListTests {
        @Test
        @DisplayName("Bad lists")
        void testBadList() {
            assertAll(
                    () -> assertThrows(JSONException.class, () -> new JSONObject("[,]")),
                    () -> assertThrows(JSONException.class, () -> new JSONObject("[")),
                    () -> assertThrows(JSONException.class, () -> new JSONObject("[5,]")),
                    () -> assertThrows(JSONException.class, () -> new JSONObject("[5,")),
                    () -> assertThrows(JSONException.class, () -> new JSONObject("[5"))
            );
        }
    }

    @Nested
    @DisplayName("Map value tests")
    class MapValueTestCases {
        @Test
        @DisplayName("Empty map")
        void testEmptyMap() throws Exception {
            assertEquals(Collections.emptyMap(), new JSONObject("{}").getJavaObject());
        }

        @Test
        @DisplayName("Map test")
        void testMap() {
            Map<String, Object> bidMap = new LinkedHashMap<>();
            bidMap.put("bid", 1);

            Map<String, Object> zxyMap = new LinkedHashMap<>();
            zxyMap.put("z", 3);
            zxyMap.put("x", 1);
            zxyMap.put("y", 2);

            assertAll(
                    () -> assertEquals(bidMap, new JSONObject("{\"bid\":1}").getJavaObject()),
                    () -> assertEquals(zxyMap, new JSONObject("{\"z\":3,\"x\":1,\"y\":2}").getJavaObject())
            );
        }

        @Test
        @DisplayName("Maps keep order")
        void testMapKeepOrder() throws Exception {
            Map<String, Object> zxyMap = new LinkedHashMap<>();
            zxyMap.put("z", 3);
            zxyMap.put("x", 1);
            zxyMap.put("y", 2);

            Map<String, Object> xzyMap = new LinkedHashMap<>();
            xzyMap.put("x", 3);
            xzyMap.put("z", 1);
            xzyMap.put("y", 2);

            Map<String, Object> zyxMap = new LinkedHashMap<>();
            zyxMap.put("z", 3);
            zyxMap.put("y", 1);
            zyxMap.put("x", 2);

            assertAll(
                    () -> assertEquals(zxyMap, new JSONObject("{\"z\":3,\"x\":1,\"y\":2}").getJavaObject()),
                    () -> assertEquals(xzyMap, new JSONObject("{\"x\":3,\"z\":1,\"y\":2}").getJavaObject()),
                    () -> assertEquals(zyxMap, new JSONObject("{\"z\":3,\"y\":1,\"x\":2}").getJavaObject())
            );
        }
    }

    @Nested
    @DisplayName("Bad map value tests")
    class BadMapValueTests {
        @Test
        @DisplayName("Bad map values")
        void testBadMap() {
            assertAll(
                    () -> assertThrows(JSONException.class, () -> new JSONObject("{,}")),
                    () -> assertThrows(JSONException.class, () -> new JSONObject("{")),
                    () -> assertThrows(JSONException.class, () -> new JSONObject("{\"\":}")),
                    () -> assertThrows(JSONException.class, () -> new JSONObject("{:1}")),
                    () -> assertThrows(JSONException.class, () -> new JSONObject("{one:1}")),
                    () -> assertThrows(JSONException.class, () -> new JSONObject("{1:1}")),
                    () -> assertThrows(JSONException.class, () -> new JSONObject("{5}")),
                    () -> assertThrows(JSONException.class, () -> new JSONObject("{\"\",\"\"}")),
                    () -> assertThrows(JSONException.class, () -> new JSONObject("{\"z\":3,\"x\"1,\"y\":2}"))
            );
        }
    }
}
