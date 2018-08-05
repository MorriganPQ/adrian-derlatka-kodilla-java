package com.kodilla.testing.shape;

import org.junit.*;

public class ShapeCollectorTestSuite {
    public static int testCounter = 0;

    @Before
    public void beforeEveryTest() {
        System.out.println("Executing test #" + ++testCounter);
    }

    @Test
    public void testAddFigure() {
        //Given
        ShapeCollector shapes = new ShapeCollector();
        Shape shape1 = new Square(5);
        Shape shape2 = new Circle(3);
        Shape shape3 = new Triangle(4, 6);
        //When
        shapes.addFigure(shape1);
        shapes.addFigure(shape2);
        shapes.addFigure(shape3);
        //Then
        Assert.assertEquals(shape1, shapes.getFigure(0));
        Assert.assertEquals(shape2, shapes.getFigure(1));
        Assert.assertEquals(shape3, shapes.getFigure(2));
    }

    @Test
    public void testGetFigure() {
        //Given
        ShapeCollector shapes = new ShapeCollector();
        Shape shape = new Square(5);
        shapes.addFigure(shape);
        //When
        Shape retrievedShape = shapes.getFigure(0);
        //Then
        Assert.assertEquals(shape, retrievedShape);
    }

    @Test
    public void testRemoveFigureNotExisting() {
        //Given
        ShapeCollector shapes = new ShapeCollector();
        Shape shape = new Square(5);
        //When
        boolean result = shapes.removeFigure(shape);
        //Then
        Assert.assertFalse(result);
    }

    @Test
    public void testRemoveFigure() {
        //Given
        ShapeCollector shapes = new ShapeCollector();
        Shape shape = new Square(5);
        shapes.addFigure(shape);
        //When
        boolean result = shapes.removeFigure(shape);
        //Then
        Assert.assertTrue(result);
        Assert.assertNull(shapes.getFigure(0));
    }
}
