package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class BibliotecaAppTest {

    @Test
    public void shouldTheUser1111111LogInWithThePassword1() {
        Library library = new Library();
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        ArrayList<User> userList = new ArrayList<User>();
        User user1 = new User("111-1111","1");
        userList.add(user1);

        bibliotecaApp.checkPassword(library,user1,user1.getPassword());

        assertThat(bibliotecaApp.actualUser,is(user1));


    }
}