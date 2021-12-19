package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ConsecutiveArrayTest {

    private static final int[] arr1 = new int[]{4, 2, 1, 6, 5};
    private static final int[] arr2 = new int[]{5, 5, 3, 1};
    private static final ConsecutiveArray consecutiveArray = new ConsecutiveArray();

    @Test
    void testBruteForce() {
        int len = consecutiveArray.bruteForceApproach(arr1);
        Assertions.assertEquals(3, len);

        len = consecutiveArray.bruteForceApproach(arr2);
        Assertions.assertEquals(1, len);
    }

    @Test
    void testConsecutive() {
        int len = consecutiveArray.consecutive(arr1);
        Assertions.assertEquals(3, len);

        len = consecutiveArray.consecutive(arr2);
        Assertions.assertEquals(1, len);
    }
}
