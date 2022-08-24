package com.coding.interview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RangeSumBSTTest {

    private static final RangeSumBST rangeSumBST = new RangeSumBST();

    private static final TreeNode rootNode1 = createRoot1();

    @Test
    public void testRange() {
        Assertions.assertEquals(32, rangeSumBST.rangeSumBST(rootNode1, 7, 15));
        Assertions.assertEquals(32, rangeSumBST.rangeSumBSTDfs(rootNode1, 7, 15));
    }

    private static TreeNode createRoot1() {
        TreeNode ten = new TreeNode(10);
        TreeNode five = new TreeNode(5);
        TreeNode three = new TreeNode(3);
        TreeNode seven = new TreeNode(7);
        TreeNode fifteen = new TreeNode(15);
        TreeNode eighteen = new TreeNode(18);

        ten.left = five;
        ten.right = fifteen;

        five.left = three;
        five.right = seven;

        fifteen.right = eighteen;

        return ten;
    }
}
