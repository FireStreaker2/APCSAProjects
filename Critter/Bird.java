
// AP Comp Sci, February 9th, 2024
// Programming Project #9: Critters (Chapter 9)

// import
import java.util.Random;

/**
 * Bird class
 * 
 * "Randomly selects one of the four directions each time"
 */
public class Bird implements Critter {
	/**
	 * getChar method
	 * 
	 * Returns the character representing Bird (B)
	 */
	public char getChar() {
		return 'B';
	}

	/**
	 * getMove method
	 * 
	 * Returns the current move.
	 */
	public int getMove(CritterInfo info) {
		// randomly select a move
		Random random = new Random();
		int number = random.nextInt(4);

		if (number == 0)
			return NORTH;
		if (number == 1)
			return EAST;
		if (number == 2)
			return SOUTH;
		else
			return WEST;
	}
}
