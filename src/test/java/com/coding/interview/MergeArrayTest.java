package com.coding.interview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MergeArrayTest {

    private static final int[] a1 = new int[]{1, 3, 5, 0, 0, 0};
    private static final int[] b1 = new int[]{2, 4, 6};
    private static final int[] expected1 = new int[]{1, 2, 3, 4, 5, 6};

    private static final int[] a2 = new int[]{5, 0, 0, 0, 0, 0};
    private static final int[] b2 = new int[]{1, 2, 3, 4, 6};
    private static final int[] expected2 = new int[]{1, 2, 3, 4, 5, 6};

    private static final int[] a3 = new int[]{1,2,3,0,0,0};
    private static final int[] b3 = new int[]{2,5,6};
    private static final int[] expected3= new int[]{1,2,2,3,5,6};

    private static final int[] a4 = new int[]{1};
    private static final int[] b4 = new int[]{};
    private static final int[] expected4= new int[]{1};

    private static final MergeArray mergeArray = new MergeArray();

    @Test
    void testMerge() {
        int[] expected = mergeArray.merge(a1, b1);
        Assertions.assertArrayEquals(expected, expected1);

        expected = mergeArray.merge(a2, b2);
        Assertions.assertArrayEquals(expected, expected2);

        expected = mergeArray.merge(a3, b3);
        Assertions.assertArrayEquals(expected, expected3);

        expected = mergeArray.merge(a4, b4);
        Assertions.assertArrayEquals(expected, expected4);
    }

}
