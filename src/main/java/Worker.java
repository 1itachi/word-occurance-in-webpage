import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import exception.InvalidUrlException;
import exception.WebsiteNotReachableException;
import process.CalculateOverallFrequency;
import process.SinglePageFrequency;

/**
 * Class for running and displaying both single page and overall results.
 * topKWords -> number of top words to be printed for each page
 */
public class Worker {

  private  int topKWords = 3;
  private  String headingForSinglePageResults = "Output #1\n" + "=========";
  private  String headingForOverallResults = "Output #2\n" + "=========";
  ArrayList<SinglePageFrequency>arrayOfSinglePageResults;

  /**
   * Constructor for worker. Initializes the array to collect single page results.
   */
  public Worker(){
    arrayOfSinglePageResults = new ArrayList<>();
  }

  /**
   * Method to print single page results and overall results in the give format.
   * @param urls set of urls
   * @param words set of words
   * @throws WebsiteNotReachableException exception thrown if the website is not reachable.
   */
  public void run(Set<String> urls, Set<String>words) throws WebsiteNotReachableException {

    System.out.println(headingForSinglePageResults);
    HashMap<String, Integer>wordMap = new HashMap<>();


    //put all words into a map with 0 as the values of occurrence
    for(String ele: words){
      wordMap.put(ele, 0);
    }

    //loop through all words, print single page result and collect the objects into a list.
    for(String url:urls){
      System.out.println(url);
      try {
        //print single page results
        SinglePageFrequency sf= new SinglePageFrequency(url, wordMap, topKWords );
        sf.printTopKWords();
        arrayOfSinglePageResults.add(sf);
      }catch (WebsiteNotReachableException e){
        System.out.println("Website not reachable!!");
      } catch (InvalidUrlException e){
        System.out.println("Invalid url!!");
      }
    }

    System.out.println("=====================================================================");
    System.out.println(headingForOverallResults);

    //print overall results
    CalculateOverallFrequency cf = new CalculateOverallFrequency(arrayOfSinglePageResults, words);
    cf.printOccurrencesOfWordsAcrossAllUrls();
  }
}
