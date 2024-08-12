public class Library {
    private Admin admin;

    public Library() {
        admin = new Admin();
        initializeSampleData();
    }

    private void initializeSampleData() {
        admin.addBook("To Kill a Mockingbird", "Harper Lee", "Fiction");
        admin.addBook("1984", "George Orwell", "Dystopian");
        admin.addBook("The Great Gatsby", "F. Scott Fitzgerald", "Classic");

        admin.addUser("user1", "user1@example.com");
        admin.addUser("user2", "user2@example.com");
    }

    public Admin getAdmin() {
        return admin;
    }
}

