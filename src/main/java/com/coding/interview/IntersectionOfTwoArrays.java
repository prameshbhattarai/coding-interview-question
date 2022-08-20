package com.coding.interview;

import java.util.*;

public class IntersectionOfTwoArrays {

    /**
     * Given two integer arrays nums1 and nums2, return an array of their intersection.
     * Each element in the result must be unique and you may return the result in any order.
     * <p>
     * Input: nums1 = [1,2,2,1], nums2 = [2,2]
     * Output: [2]
     * <p>
     * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * Output: [9,4]
     * Explanation: [4,9] is also accepted.
     *
     * @return
     */
    public Integer[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums1) {
            set.add(num);
        }

        // now iterate the second array, and check if it was in first array or not

        Set<Integer> commons = new HashSet<>();
        for (int num : nums2) {
            if (set.contains(num)) {
                commons.add(num);
            }
        }

        return commons.toArray(new Integer[0]);
    }

    /**
     *  Given two arrays, write a function to compute their intersection.
     *
     *  Example:
     *  Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
     *
     *  Note:
     *  Each element in the result should appear as many times as it shows in both arrays.
     *  The result can be in any order.
     */
    public Integer[] interactionII(int[] nums1, int[] nums2) {
        Map<Integer, Integer> frequency = new HashMap<>();

        for (int num : nums1) {
            if (frequency.containsKey(num)) {
                frequency.put(num, frequency.get(num) + 1);
            } else {
                frequency.put(num, 1);
            }
        }

        List<Integer> commons = new ArrayList<>();
        for (int num : nums2) {
            if(frequency.containsKey(num)) {
                if(frequency.get(num) > 1) {
                    frequency.put(num, frequency.get(num) - 1);
                } else {
                    frequency.remove(num);
                }
                commons.add(num);
            }
        }

        return commons.toArray(new Integer[0]);
    }

}
