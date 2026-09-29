/**
 * 
 */
package fr.app.entities;

import java.util.List;

/**
 * Training is an entity to generate, read, update or delete in the database.
 * 
 * @author RocancourtM
 */
public class Training {
	private int id;
	private String name;
	private String description;
	private int duration;
	private boolean isInPerson;
	private float price;

	/**
	 * Constructor Training with all attributes.
	 * 
	 * @param id Training course id.
	 * @param name Training course name.
	 * @param description Training description.
	 * @param duration Training duration represent in day.
	 * @param isInPerson true is it's on-site, else it's on remote.
	 * @param price Training price.
	 */
	public Training(int id, String name, String description, int duration, boolean isInPerson, float price) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.duration = duration;
		this.isInPerson = isInPerson;
		this.setPrice(price);
	}

	/**
	 * Constructor Training without id attribute.
	 * 
	 * @param name Training course name.
	 * @param description Training description.
	 * @param duration Training duration represent in day.
	 * @param isInPerson true is it's on-site, else it's on remote.
	 * @param price Training price.
	 */
	public Training(String name, String description, int duration, boolean isInPerson, float price) {
		this.name = name;
		this.description = description;
		this.duration = duration;
		this.isInPerson = isInPerson;
		this.setPrice(price);
	}

	/**
	 * Get the training course id.
	 * 
	 * @return Training course id.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Get the training course name.
	 * 
	 * @return Training course name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Get the training course description.
	 * 
	 * @return Training description.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Get the duration of the training course in day(s).
	 * 
	 * @return Training duration
	 */
	public int getDuration() {
		return duration;
	}

	/**
	 * Get a boolean is the training course is on-site or not.
	 * 
	 * @return true if on-site, false if remote.
	 */
	public boolean getIsInPerson() {
		return isInPerson;
	}

	/**
	 * Get the training course price.
	 * 
	 * @return Training price.
	 */
	public float getPrice() {
		return Float.parseFloat(String.format("%.2f", this.price));
	}

	/**
	 * Set the training course id.
	 * 
	 * @param id New training id.
	 */
	public void setId(int id) {
		this.id = id;
	}

	public void setPrice(float price) {
		this.price = Float.parseFloat(String.format("%.2f", price));
	}

	@Override
	public String toString() {
		String strInPerson = isInPerson ? "en présentiel" : "en distanciel";
		return "[" + id + "] Cours de " + name + ", description:" + description + "\n, cette formation dure " + duration
				+ " jour(s), " + strInPerson + ". \nLe prix est de " + price + "€.";
	}

	/**
	 * {@linkplain https://www.w3reference.com/blog/java-printf-print-formatted-string-to-console/}
	 * 
	 * @param listTraining
	 */
	public static void displayList(List<Training> listTraining) {
		System.out.println("Voici la liste des formations\n" + new String(new char[90]).replace('\0', '-'));
		System.out.println(String.format("%-20.20s | %-30.30s | %-9.9s | %-8.8s | %-8.8s", "Formation", "Description",
				"Durée (j)", "Sur site", "Prix (€)"));
		System.out.println(new String(new char[90]).replace('\0', '-'));

		for (Training training : listTraining) {
			System.out.println(
					String.format("%-20.20s | %-30.30s | %-9d | %-8.8s | %-3.2f", training.name, training.description,
							training.duration, training.isInPerson ? "Oui" : "Non", training.getPrice()));
		}
		
		System.out.println(new String(new char[90]).replace('\0', '='));
	}

	/**
	 * {@linkplain https://www.w3reference.com/blog/java-printf-print-formatted-string-to-console/}
	 * 
	 * @param listTraining
	 */
	public static void displayList(List<Training> listTraining, String keyWord) {
		System.out.println("Voici la liste des formations en filtrant avec le mot: " + keyWord + "\n"
				+ new String(new char[90]).replace('\0', '-'));
		System.out.println(String.format("%-20.20s | %-30.30s | %-9.9s | %-8.8s | %-8.8s", "Formation", "Description",
				"Durée (j)", "Sur site", "Prix (€)"));
		System.out.println(new String(new char[90]).replace('\0', '-'));

		for (Training training : listTraining) {
			System.out.println(
					String.format("%-20.20s | %-30.30s | %-9d | %-8.8s | %-3.2f", training.name, training.description,
							training.duration, training.isInPerson ? "Oui" : "Non", training.getPrice()));
		}

		System.out.println(new String(new char[90]).replace('\0', '='));
	}
}
