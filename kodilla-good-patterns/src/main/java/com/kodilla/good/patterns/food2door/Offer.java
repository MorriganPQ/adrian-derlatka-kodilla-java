package com.kodilla.good.patterns.food2door;

import java.util.Random;

public interface Offer {
    void about();

    default boolean order(double amount) {
        double isAvailable = new Random().nextInt(100);
        if (amount <= isAvailable) {
            System.out.println("Your order is preparing... We let you know when it will be ready!");
            return true;
        } else {
            System.out.println("Something is wrong! Contact us for more information.");
            return false;
        }
    }
}
