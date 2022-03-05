package com.coding.interview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class BoundaryBinaryTreeTest {

    private static final BoundaryBinaryTree tree = new BoundaryBinaryTree();

    private final TreeNode n04 = new TreeNode(4);
    private final TreeNode n03 = new TreeNode(3);
    private final TreeNode n02 = new TreeNode(2, n03, n04);
    private final TreeNode n01 = new TreeNode(1, null, n02);

    private final List<Integer> expectedPath1 = Arrays.asList(1, 3, 4, 2);

    private final TreeNode n110 = new TreeNode(10);
    private final TreeNode n19 = new TreeNode(9);
    private final TreeNode n18 = new TreeNode(8);
    private final TreeNode n17 = new TreeNode(7);
    private final TreeNode n16 = new TreeNode(6, n19, n110);
    private final TreeNode n15 = new TreeNode(5, n17, n18);
    private final TreeNode n14 = new TreeNode(4);
    private final TreeNode n13 = new TreeNode(3, n16, null);
    private final TreeNode n12 = new TreeNode(2, n14, n15);
    private final TreeNode n11 = new TreeNode(1, n12, n13);

    private final List<Integer> expectedPath2 = Arrays.asList(1, 2, 4, 7, 8, 9, 10, 6, 3);

    @Test
    public void testBoundary() {
        List<Integer> actual = tree.boundaryOfBinaryTree(n01);
        Assertions.assertEquals(expectedPath1, actual);

        actual = tree.boundaryOfBinaryTree(n11);
        Assertions.assertEquals(expectedPath2, actual);
    }
}
