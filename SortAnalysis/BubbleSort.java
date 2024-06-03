
// AP Comp Sci, May 3rd, 2024
// Programming Project #13: Sorting (Chapter 13)

/**
 * BubbleSort class
 * 
 * Implements bubble sort
 */
public class BubbleSort implements ISorter {
	// null constructor
	public BubbleSort() {
	}

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

		int temp = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < (n - i); j++) {
				comparisons++;
				if (arr[j - 1] > arr[j]) {
					temp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = temp;
					moves += 3;
				}

			}
		}

		long end = System.nanoTime();

		// return stats
		return new SortStats("Bubble", n, comparisons, moves, end - start);
	}

}
