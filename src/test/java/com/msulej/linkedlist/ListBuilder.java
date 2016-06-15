package com.msulej.linkedlist;

public class ListBuilder {

    public static final int VALUES_BUFFER = 20;

    String[] values = new String[VALUES_BUFFER];

    public ListBuilder withoutAnyValues() {
        return this;
    }

    public List build() {
        return new List();
    }

    public static ListBuilder list() {
        return new ListBuilder();
    }
}
