/**
 * 
 */
package fr.app.entities;

/**
 * 
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
		this.price = price;
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

	public boolean isInPerson() {
		return isInPerson;
	}

	public float getPrice() {
		return price;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		String strInPerson = isInPerson ? "en présentiel" : "en distanciel";
		return "[" + id + "] Cours de " + name + ", description:" + description + "\n, cette formation dure " + duration
				+ " jour(s), " + strInPerson + ". \nLe prix est de " + price + "€.";
	}

}
