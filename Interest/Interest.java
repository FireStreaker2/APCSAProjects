
// AP Comp Sci, October 10th, 2023
// Programming Project #3 Part B: Interest (Chapter 3)

// This project calculates interest on a savings account that is compounded annually. It
// works by first receiving user input, and then calculates the results, and then finally
// prints out the results in a neat table.

/* Stats:
 * 
 * 3 KB
 * ~27 lines without documentation
 * Made with <3
 */


// import library
import java.util.Scanner;

// class
public class Interest {
	
	// main method
	public static void main(String[] args) {
		// declare new scanner variable
		Scanner scanner = new Scanner(System.in);
		
		// invoke the ``ask()`` method to ask questions
		double initialInvestment = ask(scanner, "Enter your initial investment:");
		double annualDeposit = ask(scanner, "Enter your annual deposit:");
		int years = (int) ask(scanner, "Enter number of Years:"); // note that we typecast to an ``int`` here, that's on purpose
		double interestRate = ask(scanner, "Enter your interest rate:");
		
		// call the ``printResult()`` method to print out the table
		printResult(initialInvestment, annualDeposit, years, interestRate);

	}
	
	/* ask method
	 * simple method to ask questions and return the response
	 */
	public static double ask(Scanner scanner, String prompt) {
		System.out.println(prompt);
		return scanner.nextDouble();
	}
	
	/* printResult method
	 * 
	 * this method prints out the result in a clean way
	 */
	public static void printResult(double balance, double annualDeposit, int years, double interestRate) {
		// new line
		System.out.println();
		
		// headers (stuff not in the ``for`` loop)
		System.out.println("Year\tInterest\tDeposit \tBalance");
		System.out.println("start\t\t\t\t\t" + balance);
		
		// ``for`` loop for all of the data
		for (int i = 1; i <= years; i++) {
			
			// find out how much interest to add every year
			double interest = (interestRate / 100.0) * balance;
			
			// round down to hundredths place
			interest = (int) (interest * 100.0) / 100.0;
			
			// add interest and deposit to balance
			balance += interest + annualDeposit;
			
			// round down to hundredths place
			balance = (int) (balance * 100.0) / 100.0;
			
			// print out results
			System.out.println(i + "\t" + interest + "\t\t" + annualDeposit + "\t\t" + balance);
		}
		
	}

}
