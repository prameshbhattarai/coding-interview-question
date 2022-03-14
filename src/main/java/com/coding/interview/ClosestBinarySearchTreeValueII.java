package com.coding.interview;

import java.util.*;

/**
 * Given a non-empty binary search tree and a target value,
 *  find k values in the BST that are closest to the target.
 *
 *  Example:
 *
 *  Input: root = [4,2,5,1,3], target = 3.714286, and k = 2
 *
 *     4
 *    / \
 *   2   5
 *  / \
 * 1   3
 *
 *  Output: [4,3]
 *
 *  Note:
 *
 *  Given target value is a floating point.
 *  You may assume k is always valid, that is: k ≤ total nodes.
 *  You are guaranteed to have only one unique set of k values in the BST that are closest to the target.
 *
 *  Follow up:
 *  Assume that the BST is balanced, could you solve it in less than O(n) runtime (where n = total nodes)?
 */
public class ClosestBinarySearchTreeValueII {

    // we will treat closestValues linkedList as a queue
    private final LinkedList<Integer> closestValues = new LinkedList<>();

    /*
    Approach:
    Traverse the BST in in-order .. so that we will get closest values in increasing order (Ascending order)
    insert each node value in LinkedList
    why ? it will be easy to add and remove first and last element in linked list
     */
    public List<Integer> search(TreeNode root, double target, int k) {
        find(root, target, k);
        return closestValues;
    }

    private void find(TreeNode root, double target, int k) {
        if (root == null) return;

        find(root.left, target, k);
        if (closestValues.size() < k) {
            closestValues.add(root.val);
        } else if (closestValues.size() == k) {
            // as we are traversing the BST in in-order
            // we have already inserted node with smallest value in the list
            // as in BST left sub tree will contain smaller values than in right sub trees

            // get the first value of list and compare it with current root value
            // if the diff between root value is less than first value
            // remove the fist value and insert root value at the last
            // we are treating list as a queue

            if (Math.abs(root.val - target) < Math.abs(closestValues.getFirst() - target)) {
                closestValues.removeFirst();
                closestValues.addLast(root.val);
            } else return;
        }
        find(root.right, target, k);
    }
}
