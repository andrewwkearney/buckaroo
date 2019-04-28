/*
 * Copyright © 2019 androsaces. All rights reserved.
 */

package com.androsaces.buckaroo.json;

/**
 * This exception is thrown when JSON data parsed by the {@link JSONObject}
 * class cannot be parsed or formatted.
 *
 * @author Andrew Kearney
 */
public class JSONException extends Exception {
    private static final int CHARS_BEFORE = 40;
    private static final int CHARS_AFTER = 40;

    private int mLineNumber = 0;
    private String mContext = "";

    JSONException() {
    }

    JSONException(String message) {
        super(message);
    }

    JSONException(String message, int position) {
        super(message + " at position " + position);
        if (position < 0) throw new IllegalArgumentException("invalid position " + position);
    }

    JSONException(String message, int position, String line) {
        this(message, position);
        mContext = getContext(line, position);
    }

    JSONException(String message, Throwable cause) {
        super(message, cause);
    }

    JSONException(Throwable cause) {
        super(cause);
    }

    private String getContext(String line, int position) {
        if (position > line.length()) {
            position = line.length();
        }

        StringBuilder result = new StringBuilder();
        result.append(":\n").append('\'');
        if (position > CHARS_BEFORE) {
            result.append("...");
        }
        result.append(line, Math.max(0, position - CHARS_BEFORE), Math.min(line.length(), position + CHARS_AFTER + 1));
        if (position < line.length() - CHARS_AFTER - 1) {
            result.append("...");
        }
        result.append('\'').append("\n").append(' ');
        int blanks;
        if (position > CHARS_BEFORE) {
            result.append("   ");
            blanks = CHARS_BEFORE;
        } else {
            blanks = position;
        }

        result.append(" ".repeat(Math.max(0, blanks))).append('^');
        return result.toString();
    }

    public int getLineNumber() {
        return mLineNumber;
    }

    public void setLineNumber(int lineNumber) {
        mLineNumber = lineNumber;
    }

    @Override
    public String getMessage() {
        String superMessage = super.getMessage();
        return (superMessage != null ? superMessage : "") + " line number " + mLineNumber;
    }

    private String getVerboseMessage() {
        return getMessage() + mContext;
    }

    @Override
    public String toString() {
        String className = getClass().getName();
        String message = getVerboseMessage();
        return className + ": " + message;
    }
}
