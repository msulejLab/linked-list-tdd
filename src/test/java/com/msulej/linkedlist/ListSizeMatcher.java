package com.msulej.linkedlist;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

public class ListSizeMatcher extends TypeSafeMatcher<List> {

    private int expectedSize;

    public ListSizeMatcher(int expectedSize) {
        this.expectedSize = expectedSize;
    }

    @Override
    protected boolean matchesSafely(List list) {
        return list.size() == expectedSize;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("list of size ").appendValue(expectedSize);
    }

    @Override
    protected void describeMismatchSafely(List item, Description mismatchDescription) {
        mismatchDescription.appendText("list of size ").appendValue(item.size());
    }

    public static ListSizeMatcher hasSizeOf(int expectedSize) {
        return new ListSizeMatcher(expectedSize);
    }
}
