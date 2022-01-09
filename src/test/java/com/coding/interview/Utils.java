package com.coding.interview;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Utils {

    private Utils() {}

    public static boolean containsAll(List<int[]> expected, List<int[]> actual) {
        if (expected.size() != actual.size()) return false;

        Function<int[], Boolean> contains = (int[] array) -> {
            for (int[] ints : actual) {
                if (Arrays.equals(ints, array)) {
                    return true;
                }
            }
            return false;
        };

        for (int[] ints : expected) {
            if (!contains.apply(ints)) return false;
        }
        return true;
    }
}
