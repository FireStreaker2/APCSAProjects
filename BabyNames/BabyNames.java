// AP Comp Sci, October 30th, 2023
// Programming Project #6: Baby Names (Chapter 6)

// This program allows users to search for a baby name, and then print out the statistics
// regarding it's popularity. It does this by utilizing scanners, and reads not only the
// user input, but also the contents of a file which holds the data. When it's done, it
// prints the data in both the console and also a designated output file.

/* Stats:
 *
 * 4 KB
 * ~62 lines without documentation
 * Made with <3
 */

// import libraries
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

// class
public class BabyNames {

  // main method
  public static void main(String[] args) throws FileNotFoundException {
    // system variables
    Scanner userInput = new Scanner(System.in);
    Scanner fileInput = new Scanner(new File("names.txt"));

    // user input (start with a y in order to start the game)
    String input = "y";

    // initial title that only runs once
    System.out.println("** Popularity of a baby name since year 1900 **");
    System.out.println();

    // main game loop
    while (input.charAt(0) == 'y') {
      // start game
      start(userInput, fileInput);

      // ask if they would like to do it again
      System.out.println("Would you like to search another name?");
      input = userInput.next().toLowerCase();

      // new line
      System.out.println();
    }
  }

  /*
   * start method
   *
   * this isolates the program inside another method so we can have it loop over
   * and over again without using recursion
   */
  public static void start(Scanner userInput, Scanner fileInput)
    throws FileNotFoundException {
    // ask for user input
    System.out.println("name?");
    String name = userInput.next();

    // extra loop variables
    String line = "";
    boolean running = true;

    // while loop to find certain line
    while (fileInput.hasNextLine() && running) {
      // read every line
      line = fileInput.nextLine();
      Scanner lineInput = new Scanner(line);

      // stop outer loop if name is found
      while (lineInput.hasNext()) {
        if (lineInput.next().equalsIgnoreCase(name)) running = false;
      }
    }

    // check if name was found or not
    if (running) System.out.println("name not found.");
    else {
      // extra variables for printing
      int year = 1900;
      int iteration = 0;

      // create scanner for line
      Scanner readLine = new Scanner(line);

      // create output file (with funny logic for name)
      PrintStream output = new PrintStream(
        new File(
          name.toUpperCase().charAt(0) +
          name.toLowerCase().substring(1, name.length()) +
          ".txt"
        )
      );

      // add initial input to file
      output.println("name?");
      output.println(name);

      // read every token in the correct line
      while (readLine.hasNext()) {
        // store token in variable so we can use later
        String token = readLine.next();

        // skip the first token, which is the name
        if (iteration != 0) {
          // print info
          System.out.println(year + ":  " + token);

          // also print info to output
          output.println(year + ": " + token);

          // increase year
          year += 10;
        }

        // increase iteration
        iteration++;
      }
    }

    // new line
    System.out.println();
  }
}
