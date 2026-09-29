/**
 * 
 */
package fr.app;

import java.sql.SQLException;
import java.util.Scanner;

import fr.app.business.StockTraining;
import fr.app.business.StockTrainingImpl;
import fr.app.config.DatabaseConnection;
import fr.app.dao.TrainingDao;
import fr.app.entities.Training;

/**
 * This class launches the main program. The application connects to the
 * database to access the training courses.
 * 
 * @author RocancourtM
 */
public class App {
	/**
	 * Main program that user can input a keyword, display training list or exit the
	 * program.
	 * 
	 * @param args Nothing
	 * @throws SQLException Exception SQL or don't connect to database.
	 */
	public static void main(String[] args) throws SQLException {
		StockTraining training = new StockTrainingImpl(new TrainingDao());
		boolean continueLoop = true;
		Scanner sc = new Scanner(System.in);

		System.out.println("Bienvenue sur le site pour la vente de formation.");
		Training.displayList(training.listTraining());

		while (continueLoop) {
			System.out.print(
					"Quelle mote clé voulez-vous cherchez ? ('EXIT' pour sortir/Entrée pour réafficher la liste):");
			String inputUser = sc.nextLine();
			if (inputUser.isEmpty()) {
				Training.displayList(training.listTraining());
			} else if (inputUser.contentEquals("EXIT")) {
				continueLoop = false;
			} else {
				Training.displayList(training.searchByKeyWord(inputUser), inputUser);
			}
		}

		System.out.println("En revoir et à la prochaine 😉😉 !");
		sc.close();
		DatabaseConnection.closeConnection();
	}

}
