package com.kodilla.patterns.singleton;

import org.junit.Assert;
import org.junit.Test;

public class LoggerTestSuite {
    @Test
    public void testGetLastLog() {
        //Given
        //When
        Logger.getInstance().log("Test log");
        //Then
        Assert.assertEquals("Test log", Logger.getInstance().getLastLog());
    }
}
