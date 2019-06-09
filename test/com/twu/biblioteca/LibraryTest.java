package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class LibraryTest {

    ArrayList<Book> bookList = new ArrayList<Book>();


    @Test
    public void shouldSetInAvailableFalseWhenABookIsCheckedOut() {
        boolean expectedAvailability = false;
        Book book = new Book(101, "Demian", "Herman Hesse", 1923);
        bookList.add(book);
        Library library =  new Library();

        library.checkOutABook(bookList,101);

        assertThat(book.isAvailable(),is(expectedAvailability));

    }
}