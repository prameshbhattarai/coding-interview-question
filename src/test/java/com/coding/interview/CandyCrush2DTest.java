package com.coding.interview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class CandyCrush2DTest {

    public static final CandyCrush2D crush2D = new CandyCrush2D();

    private static final int[][] board1 = new int[][]{
            {110, 5, 112, 113, 114},
            {210, 211, 5, 213, 214},
            {310, 311, 3, 313, 314},
            {410, 411, 412, 5, 414},
            {5, 1, 512, 3, 3},
            {610, 4, 1, 613, 614},
            {710, 1, 2, 713, 714},
            {810, 1, 2, 1, 1},
            {1, 1, 2, 2, 2},
            {4, 1, 4, 4, 1014}
    };
    private static final int[][] expected1 = new int[][]{
            {110, 0, 0, 0, 0},
            {210, 0, 0, 113, 114},
            {310, 0, 0, 213, 214},
            {410, 0, 112, 313, 314},
            {5, 5, 5, 5, 414},
            {610, 211, 3, 3, 3},
            {710, 311, 412, 613, 614},
            {810, 411, 512, 713, 714},
            {1, 1, 1, 1, 1},
            {4, 4, 4, 4, 1014}
    };

    private static final int[][] board2 = new int[][]{
            {1, 1, 1, 1},
            {2, 2, 2, 2},
            {3, 3, 3, 3},
            {4, 4, 4, 4}
    };
    private static final int[][] expected2 = new int[][]{
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0}
    };

    private static final int[][] board3 = new int[][]{
            {1, 2, 3, 4},
            {1, 2, 3, 4},
            {1, 2, 3, 4},
            {1, 2, 3, 4}
    };
    private static final int[][] expected3 = new int[][]{
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0}
    };

    @Test
    public void crush() {
        int[][] actual = crush2D.crush(board1);
        Assertions.assertTrue(Arrays.deepEquals(actual, expected1));

        actual = crush2D.crush(board2);
        Assertions.assertTrue(Arrays.deepEquals(actual, expected2));

        actual = crush2D.crush(board3);
        Assertions.assertTrue(Arrays.deepEquals(actual, expected3));
    }
}
