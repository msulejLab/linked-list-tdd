package com.msulej.linkedlist;

public class Node {

    private String value;
    private Node next;

    public Node(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

    public void next(Node next) {
        this.next = next;
    }

    public Node next() {
        return next;
    }

    public boolean hasNext() {
        return next != null;
    }
}
