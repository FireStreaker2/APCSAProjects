// AP Comp Sci, February 9th, 2024
// Programming Project #9: Critters (Chapter 9)

// import
import java.util.Random;

/**
 * Frog class
 *
 * "Picks a random direction, moves 3 in that direction, repeat (same as bird,
 * but staying in a single direction longer)"
 */
public class Frog implements Critter {

  // private fields to keep track of where to move
  private int turns = 3;
  private int direction;

  /**
   * getChar method
   *
   * Returns the character representing Frog (F)
   */
  public char getChar() {
    return 'F';
  }

  /**
   * getMove method
   *
   * Returns the current move.
   */
  public int getMove(CritterInfo info) {
    // decide a new direction every three moves
    if (turns == 3) {
      turns = 0;

      Random random = new Random();
      int number = random.nextInt(4);

      if (number == 0) direction = NORTH;
      else if (number == 1) direction = EAST;
      else if (number == 2) direction = SOUTH;
      else direction = WEST;
    }

    turns++;

    return direction;
  }
}
