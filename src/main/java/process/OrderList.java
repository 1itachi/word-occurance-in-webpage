package process;

import java.util.List;
import java.util.PriorityQueue;

/**
 * Class provides a method to order a list of words based on occurrence
 */
public class OrderList {

  private List<Word>listOfWords;

  /**
   * List of words in random order
   * @param listOfWords word list.
   */
  public OrderList(List<Word>listOfWords){
    this.listOfWords = listOfWords;
  }

  /**
   * Method to sort the words in descending order of occurrences.
   * @return PriorityQueue with words arranged with max value to min value.
   * If words have equal count, they are arranged in alphabetical order.
   */
  public PriorityQueue<Word> getOrderedWordsBasedOnOccurrence(){
     PriorityQueue<Word> maxHeap =
        new PriorityQueue<>((w1, w2) -> {
          if (w1.getOccurrence() == w2.getOccurrence()) {
            return w1.getName().compareTo(w2.getName());
          } else {
            return (w2.getOccurrence() - w1.getOccurrence());
          }
        });

     for(Word word:listOfWords){
       maxHeap.add(word);
     }
    return maxHeap;
  }

}
