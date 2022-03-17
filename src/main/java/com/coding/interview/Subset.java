package com.coding.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 *
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 *
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 *
 * Input: nums = [0]
 * Output: [[],[0]]
 */
public class Subset {

    /*
    Approach:
    We will use backtracking algorithm to find all the subset of the given array
    */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtracking(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void backtracking(List<List<Integer>> result, List<Integer> tempList, int[] nums, int start) {
        result.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++) {
            // add the value in tempList
            tempList.add(nums[i]);
            backtracking(result, tempList, nums, i + 1);
            // backtrack, remove the value from tempList
            tempList.remove(tempList.size() - 1);
        }
    }

    public List<List<Integer>> subsetsDedup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrackingDedup(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void backtrackingDedup(List<List<Integer>> result, List<Integer> tempList, int[] nums, int start) {
        result.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++) {
            // we have already sorted the nums, so duplicate num will be corresponding order
            // if we are in same loop then i value will ge greater than start value

            /*
            i : 0 start : 0 ls : [1]
            i : 1 start : 1 ls : [1, 2]
            i : 2 start : 2 ls : [1, 2, 2]
            i : 2 start : 1 ls : [1, 2]   // Duplicate, how do we avoid ? check if i>start and nums[i] == nums[i-1], here both conditions satisfy, don't choose this route
            i : 1 start : 0 ls : [2]
            i : 2 start : 2 ls : [2, 2]
            i : 2 start : 0 ls : [2]  // Duplicate, how do we avoid ? check if i>start and nums[i] == nums[i-1], here both conditions satisfy, don't choose this route
             */
            if (i > start && nums[i] == nums[i-1]) continue;
            // add the value in tempList
            tempList.add(nums[i]);
            backtrackingDedup(result, tempList, nums, i + 1);
            // backtrack, remove the value from tempList
            tempList.remove(tempList.size() - 1);
        }
    }

}
