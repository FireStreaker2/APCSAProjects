// AP Comp Sci, May 3rd, 2024
// Programming Project #13: Sorting (Chapter 13)

// import
import java.util.Random;

/**
 * Program class
 *
 * Main class to run the program
 */
public class Program {

  public static void main(String[] args) {
    // create required objects
    Random random = new Random();
    BubbleSort bubbleSort = new BubbleSort();
    InsertionSort insertionSort = new InsertionSort();
    MergeSort mergeSort = new MergeSort();
    SelectionSort selectionSort = new SelectionSort();

    // first set of tests
    int[][] firstTests = new int[12][];

    // create test arrays
    for (int i = 0; i < firstTests.length; i++) {
      firstTests[i] = new int[(int) Math.pow(2, i + 1)];

      // populate test arrays
      for (int j = 0; j < firstTests[i].length; j++) firstTests[i][j] =
        random.nextInt(Integer.MAX_VALUE);
    }

    // first tests
    for (int i = 0; i < firstTests.length; i++) {
      // really bad way of doing this
      int[] temp = firstTests[i];
      int[] temp2 = firstTests[i];
      int[] temp3 = firstTests[i];
      int[] temp4 = firstTests[i];

      // test bubble sort
      System.out.println(bubbleSort.sort(temp));
      Check.isInOrder(temp);

      // test insertion sort
      System.out.println(insertionSort.sort(temp2));
      Check.isInOrder(temp2);

      // test merge sort
      System.out.println(mergeSort.sort(temp3));
      Check.isInOrder(temp3);

      // test selection sort
      System.out.println(selectionSort.sort(temp4));
      Check.isInOrder(temp4);
    }

    // second set of tests
    int[][] secondTests = new int[2][4096];
    for (int i = 0; i < secondTests[0].length; i++) secondTests[0][i] = i;

    for (
      int i = secondTests[1].length - 1;
      i >= 0;
      i--
    ) secondTests[1][secondTests[1].length - 1 - i] = i;

    // second tests
    for (int i = 0; i < secondTests.length; i++) {
      // really bad way of doing this
      int[] temp = secondTests[i];
      int[] temp2 = secondTests[i];
      int[] temp3 = secondTests[i];
      int[] temp4 = secondTests[i];

      // test bubble sort
      System.out.println(bubbleSort.sort(temp));
      Check.isInOrder(temp);

      // test insertion sort
      System.out.println(insertionSort.sort(temp2));
      Check.isInOrder(temp2);

      // test merge sort
      System.out.println(mergeSort.sort(temp3));
      Check.isInOrder(temp3);

      // test selection sort
      System.out.println(selectionSort.sort(temp4));
      Check.isInOrder(temp4);
    }
  }
}
