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
	 * @param id
	 * @param name
	 * @param description
	 * @param duration
	 * @param isInPerson
	 * @param price
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
	 * @param name
	 * @param description
	 * @param duration
	 * @param isInPerson
	 * @param price
	 */
	public Training(String name, String description, int duration, boolean isInPerson, float price) {
		this.name = name;
		this.description = description;
		this.duration = duration;
		this.isInPerson = isInPerson;
		this.setPrice(price);
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public int getDuration() {
		return duration;
	}

	public boolean getIsInPerson() {
		return isInPerson;
	}

	public float getPrice() {
		return Float.parseFloat(String.format("%.2f", this.price));
	}

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
