package com.coding.interview;

import java.util.Arrays;

/**
 * There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.
 * Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.
 * The test cases are generated so that the answer will be less than or equal to 2 * 109.
 * 
 * Input: m = 3, n = 7
 * Output: 28
 * 
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 * 1. Right -> Down -> Down
 * 2. Down -> Down -> Right
 * 3. Down -> Right -> Down
 * 
 * https://leetcode.com/problems/unique-paths/
 */
public class UniquePaths {

    public int numberOfPaths(int m, int n) {
//        return recursivePath(m, n, 0, 0, new int[m][n]);
        return tabularMethod(m, n, new int[m][n]);
    }
    
    // dynamic programming
    private int tabularMethod(int m, int n, int[][] matrix) {
        // first populate 1 to all the cells
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = 1;
            }
        }
        // now traverse the cell from top left to bottom right
        // calculate the path to next cell, which is sum of (left and top) cell
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                matrix[i][j] = matrix[i-1][j] + matrix[i][j-1];
            }
        }
        return matrix[m-1][n-1];
    }
    
    // dynamic programming - memoization
    private int recursivePath(int m, int n, int i, int j, int[][] matrix) {
        if (i >= m || j >= n) {
            // we are out of matrix
            return 0;
        }
        if (i == m-1 && j == n-1) {
            // we are at destination
            return 1;
        }
        if (matrix[i][j] != 0) return matrix[i][j];
        // recursively sum right and down
        matrix[i][j] = recursivePath(m, n, i + 1, j, matrix) + recursivePath(m, n, i, j + 1, matrix);
        return matrix[i][j];
    }
}
