package com.msulej.linkedlist;

public class List {
    private Node start;

    public List(String... initValues) {
        for (String value : initValues) {
            add(value);
        }
    }

    public Node find(String value) {
        Node node = start;

        while (node != null) {
            if (node.value().equals(value)) {
                return node;
            }

            node = node.next();
        }

        return null;
    }

    public void add(String value) {
        Node node = new Node(value);

        if (!hasStartNode()) {
            start = node;
        } else {
            updateLastNode(node);
        }
    }

    private void updateLastNode(Node node) {
        last().next(node);
    }

    public Node last() {
        Node node = start;

        while (node.hasNext()) {
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
        } else {
            return size;
        }

        while (node.hasNext()) {
            size += 1;
            node = node.next();
        }

        return size;
    }

    public String[] values() {
        String[] values = new String[size()];

        Node node = start;

        int index = 0;
        while (node != null) {
            values[index] = node.value();
            node = node.next();
            index += 1;
        }

        return values;
    }

    public void delete(String value) {
        Node node = start;
        Node nextNode = null;

        while (node != null) {
            if (!node.hasNext()) {
                return;
            }

            nextNode = node.next();
            if (nextNode.value().equals(value)) {
                node.next(nextNode.next());
            }

            node = nextNode;
        }
    }
}
