package com.msulej.linkedlist;

public class ListBuilder implements Builder<List> {

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

    public ListBuilder withValues(String ... values) {
        this.values = values;
        return this;
    }
}
