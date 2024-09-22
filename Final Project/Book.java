public class Book extends LibraryItem {
    private String isbn;

    public Book(String title, String author, String isbn) {
        super(title, author); // Call the constructor of LibraryItem
        this.isbn = isbn;
    }

    // Getter and setter for ISBN
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Title: " + getTitle() + ", Author: " + getAuthor() + ", ISBN: " + isbn;
    }
}
