
// AP Comp Sci, May 3rd, 2024
// Programming Project #13: Sorting (Chapter 13)

/**
 * MergeSort class
 * 
 * Implements merge sort
 */
public class MergeSort implements ISorter {
	// private fields
	private int comparisons;
	private int moves;

	// null constructor
	public MergeSort() {
	}
	
	/**
	 * sort Method
	 * 
	 * @param arr Array to sort
	 * @return The statistics of the sorting algorithm
	 */
	public ISortStats sort(int[] arr) {
		long start = System.nanoTime();
		int n = arr.length;
		comparisons = 0;
		moves = 0;

		sortHelper(arr, 0, arr.length - 1);

		long end = System.nanoTime();
		return new SortStats("Merge", n, comparisons, moves, end - start);
	}

	/**
	 * sortHelper method
	 * 
	 * @param arr
	 * @param start
	 * @param end
	 */
	private void sortHelper(int[] arr, int start, int end) {
		if (start < end) {
			int middle = start + (end - start) / 2;

			// split off into two halves
			sortHelper(arr, start, middle);
			sortHelper(arr, middle + 1, end);

			merge(arr, start, middle, end);
		}
	}

	/**
	 * merge method
	 * 
	 * @param arr
	 * @param start
	 * @param middle
	 * @param end
	 */
	private void merge(int arr[], int start, int middle, int end) {
		// assigning positions 
		int n1 = middle - start + 1;
		int n2 = end - middle;

		// create separate arrays for both halves
		int leftArr[] = new int[n1];
		int rightArr[] = new int[n2];

		// populate first array
		for (int i = 0; i < n1; i++) {
			leftArr[i] = arr[start + i];
			moves++;
		}

		// populate second array
		for (int j = 0; j < n2; j++) {
			rightArr[j] = arr[middle + 1 + j];
			moves++;
		}

		int i = 0;
		int j = 0;

		int k = start;
		while (i < n1 && j < n2) {
			comparisons += 3;

			if (leftArr[i] <= rightArr[j]) {
				arr[k] = leftArr[i];
				i++;
			} else {
				arr[k] = rightArr[j];
				j++;
			}

			k++;
			moves += 1;
		}

		while (i < n1) {
			arr[k] = leftArr[i];
			i++;
			k++;

			moves++;
			comparisons++;
		}

		while (j < n2) {
			arr[k] = rightArr[j];
			j++;
			k++;

			moves++;
			comparisons++;
		}
	}
}
