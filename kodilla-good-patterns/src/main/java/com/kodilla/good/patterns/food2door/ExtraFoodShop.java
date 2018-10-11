package com.kodilla.good.patterns.food2door;

public class ExtraFoodShop implements Producer {
    private String name ="ExtraFoodShop";
    private String address = "Warsaw...";
    private Offer offer;

    public ExtraFoodShop(final Offer offer) {
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
        return offer.order(amount);
    }
}
