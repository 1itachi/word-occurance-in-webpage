package process;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import exception.WebsiteNotReachableException;
import scraper.Scraper;

public class SinglePageFrequency {

  private String url;
  private HashMap<String, Integer>wordMap;
  private Integer limit;

  public SinglePageFrequency(String url, HashMap<String, Integer> wordMap, int K){
    this.url = url;
    this.wordMap = new HashMap<>(wordMap);
    this.limit = K;
  }

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

  public void printTopKWords() throws WebsiteNotReachableException {
    findFrequencies();
//    PriorityQueue<Map.Entry<String, Integer>> maxHeap =
//        new PriorityQueue<>((o1, o2) -> {
//          if (o1.getValue().equals(o2.getValue())) {
//            return o1.getKey().compareTo(o2.getKey());
//          } else {
//            return o2.getValue().compareTo(o1.getValue());
//          }
//        });

//    for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
//      maxHeap.add(entry);
//    }

    ArrayList<Word>listOfWords = new ArrayList<>();

    for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
        listOfWords.add(new Word(entry.getKey(), entry.getValue()));
    }

    OrderList order = new OrderList(listOfWords);
    PriorityQueue<Word>maxHeap = order.getOrderedWordsBasedOnOccurrence();

    int counter = this.limit;
    System.out.println(this.url);
//    while(maxHeap.size()!=0 && counter>0){
//      Map.Entry<String, Integer> entry = maxHeap.poll();
//      System.out.println(entry.getKey() + " - "+entry.getValue());
//      counter--;
//    }

      while(maxHeap.size()!=0 && counter>0){
        Word word = maxHeap.poll();
        System.out.println(word.getName() + " - "+word.getOccurance());
        counter--;
      }


  }

  public HashMap<String, Integer> getMapping(){
    return this.wordMap;
  }


}
