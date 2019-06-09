package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Library {

    ArrayList<Book> bookList = new ArrayList<Book>();


    public void addItems(){


        Book bookA = new Book(101, "Demian", "Herman Hesse", 1923);
        Book bookB = new Book(102, "Agile Samurai", "Jonathan Rasmusson", 2010);
        Book bookC = new Book(103, "Pedro Paramo", "Juan Rulfo", 1955);


        bookList.add(bookA);
        bookList.add(bookB);
        bookList.add(bookC);


        Movie movieA = new Movie(201,"Fast and Furious","Rob Cohen",2001);
        Movie movieB = new Movie(202,"2 Fast 2 Furious","John Singleton",2003);
        Movie movieC = new Movie(203,"The Fast and the Furious: Tokyo Drift","Justin Lin",2006);
        Movie movieD = new Movie(204,"Fast & Furious", "Justin Lin",2009);
        Movie movieE = new Movie(205,"Fast Five", "Justin Lin",2011);

        ArrayList<Item> movieList = new ArrayList<Item>();//<Item>

        movieList.add(movieA);
        movieList.add(movieB);
        movieList.add(movieC);
        movieList.add(movieD);
        movieList.add(movieE);
    }



    public void optionBooks(ArrayList<Book> bookList) {
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
                    optionCheckOutABook(bookList);
                    break;
                case 3:
                    optionReturnABook(bookList);
                    break;
                case 0:
                    System.out.println("Bye!");
                    break;
                default:
                    System.out.println("Please select a valid option!");

            }

        }


    }

    public void showMenuBooks() {
        System.out.println("*****  BOOKS  *****");
        System.out.println("Choose an option to continue:");
        System.out.println("1. List of optionBooks");
        System.out.println("2. Checkout a book");
        System.out.println("3. Return a book");
        System.out.println("0. Exit");

    }




    public void listAvailableBooks(ArrayList<Book> bookList) {
        System.out.println("LIST OF AVAILABLE BOOKS");
        for (Book book : bookList) {
            if (book.isAvailable()) {
                printListOfBooks(book);
            }

        }
    }


    public void listUnavailableBooks(ArrayList<Book> bookList) {
        System.out.println("LIST OF BOOKS TO BE RETURNED");
        for (Book book : bookList) {
            if (!book.isAvailable()) {
                printListOfBooks(book);
            }

        }
    }

    public void printListOfBooks(Book book) {
        System.out.println(
                book.getID() + ". " +
                        book.getName() + " --- " +
                        book.getAuthor() + " --- " +
                        book.getPublicationYear()
        );
    }


    public void optionCheckOutABook(ArrayList<Book> bookList) {

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

            checkOutABook(bookList, optionCheckout);
        }
    }

    public void checkOutABook(ArrayList<Book> bookList, int optionCheckout) {
        for (Book book:bookList) {
            if (optionCheckout == book.getID()) {
                if (book.isAvailable()) {
                    book.checkout();
                    System.out.println("Thank you. Enjoy the book!");
                    break;

                } else {
                    System.out.println("Sorry. This book is not available.");
                    break;
                }
            } else {
                System.out.println("Choose a correct option");
                break;
            }
        }
    }

    public void optionReturnABook(ArrayList<Book> bookList) {

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
            returnABook(bookList, optionReturn);

        }

        }

    public void returnABook(ArrayList<Book> bookList, int optionReturn) {
        for (Book book : bookList) {

                if (optionReturn == book.getID()) {
                    if (!book.isAvailable()) {
                        book.checkIn();
                        System.out.println("Thank you for returning the book.");
                        break;

                    } else {
                        System.out.println("That's not a valid book to return.");
                        break;
                    }

                } else {
                    System.out.println("Choose a correct option");
                }


            }
    }

    public void checkOutAMovie(ArrayList<Movie> movieList, int optionCheckout) {
        for (Movie movie:movieList) {
            if (optionCheckout == movie.getID()) {
                if (movie.isAvailable()) {
                    movie.checkout();
                    System.out.println("Thank you. Enjoy the movie!");
                    break;

                } else {
                    System.out.println("Sorry. This movie is not available.");
                    break;
                }
            } else {
                System.out.println("Choose a correct option");
                break;
            }
        }


    }
}






