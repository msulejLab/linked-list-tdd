package com.msulej.linkedlist;

public class List {
    private Node start;

    public Node find(String value) {
        return start;
    }

    public void add(String value) {
        if (start == null) {
            start = new Node(value);
        }
    }
}
