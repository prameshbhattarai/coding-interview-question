package com.coding.interview;

import java.util.*;

/**
 * Given a directed graph, find the shortest path between two nodes if one exists.
 *
 * eg.
 *
 * 1 -> 2
 * 1 -> 3
 * 2 -> 5
 * 4 -> 3
 * 5 -> 4
 */
public class ShortestPath {

    public List<Integer> shortestPathBFS(Node<Integer> source, Node<Integer> destination) {
        if (source == null || destination == null) return null;
        if(source == destination) return null;

        Queue<Node<Integer>> queue = new ArrayDeque<>();
        queue.add(source);

        Map<Integer, Integer> traversePath = new HashMap<>();
        traversePath.put(source.getValue(), null);

        while(!queue.isEmpty()) {
            Node<Integer> current = queue.remove();
            if(current.equals(destination)) break;

            for (Node<Integer> child : current.getChildren()) {
                if (!traversePath.containsKey(child.getValue())) {
                    queue.add(child);
                    traversePath.put(child.getValue(), current.getValue());
                }
            }
        }

        return createTraversePath(destination, traversePath);
    }

    public List<Integer> shortestPathDFS(Node<Integer> source, Node<Integer> destination) {
        if (source == null || destination == null) return null;
        if(source == destination) return null;

        Stack<Node<Integer>> stack = new Stack<>();
        stack.add(source);

        Map<Integer, Integer> traversePath = new HashMap<>();
        traversePath.put(source.getValue(), null);

        while(!stack.isEmpty()) {
            Node<Integer> current = stack.pop();
            if(current.equals(destination)) break;

            for (Node<Integer> child : current.getChildren()) {
                if (!traversePath.containsKey(child.getValue())) {
                    stack.push(child);
                    traversePath.put(child.getValue(), current.getValue());
                }
            }
        }

        return createTraversePath(destination, traversePath);
    }

    private List<Integer> createTraversePath(Node<Integer> destination, Map<Integer, Integer> traversePath) {
        if(!traversePath.containsKey(destination.getValue())) return null;

        List<Integer> path = new LinkedList<>();
        Integer next = destination.getValue();
        while (traversePath.containsKey(next)) {
            path.add(0, next);
            next = traversePath.get(next);
        }

        return path;
    }
}
