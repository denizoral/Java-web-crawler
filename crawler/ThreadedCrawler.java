package crawler;

import settings.Settings;

import java.util.Scanner;

public class ThreadedCrawler implements Runnable{

    @Override
    public void run() {
        System.out.println("Thread " + Thread.currentThread().getId() + " is now running.");


    }
}
