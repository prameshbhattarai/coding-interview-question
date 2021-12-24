package com.coding.interview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given a list of items with values and weights, as well as a max weight, find the
 * maximum value you can generate from items where the sum of the weights is less than
 * the max.
 *
 * items = {( w:1 ,  v:6 ), ( w:2 ,  v:10 ), ( w:3 ,  v:12 )}
 * maxWeight =  5
 * knapsack( items , maxWeight) =  22
 *
 * Time complexity: BigO (maxWeight * value.length)
 */
public class Knapsack01 {

    public static class Knapsack01Response {
        private final int maxValue;
        private final int[][] ks;

        private Knapsack01Response(int maxValue, int[][] ks) {
            this.maxValue = maxValue;
            this.ks = ks;
        }

        public int getMaxValue() {
            return maxValue;
        }

        public int[][] getKs() {
            return ks;
        }
    }

    // formula: ks[i][w] = max(ks[i-1, j], ks[i-1][j - wt[i-1]] + v[i-1])
    public Knapsack01Response dynamicProgrammingApproach(int[] weight, int[] value, int maxWeight) {
        int[][] ks = new int[value.length+1][maxWeight+1];

        for (int i = 0; i <= value.length; i++) {
            for (int j = 0; j <= maxWeight; j++) {
                // initial value for 0 index
                if (i == 0 || j == 0) {
//                    ks[i][j] = 0; // default is 0, no need to assign
                    continue;
                }
                /*
                wt  = 1, 3, 4, 5
                val = 1, 4, 5, 7

                [
                          j  0  1  2  3  4  5  6  7  // allowed weight for each iteration
               val wt  i
                       0    [0, 0, 0, 0, 0, 0, 0, 0],
               1   1   1    [0, 1, 1, 1, 1, 1, 1, 1],
               4   3   2    [0, 1, 1, 4, 5, 5, 5, 5],
               5   4   3    [0, 1, 1, 4, 5, 6, 6, 9],
               7   5   4    [0, 1, 1, 4, 5, 7, 8, 9]
                ]

                 */

                if (j - weight[i - 1] >= 0) {
                    // max of
                    // ks[i-1][j] previous row value and
                    // finding previous value for remaining capacity + current value
                    // i.e. ks[i-1][j-weight[i-1]] + value[i-1]
                    // [j-weight[i-1]] remaining capacity
                    // ks[i-1][j-weight[i-1]] finding previous row value for remaining capacity
                    // plus value[i-1] current value

                    ks[i][j] = Math.max(ks[i-1][j], ks[i-1][j-weight[i-1]] + value[i-1]);
                } else {
                    ks[i][j] = ks[i-1][j];
                }
            }
        }

        System.out.println("Weight " + Arrays.toString(weight));
        System.out.println("Value " + Arrays.toString(value));
        System.out.println(Arrays.deepToString(ks).replaceAll("],", "], \n"));

        return new Knapsack01Response(ks[value.length][maxWeight], ks);
    }

    public Map<Integer, Integer> selectedItems(int[] weight, int[] value, int[][] ks) {
        Map<Integer, Integer> selectedItem = new HashMap<>();

        int i = ks.length - 1;
        int j = ks[0].length - 1;

        while (ks[i][j] != 0) {
            // if we have same value in previous row, then we are not storing current weight in KS
            if (ks[i][j] == ks[i - 1][j]) {
                i = i - 1;
            } else {
                selectedItem.put(weight[i-1], value[i-1]);
                j = j - weight[i - 1]; // move to previous row weight that has been inserted in KS
                i = i - 1; // we have stored the current weight in KS, so move to previous row
            }
        }

        return selectedItem;
    }
}
