package com.coding.interview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ClosestBinarySearchTreeValueTest {

    private static final ClosestBinarySearchTreeValue bst = new ClosestBinarySearchTreeValue();

    private final TreeNode n16 = new TreeNode(4);
    private final TreeNode n15 = new TreeNode(6, n16, null);
    private final TreeNode n14 = new TreeNode(1);
    private final TreeNode n13 = new TreeNode(10);
    private final TreeNode n12 = new TreeNode(3, n14, n15);
    private final TreeNode n11 = new TreeNode(8, n12, n13);

    @Test
    public void search() {
        Assertions.assertEquals(4, bst.search(n11, 3.6));
        Assertions.assertEquals(3, bst.search(n11, 3.5));
        Assertions.assertEquals(8, bst.search(n11, 7.2));
    }
}
