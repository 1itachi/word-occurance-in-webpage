package exception;

/**
 * Exception if the File format is not valid.
 */
public class InvalidFileFormatException extends Exception {
    public InvalidFileFormatException(String msg){
       super(msg);
    }

}
