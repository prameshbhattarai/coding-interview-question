package com.coding.interview;

import java.util.*;

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

    /*
    Approach:
    Merge consecutive array to single Set
    and return the Set with max number of elements
     */
    public int unionFind(int[] arr) {
        UnionFind unionFind = new UnionFind(arr.length);

        // value index map
        Map<Integer, Integer> lookup = new HashMap<>();

        for (int i =0; i < arr.length; i++) {
            if (lookup.containsKey(arr[i])) continue;
            lookup.put(arr[i], i);

            if (lookup.containsKey(arr[i] + 1)) {
                // if we have next consecutive number
                // then merge both into single set
                unionFind.union(i, lookup.get(arr[i] + 1));
            }

            if (lookup.containsKey(arr[i] - 1)) {
                // if we have prev consecutive number
                // then merge both into single set
                unionFind.union(i, lookup.get(arr[i] - 1));
            }
        }

        return unionFind.maxUnion();
    }

    private static class UnionFind {
        private final int[] parent;

        UnionFind(int n) {
            this.parent = new int[n];
            // initialize parent for all index
            // initially parent of index will be index
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        /*
        find parent of i
         */
        public int find(int i) {
            // find parent of provided index
            if (parent[i] != i) {
                return find(parent[i]);
            }
            return i;
        }

        /*
        merge two index, i and j
        assign parent of j to i

        i.e. grouping i and j to same set
         */
        public void union(int i, int j) {
            int parentOfI = find(i);
            int parentOfJ = find(j);
            parent[parentOfI] = parentOfJ;
        }

        /*
        find the set with max number of elements
         */
        public int maxUnion() {
            int[] count = new int[parent.length];
            int max = 1;
            for (int i = 0; i < parent.length; i++) {
                int par = find(parent[i]);
                count[par]++;
                max = Math.max(max, count[par]);
            }
            return max;
        }
    }
}
