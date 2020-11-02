package exception;

/**
 * Exception if the url is invalid.
 */
public class InvalidUrlException extends Exception {
  public InvalidUrlException(String msg){
    super(msg);
  }
}
