package com.coding.interview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class IntersectionOfTwoArraysTest {

    private static final IntersectionOfTwoArrays intersection = new IntersectionOfTwoArrays();

    Integer[] expected1 = new Integer[] {2};
    Integer[] expected2 = new Integer[] {2, 2};

    int[] input1 = new int[] {1,2,2,1};
    int[] input2 = new int[] {2,2};

    @Test
    public void test() {
        Assertions.assertTrue(Arrays.equals(expected1, intersection.intersection(input1, input2)));
        Assertions.assertTrue(Arrays.equals(expected2, intersection.interactionII(input1, input2)));
    }
}
