package com.kodilla.good.patterns.challenges.order.service;

public class OrderRequest {
    private User user;
    private Product product;
    private double amount;

    public OrderRequest(final User user, final Product product, final double amount) {
        this.user = user;
        this.product = product;
        this.amount = amount;
    }

    public User getUser() {
        return user;
    }

    public Product getProduct() {
        return product;
    }

    public double getAmount() {
        return amount;
    }
}
