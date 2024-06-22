// AP Comp Sci, March 8th, 2024
// Programming Project #10: Shopping (Chapter 10)

// import
import java.util.ArrayList;

/**
 * Catalog class
 */
public class Catalog {

  // private fields
  private String name;
  private ArrayList<Item> list;

  /**
   * Simple constructor that accepts name
   *
   * @param name
   */
  public Catalog(String name) {
    this.name = name;
    this.list = new ArrayList<Item>();
  }

  /**
   * add method
   *
   * @param item
   */
  public void add(Item item) {
    list.add(item);
  }

  /**
   * size method
   *
   * @return size of the list
   */
  public int size() {
    return list.size();
  }

  /**
   * get method
   *
   * @param index
   * @return the item at the specified index
   */
  public Item get(int index) {
    return list.get(index);
  }

  /**
   * getName method
   *
   * @return a string version of the catalog
   */
  public String getName() {
    return name;
  }
}
