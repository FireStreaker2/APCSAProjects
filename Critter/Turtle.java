// AP Comp Sci, February 9th, 2024
// Programming Project #9: Critters (Chapter 9)

/**
 * Turtle class
 *
 * "South 5, west 5, north 5, east 5, repeat (clockwise box)"
 */
public class Turtle implements Critter {

  // private fields to keep track of where to move
  private int turns = 0;
  private int direction;

  /**
   * getChar method
   *
   * Returns the character representing Turtle (T)
   */
  public char getChar() {
    return 'T';
  }

  /**
   * getMove method
   *
   * Returns the current move.
   */
  public int getMove(CritterInfo info) {
    // go to next direction every 5 moves
    if (turns % 5 == 0) {
      if (turns == 0) direction = SOUTH;
      else if (turns == 5) direction = WEST;
      else if (turns == 10) direction = NORTH;
      else if (turns == 15) direction = EAST;
      else if (turns == 20) {
        turns = 0;
        direction = SOUTH;
      }
    }

    turns++;

    return direction;
  }
}
