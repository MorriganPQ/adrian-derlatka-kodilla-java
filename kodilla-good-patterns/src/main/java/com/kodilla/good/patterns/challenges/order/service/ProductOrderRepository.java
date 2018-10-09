package com.kodilla.good.patterns.challenges.order.service;

import java.util.ArrayList;
import java.util.List;

public class ProductOrderRepository implements OrderRepository {
    List<Order> orders = new ArrayList<>();

    @Override
    public boolean createOrder(Order order) {
        return orders.add(order);
    }
}
