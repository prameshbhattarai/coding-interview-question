package com.coding.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
 * such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * <p>
 * Notice that the solution set must not contain duplicate triplets.
 * <p>
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * <p>
 * Input: nums = []
 * Output: []
 */
public class ThreeSum {

    public List<List<Integer>> calculate(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < num.length - 2; i++) {

            // outer loop is for finding first triplet
            // skip  num[i] == num[i-1] as it will result duplicate triplets
             if (i == 0 || (num[i] != num[i-1])) {

                int lo = i + 1, hi = num.length - 1, sum = -num[i];

                // as the input array is already sorted we can do binary search
                while (lo < hi) {
                    // if the sum of lo and hi is equal to first triplet value
                    // then we found the expected triplets
                    if (num[lo] + num[hi] == sum) {

                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        lo++;
                        hi--;

                        // skip the duplicate values from second triplet
                        while (lo < hi && num[lo] == num[lo + 1]) lo++;

                        // skip the duplicate values from third triplet
                        while (lo < hi && num[hi] == num[hi - 1]) hi--;
                    } else if (num[lo] + num[hi] < sum) lo++;
                    else hi--;
                }
            }
        }
        return res;
    }

}
