/*
 * Copyright © 2018 androsaces. All rights reserved.
 */

package com.androsaces.buckaroo.config;

/**
 * This enumeration defines global regions.
 *
 * @author Andrew Kearney
 * @since 1.1.0
 */
public enum Region {
    AMER("Americas"),
    APAC("Asia Pacific"),
    EMEA("Europe, Middle East and Africa"),
    GLOB("Global");

    private final String description;

    Region(String description) {
        this.description = description;
    }

    /**
     * Gets the description of this enum.
     *
     * @return the description of this enum.
     */
    public String getDescription() {
        return description;
    }
}
