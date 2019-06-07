package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;


public class ItemTest {

    @Test
    public void shouldContainAName(){
        String expectedName = "Charlie and the chocolate factory";
        Item item = new Book(1,expectedName,"",2019);

        String itemName = item.getName();

        assertThat(expectedName,is(itemName));

    }




}
