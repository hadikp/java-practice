package exam02.lotto;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class LottoReader {

    private Map<Integer, Integer> numbers = new TreeMap<>();


    public Map<Integer, Integer> makeMapFromData(Path path) {
        List<String> begin = readFile(path);
        Map<Integer, Integer> result = new TreeMap<>();
        for (String st: begin) {
            String[] beginSplit = st.split(";");
            int first = Integer.parseInt(beginSplit[11]);
            int second = Integer.parseInt(beginSplit[12]);
            int third = Integer.parseInt(beginSplit[13]);
            int fourth = Integer.parseInt(beginSplit[14]);
            int five = Integer.parseInt(beginSplit[15]);
            numbersPutMap(first);
            numbersPutMap(second);
            numbersPutMap(third);
            numbersPutMap(fourth);
            numbersPutMap(five);
        }
        return result;
    }

    public int maxNumbers() {
        int max = 0;
        int key = 0;
        for (Map.Entry<Integer, Integer> m: numbers.entrySet()) {
            if (m.getValue() > max) {
                max = m.getValue();
                key = m.getKey();
            }
        }
        return key;
    }

    public int minNumbers() {
        int min = 10000;
        int key = 0;
        for (Map.Entry<Integer, Integer> m: numbers.entrySet()) {
            if (m.getValue() < min) {
                min = m.getValue();
                key = m.getKey();
            }
        }
        return key;
    }

    private void numbersPutMap(int first) {
        if (!numbers.containsKey(first)) {
            numbers.put(first, 1);
        }else {
            numbers.put(first, numbers.get(first)+1);
        }
    }

    private List<String> readFile(Path path) {
        try {
            return Files.readAllLines(path);
        }
        catch (IOException ioe) {
            throw new IllegalArgumentException("Can't read file!");
        }
    }

    public Map<Integer, Integer> getNumbers() {
        return numbers;
    }
}
