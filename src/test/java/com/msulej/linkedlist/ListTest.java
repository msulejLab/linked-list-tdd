package com.msulej.linkedlist;

import org.junit.Test;

import static com.msulej.linkedlist.ListBuilder.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;


public class ListTest {

    @Test
    public void itCompiles() {
        assertThat(true, is(true));
    }

    @Test
    public void shouldNotFindNodeInEmptyList() {
        List theList = a(list().withoutAnyValues());

        Node listNode = theList.find("fred");

        assertThat(listNode, is(nullValue()));
    }

    @Test
    public void shouldAddAndFindSpecificValue() {
        List theList = a(list().withoutAnyValues());

        theList.add("fred");

        Node listNode = theList.find("fred");

        assertThat("fred", equalTo(listNode.value()));
    }

    @Test
    public void shouldReturnCorrectSize() {
        List emptyList = a(list().withoutAnyValues());
        List filledList = a(list().withValues("fred", "wilma"));

        assertThat(emptyList, ListSizeMatcher.hasSizeOf(0));
        assertThat(filledList, ListSizeMatcher.hasSizeOf(3));
    }

    private List a(ListBuilder builder) {
        return builder.build();
    }
}