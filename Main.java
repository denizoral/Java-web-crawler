import crawler.Crawler;
import settings.Settings;

import java.util.Scanner;

public class Main {

    static Crawler crawl;

    public static void main(String[] args) {
        if (Settings.getUrl() == null) {
            System.out.print("I see that you didn't set your url that you want to be crawled\nwould you like to set it now? (Y/N) ");
            Scanner scan = new Scanner(System.in);
            String input = scan.nextLine();
            if (input.toUpperCase().equals("Y")) {
                System.out.print("Enter your URL: ");
                input = scan.nextLine();
                Settings.setUrl(input);
                crawl = new Crawler(Settings.getUrl());
            } else {
                System.out.println("Bye");
            }
        } else {
            crawl = new Crawler(Settings.getUrl());
        }
    }
}
