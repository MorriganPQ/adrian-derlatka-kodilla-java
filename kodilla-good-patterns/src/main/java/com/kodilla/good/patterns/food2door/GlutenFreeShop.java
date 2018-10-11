package com.kodilla.good.patterns.food2door;

public class GlutenFreeShop implements Producer {
    private String name ="GlutenFreeShop";
    private String address = "Otwock...";
    private Offer offer;

    public GlutenFreeShop(final Offer offer) {
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
        System.out.println("Connecting to external system...");
        System.out.println("Welcome to " + name + "order system!");
        return offer.order(amount);
    }
}
