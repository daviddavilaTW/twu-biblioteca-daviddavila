package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
        System.out.println("\n \n");

        Book bookArray[] = new Book[3];

        bookArray[0] = new Book(1,"BookName1", "David", 2001, true);
        bookArray[1] = new Book(2,"BookName2", "Alejandro", 2010, true);
        bookArray[2] = new Book(3,"BookName3", "Melany", 2011, false);


        int optionChoosen = 5;

        Scanner scanner = new Scanner(System.in);

        while (optionChoosen != 0) {

            System.out.println("Choose an option to continue:");
            System.out.println("1. List of books");
            System.out.println("2. CheckOut a book");

            System.out.println("0. Quit");

            optionChoosen = scanner.nextInt();


            switch (optionChoosen) {
                case 1:
                    System.out.println("\n");

                    // Problemas metiendolo en un metodo... (Refactor)
                    System.out.println("LIST OF BOOKS");

                    for (int book = 0; book < bookArray.length; book++) {

                        if (bookArray[book].isAvaliable()) {

                            System.out.println(
                                    bookArray[book].getBookName() + " --- " +
                                            bookArray[book].getAuthorName() + " --- " +
                                            bookArray[book].getPublicationYear());

                        }
                    }

                    break;

                case 0:
                    System.out.println("Bye!");
                    break;

                default:
                    System.out.println("Please select a valid option!");

            }

        }


    }
}
