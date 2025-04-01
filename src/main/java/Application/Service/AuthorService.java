package Application.Service;

import Application.Model.Author;
import Application.DAO.AuthorDAO;

import java.util.List;

/**
 * The purpose of a Service class is to contain "business logic" that sits between the web layer (controller) and DAO
 */
public class AuthorService {
    private AuthorDAO authorDAO;
    /**
     * no-args constructor for creating a new AuthorService with a new AuthorDAO.
     */
    public AuthorService(){
        authorDAO = new AuthorDAO();
    }
    /**
     * Constructor for a AuthorService when a AuthorDAO is provided.
     * This is used for when a mock AuthorDAO that exhibits mock behavior is used in the test cases.
     * @param authorDAO
     */
    public AuthorService(AuthorDAO authorDAO){
        this.authorDAO = authorDAO;
    }
    /**
     * TODO: Use the AuthorDAO to retrieve all authors.
     *
     * @return all authors
     */
    public List<Author> getAllAuthors() {
        return authorDAO.getAllAuthors();
    }
    /**
     * TODO: Use the AuthorDAO to persist an author. The given Author will not have an id provided.
     *
     * @param author an author object.
     * @return The persisted author if the persistence is successful.
     */
    public Author addAuthor(Author author) {
        return authorDAO.insertAuthor(author);
    }
}
