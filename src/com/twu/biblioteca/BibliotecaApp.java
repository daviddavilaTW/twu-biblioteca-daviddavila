package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {

    public static User actualUser;
    public static User librarian = new User ("000-0000","0","Librarian","librarian@bangalore.com","00000000");

    public static void main(String[] args) {

        ArrayList<User> userList = new ArrayList<User>();
        User user1 = new User("111-1111","1","David Davila","david.davila@thoughtworks.com","09999736900");
        User user2 = new User("222-2222","2","Melany Torres","meltorres9@hotmail.com","0999789732");

        userList.add(librarian);
        userList.add(user1);
        userList.add(user2);


        Library library = new Library();
        library.addItems();

        login(userList, library);

    }

    private static void mainMenu(Library library) {
        int optionChosen = 5;

        Scanner scanner = new Scanner(System.in);

        while (optionChosen != 0) {
            showMainMenu();
            optionChosen = getOptionChosen(library, scanner);
        }
    }

    public static void login(ArrayList<User> userList, Library library){
        Scanner scanner = new Scanner(System.in);
        String actualLibraryNumber = "";
        while (true) {


            System.out.print("Enter your library number: ");
            actualLibraryNumber = scanner.next();


    for (User user : userList) {

        checkLibraryNumber(library, scanner, actualLibraryNumber, user);
    }
if(actualUser==null){
    System.out.println("Incorrect Information.");

}

}



    }

    private static void checkLibraryNumber(Library library, Scanner scanner, String actualLibraryNumber, User user) {
        if(user.getLibraryNumber().equals(actualLibraryNumber)) {

            System.out.print("Enter your password: ");
            String actualPassword = scanner.next();
            checkPassword(library, user, actualPassword);

        }


    }

    public static void checkPassword(Library library, User user, String actualPassword) {
        if (user.getPassword().equals(actualPassword)){

            actualUser = user;

            System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n \n");

            mainMenu(library);

        }
    }

    private static int getOptionChosen(Library library, Scanner scanner) {
        User user = new User();
        int optionChosen;
        optionChosen = scanner.nextInt();
        switch (optionChosen) {
            case 1:
                actualUser.optionUserInfo();
                break;
            case 2:
                library.optionBooks();
                break;
            case 3:
                library.optionMovies();

            case 0:
                System.out.println("Bye!");
                break;
            default:
                System.out.println("Please select a valid option!");

        }
        return optionChosen;
    }



    private static void showMainMenu() {
        System.out.println("Choose an option to continue:");
        System.out.println("1. User Info");
        System.out.println("2. Books");
        System.out.println("3. Movies");
        System.out.println("0. Quit");

    }
}