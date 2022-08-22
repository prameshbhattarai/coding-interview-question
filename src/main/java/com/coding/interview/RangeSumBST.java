package com.coding.interview;

import java.util.Stack;

/**
 * Given the root node of a binary search tree and two integers low and high,
 * return the sum of values of all nodes with a value in the inclusive range [low, high].
 *
 * Input: root = [10,5,15,3,7,null,18], low = 7, high = 15
 * Output: 32
 * Explanation: Nodes 7, 10, and 15 are in the range [7, 15]. 7 + 10 + 15 = 32.
 */
public class RangeSumBST {

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;

        int sum = 0;
        // if the value is with in range then sum it up...
        if(low <= root.val && root.val <= high) sum += root.val;

        // if val is greater than low.. then traverse left nodes..
        // it will return the sum.. if found any with in the range..
        if (root.val > low) sum += rangeSumBST(root.left, low, high);

        // if val is less than the high.. then traverse right nodes...
        // it will return the sum.. if found any with un the range,,,
        if (root.val < high) sum += rangeSumBST(root.right, low, high);

        return sum;
    }

    public int rangeSumBSTDfs(TreeNode root, int low, int high) {
        int sum = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            if (current != null) {
                if (current.val > low) stack.push(current.left);
                if (current.val < high) stack.push(current.right);

                if(low <= current.val && current.val <= high) sum += current.val;
            }
        }
        return sum;
    }

}
