package com.kodilla.stream.world;

import org.junit.Assert;
import org.junit.Test;
import java.math.BigDecimal;

public class WorldTestSuite {
    @Test
    public void testGetPeopleQuantity() {
        //Given
        Continent europe = new Continent();
        europe.addCountry(new Country(new BigDecimal("80996685")));
        europe.addCountry(new Country(new BigDecimal("66259012")));
        europe.addCountry(new Country(new BigDecimal("63742977")));
        europe.addCountry(new Country(new BigDecimal("61680122")));

        Continent asia = new Continent();
        asia.addCountry(new Country(new BigDecimal("1330044605")));
        asia.addCountry(new Country(new BigDecimal("1147996000")));
        asia.addCountry(new Country(new BigDecimal("237512000")));
        asia.addCountry(new Country(new BigDecimal("176242949")));

        Continent africa = new Continent();
        africa.addCountry(new Country(new BigDecimal("190632261")));
        africa.addCountry(new Country(new BigDecimal("105350020")));
        africa.addCountry(new Country(new BigDecimal("97041072")));
        africa.addCountry(new Country(new BigDecimal("83301151")));

        World world = new World();
        world.addContinent(europe);
        world.addContinent(asia);
        world.addContinent(africa);

        //When
        BigDecimal totalPeople = world.getPeopleQuantity();

        //Then
        BigDecimal expectedPeople = new BigDecimal("3640798854");
        Assert.assertEquals(expectedPeople, totalPeople);
    }
}
