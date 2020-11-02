package scraper;
import java.io.IOException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import exception.InvalidUrlException;
import exception.WebsiteNotReachableException;

/**
 * Class provides method to scrape web page.
 */
public class Scraper {
  /**
   * This method scrapes the web page of the given url and returns the response as string.
   * @return Scraped results as a string.
   * @throws WebsiteNotReachableException exception if the website is not accessible.
   */
  public String scrapeWebPage(String url) throws WebsiteNotReachableException, InvalidUrlException {
    try{
      new URL(url).toURI();
    } catch (Exception e){
      throw new InvalidUrlException(url + " Not a valid url");
    }

    Document doc = null;
    try {
      doc =  Jsoup.connect(url).get();;
    } catch (IOException e) {
      throw new WebsiteNotReachableException(url + " Not reachable");
    }
    return doc.body().text();
  }
}
