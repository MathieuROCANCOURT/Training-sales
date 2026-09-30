/**
 * 
 */
package fr.app.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 * Create a connection with 'training_sales' database with MariaDB.
 * 
 * @author RocancourtM
 */
public class DatabaseConnection {
	/**
	 * URL used to connect to the 'training_sales' database.
	 */
	private static final String URL = "jdbc:mariadb://localhost:3306/training_sales";
	/**
	 * User used to connect to database.
	 */
	private static final String USER = "root";
	/**
	 * Password used to connect to database.
	 */
	private static final String PASSWORD = System.getProperty("database.password");

	/**
	 * DatabaseConnection Constructor.
	 */
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