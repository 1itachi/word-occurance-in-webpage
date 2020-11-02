import java.io.File;
import java.io.FileNotFoundException;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import exception.EmptyFileException;
import exception.InvalidFileFormatException;
import exception.WebsiteNotReachableException;


/**
 * Class for main method.
 */
public class Main {
  public static void main(String[] args) throws FileNotFoundException, InvalidFileFormatException,
      WebsiteNotReachableException, EmptyFileException {
    Set<String> urls = readFile(args[0]);
    Set<String> words = readFile(args[1]);

    if(urls.isEmpty())
      throw new EmptyFileException("File for url has no content!!");
    if(words.isEmpty())
      throw new EmptyFileException("File for words has no content!!");

    Worker worker = new Worker();
    worker.run(urls,words);

  }


  /**
   * Function to read the files and return a set of string values.
   * @param fileName file
   * @return Set containing unique values
   * @throws FileNotFoundException throws exception if the file is not found.
   */
  private static Set<String> readFile(String fileName) throws FileNotFoundException,
      InvalidFileFormatException {

    Set<String> setOfWords = new HashSet<>();
    try{
      File file = new File(fileName);
      Scanner scanner = new Scanner(file);
      while (scanner.hasNextLine()) {
        String line = scanner.nextLine().trim();
        if(line.split(" ").length>1)
          throw new InvalidFileFormatException(fileName + " is in invalid format.");
        if (!setOfWords.contains(line) && !line.trim().isEmpty()) {
          setOfWords.add(line.toLowerCase());
        }
      }
    } catch (FileNotFoundException e){
      throw new FileNotFoundException(fileName + " not found!");
    } catch (InvalidFileFormatException exception){
      throw exception;
    }

    return setOfWords;
  }
}
