package com.coding.interview;

import java.util.*;

/**
 * Given the root of a binary tree, calculate the vertical order traversal of the binary tree.
 *
 * For each node at position (row, col), its left and right children will be at positions (row + 1, col - 1) and (row + 1, col + 1) respectively. The root of the tree is at (0, 0).
 *
 * The vertical order traversal of a binary tree is a list of top-to-bottom orderings for each column index starting from the leftmost column and ending on the rightmost column. There may be multiple nodes in the same row and same column. In such a case, sort these nodes by their values.
 *
 * Return the vertical order traversal of the binary tree.
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[9],[3,15],[20],[7]]
 * Explanation:
 * Column -1: Only node 9 is in this column.
 * Column 0: Nodes 3 and 15 are in this column in that order from top to bottom.
 * Column 1: Only node 20 is in this column.
 * Column 2: Only node 7 is in this column.
 *
 * Input: root = [1,2,3,4,5,6,7]
 * Output: [[4],[2],[1,5,6],[3],[7]]
 * Explanation:
 * Column -2: Only node 4 is in this column.
 * Column -1: Only node 2 is in this column.
 * Column 0: Nodes 1, 5, and 6 are in this column.
 *           1 is at the top, so it comes first.
 *           5 and 6 are at the same position (2, 0), so we order them by their value, 5 before 6.
 * Column 1: Only node 3 is in this column.
 * Column 2: Only node 7 is in this column.
 *
 * Input: root = [1,2,3,4,6,5,7]
 * Output: [[4],[2],[1,5,6],[3],[7]]
 * Explanation:
 * This case is the exact same as example 2, but with nodes 5 and 6 swapped.
 * Note that the solution remains the same since 5 and 6 are in the same location and should be ordered by their values.
 *
 * https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
 */
public class VerticalOrderTraversalBT {

    /*
    Approach:
    First we will traverse entire graph using DFS and create a Tuples with value, row, column
    and store it in PriorityQueue

    Priority order in queue
    if row are not same, then sort by comparing row order
    if row are same but column are not, then sort by comparing column order
    if both are same, then sort by value
     */

    private static class Tuples {
        int value;
        int row;
        int column;

        Tuples(int value, int row, int column) {
            this.value = value;
            this.row = row;
            this.column = column;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> orderedList = new ArrayList<>();

        if (root == null) return orderedList;

        PriorityQueue<Tuples> queue = new PriorityQueue<>(new Comparator<Tuples>() {
            @Override
            public int compare(Tuples o1, Tuples o2) {

                // if row are not same, then sort by comparing row order
               if(o1.row < o2.row) return  -1;
               if(o1.row > o2.row) return  1;

               // if row are same but column are not, then sort by comparing column order
               if(o1.column < o2.column) return  -1;
               if(o1.column > o2.column) return 1;

               // if both are same, then sort by value
               return o1.value - o2.value;
            }
        });

        traverseByDFS(queue, root, 0, 0);

        // now fetch all the value from queue which are already sorted
        // and group by column
        Map<Integer, List<Integer>> lookup = new TreeMap<>();
        while (!queue.isEmpty()) {
            Tuples tuples = queue.poll();
            lookup.putIfAbsent(tuples.column, new ArrayList<>());
            lookup.get(tuples.column).add(tuples.value);
        }

        orderedList.addAll(lookup.values());
        return orderedList;
    }

    // traverse the graph and insert values in priority queue
    private void traverseByDFS(PriorityQueue<Tuples> queue, TreeNode root, int row, int column) {
        if (root == null) return;
        queue.add(new Tuples(root.val, row, column));
        traverseByDFS(queue, root.left, row + 1, column - 1);
        traverseByDFS(queue, root.right, row + 1, column + 1);
    }
}
