
// AP Comp Sci, May 3rd, 2024
// Programming Project #13: Sorting (Chapter 13)

/**
 * SelectionSort method
 * 
 * Implements selection sort
 */
public class SelectionSort implements ISorter {
	// null constructor
	public SelectionSort() {
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

		for (int i = 0; i < n - 1; i++) {
			int position = i;

			for (int j = i + 1; j < n; j++) {
				comparisons++;
				if (arr[j] < arr[position])
					position = j;
			}

			int temp = arr[position];
			arr[position] = arr[i];
			arr[i] = temp;
			moves += 3;
		}

		long end = System.nanoTime();
		
		// return stats
		return new SortStats("Selection", n, comparisons, moves, end - start);
	}

}
