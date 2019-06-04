package com.twu.biblioteca;

public class Book {
    private int IDBook;
    private String bookName;
    private String authorName;
    private int publicationYear;
    private boolean isAvaliable; //If it's checked out, is not avaliable



    public Book(int IDBook, String bookName, String authorName, int publicationYear, boolean isAvaliable) {
        this.IDBook = IDBook;
        this.bookName = bookName;
        this.authorName = authorName;
        this.publicationYear = publicationYear;
        this.isAvaliable = isAvaliable;
    }

    public int getIDBook() {
        return IDBook;
    }

    public void setIDBook(int IDBook) {
        this.IDBook = IDBook;
    }

    public boolean isAvaliable() {
        return isAvaliable;
    }

    public void setAvaliable(boolean avaliable) {
        isAvaliable = avaliable;
    }

    public Book(boolean isAvaliable) {
        this.isAvaliable = isAvaliable;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }
}
