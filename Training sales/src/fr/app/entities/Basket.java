/**
 * 
 */
package fr.app.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 */
public class Basket {
	private int id;
	private List<Training> listTraining = new ArrayList<Training>();
	private float totalPrice = 0f;
	private boolean isBuy = false;
	
	public Basket() {
	}

	/**
	 * @param listTraining
	 * @param totalPrice
	 * @param isBuy
	 */
	public Basket(List<Training> listTraining, float totalPrice, boolean isBuy) {
		this.listTraining = listTraining;
		this.totalPrice = totalPrice;
		this.isBuy = isBuy;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Training> getListTraining() {
		return listTraining;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public boolean isBuy() {
		return isBuy;
	}

}
