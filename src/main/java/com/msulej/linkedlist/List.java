package com.msulej.linkedlist;

public class List {
    private Node start;

    public List(String... initValues) {
        for (String value : initValues) {
            add(value);
        }
    }

    public Node find(String value) {
        return start;
    }

    public void add(String value) {
        Node node = new Node(value);

        if (!hasStartNode()) {
            start = node;
        } else {
            last().next(node);
        }
    }

    public Node last() {
        Node node = start;

        while (node.next() != null) {
            node = node.next();
        }

        return node;
    }

    private boolean hasStartNode() {
        return start != null;
    }

    public int size() {
        Node node = start;
        int size = 0;

        if (node != null) {
            size = 1;
        }

        while (node != null) {
            node = node.next();
            size += 1;
        }

        return size;
    }
}
