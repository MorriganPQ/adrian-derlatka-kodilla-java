package com.kodilla.testing.collection;

import org.junit.*;
import java.util.*;

public class CollectionTestSuite {
    @Before
    public void before() {
        System.out.println("Test Case: begin");
    }

    @After
    public void after() {
        System.out.println("Test Case: end");
    }

    @Test
    public void testOddNumbersExterminatorEmptyList() {
        //Given
        List<Integer> emptyList = new ArrayList<>();
        //When
        List<Integer> result = OddNumbersExterminator.exterminate(emptyList);
        System.out.println("Testing exterminating empty list");
        //Then
        Assert.assertEquals(emptyList, result);
    }

    @Test
    public void testOddNumbersExterminatorNormalList() {
        //Given
        List<Integer> normalList = new ArrayList<>();
        normalList.add(25);
        normalList.add(30);
        normalList.add(4321);
        normalList.add(2098);
        normalList.add(1);
        normalList.add(56);

        List<Integer> finalList = new ArrayList<>();
        finalList.add(30);
        finalList.add(2098);
        finalList.add(56);
        //When
        List<Integer> result = OddNumbersExterminator.exterminate(normalList);
        System.out.println("Testing exterminating normal list");
        //Then
        Assert.assertEquals(finalList, result);
    }
}
