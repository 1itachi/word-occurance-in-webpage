package process;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Class represents Calculate overall frequency. Provided a list of single page results and set
 * of words, calculates the total occurrences of the words across all urls.
 */
public class CalculateOverallFrequency {

  private List<SinglePageFrequency>pageResults;
  private HashMap<String,Integer>mapFinalResults;

  /**
   * Constructor for calculate overall frequency. Maps set of words to hashmap with initial value as
   * 0.
   * @param pageResults List of single page results.
   * @param words words to be searched.
   */
  public CalculateOverallFrequency(List<SinglePageFrequency> pageResults, Set<String>words){
      this.pageResults = pageResults;
      mapFinalResults = new HashMap<>();
      for(String word:words){
        mapFinalResults.put(word,0);
      }
  }

  /**
   * Method to print all the occurrences of words across all urls.
   */
  public void printOccurrencesOfWordsAcrossAllUrls() {

    //Merge all Hashmaps of single page results to single Hashmap.
    for(SinglePageFrequency sp: pageResults){
      HashMap<String, Integer>spMap = sp.getMapping();
      spMap.forEach((key, value) -> mapFinalResults.merge(key,value,
          (value1, value2)-> value1+value2));
    }

    ArrayList<Word> listOfWords = new ArrayList<>();

    //create a list of word
    for (Map.Entry<String, Integer> entry : mapFinalResults.entrySet()) {
      listOfWords.add(new Word(entry.getKey(), entry.getValue()));
    }

    OrderList order = new OrderList(listOfWords);
    PriorityQueue<Word>maxHeap = order.getOrderedWordsBasedOnOccurrence();

    //print results in descending order of occurrences
    while(maxHeap.size()!=0){
      Word word = maxHeap.poll();
      System.out.println(word.getName() + " - " + word.getOccurrence());
    }

  }
}
