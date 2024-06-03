
// AP Comp Sci, May 3rd, 2024
// Programming Project #13: Sorting (Chapter 13)

/**
 * ISortStats interface
 * 
 * Contains all the required methods that need to be implemented
 */
public interface ISortStats {
	String getAlgorithm();
	int getNumItems();
	int getNumComparisons();
	int getNumMoves();
	long getNumNanoseconds();
}