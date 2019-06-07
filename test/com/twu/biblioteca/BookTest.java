package com.twu.biblioteca;


import org.junit.Test;

import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class BookTest {

    @Test
    public void shouldInitiateABookAsAvaliable() {

        Book book = new Book(4, "Charlie and the chocolate factory", "Thom", 2001);

        assertTrue(book.isAvailable());
    }

    @Test
    public void shouldContainAName() {

        String expectedName = "Harry Potter";

        Book book = new Book(5, expectedName, "JKR", 1995);

        assertThat(book.getName(), is(expectedName));

    }

    @Test
    public void shouldContainAnAuthorName() {

        String expectedAuthorName = "Gabriel Garcia";

        Book book = new Book(10, "100 Anios", expectedAuthorName, 2001);

        assertThat(book.getAuthorName(), is(expectedAuthorName));
    }

    @Test
    public void shouldContainAnPublicationYear() {

        int expectedPublicationYear = 2019;

        Book book = new Book(11, "TTD for Noobs", "David", expectedPublicationYear);

        assertThat(book.getPublicationYear(), is(expectedPublicationYear));
    }

    @Test
    public void shouldUpdateAsNotAvailableWhenCheckout() {

        Book book = new Book(11, "TTD for Noobs", "David", 2001);

        book.checkout();

        assertFalse(book.isAvailable());

    }

    @Test
    public void shouldUpdateAsAvailableWhenCheckIn() {
        Book book = new Book(10, "100 Anios", "Pedro", 2001);

        book.setAvailable(false);
        book.checkIn();

        assertTrue(book.isAvailable());

    }

    @Test
    public void shouldPrintTheNameWhenCallPrintName() {
        String expectedName = "100 Anios";
        Book book = new Book(10, expectedName, "Pedro", 2001);
        PrintStream mockPrintStream = mock(PrintStream.class);

        book.printName(mockPrintStream);

        verify(mockPrintStream).println("Name: " + expectedName);
    }
}
