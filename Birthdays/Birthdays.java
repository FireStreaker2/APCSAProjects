// AP Comp Sci, October 30th, 2023
// Programming Project #4: Birthdays (Chapter 4)

// This project receives user input and calculates birthdays based off of that.
// It also has corresponding messages based on the info provided. Finally, it
// outputs a fun fact about a certain day.

/* Stats:
 *
 * 4 KB
 * ~54 lines without documentation
 * Made with <3
 */

// import library
import java.util.Scanner;

// class
public class Birthdays {

  // main method
  public static void main(String[] args) {
    // initialize scanner
    Scanner scanner = new Scanner(System.in);

    // first question (that we dont use a method for)
    System.out.print("Please enter today's date (month day): ");
    int month = scanner.nextInt();
    int day = scanner.nextInt();

    // get absolute day of today
    int today = getAbsoluteDay(month, day);

    // first response
    System.out.println(
      "Today is " + month + "/" + day + "/2024, day #" + today + " of the year."
    );
    System.out.println();

    // ask birthday questions
    int firstDay = askBirthday(
      scanner,
      "Please enter person #1's birthday (month day): ",
      today
    );
    int secondDay = askBirthday(
      scanner,
      "Please enter person #2's birthday (month day): ",
      today
    );

    // output logic
    if (firstDay == secondDay) System.out.println(
      "Wow, you share the same birthday! ^_^"
    );
    else if (today - firstDay > today - secondDay) System.out.println(
      "Person #1's birthday is sooner."
    );
    else System.out.println("Person #2's birthday is sooner.");

    // cool new line
    System.out.println();

    // fun fact
    System.out.print("Senpai~, did you know? 4/15 is national anime day!!!");
  }

  /*
   * askBirthday method
   *
   * just a simple method to handle asking questions, produce output, and return
   * user input
   */
  public static int askBirthday(Scanner scanner, String question, int today) {
    // ask question
    System.out.print(question);

    // get input
    int month = scanner.nextInt();
    int day = scanner.nextInt();

    // get absolute day
    int absoluteDay = getAbsoluteDay(month, day);

    // calculate days from next birthday
    int length;
    if (absoluteDay >= today) length = absoluteDay - today;
    else length = 366 - (absoluteDay - today);

    // make it wrap around if its in the past
    if (length < 0) length += 366;

    // print out output
    System.out.print(
      month + "/" + day + "/2024 falls on day #" + absoluteDay + " of 366. "
    );

    // logic for extra output
    if (length == 0) System.out.println("Happy Birthday! :)");
    else System.out.println("Your next birthday is in " + length + " day(s).");

    // new line
    System.out.println();

    // return value so logic can be in ``main``
    return absoluteDay;
  }

  /*
   * getAbsoluteDay method
   *
   * just returns the absolute day given month and day
   */
  public static int getAbsoluteDay(int month, int day) {
    // include amount of days that already passed in current month
    int days = day;

    // loop through all the months that have already passed
    for (int i = month - 1; i > 0; i--) {
      // add amount of days per month that passed
      if ((i % 2 == 1 && i < 8) || (i % 2 == 0 && i >= 8)) days += 31;
      else if (i == 2) days += 29;
      else days += 30;
    }

    // return value
    return days;
  }
}
