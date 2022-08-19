package commands;

public interface Commands {

    int LOGOUT = 0;
    int ADD_BOOK = 1;
    int ADD_AUTHOR = 2;
    int PRINT_ALL_BOOKS = 3;
    int PRINT_ALL_AUTHORS = 4;
    int PRINT_BOOKS_AUTHOR_NAME = 5;
    int PRINT_BOOKS_AUTHOR_SURNAME = 6;
    int PRINT_BOOKS_BY_AUTHOR_EMAIL = 7;
    int PRINT_BOOKS_BY_AUTHOR_GENDER = 8;
    int PRINT_BOOKS_BY_GENRE = 9;
    int PRINT_BOOKS_BY_PRICE_RANGE = 10;

    int EXIT = 0;
    int LOGIN = 1;
    int REGISTER = 2;
    int PRINT_ARRAY = 3;

    static void printAdminCommands() {

        System.out.println("please input " + LOGOUT + " for LOGOUT");
        System.out.println("please input " + ADD_BOOK + " for add book");
        System.out.println("please input " + PRINT_ALL_BOOKS + " for print all books");
        System.out.println("please input " + PRINT_ALL_AUTHORS + " for print all authors");
        System.out.println("please input " + PRINT_BOOKS_AUTHOR_NAME + " for print Books by authorName");
        System.out.println("please input " + PRINT_BOOKS_AUTHOR_SURNAME + " for print Books by authorSurname");
        System.out.println("please input " + PRINT_BOOKS_BY_AUTHOR_EMAIL + " for print Books by authorEmail");
        System.out.println("please input " + PRINT_BOOKS_BY_AUTHOR_GENDER + " for print Books by authorGender");
        System.out.println("please input " + PRINT_BOOKS_BY_GENRE + " for print Books by genre");
        System.out.println("please input " + PRINT_BOOKS_BY_PRICE_RANGE + " for print books by price range");

    }

    static void printUserCommands() {

        System.out.println("please input " + 0 + " for LOGOUT");
        System.out.println("please input " + 1 + " for add book");
        System.out.println("please input " + 2 + " for print all books");
        System.out.println("please input " + 3 + " for print Books by authorName");
        System.out.println("please input " + 4 + " for print Books by authorSurname");
        System.out.println("please input " + 5 + " for print Books by genre");
        System.out.println("please input " + 6 + " for print books by price range");

    }

    static void printLoginCommands() {

        System.out.println("please input " + EXIT + " for EXIT");
        System.out.println("please input " + LOGIN + " for LOGIN");
        System.out.println("please input " + REGISTER + " REGISTER");
        System.out.println("please input " + PRINT_ARRAY + " for print ARRAY");

    }
}
