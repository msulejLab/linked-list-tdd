package com.msulej.linkedlist;

public class ListBuilder {

    String[] values = new String[20];

    public ListBuilder withoutAnyValues() {
        return this;
    }

    public List build() {
        return new List();
    }
}
