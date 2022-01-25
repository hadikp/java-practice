package exam03.histogram;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HistogramTest {

    @Test
    void test() {
        Path path = Path.of("src/test/resources/histogram.txt");
        Histogram histogram = new Histogram();
        List<String> file = new ArrayList<>();
        System.out.println( histogram.createHistogram(file, path));
    }
}