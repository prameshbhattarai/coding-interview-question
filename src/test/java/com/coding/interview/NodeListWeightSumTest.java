package com.coding.interview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class NodeListWeightSumTest {

    private static final NestedListWeightSum nestedListWeightSum = new NestedListWeightSum();


    private static final List<Node<Integer>> input1 = createInput1();
    private static final List<Node<Integer>> input2 = createInput2();

    @Test
    public void weightSumTest() {
        Assertions.assertEquals(10, nestedListWeightSum.weightSum(input1));
        Assertions.assertEquals(27, nestedListWeightSum.weightSum(input2));
        Assertions.assertEquals(27, nestedListWeightSum.weightSum(input2));
    }

    private static List<Node<Integer>> createInput2() {
        Node<Integer> node3 = new Node<>(6);

        Node<Integer> node2 = new Node<>(4);
        node2.addChildren(node3);

        Node<Integer> node1 = new Node<>(1);
        node1.addChildren(node2);

        List<Node<Integer>> input = new ArrayList<>();
        input.add(node1);
        return input;

    }

    private static List<Node<Integer>> createInput1() {
        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);

        Node<Integer> nodeList1 = new Node<>();
        nodeList1.addChildren(node1);
        nodeList1.addChildren(node1);

        Node<Integer> nodeList2 = new Node<>();
        nodeList1.addChildren(node1);
        nodeList1.addChildren(node1);

        List<Node<Integer>> input = new ArrayList<>();
        input.add(nodeList1);
        input.add(node2);
        input.add(nodeList2);
        return input;

    }

}
