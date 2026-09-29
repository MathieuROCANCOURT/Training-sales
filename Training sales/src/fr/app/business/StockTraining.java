/**
 * 
 */
package fr.app.business;

import java.util.List;
import fr.app.entities.Training;

/**
 * 
 */
public interface StockTraining {
	void addTraining(String name, String description, int duration, boolean isInPerson, float price);

	void removeTraining(int trainingId);

	List<Training> listProducts();
}
