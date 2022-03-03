package com.coding.interview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class VerticalOrderTraversalBTTest {

    private static final VerticalOrderTraversalBT tree = new VerticalOrderTraversalBT();

    private final TreeNode n05 = new TreeNode(7);
    private final TreeNode n04 = new TreeNode(15);
    private final TreeNode n03 = new TreeNode(20, n04, n05);
    private final TreeNode n02 = new TreeNode(9);
    private final TreeNode n01 = new TreeNode(3, n02, n03);

    private final List<List<Integer>> expected1 = Arrays.asList(
            Arrays.asList(9),
            Arrays.asList(3, 15),
            Arrays.asList(20),
            Arrays.asList(7)
    );

    private final TreeNode n16 = new TreeNode(2);
    private final TreeNode n15 = new TreeNode(2);
    private final TreeNode n14 = new TreeNode(0);
    private final TreeNode n13 = new TreeNode(4, n16, null);
    private final TreeNode n12 = new TreeNode(1, n14, n15);
    private final TreeNode n11 = new TreeNode(3, n12, n13);

    private final List<List<Integer>> expected2 = Arrays.asList(
            Arrays.asList(0),
            Arrays.asList(1),
            Arrays.asList(3, 2, 2),
            Arrays.asList(4)
    );

    @Test
    public void testVerticalTraversal() {
        List<List<Integer>> actual = tree.verticalTraversal(n01);
        Assertions.assertEquals(expected1, actual);

        actual = tree.verticalTraversal(n11);
        Assertions.assertEquals(expected2, actual);
    }
}
