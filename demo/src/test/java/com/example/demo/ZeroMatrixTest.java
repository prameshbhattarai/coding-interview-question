package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ZeroMatrixTest {

    private final boolean[][] arr1 = {
            {true, false, false, false},
            {false, false, false, true},
            {false, false, false, false}
    };
    private final boolean[][] expected1 = {
            {true, true, true, true},
            {true, true, true, true},
            {true, false, false, true}
    };
    private final boolean[][] arr2 = {
            {true, false, false, true},
            {false, false, false, false},
            {false, false, false, false}
    };
    private final boolean[][] expected2 = {
            {true, true, true, true},
            {true, false, false, true},
            {true, false, false, true}
    };
    private static final ZeroMatrix zeroMatrix = new ZeroMatrix();

    @Test
    void testBruteForce() {

        boolean[][] arr = zeroMatrix.bruteForce(arr1);
        Assertions.assertTrue(Arrays.deepEquals(expected1, arr));

        arr = zeroMatrix.bruteForce(arr2);
        Assertions.assertTrue(Arrays.deepEquals(expected2, arr));
    }

    @Test
    void testOptimizedWay() {
        ZeroMatrix zeroMatrix = new ZeroMatrix();
        boolean[][] arr = zeroMatrix.optimizedWay(arr1);
        Assertions.assertTrue(Arrays.deepEquals(expected1, arr));

        arr = zeroMatrix.optimizedWay(arr2);
        Assertions.assertTrue(Arrays.deepEquals(expected2, arr));
    }
}
