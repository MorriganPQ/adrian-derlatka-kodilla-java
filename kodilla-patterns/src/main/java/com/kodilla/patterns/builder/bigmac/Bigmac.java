package com.kodilla.patterns.builder.bigmac;

import java.util.ArrayList;
import java.util.List;

public final class Bigmac {
    private final Bun bun;
    private final int burgers;
    private final Sauce sauce;
    private final List<Ingredient> ingredients;

    private Bigmac(final Bun bun, final int burgers, final Sauce sauce, final List<Ingredient> ingredients) {
        this.bun = bun;
        this.burgers = burgers;
        this.sauce = sauce;
        this.ingredients = new ArrayList<>(ingredients);
    }

    public Bun getBun() {
        return bun;
    }

    public int getBurgers() {
        return burgers;
    }

    public Sauce getSauce() {
        return sauce;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public static class BigmacBuilder {
        private Bun bun = null;
        private int burgers = -1;
        private Sauce sauce = null;
        private List<Ingredient> ingredients = new ArrayList<>();

        public BigmacBuilder bun(String bunType) {
            this.bun = new Bun(bunType);
            return this;
        }

        public BigmacBuilder burgers(int burgers) {
            this.burgers = burgers;
            return this;
        }

        public BigmacBuilder sauce(String sauceType) {
            this.sauce = new Sauce(sauceType);
            return this;
        }

        public BigmacBuilder ingredient(String ingredientType) {
            ingredients.add(new Ingredient(ingredientType));
            return this;
        }

        public Bigmac build() {
            if (bun == null) {
                throw new IllegalStateException("Bun has to be specified!");
            }
            if (!(burgers >= 0 && burgers <= 3)) {
                throw new IllegalStateException("Number of burgers has to be in range from 0 to 3!");
            }
            if (sauce == null) {
                throw new IllegalStateException("Sauce has to be specified!");
            }
            return new Bigmac(bun, burgers, sauce, ingredients);
        }
    }
}
