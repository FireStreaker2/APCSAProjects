
// AP Comp Sci, February 9th, 2024
// Programming Project #9: Critters (Chapter 9)

/**
 * Wolf class
 * 
 * "You define this, no implementation will lower grade"
 */
public class Wolf implements Critter {
	// private fields to keep track of where to move
	private int turns = 0;
	private int direction;
	private int amount = 2;

	/**
	 * getChar method
	 * 
	 * Returns the character representing Wolf (W)
	 */
	public char getChar() {
		return 'W';
	}

	/**
	 * getMove method
	 * 
	 * Returns the current move.
	 */
	public int getMove(CritterInfo info) {
		// move in a spiral like shape
		if (turns % amount == 0) {
			if (turns == 0)
				direction = SOUTH;
			else if (turns == amount)
				direction = WEST;
			else if (turns == amount * 2)
				direction = NORTH;
			else if (turns == amount * 3)
				direction = EAST;
			else if (turns == amount * 4) {
				turns = 0;
				direction = SOUTH;
				// increase amount once a loop has been finished
				amount++;
			}
		}

		turns++;

		return direction;
	}
}
