package com.coding.interview;

/**
 * Given 2 sorted arrays, A and B, where A is long enough to hold the contents of
 * A and B, write a function to copy the contents of B into A without using any buffer or
 * additional memory.
 * <p>
 * Input:
 * a = {1, 3, 5, 0, 0, 0}
 * b = {2, 4, 6}
 * <p>
 * Output:
 * a = {1, 2, 3, 4, 5, 6}
 */
public class MergeArray {

    public int[] merge(int[] a, int[] b) {
        int j = b.length - 1, i = a.length - b.length - 1, k = a.length - 1;
        while (i >= 0 && j >= 0) {
            a[k--] = a[i] > b[j] ? a[i--] : b[j--];
        }
        while (j >= 0) {
            a[k--] = b[j--];
        }
        return a;
    }
}
