package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {

        Library library = new Library();
        library.addItems();

        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n \n");

        int optionChosen = 5;

        Scanner scanner = new Scanner(System.in);

        while (optionChosen != 0) {
            showMainMenu();
            optionChosen = scanner.nextInt();
            switch (optionChosen) {
                case 1:
                    library.optionBooks(library.bookList);
                    break;
                case 0:
                    System.out.println("Bye!");
                    break;
                default:
                    System.out.println("Please select a valid option!");

            }

        }


    }

    private static void showMainMenu() {
        System.out.println("Choose an option to continue:");
        System.out.println("1. Books");
        System.out.println("2. Movies");
        System.out.println("0. Quit");

    }
}