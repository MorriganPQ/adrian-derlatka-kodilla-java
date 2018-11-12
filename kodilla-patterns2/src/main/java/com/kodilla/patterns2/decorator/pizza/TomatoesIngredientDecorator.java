package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class TomatoesIngredientDecorator extends AbstractPizzaOrderDecorator {
    public TomatoesIngredientDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getPrice() {
        return super.getPrice().add(new BigDecimal(4));
    }

    @Override
    public String getIngredients() {
        return super.getIngredients() + ", tomatoes";
    }
}
