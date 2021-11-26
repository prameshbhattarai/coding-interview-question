package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

class Knapsack01Tests {

    private static final int[] wt1 = new int[]{1, 3, 4, 5};
    private static final int[] val1 = new int[]{1, 4, 5, 7};
    private static final int mw1 = 7;

    private static final int[] wt2 = new int[]{1, 2, 5, 6};
    private static final int[] val2 = new int[]{2, 3, 4, 5};
    private static final int mw2 = 8;

    private static final Knapsack01 knapsack01 = new Knapsack01();


    @Test
    void testDynamicProgramming() {
        Knapsack01.Knapsack01Response response = knapsack01.dynamicProgrammingApproach(wt1, val1, mw1);
        Assertions.assertEquals(9, response.getMaxValue());

        Map<Integer, Integer> selectedItems = knapsack01.selectedItems(wt1, val1, response.getKs());
        Assertions.assertEquals("{3=4, 4=5}", selectedItems.toString());

        response = knapsack01.dynamicProgrammingApproach(wt2, val2, mw2);
        Assertions.assertEquals(9, response.getMaxValue());

        selectedItems = knapsack01.selectedItems(wt2, val2, response.getKs());
        Assertions.assertEquals("{1=2, 2=3, 5=4}", selectedItems.toString());
    }

}
