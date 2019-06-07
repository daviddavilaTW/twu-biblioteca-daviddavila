package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MovieTest {
    @Test
    public void shouldInitiateWithARatingIn0() {

        int rating = 0;

        Movie movie = new Movie(9,"","",1999);

        assertThat(movie.getRating(),is(rating));


    }
}