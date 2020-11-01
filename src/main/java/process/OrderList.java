package process;

import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class OrderList {

  private List<Word>listOfWords;

  public OrderList(List<Word>listOfWords){
    this.listOfWords = listOfWords;
  }

  public PriorityQueue<Word> getOrderedWordsBasedOnOccurrence(){
     PriorityQueue<Word> maxHeap =
        new PriorityQueue<>((w1, w2) -> {
          if (w1.getOccurance() == w2.getOccurance()) {
            return w1.getName().compareTo(w2.getName());
          } else {
            return (w2.getOccurance() - w1.getOccurance());
          }
        });

     for(Word word:listOfWords){
       maxHeap.add(word);
     }

    return maxHeap;
  }

}
