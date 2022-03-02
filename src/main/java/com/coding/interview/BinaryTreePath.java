package com.coding.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return all root-to-leaf paths.
 *
 *  For example, given the following binary tree:
 *
 *       1
 *     /  \
 *    2    3
 *     \
 *      5
 *  All root-to-leaf paths are:
 *
 *  ["1->2->5", "1->3"]
 */
public class BinaryTreePath {

    /*
    We need to find all the path from root to leaf node.
    Approach: We can use pre-order traversing, to find path from root to leaf node.

    In each node traverse, we will store current visiting path.
    So after we reach to leaf node we will have entire visited path.
     */
    public List<String> findPath(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null) return paths;
        preOrderPathTraverse("", root, paths);
        return paths;
    }

    private void preOrderPathTraverse(String pathBuilder, TreeNode root, List<String> paths) {
        if (root.left == null && root.right == null) {
            paths.add(pathBuilder + root.val);
        }

        // append current visited node in the path builder
        if (root.left != null) {
            preOrderPathTraverse(pathBuilder + root.val + "->", root.left, paths);
        }

        // append current visited node in the path builder
        if (root.right != null) {
            preOrderPathTraverse(pathBuilder + root.val + "->", root.right, paths);
        }
    }
}
