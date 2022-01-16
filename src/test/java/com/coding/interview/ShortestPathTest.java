package com.coding.interview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ShortestPathTest {

    static final Node<Integer> node1 = new Node<>(1);
    static final Node<Integer> node2 = new Node<>(2);
    static final Node<Integer> node3 = new Node<>(3);
    static final Node<Integer> node4 = new Node<>(4);
    static final Node<Integer> node5 = new Node<>(5);

    static Node<Integer> root = createTree();

    public static Node<Integer> createTree() {

        node1.addChildren(node2);
        node1.addChildren(node3);

        node2.addChildren(node5);

        node5.addChildren(node4);

        node4.addChildren(node3);
        node4.addChildren(node1);
        return node1;
    }

    private final List<Integer> expectedPath = Arrays.asList(2, 5, 4, 3);

    private static final ShortestPath shortestPath = new ShortestPath();

    @Test
    public void findShortestPathBFS() {
        List<Integer> actualPath = shortestPath.shortestPathBFS(node2, node3);
        Assertions.assertEquals(expectedPath, actualPath);
    }

    @Test
    public void findShortestPathDFS() {
        List<Integer> actualPath = shortestPath.shortestPathDFS(node2, node3);
        Assertions.assertEquals(expectedPath, actualPath);
    }
}
