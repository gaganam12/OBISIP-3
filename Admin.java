import java.util.HashMap;

public class Admin {
    private HashMap<String, User> users;
    private HashMap<String, Book> books;

    public Admin() {
        users = new HashMap<>();
        books = new HashMap<>();
    }

    public void addBook(String title, String author, String category) {
        books.put(title, new Book(title, author, category));
        System.out.println("Book added successfully.");
    }

    public void removeBook(String title) {
        books.remove(title);
        System.out.println("Book removed successfully.");
    }

    public void addUser(String username, String email) {
        users.put(username, new User(username, email));
        System.out.println("User added successfully.");
    }

    public void removeUser(String username) {
        users.remove(username);
        System.out.println("User removed successfully.");
    }

    public HashMap<String, Book> getBooks() {
        return books;
    }

    public HashMap<String, User> getUsers() {
        return users;
    }
}

