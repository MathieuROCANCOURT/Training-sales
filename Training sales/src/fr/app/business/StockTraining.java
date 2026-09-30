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
	/**
	 * Check all variables if not null and valid to create a training course in
	 * training table.
	 * 
	 * @param name        Training course name.
	 * @param description Training course description.
	 * @param duration    Training course duration in day.
	 * @param isInPerson  True if training course is on-site, else false is remote.
	 * @param price       Training course price.
	 * @throws SQLException             Error SQL Request or Timeout connection.
	 * @throws ClassNotFoundException   The Driver Class isn't found.
	 * @throws IllegalArgumentException Error if name or description is null or
	 *                                  empty or duration is inferior to 1 or price
	 *                                  is inferior to 0.
	 */
	void addTraining(String name, String description, int duration, boolean isInPerson, float price)
			throws SQLException, ClassNotFoundException, IllegalArgumentException;

	/**
	 * Send a SQL request with the keyWord in the criteria.
	 * 
	 * @param keyWord Word to filter in SQL Request on name and description columns.
	 * @return Training list with keyWord filter or all list if keyWord is empty.
	 * @throws SQLException           Error SQL Request or Timeout connection.
	 * @throws ClassNotFoundException he Driver Class isn't found.
	 */
	List<Training> displayListByKeyWord(String keyWord) throws SQLException, ClassNotFoundException;

	/**
	 * Send a SQL request with the keyWord and if on-site or remote in the criteria.
	 * 
	 * @param keyWord Word to filter in SQL Request on name and description columns.
	 * @param onSite  true if filter on-site, false if filter remote.
	 * @return Training list with keyWord filter or all list if keyWord is empty.
	 * @throws SQLException           Error SQL Request or Timeout connection.
	 * @throws ClassNotFoundException he Driver Class isn't found.
	 */
	List<Training> filterKeywordAndOnSiteOrRemote(String keyWord, boolean onSite)
			throws SQLException, ClassNotFoundException;
}
