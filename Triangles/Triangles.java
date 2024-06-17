public class Triangles {

  public static final int SIZE = 4;

  public static void main(String[] args) {
    // all groups
    for (int i = 0; i < SIZE; i++) {
      // a single group
      for (int j = 0; j < SIZE; j++) {
        // single line
        for (int k = 1; k <= SIZE - i; k++) {
          // slashes
          for (int l = 1; l <= SIZE - j; l++) {
            System.out.print("/");
          }

          // spaces
          for (int l = 1; l <= j; l++) {
            System.out.print(" ");
          }
        }
        // new line
        System.out.println();
      }
    }
  }
}
