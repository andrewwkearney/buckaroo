package com.androsaces.buckaroo.functional;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.function.Function;

import static com.androsaces.buckaroo.functional.IfNotNull.setIfNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for {@link IfNotNull} class.
 *
 * @author Andrew Kearney
 */
class IfNotNullTest {
    private final Examples mExamples = new Examples();

    @Nested
    class PrimitiveTests {
        @Test
        void booleanIsSet() {
            validateBoolean(mExamples, true);
            validateBoolean(mExamples, false);
        }

        @Test
        void byteIsSet() {
            validateByte(mExamples, Byte.MAX_VALUE);
            validateByte(mExamples, Byte.MIN_VALUE);
        }

        @Test
        void charIsSet() {
            validateChar(mExamples, Character.MAX_VALUE);
            validateChar(mExamples, Character.MIN_VALUE);
        }

        @Test
        void doubleIsSet() {
            validateDouble(mExamples, Double.MAX_VALUE);
            validateDouble(mExamples, Double.MIN_VALUE);
        }

        @Test
        void floatIsSet() {
            validateFloat(mExamples, Float.MAX_VALUE);
            validateFloat(mExamples, Float.MIN_VALUE);
        }

        @Test
        void intIsSet() {
            validateInt(mExamples, Integer.MAX_VALUE);
            validateInt(mExamples, Integer.MIN_VALUE);
        }

        @Test
        void longIsSet() {
            validateLong(mExamples, Long.MAX_VALUE);
            validateLong(mExamples, Long.MIN_VALUE);
        }

        @Test
        void objectIsSet() {
            validateObject(mExamples, new Object());
        }

    }

    @Nested
    class ObjectTransformTests {
        @Test
        void bigDecimalIsSet() {
            setIfNotNull(mExamples::setObject, "100", BigDecimal::new);
            assertEquals(new BigDecimal(100), mExamples.getObject());
        }

        @Test
        void localDateIsSet() {
            setIfNotNull(mExamples::setObject, "2020-01-01", LocalDate::parse);
            assertEquals(LocalDate.of(2020, Month.JANUARY, 1), mExamples.getObject());
        }
    }

    private void validateObject(Examples examples, Object value) {
        setIfNotNull(mExamples::setObject, value);
        assertEquals(value, examples.getObject());
    }

    private void validateBoolean(Examples examples, boolean value) {
        setIfNotNull(examples::setBoolean, value);
        assertEquals(value, examples.getBoolean());
    }

    private void validateByte(Examples examples, byte value) {
        setIfNotNull(examples::setByte, value);
        assertEquals(value, examples.getByte());
    }

    private void validateChar(Examples examples, char value) {
        setIfNotNull(examples::setChar, value);
        assertEquals(value, examples.getChar());
    }

    private void validateDouble(Examples examples, double value) {
        setIfNotNull(examples::setDouble, value);
        assertEquals(value, examples.getDouble() );
    }

    private void validateFloat(Examples examples, float value) {
        setIfNotNull(examples::setFloat, value);
        assertEquals(value, examples.getFloat() );
    }

    private void validateInt(Examples examples, int value) {
        setIfNotNull(examples::setInt, value);
        assertEquals(value, examples.getInt());
    }

    private void validateLong(Examples examples, long value) {
        setIfNotNull(examples::setLong, value);
        assertEquals(value, examples.getLong());
    }

    private static class Examples {
        private Object mObject;
        private boolean mBoolean;
        private byte mByte;
        private char mChar;
        private double mDouble;
        private float mFloat;
        private int mInt;
        private long mLong;
        private short mShort;
        private String mString;

        public Object getObject() {
            return mObject;
        }

        public void setObject(Object object) {
            mObject = object;
        }

        public byte getByte() {
            return mByte;
        }

        public void setByte(Byte aByte) {
            mByte = aByte;
        }

        public char getChar() {
            return mChar;
        }

        public void setChar(char aChar) {
            mChar = aChar;
        }

        public double getDouble() {
            return mDouble;
        }

        public void setDouble(double aDouble) {
            mDouble = aDouble;
        }

        public double getFloat() {
            return mFloat;
        }

        public void setFloat(float aFloat) {
            mFloat = aFloat;
        }

        public int getInt() {
            return mInt;
        }

        public void setInt(int anInt) {
            mInt = anInt;
        }

        public long getLong() {
            return mLong;
        }

        public void setLong(long aLong) {
            mLong = aLong;
        }

        public short getShort() {
            return mShort;
        }

        public void setShort(short aShort) {
            mShort = aShort;
        }

        public String getString() {
            return mString;
        }

        public void setString(String string) {
            mString = string;
        }

        public boolean getBoolean() {
            return mBoolean;
        }

        public void setBoolean(boolean bool) {
            mBoolean = bool;
        }
    }
}