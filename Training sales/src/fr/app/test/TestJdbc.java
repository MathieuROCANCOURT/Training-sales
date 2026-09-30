package fr.app.test;


import org.junit.jupiter.api.Test;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;

import fr.app.business.StockTraining;
import fr.app.business.StockTrainingImpl;
import fr.app.config.DatabaseConnection;
import fr.app.dao.TrainingDao;
import fr.app.entities.Training;

public class TestJdbc {
	public static void main(String[] args) throws SQLException, IllegalArgumentException {
		try (PreparedStatement st = DatabaseConnection.getConnection()
				.prepareStatement("ALTER TABLE training AUTO_INCREMENT = 1");) {
			st.executeUpdate();

			TrainingDao trainingDao = new TrainingDao();
			StockTraining stockTraining = new StockTrainingImpl(trainingDao);

			stockTraining.addTraining("Algèbre linéaire", "Matrice de passage", 2, false, 24.62f);

			/*
			// Generate IllegalArgumentException price.
			stockTraining.addTraining("Analyse", "Développement limité", 10, true, -2.62f);
			// Generate IllegalArgumentException description.
			stockTraining.addTraining("Proba", null, 10, true, 2.62f);
			// Generate IllegalArgumentException duration
			stockTraining.addTraining("Histoire des maths", "Figures célèbres des mathématiques.", -10, true, 2.62f);
			// Generate IllegalArgumentException name.
			stockTraining.addTraining(null, "Test", 10, false, 24.62f);
			*/

			Training.displayTitleAndHeaders("");
			Training.displayList(stockTraining.displayListByKeyWord(""));

			Training trainingTest = trainingDao.read(10);
			System.out.println(trainingTest);
			System.out.println(trainingDao.read(8));
			
			trainingTest.setId(15);
			trainingDao.delete(trainingTest);
			trainingTest.setId(16);
			trainingDao.delete(trainingTest);
			trainingTest.setId(17);
			trainingDao.delete(trainingTest);
			trainingTest.setId(10);
			
			trainingTest.setPrice(-2.3f);
			trainingDao.update(trainingTest);
			System.out.println(trainingDao.read(10));
			
			
		} catch (SQLException | IllegalArgumentException e) {
			Logger logger = Logger.getAnonymousLogger();
			logger.severe(e.getLocalizedMessage());
		} finally {
			DatabaseConnection.closeConnection();
		}
	}
}
