package crawler;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class QueueLinks {

    Queue queue = new LinkedList<>();
    ArrayList crawled = new ArrayList();

    public void addCrawled(String URL) {
        crawled.add(URL);
    }

    public ArrayList crawledList() {
        return crawled;
    }

    public Boolean isEmpty() {
        return queue.isEmpty();
    }

    public boolean contains(String text){
        return queue.contains(text);
    }

    public void addQueue(String URL) {
        queue.add(URL);
    }

    public void removeQueue() {
        queue.remove();
    }

    public String peek() {
        return (String) queue.peek();
    }

    public String nextLink() {
        System.out.println("[Exploring] " + queue.peek());
        return (String) queue.poll();
    }

}
