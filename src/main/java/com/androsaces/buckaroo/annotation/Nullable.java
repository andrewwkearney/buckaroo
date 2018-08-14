/*
 * Copyright © 2018 androsaces. All rights reserved.
 */

package com.androsaces.buckaroo.annotation;

import java.lang.annotation.*;

/**
 * Any element that has been annotated with {@code Nullable} claims that {@code null}
 * is an acceptable value.
 *
 * @author Andrew Kearney
 */
@Documented
@Retention(RetentionPolicy.CLASS)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
public @interface Nullable {
}
