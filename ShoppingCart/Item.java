
// AP Comp Sci, March 8th, 2024
// Programming Project #10: Shopping (Chapter 10)

/**
 * Item class
 */
public class Item {
	// private fields
	private String name;
	private double price;

	private int bulkQuantity = -727;
	private double bulkPrice;

	/**
	 * First simple constructor
	 * 
	 * @param name
	 * @param price
	 */
	public Item(String name, double price) {
		if (price < 0)
			throw new IllegalArgumentException("Price cannot be negative!");

		this.name = name;
		this.price = price;
	}

	/**
	 * Second constructor for bulk orders
	 * 
	 * @param name
	 * @param price
	 * @param bulkQuantity
	 * @param bulkPrice
	 */
	public Item(String name, double price, int bulkQuantity, double bulkPrice) {
		if (price < 0 || bulkPrice < 0)
			throw new IllegalArgumentException("Price cannot be negative!");

		this.name = name;
		this.price = price;

		this.bulkQuantity = bulkQuantity;
		this.bulkPrice = bulkPrice;
	}

	/**
	 * priceFor method
	 * 
	 * @param quantity
	 * @return cost for a certain amount of this item
	 */
	public double priceFor(int quantity) {
		if (quantity < 0)
			throw new IllegalArgumentException("Quantity cannot be negative!");

		double price = 0;

		if (bulkQuantity == -727) {
			price = this.price * quantity;
		} else {
			int remaining = quantity % bulkQuantity;
			price += remaining * this.price;

			int bulkAmount = quantity - remaining;
			price += (bulkAmount * bulkPrice) / 10;
		}

		return price;
	}

	/**
	 * toString method
	 * 
	 * @return a string version of the item
	 */
	public String toString() {
		String result = String.format(this.name + ", $%.2f", this.price);

		if (this.bulkPrice != 0)
			result += String.format(" (" + this.bulkQuantity + " for $%.2f)", this.bulkPrice);

		return result;
	}
}
