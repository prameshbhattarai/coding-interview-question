package com.coding.interview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class LetterCasePermutationTest {

    private static final String s1 = "a1b2";
    private static final List<String> ex1 = Arrays.asList("A1B2","A1b2","a1B2","a1b2");

    private static final String s2 = "3z4";
    private static final List<String> ex2 = Arrays.asList("3Z4","3z4");

    private static final LetterCasePermutation permutations = new LetterCasePermutation();

    @Test
    public void testString() {
        List<String> results = permutations.permute(s1);
        Assertions.assertEquals(ex1, results);

        results = permutations.permute(s2);
        Assertions.assertEquals(ex2, results);
    }
}
