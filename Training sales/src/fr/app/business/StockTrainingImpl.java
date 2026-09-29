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
		super();
		this.trainingDao = trainingDao;
	}

	@Override
	public void addTraining(long id, String name, int initialQuantity) {

	}

	@Override
	public void removeTraining(long productId, int quantity) {

	}

	@Override
	public List<Training> listProducts() {
		return null;
	}

}
