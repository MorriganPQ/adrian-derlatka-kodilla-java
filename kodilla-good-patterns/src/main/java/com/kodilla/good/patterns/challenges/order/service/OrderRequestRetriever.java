package com.kodilla.good.patterns.challenges.order.service;

public class OrderRequestRetriever {
    public OrderRequest retrieve() {
        User user = new User("Kimberly", "Hudson", "1631 Desert Broom Court Jersey City, NJ 07306", "KimberlyNHudson@rhyta.com", "201-714-0085");
        Product game = new Game(3.14);

        return new OrderRequest(user, game, 3);
    }

    public OrderRequest retrieve2() {
        User user = new User("Kimberly", "Hudson", "1631 Desert Broom Court Jersey City, NJ 07306", "KimberlyNHudson@rhyta.com", "201-714-0085");
        Product toothbrush = new Toothbrush(9.99);

        return new OrderRequest(user, toothbrush, 3);
    }
}
