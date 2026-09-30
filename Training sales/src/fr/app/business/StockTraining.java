/**
 * 
 */
package fr.app.business;

import java.sql.SQLException;
import java.util.List;

import fr.app.dao.TrainingDao;
import fr.app.entities.Training;

/**
 * Interface to resume all actions to check or not before send a SQL request to
 * database with {@link TrainingDao}.
 * 
 * @author RocancourtM
 */
public interface StockTraining {
	void addTraining(String name, String description, int duration, boolean isInPerson, float price)
			throws SQLException, ClassNotFoundException;

	List<Training> displayListByKeyWord(String keyWord) throws SQLException, ClassNotFoundException;

	List<Training> filterKeywordAndOnSiteOrRemote(String keyWord, boolean onSite)
			throws SQLException, ClassNotFoundException;
}
