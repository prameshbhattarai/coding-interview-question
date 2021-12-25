package com.coding.interview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MatrixSearchTest {
    private static final MatrixSearch matrixSearch = new MatrixSearch();
    private final int[][] arr1 = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12}
    };

    @Test
    void testBruteForce() {
        boolean found;
        for (int i = 1; i <= 12; i++) {
            found = matrixSearch.bruteForceApproach(arr1, i);
            Assertions.assertTrue(found);
        }

        found = matrixSearch.bruteForceApproach(arr1, 0);
        Assertions.assertFalse(found);

        found = matrixSearch.bruteForceApproach(arr1, 13);
        Assertions.assertFalse(found);
    }

    @Test
    void testOptimizedApproach() {
        boolean found;
        for (int i = 1; i <= 12; i++) {
            found = matrixSearch.optimizedApproach(arr1, i);
            Assertions.assertTrue(found);
        }

        found = matrixSearch.optimizedApproach(arr1, 0);
        Assertions.assertFalse(found);

        found = matrixSearch.optimizedApproach(arr1, 13);
        Assertions.assertFalse(found);
    }
}
