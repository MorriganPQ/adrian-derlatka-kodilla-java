package com.kodilla.good.patterns.food2door;

public class ProductOffer implements Offer {
    private String productName;
    private double amount;
    private String unit;

    public ProductOffer(final String productName, final double amount, final String unit) {
        this.productName = productName;
        this.amount = amount;
        this.unit = unit;
    }

    public String getProductName() {
        return productName;
    }

    public double getAmount() {
        return amount;
    }

    public String getUnit() {
        return unit;
    }

    @Override
    public void about() {
        System.out.println("Offer: " + amount + " " + unit + " of " + productName);
    }
}
