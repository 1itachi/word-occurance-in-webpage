package process;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

import exception.WebsiteNotReachableException;

public class CalculateOverallFrequency {

  private List<SinglePageFrequency>pageResults;
  private HashMap<String,Integer>mapFinalResults;

  public CalculateOverallFrequency(List<SinglePageFrequency> pageResults, Set<String>words){
      this.pageResults = pageResults;
      mapFinalResults = new HashMap<>();
      for(String word:words){
        mapFinalResults.put(word,0);
      }
  }

  public void printOccurrencesOfWordsAcrossAllUrls() {

    for(SinglePageFrequency sp: pageResults){

      HashMap<String, Integer>spMap = sp.getMapping();

      spMap.forEach((key, value) -> mapFinalResults.merge(key,value,
          (value1, value2)-> value1+value2));

    }

//    PriorityQueue<Map.Entry<String, Integer>> maxHeap =
//        new PriorityQueue<>((o1, o2) -> {
//          if (o1.getValue().equals(o2.getValue())) {
//            return o1.getKey().compareTo(o2.getKey());
//          } else {
//            return o2.getValue().compareTo(o1.getValue());
//          }
//        });

    ArrayList<Word> listOfWords = new ArrayList<>();

//    for (Map.Entry<String, Integer> entry : mapFinalResults.entrySet()) {
//      maxHeap.add(entry);
//    }

    for (Map.Entry<String, Integer> entry : mapFinalResults.entrySet()) {
      listOfWords.add(new Word(entry.getKey(), entry.getValue()));
    }

    OrderList order = new OrderList(listOfWords);
    PriorityQueue<Word>maxHeap = order.getOrderedWordsBasedOnOccurrence();

//    while(maxHeap.size()!=0){
//      Map.Entry<String,Integer> entry = maxHeap.poll();
//      System.out.println(entry.getKey() + " - " + entry.getValue());
//    }

    while(maxHeap.size()!=0){
      Word word = maxHeap.poll();
      System.out.println(word.getName() + " - " + word.getOccurance());
    }

  }
}
