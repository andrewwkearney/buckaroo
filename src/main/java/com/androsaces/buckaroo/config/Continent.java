/*
 * Copyright © 2018 androsaces. All rights reserved.
 */

package com.androsaces.buckaroo.config;

/**
 * This enumeration defines the continents.
 *
 * @author Andrew Kearney
 * @since 1.1.0
 */
public enum Continent {
    /**
     * Africa.
     * <p>
     * The continent of Africa along with islands including Madagascar and
     * other outlying archipelagos.
     */
    AFRICA("Africa"),
    /**
     * Antarctica.
     */
    ANTARCTICA("Antarctica"),
    /**
     * Asia.
     * <p>
     * The continent of Asia including China, Russia, Japan, India, Sri Lanka
     * and other small archipelagos.
     */
    ASIA("Asia"),
    /**
     * Australia.
     * <p>
     * The continent of Australia, including mainland Australia, Tasmania,
     * New Guinea and New Britain.
     */
    AUSTRALIA("Australia"),
    /**
     * Europe.
     * <p>
     * The continent of Europe including western Russia and Turkey and islands
     * including Ireland, United Kingdom, Iceland and smaller islands.
     */
    EUROPE("Europe"),
    /**
     * North America.
     * <p>
     * The continent of North America including the United States of America,
     * Canada, Mexico and other central American countries.
     */
    NORTH_AMERICA("North America"),
    /**
     * Oceania.
     * <p>
     * While not technically a continent, it includes other countries in the
     * Asia Pacific region like New Zealand, Hawaii, Guam, Fiji and French
     * Polynesia.
     */
    OCEANIA("Oceania"),
    /**
     * South America.
     * <p>
     * The continent of South America including Galapagos Islands, and the
     * Falklands islands.
     */
    SOUTH_AMERICA("South America");

    private final String description;

    Continent(String description) {
        this.description = description;
    }

    /**
     * Gets the description of the continent.
     *
     * @return the description of the continent.
     */
    public String getDescription() {
        return description;
    }

    /**
     * @see Object#toString()
     */
    @Override
    public String toString() {
        return description;
    }
}
