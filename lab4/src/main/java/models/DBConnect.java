package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {

    private static final String url = "jdbc:mysql://106.12.146.48:3510/wqb_itmd510?rewriteBatchedStatements=true";
    private static final String username = "root";
    private static final String password = "itmd510";
    protected Connection connection;
    public DBConnect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println("Error creating connection to database: " + e);
            System.exit(-1);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }


}
