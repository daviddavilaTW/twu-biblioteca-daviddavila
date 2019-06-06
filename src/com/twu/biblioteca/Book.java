package com.twu.biblioteca;

public class Book {
    private int IDBook;
    private String name;
    private String authorName;
    private int publicationYear;
    private boolean isAvailable; //If it's checked out, is not available



    public Book(int IDBook, String name, String authorName, int publicationYear, boolean isAvailable) {
        this.IDBook = IDBook;
        this.name = name;
        this.authorName = authorName;
        this.publicationYear = publicationYear;
        this.isAvailable = isAvailable;
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

}
