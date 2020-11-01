package process;

/**
 * This class represents a word object.
 * Word has a word and number of occurrences.
 */
public class Word {
  private String name;
  private int occurrence;

  /**
   * Constructor to create a word object.
   * @param name word (string).
   * @param occurrence number of occurrences.
   */
  public Word(String name, int occurrence){
    this.name = name;
    this.occurrence = occurrence;
  }

  /**
   * Get the word.
   * @return return word.
   */
  public String getName() {
    return name;
  }

  /**
   * Get the occurrence
   * @return the number of occurrences of the word.
   */
  public int getOccurrence() {
    return occurrence;
  }
}
