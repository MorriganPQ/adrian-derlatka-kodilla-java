package com.kodilla.good.patterns.food2door;

public class Application {
    public static void main(String[] args) {
        Offer extraFoodShopOffer = new ProductOffer("Bread", 20, "loaves");
        Offer glutenFreeShopOffer = new ProductOffer("Butter", 10, "cubes");
        Offer healthyShopOffer = new ProductOffer("Tomatoes", 2.5, "kgs");

        Producer extraFoodShop = new ExtraFoodShop(extraFoodShopOffer);
        Producer glutenFreeShop = new GlutenFreeShop(glutenFreeShopOffer);
        Producer healthyShop = new HealthyShop(healthyShopOffer);

        extraFoodShop.about();
        ((ExtraFoodShop) extraFoodShop).getOffer().about();
        extraFoodShop.process(20);
        extraFoodShop.isOrderCompleted();

        System.out.println();
        glutenFreeShop.about();
        ((GlutenFreeShop) glutenFreeShop).getOffer().about();
        glutenFreeShop.process(20);
        glutenFreeShop.isOrderCompleted();

        System.out.println();
        healthyShop.about();
        ((HealthyShop) healthyShop).getOffer().about();
        healthyShop.process(2.5);
        healthyShop.isOrderCompleted();
    }
}
