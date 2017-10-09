package com.androsaces.tools.buckaroo.annotation;

import java.lang.annotation.*;

/**
 * Any element that has been annotated with {@code NotNull} claims that {@code null}
 * is a forbidden value.
 */
@Documented
@Retention(RetentionPolicy.CLASS)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
public @interface NotNull
{
}
