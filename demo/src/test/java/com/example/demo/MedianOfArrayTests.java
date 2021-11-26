package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MedianOfArrayTests {

    private static final int[] arr1 = new int[] {1, 3, 5};
    private static final int[] arr2 = new int[] {2, 4, 6};

    private static final int[] arr3 = new int[] {1, 3, 8, 9, 15};
    private static final int[] arr4 = new int[] {7, 11, 18, 19, 21, 25};

    private static final int[] arr5 = new int[] {23, 26, 31, 35};
    private static final int[] arr6 = new int[] {3, 5, 7, 9, 11, 16};

    private static final MedianOfArray medianOfArray = new MedianOfArray();


    @Test
    void testBruteForce() {
        double median = medianOfArray.bruteForceApproach(arr1, arr2);
        Assertions.assertEquals(3.5, median);

        median = medianOfArray.bruteForceApproach(arr3, arr4);
        Assertions.assertEquals(11.0, median);

        median = medianOfArray.bruteForceApproach(arr5, arr6);
        Assertions.assertEquals(13.5, median);
    }


    @Test
    void testBinarySearch() {
        double median = medianOfArray.binarySearchApproach(arr1, arr2);
        Assertions.assertEquals(3.5, median);

        median = medianOfArray.binarySearchApproach(arr3, arr4);
        Assertions.assertEquals(11.0, median);

        median = medianOfArray.binarySearchApproach(arr5, arr6);
        Assertions.assertEquals(13.5, median);
    }

}
