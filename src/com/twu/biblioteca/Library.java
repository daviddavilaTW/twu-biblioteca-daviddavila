package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

import static com.twu.biblioteca.BibliotecaApp.actualUser;

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

    public void optionBooks() {
        Scanner scanner = new Scanner(System.in);

        int optionBooks = -1;
        while (optionBooks != 0) {
            showMenuBooks();

            optionBooks = scanner.nextInt();
            switch (optionBooks) {
                case 1:
                    listAvailableBooks();
                    break;
                case 2:
                    optionCheckOutABook();
                    break;
                case 3:
                    optionReturnABook();
                    break;
                case 0:
                    System.out.println("Bye!");
                    break;
                default:
                    System.out.println("Please select a valid option!");

            }

        }


    }

    public void listAvailableBooks() {
        System.out.println("LIST OF AVAILABLE BOOKS");
        for (Book book : this.bookList) {
            if (book.isAvailable()) {
                printListOfItems(book);
            }

        }
    }

    public void listUnavailableBooks() {
        System.out.println("LIST OF BOOKS TO BE RETURNED");
        for (Book book : this.bookList) {
            if (!book.isAvailable()) {
                printListOfItems(book);
            }

        }
    }

    public void optionCheckOutABook() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("CHECK OUT A BOOK");

        int optionCheckout = -1;

        while (optionCheckout != 0) {

            System.out.println("Choose a book to checkout to continue:");
            listAvailableBooks();
            System.out.println("0. Exit to book menu");
            optionCheckout = scanner.nextInt();

            if (optionCheckout == 0) {
                break;
            }
            checkOutABook(optionCheckout);
        }
    }

    public void checkOutABook(int optionCheckout) {
        boolean existsBook = false;
        for (Book book:this.bookList) {
            if (optionCheckout == book.getID()) {
                existsBook = true;
                checkBookAvailability(book);
                break;
            }

        }
        if (!existsBook){
            System.out.println("Wrong option. Choose a correct option");
        }
    }

    public void checkBookAvailability(Book book) {
        if (book.isAvailable()) {
            book.checkout();
            System.out.println("Thank you. Enjoy the book!");
            book.setOwner(actualUser);
            return;

        } else {
            System.out.println("Sorry. This book is not available.");
            return;
        }
    }

    public void optionReturnABook() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("RETURN A BOOK");

        int optionReturn = -1;

        while (optionReturn != 0) {

            System.out.println("Choose a book to return to continue:");
            listUnavailableBooks();
            System.out.println("0. Exit to main menu");
            optionReturn = scanner.nextInt();

            if (optionReturn == 0) {
                break;
            }
            returnABook(optionReturn);

        }

        }

    public void returnABook( int optionReturn) {
        for (Book book : this.bookList) {

                if (optionReturn == book.getID()) {
                    checkBookUnavailability(book);
                    break;

                } else {
                    System.out.println("Choose a correct option");
                }


            }
    }

    public void checkBookUnavailability(Book book) {
        if (!book.isAvailable()) {
            book.checkIn();
            System.out.println("Thank you for returning the book.");
            return;

        } else {
            System.out.println("That's not a valid book to return.");
            return;
        }
    }

    public void checkOutAMovie( int optionCheckout) {
        boolean existsMovie = false;
        for (Movie movie: this.movieList) {
            if (optionCheckout == movie.getID()) {
                checkMovieAvailability(movie);
                break;
            }


        }
        if(!existsMovie) {
            System.out.println("Wrong option. Choose a correct option");
        }

    }

    public void checkMovieAvailability(Movie movie) {
        if (movie.isAvailable()) {
            movie.checkout();
            System.out.println("Thank you. Enjoy the movie!");
            return;

        } else {
            System.out.println("Sorry. This movie is not available.");
            return;
        }
    }

    public void optionMovies() {

        Scanner scanner = new Scanner(System.in);

        int optionMovies = -1;
        while (optionMovies != 0) {
            showMenuMovies();

            optionMovies = scanner.nextInt();
            switch (optionMovies) {
                case 1:
                    listAvailableMovies();
                    break;
                case 2:
                    optionCheckOutAMovie();
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

    public void listAvailableMovies() {

        System.out.println("LIST OF AVAILABLE MOVIES");
        for (Movie movie:this.movieList
             ) {
            if(movie.isAvailable()){
                printListOfItems(movie);

            }


        }
    }

    public void optionCheckOutAMovie() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("CHECK OUT A MOVIE");

        int optionCheckout = -1;

        while (optionCheckout != 0) {
            System.out.println("Choose a movie to checkout to continue:");
            listAvailableMovies();
            System.out.println("0. Exit to movie menu");

            optionCheckout = scanner.nextInt();

            if (optionCheckout == 0) {
                break;
            }

            checkOutAMovie(optionCheckout);
        }
    }
}






