package com.coding.interview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UniquePathsTest {

    private static final UniquePaths uniquePaths = new UniquePaths();
    
    @Test
    public void test() {
        Assertions.assertEquals(28, uniquePaths.numberOfPaths(3, 7));
        Assertions.assertEquals(3, uniquePaths.numberOfPaths(3, 2));
    }
}
