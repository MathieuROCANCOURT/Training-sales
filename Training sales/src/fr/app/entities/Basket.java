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
		this.setTotalPrice(totalPrice);
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
		return Float.parseFloat(String.format("%.2f", totalPrice));
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = Float.parseFloat(String.format("%.2f", totalPrice));
	}

	public boolean isBuy() {
		return isBuy;
	}

	public void addToBasket(Training training) {
		if (!this.isBuy) {
			this.listTraining.add(training);
			this.setTotalPrice(totalPrice + training.getPrice());
		}
	}
	
	public void removeToBasket(Training training) {
		if (!this.isBuy && this.listTraining.contains(training)) {
			this.listTraining.remove(training);
			this.setTotalPrice(totalPrice - training.getPrice());
		}
	}
}
