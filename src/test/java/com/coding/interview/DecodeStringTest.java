package com.coding.interview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DecodeStringTest {

    private final DecodeString decodeString = new DecodeString();
    
    @Test
    public void testDecode() {
        Assertions.assertEquals("aaabcbc", decodeString.decode("3[a]2[bc]"));
        Assertions.assertEquals("accaccacc", decodeString.decode("3[a2[c]]"));
        Assertions.assertEquals("abcabccdcdcdef", decodeString.decode("2[abc]3[cd]ef"));
    }
}
