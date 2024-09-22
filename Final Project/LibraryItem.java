public abstract class LibraryItem {
    private String title;
    private String author;

    public LibraryItem(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // Getters and setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    // Overriding equals to compare LibraryItems by title and author
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        LibraryItem that = (LibraryItem) obj;
        return title.equals(that.title) && author.equals(that.author);
    }

    // Overriding hashCode to ensure consistency with equals
    @Override
    public int hashCode() {
        return title.hashCode() + author.hashCode();
    }

    @Override
    public abstract String toString();
}
