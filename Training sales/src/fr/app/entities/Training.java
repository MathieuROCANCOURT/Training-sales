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
	/**
	 * Draw a line to separate the column headers, the title, and the content into
	 * columns.
	 */
	private static final String SEPARATOR_HEADER = '\n' + new String(new char[90]).replace('\0', '-');
	/**
	 * A header format that left-aligns headers and inserts the necessary spaces.
	 */
	private static final String HEADER_FORMAT = String.format("%-20.20s | %-30.30s | %-9.9s | %-8.8s | %-8.8s",
			"Formation", "Description", "Durée (j)", "Sur site", "Prix (€)");

	/**
	 * Training course id.
	 */
	private int id;
	/**
	 * Training course name.
	 */
	private String name;
	/**
	 * Training course description.
	 */
	private String description;
	/**
	 * Training course duration represent in day.
	 */
	private int duration;
	/**
	 * true is it's on-site, else it's on remote.
	 */
	private boolean isInPerson;
	/**
	 * Training course price.
	 */
	private float price;

	/**
	 * Constructor Training with all attributes.
	 * 
	 * @param id          Training course id.
	 * @param name        Training course name.
	 * @param description Training description.
	 * @param duration    Training duration represent in day.
	 * @param isInPerson  true is it's on-site, else it's on remote.
	 * @param price       Training price.
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
	 * @param name        Training course name.
	 * @param description Training description.
	 * @param duration    Training duration represent in day.
	 * @param isInPerson  true is it's on-site, else it's on remote.
	 * @param price       Training price.
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
	 * Modify the training course id.
	 * 
	 * @param id New training id.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Modify the training course price.
	 * 
	 * @param price New training price.
	 */
	public void setPrice(float price) {
		if (price < 0) {
			price = Math.abs(price);
		}
		this.price = Float.parseFloat(String.format("%.2f", price));
	}

	@Override
	public String toString() {
		String strInPerson = isInPerson ? "en présentiel" : "en distanciel";
		return "[" + id + "] Cours de " + name + ", description:" + description + "\n, cette formation dure " + duration
				+ " jour(s), " + strInPerson + ". \nLe prix est de " + price + "€.";
	}

	/**
	 * Display on console the list of all training courses.<br>
	 * Use this documentation to format string:
	 * 
	 * @see <a
	 *      href=https://www.w3reference.com/blog/java-printf-print-formatted-string-to-console/>Formatted
	 *      String to console</a>
	 * 
	 * @param listTraining List of all training courses.
	 * 
	 */
	public static void displayList(List<Training> listTraining) {
		for (Training training : listTraining) {
			System.out.println(String.format("%-20.20s | %-30.30s | %-9d | %-8.8s | %-3.2f", training.name,
					training.description, training.duration, training.isInPerson ? "Oui" : "Non", training.getPrice()));
		}

		System.out.println(new String(new char[90]).replace('\0', '='));
	}

	/**
	 * Display on console title and headers table with separators.
	 * 
	 * @param keyWord The word used to filter the list by name and description.
	 * @param onSite  Used to filter the list list if it's on-site (true) or remote
	 *                (false).
	 */
	public static void displayTitleAndHeaders(String keyWord, boolean onSite) {
		String beginTitle = "Voici la liste des formations ".concat(onSite ? "en présentiel" : "en distanciel");

		if (keyWord.isEmpty()) {
			System.out.println(beginTitle + '.' + SEPARATOR_HEADER);
		} else {
			System.out.println(beginTitle + " en filtrant avec le mot: " + keyWord + SEPARATOR_HEADER);
		}

		System.out.println(HEADER_FORMAT + SEPARATOR_HEADER);
	}

	/**
	 * Display on console title and headers table with separators.
	 * 
	 * @param keyWord The word used to filter the list by name and description (word
	 *                empty: no filter).
	 */
	public static void displayTitleAndHeaders(String keyWord) {
		String beginTitle = "Voici la liste des formations";

		if (keyWord.isEmpty()) {
			System.out.println(beginTitle + '.' + SEPARATOR_HEADER);
		} else {
			System.out.println(beginTitle + " en filtrant avec le mot: " + keyWord + '.' + SEPARATOR_HEADER);
		}

		System.out.println(HEADER_FORMAT + SEPARATOR_HEADER);
	}
}
