package com.kodilla.good.patterns.challenges.order.service;

import java.time.LocalDateTime;

public class Order {
    private int id;
    private LocalDateTime orderTime;
    private User user;
    private Product product;
    private double amount;
    private boolean isPaid;
    private boolean isShipped;

    public Order(final int id, final LocalDateTime orderTime, final User user, final Product product, final double amount) {
        this.id = id;
        this.orderTime = orderTime;
        this.user = user;
        this.product = product;
        this.amount = amount;
        this.isPaid = false;
        this.isShipped = false;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
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

    public boolean isPaid() {
        return isPaid;
    }

    public boolean isShipped() {
        return isShipped;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public void setShipped(boolean shipped) {
        isShipped = shipped;
    }
}
