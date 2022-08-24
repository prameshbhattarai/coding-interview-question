package com.coding.interview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class HighFiveTest {

    private static final int[][] items = new int[][]{{1, 91}, {1, 92}, {2, 93}, {2, 97}, {1, 60}, {2, 77}, {1, 65}, {1, 87}, {1, 100}, {2, 100}, {2, 76}};
    private static final int[][] expectedResult = new int[][] {
            {1, 87},
            {2, 88}
    };
    private final HighFive highFive = new HighFive();

    @Test
    public void testAverageOfHighFiveSubject() {
        System.out.println(Arrays.deepToString(highFive.highFive(items)));
        Assertions.assertTrue(Arrays.deepEquals(expectedResult, highFive.highFive(items)));
    }
}
