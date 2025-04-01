package Application.Model;

/**
 * This class is used to model a Book.
 */
public class Book {
    int isbn;
    int author_id;
    String title;
    int copies_available;

    /**
     * A default, no-args constructor is REQUIRED for Jackson ObjectMapper to work.
     */
    public Book(){

    }

    /**
     * An all-args constructor for creating new Book objects in DAO and service classes.
     * @param isbn
     * @param author_id
     * @param title
     * @param copies_available
     */
    public Book(int isbn, int author_id, String title, int copies_available) {
        this.isbn = isbn;
        this.author_id = author_id;
        this.title = title;
        this.copies_available = copies_available;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCopies_available() {
        return copies_available;
    }

    public void setCopies_available(int copies_available) {
        this.copies_available = copies_available;
    }
    /**
     * An equals method that determines if another Book is equal to this one.
     * @param o some other object (such as Book).
     * @return true if this author is equivalent to o, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return isbn == book.isbn && author_id == book.author_id && title.equals(book.title)
                && copies_available == book.copies_available;
    }
    /**
     * A toString method to test your methods using System.out.println (as needed)
     * @return a String representation of this book
     */
    @Override
    public String toString() {
        return "Book{" +
                "isbn=" + isbn +
                ", author_id=" + author_id +
                ", title=" + title +
                ", copies_available=" + copies_available +
                '}';
    }
}
