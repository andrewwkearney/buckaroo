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
    /**
     * The global region of the Americas.
     * <p>Typically includes North, Central and South America.
     */
    AMER("Americas"),
    /**
     * The global region of Asia Pacific.
     * <p>
     * Typically includes countries on the Pacific rim, like China, Japan,
     * India, Sri Lanka, Singapore, Australia and New Zealand. May also
     * include far east Russia.
     */
    APAC("Asia Pacific"),
    /**
     * The global region of Europe, Middle East and Africa.
     * <p>
     * Typically includes continental Europe, Africa and the Middle East and
     * sometimes may include western Russia.
     * </p>
     */
    EMEA("Europe, Middle East and AFRICA"),
    /**
     * Global region.
     * <p>
     * Encompasses all regions.
     */
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
