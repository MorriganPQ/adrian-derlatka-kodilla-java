package com.kodilla.good.patterns.challenges.order.service;

import java.util.Random;

public class OrdersExternalDataImitation {
    public static int nextId = 1; // Imitate next id

    // Imitate paying for order
    public static boolean isPaid(int orderId) {
        switch(new Random().nextInt(2)) {
            case 0: return false;
            case 1: return true;
            default: return false;
        }
    }
}
