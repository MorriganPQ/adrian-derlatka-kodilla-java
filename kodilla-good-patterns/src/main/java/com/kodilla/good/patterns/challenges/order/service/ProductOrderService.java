package com.kodilla.good.patterns.challenges.order.service;

import java.time.LocalDateTime;

public class ProductOrderService implements OrderService {
    @Override
    public Order order(OrderRequest orderRequest) {
        Order order = new Order(OrdersExternalDataImitation.nextId++, LocalDateTime.now(), orderRequest.getUser(), orderRequest.getProduct(), orderRequest.getAmount());
        order.setPaid(OrdersExternalDataImitation.isPaid(order.getId()));

        System.out.println("Order #" + order.getId());
        if(order.isPaid()) {
            System.out.println("Order is preparing to shipment");
            order.setShipped(true);
            System.out.println("Order has been shipped");
        } else {
            System.out.println("Payment has mot been received");
        }

        return order;
    }
}
