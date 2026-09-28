/**
 * 
 */
package fr.app.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Logger;

import fr.app.config.DatabaseConnection;
import fr.app.entities.Training;

/**
 * 
 */
public class TrainingDao implements Dao<Training> {
	@Override
	public void create(Training training) throws SQLException {
		String execute = "INSERT INTO training(tr_name, tr_description, tr_duration, tr_inperson, tr_price) VALUES (?,?,?,?,?);";

		try (PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(execute,
				Statement.RETURN_GENERATED_KEYS)) {
			ps.setString(1, training.getName());
			ps.setString(2, training.getDescription());
			ps.setInt(3, training.getDuration());
			ps.setBoolean(4, training.getIsInPerson());
			ps.setFloat(5, training.getPrice());
			ps.executeUpdate();

			try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					training.setId(generatedKeys.getInt(1));
				} else {
					throw new SQLException("Insert succeeded but no ID obtained.");
				}
			}
		} catch (SQLException e) {
			Logger logger = Logger.getAnonymousLogger();
			logger.warning(e.getLocalizedMessage());
		}
	}

	@Override
	public List<Training> readAll() throws SQLException {
		return null;
	}

	@Override
	public Training read(int id) throws SQLException {
		return null;
	}

	@Override
	public void update(Training t) throws SQLException {

	}

	@Override
	public void delete(Training t) throws SQLException {

	}

}
