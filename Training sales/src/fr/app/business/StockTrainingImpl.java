/**
 * 
 */
package fr.app.business;

import java.sql.SQLException;
import java.util.List;

import fr.app.dao.TrainingDao;
import fr.app.entities.Training;

/**
 * 
 */
public class StockTrainingImpl implements StockTraining {
	private final TrainingDao trainingDao;

	/**
	 * @param trainingDao
	 */
	public StockTrainingImpl(TrainingDao trainingDao) {
		this.trainingDao = trainingDao;
	}

	@Override
	public void addTraining(String name, String description, int duration, boolean isInPerson, float price) throws SQLException {
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
	public List<Training> listTraining() throws SQLException {
		return this.trainingDao.readAll();
	}

	@Override
	public List<Training> searchByKeyWord(String keyWord) throws SQLException {
		return this.trainingDao.searchByKeyWord(keyWord);
	}

	@Override
	public List<Training> filterOnSiteOrRemote(boolean filterOnSite) throws SQLException {
		return this.trainingDao.filterOnSiteOrRemote(filterOnSite);
	}
	
	@Override
	public List<Training> filterKeywordAndOnSiteOrRemote(String keyWord, boolean onSite) throws SQLException {
		return this.trainingDao.filterKeywordAndOnSiteOrRemote(keyWord, onSite);
	}
}
