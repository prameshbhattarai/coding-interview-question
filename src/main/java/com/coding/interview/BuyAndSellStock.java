package com.coding.interview;

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 * <p>
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * <p>
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 */
public class BuyAndSellStock {

    /*
    Simple approach
    using two pointer, one outer pointer i and another inner pointer j
    we will check max diff between outer pointer and inner pointer

    but this approach is inefficient, it will take Big O (n * n)

    Efficient approach
    But we can do it in single iteration
    we will try to find the minimum value and find the max difference between currentValue - minimum value.
     */

    public int bestTimeToBuyAndSell(int[] arr) {
        if (arr.length == 0) return 0;
        int minPrice = arr[0], profit = 0;

        for (int i = 1; i < arr.length; i++) {
            // if current value is greater than minPrice value
            // then calculate the difference
            // if it is the max difference, then update the profit
            if (arr[i] > minPrice) {
                int diff = arr[i] - minPrice;
                profit = Math.max(profit, diff);
            } else {
                // if it is min value so far than update the minPrice
                minPrice = arr[i];
            }
        }
        return profit;
    }
}
