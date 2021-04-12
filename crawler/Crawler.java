package crawler;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;


public class Crawler {

    public Crawler(String URL) {
        crawl(URL);
    }

    static boolean startup = true;
    static QueueLinks queue = new QueueLinks();
    static FileHandler handler = new FileHandler();

    public static void crawl(String URL) {

        Document doc;
        Elements links;

        try {
            doc = Jsoup.connect(URL)
                    .ignoreHttpErrors(true)
                    .ignoreContentType(true)
                    .userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:25.0) Gecko/20100101 Firefox/25.0")
                    .referrer("https://www.google.com")
                    .timeout(0)
                    .followRedirects(true)
                    .get();

            links = doc.select("a");
            System.out.println("=====================Links being added to the queue ========================");
            for (Element link : links) {
                if (!startup && (queue.crawledList().contains(link.attr("abs:href")) || queue.contains(link.attr("abs:href")))) {
                } else {
                    if ((link.attr("abs:href").isEmpty())
                            || (link.attr("abs:href").isBlank())
                            || link.attr("abs:href").contains("mail:to")) {
                        System.out.println("Skipped invalid URL");
                    } else {
                        System.out.println("[Added to Queue] " + link.attr("abs:href"));
                        queue.addQueue(link.attr("abs:href"));
                        startup = false;
                    }
                }
            }

            if (!(queue.crawledList().contains(queue.peek()))) {
                queue.addCrawled(queue.peek());
                handler.fileHandler(queue.peek(), "crawled.txt");
                crawl(queue.nextLink());
            } else if (queue.isEmpty()) {
                System.out.println("Queue is empty. Done crawling!");
                System.exit(0);
            } else {
                queue.removeQueue();
                crawl(queue.nextLink());
            }
        } catch (HttpStatusException e) {
            System.out.println("Error on link: " + URL + " Skipping...");
            queue.removeQueue();
        } catch (IOException e) {
            System.out.println("Error on link " + e);
        }
    }

    public static void bootup(String URL) {

    }

}
