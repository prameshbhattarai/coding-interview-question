package com.coding.interview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CustomSortStringTest {

    private final CustomSortString sorter = new CustomSortString();
    
    @Test
    public void testSortingOrder() {
        Assertions.assertEquals("cbad", sorter.sort("cba", "abcd"));
        Assertions.assertEquals("cbad", sorter.sort("cbafg", "abcd"));
    }
}
