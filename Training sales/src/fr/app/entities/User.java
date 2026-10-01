/**
 * 
 */
package fr.app.entities;

import java.util.ArrayList;

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
	private ArrayList<Basket> listBasket = new ArrayList<Basket>();
}
