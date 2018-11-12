package com.kodilla.patterns2.decorator.pizza;

import org.junit.Test;
import java.math.BigDecimal;
import static org.junit.Assert.*;

public class PizzaOrderTestSuite {
    @Test
    public void testGarlicMushroomsPineappleTomatoesPizzaGetPrice() {
        // Given
        PizzaOrder pizza = new BasicPizzaOrder();
        pizza = new GarlicIngredientDecorator(pizza);
        pizza = new MushroomsIngredientDecorator(pizza);
        pizza = new PineappleIngredientDecorator(pizza);
        pizza = new TomatoesIngredientDecorator(pizza);
        // When
        BigDecimal price = pizza.getPrice();
        // Then
        assertEquals(new BigDecimal(35), price);
    }

    @Test
    public void testGarlicMushroomsPineappleTomatoesPizzaGetIngredients() {
        // Given
        PizzaOrder pizza = new BasicPizzaOrder();
        pizza = new GarlicIngredientDecorator(pizza);
        pizza = new MushroomsIngredientDecorator(pizza);
        pizza = new PineappleIngredientDecorator(pizza);
        pizza = new TomatoesIngredientDecorator(pizza);
        // When
        String ingredients = pizza.getIngredients();
        // Then
        assertEquals("Ingredients: dough, tomato sauce, cheese, garlic, mushrooms, pineapple, tomatoes", ingredients);
    }

    @Test
    public void testChickenExtraCheeseMushroomsTomatoesPizzaGetPrice() {
        // Given
        PizzaOrder pizza = new BasicPizzaOrder();
        pizza = new ChickenIngredientDecorator(pizza);
        pizza = new ExtraCheeseDecorator(pizza);
        pizza = new MushroomsIngredientDecorator(pizza);
        pizza = new TomatoesIngredientDecorator(pizza);
        // When
        BigDecimal price = pizza.getPrice();
        // Then
        assertEquals(new BigDecimal(34), price);
    }

    @Test
    public void testChickenExtraCheeseMushroomsTomatoesPizzaGetIngredients() {
        // Given
        PizzaOrder pizza = new BasicPizzaOrder();
        pizza = new ChickenIngredientDecorator(pizza);
        pizza = new ExtraCheeseDecorator(pizza);
        pizza = new MushroomsIngredientDecorator(pizza);
        pizza = new TomatoesIngredientDecorator(pizza);
        // When
        String ingredients = pizza.getIngredients();
        // Then
        assertEquals("Ingredients: dough, tomato sauce, cheese, chicken, extra cheese, mushrooms, tomatoes", ingredients);
    }

    @Test
    public void testAllIngredientsWithTripleCheesePizzaGetPrice() {
        // Given
        PizzaOrder pizza = new BasicPizzaOrder();
        pizza = new ChickenIngredientDecorator(pizza);
        pizza = new ExtraCheeseDecorator(pizza);
        pizza = new GarlicIngredientDecorator(pizza);
        pizza = new MushroomsIngredientDecorator(pizza);
        pizza = new PineappleIngredientDecorator(pizza);
        pizza = new ShrimpsIngredientDecorator(pizza);
        pizza = new TomatoesIngredientDecorator(pizza);
        pizza = new ExtraCheeseDecorator(pizza);
        // When
        BigDecimal price = pizza.getPrice();
        // Then
        assertEquals(new BigDecimal(55), price);
    }

    @Test
    public void testAllIngredientsWithTripleCheesePizzaGetIngredients() {
        // Given
        PizzaOrder pizza = new BasicPizzaOrder();
        pizza = new ChickenIngredientDecorator(pizza);
        pizza = new ExtraCheeseDecorator(pizza);
        pizza = new GarlicIngredientDecorator(pizza);
        pizza = new MushroomsIngredientDecorator(pizza);
        pizza = new PineappleIngredientDecorator(pizza);
        pizza = new ShrimpsIngredientDecorator(pizza);
        pizza = new TomatoesIngredientDecorator(pizza);
        pizza = new ExtraCheeseDecorator(pizza);
        // When
        String ingredients = pizza.getIngredients();
        // Then
        assertEquals("Ingredients: dough, tomato sauce, cheese, chicken, extra cheese, garlic, mushrooms, pineapple, shrimps, tomatoes, extra cheese", ingredients);
    }
}
