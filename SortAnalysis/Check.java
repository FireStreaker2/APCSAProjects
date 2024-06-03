
// AP Comp Sci, May 3rd, 2024
// Programming Project #13: Sorting (Chapter 13)

/**
 * Check class
 * 
 * Implements a static method that checks if an array is sorted
 */
public class Check {

	/**
	 * isInOrder method
	 * 
	 * @param arr Array to check
	 * @return
	 */
	public static boolean isInOrder(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				System.out.println("Array is not in order!");
				return false;
			}
		}

		System.out.println("Array is in order!");
		return true;
	}
}
