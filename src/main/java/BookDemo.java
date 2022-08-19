import commands.Commands;
import commands.Gender;
import exception.AuthorNotFoundException;
import model.Author;
import model.Book;
import model.User;
import model.UserType;
import storage.AuthorStorage;
import storage.BookStorage;
import storage.UserStorage;

import java.io.IOException;
import java.util.Scanner;


public class BookDemo implements Commands {

    private static final Scanner scanner = new Scanner(System.in);
    private static final BookStorage bookStorage = new BookStorage();
    private static final AuthorStorage authorStorage = new AuthorStorage();
    private static final Author author = new Author("xachatur", "abovyan", "vep2@mail.ru", "male");
    private static final UserStorage userStorage = new UserStorage();

    public static void main(String[] args) throws IOException {
        initData();

        boolean run = true;
        while (run) {
            Commands.printLoginCommands();
            int command;
            try {
                command = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                command = -1;
            }
            switch (command) {
                case EXIT:
                    run = false;
                    break;
                case LOGIN:
                    login();
                    break;
                case REGISTER:
                    register();
                    break;
                case PRINT_ARRAY:
                    userStorage.printAllUsers();
                default:
                    System.err.println("INVALID COMMAND");
            }
        }
    }

    private static void login() throws IOException {
        System.out.println("Please input email, password");
        String emailPasswordStr = scanner.nextLine();
        String[] emailPassword = emailPasswordStr.split(",");
        User user = userStorage.getUserByemail(emailPassword[0]);
        if (user == null) {
            System.err.println("User with " + emailPassword[0] + " doesn't exist!!!!!!!!");
        } else {
            if (user.getPassword().equals(emailPassword[1])) {
                if (user.getUserType() == UserType.ADMIN) {
                    loginAdmin();
                } else if (user.getUserType() == UserType.USER) {
                    loginUser();
                }
            } else {
                System.err.println("Password is wrong");
            }
        }
    }
//axpers xi push chi anum???
    private static void loginUser() {
        boolean run = true;
        while (run) {
            Commands.printUserCommands();
            int command;
            try {
                command = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                command = -1;
            }

            switch (command) {
                case EXIT:
                    run = false;
                    break;

                case ADD_BOOK:
                    addBook();
                    break;

                case ADD_AUTHOR:
                    addAuthor();
                    break;

                case PRINT_ALL_BOOKS:
                    bookStorage.printAllBooks();
                    break;

                case PRINT_BOOKS_AUTHOR_NAME:
                    printBooksByAuthorName();
                    break;

                case PRINT_BOOKS_AUTHOR_SURNAME:
                    printBooksByAuthorSurname();
                    break;

                case PRINT_BOOKS_BY_AUTHOR_GENDER:
                    printBooksByAuthorGender();
                    break;
                case PRINT_BOOKS_BY_GENRE:
                    printBooksByGenere();
                    break;

                case PRINT_BOOKS_BY_PRICE_RANGE:
                    printBooksByPriceRange();
                    break;

                default:
                    System.err.println("Invalid command");
            }
        }
    }

    private static void register() {
        System.out.println("Please input name, surname, email, password");
        String userDataStr = scanner.nextLine();
        String[] userData = userDataStr.split(",");
        if (userData.length < 4) {
            System.err.println("Please input correct data");
        } else {
            if (userStorage.getUserByemail(userData[0]) == null) {
                User user = new User();
                user.setName(userData[0]);
                user.setSurname(userData[1]);
                user.setEmail(userData[2]);
                user.setPassword(userData[3]);
                user.setUserType(UserType.USER);
                userStorage.add(user);
                System.out.println("User created");
            } else {
                System.err.println("User with " + userData[0] + " already exist!!!");
            }
        }
    }


    private static void loginAdmin() throws IOException {
        boolean run = true;
        while (run) {
            Commands.printAdminCommands();
            int command;
            try {
                command = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                command = -1;
            }

            switch (command) {
                case 0:
                    run = false;
                    break;

                case ADD_BOOK:
                    addBook();
                    break;

                case ADD_AUTHOR:
                    addAuthor();
                    break;

                case PRINT_ALL_BOOKS:
                    bookStorage.printAllBooks();
                    break;

                case PRINT_ALL_AUTHORS:
                    authorStorage.printAllAuthors();
                    break;

                case PRINT_BOOKS_AUTHOR_NAME:
                    printBooksByAuthorName();
                    break;

                case PRINT_BOOKS_AUTHOR_SURNAME:
                    printBooksByAuthorSurname();
                    break;

                case PRINT_BOOKS_BY_AUTHOR_EMAIL:
                    printBooksByAuthorEmail();
                    break;

                case PRINT_BOOKS_BY_AUTHOR_GENDER:
                    printBooksByAuthorGender();
                    break;
                case PRINT_BOOKS_BY_GENRE:
                    printBooksByGenere();
                    break;

                case PRINT_BOOKS_BY_PRICE_RANGE:
                    printBooksByPriceRange();
                    break;

                default:
                    System.err.println("Invalid command");
            }
        }
    }

    private static void initData() {
        User user = new User("admin", "admin", "admin@mail.ru", "admin", UserType.ADMIN);
        userStorage.add(user);
        User user1 = new User("test","test","test@mail.ru","123456",UserType.ADMIN);
        userStorage.add(user1);
        bookStorage.add(new Book("abu lala mahari", 750, 145, "Joxovacu"));
        bookStorage.add(new Book("xenty", 8500, 14, "Joxovacu"));
        bookStorage.add(new Book("verq hayastani", 9500, 15, "Joxovacu"));
        bookStorage.add(new Book("hayoc lezu", 5500, 45, "Joxovacu"));
        authorStorage.add(new Author("avetiq", "isahakyan", "poem@mail.ru", "male"));
        authorStorage.add(new Author("raffi", "raffi", "vep1@mail.ru", "male"));
        authorStorage.add(new Author("xachatur", "abovyan", "vep2@mail.ru", "male"));
        authorStorage.add(new Author("silva", "kaputikyan", "banastexcutyun@mail.ru", "female"));
    }

    private static void printBooksByAuthorName() {
        System.out.println("Please input author name");
        String authorName = scanner.nextLine();
        authorStorage.printBooksByAuthorName(authorName);
    }

    private static void printBooksByAuthorSurname() {
        System.out.println("Please input author surname");
        String surname = scanner.nextLine();
        authorStorage.printBooksByAuthorSurname(surname);
    }

    private static void printBooksByAuthorEmail() throws IOException {
        System.out.println("Please input author email");
        String email = scanner.nextLine();
        authorStorage.printBooksByAuthorEmail(email);
    }

    private static String printBooksByAuthorGender() {
        System.out.println("Pleace input 1 for male");
        System.out.println("Pleace input 2 for female");
        int index = Integer.parseInt(scanner.nextLine());
        if (index != 1 && index != 2) {
            System.err.println("Please input correct gender");
            printBooksByAuthorGender();
        } else if (index == 1) {
            author.setGender("male");
        } else {
            author.setGender("female");
        }
        return author.getGender();
    }

    private static void printBooksByGenere() {
        System.out.println("Please input genere");
        String genre = scanner.nextLine();
        bookStorage.printBooksByGenre(genre);
    }

    private static void printBooksByPriceRange() {
        System.out.println("Pleace input min price");
        try {
            int min = Integer.parseInt(scanner.nextLine());
            System.out.println("Pleace input max price");
            int max = Integer.parseInt(scanner.nextLine());
            bookStorage.printBooksByPriceRange(min, max);
        } catch (NumberFormatException e) {
            System.err.println("Your price range not found in books");
            System.out.println("Please input price range");
            printBooksByPriceRange();
        }
    }

    private static void addAuthor() {
        System.out.println("Please input author name");
        String authorName = scanner.nextLine();
        System.out.println("Please input author surname");
        String authorSurName = scanner.nextLine();
        System.out.println("Please input author email");
        String email = scanner.nextLine();
        String gender = printBooksByAuthorGender();
        if (gender == null) {
            //TODO: kam ban grel kam hanel
        } else {
            if (authorName == null || authorName.equals("")) {
                System.out.println("Please input author name!!!");
                //TODO: kam logika grel inch vor, kam jnjel
            } else if (authorSurName == null || authorSurName.equals("")) {
                System.out.println("Please input author surname");
                //TODO: nuyny sa u takiny
            } else if (!email.contains("@")) {
                System.out.println("please input correct email");
            } else {
                Author author = new Author(authorName.trim(), authorSurName.trim(), email.trim(), gender);
                authorStorage.add(author);
                System.out.println("author created");
            }
        }

    }

    private static Gender gender() {
        return null;
    }


    private static void addBook() {
        if (authorStorage.getSize() == 0) {
            System.out.println("for create book need has author");
            System.out.println(" please create author");
            System.out.println("for create author choose_1: for exit choose_2");
            int command = 0;
            try {
                command = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("please input only numbers");
            }

            if (command == 1) {
                addAuthor();
            } else if (false) ; //TODO: kam jnjel kam logika grel, if-ic heto chi karox ; lnel
        } else {
            authorStorage.printAllAuthor();
            System.out.println("please choose index author");
            Author author = null;
            try {
                int authorIndex = Integer.parseInt(scanner.nextLine());
                author = authorStorage.getAuthorByIndex(authorIndex);
            } catch (AuthorNotFoundException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("please input only numbers");
                //TODO: heto inch? tpum enq bayc hnaravorutyun chenq talis noric chisht grelu
                //minchev push ani revizia anenq mi hat ))
            }
            if (author == null) {
                System.out.println("please choose correct index!!!");
                addBook();
            } else {
                System.out.println("Please input book's name");
                String booksName = scanner.nextLine();
                System.out.println("Please input count");
                int count = Integer.parseInt(scanner.nextLine());
                System.out.println("Please input genre");
                String genre = scanner.nextLine();
                try {
                    System.out.println("Please input price");
                    double price = Double.parseDouble(scanner.nextLine());
                    if (booksName == null || booksName.equals("")) {
                        System.out.println("Please input book's name!!!!");
                    } else if (price < 0) {
                        System.out.println("Please input correct price");
                    } else if (genre == null || genre.equals("")) {
                        System.out.println("Please input genre name!!!!");
                    } else {
                        Book book = new Book(booksName.trim(), price, count, genre.trim());
                        bookStorage.add(book);
                        System.out.println("book created");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Please note only numbers");
                    addBook();
                }
            }
        }

    }
}


