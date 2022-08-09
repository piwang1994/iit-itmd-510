package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect  {

	protected Connection connection;
	public Connection getConnection() {
		return connection;
	}

	private static String url = "jdbc:mysql://www.papademas.net:3307/510fp";
	private static String username = "fp510";
	private static String password = "510";

	public DBConnect() {
		try {
            Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			System.out.println("Error creating connection to database: " + e);
			System.exit(-1);
		} catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

	
}
