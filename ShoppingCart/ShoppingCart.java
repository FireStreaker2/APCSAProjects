// AP Comp Sci, March 8th, 2024
// Programming Project #10: Shopping (Chapter 10)

// import
import java.util.ArrayList;

/**
 * ShoppingCart class
 */
public class ShoppingCart {

  // private fields
  private ArrayList<ItemOrder> list;
  private boolean discount;

  /**
   * Constructor that doesn't accept anything
   */
  public ShoppingCart() {
    this.list = new ArrayList<ItemOrder>();
  }

  /**
   * add method
   *
   * @param order
   */
  public void add(ItemOrder order) {
    boolean contains = false;
    int index = -1;

    // check if it already contains the order
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getItem() == order.getItem()) {
        contains = true;
        index = i;
        break;
      }
    }

    if (contains) list.set(index, order);
    else list.add(order);
  }

  /**
   * setDiscount method
   *
   * @param value
   */
  public void setDiscount(boolean value) {
    this.discount = value;
  }

  /**
   * getTotal method
   *
   * @return the total cost, including discounts
   */
  public double getTotal() {
    double total = 0;

    for (ItemOrder order : list) total += order.getPrice();

    if (this.discount) total = total - total * 0.1;

    return total;
  }
}
