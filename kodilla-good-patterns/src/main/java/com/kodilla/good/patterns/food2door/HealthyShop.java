package com.kodilla.good.patterns.food2door;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HealthyShop implements Producer {
    private String name ="HealthyShop";
    private String address = "Pruszków...";
    private Offer offer;

    public HealthyShop(final Offer offer) {
        this.offer = offer;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Offer getOffer() {
        return offer;
    }

    @Override
    public void about() {
        System.out.println(name + " (" + address + ")");
    }

    @Override
    public boolean process(double amount) {
        System.out.println("For how long (in days) do you want to place your order? [range 0-365, 0 to cancel]");
        while (true) {
            int days;
            try {
                days = new Scanner(System.in).nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Input has to be an integer number! Try again:");
                continue;
            }
            if (days == 0) {
                System.out.println("See you next time!");
                return false;
            } else if (days > 0 && days <= 365) {
                return offer.order(amount);
            } else {
                System.out.println("Out of range [0-365]! Try again:");
            }
        }
    }
}
