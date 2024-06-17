// AP Comp Sci, April 3rd, 2024
// Programming Project #12: Boggle (Chapter 12)

// imports
import java.util.ArrayList;
import java.util.Collections;

/**
 * Program class
 *
 * Used to run the program
 */
public class Program {

  public static void main(String[] args) {
    System.out.println("Welcome to Boggle");

    WordList list = new WordList("./WordList.txt", 3, 8);
    Board board = new Board(list, 4);

    ArrayList<String> words = board.find();
    Collections.sort(words, new WordComparator());

    System.out.println(board.toString());
    System.out.println("Found " + words.size() + " word(s)\n");

    for (int i = list.getLongestWordLength(); i >= 3; i--) {
      // initial nested loop to see if there are any words of i length
      boolean found = false;
      for (String word : words) if (word.length() == i) {
        found = true;
        break;
      }

      // only print if there are words of i length
      if (found) System.out.println(i + " letter words");

      for (String word : words) if (word.length() == i) System.out.println(
        word
      );

      if (found) System.out.println("");
    }
  }
}
