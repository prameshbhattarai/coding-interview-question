package com.coding.interview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BinaryTreeFromPreAndInorderTest {

    private static final BinaryTreeFromPreAndInorder binaryTree = new BinaryTreeFromPreAndInorder();

    private static final int[] preOrder1 = new int[] {3,9,20,15,7};
    private static final int[] inorder1 = new int[] {9,3,15,20,7};

    private final TreeNode n06 = new TreeNode(7);
    private final TreeNode n05 = new TreeNode(15);
    private final TreeNode n03 = new TreeNode(20, n05, n06);
    private final TreeNode n02 = new TreeNode(9, null, null);
    private final TreeNode n01 = new TreeNode(3, n02, n03);

    @Test
    public void test() {
        TreeNode actualNode = binaryTree.buildTree(preOrder1, inorder1);
        Assertions.assertEquals(n01, actualNode);
    }
}
