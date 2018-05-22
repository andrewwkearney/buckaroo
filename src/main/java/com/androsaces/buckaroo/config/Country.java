/*
 * Copyright © 2018 androsaces. All rights reserved.
 */

package com.androsaces.buckaroo.config;

import static com.androsaces.buckaroo.config.Region.*;

/**
 * This enumeration defines countries. The enumeration references the ISO-3166
 * codes for each country. Some non-ISO codes have been added to
 * support the countries with the United Kingdom.
 *
 * @author Andrew Kearney
 * @since 1.1.0
 */
public enum Country {
    ABW(AMER, Continent.NorthAmerica, "Aruba"),
    AFG(APAC, Continent.Asia, "Afghanistan"),
    AGO(EMEA, Continent.Africa, "Angola"),
    AIA(AMER, Continent.NorthAmerica, "Anguilla"),
    ALB(EMEA, Continent.Europe, "Albania"),
    AND(EMEA, Continent.Europe, "Andorra"),
    ARE(EMEA, Continent.Asia, "United Arab Emirates"),
    ARG(AMER, Continent.SouthAmerica, "Argentina"),
    ARM(EMEA, Continent.Asia, "Armenia"),
    ASM(APAC, Continent.Oceania, "American Samoa"),
    ATA(GLOB, Continent.Antarctica, "Antarctica"),
    ATG(AMER, Continent.NorthAmerica, "Antigua"),
    AUS(APAC, Continent.Australia, "Australia"),
    AUT(EMEA, Continent.Europe, "Austria"),
    AZE(EMEA, Continent.Asia, "Azerbaijan"),
    BDI(EMEA, Continent.Africa, "Burundi"),
    BEL(EMEA, Continent.Europe, "Belgium"),
    BEN(EMEA, Continent.Africa, "Benin"),
    BES(AMER, Continent.NorthAmerica, "Bonaire"),
    BFA(EMEA, Continent.Africa, "Burkina Faso"),
    BGD(APAC, Continent.Asia, "Bangladesh"),
    BGR(EMEA, Continent.Europe, "Bulgaria"),
    BHR(EMEA, Continent.Asia, "Bahrain"),
    BHS(AMER, Continent.NorthAmerica, "Bahamas"),
    BIH(EMEA, Continent.Europe, "Bosnia and Herzegovina"),
    BLM(AMER, Continent.NorthAmerica, "Saint Barthlemy"),
    BLR(EMEA, Continent.Europe, "Belarus"),
    BLZ(AMER, Continent.NorthAmerica, "Belize"),
    BMU(AMER, Continent.NorthAmerica, "Bermuda"),
    BOL(AMER, Continent.SouthAmerica, "Bolivia"),
    BRA(AMER, Continent.SouthAmerica, "Brazil"),
    BRB(AMER, Continent.NorthAmerica, "Barbados"),
    BRN(APAC, Continent.Asia, "Brunei"),
    BTN(APAC, Continent.Asia, "Bhutan"),
    BVT(GLOB, Continent.Antarctica, "Bouvet Island"),
    BWA(EMEA, Continent.Africa, "Botswana"),
    CAF(EMEA, Continent.Africa, "Central African Republic"),
    CAN(AMER, Continent.NorthAmerica, "Canada"),
    CCK(APAC, Continent.Asia, "Cocos Islands"),
    CHE(EMEA, Continent.Europe, "Switzerland"),
    CHL(AMER, Continent.SouthAmerica, "Chile"),
    CHN(APAC, Continent.Asia, "China"),
    CIV(EMEA, Continent.Africa, "Ivory Coast"),
    CMR(EMEA, Continent.Africa, "Cameroon"),
    COG(EMEA, Continent.Africa, "Congo"),
    COK(APAC, Continent.Oceania, "Cook Islands"),
    COL(AMER, Continent.SouthAmerica, "Colombia"),
    COM(EMEA, Continent.Africa, "Comoros"),
    CPV(EMEA, Continent.Africa, "Cape Verde"),
    CRI(AMER, Continent.NorthAmerica, "Costa Rica"),
    CUB(AMER, Continent.NorthAmerica, "Cuba"),
    CUW(AMER, Continent.NorthAmerica, "Curacao"),
    CXR(APAC, Continent.Asia, "Christmas Island"),
    CYM(AMER, Continent.NorthAmerica, "Cayman Islands"),
    CYP(EMEA, Continent.Asia, "Cyprus"),
    CZE(EMEA, Continent.Europe, "Czech Republic"),
    DEU(EMEA, Continent.Europe, "Germany"),
    DJI(EMEA, Continent.Africa, "Djibouti"),
    DMA(AMER, Continent.NorthAmerica, "Dominica"),
    DNK(EMEA, Continent.Europe, "Denmark"),
    DOM(AMER, Continent.NorthAmerica, "Dominican Republic"),
    DZA(EMEA, Continent.Africa, "Algeria"),
    ECU(AMER, Continent.SouthAmerica, "Ecuador"),
    EGY(EMEA, Continent.Africa, "Egypt"),
    ENG(EMEA, Continent.Europe, "England"),
    ERI(EMEA, Continent.Africa, "Eritrea"),
    ESH(EMEA, Continent.Africa, "Western Sahara"),
    ESP(EMEA, Continent.Europe, "Spain"),
    EST(EMEA, Continent.Europe, "Estonia"),
    ETH(EMEA, Continent.Africa, "Ethiopia"),
    FIN(EMEA, Continent.Europe, "Finland"),
    FJI(APAC, Continent.Oceania, "Fiji"),
    FLK(AMER, Continent.SouthAmerica, "Falkland Islands"),
    FRA(EMEA, Continent.Europe, "France"),
    FRO(EMEA, Continent.Europe, "Faroe Islands"),
    FSM(APAC, Continent.Oceania, "Micronesia"),
    GAB(EMEA, Continent.Africa, "Gabon"),
    GBR(EMEA, Continent.Europe, "United Kingdom"),
    GEO(EMEA, Continent.Asia, "Georgia"),
    GGY(EMEA, Continent.Europe, "Guernsey"),
    GHA(EMEA, Continent.Africa, "Ghana"),
    GIB(EMEA, Continent.Europe, "Gibraltar"),
    GIN(EMEA, Continent.Africa, "Guinea"),
    GLP(AMER, Continent.NorthAmerica, "Guadeloupe"),
    GMB(EMEA, Continent.Africa, "Gambia"),
    GNB(EMEA, Continent.Africa, "Guinea-Bissau"),
    GNQ(EMEA, Continent.Africa, "Equatorial Guinea"),
    GRC(EMEA, Continent.Europe, "Greece"),
    GRD(AMER, Continent.NorthAmerica, "Grenada"),
    GRL(AMER, Continent.NorthAmerica, "Greenland"),
    GTM(AMER, Continent.NorthAmerica, "Guatemala"),
    GUF(AMER, Continent.SouthAmerica, "French Guiana"),
    GUM(APAC, Continent.Oceania, "Guam"),
    GUY(AMER, Continent.SouthAmerica, "Guyana"),
    HKG(APAC, Continent.Asia, "Hong Kong"),
    HND(AMER, Continent.NorthAmerica, "Honduras"),
    HRV(EMEA, Continent.Europe, "Croatia"),
    HTI(AMER, Continent.NorthAmerica, "Haiti"),
    HUN(EMEA, Continent.Europe, "Hungary"),
    IDN(APAC, Continent.Asia, "Indonesia"),
    IMN(EMEA, Continent.Europe, "Isle of Man"),
    IND(APAC, Continent.Asia, "India"),
    IRL(EMEA, Continent.Europe, "Ireland"),
    IRN(EMEA, Continent.Asia, "Iran"),
    IRQ(EMEA, Continent.Asia, "Iraq"),
    ISL(EMEA, Continent.Europe, "Iceland"),
    ISR(EMEA, Continent.Asia, "Israel"),
    ITA(EMEA, Continent.Europe, "Italy"),
    JAM(AMER, Continent.NorthAmerica, "Jamaica"),
    JEY(EMEA, Continent.Europe, "Jersey"),
    JOR(EMEA, Continent.Asia, "Jordan"),
    JPN(APAC, Continent.Asia, "Japan"),
    KAZ(APAC, Continent.Asia, "Kazakhstan"),
    KEN(EMEA, Continent.Africa, "Kenya"),
    KGZ(APAC, Continent.Asia, "Kyrgyzstan"),
    KHM(APAC, Continent.Asia, "Cambodia"),
    KIR(APAC, Continent.Oceania, "Kiribati"),
    KOR(APAC, Continent.Asia, "South Korea"),
    KWT(EMEA, Continent.Asia, "Kuwait"),
    LAO(APAC, Continent.Asia, "Laos"),
    LBN(EMEA, Continent.Asia, "Lebanon"),
    LBR(EMEA, Continent.Africa, "Liberia"),
    LBY(EMEA, Continent.Africa, "Libyan"),
    LCA(AMER, Continent.NorthAmerica, "Saint Lucia"),
    LIE(EMEA, Continent.Europe, "Liechtenstein"),
    LKA(APAC, Continent.Asia, "Sri Lanka"),
    LSO(EMEA, Continent.Africa, "Lesotho"),
    LTU(EMEA, Continent.Europe, "Lithuania"),
    LUX(EMEA, Continent.Europe, "Luxembourg"),
    LVA(EMEA, Continent.Europe, "Latvia"),
    MAC(APAC, Continent.Asia, "Macao"),
    MAF(AMER, Continent.NorthAmerica, "Saint Martin"),
    MAR(EMEA, Continent.Africa, "Morocco"),
    MCO(EMEA, Continent.Europe, "Monaco"),
    MDA(EMEA, Continent.Europe, "Moldova"),
    MDG(EMEA, Continent.Africa, "Madagascar"),
    MDV(APAC, Continent.Asia, "Maldives"),
    MEX(AMER, Continent.NorthAmerica, "Mexico"),
    MHL(APAC, Continent.Oceania, "Marshall Islands"),
    MKD(EMEA, Continent.Europe, "Macedonia"),
    MLI(EMEA, Continent.Africa, "Mali"),
    MLT(EMEA, Continent.Europe, "Malta"),
    MMR(APAC, Continent.Asia, "Myanmar"),
    MNE(EMEA, Continent.Europe, "Montenegro"),
    MNG(APAC, Continent.Asia, "Mongolia"),
    MOZ(EMEA, Continent.Africa, "Mozambique"),
    MRT(EMEA, Continent.Africa, "Mauritania"),
    MSR(AMER, Continent.NorthAmerica, "Montserrat"),
    MTQ(AMER, Continent.NorthAmerica, "Martinique"),
    MUS(EMEA, Continent.Africa, "Mauritius"),
    MWI(EMEA, Continent.Africa, "Malawi"),
    MYS(APAC, Continent.Asia, "Malaysia"),
    MYT(EMEA, Continent.Africa, "Mayotte"),
    NAM(EMEA, Continent.Africa, "Namibia"),
    NCL(APAC, Continent.Oceania, "New Caledonia"),
    NER(EMEA, Continent.Africa, "Niger"),
    NFK(APAC, Continent.Oceania, "Norfolk Island"),
    NGA(EMEA, Continent.Africa, "Nigeria"),
    NIC(AMER, Continent.NorthAmerica, "Nicaragua"),
    NIR(EMEA, Continent.Europe, "Northern Ireland"),
    NIU(APAC, Continent.Oceania, "Niue"),
    NLD(EMEA, Continent.Europe, "Netherlands"),
    NOR(EMEA, Continent.Europe, "Norway"),
    NPL(APAC, Continent.Asia, "Nepal"),
    NRU(APAC, Continent.Oceania, "Nauru"),
    NZL(APAC, Continent.Oceania, "New Zealand"),
    OMN(EMEA, Continent.Asia, "Oman"),
    PAK(APAC, Continent.Asia, "Pakistan"),
    PAN(AMER, Continent.NorthAmerica, "Panama"),
    PCN(APAC, Continent.Oceania, "Pitcairn"),
    PER(AMER, Continent.SouthAmerica, "Peru"),
    PHL(APAC, Continent.Asia, "Philippines"),
    PLW(APAC, Continent.Oceania, "Palau"),
    PNG(APAC, Continent.Oceania, "Papua New Guinea"),
    POL(EMEA, Continent.Europe, "Poland"),
    PRI(AMER, Continent.NorthAmerica, "Puerto Rico"),
    PRK(APAC, Continent.Asia, "North Korea"),
    PRT(EMEA, Continent.Europe, "Portugal"),
    PRY(AMER, Continent.SouthAmerica, "Paraguay"),
    PSE(EMEA, Continent.Asia, "Palestinian Territory"),
    PYF(APAC, Continent.Oceania, "French Polynesia"),
    QAT(EMEA, Continent.Asia, "Qatar"),
    REU(EMEA, Continent.Africa, "Reunion"),
    ROU(EMEA, Continent.Europe, "Romania"),
    RUS(EMEA, Continent.Asia, "Russia"),
    RWA(EMEA, Continent.Africa, "Rwanda"),
    SAU(EMEA, Continent.Asia, "Saudi Arabia"),
    SCO(EMEA, Continent.Europe, "Scotland"),
    SDN(EMEA, Continent.Africa, "Sudan"),
    SEN(EMEA, Continent.Africa, "Senegal"),
    SGP(APAC, Continent.Asia, "Singapore"),
    SGS(GLOB, Continent.Antarctica, "South Georgia"),
    SHN(EMEA, Continent.Africa, "Saint Helena"),
    SJM(EMEA, Continent.Europe, "Svalbard and Jan Mayen"),
    SLB(APAC, Continent.Oceania, "Solomon Islands"),
    SLE(EMEA, Continent.Africa, "Sierra Leone"),
    SLV(AMER, Continent.NorthAmerica, "El Salvador"),
    SMR(EMEA, Continent.Europe, "San Marino"),
    SOM(EMEA, Continent.Africa, "Somalia"),
    SPM(AMER, Continent.NorthAmerica, "Saint Pierre and Miquelon"),
    SRB(EMEA, Continent.Europe, "Serbia"),
    STP(EMEA, Continent.Africa, "Sao Tome and Principe"),
    SUR(AMER, Continent.SouthAmerica, "Suriname"),
    SVK(EMEA, Continent.Europe, "Slovakia"),
    SVN(EMEA, Continent.Europe, "Slovenia"),
    SWE(EMEA, Continent.Europe, "Sweden"),
    SWZ(EMEA, Continent.Africa, "Swaziland"),
    SXM(AMER, Continent.NorthAmerica, "Sint Maarten"),
    SYC(EMEA, Continent.Africa, "Seychelles"),
    SYR(EMEA, Continent.Asia, "Syria"),
    TCA(AMER, Continent.NorthAmerica, "Turks and Caicos Islands"),
    TCD(EMEA, Continent.Africa, "Chad"),
    TGO(EMEA, Continent.Africa, "Togo"),
    THA(APAC, Continent.Asia, "Thailand"),
    TJK(APAC, Continent.Asia, "Tajikistan"),
    TKL(APAC, Continent.Oceania, "Tokelau"),
    TKM(APAC, Continent.Asia, "Turkmenistan"),
    TLS(APAC, Continent.Asia, "Timor-Leste"),
    TON(APAC, Continent.Oceania, "Tonga"),
    TTO(AMER, Continent.NorthAmerica, "Trinidad and Tobago"),
    TUN(EMEA, Continent.Africa, "Tunisia"),
    TUR(EMEA, Continent.Asia, "Turkey"),
    TUV(APAC, Continent.Oceania, "Tuvalu"),
    TWN(APAC, Continent.Asia, "Taiwan"),
    TZA(EMEA, Continent.Africa, "Tanzania"),
    UGA(EMEA, Continent.Africa, "Uganda"),
    UKR(EMEA, Continent.Europe, "Ukraine"),
    URY(AMER, Continent.SouthAmerica, "Uruguay"),
    USA(AMER, Continent.NorthAmerica, "United States"),
    UZB(APAC, Continent.Asia, "Uzbekistan"),
    VAT(EMEA, Continent.Europe, "Vatican City"),
    VCT(AMER, Continent.NorthAmerica, "Saint Vincent"),
    VEN(AMER, Continent.SouthAmerica, "Venezuela"),
    VGB(AMER, Continent.NorthAmerica, "British Virgin Islands"),
    VIR(AMER, Continent.NorthAmerica, "US Virgin Islands"),
    VNM(APAC, Continent.Asia, "Vietnam"),
    VUT(APAC, Continent.Oceania, "Vanuatu"),
    WLF(APAC, Continent.Oceania, "Wallis and Futuna"),
    WLS(EMEA, Continent.Europe, "Wales"),
    WSM(APAC, Continent.Oceania, "Samoa"),
    YEM(EMEA, Continent.Asia, "Yemen"),
    ZAF(EMEA, Continent.Africa, "South Africa"),
    ZMB(EMEA, Continent.Africa, "Zambia"),
    ZWE(EMEA, Continent.Africa, "Zimbabwe");

    private final Region region;
    private final Continent continent;
    private final String name;

    Country(Region region, Continent continent, String name) {
        this.region = region;
        this.continent = continent;
        this.name = name;
    }

    /**
     * Gets the geographical region of the country.
     *
     * @return the {@link Region} enum.
     */
    public Region getRegion() {
        return region;
    }

    /**
     * Gets the geographical continent of the country.
     *
     * @return the {@link Continent} enum.
     */
    public Continent getContinent() {
        return continent;
    }

    /**
     * Gets the name of the country.
     *
     * @return the country name.
     */
    public String getName() {
        return name;
    }
}