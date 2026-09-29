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
	void addTraining(long id, String name, int initialQuantity);

	void removeTraining(long productId, int quantity);

	List<Training> listProducts();
}
