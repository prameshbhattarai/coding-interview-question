package com.coding.interview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BuyAndSellStockIITest {
    private final int[] stockPrice1 = new int[]{7,1,5,3,6,4};
    private final int[] stockPrice2 = new int[]{7,6,4,3,1};
    private final int[] stockPrice3 = new int[]{1,2,3,4,5};

    private static final BuyAndSellStockII buyAndSellStock = new BuyAndSellStockII();

    @Test
    public void findMaxProfit() {
        Assertions.assertEquals(7, buyAndSellStock.maxProfit(stockPrice1));
        Assertions.assertEquals(0, buyAndSellStock.maxProfit(stockPrice2));
        Assertions.assertEquals(4, buyAndSellStock.maxProfit(stockPrice3));
    }
}
