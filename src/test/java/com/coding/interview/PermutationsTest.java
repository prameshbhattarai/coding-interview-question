package com.coding.interview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class PermutationsTest {

    private static final int[] arr1 = new int[]{1, 2, 3};
    private static final List<int[]> expected1 = Arrays.asList(
            new int[]{1, 2, 3},
            new int[]{1, 3, 2},
            new int[]{2, 1, 3},
            new int[]{2, 3, 1},
            new int[]{3, 2, 1},
            new int[]{3, 1, 2}
    );

    private static final int[] arr2 = new int[]{1, 2, 3, 4};
    private static final List<int[]> expected2 = Arrays.asList(
            new int[]{1, 2, 3, 4},
            new int[]{1, 2, 4, 3},
            new int[]{1, 3, 2, 4},
            new int[]{1, 3, 4, 2},
            new int[]{1, 4, 3, 2},
            new int[]{1, 4, 2, 3},
            new int[]{2, 1, 3, 4},
            new int[]{2, 1, 4, 3},
            new int[]{2, 3, 1, 4},
            new int[]{2, 3, 4, 1},
            new int[]{2, 4, 3, 1},
            new int[]{2, 4, 1, 3},
            new int[]{3, 2, 1, 4},
            new int[]{3, 2, 4, 1},
            new int[]{3, 1, 2, 4},
            new int[]{3, 1, 4, 2},
            new int[]{3, 4, 1, 2},
            new int[]{3, 4, 2, 1},
            new int[]{4, 2, 3, 1},
            new int[]{4, 2, 1, 3},
            new int[]{4, 3, 2, 1},
            new int[]{4, 3, 1, 2},
            new int[]{4, 1, 3, 2},
            new int[]{4, 1, 2, 3}
    );

    private static final String s1 = "abc";
    private static final List<String> ex1 = Arrays.asList("cba", "bca", "cab", "acb", "bac", "abc");

    private static final String s2 = "abcd";
    private static final List<String> ex2 = Arrays.asList( "dcba", "cdba", "dbca", "bdca", "cbda", "bcda", "dcab", "cdab", "dacb", "adcb", "cadb", "acdb", "dbac", "bdac", "dabc", "adbc", "badc", "abdc", "cbad", "bcad", "cabd", "acbd", "bacd", "abcd");

    private static final Permutations permutations = new Permutations();

    @Test
    public void testArrayOfInteger() {
        List<int[]> results = permutations.permute(arr1);
        Assertions.assertTrue(Utils.containsAll(expected1, results));

        results = permutations.permute(arr2);
        Assertions.assertTrue(Utils.containsAll(expected2, results));
    }

    @Test
    public void testString() {
        List<String> results = permutations.permute(s1);
        Assertions.assertEquals(ex1, results);

        results = permutations.permute(s2);
        Assertions.assertEquals(ex2, results);
    }

}
