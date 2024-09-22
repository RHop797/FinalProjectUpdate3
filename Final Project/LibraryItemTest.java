public class LibraryItemTest {
    public static void main(String[] args) {
        testLibraryItemCreation();
        testEqualsMethod();
        testSetters();
        System.out.println("All LibraryItem tests passed.");
    }

    public static void testLibraryItemCreation() {
        LibraryItem item = new Book("Refactoring", "Martin Fowler", "9780201485677");
        
        assert "Refactoring".equals(item.getTitle()) : "Test failed: Title mismatch";
        assert "Martin Fowler".equals(item.getAuthor()) : "Test failed: Author mismatch";
    }

    public static void testEqualsMethod() {
        LibraryItem item1 = new Book("Refactoring", "Martin Fowler", "9780201485677");
        LibraryItem item2 = new Book("Refactoring", "Martin Fowler", "9780201485677");
        LibraryItem item3 = new Book("Design Patterns", "Erich Gamma", "9780201633610");

        assert item1.equals(item2) : "Test failed: Items should be equal";
        assert !item1.equals(item3) : "Test failed: Items should not be equal";
    }

    public static void testSetters() {
        LibraryItem item = new Book("Refactoring", "Martin Fowler", "9780201485677");

        item.setTitle("Clean Architecture");
        item.setAuthor("Robert C. Martin");

        assert "Clean Architecture".equals(item.getTitle()) : "Test failed: Title mismatch after setter";
        assert "Robert C. Martin".equals(item.getAuthor()) : "Test failed: Author mismatch after setter";
    }
}
