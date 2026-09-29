/**
 * 
 */
package fr.app;

import java.sql.SQLException;

import fr.app.business.StockTraining;
import fr.app.business.StockTrainingImpl;
import fr.app.config.DatabaseConnection;
import fr.app.dao.TrainingDao;
import fr.app.entities.Training;

/**
 * 
 */
public class App {

	/**
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		StockTraining training = new StockTrainingImpl(new TrainingDao());
		
		for (Training trained: training.listTraining()) {
			System.out.println(trained);
		}
		for (Training trained: training.searchByKeyWord("SE")) {
			System.out.println(trained);
		}
		
		DatabaseConnection.closeConnection();
	}

}
