package com.coding.interview;

/**
 * Given an n x m array where all rows and columns are in sorted order, write a
 * function to determine whether the array contains an element x.
 *
 * [
 * [1, 2, 3, 4]
 * [5, 6, 7, 8]
 * [9, 10, 11, 12]
 * ]
 */
public class MatrixSearch {

    public boolean optimizedApproach(int[][] arr, int element) {
        // iterate each row and find which will contain the element
        // and then iterate on respective row to find the element

        int row = arr.length - 1, column = arr[0].length -1;

        while (row >= 0 && column >= 0) {
            if (arr[row][column] == element) return true;
            if (element < arr[row][0]) row--;
            else column--;
        }

        return false;
    }

    public boolean bruteForceApproach(int[][] arr, int element) {
        int numberOfRows = arr.length;
        int numberOfColumn = arr[0].length;

        /*
        using binary search
        try to find the row which will contain the element
        and again use binary search on finding the element in the row
         */

        int i = 0, j = numberOfRows - 1, mid = 0;

        while (i <= j) {
            mid = i + (j - i)/2;
            // get the first element of the mid
            if (element >= arr[mid][0] && element <= arr[mid][numberOfColumn-1]) {
                // do binary search in current row
                return binarySearch(arr[mid], element);
            } else if (element > arr[mid][0]) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }

        return false;
    }

    private boolean binarySearch(int[] arr, int element) {
        int i = 0, j = arr.length - 1, mid = 0;

        while (i <= j) {
            mid = i + (j - i)/2;

            // get the first element of the mid
            if (arr[mid] < element) {
                i = mid + 1;
            } else if (arr[mid] > element) {
                j = mid - 1;
            } else {
               return true;
            }
        }
        return false;
    }
}
