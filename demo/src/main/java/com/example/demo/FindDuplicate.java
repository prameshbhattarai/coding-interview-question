package com.example.demo;

import java.util.*;

/**
 * Given an array of integers where each value 1 <= x <= len(array), write a
 * function that finds all the duplicates in the array.
 * <p>
 * [1, 2, 3] = []
 * [1, 2, 2] = [2]
 * [3, 3, 3] = [3]
 * [1, 2, 2, 1] = [1, 2]
 */
public class FindDuplicate {

    public List<Integer> bruteForceApproach(int[] arr) {
        List<Integer> duplicates = new ArrayList<>();

        int[] frequency = new int[arr.length + 2];
        for (int j : arr) {
            frequency[j]++;
        }

        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i] > 1) duplicates.add(i);
        }
        return duplicates;
    }

    // avoid extra space
    public List<Integer> findDuplicate(int[] arr) {
        Set<Integer> duplicates = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            // convert the value into index
            // all the values in array are between 1 <= x <= len(array)
            int index = Math.abs(arr[i]) - 1;

            // if the value is negative then we have already visited it
            if (arr[index] < 0) {
                duplicates.add(Math.abs(arr[index]));
            } else {
                // all the values in array are between 1 <= x <= len(array)
                //set current index value to negative
                arr[index] = -arr[index];
            }
        }

        // revert the array to original state
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Math.abs(arr[i]);
        }
        return new ArrayList<>(duplicates);
    }
}
