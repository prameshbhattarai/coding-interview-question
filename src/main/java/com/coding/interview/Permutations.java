package com.coding.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a function that returns all permutations of a given list.
 *
 * Input
 * [1,2,3]
 *
 * Output
 * [1, 2, 3]
 * [1, 3, 2]
 * [2, 1, 3]
 * [2, 3, 1]
 * [3, 1, 2]
 * [3, 2, 1]
 */
public class Permutations {

    public List<int[]> permute(int[] arr) {
        List<int[]> collection = new ArrayList<>();
        permute(0, arr, collection);
        return collection;
    }

    public List<String> permute(String str) {
        List<String> collection = new ArrayList<>();
        permute(0, str, collection);
        return collection;
    }

    private void permute(int index, String str, List<String> a) {
        if (index == str.length()) {
            a.add(str);
        } else {
            for (int i = index; i < str.length(); i++) {
                permute(index + 1, str.charAt(i) + str.substring(0, i) + str.substring(i + 1), a);
            }
        }
    }

    private void permute(int index, int[] arr, List<int[]> a) {
        if (index == arr.length) {
            a.add(arr);
        } else {
            for (int i = index; i < arr.length; i++) {
                int[] na = arr.clone();
                int temp = na[i];
                na[i] = na[index];
                na[index] = temp;
                permute(index + 1, na, a);
            }
        }
    }

}
