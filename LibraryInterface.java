import java.util.Scanner;

public class LibraryInterface {
    private Library library;
    private Scanner scanner;

    public LibraryInterface(Library library) {
        this.library = library;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Admin Login");
            System.out.println("2. User Login");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    adminMenu();
                    break;
                case 2:
                    userMenu();
                    break;
                case 3:
                    System.out.println("Exiting system...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void adminMenu() {
        System.out.println("\nAdmin Menu");
        while (true) {
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Add User");
            System.out.println("4. Remove User");
            System.out.println("5. View All Books");
            System.out.println("6. View All Users");
            System.out.println("7. Back to Main Menu");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    removeBook();
                    break;
                case 3:
                    addUser();
                    break;
                case 4:
                    removeUser();
                    break;
                case 5:
                    viewAllBooks();
                    break;
                case 6:
                    viewAllUsers();
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void addBook() {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter book author: ");
        String author = scanner.nextLine();
        System.out.print("Enter book category: ");
        String category = scanner.nextLine();
        library.getAdmin().addBook(title, author, category);
    }

    private void removeBook() {
        System.out.print("Enter book title to remove: ");
        String title = scanner.nextLine();
        library.getAdmin().removeBook(title);
    }

    private void addUser() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        library.getAdmin().addUser(username, email);
    }

    private void removeUser() {
        System.out.print("Enter username to remove: ");
        String username = scanner.nextLine();
        library.getAdmin().removeUser(username);
    }

    private void viewAllBooks() {
        System.out.println("\nAll Books:");
        for (Book book : library.getAdmin().getBooks().values()) {
            System.out.println(book);
        }
    }

    private void viewAllUsers() {
        System.out.println("\nAll Users:");
        for (User user : library.getAdmin().getUsers().values()) {
            System.out.println(user);
        }
    }

    private void userMenu() {
        System.out.print("\nEnter username: ");
        scanner.nextLine();  // Consume newline
        String username = scanner.nextLine();

        User user = library.getAdmin().getUsers().get(username);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        System.out.println("Welcome, " + user.getUsername());

        while (true) {
            System.out.println("1. Browse Books");
            System.out.println("2. Search Book by Title");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Email Query");
            System.out.println("6. Logout");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    browseBooks();
                    break;
                case 2:
                    searchBookByTitle();
                    break;
                case 3:
                    issueBook(user);
                    break;
                case 4:
                    returnBook(user);
                    break;
                case 5:
                    emailQuery(user);
                    break;
                case 6:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void browseBooks() {
        System.out.println("\nBrowse Books:");
        for (Book book : library.getAdmin().getBooks().values()) {
            System.out.println(book);
        }
    }

    private void searchBookByTitle() {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        Book book = library.getAdmin().getBooks().get(title);

        if (book != null) {
            System.out.println("Book found: " + book);
        } else {
            System.out.println("Book not found.");
        }
    }

    private void issueBook(User user) {
        System.out.print("Enter book title to issue: ");
        String title = scanner.nextLine();
        Book book = library.getAdmin().getBooks().get(title);

        if (book != null && !book.isIssued()) {
            user.issueBook(book);
            System.out.println("Book issued successfully.");
        } else {
            System.out.println("Book is already issued or not available.");
        }
    }

    private void returnBook(User user) {
        System.out.print("Enter book title to return: ");
        String title = scanner.nextLine();
        Book book = library.getAdmin().getBooks().get(title);

        if (book != null && user.getIssuedBooks().contains(book)) {
            user.returnBook(book);
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("Book was not issued to you.");
        }
    }

    private void emailQuery(User user) {
        System.out.print("Enter your query: ");
        String query = scanner.nextLine();
        System.out.println("Query sent. We will respond to " + user.getEmail());
        // In a real-world application, you would send an actual email here.
    }
}

