package com.twu.biblioteca;

public class Movie extends Item
{

    private int rating;

    public Movie(int ID, String name, String author, int publicationYear) {
        super(ID, name, author, publicationYear);
        this.rating = 0;

    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
