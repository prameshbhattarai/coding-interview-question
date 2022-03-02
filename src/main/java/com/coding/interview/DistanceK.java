package com.coding.interview;

import java.util.*;
import java.util.stream.Collectors;

/**
 * All Nodes Distance K in Binary Tree
 * <p>
 * Given the root of a binary tree, the value of a target node target, and an integer k, return an array of the values of all nodes that have a distance k from the target node.
 * <p>
 * You can return the answer in any order.
 * <p>
 * https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
 */
public class DistanceK {

    public static class HashMapAndBFS {
        /*
            Converting the binary uni-direction tree to graph
            as we need to find the distance towards parent also

            so we will first find the parent of each node (or upto target node)

            then we will do BFS from target, we will push left, right and parent into the queue
            and the distance K will be the level of the BFS

            so if we are at K level then all the remaining child nodes are in the distance of K
            we will return all the child nodes as All Nodes Distance at K
         */

        public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
            Map<TreeNode, TreeNode> parentMap = new HashMap<>();
            buildParentOfEachNode(root, null, parentMap);

            // do BFS from target node
            // traverse from target node to level (K)

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(target);

            Set<TreeNode> visitedNode = new HashSet<>();
            visitedNode.add(target);
            int level = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();

                if (level == k) {
                    // we are at the distance of k, return all the elements from queue as list
                    return queue.stream().map((node) -> node.val).collect(Collectors.toList());
                }

                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.remove();
                    if (node.left != null && !visitedNode.contains(node.left)) {
                        queue.add(node.left);
                        visitedNode.add(node.left);
                    }

                    if (node.right != null && !visitedNode.contains(node.right)) {
                        queue.add(node.right);
                        visitedNode.add(node.right);
                    }

                    TreeNode parentNode = parentMap.get(node);
                    if (parentNode != null && !visitedNode.contains(parentNode)) {
                        queue.add(parentNode);
                        visitedNode.add(parentNode);
                    }
                }

                level++;
            }
            return new ArrayList<>();
        }

        private void buildParentOfEachNode(TreeNode root, TreeNode parent, Map<TreeNode, TreeNode> parentMap) {
            if (root == null) return;
            if (!parentMap.containsKey(root)) {
                parentMap.put(root, parent);
            }
            buildParentOfEachNode(root.left, root, parentMap);
            buildParentOfEachNode(root.right, root, parentMap);
        }
    }

}
