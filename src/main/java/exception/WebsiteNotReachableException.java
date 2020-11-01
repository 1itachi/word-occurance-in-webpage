package exception;

/**
 * Exception if the website is not reachable.
 */
public class WebsiteNotReachableException extends Exception {
    public WebsiteNotReachableException(String msg){
      super(msg);
    }
}


