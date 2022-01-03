package com.coding.interview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BuyAndSellStockTest {

    private final int[] stockPrice1 = new int[]{7,1,5,3,6,4};
    private final int[] stockPrice2 = new int[]{7,6,4,3,1};

    private static final BuyAndSellStock buyAndSellStock = new BuyAndSellStock();

    @Test
    public void findBestTimeToBuyAndSellStock() {
        Assertions.assertEquals(5, buyAndSellStock.bestTimeToBuyAndSell(stockPrice1));
        Assertions.assertEquals(0, buyAndSellStock.bestTimeToBuyAndSell(stockPrice2));
    }
}
