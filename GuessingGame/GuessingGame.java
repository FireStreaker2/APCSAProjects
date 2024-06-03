
// AP Comp Sci, October 30th, 2023
// Programming Project #5: Guessing Game (Chapter 5)

// This project is a simple guessing game that utilizes Java's Scanner and Random class. 
// It works by prompting the user for guesses, and then tells them whether the answer is
// higher or lower. Finally, when the user correctly guesses the answer, it output's their
// overall statistics, assuming they don't want to play again.

/* Stats:
 * 
 * 5 KB
 * ~72 lines without documentation
 * Made with <3
 */

// import libraries
import java.util.Random;
import java.util.Scanner;

// class
public class GuessingGame {
	// class constants for range
	public static final int min = 1;
	public static final int max = 1000000;

	// main method
	public static void main(String[] args) {
		// required game variables
		Random random = new Random();
		Scanner scanner = new Scanner(System.in);

		// note that we start the game with a y, this is so the while loop actually
		// works and doesnt break
		String input = "y";

		// stats
		// (note that we use doubles, this is so the guess/game stat is correct)
		double games = 0;
		double guesses = 0;
		int bestGuesses = 0;

		// main game loop (restarts if user input starts with a y)
		while (input.charAt(0) == 'y') {
			// start game and add result to total guesses
			int currentGuesses = startGame(scanner, random);
			guesses += currentGuesses;

			// increment amount of games
			games++;

			// assign best game if conditions are met
			if (currentGuesses < bestGuesses || games == 1)
				bestGuesses = currentGuesses;

			// ask for new game
			System.out.println("Play again? ");
			input = scanner.next().toLowerCase();

			// new line
			System.out.println();
		}

		// print out all of the stats
		System.out.println("Your overall results: ");
		System.out.println("Total games = " + (int) games); // typecast to int for full number
		System.out.println("Total guesses = " + (int) guesses); // same here
		System.out.printf("Guess/game = %.1f\n", (guesses / games)); // use ``printf`` here so we can round
		System.out.println("Best game = " + bestGuesses);
	}

	/*
	 * startGame method
	 * 
	 * this method starts the game, and allows it to be repeated inside a while loop
	 */
	public static int startGame(Scanner scanner, Random random) {
		// game variables
		int answer = random.nextInt(max - min + 1) + min;
		int guess = 0;
		int attempts = 0;
		int previousGuess = 0;

		// extra while loop to make sure answer isnt 0 at the start (will cause game to
		// end immediately)
		while (answer == guess)
			answer = random.nextInt(max - min + 1) + min;

		// initial statement
		System.out.println("I'm thinking of a number between " + min + " and " + max + "...");

		// guess loop
		while (guess != answer) {
			// ask for user input
			System.out.println("Your guess?");

			// check if input is a string
			if (scanner.hasNextInt()) {
				// get user input
				guess = scanner.nextInt();

				// logic for handling a integer user input
				if (guess > max || guess < min)
					System.out.println("Your guess was not a whole number between " + min + " and " + max);
				else if (guess < answer) {
					attempts++;
					System.out.println("It's higher.");
				} else if (guess > answer) {
					attempts++;
					System.out.println("It's lower.");
				}

				// output the "further away" message if conditions are met
				if (attempts != 1 && (Math.abs(answer - guess) > Math.abs(answer - previousGuess)))
					System.out.println("Your guess was further from the target number");

				// assign previousguess's value
				previousGuess = guess;

			} else {
				// exception for if guess wasnt an integer
				String input = scanner.next();
				System.out.println("Your guess was not a whole number between " + min + " and " + max);
			}
		}

		// print out number of attempts
		System.out.println("You guessed it in " + attempts + " guesses!");

		// return total attempts for this game session to be used later in final stats
		return attempts;

		/*
		 * note
		 * 
		 * i was originally planning to use recursion, but we havent learned that yet so
		 * i just stuck with a while loop in the main method
		 */
	}
}
