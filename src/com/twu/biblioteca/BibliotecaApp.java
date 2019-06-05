package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n \n");

        Book bookArray[] = new Book[3];

        bookArray[0] = new Book(1,"BookName1", "David", 2001, true);
        bookArray[1] = new Book(2,"BookName2", "Alejandro", 2010, true);
        bookArray[2] = new Book(3,"BookName3", "Melany", 2011, false);


        int optionChoosen = 5;

        Scanner scanner = new Scanner(System.in);

        while (optionChoosen != 0) {

            System.out.println("Choose an option to continue:");
            System.out.println("1. List of books");
            System.out.println("2. Checkout a book");
            System.out.println("3. Return a book");

            System.out.println("0. Quit");

            optionChoosen = scanner.nextInt();


            switch (optionChoosen) {
                case 1:

                    System.out.println("LIST OF AVAILABLE BOOKS");

                    listAvailableBooks(bookArray);

                    break;


                case 2:
                    //Check out a book

                    System.out.println("CHECK OUT A BOOK");


                    int optionCheckout = 0;

                        while (optionCheckout != -1) {

                            System.out.println("Choose a book to checkout to continue:");

                            listAvailableBooks(bookArray);

                            System.out.println("0. Exit to main menu");

                            optionCheckout = scanner.nextInt()-1;

                            if(optionCheckout<bookArray.length){
                                System.out.println("You choose the book number "
                                        +(optionCheckout+1));
                                if (bookArray[optionCheckout].isAvaliable()) {
                                    changeBookStatus(bookArray,optionCheckout);
                                    System.out.println("Thank you. Enjoy the book.");
                                    break;
                                }else{
                                    System.out.println("Sorry. This book is not available.");
                                }

                            }
                            else{
                                System.out.println("Choose a correct option");

                            }


                        }
                    break;
                case 3:
                    //Return a book

                    System.out.println("RETURN A BOOK");

                    int optionReturn = 0;

                    while (optionReturn != -1){
                        System.out.println("Choose a book to return to continue:");

                        listUnavailableBooks(bookArray);

                        System.out.println("0. Exit to main menu");

                        optionReturn = scanner.nextInt()-1;

                        if(optionReturn<bookArray.length){
                            System.out.println("You choose the book number "
                                    +(optionReturn+1));

                            if (!bookArray[optionReturn].isAvaliable()) {
                                changeBookStatus(bookArray,optionReturn);
                                System.out.println("Thank you. Enjoy the book.");
                                break;
                            }else{
                                System.out.println("Sorry. This book is not available.");
                            }

                        }
                        else{
                            System.out.println("Choose a correct option");

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
    public static void listBooks(Book[] bookArray){


        for (int book = 0; book < bookArray.length; book++) {


            System.out.println(
                    bookArray[book].getBookName() + " --- " +
                            bookArray[book].getAuthorName() + " --- " +
                            bookArray[book].getPublicationYear());


        }
    }
    public static void listAvailableBooks(Book[] bookArray){

        for (int book = 0; book < bookArray.length; book++) {

            if (bookArray[book].isAvaliable()) {

                System.out.println(
                        bookArray[book].getIDBook() + ". " +
                                bookArray[book].getBookName() + " --- " +
                                bookArray[book].getAuthorName() + " --- " +
                                bookArray[book].getPublicationYear());

            }
        }
    }

    public static void listUnavailableBooks(Book[] bookArray){

        for (int book = 0; book < bookArray.length; book++) {

            if (!bookArray[book].isAvaliable()) {

                System.out.println(
                        bookArray[book].getIDBook() + ". " +
                                bookArray[book].getBookName() + " --- " +
                                bookArray[book].getAuthorName() + " --- " +
                                bookArray[book].getPublicationYear());

            }
        }
    }

    public static void changeBookStatus(Book[] bookArray, int bookID) {

        if (bookArray[bookID].isAvaliable()){
            bookArray[bookID].setAvaliable(false);
        }else{
            bookArray[bookID].setAvaliable(true);
        }


    }


}
