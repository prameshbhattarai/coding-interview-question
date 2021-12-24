package com.coding.interview;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given an unsorted array, find the length of the longest sequence of
 * consecutive numbers in the array.
 *
 * [4, 2, 1, 6, 5] = 3 [4, 5, 6]
 * [5, 5, 3, 1] = 1 [1], [3] or [5]
 */
public class ConsecutiveArray {

    public int bruteForceApproach(int[] arr) {
        Arrays.sort(arr);
        int maxConsecutiveArray = 1;
        int tempConsecutiveArray = 1;
        for (int i =1; i < arr.length; i++) {
            if (arr[i-1] + 1 == arr[i]) {
                tempConsecutiveArray++;
            } else {
                maxConsecutiveArray = Math.max(maxConsecutiveArray, tempConsecutiveArray);
                tempConsecutiveArray = 1;
            }
        }
        return Math.max(maxConsecutiveArray, tempConsecutiveArray);
    }

    public int consecutive(int[] arr) {
        Set<Integer> lookup = new HashSet<>();
        for (int a : arr) lookup.add(a);

        int maxConsecutiveArray = 1;
        for (int i = 0; i < arr.length; i++) {

            // check if we have next consecutive value in array or not
            if (!lookup.contains(arr[i] + 1)) continue;

            int length = 1;
            int nextValue = arr[i] + 1;

            // loop until we have next consecutive value of next value
            while (lookup.contains(nextValue++)) {
                length++;
            }

            maxConsecutiveArray = Math.max(length, maxConsecutiveArray);
        }

        return maxConsecutiveArray;

    }
}
