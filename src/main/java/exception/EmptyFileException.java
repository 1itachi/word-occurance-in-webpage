package exception;

/**
 * Exception if the File format is not valid.
 */
public class EmptyFileException extends Exception {
  public EmptyFileException(String msg){
    super(msg);
  }

}
