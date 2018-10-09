package com.kodilla.good.patterns.challenges.order.service;

public class Game implements Product {
    private final String name = "Game";
    private double price;

    public Game(final double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
