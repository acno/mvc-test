package app;

import org.springframework.stereotype.Component;

import java.io.*;
import java.util.LinkedList;

@Component
public class FileSaver {
    private File filename = new File("test.txt");

    public void save(String message) {
        try (PrintWriter pw = new PrintWriter(new FileOutputStream("test.txt", true))) {
            pw.println(message);
            System.out.println(filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public LinkedList<String> read() {
        LinkedList<String> lines = new LinkedList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }
}