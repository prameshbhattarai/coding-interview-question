package com.coding.interview;

/**
 * Find two positive numbers whose sum is N and does not contain any digit as K
 * <p>
 * A + B = N
 * but A and B should not contain K
 * <p>
 * Input: N = 100, K = 0
 * Output: 1 99
 */
public class SumOfN {

    private boolean contains(String num, int k) {
        return !num.contains(Integer.toString(k));
    }

    public int[] findSum(int n, int k) {
        if (n < 1) return new int[]{};

        for (int i = 1; i < n; i++) {
            if (contains(Integer.toString(i), k) && contains(Integer.toString(n - i), k)) {
                // we can also return the array list
                // of combination of all the sum
                return new int[]{i, n - i};
            }
        }

        return new int[]{};
    }
}
