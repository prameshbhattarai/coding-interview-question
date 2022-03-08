package com.coding.interview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CandyCrush1DTest {

    private static final CandyCrush1D crush = new CandyCrush1D();

    private static final String test1 = "aaabbbc";
    private static final String test2 = "aabbbacd";
    private static final String test3 = "aabbccddeeedcba";
    private static final String test4 = "deeedbbcccbdaa";
    private static final String test5 = "aaabbbacd";

    @Test
    public void crushTest() {
        String actual = crush.crush(test1);
        Assertions.assertEquals("c", actual);

        actual = crush.crush(test2);
        Assertions.assertEquals("cd", actual);

        actual = crush.crush(test3);
        Assertions.assertEquals("", actual);

        actual = crush.crush(test4);
        Assertions.assertEquals("aa", actual);

        actual = crush.crush(test5);
        Assertions.assertEquals("acd", actual);
    }
}
