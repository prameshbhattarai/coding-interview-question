package com.coding.interview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DecodeWaysTest {

    public final DecodeWays decodeWays = new DecodeWays();
    
    @Test
    public void test() {
        Assertions.assertEquals(2, decodeWays.numsDecoding("12"));
        Assertions.assertEquals(3, decodeWays.numsDecoding("226"));
        Assertions.assertEquals(0, decodeWays.numsDecoding("06"));
    }
}
