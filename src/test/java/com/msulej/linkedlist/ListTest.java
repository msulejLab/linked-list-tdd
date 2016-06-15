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

        assertThat(listNode, equalTo(listNode.value()));
    }

    private List a(ListBuilder builder) {
        return builder.build();
    }
}
