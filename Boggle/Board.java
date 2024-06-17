// AP Comp Sci, April 3rd, 2024
// Programming Project #12: Boggle (Chapter 12)

// imports
import java.util.ArrayList;
import java.util.Random;

/**
 * Board class
 */
public class Board {

  // private fields
  public String[][] array; // ALL LETTERS IN THE BOGGLE BOARD
  private WordList words; // ALL VALID WORDS IN THE WORD LIST

  /**
   * Constructor for the board
   *
   * @param list
   * @param size
   */
  public Board(WordList list, int size) {
    // initialize fields
    words = list;
    array = new String[size][size];

    // populate boggle board using nextLetter method
    for (int i = 0; i < size; i++) for (
      int j = 0;
      j < array[i].length;
      j++
    ) array[i][j] = words.nextLetter().toUpperCase();
  }

  /**
   * Find method
   *
   * Recursively goes through the boggle board and checks all valid words using
   * backtracking
   *
   * @return
   */
  public ArrayList<String> find() {
    // array list that holds all valid words
    ArrayList<String> valids = new ArrayList<String>();

    boolean visited[][] = new boolean[array.length][array.length];

    String str = "";

    for (int i = 0; i < array.length; i++) for (
      int j = 0;
      j < array.length;
      j++
    ) find(array, visited, i, j, str, valids);

    ArrayList<String> seen = new ArrayList<String>();

    for (int i = valids.size() - 1; i >= 0; i--) {
      if (seen.contains(valids.get(i))) valids.remove(i);

      seen.add(valids.get(i));
    }

    // prefix code
    String[] prefixes = { "RE", "STR", "UN" };

    Random random = new Random();
    String prefix = prefixes[random.nextInt(prefixes.length)];

    int x = random.nextInt(array.length);
    int y = random.nextInt(array.length);

    for (int i = 0; i < prefix.length(); i++) {
      if (x + i >= array.length && y + i >= array.length) array[x - i][y - i] =
        prefix.charAt(i) + "";
      else if (x + i >= array.length && y + i < array.length) array[x - i][y +
        i] = prefix.charAt(i) + "";
      else if (x + i < array.length && y + i >= array.length) array[x + i][y -
        i] = prefix.charAt(i) + "";
      else array[x + i][y + i] = prefix.charAt(i) + "";
    }

    return valids;
  }

  /**
   * Find method helper
   *
   * Helper method with overloads to assist the main find method
   *
   * @param boggle
   * @param visited
   * @param i
   * @param j
   * @param result
   * @param valids
   */
  public void find(
    String boggle[][],
    boolean visited[][],
    int i,
    int j,
    String result,
    ArrayList<String> valids
  ) {
    visited[i][j] = true;
    result = result + boggle[i][j];

    for (int row = i - 1; row <= i + 1 && row < array.length; row++) for (
      int col = j - 1;
      col <= j + 1 && col < array.length;
      col++
    ) if (row >= 0 && col >= 0 && !visited[row][col]) find(
      boggle,
      visited,
      row,
      col,
      result,
      valids
    );

    // don't continue if it's too long
    if (result.length() > words.getLongestWordLength()) return;

    if (words.contains(result)) valids.add(result);

    visited[i][j] = false;
  }

  /**
   * toString method
   *
   * @return string version of the board
   */
  public String toString() {
    String result = "";

    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array[i].length; j++) {
        result += array[i][j] + " ";
      }

      result += "\n";
    }

    return result;
  }
}
