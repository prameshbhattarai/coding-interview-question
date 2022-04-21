package com.coding.interview;

/**
 * Given two integer arrays preorder and inorder where preorder is the preorder traversal
 * of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.
 * <p>
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 * <p>
 * Input: preorder = [-1], inorder = [-1]
 * Output: [-1]
 */
public class BinaryTreeFromPreAndInorder {

    /*
    We have preorder and inorder traversal

    in preorder the first element is always the root
    and in inorder all the left element of root are left child and all the right element of root are right child

    we will get all the left child elements and right child elements
    now recursively look into the left child elements and right child elements
    */

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight) return null;

        // rootIndex contain the root element
        int rootIndex = inLeft;

        // finding the root node in inorder traverse
        while (rootIndex < inRight) {
            if (preorder[preLeft] == inorder[rootIndex]) break;
            rootIndex++;
        }

        // now create TreeNode
        TreeNode root = new TreeNode(preorder[preLeft]);

        // now create the left child node of root
        root.left = buildTree(preorder, preLeft + 1, preLeft + (rootIndex - inLeft), inorder, inLeft, rootIndex - 1);

        // now create the right child node of root
        root.right = buildTree(preorder, preLeft + (rootIndex - inLeft) + 1, preRight, inorder, rootIndex + 1, inRight);

        return root;

    }
}
