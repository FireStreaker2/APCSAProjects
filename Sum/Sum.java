// AP Comp Sci, December 15th, 2023
// Programming Project #7: Sum (Chapter 7)

// This project adds together big numbers using arrays. Because of the integer limit, you cannot
// directly add them together. So instead, we utilize arrays to add together columns slowly until
// we get our result. Moreover, this program also reads from a file in order to receive it's input,
// and then displays the results neatly in stdout.

/* Stats:
 *
 * 5 KB
 * ~70 lines without documentation
 * Made with <3
 */

// import libraries
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// main class
public class Sum {

  // class constant
  public static final int digitLength = 25; // maximum length of each digit
  public static final int tokenAmount = 8; // maximum number of numbers in one line

  // main method
  public static void main(String[] args) throws FileNotFoundException {
    // file scanner
    Scanner scanner = new Scanner(new File("sum.txt"));

    // keep track of line count to use at the end
    int lines = 0;

    // read every line
    while (scanner.hasNextLine()) {
      // declare array to store every token in the current line
      // but as an array so we can add them
      int[][] array = new int[tokenAmount][digitLength];

      // increase line count
      lines++;

      // make variable to keep track of current token
      int iteration = 0;

      // read every token in the line
      Scanner lineScanner = new Scanner(scanner.nextLine());

      while (lineScanner.hasNext()) {
        // store token as string to bypass integer limit
        String token = lineScanner.next();

        // print out token (only add a plus if it's not the first iteration)
        if (iteration == 0) System.out.print(token);
        else System.out.print(" + " + token);

        // store token as an array inside of array[iteration]
        // (loop through token, add every character as an
        // integer to the end of the array)
        for (int i = 0; i < token.length(); i++) {
          array[iteration][array[iteration].length - i - 1] =
            Character.getNumericValue(token.charAt(token.length() - i - 1));
        }

        // increase iteration to keep track of current token
        iteration++;
      }

      // ending sum for current line
      String sum = "";
      boolean isCarryOver = false;

      // store carry over
      int carryOver = 0;

      // loop through every integer inside of inside loops
      for (int i = 24; i >= 0; i--) {
        // keep track of inner sum
        int innerSum = 0;

        // loop through every array
        for (int j = 0; j < array.length; j++) {
          // get sum for current "position"
          innerSum += array[j][i];
        }

        // logic for detecting carry over stuff
        // case if there is no carry over currently but there will be after this
        if (innerSum > 9 && isCarryOver == false) {
          // add initial value (integer in ones place) to the start of string
          int result = innerSum % 10;
          sum = result + sum;

          // calculating carry over and setting it for next time
          isCarryOver = true;
          int temp = innerSum;

          // set carry over to tens place of sum
          while (temp >= 10) temp /= 10;
          carryOver = temp;
          // case for if there is current carry over AND there will be carry over after
        } else if (isCarryOver == true && innerSum + carryOver > 9) {
          // add previous carry over
          innerSum += carryOver;

          // set future carry over to tens place of sum
          int temp = innerSum;
          while (temp >= 10) temp /= 10;
          carryOver = temp;

          // add the current sum to overall sum
          sum = (innerSum % 10) + sum;
          // case for if there is current carry over but there wont be carry over after
        } else if (isCarryOver == true && innerSum + carryOver <= 9) {
          // add previous carry over
          innerSum += carryOver;

          // disable carry over for the next round
          isCarryOver = false;

          // add to the start
          sum = innerSum + sum;
          // case for if there is no carry over and there will be no carry over after this
        } else {
          // just add it normally
          sum = innerSum + sum;
        }
      }

      // figure out where to start number from
      int start = 0;
      boolean running = true;
      for (int i = 0; i < sum.length(); i++) {
        // loop through until we hit the first not zero
        if (sum.charAt(i) != '0' && running) {
          // set the start point
          start = i;

          // stop checking
          running = false;
        }
      }

      // if it never stopped then we know that
      // it's all zeroes, so we just make it
      // one zero like this
      if (running) start = sum.length() - 1;

      // print out result if there are any numbers, otherwise subtract one from line
      // (if its a blank line, we ignore it)
      if (iteration == 0) lines -= 1;
      else System.out.println(" = " + sum.substring(start, sum.length()));
    }

    // print out line count
    System.out.println("Total lines = " + lines);
  }
}
