package com.coding.interview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumTest {

    private static final CombinationSum combination = new CombinationSum();
    private static final List<List<Integer>> expectedList1 = new ArrayList<>();
    private static final List<List<Integer>> expectedList2 = new ArrayList<>();
    private static final List<List<Integer>> expectedList3 = new ArrayList<>();
    private static final List<List<Integer>> expectedList4 = new ArrayList<>();

    static {
        expectedList1.add(Arrays.asList(2, 2, 3));
        expectedList1.add(Arrays.asList(7));
    }

    static {
        expectedList2.add(Arrays.asList(2, 2, 2, 2));
        expectedList2.add(Arrays.asList(2, 3, 3));
        expectedList2.add(Arrays.asList(3, 5));
    }

    static {
        expectedList3.add(Arrays.asList(1, 1, 6));
        expectedList3.add(Arrays.asList(1, 2, 5));
        expectedList3.add(Arrays.asList(1, 7));
        expectedList3.add(Arrays.asList(2, 6));
    }

    static {
        expectedList4.add(Arrays.asList(1, 2, 2));
        expectedList4.add(Arrays.asList(5));
    }

    @Test
    public void test() {
        Assertions.assertEquals(expectedList1, combination.combinationSum(new int[]{2, 3, 6, 7}, 7));
        Assertions.assertEquals(expectedList2, combination.combinationSum(new int[]{2, 3, 5}, 8));

        Assertions.assertEquals(expectedList3, combination.combinationSumDedup(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
        Assertions.assertEquals(expectedList4, combination.combinationSumDedup(new int[]{2, 5, 2, 1, 2}, 5));
    }
}
