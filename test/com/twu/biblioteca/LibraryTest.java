package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class LibraryTest {

    ArrayList<Book> bookList = new ArrayList<Book>();

    ArrayList<Movie> movieList = new ArrayList<Movie>();
    @Test
    public void shouldSetInAvailableFalseWhenABookIsCheckedOut() {
        boolean expectedAvailability = false;
        Book book = new Book(101, "Demian", "Herman Hesse", 1923);
        bookList.add(book);
        Library library =  new Library();

        library.checkOutABook(bookList,101);

        assertThat(book.isAvailable(),is(expectedAvailability));

    }


    @Test
    public void shouldSetInAvailableTrueWhenABookIsReturned() {
        boolean expectedAvailability = true;
        Book book = new Book(101, "Demian", "Herman Hesse", 1923);
        bookList.add(book);
        Library library =  new Library();

        book.setAvailable(false);
        library.returnABook(bookList,101);

        assertThat(book.isAvailable(),is(expectedAvailability));

    }

    @Test
    public void shouldSetInAvailableFalseWhenAMovieIsCheckedOut() {
        boolean expectedAvailable = false;
        Movie movie = new Movie(201,"Fast and Furious","Rob Cohen",2001);
        movieList.add(movie);
        Library library = new Library();

        library.checkOutAMovie(movieList,201);

        assertThat(movie.isAvailable(), is(expectedAvailable));



    }
}