import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Library {
    private ObservableList<LibraryItem> items;

    public Library() {
        // Initialize the ObservableList
        items = FXCollections.observableArrayList();
    }

    // Add an item to the library
    public void addItem(LibraryItem item) {
        items.add(item);
    }

    // Remove an item from the library
    public void removeItem(LibraryItem item) {
        items.remove(item);
    }

    // Get all items in the library
    public ObservableList<LibraryItem> getItems() {
        return items;
    }

    // Search for items by title
    public ObservableList<LibraryItem> searchByTitle(String title) {
        ObservableList<LibraryItem> result = FXCollections.observableArrayList();
        for (LibraryItem item : items) {
            if (item.getTitle().toLowerCase().contains(title.toLowerCase())) {
                result.add(item);
            }
        }
        return result;
    }

    // Search for items by author
    public ObservableList<LibraryItem> searchByAuthor(String author) {
        ObservableList<LibraryItem> result = FXCollections.observableArrayList();
        for (LibraryItem item : items) {
            if (item.getAuthor().toLowerCase().contains(author.toLowerCase())) {
                result.add(item);
            }
        }
        return result;
    }

    // Search for books by ISBN (assuming the item is a Book)
    public ObservableList<Book> searchByIsbn(String isbn) {
        ObservableList<Book> result = FXCollections.observableArrayList();
        for (LibraryItem item : items) {
            if (item instanceof Book && ((Book) item).getIsbn().equals(isbn)) {
                result.add((Book) item);
            }
        }
        return result;
    }
}

