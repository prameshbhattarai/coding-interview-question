package com.coding.interview;

/**
 * Closest Binary Search Tree Value
 *
 *  Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.
 *
 *  Note:
 *      Given target value is a floating point.
 *      You are guaranteed to have only one unique value in the BST that is closest to the target.
 */
public class ClosestBinarySearchTreeValue {

    /*
    BinarySearchTree store value in leftValue < rootValue < rightValue
    So our approach will be recursively traverse the BST to the leafNode
    and find the closest value of target

    first we go to the leaf node and find the closest value in each recursive call

    closestTillNow will contain the closest value from each recursive call
     */
    public int search(TreeNode root, double target) {
        TreeNode nextRoot = target < root.val ? root.left : root.right;
        // if nextRoot is null, then return the value of leaf node
        if (nextRoot == null) return root.val; // this is leaf node value

        int closestTillNow = search(nextRoot, target);
        // find the closest value of target
        // it can be closestTillNow or root node of the current recursive call
        return Math.abs(closestTillNow - target) < Math.abs(root.val - target) ? closestTillNow : root.val;
    }
}
