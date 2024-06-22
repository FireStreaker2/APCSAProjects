// AP Comp Sci, April 3rd, 2024
// Programming Project #12: Boggle (Chapter 12)

// import
import java.util.Comparator;

/**
 * WordComparator class
 *
 * Implements the Comparator class in order to sort by length and then
 * alphabetically
 */
public class WordComparator implements Comparator<String> {

  /**
   * compare method
   *
   * Method that contains the actual logic for comparison
   */
  public int compare(String firstWord, String secondWord) {
    if (firstWord.length() != secondWord.length()) return (
      firstWord.length() - secondWord.length()
    );

    return firstWord.compareTo(secondWord);
  }
}
