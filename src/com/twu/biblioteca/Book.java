package com.twu.biblioteca;

import java.io.PrintStream;

public class Book extends Item{

    public Book(int ID, String name, String author, int year) {
        super(ID, name, author, year);
    }

    public void checkout() {

        this.setAvailable(false);
    }

    public void checkIn() {
        this.setAvailable(true);
    }

    public void printName(PrintStream printStream) {

        printStream.println("Name: " + this.getName());

    }
}
