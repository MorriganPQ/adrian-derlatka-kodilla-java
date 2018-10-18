package com.kodilla.patterns.builder.bigmac;

public final class Sauce {
    public static final String STANDARD = "STANDARD";
    public static final String THOUSAND_ISLANDS = "THOUSAND ISLANDS";
    public static final String BARBECUE = "BARBECUE";

    private final String type;

    public Sauce(String type) {
        if (type.equals(STANDARD) || type.equals(THOUSAND_ISLANDS) || type.equals(BARBECUE)) {
            this.type = type;
        } else {
            throw new IllegalStateException("Sauce has to be STANDARD, THOUSAND ISLANDS or BARBECUE");
        }
    }

    public String getType() {
        return type;
    }
}
