public class LibraryTest {
    public static void main(String[] args) {
        testAddBook();
        testRemoveBook();
        testSearchByTitle();
        System.out.println("All tests passed.");
    }

    public static void testAddBook() {
        Library library = new Library();
        Book book = new Book("Clean Code", "Robert C. Martin", "9780132350884");

        library.addItem(book);
        assert library.getItems().contains(book) : "Test failed: Book not added";
    }

    public static void testRemoveBook() {
        Library library = new Library();
        Book book = new Book("Clean Code", "Robert C. Martin", "9780132350884");

        library.addItem(book);
        library.removeItem(book);
        assert !library.getItems().contains(book) : "Test failed: Book not removed";
    }

    public static void testSearchByTitle() {
        Library library = new Library();
        Book book1 = new Book("Clean Code", "Robert C. Martin", "9780132350884");
        Book book2 = new Book("The Pragmatic Programmer", "Andy Hunt", "9780201616224");

        library.addItem(book1);
        library.addItem(book2);

        assert library.searchByTitle("Clean Code").contains(book1) : "Test failed: Title search failed";
        assert !library.searchByTitle("Clean Code").contains(book2) : "Test failed: Incorrect book in search result";
    }
}

