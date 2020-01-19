/*
 * Copyright &copy; 2019 androsaces. All rights reserved.
 */

package com.androsaces.buckaroo.json;

import com.androsaces.buckaroo.Params;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class provides a JSON object representation that is created by parsing
 * a JSON formatted string.
 * <p>
 * JSON (JavaScript Object Notation) is a lightweight data-interchange format.
 * It is easy for humans to read and write. It is easy for machines to parse
 * and generate. It is based on a subset of the JavaScript Programming Language.
 * JSON is a text format that is completely language independent but uses
 * conventions that are familiar to programmers of the C-family of languages,
 * including C, C++, C#, Java, JavaScript, Perl, Python, and many others.
 * These properties make JSON an ideal data-interchange language.
 *
 * @author Andrew Kearney
 * @since 2.1.0
 */
public class JSONObject {
    private static final Pattern NUMBER_PATTERN = Pattern.compile("(-?\\d+)(\\.\\d+)?([eE][+-]?\\d+)?");

    private int mPosition = 0;
    private String mJSONString;
    private Object mJavaObject;

    /**
     * Creates a JSON object by parsing a formatted JSON string.
     *
     * @param JSONString the JSON string to parse
     * @throws JSONException if the string is not valid JSON
     */
    public JSONObject(String JSONString) throws JSONException {
        mJSONString = Params.notNull(JSONString, "JSONString");
        mJavaObject = parseMessage();
        skipWhitespaceAtEnd();
    }

    static char encodedChar(char c) {
        switch (c) {
            case 'b':
                return '\b';
            case 'f':
                return '\f';
            case 'n':
                return '\n';
            case 'r':
                return '\r';
            case 't':
                return '\t';
            default:
                return c;
        }
    }

    /**
     * Returns the formatted JSON string
     *
     * @return a formatted JSON string
     */
    public String getJSONString() {
        return mJSONString;
    }

    /**
     * Returns the Java object that was created by parsing the JSON string
     *
     * @return a formatted JSON string
     */
    public Object getJavaObject() {
        return mJavaObject;
    }

    private Object parseMessage() throws JSONException {
        return parseObject();
    }

    private Object parseObject() throws JSONException {
        try {
            while (mPosition < mJSONString.length()) {
                char c = mJSONString.charAt(mPosition);
                switch (c) {
                    case '"':
                        return parseString();
                    case '-':
                    case '0':
                    case '1':
                    case '2':
                    case '3':
                    case '4':
                    case '5':
                    case '6':
                    case '7':
                    case '8':
                    case '9':
                        return parseNumber();
                    case '[':
                        return parseArray();
                    case '{':
                        return parseMap();
                    case 'f':
                        return parseBoolean(false);
                    case 't':
                        return parseBoolean(true);
                    case 'n':
                        return parseNull();
                    case ' ':
                    case '\t':
                    case '\n':
                    case '\r':
                        ++mPosition;
                        break;
                    default:
                        throw new JSONException("Unexpected character '" + c + '\'', mPosition);
                }
            }
            throw new JSONException("Out of data where object expected", mPosition, mJSONString);
        } catch (RuntimeException e) {
            throw new JSONException("Parse error due to " + e, mPosition, mJSONString);
        }
    }

    private String parseString() throws JSONException {
        if (mJSONString.charAt(mPosition++) != '"') {
            throw new JSONException("Expected quotes at start of string", mPosition, mJSONString);
        }
        int start = mPosition;
        boolean quoted = false;
        StringBuilder builder = null;
        for (int i = start; i < mJSONString.length(); i++) {
            char c = mJSONString.charAt(i);
            if (quoted) {
                if (c == 'u') {
                    String hex = mJSONString.substring(i + 1, i + 5);
                    int code = Integer.parseInt(hex, 16);
                    builder.append((char) code);
                    i += 4;
                } else {
                    builder.append(encodedChar(c));
                }
                quoted = false;
            } else {
                switch (c) {
                    case '\\':
                        if (builder == null) {
                            builder = new StringBuilder(mJSONString.substring(start, i));
                        }
                        quoted = true;
                        break;
                    case '"':
                        mPosition = i + 1;
                        return builder == null ? mJSONString.substring(start, i) : builder.toString();
                    default:
                        if (builder != null) {
                            builder.append(c);
                        }
                        break;
                }
            }
        }
        throw new JSONException("Closing string quote expected", mPosition, mJSONString);
    }

    private Object parseNumber() throws JSONException {
        Matcher matcher = NUMBER_PATTERN.matcher(mJSONString.substring(mPosition));
        if (matcher.lookingAt()) {
            String numberString = matcher.group();
            mPosition += numberString.length();
            if (matcher.group(2) != null) {
                return parseRealNumber(numberString);
            } else if (matcher.group(3) != null) {
                return parseRealNumber(matcher.group(1) + ".0" + matcher.group(3));
            } else {
                return parseInteger(numberString);
            }
        } else {
            throw new JSONException("Expected a number", mPosition, mJSONString);
        }
    }

    private Object parseRealNumber(String numberString) {
        return new BigDecimal(numberString);
    }

    private Object parseInteger(String numberString) {
        try {
            return toPrimitiveInteger(numberString);
        } catch (NumberFormatException e) {
            return new BigInteger(numberString);
        }
    }

    private Number toPrimitiveInteger(String numberString) {
        if (numberString.length() > 9) {
            Long number = Long.valueOf(numberString);
            if (number == number.intValue()) {
                return number.intValue();
            } else {
                return number;
            }
        }
        return Integer.parseInt(numberString);
    }

    private Object parseArray() throws JSONException {
        skipWhitespace();
        List<Object> list = new ArrayList<>();
        if (mJSONString.charAt(++mPosition) == ']') {
            ++mPosition;
        } else {
            for (; ; ) {
                list.add(parseObject());
                skipWhitespace();
                char c = mJSONString.charAt(mPosition++);
                if (c == ']') break;
                if (c != ',') throw new JSONException("Expected comma between items in list", mPosition, mJSONString);
            }
        }
        return list;
    }

    private Map<String, ?> parseMap() throws JSONException {
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        skipWhitespace();
        if (mJSONString.charAt(++mPosition) == '}') {
            ++mPosition;
        } else {
            for (; ; ) {
                skipWhitespace();
                String key = parseString();
                skipWhitespace();
                if (mJSONString.charAt(mPosition++) != ':') {
                    throw new JSONException("Expected colon after map key", mPosition, mJSONString);
                }
                Object value = parseObject();
                map.put(key, value);
                skipWhitespace();
                char c = mJSONString.charAt(mPosition++);
                if (c == '}') break;
                if (c != ',') throw new JSONException("expected comma between map pairs", mPosition, mJSONString);
            }
        }
        return map;
    }

    private Object parseBoolean(boolean bool) throws JSONException {
        if (bool) {
            validateExpectedText("true");
            return true;
        } else {
            validateExpectedText("false");
            return false;
        }
    }

    private Object parseNull() throws JSONException {
        validateExpectedText("null");
        return null;
    }

    private void validateExpectedText(String text) throws JSONException {
        if (mJSONString.startsWith(text, mPosition)) {
            mPosition += text.length();
        } else {
            throw new JSONException("Expected \"" + text + '"', mPosition, mJSONString);
        }
    }

    private void skipWhitespaceAtEnd() throws JSONException {
        skipWhitespace();
        if (mPosition < mJSONString.length()) {
            throw new JSONException("Invalid data", mPosition, mJSONString);
        }
    }

    private void skipWhitespace() {
        while (mPosition < mJSONString.length() && isWhitespace(mJSONString.charAt(mPosition))) {
            mPosition++;
        }
    }

    private boolean isWhitespace(char c) {
        return c == ' ' || c == '\r' || c == '\n' || c == '\t';
    }

    @Override
    public String toString() {
        return mJSONString;
    }
}
