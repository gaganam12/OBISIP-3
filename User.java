import java.util.ArrayList;

public class User {
    private String username;
    private String email;
    private ArrayList<Book> issuedBooks;

    public User(String username, String email) {
        this.username = username;
        this.email = email;
        this.issuedBooks = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public ArrayList<Book> getIssuedBooks() {
        return issuedBooks;
    }

    public void issueBook(Book book) {
        issuedBooks.add(book);
        book.issue();
    }

    public void returnBook(Book book) {
        issuedBooks.remove(book);
        book.returnBook();
    }

    @Override
    public String toString() {
        return "User: " + username + " | Email: " + email;
    }
}

