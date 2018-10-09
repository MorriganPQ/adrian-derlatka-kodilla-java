package com.kodilla.good.patterns.challenges.order.service;

public class Application {
    public static void main(String[] args) {
        OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();
        OrderRequest orderRequest = orderRequestRetriever.retrieve();
        OrderRequest orderRequest2 = orderRequestRetriever.retrieve2();

        OrderProcessor orderProcessor = new OrderProcessor(new MailInformationService(), new ProductOrderService(), new ProductOrderRepository());
        orderProcessor.process(orderRequest);

        OrderProcessor orderProcessor2 = new OrderProcessor(new SmsInformationService(), new ProductOrderService(), new ProductOrderRepository());
        orderProcessor2.process(orderRequest2);
    }
}
