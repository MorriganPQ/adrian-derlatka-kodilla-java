package com.kodilla.patterns.builder.bigmac;

public final class Bun {
    public static final String WITH_SESAME = "WITH SESAME";
    public static final String WITHOUT_SESAME = "WITHOUT SESAME";

    private final String type;

    public Bun(String type) {
        if (type.equals(WITH_SESAME) || type.equals(WITHOUT_SESAME)) {
            this.type = type;
        } else {
            throw new IllegalStateException("Bun has to be WITH SESAME or WITHOUT SESAME!");
        }
    }

    public String getType() {
        return type;
    }
}
