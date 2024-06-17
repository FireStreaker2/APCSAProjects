// AP Comp Sci, May 3rd, 2024
// Programming Project #13: Sorting (Chapter 13)

/**
 * InsertionSort class
 *
 * Implements insertion sort
 */
public class InsertionSort implements ISorter {

  // null constructor
  public InsertionSort() {}

  /**
   * sort Method
   *
   * @param arr Array to sort
   * @return The statistics of the sorting algorithm
   */
  public ISortStats sort(int[] arr) {
    // keep track of stats
    long start = System.nanoTime();
    int n = arr.length;
    int comparisons = 0;
    int moves = 0;

    for (int i = 1; i < n; i++) {
      int current = arr[i];
      int j = i - 1;

      while (j >= 0 && arr[j] > current) {
        arr[j + 1] = arr[j];
        j--;
        moves++;
        comparisons++;
      }

      arr[j + 1] = current;
      moves += 2;
    }

    long end = System.nanoTime();

    // return stats
    return new SortStats("Insertion", n, comparisons, moves, end - start);
  }
}
