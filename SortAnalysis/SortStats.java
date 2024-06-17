// AP Comp Sci, May 3rd, 2024
// Programming Project #13: Sorting (Chapter 13)

/**
 * SortStats Class
 */
public class SortStats implements ISortStats {

  // private fields
  private String algorithm;
  private int numItems;
  private int numComparisons;
  private int numMoves;
  private long numNanoseconds;

  /**
   * Constructor for the SortStats class that accepts the required values
   *
   * @param algorithm
   * @param numItems
   * @param numComparisons
   * @param numMoves
   * @param numNanoseconds
   */
  public SortStats(
    String algorithm,
    int numItems,
    int numComparisons,
    int numMoves,
    long numNanoseconds
  ) {
    this.algorithm = algorithm;
    this.numItems = numItems;
    this.numComparisons = numComparisons;
    this.numMoves = numMoves;
    this.numNanoseconds = numNanoseconds;
  }

  /**
   * getAlgorithm method
   */
  public String getAlgorithm() {
    return algorithm;
  }

  /**
   * getNumItems method
   */
  public int getNumItems() {
    return numItems;
  }

  /**
   * getNumComparisons method
   */
  public int getNumComparisons() {
    return numComparisons;
  }

  /**
   * getNumMoves method
   */
  public int getNumMoves() {
    return numMoves;
  }

  /**
   * getNumNanoseconds method
   */
  public long getNumNanoseconds() {
    return numNanoseconds;
  }

  /**
   * toString method
   */
  public String toString() {
    // works perfectly fine in production
    return String.format(
      "{\n  \"Algorithm\"\t   : \"%s\",\n  \"NumItems\"\t   : \"%s\",\n  \"NumComparisons\" : \"%s\",\n  \"NumMoves\"\t   : \"%s\",\n  \"NumNanoseconds\" : \"%s\"\n}",
      algorithm,
      numItems,
      numComparisons,
      numMoves,
      numNanoseconds
    );
  }
}
