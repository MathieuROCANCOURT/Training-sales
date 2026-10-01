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
}
