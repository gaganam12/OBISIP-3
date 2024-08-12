public class LibrarySystem {
    public static void main(String[] args) {
        Library library = new Library();
        LibraryInterface libraryInterface = new LibraryInterface(library);
        libraryInterface.start();
    }
}
