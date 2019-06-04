package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
        System.out.println("\n \n");

        Book bookArray[] = new Book[3];

        bookArray[0] = new Book("BookName1", "David", 2001);
        bookArray[1] = new Book("BookName2", "Alejandro", 2010);
        bookArray[2] = new Book("BookName3", "Melany", 2011);


        for (int book = 0; book < bookArray.length; book++) {
            System.out.println(
                    bookArray[book].getBookName() + " --- " +
                            bookArray[book].getAuthorName() + " --- " +
                            bookArray[book].getPublicationYear());
            System.out.println("\n");
        }



    }
}
