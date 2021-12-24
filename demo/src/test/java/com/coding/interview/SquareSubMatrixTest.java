package com.coding.interview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SquareSubMatrixTest {

    private final int[][] arr1 = {
            {1, 1, 1, 0},
            {1, 1, 1, 1},
            {1, 1, 0, 0}
    };
    private final int[][] arr2 = {
            {1, 0, 1, 0, 0},
            {1, 0, 1, 1, 1},
            {1, 1, 1, 1, 1},
            {1, 0, 0, 1, 0}
    };

    private static final SquareSubMatrix matrix = new SquareSubMatrix();

    @Test
    public void findLargeSquare() {
        int maxSquare = matrix.findLargeSquare(arr1);
        Assertions.assertEquals(2, maxSquare);

        maxSquare = matrix.findLargeSquare(arr2);
        Assertions.assertEquals(2, maxSquare);
    }
}
