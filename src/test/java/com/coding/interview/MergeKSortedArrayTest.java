package com.coding.interview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class MergeKSortedArrayTest {

    private static final MergeKSortedArray.BruteForce1 bruteForceApproach1 = new MergeKSortedArray.BruteForce1();
    private static final MergeKSortedArray.BruteForce2 bruteForceApproach2 = new MergeKSortedArray.BruteForce2();
    private static final MergeKSortedArray.PriorityQueueApproach priorityQueueApproach =
            new MergeKSortedArray.PriorityQueueApproach();


    private final int[][] arr1 = new int[][]{{1, 4, 7}, {2, 5, 8}, {3, 6, 9}};
    private final int[] expected1 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

    private final int[][] arr2 = new int[][]{{1, 3, 5, 7},{2, 4, 6, 8},{0, 9, 10, 11}};
    private final int[] expected2 = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};

    @Test
    public void testBruteForceApproach1() {
        int[] arr = bruteForceApproach1.sortArray(arr1);
        Assertions.assertTrue(Arrays.equals(expected1, arr));

        arr = bruteForceApproach1.sortArray(arr2);
        Assertions.assertTrue(Arrays.equals(expected2, arr));
    }

    @Test
    public void testBruteForceApproach2() {
        int[] arr = bruteForceApproach2.sortArray(arr1);
        Assertions.assertTrue(Arrays.equals(expected1, arr));

        arr = bruteForceApproach2.sortArray(arr2);
        Assertions.assertTrue(Arrays.equals(expected2, arr));
    }

    @Test
    public void testPriorityQueueApproach() {
        int[] arr = priorityQueueApproach.sortArray(arr1);
        Assertions.assertTrue(Arrays.equals(expected1, arr));

        arr = priorityQueueApproach.sortArray(arr2);
        Assertions.assertTrue(Arrays.equals(expected2, arr));
    }
}
