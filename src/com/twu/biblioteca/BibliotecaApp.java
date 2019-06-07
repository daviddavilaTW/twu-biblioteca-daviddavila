package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n \n");



        Book bookA = new Book(101, "Demian", "Herman Hesse", 1923);
        Book bookB = new Book(102, "Agile Samurai", "Jonathan Rasmusson", 2010);
        Book bookC = new Book(103, "Pedro Paramo", "Juan Rulfo", 1955);

        ArrayList<Book> bookList = new ArrayList<Book>();//<Item>

        bookList.add(bookA);
        bookList.add(bookB);
        bookList.add(bookC);


        Movie movieA = new Movie(201,"Fast and Furious","Rob Cohen",2001);
        Movie movieB = new Movie(202,"2 Fast 2 Furious","John Singleton",2003);
        Movie movieC = new Movie(203,"The Fast and the Furious: Tokyo Drift","Justin Lin",2006);
        Movie movieD = new Movie(204,"Fast & Furious", "Justin Lin",2009);
        Movie movieE = new Movie(205,"Fast Five", "Justin Lin",2011);

        int optionChosen = 5;
        Scanner scanner = new Scanner(System.in);

        while (optionChosen != 0) {
            showMenu();
            optionChosen = scanner.nextInt();
            switch (optionChosen) {
                case 1:
                    books(bookList);
                    break;
                case 2:
                    checkOutABook(bookList);
                    break;
                case 3:
                    returnABook(bookList);
                    break;
                case 0:
                    System.out.println("Bye!");
                    break;
                default:
                    System.out.println("Please select a valid option!");

            }

        }


    }

    private static void books(ArrayList<Book> bookList) {
        Scanner scanner = new Scanner(System.in);

        int optionBooks = -1;
        while (optionBooks != 0) {
            showMenuBooks();

            optionBooks = scanner.nextInt();
            switch (optionBooks) {
                case 1:
                    listAvailableBooks(bookList);
                    break;
                case 2:
                    checkOutABook(bookList);
                    break;
                case 3:
                    returnABook(bookList);
                    break;
                case 0:
                    System.out.println("Bye!");
                    break;
                default:
                    System.out.println("Please select a valid option!");

            }

        }


    }

    private static void showMenuBooks() {
        System.out.println("*****  BOOKS  *****");
        System.out.println("Choose an option to continue:");
        System.out.println("1. List of books");
        System.out.println("2. Checkout a book");
        System.out.println("3. Return a book");
        System.out.println("0. Exit");

    }


    private static void showMenu() {
        System.out.println("Choose an option to continue:");
        System.out.println("1. Books");
        System.out.println("2. Movies");
        System.out.println("0. Quit");

    }


    public static void listAvailableBooks(ArrayList<Book> bookList) {
        System.out.println("LIST OF AVAILABLE BOOKS");
        for (Book book : bookList) {
            if (book.isAvailable()) {
                printListOfBooks(book);
            }

        }
    }


    public static void listUnavailableBooks(ArrayList<Book> bookList) {
        System.out.println("LIST OF BOOKS TO BE RETURNED");
        for (Book book : bookList) {
            if (!book.isAvailable()) {
                printListOfBooks(book);
            }

        }
    }

    private static void printListOfBooks(Book book) {
        System.out.println(
                book.getID() + ". " +
                        book.getName() + " --- " +
                        book.getAuthor() + " --- " +
                        book.getPublicationYear()
        );
    }

    public static void changeBookStatus(ArrayList<Book> bookList, int bookID) {


        for (Book book : bookList
        ) {
            if (book.getID() == bookID) {
                if (book.isAvailable()) {
                    book.setAvailable(false);
                } else {
                    book.setAvailable(true);
                }
            }

        }


    }


    public static void checkOutABook(ArrayList<Book> bookList) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("CHECK OUT A BOOK");

        int optionCheckout = -1;

        while (optionCheckout != 0) {

            System.out.println("Choose a book to checkout to continue:");
            listAvailableBooks(bookList);
            System.out.println("0. Exit to main menu");
            optionCheckout = scanner.nextInt();

            if (optionCheckout == 0) {
                break;
            }

            if (optionCheckout <= bookList.size() && optionCheckout > 0) {
                System.out.println("You choose the book number "
                        + (optionCheckout));

                for (Book book : bookList) {
                    if (optionCheckout == book.getID()) {
                        if (book.isAvailable()) {
                            changeBookStatus(bookList, optionCheckout);
                            System.out.println("Thank you. Enjoy the book!");
                            break;

                        } else {
                            System.out.println("Sorry. This book is not available.");
                            break;
                        }
                    }


                }
            } else {
                System.out.println("Choose a correct option");
            }
        }
    }

    private static void returnABook(ArrayList<Book> bookList) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("RETURN A BOOK");

        int optionReturn = -1;

        while (optionReturn != 0) {

            System.out.println("Choose a book to return to continue:");
            listUnavailableBooks(bookList);
            System.out.println("0. Exit to main menu");
            optionReturn = scanner.nextInt();
            if (optionReturn == 0) {
                break;
            }

            if (optionReturn < bookList.size() && optionReturn > 0) {
                System.out.println("You choose the book number "
                        + (optionReturn));

                for (Book book : bookList) {

                    if (optionReturn == book.getID()) {
                        if (!book.isAvailable()) {
                            changeBookStatus(bookList, optionReturn);
                            System.out.println("Thank you for returning the book.");
                            break;

                        } else {
                            System.out.println("That's not a valid book to return.");
                            break;
                        }

                    }


                }


            } else {
                System.out.println("Choose a correct option");
                break;

            }

        }

    }
}