package com.coding.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
 *
 * The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.
 *
 * It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
 *
 * Input: candidates = [2,3,6,7], target = 7
 * Output: [[2,2,3],[7]]
 * Explanation:
 * 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
 * 7 is a candidate, and 7 = 7.
 * These are the only two combinations.
 *
 * Input: candidates = [2,3,5], target = 8
 * Output: [[2,2,2,2],[2,3,3],[3,5]]
 *
 * Input: candidates = [2], target = 1
 * Output: []
 */
public class CombinationSum {

    /*
    Approach:
    We will use backtracking algorithm to find all the combination sum of the given array
    */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        backtracking(result, new ArrayList<>(), candidates, 0, target);
        return result;
    }

    private void backtracking(List<List<Integer>> result, List<Integer> path, int[] candidates, int start, int remaining) {
        if (remaining == 0) result.add(new ArrayList<>(path));
        if (remaining < 0 || start > candidates.length) return;
        for(int i = start; i < candidates.length; i++) {
            path.add(candidates[i]);
            // as we can have combination of same number
            // so we are sending i, recursively
            backtracking(result, path, candidates, i, remaining - candidates[i]);
            path.remove(path.size() - 1);
        }
    }

    public List<List<Integer>> combinationSumDedup(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return result;

        // for identifying duplicate number we are sorting the array
        Arrays.sort(candidates);

        backtrackingDedup(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void backtrackingDedup(List<List<Integer>> result, List<Integer> temp, int[] candidates, int target, int start) {
        if (target == 0) result.add(new ArrayList<>(temp));

        if (target < 0 || start > candidates.length) return;

        for (int i = start; i < candidates.length; i++) {
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
            if (i > start && candidates[i] == candidates[i-1]) continue;

            temp.add(candidates[i]);
            // as we should have only unique number
            // so we are sending i + 1, recursively
            backtrackingDedup(result, temp, candidates, target - candidates[i], i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
