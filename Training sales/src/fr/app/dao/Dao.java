package fr.app.dao;

import java.sql.SQLException;
import java.util.List;

/**
 * Dao interface where each table can be send request to the database where the
 * administrator can:
 * <ul>
 * <li>Create an object</li>
 * <li>Dead all objects</li>
 * <li>Read an object</li>
 * <li>Update an object</li>
 * <li>Delete an object</li>
 * </ul>
 * 
 * @author RocancourtM
 */
public interface Dao<T> {
	/**
	 * Create an object in database with associated table and to affect an id.
	 * 
	 * @param t Object to create in database.
	 * @throws SQLException Generate an error SQL request.
	 * @throws ClassNotFoundException The Driver Class isn't found.
	 */
	public void create(T t) throws SQLException, ClassNotFoundException;

	/**
	 * Read all objects in database with associated table.
	 * 
	 * @return List of all elements in a table.
	 * @throws SQLException Generate an error SQL request.
	 * @throws ClassNotFoundException The Driver Class isn't found.
	 */
	public List<T> readAll() throws SQLException, ClassNotFoundException;

	/**
	 * Read an object in database with associated table and associated id.
	 * 
	 * @param id Id to read in database.
	 * @return The object associates by id.
	 * @throws SQLException Generate an error SQL request.
	 * @throws ClassNotFoundException The Driver Class isn't found.
	 */
	public T read(int id) throws SQLException, ClassNotFoundException;

	/**
	 * Update an object in database with associated table and associated id.
	 * 
	 * @param t Object to update in database.
	 * @throws SQLException Generate an error SQL request.
	 * @throws ClassNotFoundException The Driver Class isn't found.
	 */
	public void update(T t) throws SQLException, ClassNotFoundException;

	/**
	 * Delete an object in database with table associated.
	 * 
	 * @param t Object to create in database.
	 * @throws SQLException Generate an error SQL request.
	 * @throws ClassNotFoundException The Driver Class isn't found.
	 */
	public void delete(T t) throws SQLException, ClassNotFoundException;
}
