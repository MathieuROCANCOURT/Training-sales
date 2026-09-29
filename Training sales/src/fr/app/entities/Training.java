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
		return Float.parseFloat(String.format("%.02f", this.price));
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setPrice(float price) {
		this.price = Float.parseFloat(String.format("%.02f", price));
	}

	@Override
	public String toString() {
		String strInPerson = isInPerson ? "en présentiel" : "en distanciel";
		return "[" + id + "] Cours de " + name + ", description:" + description + "\n, cette formation dure " + duration
				+ " jour(s), " + strInPerson + ". \nLe prix est de " + price + "€.";
	}

}
