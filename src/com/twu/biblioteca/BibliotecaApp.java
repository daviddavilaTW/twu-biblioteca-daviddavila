package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
        System.out.println("\n \n");

        Book bookArray[] = new Book[3];

        bookArray[0] = new Book("BookName1", "David", 2001);
        bookArray[1] = new Book("BookName2", "Alejandro", 2010);
        bookArray[2] = new Book("BookName3", "Melany", 2011);

        System.out.println("Choose an option to continue:");
        System.out.println("1. List of books");

        String optionChoised;

        Scanner scanner = new Scanner(System.in);
        optionChoised = scanner.nextLine();
        System.out.println("You choose the option " + optionChoised);



        // Problemas metiendolo en un metodo... (Refactor)

        System.out.println("\n");

        System.out.println("LIST OF BOOKS");
        for (int book = 0; book < bookArray.length; book++) {
            System.out.println(
                    bookArray[book].getBookName() + " --- " +
                            bookArray[book].getAuthorName() + " --- " +
                            bookArray[book].getPublicationYear());
        }



    }
}
