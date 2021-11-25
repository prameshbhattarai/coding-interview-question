package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MedianOfArrayTests {

    private static final int[] arr1 = new int[] {1, 3, 5};
    private static final int[] arr2 = new int[] {2, 4, 6};

    @Test
    void testBruteForce() {
        MedianOfArray medianOfArray = new MedianOfArray();
        double median = medianOfArray.bruteForceApproach(arr1, arr2);
        Assertions.assertEquals(median, 3.5);
    }

}
