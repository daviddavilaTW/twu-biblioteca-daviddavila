package com.twu.biblioteca;

import java.io.PrintStream;

public class Book {
    private int IDBook;
    private String name;
    private String authorName;
    private int publicationYear;
    private boolean isAvailable; //If it's checked out, is not available


    public Book(int IDBook, String name, String authorName, int publicationYear) {
        this.IDBook = IDBook;
        this.name = name;
        this.authorName = authorName;
        this.publicationYear = publicationYear;
        this.isAvailable = true;
    }

    public int getIDBook() {
        return IDBook;
    }


    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String getName() {
        return name;
    }

    public String getAuthorName() {
        return authorName;
    }

    public int getPublicationYear() {
        return publicationYear;
    }


    public void checkout() {
        this.setAvailable(false);
    }

    public void checkIn() {
        this.setAvailable(true);
    }

    public void printName(PrintStream printStream) {

        printStream.println("Name: " + this.name);

    }
}
