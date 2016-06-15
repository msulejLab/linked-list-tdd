package com.msulej.linkedlist;

public class ListBuilder {

    private String[] values;

    public ListBuilder withoutAnyValues() {
        values = new String[0];
        return this;
    }

    public List build() {
        return new List(values);
    }

    public static ListBuilder list() {
        return new ListBuilder();
    }
}
