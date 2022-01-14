package com.coding.interview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class BuildOrderTest {

    private static final BuildOrder buildOrder = new BuildOrder();

    private static final int[][] arr1 = new int[][] {
            {},
            {0},
            {0},
            {1, 2},
            {3}
    };
    private static final int[] expected1 = new int[] {0, 1, 2, 3, 4};

    private static final int[][] arr2 = new int[][] {
            {},
            {},
            {3},
            {1},
            {0, 1},
            {0, 2}
    };
    private static final int[] expected2 = new int[] {0, 1, 2, 3, 4, 5};

    @Test
    public void testTopologySorting() {
        int[] actual = buildOrder.topologySort(arr1);
        Assertions.assertArrayEquals(expected1, actual);

        actual = buildOrder.topologySort(arr2);
        Assertions.assertArrayEquals(expected2, actual);
    }
}
