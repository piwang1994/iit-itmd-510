import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class HashDao {
    // instance fields
    static Connection connect = null;
    Statement statement = null;

    // constructor
    public static Connection getConnection() {
        // Setup the connection with the DB
        try {
            connect = DriverManager
                    .getConnection("jdbc:mysql://www.papademas.net:3307/510fp?autoReconnect=true&useSSL=false"
                            + "&user=fp510&password=510");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connect;
    }

}
