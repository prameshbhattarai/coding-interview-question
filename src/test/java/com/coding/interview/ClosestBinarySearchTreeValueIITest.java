package com.coding.interview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ClosestBinarySearchTreeValueIITest {

    private final ClosestBinarySearchTreeValueII bst1 = new ClosestBinarySearchTreeValueII();
    private final ClosestBinarySearchTreeValueII bst2 = new ClosestBinarySearchTreeValueII();
    private final ClosestBinarySearchTreeValueII bst3 = new ClosestBinarySearchTreeValueII();

    private final TreeNode n16 = new TreeNode(4);
    private final TreeNode n15 = new TreeNode(6, n16, null);
    private final TreeNode n14 = new TreeNode(1);
    private final TreeNode n13 = new TreeNode(10);
    private final TreeNode n12 = new TreeNode(3, n14, n15);
    private final TreeNode n11 = new TreeNode(8, n12, n13);

    /*
               8
             /   \
            3    10
          /   \
         1     6
                \
                 4
     */

    @Test
    public void search() {
        Assertions.assertEquals(Arrays.asList(3, 4), bst1.search(n11, 3.6, 2));
        Assertions.assertEquals(Arrays.asList(1, 3, 4),  bst2.search(n11, 3.5, 3));
        Assertions.assertEquals(Arrays.asList(4, 6, 8, 10),  bst3.search(n11, 7.2, 4));
    }
}
