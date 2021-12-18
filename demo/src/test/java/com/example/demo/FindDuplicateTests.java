package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindDuplicateTests {

    private static final int[] arr1 = new int[]{1, 2, 3};
    private static final int[] arr2 = new int[]{1, 2, 2};
    private static final int[] arr3 = new int[]{3, 3, 3};
    private static final int[] arr4 = new int[]{1, 2, 2, 1};
    private static final FindDuplicate findDuplicate = new FindDuplicate();

    @Test
    void testBruteForce() {
        List<Integer> duplicates = findDuplicate.bruteForceApproach(arr1);
        Assertions.assertEquals(Collections.emptyList(), duplicates);

        duplicates = findDuplicate.bruteForceApproach(arr2);
        Assertions.assertEquals(Collections.singletonList(2), duplicates);

        duplicates = findDuplicate.bruteForceApproach(arr3);
        Assertions.assertEquals(Collections.singletonList(3), duplicates);

        duplicates = findDuplicate.bruteForceApproach(arr4);
        Assertions.assertEquals(Arrays.asList(1, 2), duplicates);
    }

    @Test
    void testFindDuplicate() {
        List<Integer> duplicates = findDuplicate.findDuplicate(arr1);
        Assertions.assertEquals(Collections.emptyList(), duplicates);

        duplicates = findDuplicate.findDuplicate(arr2);
        Assertions.assertEquals(Collections.singletonList(2), duplicates);

        duplicates = findDuplicate.findDuplicate(arr3);
        Assertions.assertEquals(Collections.singletonList(3), duplicates);

        duplicates = findDuplicate.findDuplicate(arr4);
        Assertions.assertEquals(Arrays.asList(1, 2), duplicates);
    }
}
