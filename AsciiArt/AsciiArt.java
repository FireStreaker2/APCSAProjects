// AP Comp Sci, September 26th, 2023
// Programming Project #2.5: ASCII Art Contest (Chapter 2)

// This program prints out an ASCII art version of an UwU face, which can also be scaled.
// It works by utilizing ``for`` loops to reduce redundancy. The only caveat is the code
// for the face. Whilst it may be slightly messy, it still works.

/* Stats:
 *
 * 1 KB
 * ~67 lines without documentation
 * Made with <3
 */

// class
public class AsciiArt {

  // class constant
  public static final int SIZE = 10;

  public static void main(String[] args) {
    // --------------------- TOP BORDER START --------------------- \\
    // spaces
    for (int i = 1; i <= SIZE + 1; i++) {
      System.out.print(" ");
    }

    // underscores (_)
    for (int i = 1; i <= SIZE * 3; i++) {
      System.out.print("_");
    }

    // new line
    System.out.println();

    // --------------------- TOP BORDER END --------------------- \\

    // top half
    // notice that there's a "- 1" in the ``for`` loop, thats intended
    //                       vvv
    for (int i = 0; i < SIZE - 1; i++) {
      // spaces
      for (int j = 1; j <= SIZE - i; j++) {
        System.out.print(" ");
      }

      // border
      System.out.print("/");

      // more spaces
      for (int j = 1; j <= (SIZE * 3) + i * 2; j++) {
        System.out.print(" ");
      }

      // other border
      System.out.print("\\");

      // new line
      System.out.println();
    }

    // --------------------- FACE START --------------------- \\
    // note that we have a different section for the face thats isolated from the
    // other for loops, this is
    // because we cant use ``if`` statements yet

    // first eye
    System.out.print(" /");
    printSpacing();
    System.out.print("U");

    // spacing between eyes
    for (int i = 1; i <= (SIZE * 3) - 4; i++) {
      System.out.print(" ");
    }

    // second eye
    System.out.print("U");
    printSpacing();
    System.out.println("\\");

    // border
    System.out.print("|");
    printSpacing();

    // first blush
    System.out.print("///");

    // spacing
    for (int i = 1; i <= SIZE - 2; i++) {
      System.out.print(" ");
    }

    // mouth
    System.out.print("W");

    // more spacing
    for (int i = 1; i <= (SIZE * 3) - 7 - (SIZE - 2); i++) {
      System.out.print(" ");
    }

    // second blush
    System.out.print("///");
    printSpacing();
    System.out.println("|");

    // --------------------- FACE END --------------------- \\

    // bottom half
    for (int i = 1; i <= SIZE - 1; i++) {
      // spaces
      for (int j = 1; j <= i; j++) {
        System.out.print(" ");
      }

      // border
      System.out.print("\\");

      // more spaces
      for (int j = 1; j <= (SIZE * 5) - (2 * i); j++) {
        System.out.print(" ");
      }

      // border
      System.out.println("/");
    }

    // final line with underscores (_)
    printSpacing();
    System.out.print("\\");
    for (int i = 1; i <= SIZE * 3; i++) {
      System.out.print("_");
    }

    System.out.print("/");
  }

  /* printSpacing method
   *
   * This method just prints out some spaces, it's
   * just a really short way of reducing redundancy
   */
  public static void printSpacing() {
    for (int i = 1; i <= SIZE; i++) {
      System.out.print(" ");
    }
  }
}
