package com.coding.interview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetTest {

    private static final Subset subset = new Subset();
    private static final List<List<Integer>> expectedList1 = new ArrayList<>();
    static {
        expectedList1.add(new ArrayList<>());
        expectedList1.add(Arrays.asList(1));
        expectedList1.add(Arrays.asList(1, 2));
        expectedList1.add(Arrays.asList(2));
    }

    private static final List<List<Integer>> expectedList2 = new ArrayList<>();
    static {
        expectedList2.add(new ArrayList<>());
        expectedList2.add(Arrays.asList(1));
        expectedList2.add(Arrays.asList(1, 2));
        expectedList2.add(Arrays.asList(1, 2, 3));
        expectedList2.add(Arrays.asList(1, 3));
        expectedList2.add(Arrays.asList(2));
        expectedList2.add(Arrays.asList(2, 3));
        expectedList2.add(Arrays.asList(3));
    }

    private static final List<List<Integer>> expectedList3 = new ArrayList<>();
    static {
        expectedList3.add(new ArrayList<>());
        expectedList3.add(Arrays.asList(1));
        expectedList3.add(Arrays.asList(1, 1));
    }

    private static final List<List<Integer>> expectedList4 = new ArrayList<>();
    static {
        expectedList4.add(new ArrayList<>());
        expectedList4.add(Arrays.asList(1));
        expectedList4.add(Arrays.asList(1, 2));
        expectedList4.add(Arrays.asList(1, 2, 2));
        expectedList4.add(Arrays.asList(2));
        expectedList4.add(Arrays.asList(2, 2));
    }

    @Test
    public void test() {
        Assertions.assertEquals(expectedList1, subset.subsets(new int[] {1, 2}));
        Assertions.assertEquals(expectedList2, subset.subsets(new int[] {1, 2, 3}));

        Assertions.assertEquals(expectedList3, subset.subsetsDedup(new int[] {1, 1}));
        Assertions.assertEquals(expectedList4, subset.subsetsDedup(new int[] {1, 2, 2}));
    }
}
