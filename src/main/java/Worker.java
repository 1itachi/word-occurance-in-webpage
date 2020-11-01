import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import exception.WebsiteNotReachableException;
import process.CalculateOverallFrequency;
import process.SinglePageFrequency;

public class Worker {

  private  int topKWords = 3;
  private  String headingForSinglePageResults = "Output #1\n" + "=========";
  private  String headingForOverallResults = "Output #2\n" + "=========";
  ArrayList<SinglePageFrequency>arrayOfSinglePageResults;

  public Worker(){
    arrayOfSinglePageResults = new ArrayList<>();
  }


  public void run(Set<String> urls, Set<String>words) throws WebsiteNotReachableException {

    System.out.println(headingForSinglePageResults);
    HashMap<String, Integer>wordMap = new HashMap<>();


    //put all words into a map with 0 as the values of occurrence
    for(String ele: words){
      wordMap.put(ele, 0);
    }

    //loop through all words, print single page result and collect the objects into a list.
    for(String url:urls){
      SinglePageFrequency sf= new SinglePageFrequency(url, wordMap, topKWords );
      sf.printTopKWords();
      arrayOfSinglePageResults.add(sf);
    }

    System.out.println("=====================================================================");
    System.out.println(headingForOverallResults);

    CalculateOverallFrequency cf = new CalculateOverallFrequency(arrayOfSinglePageResults, words);
    cf.printOccurrencesOfWordsAcrossAllUrls();


  }



}
