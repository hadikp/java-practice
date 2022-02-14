package exam03.histogram;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Histogram {

    public String createHistogram(List<String> file, Path path) {
        StringBuilder sb = new StringBuilder();
        List<String> fileRead = readFile(path);
        for (String st: fileRead) {
            int numberStars = Integer.parseInt(st);
            //sb.append("*".repeat(numberStars));
            sb.append("\n");
        }
        return sb.toString();
    }

    private List<String> readFile(Path path) {
        try {
            return Files.readAllLines(path);
        }
        catch (IOException ioe) {
            throw new IllegalArgumentException("Can't read file!", ioe);
        }
    }
}
