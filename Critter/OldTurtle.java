// AP Comp Sci, February 9th, 2024
// Programming Project #9: Critters (Chapter 9)

/**
 * OldTurtle class
 *
 * "An OldTurtle is a Turtle. It alternates moving and staying still. When
 * moving, it acts like a Turtle."
 */
public class OldTurtle implements Critter {

  // private fields to keep track of where to move
  private int turns = 0;
  private int outerTurns = -1;
  private int direction;

  /**
   * getChar method
   *
   * Returns the character representing OldTurtle (O)
   */
  public char getChar() {
    return 'O';
  }

  /**
   * getMove method
   *
   * Returns the current move.
   */
  public int getMove(CritterInfo info) {
    // keep track of "outer turns"
    outerTurns++;

    if (outerTurns % 2 == 0) {
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
    } else {
      // don't move every other turn
      return CENTER;
    }
  }
}
