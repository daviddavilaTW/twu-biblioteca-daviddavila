package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Library {

    ArrayList<Book> bookList = new ArrayList<Book>();
    ArrayList<Movie> movieList = new ArrayList<Movie>();//<Item>


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


        movieList.add(movieA);
        movieList.add(movieB);
        movieList.add(movieC);
        movieList.add(movieD);
        movieList.add(movieE);
    }

    public void printListOfItems(Item item) {

        System.out.println(
                item.getID() + ". " +
                        item.getName() + " --- " +
                        item.getAuthor() + " --- " +
                        item.getPublicationYear()
        );
    }

    public void showMenuBooks() {
        System.out.println("*****  BOOKS  *****");
        System.out.println("Choose an option to continue:");
        System.out.println("1. List of books");
        System.out.println("2. Checkout a book");
        System.out.println("3. Return a book");
        System.out.println("0. Main Menu");

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

    public void listAvailableBooks(ArrayList<Book> bookList) {
        System.out.println("LIST OF AVAILABLE BOOKS");
        for (Book book : bookList) {
            if (book.isAvailable()) {
                printListOfItems(book);
            }

        }
    }

    public void listUnavailableBooks(ArrayList<Book> bookList) {
        System.out.println("LIST OF BOOKS TO BE RETURNED");
        for (Book book : bookList) {
            if (!book.isAvailable()) {
                printListOfItems(book);
            }

        }
    }

    public void optionCheckOutABook(ArrayList<Book> bookList) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("CHECK OUT A BOOK");

        int optionCheckout = -1;

        while (optionCheckout != 0) {

            System.out.println("Choose a book to checkout to continue:");
            listAvailableBooks(bookList);
            System.out.println("0. Exit to book menu");
            optionCheckout = scanner.nextInt();

            if (optionCheckout == 0) {
                break;
            }
            checkOutABook(bookList, optionCheckout);
        }
    }

    public void checkOutABook(ArrayList<Book> bookList, int optionCheckout) {
        boolean existsBook = false;
        for (Book book:bookList) {
            if (optionCheckout == book.getID()) {
                existsBook = true;
                if (book.isAvailable()) {
                    book.checkout();
                    System.out.println("Thank you. Enjoy the book!");
                    break;

                } else {
                    System.out.println("Sorry. This book is not available.");
                    break;
                }
            }

        }
        if (!existsBook){
            System.out.println("Wrong option. Choose a correct option");
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
        boolean existsMovie = false;
        for (Movie movie:movieList) {
            if (optionCheckout == movie.getID()) {
                existsMovie = true;
                if (movie.isAvailable()) {
                    movie.checkout();
                    System.out.println("Thank you. Enjoy the movie!");
                    break;

                } else {
                    System.out.println("Sorry. This movie is not available.");
                    break;
                }
            }


        }
        if(!existsMovie) {
            System.out.println("Wrong option. Choose a correct option");
        }

    }

    public void optionMovies(ArrayList<Movie> movieList) {

        Scanner scanner = new Scanner(System.in);

        int optionMovies = -1;
        while (optionMovies != 0) {
            showMenuMovies();

            optionMovies = scanner.nextInt();
            switch (optionMovies) {
                case 1:
                    listAvailableMovies(movieList);
                    break;
                case 2:
                    optionCheckOutAMovie(movieList);
                    break;
                case 0:
                    System.out.println("Bye!");
                    break;
                default:
                    System.out.println("Please select a valid option!");

            }
        }
    }

    public void showMenuMovies() {
        System.out.println("*****  MOVIES  *****");
        System.out.println("Choose an option to continue:");
        System.out.println("1. List of movies");
        System.out.println("2. Checkout a movie");
        System.out.println("0. Main Menu");

    }

    public void listAvailableMovies(ArrayList<Movie> movieList) {

        System.out.println("LIST OF AVAILABLE MOVIES");
        for (Movie movie:movieList
             ) {
            if(movie.isAvailable()){
                printListOfItems(movie);

            }


        }
    }

    public void optionCheckOutAMovie(ArrayList<Movie> movieList) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("CHECK OUT A MOVIE");

        int optionCheckout = -1;

        while (optionCheckout != 0) {
            System.out.println("Choose a movie to checkout to continue:");
            listAvailableMovies(movieList);
            System.out.println("0. Exit to movie menu");

            optionCheckout = scanner.nextInt();

            if (optionCheckout == 0) {
                break;
            }

            checkOutAMovie(movieList, optionCheckout);
        }
    }
}






