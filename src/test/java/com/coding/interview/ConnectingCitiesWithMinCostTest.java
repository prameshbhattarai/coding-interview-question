package com.coding.interview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ConnectingCitiesWithMinCostTest {

    private static final ConnectingCitiesWithMinCost cost = new ConnectingCitiesWithMinCost();

    @Test
    public void test() {
        Assertions.assertEquals(6, cost.minimumCost(3, new int[][]{
                {1, 2, 5},
                {1, 3, 6},
                {2, 3, 1}
        }));
        Assertions.assertEquals(-1, cost.minimumCost(4, new int[][]{
                {1, 2, 3},
                {3, 4, 4}
        }));
    }
}
