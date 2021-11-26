package com.example.demo;

import java.util.Arrays;

/**
 * Find the median of two sorted arrays.
 */
public class MedianOfArray {

    /**
     * Time Complexity: BigO (arr1.length + arr2.length)
     * Space Complexity: BigO (arr1.length + arr2.length)
     */
    public double bruteForceApproach(int[] arr1, int[] arr2) {
        int[] arr = new int[arr1.length + arr2.length];

        int arr1Length = arr1.length;
        int arr2Length = arr2.length;
        int arrLength = arr.length;

        int i = 0, j = 0, k = 0;
        while (i < arr1Length && j < arr2Length) {
            if (arr1[i] <= arr2[j]) {
                arr[k] = arr1[i];
                i++;
            } else {
                arr[k] = arr2[j];
                j++;
            }
            k++;
        }

        while (i < arr1Length) {
            arr[k++] = arr1[i++];
        }

        while (j < arr2Length) {
            arr[k++] = arr2[j++];
        }

        System.out.println("Arrays " + Arrays.toString(arr));

        boolean isEven = arrLength % 2 == 0;
        if (isEven) {
            return (double) (arr[arrLength / 2] + arr[arrLength / 2 - 1]) / 2;
        }
        return arr[arrLength / 2];
    }

    /**
     * Time Complexity: Big O(log(min(arr1.length, arr2.length))
     * Space Complexity: Big 0(1)
     */
    public double binarySearchApproach(int[] x, int[] y) {

        int xLength = x.length;
        int yLength = y.length;

        // x should be less than y in length
        if (xLength > yLength) {
            return binarySearchApproach(y, x);
        }

        int start = 0;
        int end = xLength;

        while (start <= end) {
            int partitionX = (start + end) / 2;
            int partitionY = (xLength + yLength + 1) / 2 - partitionX;

            System.out.println("Left X " + Arrays.toString(Arrays.copyOfRange(x, 0, partitionX)));
            System.out.println("Right X " + Arrays.toString(Arrays.copyOfRange(x, partitionX, xLength)));

            System.out.println("Left Y " + Arrays.toString(Arrays.copyOfRange(y, 0, partitionY)));
            System.out.println("Right Y " + Arrays.toString(Arrays.copyOfRange(y, partitionY, yLength)));

            // if partitionX == 0, then we do not have any element on LeftX, so set MIN value
            int maxLeftX = partitionX == 0 ? Integer.MIN_VALUE : x[partitionX - 1];

            // if partitionX == xLength, then we do not have any element on RightX, so set MAX value
            int minRightX = partitionX == xLength ? Integer.MAX_VALUE : x[partitionX];

            // if partitionY == 0, then we do not have any element on LeftY, so set MIN value
            int maxLeftY = partitionY == 0 ? Integer.MIN_VALUE : y[partitionY - 1];

            // if partitionY == yLength, then we do not have any element on RightY, so set MAX value
            int minRightY = partitionY == yLength ? Integer.MAX_VALUE : y[partitionY];

            // Accomplishment is to make our partition in such a way that
            // LeftX and LeftY will contain all the smallest elements groups
            // RightX and RightY will contain all the largest elements groups

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if ((xLength + yLength) % 2 == 0) {
                    // median will be
                    // AVG of (MAX value from smallest elements groups + MIN value from largest elements groups)
                    return (double) (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY))/2;
                }
                // median will be
                // MAX value from smallest groups
                return Math.max(maxLeftX, maxLeftY);

            } else if (maxLeftX > minRightY) {
                // move partition to left
                end = partitionX - 1;
            } else {
                // move partition to right
                start = partitionX + 1;
            }
        }

        return -1;
    }
}
