
// AP Comp Sci, September 25th, 2023
// Programming Project #2: Rocket Ship (Chapter 2)

// This Java program prints out an ASCII art version of a rocket ship. It utilizes static methods
// and nested for loops to reduce redundancy yet still output the expected result. It also uses a
// constant variable which the user can change in order to scale the size of the rocket ship.

/* Stats:
 * 
 * 4 KB
 * ~81 lines without documentation
 * Made with <3
 */

// class
public class DrawRocket {
	// constant variable for size
	public static final int SIZE = 1;
	
	// main method
	public static void main(String[] args) {
		// call all other static methods in order
		drawCone();
		drawLine();
		drawTopTriangle();
		drawBottomTriangle();
		drawLine();
		drawBottomTriangle();
		drawTopTriangle();
		drawLine();
		drawCone();
	}
	
	
	// ---- OTHER METHODS START ---- \\
	
	/* drawCone method
	 * 
	 * this just draws the giant cone
	 */
	public static void drawCone() {
		// number of lines
		for (int i = 1; i <= (SIZE * 2) - 1; i++) {
			// spaces
			for (int j = 1; j <= (SIZE * 2) - i; j++) {
				System.out.print(" ");
			}
			
			// forward slashes (/)
			for (int j = 1; j <= i; j++) {
				System.out.print("/");
			}
			
			// asterisks
			System.out.print("**");
			
			// back slashes (\)
			for (int j = 1; j <= i; j++) {
				System.out.print("\\");
			}
			
			// new line
			System.out.println();
		}
	}
	
	/* drawLine method
	 * 
	 * this draws the separator thats between some of the things
	 */
	public static void drawLine() {
		System.out.print("+");
		
		// repeatedly print out "=*"
		for (int i = 1; i <= SIZE * 2; i++) {
			System.out.print("=*");
		}
		
		System.out.print("+");
		
		// new line
		System.out.println();
	}
	
	/* drawTopTriangle method
	 * 
	 * this draws the half of the box that includes the triangles facing up                                                 
	 */
	public static void drawTopTriangle() {
		// number of lines
		for (int i = 1; i <= SIZE; i++) {
			System.out.print("|");
			
			// first group of periods (.)
			for (int j = 1; j <= SIZE - i; j++) {
				System.out.print(".");
			}
			
			// first group of triangles
			for (int j = 1; j <= i; j++) {
				System.out.print("/\\");
			}
			
			// second group of periods (.)
			for (int j = 1; j <= (SIZE - i) * 2; j++) {
				System.out.print(".");
			}
			
			// second group of triangles (same code as before)
			for (int j = 1; j <= i; j++) {
				System.out.print("/\\");
			}
			
			// third group of periods (.)
			for (int j = 1; j <= SIZE - i; j++) {
				System.out.print(".");
			}
			
			System.out.print("|");
			
			// new line
			System.out.println();
		}
	}
	
	/* drawBottomTriangle method
	 * 
	 * this draws the half of the box that includes the triangles facing down                                              
	 */
	public static void drawBottomTriangle() {
		// number of lines (note that we start from 0 for this one, thats intentional)
		for (int i = 0; i < SIZE; i++) {
			System.out.print("|");
			
			// first group of periods (.)
			for (int j = 1; j <= i; j++) {
				System.out.print(".");
			}
			
			// first group of triangles (they're upside down this time :O )
			for (int j = 1; j <= SIZE - i; j++) {
				System.out.print("\\/");
			}
			
			// second group of periods (.)
			for (int j = 1; j <= i * 2; j++) {
				System.out.print(".");
			}
				
			// second group of triangles (same code as before)
			for (int j = 1; j <= SIZE - i; j++) {
				System.out.print("\\/");
			}
			
			// third group of periods (.)
			for (int j = 1; j <= i; j++) {
				System.out.print(".");
			}
			
			System.out.print("|");
			
			// new line
			System.out.println();
		}
	}
	
	// ---- OTHER METHODS END ---- \\

}
