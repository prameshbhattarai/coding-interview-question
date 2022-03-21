package com.coding.interview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumTest {

    private static final ThreeSum sum = new ThreeSum();

    private static final int[] input1 = new int[]{-1, 0, 1, 2, -1, -4};
    private static final List<List<Integer>> expected1 = Arrays.asList(
            Arrays.asList(-1,-1,2),
            Arrays.asList(-1,0,1)
    );

    private static final int[] input2 = new int[]{};
    private static final List<List<Integer>> expected2 = new ArrayList<>();

    private static final int[] input3 = new int[]{0};
    private static final List<List<Integer>> expected3 = new ArrayList<>();

    @Test
    public void calculate() {
        Assertions.assertEquals(expected1, sum.calculate(input1));
        Assertions.assertEquals(expected2, sum.calculate(input2));
        Assertions.assertEquals(expected3, sum.calculate(input3));
    }
}
