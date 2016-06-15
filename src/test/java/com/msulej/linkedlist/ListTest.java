package com.msulej.linkedlist;

import org.hamcrest.core.IsNot;
import org.junit.Test;

import static com.msulej.linkedlist.ListBuilder.*;
import static com.msulej.linkedlist.ListSizeMatcher.hasSizeOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsArrayContainingInOrder.arrayContaining;
import static org.hamcrest.core.IsNot.not;


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
        List filledList = a(list().withValues("fred", "wilma", "betty"));

        assertThat(emptyList, hasSizeOf(0));
        assertThat(filledList, hasSizeOf(3));
    }

    @Test
    public void shouldReturnArrayOfValues() {
        List theList = a(list().withoutAnyValues());

        theList.add("fred");
        theList.add("wilma");
        theList.add("betty");
        theList.add("barney");

        assertThat(theList.values(), arrayContaining("fred", "wilma", "betty", "barney"));
    }

    @Test
    public void shouldDeleteNodeFromList() {
        List theList = a(list().withValues("fred", "wilma", "betty", "barney"));

        Node theNode = theList.find("wilma");
        assertThat("List should contain wilma", not(nullValue()));

        theList.delete(theNode.value());

        assertThat(theList.find("wilma"), is(nullValue()));
    }

    @Test
    public void shouldDeleteFirstNodeFromList() {
        List theList = a(list().withValues("fred", "wilma"));

        Node deletedNode = theList.delete("fred");

        assertThat(theList, hasSizeOf(1));
        assertThat(deletedNode.value(), equalTo("fred"));
    }

    @Test
    public void shouldReturnNodeForSpecificPosition() {
        List theList = a(list().withValues("fred", "wilma", "betty", "barney", "dino"));

        Node firstNode = theList.get(0);
        assertThat(firstNode.value(), equalTo("fred"));

        Node middleNode = theList.get(2);
        assertThat(middleNode.value(), equalTo("betty"));

        Node lastNode = theList.get(4);
        assertThat(lastNode.value(), equalTo("dino"));
    }


    private List a(ListBuilder builder) {
        return builder.build();
    }
}