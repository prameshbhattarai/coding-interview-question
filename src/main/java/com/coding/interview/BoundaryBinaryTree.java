package com.coding.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

/**
 * Given a binary tree, return the values of its boundary in anti-clockwise direction starting from root.
 * Boundary includes left boundary, leaves, and right boundary in order without duplicate nodes.
 * (The values of the nodes may still be duplicates.)
 *
 * Left boundary is defined as the path from root to the left-most node.
 * Right boundary is defined as the path from root to the right-most node.
 * If the root doesn’t have left subtree or right subtree,
 * then the root itself is left boundary or right boundary.
 *
 * Note this definition only applies to the input binary tree, and not applies to any subtrees.
 *
 * The left-most node is defined as a leaf node you could reach when you always firstly travel to the left subtree if exists.
 * If not, travel to the right subtree. Repeat until you reach a leaf node.
 *
 * The right-most node is also defined by the same way with left and right exchanged.
 *
 * Input:
 *   1
 *    \
 *     2
 *    / \
 *   3   4
 *
 * Ouput:
 * [1, 3, 4, 2]
 *
 * Input:
 *     ____1_____
 *    /          \
 *   2            3
 *  / \          /
 * 4   5        6
 *    / \      / \
 *   7   8    9  10
 *
 * Ouput:
 * [1,2,4,7,8,9,10,6,3]
 */
public class BoundaryBinaryTree {

    /*
    Approach:

    First we will traverse all the left most node from the graph.
    And store it in the list.
    But not the leaf nodes.

    Then we will list all the leaf nodes of the graph, using DFS.

    Then we will traverse all the right most node from the graph. But not the leaf nodes.
    And store it in the stack, so that when we pop the nodes from stack, we will maintain the order.

    Then pop each node from stack and store it in the list.

    And return the list.


    Then
     */

    Predicate<TreeNode> isLeafNode = (node) -> node.left == null && node.right == null;

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;

        // store the root node in the list
        list.add(root.val);

        // first traverse the graph and store all the left most nodes.
        TreeNode node = root.left;

        while (node != null) {
            if (!isLeafNode.test(node)) list.add(node.val);
            if (node.left != null) node = node.left;
            else node = node.right;
        }

        // get all the leaf nodes using DFS
        storeLeafNodesDFS(root, list);

        // now traverse the graph and store all the right most nodes in Stack
        Stack<Integer> stack = new Stack<>();
        node = root.right;
        while (node != null) {
            if (!isLeafNode.test(node)) stack.push(node.val);
            if (node.right != null) node = node.right;
            else node = node.left;
        }

        // now get all the value from stack and store it into the list
        while(!stack.isEmpty()) {
            list.add(stack.pop());
        }

        // return all the values from list
        return list;
    }

    private void storeLeafNodesDFS(TreeNode node, List<Integer> list) {
        if (isLeafNode.test(node)) list.add(node.val);
        if (node == null) return;
        if (node.left != null) storeLeafNodesDFS(node.left, list);
        if (node.right != null) storeLeafNodesDFS(node.right, list);
    }
}
