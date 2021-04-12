package crawler;

import java.io.FileWriter;
import java.io.IOException;

public class FileHandler {

    public void fileHandler(String URL, String filename) {
        try {
            FileWriter createFile = new FileWriter(filename, true);
            createFile.write(URL + "\n");

            createFile.close();
        } catch (IOException e){
            System.out.println(e);
        }
    }
}
