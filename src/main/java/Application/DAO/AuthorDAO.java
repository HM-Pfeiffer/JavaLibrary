package Application.DAO;

import Application.Model.Author;
import Application.Util.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO class mediates the transformation of data between the format of objects in Java to rows in a db
 *
 * The database has already created a table named 'author':
 *     id, which is of type int and is a primary key,
 *     name, which is of type varchar(255).
 */
public class AuthorDAO {

    /**
     * TODO: retrieve all authors from the Author table.
     * @return all Authors.
     */
    public List<Author> getAllAuthors(){
        Connection connection = ConnectionUtil.getConnection();
        List<Author> authors = new ArrayList<>();
        try {
            //Write SQL logic here
            String sql = "SELECT * FROM author";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Author author = new Author(rs.getInt("id"), rs.getString("name"));
                authors.add(author);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return authors;
    }

    /**
     * TODO: insert an author into the Author table.
     * The author_id should be automatically generated by the sql database if it is not provided because it was
     * set to auto_increment. Therefore, only a record with a single column (name) is needed.
     */
    public Author insertAuthor(Author author){
        Connection connection = ConnectionUtil.getConnection();
        try {
            String sql = "INSERT INTO author(name) VALUES ?" ;
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, author.getName());
            
            preparedStatement.executeUpdate();
            ResultSet pkeyResultSet = preparedStatement.getGeneratedKeys();
            if(pkeyResultSet.next()){
                int generated_author_id = (int) pkeyResultSet.getLong(1);
                return new Author(generated_author_id, author.getName());
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
