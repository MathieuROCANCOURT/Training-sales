/**
 * 
 */
package fr.app.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
			logger.warning("Error create training request: " + e.getLocalizedMessage());
		}
	}

	@Override
	public List<Training> readAll() throws SQLException {
		List<Training> listTraining = new ArrayList<Training>();
		String execute = "SELECT tr_id_training, tr_name, tr_description, tr_duration, tr_inperson, tr_price FROM training;";

		try (PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(execute)) {
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					listTraining.add(new Training(rs.getInt("tr_id_training"), rs.getString("tr_name"),
							rs.getString("tr_description"), rs.getInt("tr_duration"), rs.getBoolean("tr_inperson"),
							rs.getFloat("tr_price")));
				}
			}
		} catch (SQLException e) {
			Logger logger = Logger.getAnonymousLogger();
			logger.warning("Error read all training request: " + e.getLocalizedMessage());
		}
		return listTraining;
	}

	@Override
	public Training read(int id) throws SQLException {
		String execute = "SELECT tr_id_training, tr_name, tr_description, tr_duration, tr_inperson, tr_price FROM training"
				+ "WHERE tr_id_training=?;";

		try (PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(execute)) {
			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					return new Training(rs.getInt("tr_id_training"), rs.getString("tr_name"),
							rs.getString("tr_description"), rs.getInt("tr_duration"), rs.getBoolean("tr_inperson"),
							rs.getFloat("tr_price"));
				}
			}
		} catch (SQLException e) {
			Logger logger = Logger.getAnonymousLogger();
			logger.warning("Error read training request: " + e.getLocalizedMessage());
		}
		return null;
	}

	public List<Training> searchByKeyWord(String keyWord) {
		List<Training> listTraining = new ArrayList<Training>();
		String execute = "SELECT tr_id_training, tr_name, tr_description, tr_duration, tr_inperson, tr_price FROM training"
				+ "WHERE tr_name LIKE %?% OR tr_description LIKE %?%;";

		try (PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(execute)) {
			ps.setString(1, keyWord);
			ps.setString(2, keyWord);
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					listTraining.add(new Training(rs.getInt("tr_id_training"), rs.getString("tr_name"),
							rs.getString("tr_description"), rs.getInt("tr_duration"), rs.getBoolean("tr_inperson"),
							rs.getFloat("tr_price")));
				}
			}
		} catch (SQLException e) {
			Logger logger = Logger.getAnonymousLogger();
			logger.warning("Error read all training request: " + e.getLocalizedMessage());
		}
		return listTraining;
	}

	@Override
	public void update(Training training) throws SQLException {
		String execute = "UPDATE training"
				+ "SET tr_name = ?, tr_description = ?, tr_duration = ?, tr_inperson = ?, tr_price = ?"
				+ "WHERE tr_id_training = ?;";

		try (PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(execute)) {
			ps.setString(1, training.getName());
			ps.setString(2, training.getDescription());
			ps.setInt(3, training.getDuration());
			ps.setBoolean(4, training.getIsInPerson());
			ps.setFloat(5, training.getPrice());
			ps.setInt(6, training.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			Logger logger = Logger.getAnonymousLogger();
			logger.warning("Error update training request: " + e.getLocalizedMessage());
		}
	}

	@Override
	public void delete(Training training) throws SQLException {
		String execute = "DELETE FROM training WHERE tr_id_training = ?;";

		try (PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(execute)) {
			ps.setInt(1, training.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			Logger logger = Logger.getAnonymousLogger();
			logger.warning("Error delete training request: " + e.getLocalizedMessage());
		}
	}

}
