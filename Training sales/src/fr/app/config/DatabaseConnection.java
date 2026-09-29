/**
 * 
 */
package fr.app.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 * 
 */
public class DatabaseConnection {
	private static final String URL = "jdbc:mariadb://localhost:3306/shop";
	private static final String USER = "root";
	private static final String PASSWORD = System.getProperty("database.password");

	private DatabaseConnection() {
	}

	public static Connection getConnection() throws SQLException {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			Logger logger = Logger.getAnonymousLogger();
			logger.severe(e.getLocalizedMessage());
		}

		return DriverManager.getConnection(URL, USER, PASSWORD);
	}

	public static void closeConnection() {
		try {
			getConnection().close();
		} catch (SQLException e) {
			Logger logger = Logger.getAnonymousLogger();
			logger.severe("Error close connection: " + e.getLocalizedMessage());
		}
	}
}