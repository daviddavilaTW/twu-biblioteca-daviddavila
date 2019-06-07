package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n \n");


        Book bookA = new Book(1, "BookName1", "David", 2001, true);
        Book bookB = new Book(2, "BookName2", "Alejandro", 2010, true);
        Book bookC = new Book(3, "BookName3", "Melany", 2011, false);

        ArrayList<Book> bookList = new ArrayList<Book>();

        /*for (Book book : bookList) {
            System.out.println(book);
        }*/

        bookList.add(bookA);
        bookList.add(bookB);
        bookList.add(bookC);


        int optionChoosen = 5;
        Scanner scanner = new Scanner(System.in);

        while (optionChoosen != 0) {


            showMenu();


            optionChoosen = scanner.nextInt();


            switch (optionChoosen) {
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


    private static void showMenu() {
        System.out.println("Choose an option to continue:");
        System.out.println("1. List of books");
        System.out.println("2. Checkout a book");
        System.out.println("3. Return a book");

        System.out.println("0. Quit");

    }


    public static void listBooks(Book[] bookArray) {


        for (int book = 0; book < bookArray.length; book++) {


            System.out.println(
                    bookArray[book].getName() + " --- " +
                            bookArray[book].getAuthorName() + " --- " +
                            bookArray[book].getPublicationYear());


        }
    }

    public static void listAvailableBooks(ArrayList bookList) {
        System.out.println("LIST OF AVAILABLE BOOKS");
        Iterator iterator = bookList.iterator();

        while (iterator.hasNext()) {
            Book book = (Book) iterator.next();
            if (book.isAvailable()) {
                printListOfBooks(book);
            }

        }
    }


    public static void listUnavailableBooks(ArrayList bookList) {
        System.out.println("LIST OF BOOKS TO BE RETURNED");
        Iterator iterator = bookList.iterator();

        while (iterator.hasNext()) {
            Book book = (Book) iterator.next();
            if (!book.isAvailable()) {
                printListOfBooks(book);
            }

        }
    }

    private static void printListOfBooks(Book book) {
        System.out.println(
                book.getIDBook() + ". " +
                        book.getName() + " --- " +
                        book.getAuthorName() + " --- " +
                        book.getPublicationYear()
        );
    }

    public static void changeBookStatus(ArrayList bookList, int bookID) {


        Iterator iterator = bookList.iterator();
        while (iterator.hasNext()) {
            Book book = (Book) iterator.next();

            if (book.getIDBook() == bookID){
                if(book.isAvailable()){
                    book.setAvailable(false);
                }else{
                    book.setAvailable(true);
                }
            }
        }
    }




    public static void checkOutABook(ArrayList bookList) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("CHECK OUT A BOOK");

        int optionCheckout = -1;

        while (optionCheckout != 0) {

            System.out.println("Choose a book to checkout to continue:");
            listAvailableBooks(bookList);
            System.out.println("0. Exit to main menu");
            optionCheckout = scanner.nextInt();

            if (optionCheckout <= bookList.size()&&optionCheckout>0) {
                System.out.println("You choose the book number "
                        + (optionCheckout));

                Iterator iterator = bookList.iterator();

                while (iterator.hasNext()) {
                    Book book = (Book) iterator.next();

                    if (book.getIDBook() == optionCheckout) {
                        if (book.isAvailable()) {
                            changeBookStatus(bookList, optionCheckout);
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
        }
    }

        private static void returnABook (ArrayList bookList){
            Scanner scanner = new Scanner(System.in);
            System.out.println("RETURN A BOOK");

            int optionReturn = 0;

            while (optionReturn != -1) {

                System.out.println("Choose a book to return to continue:");
                listUnavailableBooks(bookList);
                System.out.println("0. Exit to main menu");
                optionReturn = scanner.nextInt() - 1;

                if (optionReturn < bookList.size()) {
                    System.out.println("You choose the book number "
                            + (optionReturn + 1));

                    Iterator iterator = bookList.iterator();

                    while (iterator.hasNext()) {
                        Book book = (Book) iterator.next();

                        if (book.getIDBook() == optionReturn) {
                            if (!book.isAvailable()) {
                                changeBookStatus(bookList, optionReturn);
                                System.out.println("Thank you for returning the book.");


                            } else {
                                System.out.println("That's not a valid book to return.");
                            }

                        } else {
                            System.out.println("Choose a correct option");

                        }


                    }

            }

        }

    }
}