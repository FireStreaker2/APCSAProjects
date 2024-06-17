// AP Comp Sci, October 10th, 2023
// Programming Project #3 Part A: Greetings (Chapter 3)

// This is a simple program to receive user input and then return a simple greeting.
// It asks for the first name, last name, and year of birth.

/* Stats:
 *
 * 2 KB
 * ~25 lines without documentation
 * Made with <3
 */

// import libraries
import java.util.Calendar;
import java.util.Scanner;

// class
public class Greetings {

  // main method
  public static void main(String[] args) {
    // declare needed system variables
    Scanner scanner = new Scanner(System.in);
    int currentYear = (Calendar.getInstance().get(Calendar.YEAR));

    // ask questions and store answers in variables
    String firstName = ask(scanner, "Please enter your first name: ");
    String lastName = ask(scanner, "Please enter your last name: ");
    int birth = askAge(scanner, "Please enter your year of birth: ");

    // get first character of first initial
    firstName = firstName.toUpperCase();
    char firstInitial = firstName.charAt(0);

    // get last initial (same process as above)
    lastName = lastName.toUpperCase();
    char lastInitial = lastName.charAt(0);

    // get the rest of last name
    String restOfLastName = lastName
      .toLowerCase()
      .substring(1, lastName.length());

    // find current age
    int age = currentYear - birth;

    // print result
    System.out.println(
      "Greetings, " +
      firstInitial +
      ". " +
      lastInitial +
      restOfLastName +
      "! You are about " +
      age +
      " years old."
    );
  }

  /* ask method
   * simple method to ask questions and return the response
   */
  public static String ask(Scanner scanner, String prompt) {
    System.out.println(prompt);
    return scanner.next();
  }

  /* askAge method
   * its like the ask method, but for an integer
   * (we use it to find the age)
   */
  public static int askAge(Scanner scanner, String prompt) {
    System.out.println(prompt);
    return scanner.nextInt();
  }
}
