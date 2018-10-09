package com.kodilla.good.patterns.challenges.order.service;

public class Toothbrush implements Product {
    private final String name = "Toothbrush";
    private double price;

    public Toothbrush(final double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
