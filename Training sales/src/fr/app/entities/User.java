/**
 * 
 */
package fr.app.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 */
public class User {
	private int id;
	private String lastname;
	private String firstname;
	private String eMail;
	private Address address;
	private String phoneNumber;
	private List<Basket> listBasket = new ArrayList<Basket>();

	/**
	 * @param id
	 * @param lastname
	 * @param firstname
	 * @param eMail
	 * @param address
	 * @param phoneNumber
	 * @param listBasket
	 */
	public User(int id, String lastname, String firstname, String eMail, Address address, String phoneNumber,
			List<Basket> listBasket) {
		this.id = id;
		this.lastname = lastname;
		this.firstname = firstname;
		this.eMail = eMail;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.listBasket = listBasket;
	}

	/**
	 * @param lastname
	 * @param firstname
	 * @param eMail
	 * @param address
	 * @param phoneNumber
	 * @param listBasket
	 */
	public User(String lastname, String firstname, String eMail, Address address, String phoneNumber,
			List<Basket> listBasket) {
		this.lastname = lastname;
		this.firstname = firstname;
		this.eMail = eMail;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.listBasket = listBasket;
	}
}
