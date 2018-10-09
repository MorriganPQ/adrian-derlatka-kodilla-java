package com.kodilla.good.patterns.challenges.order.service;

public class OrderProcessor {
    private InformationService informationService;
    private OrderService orderService;
    private OrderRepository orderRepository;

    public OrderProcessor(final InformationService informationService, final OrderService orderService, final OrderRepository orderRepository) {
        this.informationService = informationService;
        this.orderService = orderService;
        this.orderRepository = orderRepository;
    }

    public Order process(final OrderRequest orderRequest) {
        Order order = orderService.order(orderRequest);
        if(order.isShipped()) {
            orderRepository.createOrder(order);
            informationService.inform(order.getUser());
        }
        return order;
    }
}
