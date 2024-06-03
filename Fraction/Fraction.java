
// AP Comp Sci, January 1st, 2024
// Programming Project #8: Fraction (Chapter 8)

// This program creates a fraction class for programmers to use.
// It allows for initializing a fraction using two integers, a 
// single whole number, or a string. It comes bundled with a 
// variety of useful methods for developers to use.

/* Stats:
 * 
 * 6 KB
 * Made with <3
 */

// main class
public class Fraction {
	// class fields
	private int numerator;
	private int denominator;

	// CONSTRUCTORS

	/**
	 * Constructor that accepts integers for numerator and denominator
	 * 
	 * @constructor
	 * @param numerator   (ex. 10)
	 * @param denominator (ex. 3)
	 */
	public Fraction(int numerator, int denominator) {
		if (denominator == 0)
			throw new IllegalArgumentException("Cannot divide by 0!");

		this.simplify(numerator, denominator);
	}

	/**
	 * Constructor that accepts a whole number
	 * 
	 * @constructor
	 * @param wholeNumber (ex. 727)
	 */
	public Fraction(int wholeNumber) {
		this.numerator = wholeNumber;
		this.denominator = 1;
	}

	/**
	 * Constructor that accepts a string representing a fraction
	 * 
	 * @constructor
	 * @param fraction (ex. "727/420")
	 */
	public Fraction(String fraction) {
		int positionOfSlash = fraction.indexOf("/");

		int numerator;

		if (fraction.charAt(0) == '+')
			numerator = Integer.parseInt(fraction.substring(1, positionOfSlash));
		else if (fraction.charAt(0) == '-')
			numerator = -1 * Integer.parseInt(fraction.substring(1, positionOfSlash));
		else
			numerator = Integer.parseInt(fraction.substring(0, positionOfSlash));

		int denominator = Integer.parseInt(fraction.substring(positionOfSlash + 1, fraction.length()));

		this.simplify(numerator, denominator);
	}

	// METHODS

	/**
	 * Method that adds two fractions together
	 * 
	 * @param fraction
	 * @return
	 */
	public Fraction add(Fraction fraction) {
		return new Fraction(this.numerator * fraction.getDenominator() + fraction.getNumerator() * this.denominator,
				this.denominator * fraction.denominator);
	}

	/**
	 * Method that subtracts two fractions
	 * 
	 * @param fraction
	 * @return
	 */
	public Fraction subtract(Fraction fraction) {
		return new Fraction(this.numerator * fraction.getDenominator() - fraction.getNumerator() * this.denominator,
				this.denominator * fraction.denominator);
	}

	/**
	 * Method that multiplies two fractions
	 * 
	 * @param fraction
	 * @return
	 */
	public Fraction multiply(Fraction fraction) {
		return new Fraction(this.numerator * fraction.getNumerator(), this.denominator * fraction.getDenominator());
	}

	/**
	 * Method that divides two fractions
	 * 
	 * @param fraction
	 * @return
	 */
	public Fraction divide(Fraction fraction) {
		return new Fraction(this.numerator * fraction.getDenominator(), this.denominator * fraction.getNumerator());
	}

	/**
	 * Method that returns a string version of the fraction
	 * 
	 * @return
	 */
	public String toString() {
		if (this.denominator == 1)
			return this.numerator + "";

		return this.numerator + "/" + this.denominator;
	}

	/**
	 * Method that returns a mixed string representation of the fraction
	 * 
	 * @return
	 */
	public String toMixedNumberString() {
		if (this.denominator == 1)
			return this.numerator + "";

		int mixedNum = 0;
		int absNume = Math.abs(this.numerator);
		int absDeno = Math.abs(this.denominator);
		if (absNume > absDeno) {
			while (absNume > absDeno) {
				absNume -= absDeno;
				mixedNum += 1;
			}
			if (this.numerator < 0 && this.numerator < 0) {
				mixedNum *= -1;

			}
			return (mixedNum + "_" + absNume + "/" + absDeno);

		}
		return (this.numerator + "/" + this.denominator);
	}

	/**
	 * Method that compares two different fractions. Returns 1 if first fraction is
	 * bigger than second fraction, returns 0 if they're equal, and returns -1 if
	 * the first fraction is smaller than the second fraction
	 * 
	 * @param fraction
	 * @return
	 */
	public int compareTo(Fraction fraction) {
		int firstNumerator = this.numerator * fraction.getDenominator();
		int secondNumerator = fraction.getNumerator() * this.denominator;

		if (firstNumerator == secondNumerator)
			return 0;
		else if (firstNumerator < secondNumerator)
			return -1;
		else
			return 1;
	}

	// UTIL METHODS

	/**
	 * Simplifies the fraction using the greatest common divisor
	 * 
	 * @param numerator
	 * @param denominator
	 */
	private void simplify(int numerator, int denominator) {
		int n1 = Math.abs(numerator);
		int n2 = Math.abs(denominator);
		int n3;

		while (n1 != 0 && n2 != 0) {
			if (n1 > n2)
				n1 = n1 % n2;
			else
				n2 = n2 % n1;
		}

		if (n1 > n2)
			n3 = n1;
		else
			n3 = n2;

		if ((numerator < 0 && denominator < 0) || (denominator < 0)) {
			numerator *= -1;
			denominator *= -1;
		}

		this.numerator = numerator / n3;
		this.denominator = denominator / n3;
	}

	// GETTER METHODS

	/**
	 * Returns the numerator
	 * 
	 * @return
	 */
	public int getNumerator() {
		return this.numerator;
	}

	/**
	 * Returns the denominator
	 * 
	 * @return
	 */
	public int getDenominator() {
		return this.denominator;
	}
}
