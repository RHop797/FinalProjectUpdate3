public class BookTest {
    public static void main(String[] args) {
        testBookCreation();
        testBookToString();
        testSetters();
        System.out.println("All tests passed.");
    }

    public static void testBookCreation() {
        Book book = new Book("Effective Java", "Joshua Bloch", "9780134685991");
        
        assert "Effective Java".equals(book.getTitle()) : "Test failed: Title mismatch";
        assert "Joshua Bloch".equals(book.getAuthor()) : "Test failed: Author mismatch";
        assert "9780134685991".equals(book.getIsbn()) : "Test failed: ISBN mismatch";
    }

    public static void testBookToString() {
        Book book = new Book("Effective Java", "Joshua Bloch", "9780134685991");
        
        String expected = "Title: Effective Java, Author: Joshua Bloch, ISBN: 9780134685991";
        assert expected.equals(book.toString()) : "Test failed: toString mismatch";
    }

    public static void testSetters() {
        Book book = new Book("Effective Java", "Joshua Bloch", "9780134685991");
        
        book.setTitle("Java Concurrency in Practice");
        book.setAuthor("Brian Goetz");
        book.setIsbn("9780321349606");

        assert "Java Concurrency in Practice".equals(book.getTitle()) : "Test failed: Title mismatch after setter";
        assert "Brian Goetz".equals(book.getAuthor()) : "Test failed: Author mismatch after setter";
        assert "9780321349606".equals(book.getIsbn()) : "Test failed: ISBN mismatch after setter";
    }
}

