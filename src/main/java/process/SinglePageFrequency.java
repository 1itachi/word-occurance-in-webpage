package process;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import exception.WebsiteNotReachableException;
import scraper.Scraper;

/**
 * Class represents Single page frequency. Provided a url and list of words, calculates the number
 * of occurrence of the words in the page.
 */
public class SinglePageFrequency {

  private String url;
  private HashMap<String, Integer>wordMap;
  private Integer limit;

  /**
   * Constructor for single page frequency.
   * @param url page url to scrape and search words.
   * @param wordMap a map of words and number of occurrences.
   * @param K to print top K occurrences words.
   * @throws WebsiteNotReachableException exception if website is not reachable.
   */
  public SinglePageFrequency(String url, HashMap<String, Integer> wordMap, int K) throws
        WebsiteNotReachableException {
    this.url = url;
    this.wordMap = new HashMap<>(wordMap);
    this.limit = K;
    findFrequencies();
  }

  /**
   * local method to scrape the page and count the occurrences of the word.
   * @throws WebsiteNotReachableException exception if website is not reachable.
   */
  private void findFrequencies() throws WebsiteNotReachableException {
    Scraper scraper = new Scraper();
    //Scrape web page, trim the leading or trailing spaces, convert to lowercase
    String pageContent = scraper.scrapeWebPage(url).trim().toLowerCase();
    // and split for all non-alphanumeric
    String[] contentWords = pageContent.split("[^\\w]+");

    for(String word: contentWords){
      if(wordMap.containsKey(word)) {
        wordMap.put(word, wordMap.get(word) + 1);
      }
    }
  }

  /**
   * Print the top K words in the given format
   * Example:
   *      https://www.example1.com
   *      cat - 12
   *      dog - 9
   *      bear - 7
   * @throws WebsiteNotReachableException exception thrown if the url is not accessible
   */
  public void printTopKWords() throws WebsiteNotReachableException {

    ArrayList<Word>wordList = new ArrayList<>();

    //Create a word object with key and value of a Hashmap and add it to a list
    for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
      wordList.add(new Word(entry.getKey(), entry.getValue()));
    }

    //Create OrderList object
    OrderList order = new OrderList(wordList);
    //Function to get ordered values in the form of priority queue based on occurrence
    PriorityQueue<Word>maxHeap = order.getOrderedWordsBasedOnOccurrence();

    int counter = this.limit;
    System.out.println(this.url);

    //Loop and print the results
    while(maxHeap.size()!=0 && counter>0){
        Word word = maxHeap.poll();
        System.out.println(word.getName() + " - "+word.getOccurrence());
        counter--;
    }
  }

  /**
   * Get mapping of the single page results.
   * @return HashMap with key as word name and value as number of occurrence.
   */
  public HashMap<String, Integer> getMapping(){
    return this.wordMap;
  }


}
