/**
 * 
 */
package fr.app.business;

import java.sql.SQLException;
import java.util.List;
import fr.app.entities.Training;

/**
 * 
 */
public interface StockTraining {
	void addTraining(String name, String description, int duration, boolean isInPerson, float price)
			throws SQLException;

	List<Training> listTraining() throws SQLException;

	List<Training> searchByKeyWord(String keyWord) throws SQLException;
}
