package com.coding.interview;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Given k sorted arrays, merge them into a single sorted array.
 * <p>
 * Input:
 * [
 * [1, 4, 7]
 * [2, 5, 8]
 * [3, 6, 9]
 * ]
 * <p>
 * Output:
 * [1, 2, 3, 4, 5, 6, 7, 8, 9]
 */
public class MergeKSortedArray {

    public static class BruteForce1 {
        /**
         * Copy all the sub arrays into single array and then use merge sort.
         * @param arrs
         * @return
         */
        public int[] sortArray(int[][] arrs) {
            int k = arrs.length;
            int n = arrs[0].length;

            int[] merged = new int[k * n];
            int mergeIndex = 0;

            // insert all the values from k arrays into single array
            // then use sorting algorithm
            for (int i = 0; i < arrs.length; i++) {
                for (int j = 0; j < arrs[0].length; j++) {
                    merged[mergeIndex++] = arrs[i][j];
                }
            }

            mergeSort(merged, 0, merged.length - 1);
            return merged;
        }

        private void mergeSort(int[] arr, int l, int r) {
            if (l < r) {
                int m = l + (r - l) / 2;

                mergeSort(arr, l, m);
                mergeSort(arr, m + 1, r);

                merge(arr, l, m, r);
            }
        }

        private void merge(int[] arr, int l, int m, int r) {
            int n1 = m - l + 1;
            int n2 = r - m;

            int[] leftArray = new int[n1];
            int[] rightArray = new int[n2];

            for (int i = 0; i < n1; i++) {
                leftArray[i] = arr[l + i];
            }
            for (int j = 0; j < n2; j++) {
                rightArray[j] = arr[m + 1 + j];
            }

            int k = l;
            int i = 0, j = 0;
            while (i < n1 && j < n2) {
                if (leftArray[i] <= rightArray[j]) {
                    arr[k++] = leftArray[i++];
                } else {
                    arr[k++] = rightArray[j++];
                }
            }

            while (i < n1) {
                arr[k++] = leftArray[i++];
            }

            while (j < n2) {
                arr[k++] = rightArray[j++];
            }
        }
    }

    public static class BruteForce2 {
        /**
         * Divide 2D arrays into pairs and merge each pair recursively.
         * @param arrs
         * @return
         */
        public int[] sortArray(int[][] arrs) {
            int k = arrs.length;

            if (k == 1) return arrs[0];
            if (k == 2) return mergeTwoArrays(arrs[0], arrs[1]);

            int m = k / 2;
            int[] a = sortArray(Arrays.copyOf(arrs, m));
            int[] b = sortArray(Arrays.copyOfRange(arrs, m, arrs.length));

            return mergeTwoArrays(a, b);
        }

        private int[] mergeTwoArrays(int[] a, int[] b) {
            int[] n = new int[a.length + b.length];

            int i = 0, j = 0, k = 0;
            while (i < a.length && j < b.length) {
                if (a[i] <= b[j]) {
                    n[k++] = a[i++];
                } else {
                    n[k++] = b[j++];
                }
            }

            while (i < a.length) {
                n[k++] = a[i++];
            }

            while (j < b.length) {
                n[k++] = b[j++];
            }

            return n;
        }
    }

    public static class PriorityQueueApproach {

        private static class Node implements Comparable<Node> {

            final int row, index, value;

            private Node(int row, int index, int value) {
                this.row = row;
                this.index = index;
                this.value = value;
            }

            @Override
            public int compareTo(Node o) {
                if (value > o.value) return 1;
                if (value < o.value) return -1;
                return 0;
            }
        }

        public int[] sortArray(int[][] arrs) {
            // we are using priority queue as all it will sort the
            // value in ascending order
            PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
            int size = 0;

            // as all of the sub arrays are sorted
            // we will insert all the first index value of all sub arrays
            // into priority queue
            for (int i = 0; i < arrs.length; i++) {
                size += arrs[i].length; // adding size of each sub array (each row) length
                if (arrs[i].length > 0) {
                    priorityQueue.add(new Node(i, 0, arrs[i][0])); // inserting first index value into priority queue
                }
            }

            int[] sorted = new int[size];

            int i = 0;
            while(!priorityQueue.isEmpty()) {
                Node node = priorityQueue.poll();
                sorted[i++] = node.value;

                // next index of poll node
                int nextIndex = node.index + 1;
                if (nextIndex < arrs[node.row].length) {
                    // insert next element of that row...
                    priorityQueue.add(new Node(node.row, nextIndex, arrs[node.row][nextIndex]));
                }
            }

            return sorted;
        }

    }

}
