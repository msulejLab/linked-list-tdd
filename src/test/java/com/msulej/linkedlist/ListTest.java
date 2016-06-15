package com.msulej.linkedlist;

import org.junit.Test;

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

    private List a(ListBuilder builder) {
        return builder.build();
    }

    private ListBuilder list() {
        return new ListBuilder();
    }
}
