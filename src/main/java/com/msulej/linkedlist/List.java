package com.msulej.linkedlist;

public class List {
    private Node start;

    public List(String... initValues) {
        addValuesToList(initValues);
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

    public Node last() {
        Node node = start;

        while (node.hasNext()) {
            node = node.next();
        }

        return node;
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

    public Node delete(String value) {
        Node node = start;
        Node nextNode = null;

        if (start != null) {
            if (start.value().equals(value)) {
                return deleteFirstNode();
            }
        }

        while (node != null) {
            if (!node.hasNext()) {
                return null;
            }

            nextNode = node.next();
            if (nextNode.value().equals(value)) {
                node.next(nextNode.next());
                return nextNode;
            }

            node = nextNode;
        }
        return node;
    }

    private Node deleteFirstNode() {
        Node oldStart = start;
        start = oldStart.next();
        return oldStart;
    }

    private void addValuesToList(String[] initValues) {
        for (String value : initValues) {
            add(value);
        }
    }

    private void updateLastNode(Node node) {
        last().next(node);
    }

    private boolean hasStartNode() {
        return start != null;
    }

    public Node get(int index) {
        Node node = start;

        int currentIndex = 0;
        while (node != null) {
            if (currentIndex == index) {
                return node;
            }

            node = node.next();
            currentIndex += 1;
        }

        return null;
    }
}
