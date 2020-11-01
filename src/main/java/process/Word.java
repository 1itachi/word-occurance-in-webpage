package process;

public class Word {
  private String name;
  private int occurance;

  public Word(String name, int occurance){
    this.name = name;
    this.occurance = occurance;
  }

  public String getName() {
    return name;
  }

  public int getOccurance() {
    return occurance;
  }
}
