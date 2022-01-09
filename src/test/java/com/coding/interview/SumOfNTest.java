package com.coding.interview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SumOfNTest {

    private final static SumOfN sumOfN = new SumOfN();

    @Test
    public void testSum() {
        Assertions.assertArrayEquals(new int[]{1, 11}, sumOfN.findSum(12, 0));
        Assertions.assertArrayEquals(new int[]{5, 99}, sumOfN.findSum(104, 0));
        Assertions.assertArrayEquals(new int[]{1, 199}, sumOfN.findSum(200, 0));
        Assertions.assertArrayEquals(new int[]{1, 2}, sumOfN.findSum(3, 0));
        Assertions.assertArrayEquals(new int[]{2, 9}, sumOfN.findSum(11, 0));
    }
}
