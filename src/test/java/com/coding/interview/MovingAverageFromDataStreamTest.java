package com.coding.interview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MovingAverageFromDataStreamTest {

    private static final MovingAverageFromDataStream averageFromWindow = new MovingAverageFromDataStream();

    private static final int[] values = new int[] {1, 10, 3, 5};
    private static final int windowSize = 3;

    @Test
    public void test() {
        Assertions.assertEquals(6.0, averageFromWindow.average(windowSize, values));
    }
}
