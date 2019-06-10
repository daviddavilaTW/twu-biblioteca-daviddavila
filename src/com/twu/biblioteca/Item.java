package com.twu.biblioteca;

public class Item {
    private int ID;
    private String name;
    private String author;
    private int publicationYear;
    private boolean isAvailable;
    private User owner;

    BibliotecaApp bibliotecaApp = new BibliotecaApp();


    public Item(int ID, String name, String author, int publicationYear) {
        this.ID = ID;
        this.name = name;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isAvailable = true;
        this.owner = bibliotecaApp.librarian;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
