package com.coding.interview;

import java.util.ArrayList;
import java.util.List;

public class Node<T> {
    private final T value;
    private List<Node<T>> children;

    public Node(T value) {
        this.value = value;
    }

    public List<Node<T>> addChildren(Node<T> child) {
        if (this.children == null) this.children = new ArrayList<>();
        this.children.add(child);
        return children;
    }

    public T getValue() {
        return value;
    }

    public List<Node<T>> getChildren() {
        return children;
    }
}
