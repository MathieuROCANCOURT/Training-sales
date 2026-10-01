/**
 * 
 */
package fr.app.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

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
		this.setLastname(lastname);
		this.setFirstname(firstname);
		this.eMail = eMail;
		this.address = address;
		this.setPhoneNumber(phoneNumber);
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
		this.setLastname(lastname);
		this.setFirstname(firstname);
		this.eMail = eMail;
		this.address = address;
		this.setPhoneNumber(phoneNumber);
		this.listBasket = listBasket;
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
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		if (lastname != null && !lastname.isEmpty()) {
			this.lastname = lastname;
		}
	}

	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		if (firstname != null && !firstname.isEmpty()) {
			this.firstname = firstname;
		}
	}

	/**
	 * @return the eMail
	 */
	public String getEMail() {
		return eMail;
	}

	/**
	 * @param eMail the eMail to set
	 */
	public void setEMail(String eMail) {
		this.eMail = eMail;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		if (phoneNumber.length() == 10 && phoneNumber.matches("\\d")) {
			this.phoneNumber = phoneNumber;
		}
	}

	@Override
	public String toString() {
		return "Voici les coordonnées de l'utilisateur:\nNom: " + lastname + ", Prénom: " + firstname + "\nCourriel="
				+ eMail + "\nAdresse: " + address.toString() + "\nNuméro de téléphone: " + phoneNumber
				+ "\nVoici la liste de vos paniers:\n" + listBasket.toString();
	}

}
