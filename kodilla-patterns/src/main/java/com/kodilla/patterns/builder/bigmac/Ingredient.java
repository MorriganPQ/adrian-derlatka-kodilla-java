package com.kodilla.patterns.builder.bigmac;

public final class Ingredient {
    public static final String LETTUCE = "LETTUCE";
    public static final String ONION = "ONION";
    public static final String BACON = "BACON";
    public static final String CUCUMBER = "CUCUMBER";
    public static final String CHILI = "CHILI";
    public static final String MUSHROOMS = "MUSHROOMS";
    public static final String SHRIMPS = "SHRIMPS";
    public static final String CHEESE = "CHEESE";

    private final String type;

    public Ingredient(String type) {
        switch (type) {
            case LETTUCE:
            case ONION:
            case BACON:
            case CUCUMBER:
            case CHILI:
            case MUSHROOMS:
            case SHRIMPS:
            case CHEESE:
                this.type = type;
                break;
            default:
                throw new IllegalStateException("Ingredients has to be LETTUCE, ONION, BACON, CUCUMBER, CHILI, MUSHROOMS, SHRIMPS or CHEESE!");
        }
    }

    public String getType() {
        return type;
    }
}
