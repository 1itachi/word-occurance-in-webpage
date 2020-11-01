import java.io.File;
import java.io.FileNotFoundException;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


/**
 * Class for main method.
 */
public class Main {
  public static void main(String[] args) throws Exception {
    Set<String> urls = readFile(args[0]);
    Set<String> words = readFile(args[1]);
    Worker worker = new Worker();
    worker.run(urls,words);

  }


  /**
   * Function to read the files and return a set of string values.
   * @param fileName file
   * @return Set containing unique values
   * @throws FileNotFoundException throws exception if the file is not found.
   */
  private static Set<String> readFile(String fileName) throws FileNotFoundException {
    Set<String> setOfWords = new HashSet<>();
    try {
      File file = new File(fileName);
      Scanner scanner = new Scanner(file);
      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        if (!setOfWords.contains(line) && !line.trim().isEmpty()) {
          setOfWords.add(line.toLowerCase());
        }
      }
    } catch (FileNotFoundException e){
      throw new FileNotFoundException(fileName + " not found!");
    }

    return setOfWords;
  }
}
