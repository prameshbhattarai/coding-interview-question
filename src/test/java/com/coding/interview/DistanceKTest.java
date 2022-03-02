package com.coding.interview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DistanceKTest {

    private static final DistanceK.HashMapAndBFS HASH_MAP_AND_BFS = new DistanceK.HashMapAndBFS();

    private final TreeNode n0 = new TreeNode(0);
    private final TreeNode n8 = new TreeNode(8);
    private final TreeNode n1 = new TreeNode(1, n0, n8);
    private final TreeNode n6 = new TreeNode(6);
    private final TreeNode n7 = new TreeNode(7);
    private final TreeNode n4 = new TreeNode(4);
    private final TreeNode n2 = new TreeNode(2, n7, n4);
    private final TreeNode n5 = new TreeNode(5, n6, n2);
    private final TreeNode n3 = new TreeNode(3, n5, n1);

    @Test
    public void testUsingBFS() {
        List<Integer> results = HASH_MAP_AND_BFS.distanceK(n3, n5, 2);
        Assertions.assertEquals(Arrays.asList(7, 4, 1), results);

        results = HASH_MAP_AND_BFS.distanceK(n4, n4, 3);
        Assertions.assertEquals(new ArrayList<>(), results);
    }

}
