import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;

import exception.EmptyFileException;
import exception.InvalidFileFormatException;
import exception.WebsiteNotReachableException;

public class WordFrequencyTest {

  private final String PATH = "src/test/java/";

  /**
   * Test is empty file exception is thrown if url file is empty.
   */
  @Test(expected = EmptyFileException.class)
  public void testEmptyFileExceptionOnUrlFile() throws FileNotFoundException,
      InvalidFileFormatException, EmptyFileException, WebsiteNotReachableException {
    String[] args = new String[]{PATH+"emptyUrl.txt", PATH+"word.txt"};
    Main.main(args);
  }

  /**
   * Test is empty file exception is thrown if word file is empty.
   */
  @Test(expected = EmptyFileException.class)
  public void testEmptyFileExceptionOnWordFile() throws FileNotFoundException,
      InvalidFileFormatException, EmptyFileException, WebsiteNotReachableException {
    String[] args = new String[]{PATH+"url.txt", PATH+"emptyWord.txt"};
    Main.main(args);
  }

  /**
   * Test is Illegal file format exception is thrown if word file is of illegal format.
   */
  @Test(expected = InvalidFileFormatException.class)
  public void testInvalidFileFormatExceptionOnWordFile() throws FileNotFoundException,
      InvalidFileFormatException, EmptyFileException, WebsiteNotReachableException {
    String[] args = new String[]{PATH+"url.txt", PATH+"invalidWord.txt"};
    Main.main(args);
  }

  /**
   * Test is Illegal file format exception is thrown if url file is of illegal format.
   */
  @Test(expected = InvalidFileFormatException.class)
  public void testInvalidFileFormatExceptionOnUrlFile() throws FileNotFoundException,
      InvalidFileFormatException, EmptyFileException, WebsiteNotReachableException {
    String[] args = new String[]{PATH+"invalidUrl.txt", PATH+"word.txt"};
    Main.main(args);
  }

  /**
   * Test if websiteNotReachable is not thrown instead handled in the program
   */
  @Test
  public void testWebsiteNotReachable() throws FileNotFoundException,
      InvalidFileFormatException, EmptyFileException, WebsiteNotReachableException {
      String[] args = new String[]{PATH+"url-invalid.txt", PATH+"word.txt"};
      Main.main(args);
  }

  /**
   * Test if invalidUrlException is not thrown instead handled in the program
   */
  @Test
  public void testInvalidUrlExceptionOnUrlFile() throws FileNotFoundException,
      InvalidFileFormatException, EmptyFileException, WebsiteNotReachableException {
      String[] args = new String[]{PATH+"url-invalid.txt", PATH+"word.txt"};
      Main.main(args);
  }

}
