/**
 * 
 */
package fr.app.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;
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

	/**
	 * Create a connection to 'training_sales' database.
	 * 
	 * @return A connection with a 'training_sales' database. SQL statements are
	 *         executed and results are returned within the context of a connection.
	 * @throws SQLException           Error SQL Request or Timeout connection.
	 * @throws ClassNotFoundException The Driver Class isn't found.
	 */
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			Logger logger = Logger.getAnonymousLogger();
			logger.severe(e.getLocalizedMessage());
		}

		return DriverManager.getConnection(URL, USER, PASSWORD);
	}

	/**
	 * Close connection to 'training_sales' database.
	 * 
	 * @throws SQLException           Error SQL Request or Timeout connection.
	 * @throws ClassNotFoundException The Driver Class isn't found.
	 */
	public static void closeConnection() throws SQLException, ClassNotFoundException {
		try {
			getConnection().close();
		} catch (SQLException | ClassNotFoundException e) {
			Logger logger = Logger.getAnonymousLogger();
			logger.severe("Error close connection: " + e.getLocalizedMessage());
		}
	}
}