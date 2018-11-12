package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class PineappleIngredientDecorator extends AbstractPizzaOrderDecorator {
    public PineappleIngredientDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getPrice() {
        return super.getPrice().add(new BigDecimal(6));
    }

    @Override
    public String getIngredients() {
        return super.getIngredients() + ", pineapple";
    }
}
