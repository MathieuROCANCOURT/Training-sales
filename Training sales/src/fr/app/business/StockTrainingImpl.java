/**
 * 
 */
package fr.app.business;

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
	public void addTraining(String name, String description, int duration, boolean isInPerson, float price) {

	}

	@Override
	public void removeTraining(int trainingId) {

	}

	@Override
	public List<Training> listProducts() {
		return null;
	}

}
