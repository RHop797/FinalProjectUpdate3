import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LibraryApp extends Application {
    private Library library = new Library();  // Using your modified Library class
    private ObservableList<String> itemList = FXCollections.observableArrayList();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Library Management System");

        // Create UI components
        TextField titleField = new TextField();
        titleField.setPromptText("Title");

        TextField authorField = new TextField();
        authorField.setPromptText("Author");

        TextField isbnField = new TextField();
        isbnField.setPromptText("ISBN");

        Button addButton = new Button("Add Book");
        Button removeButton = new Button("Remove Book");
        ListView<String> itemListView = new ListView<>(itemList);

        // Event handlers
        addButton.setOnAction(e -> addBook(titleField, authorField, isbnField));
        removeButton.setOnAction(e -> removeBook(titleField));

        // Layout setup
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));
        layout.getChildren().addAll(
            titleField,
            authorField,
            isbnField,
            addButton,
            removeButton,
            itemListView
        );

        // Scene setup
        Scene scene = new Scene(layout, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void addBook(TextField titleField, TextField authorField, TextField isbnField) {
        String title = titleField.getText();
        String author = authorField.getText();
        String isbn = isbnField.getText();

        if (!title.isEmpty() && !author.isEmpty() && !isbn.isEmpty()) {
            // Adding a Book
            Book book = new Book(title, author, isbn);
            library.addItem(book);
            updateItemList();

            // Clear input fields
            titleField.clear();
            authorField.clear();
            isbnField.clear();
        } else {
            showAlert("Error", "Title, Author, and ISBN fields must be filled in.");
        }
    }

    private void removeBook(TextField titleField) {
        String title = titleField.getText();
        if (!title.isEmpty()) {
            LibraryItem toRemove = null;
            for (LibraryItem item : library.getItems()) {
                if (item.getTitle().equalsIgnoreCase(title)) {
                    toRemove = item;
                    break;
                }
            }

            if (toRemove != null) {
                library.removeItem(toRemove);
                updateItemList();
            } else {
                showAlert("Error", "Book with the given title not found.");
            }

            titleField.clear();
        } else {
            showAlert("Error", "Please provide a title to remove.");
        }
    }

    private void updateItemList() {
        itemList.clear();
        for (LibraryItem item : library.getItems()) {
            itemList.add(item.toString());
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
