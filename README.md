
## Word Search


#### Assumptions:

* Files (urls & words) will have values provided line by line. If a line is empty, it is ignored.
* Values are matched regardless of their case. For example: "CAT" and "cat" are matched as same.
* If duplicates urls/words are provided in the files, only one occurrence of the value is considered.
* The content of a page is split on all non-alphanumeric characters.
* List of urls and words should be listed in new lines.

#### Approach to the problem:

* Reading files : Set is used to store urls and words to avoid duplicate entries.
* For each url, a new instance of SinglePageFrequency is created and the occurrences of words is 
calculated and printed to console in the required format. A list of these objects is collected after 
completion of the task. The SinglePageFrequency class provides a method to get the word mapping.
* After all single page results are run, the list collected is passed on to the CaculateOverallFrequency
instance which uses getMapping() function of each instances to calculate the overall results of the 
occurrences.
* PriorityQueue is used to arrange the words in decreasing order os their occurrences.

#### Custom Exceptions:
* `EmptyFileException` : Exception if the file has no content
* `InvalidFileFormatException` : If the file has words in invalid format. (Each word should be 
listed in a separate line)
* `InvalidUrlException` : If the url specified is invalid
* `WebsiteNotReachableException`: if the website is not reachable


#### Build and run:
* Run JAR file: Unzip file and Navigate to root of the project, in the terminal run:
`java -jar nok-nok-word-search-maven.jar urls.txt words.txt`
* Maven should be installed. Run `mvn install`to build and install dependencies.
* Run tests by running `WordFrequencyTest` file.


References used:
* https://www.htmlgoodies.com/html5/other/web-page-scraping-with-jsoup.html
* https://stackoverflow.com/questions/20453450/check-that-a-method-throws-an-exception-when-applied-to-any-element-of-a-list-of

Scope for improvement:

* Using Threads.
