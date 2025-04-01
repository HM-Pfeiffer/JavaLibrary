package Application.DAO;

import Application.Util.ConnectionUtil;
import Application.Model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO class mediates the transformation of data between the format of objects in Java to rows in a database.
 *
 * database has a table named 'book':  
 *      isbn, which is of type int and is a primary key,
 *      author_id, which is of type int, and is a foreign key associated with the column 'id' of 'author',
 *      title, which is of type varchar(255),
 *      copies_available, which is of type int.
 */
public class BookDAO {
    /**
     * TODO: retrieve all books from the Book table.
     * @return all Books.
     */
    public List<Book> getAllBooks(){
        Connection connection = ConnectionUtil.getConnection();
        List<Book> books = new ArrayList<>();
        try {
            //Write SQL logic here
            String sql = "SELECT * FROM book";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Book book = new Book(rs.getInt("isbn"),
                        rs.getInt("author_id"),
                        rs.getString("title"),
                        rs.getInt("copies_available"));
                books.add(book);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return books;
    }

    /**
     * TODO: retrieve a book from the Book table, identified by its isbn.
     * @return a book identified by isbn.
     */
    public Book getBookByIsbn(int isbn){
        Connection connection = ConnectionUtil.getConnection();
        try {
            String sql = "SELECT * FROM book WHERE isbn = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, isbn);

            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Book book = new Book(rs.getInt("isbn"),
                        rs.getInt("author_id"),
                        rs.getString("title"),
                        rs.getInt("copies_available"));
                return book;
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * TODO: insert a book into the Book table.
     * primary key here will be provided by the client as part of the Book object
     * Given the specific nature of an ISBN as both a numerical organization of books outside of this db
     * and as a primary key, it makes sense for the client to submit an ISBN when submitting a book.
     */
    public Book insertBook(Book book){
        Connection connection = ConnectionUtil.getConnection();
        try {
            String sql = "INSERT INTO book (isbn, author_id, title, copies_available) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, book.getIsbn());
            preparedStatement.setInt(2, book.getAuthor_id());
            preparedStatement.setString(3, book.getTitle());
            preparedStatement.setInt(4, book.getCopies_available());

            preparedStatement.executeUpdate();
            return book;
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    /**
     * TODO: retrieve all books from the Book table with copies_available over zero.
     * @returnall books with book count > 0.
     */
    public List<Book> getBooksWithBookCountOverZero(){
        Connection connection = ConnectionUtil.getConnection();
        List<Book> books = new ArrayList<>();
        try {
            //Write SQL logic here
            String sql = "SELECT * FROM book WHERE copies_available > 0";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Book book = new Book(rs.getInt("isbn"),
                        rs.getInt("author_id"),
                        rs.getString("title"),
                        rs.getInt("copies_available"));
                books.add(book);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return books;
    }
}
