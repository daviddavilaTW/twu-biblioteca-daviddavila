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

        library.checkBookAvailability(book);

        assertThat(book.isAvailable(),is(expectedAvailability));

    }


    @Test
    public void shouldSetInAvailableTrueWhenABookIsReturned() {
        boolean expectedAvailability = true;
        Book book = new Book(101, "Demian", "Herman Hesse", 1923);
        bookList.add(book);
        Library library =  new Library();

        book.setAvailable(false);
        library.checkBookUnavailability(book);

        assertThat(book.isAvailable(),is(expectedAvailability));

    }

    @Test
    public void shouldSetInAvailableFalseWhenAMovieIsCheckedOut() {
        boolean expectedAvailable = false;
        Movie movie = new Movie(201,"Fast and Furious","Rob Cohen",2001);
        movieList.add(movie);
        Library library = new Library();

        library.checkMovieAvailability(movie);

        assertThat(movie.isAvailable(), is(expectedAvailable));

    }


    @Test
    public void shouldReturn1111111InTheInfoOfTheBook101() {
        User user = new User("111-1111","1","","","");
        Book book = new Book(101,"BookTest","NameTest",2019);
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        Library library = new Library();

        bibliotecaApp.actualUser = user;
        library.checkBookAvailability(book);
        assertThat(book.getOwner().getLibraryNumber(),is(user.getLibraryNumber()));



    }
}