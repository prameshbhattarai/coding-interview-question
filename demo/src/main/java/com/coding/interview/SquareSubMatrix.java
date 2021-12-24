package com.coding.interview;

/**
 * Given a 2D array of 1s and 0s, find the largest square subarray of all 1s.
 *
 * Input
 * [
 * [1, 1, 1, 0]
 * [1, 1, 1, 1]
 * [1, 1, 0, 0]
 * ]
 *
 * Output
 * 2
 */
public class SquareSubMatrix {

    /**
     * Dynamic programming approach.
     * @param arr
     * @return
     */
    public int findLargeSquare(int[][] arr) {
         int[][] temp = new int[arr.length][arr[0].length];
         int maxSquare = 0;
         for (int i = 0; i < arr.length; i++) {
             for (int j = 0; j < arr[0].length; j++) {
                 // copy the first row and first column as it is
                 if (i == 0 || j == 0) {
                     temp[i][j] = arr[i][j];
                 } else {
                     // if the current cell have value 1 then
                     // find the min value from min(S[i][j-1], S[i-1][j], S[i-1][j-1])
                     // and then add 1
                     if (arr[i][j] == 1) {
                         int min = Math.min(arr[i][j-1], arr[i-1][j]);
                         min = Math.min(min, arr[i-1][j-1]);
                         temp[i][j] = min + 1;
                         maxSquare = Math.max(maxSquare, temp[i][j]);
                     } else {
                         // if the current cell have value 0 then
                         // insert same value 0
                         temp[i][j] = 0;
                     }
                 }
             }
         }
         return maxSquare;
    }
}
