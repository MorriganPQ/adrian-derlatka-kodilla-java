package com.kodilla.patterns.builder.bigmac;

import org.junit.Assert;
import org.junit.Test;

public class BigmacTestSuite {
    @Test
    public void testBigmacBuilder() {
        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .bun(Bun.WITH_SESAME)
                .burgers(2)
                .sauce(Sauce.THOUSAND_ISLANDS)
                .ingredient(Ingredient.CHEESE)
                .ingredient(Ingredient.LETTUCE)
                .ingredient(Ingredient.MUSHROOMS)
                .ingredient(Ingredient.ONION)
                .build();

        //When
        //Then
        Assert.assertEquals(Bun.WITH_SESAME, bigmac.getBun().getType());
        Assert.assertEquals(2, bigmac.getBurgers());
        Assert.assertEquals(Sauce.THOUSAND_ISLANDS, bigmac.getSauce().getType());
        Assert.assertEquals(4, bigmac.getIngredients().size());
    }
}
