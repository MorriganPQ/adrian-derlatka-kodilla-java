package com.kodilla.stream.array;

import org.junit.Assert;
import org.junit.Test;

public class ArrayOperationsTestSuite {
    @Test
    public void testGetAverage() {
        //Given
        int[] numbers = {12, 5, 20, 9, 3, 57, 1, 7, 109, 67, 17, 9, 60, 33, 123, 87, 609, 44, 2, 99};

        //When
        double average = ArrayOperations.getAverage(numbers);

        //Then
        Assert.assertEquals(68.65, average, 0);
    }
}
