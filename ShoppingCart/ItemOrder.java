// AP Comp Sci, March 8th, 2024
// Programming Project #10: Shopping (Chapter 10)

/**
 * ItemOrder class
 */
public class ItemOrder {

  // private fields
  private Item item;
  private int quantity;

  /**
   * Constructor
   *
   * @param item
   * @param quantity
   */
  public ItemOrder(Item item, int quantity) {
    this.item = item;
    this.quantity = quantity;
  }

  /**
   * getPrice method
   *
   * @return the price for a certain amount of an item
   */
  public double getPrice() {
    return item.priceFor(quantity);
  }

  /**
   * getItem method
   *
   * @return the corresponding item
   */
  public Item getItem() {
    return item;
  }
}
