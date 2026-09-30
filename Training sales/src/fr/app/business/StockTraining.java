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
			throws SQLException, ClassNotFoundException;

	List<Training> displayListByKeyWord(String keyWord) throws SQLException, ClassNotFoundException;

	List<Training> filterKeywordAndOnSiteOrRemote(String keyWord, boolean onSite) throws SQLException, ClassNotFoundException;
}
