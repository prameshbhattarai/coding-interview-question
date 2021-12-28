package com.coding.interview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array, write a function to find any subarray that sums to zero, if one
 * exists.
 *
 * Input: {1, 2, -5, 1, 2}
 *
 * Output: {2, -5, 1, 2}
 */
public class ZeroSumSubArray {

    /**
     * This approach will take big O (n^2)
     * @param arr
     * @return arr
     */
    public int[] bruteForceApproach(int[] arr) {
        int sum;
        /*
           Sliding window technique
           Using two pointer,
           one in outer loop for starting index
           another in inner loop for ending index
         */
        for (int i = 0; i < arr.length; i++) {
            sum = arr[i];
            for (int j = i+1; j < arr.length; j++) {
                sum += arr[j];
                if (sum == 0) {
                    return Arrays.copyOfRange(arr, i, j+1);
                }
            }
        }
        return null;
    }

    /*
    This approach will take BigO(n) time complexity.
     */
    public int[] optimizeApproach(int[] arr) {
        /*

        We will store sum of each value in lookup
        and if we find sum in lookup then
        we have found the sub array which will result zero
         */
        // sum and index lookup
        Map<Integer, Integer> lookup = new HashMap<>();
        for (int i = 0, sum = 0; i < arr.length; i++) {
            sum += arr[i];
            if (arr[i] == 0) {
                return new int[] {arr[i]};
            }
            /*
                arr = {1, 2, -5, 1, 2}
                sum = {1, 3, -2, -1, 1}

                we have found sum 1 in index 0 and index 5
                so we will have summation from index 1 to index 5 equal to 0
             */
            // store sum in lookup
            if (lookup.containsKey(sum)) {
                return Arrays.copyOfRange(arr, lookup.get(sum) + 1, i+1);
            }
            lookup.put(sum, i);
        }


        return null;
    }
}
