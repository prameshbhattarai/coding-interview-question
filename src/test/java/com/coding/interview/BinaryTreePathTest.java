package com.coding.interview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class BinaryTreePathTest {

    private static final BinaryTreePath binaryTreePath = new BinaryTreePath();

    private final TreeNode n05 = new TreeNode(5);
    private final TreeNode n03 = new TreeNode(3);
    private final TreeNode n02 = new TreeNode(2, null, n05);
    private final TreeNode n01 = new TreeNode(1, n02, n03);

    private final List<String> expectedPath1 = Arrays.asList("1->2->5", "1->3");

    private final TreeNode n16 = new TreeNode(2);
    private final TreeNode n15 = new TreeNode(5);
    private final TreeNode n14 = new TreeNode(3);
    private final TreeNode n13 = new TreeNode(2, n16, null);
    private final TreeNode n12 = new TreeNode(8, n14, n15);
    private final TreeNode n11 = new TreeNode(10, n12, n13);

    private final List<String> expectedPath2 = Arrays.asList("10->8->3", "10->8->5", "10->2->2");

    @Test
    public void findPath() {
        List<String> actualPath = binaryTreePath.findPath(n01);
        Assertions.assertEquals(expectedPath1, actualPath);

        actualPath = binaryTreePath.findPath(n11);
        Assertions.assertEquals(expectedPath2, actualPath);
    }
}
