/**
 * 
 */
package fr.app.entities;

/**
 * 
 */
public class Address {
	private int id;
	private String street;
	private String city;

	/**
	 * @param id
	 * @param street
	 * @param city
	 */
	public Address(int id, String street, String city) {
		this.id = id;
		this.street = street;
		this.city = city;
	}

	/**
	 * @param street
	 * @param city
	 */
	public Address(String street, String city) {
		this.street = street;
		this.city = city;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	
	
}
