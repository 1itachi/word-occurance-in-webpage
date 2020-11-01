package scraper;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import exception.WebsiteNotReachableException;

/**
 * Class provides method to scrape web page
 */
public class Scraper {
  /**
   * This method scrapes the web page of the given url and returns the response as string.
   * @return Scraped results as a string
   * @throws WebsiteNotReachableException
   */
  public String scrapeWebPage(String url) throws WebsiteNotReachableException {
    Document doc = null;
    try {
      doc =  Jsoup.connect(url).get();;
    } catch (IOException e) {
      throw new WebsiteNotReachableException(url + " Not reachable");
    }
    return doc.body().text();
  }
}
