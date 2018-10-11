package com.kodilla.good.patterns.food2door;

public interface Producer {
    void about();
    boolean process(double amount);

    default boolean isOrderCompleted() {
        boolean isOrderCompleted = RandomBoolean.randomBoolean();
        if (isOrderCompleted) {
            System.out.println("Your order has been completed!");
        } else {
            System.out.println("Your order has not been completed yet.");
        }
        return isOrderCompleted;
    }
}
