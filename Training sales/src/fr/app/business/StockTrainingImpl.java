/**
 * 
 */
package fr.app.business;

import java.sql.SQLException;
import java.util.List;

import fr.app.dao.TrainingDao;
import fr.app.entities.Training;

/**
 * StockTrainingImpl permit to check the data before send a SQL request to
 * database. It's a checking before use {@link TrainingDao} class.
 * 
 * @author RocancourtM
 */
public class StockTrainingImpl implements StockTraining {
	/**
	 * Database Access Object to Training table.
	 */
	private final TrainingDao trainingDao;

	/**
	 * Create a StockTrainingImpl where user can interact with the database.
	 * 
	 * @param trainingDao Database Access Object to Training table.
	 */
	public StockTrainingImpl(TrainingDao trainingDao) {
		this.trainingDao = trainingDao;
	}

	@Override
	public void addTraining(String name, String description, int duration, boolean isInPerson, float price)
			throws SQLException, ClassNotFoundException, IllegalArgumentException {
		if (name == null || name.trim().isEmpty()) {
			throw new IllegalArgumentException("Le nom est obligatoire");
		}
		if (description == null || description.trim().isEmpty()) {
			throw new IllegalArgumentException("La description est obligatoire");
		}
		if (duration < 1) {
			throw new IllegalArgumentException("La durée de la formation doit être strictement positif.");
		}
		if (price < 0) {
			throw new IllegalArgumentException("Le prix doit être positif.");
		}
		this.trainingDao.create(new Training(name, description, duration, isInPerson, price));
	}

	@Override
	public List<Training> displayListByKeyWord(String keyWord) throws SQLException, ClassNotFoundException {
		if (keyWord.isEmpty()) {
			return this.trainingDao.readAll();
		}
		return this.trainingDao.searchByKeyWord(keyWord);
	}

	@Override
	public List<Training> filterKeywordAndOnSiteOrRemote(String keyWord, boolean onSite)
			throws SQLException, ClassNotFoundException {
		if (keyWord.isEmpty()) {
			return this.trainingDao.filterOnSiteOrRemote(onSite);
		}
		return this.trainingDao.filterKeywordAndOnSiteOrRemote(keyWord, onSite);
	}
}
