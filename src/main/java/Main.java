import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import javax.print.DocFlavor;

import process.CalculateOverallFrequency;
import scraper.Scraper;

public class Main {
  public static void main(String[] args) throws Exception {
    Set<String> urls = readFile(args[0]);
    Set<String> words = readFile(args[1]);
    Worker worker = new Worker();
    worker.run(urls,words);

  }



  private static Set<String> readFile(String fileName) throws Exception {
    Set<String> setOfWords = new HashSet<String>();
    try {
      File file = new File(fileName);
      Scanner scanner = new Scanner(file);
      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        if (!setOfWords.contains(line) && !line.trim().isEmpty()) {
          setOfWords.add(line.toLowerCase());
//          System.out.println(line);
        }
      }
    } catch (FileNotFoundException e){
      throw new FileNotFoundException(fileName + " not found!");
    }

    return setOfWords;
  }
}
