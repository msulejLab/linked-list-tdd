package com.msulej.linkedlist;

public class List {
    private Node start;

    public List(String... initValues) {

    }

    public Node find(String value) {
        return start;
    }

    public void add(String value) {
        if (!hasStartNode()) {
            start = new Node(value);
        }
    }

    private boolean hasStartNode() {
        return start != null;
    }
}
