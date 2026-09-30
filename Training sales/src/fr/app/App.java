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
	 * @throws SQLException           Exception SQL or don't connect to database.
	 * @throws ClassNotFoundException The Driver Class isn't found.
	 */
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		StockTraining training = new StockTrainingImpl(new TrainingDao());
		boolean continueLoop = true;
		Scanner sc = new Scanner(System.in);

		System.out.println("Bienvenue sur le site pour la vente de formation.");
		Training.displayTitleAndHeaders("");
		Training.displayList(training.displayListByKeyWord(""));

		while (continueLoop) {
			System.out.print("Quelle mot clé voulez-vous cherchez ? ('EXIT' pour sortir/Entrée pour aucun mot clé):");
			String inputUser = sc.nextLine();

			if (inputUser.contentEquals("EXIT")) {
				continueLoop = false;

			} else {
				System.out.println(
						"Voulez-vous un filtrage en présentiel ou distanciel ? ['p':présentiel/'d':distanciel/non par défaut]");
				String inputUserOnSite = sc.nextLine();

				switch (inputUserOnSite.toLowerCase()) {
				case "p":
					Training.displayTitleAndHeaders(inputUser, true);
					Training.displayList(training.filterKeywordAndOnSiteOrRemote(inputUser, true));
					break;
				case "d":
					Training.displayTitleAndHeaders(inputUser, false);
					Training.displayList(training.filterKeywordAndOnSiteOrRemote(inputUser, false));
					break;
				default:
					Training.displayTitleAndHeaders(inputUser);
					Training.displayList(training.displayListByKeyWord(inputUser));
				}
			}
		}

		System.out.println("En revoir et à la prochaine 😉😉 !");
		sc.close();
		DatabaseConnection.closeConnection();
	}
}
