package com.kodilla.spring.calculator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorTestSuite {
    @Test
    public void testCalculations() {
        // Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = context.getBean(Calculator.class);
        // When
        double add = calculator.add(5, 2.5);
        double sub = calculator.sub(5, 2.5);
        double mul = calculator.mul(5, 2.5);
        double div = calculator.div(5, 2.5);
        // Then
        Assert.assertEquals(7.5, add, 0);
        Assert.assertEquals(2.5, sub, 0);
        Assert.assertEquals(12.5, mul, 0);
        Assert.assertEquals(2.0, div, 0);
    }
}
