package com.coding.interview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ZeroSumSubArrayTest {

    private static final int[] arr1 = new int[]{1, 2, -5, 1, 2};
    private static final int[] expected1 = new int[]{2, -5, 1, 2};

    private static final int[] arr2 = new int[]{4, 2, -3, 1, 6};
    private static final int[] expected2 = new int[]{2, -3, 1};
    private static final ZeroSumSubArray zeroSumSubArray = new ZeroSumSubArray();

    @Test
    void testBruteForceApproach() {
        int[] range = zeroSumSubArray.bruteForceApproach(arr1);
        Assertions.assertArrayEquals(expected1, range);

        range = zeroSumSubArray.bruteForceApproach(arr2);
        Assertions.assertArrayEquals(expected2, range);
    }


    @Test
    void testOptimizeApproach() {
        int[] range = zeroSumSubArray.optimizeApproach(arr1);
        Assertions.assertArrayEquals(expected1, range);

        range = zeroSumSubArray.optimizeApproach(arr2);
        Assertions.assertArrayEquals(expected2, range);
    }
}
