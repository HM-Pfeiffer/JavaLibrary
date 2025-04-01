package Application.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * The ConnectionUtil class will be utilized to create an active connection to our database. This class utilizes the
 * singleton design pattern. It's utilizing an in-memory called h2database. In-memory means that the database
 * is dissolved when the program ends - it is only for use in testing.
 */
public class ConnectionUtil {
    
    //url will represent the connection string. Since this is an in-memory db, file location to store the data will be represented
    private static String url = "jdbc:h2:./h2/db";
    private static String username = "sa";
    private static String password = "sa";

    private static Connection connection = null;

    /**
     * @return active connection to the database
     */
    public static Connection getConnection(){
        if(connection == null){
            try {
                connection = DriverManager.getConnection(url, username, password);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return connection;
    }

}
