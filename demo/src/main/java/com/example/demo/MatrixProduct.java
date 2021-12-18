package com.example.demo;

import java.util.Arrays;

/**
 * Given a matrix, find the path from top left to bottom right with the greatest
 * product by moving only down and right.
 *
 * [1, 2, 3]
 * [4, 5, 6]
 * [7, 8, 9]
 *
 * 1 ->  4  ->  7  ->  8  ->  9
 * 2016
 *
 * [-1,  2,  3]
 * [4,  5,  -6]
 * [7,  8,  9]
 *
 * -1 ->  4  ->  5  ->  -6 ->  9
 * 1080
 */
public class MatrixProduct {

    public int matrixProduct(int[][] matrix) {
        /*
            matrix
            -1 2  3
             4 5 -6
             7 8  9

            max [contain max product value]
            -1 -2  -6
            -4 -10 120
            -28


            min [contain min product value]
            -1  -2  -6
            -4  -20  36
            -28
         */
        int[][] maxTemp = new int[matrix.length][matrix[0].length];
        int[][] minTemp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {

                int max = Integer.MIN_VALUE;
                int min = Integer.MAX_VALUE;

                // set first cell value directly into the temp matrix
                if (i == 0 && j == 0) {
                    max = matrix[i][j];
                    min = matrix[i][j];
                }

                if (i > 0) {
                    // get the max product from maxTemp and minTemp matrix
                    max = Math.max(maxTemp[i-1][j] * matrix[i][j], minTemp[i-1][j] * matrix[i][j]);

                    // get the min product from maxTemp and minTemp matrix
                    min = Math.min(maxTemp[i-1][j] * matrix[i][j], minTemp[i-1][j] * matrix[i][j]);
                }

                if (j > 0) {
                    // get the max product from maxTemp and minTemp matrix
                    int tempMax = Math.max(maxTemp[i][j-1] * matrix[i][j], minTemp[i][j-1] * matrix[i][j]);
                    max = Math.max(tempMax, max);

                    // get the min product from maxTemp and minTemp matrix
                    int tempMin = Math.min(maxTemp[i][j-1] * matrix[i][j], minTemp[i][j-1] * matrix[i][j]);
                    min = Math.min(tempMin, min);
                }

                maxTemp[i][j] = max;
                minTemp[i][j] = min;

                System.out.println("max >>> " + Arrays.deepToString(maxTemp));
                System.out.println("min >>> " + Arrays.deepToString(minTemp));
            }
        }
        return maxTemp[matrix.length - 1][matrix[0].length - 1];
    }
}
