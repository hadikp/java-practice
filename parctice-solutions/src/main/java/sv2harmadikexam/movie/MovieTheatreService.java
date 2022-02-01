package sv2harmadikexam.movie;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalTime;
import java.util.*;

public class MovieTheatreService {

    private Map<String, List<Movie>> shows = new LinkedHashMap<>();


    public void readFromFile(Path path) {
        List<String> readFile = readFile(path);

        for (String st: readFile) {
            String[] stSplit = st.split("-");
            String cinema = stSplit[0];
            String[] stSplitSplit = stSplit[1].split(";");
            String title = stSplitSplit[0];
            String[] stSplitSplitsplit = stSplitSplit[1].split(":");
            int hour = Integer.parseInt(stSplitSplitsplit[0].trim());
            int minute = Integer.parseInt(stSplitSplitsplit[1]);
            LocalTime time = LocalTime.of(hour, minute);

            if (!shows.containsKey(cinema)) {
                shows.put(cinema, new ArrayList<>(Arrays.asList(new Movie(title, time))));
            } else {
                List<Movie> value = shows.get(cinema);
                value.add(new Movie(title, time));
                shows.put(cinema, value);
            }
        }
        sortListMap();
    }

    private List<String> readFile(Path path) {
        try {
            return Files.readAllLines(path);
        }
        catch (IOException ioe) {
            throw new IllegalStateException("Can't read file!");
        }
    }

    public void sortListMap() {
        for (Map.Entry<String, List<Movie>> m: shows.entrySet()) {
            List<Movie> value = m.getValue();
            List<Movie> movieListOrdered = value.stream().sorted(Comparator.comparing(Movie::getStartTime)).toList();
            shows.put(m.getKey(), movieListOrdered);
        }
    }

    public List<String> findMovie(String title) {
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, List<Movie>> m: shows.entrySet()) {
            boolean isTitle = isTitle(title, m);
            if (isTitle) {
                result.add(m.getKey());
            }
        }
        return result;
    }

    private boolean isTitle(String title, Map.Entry<String, List<Movie>> m) {
        boolean isTitle = m.getValue().stream().anyMatch(f -> f.getTitle().equals(title));
        return isTitle;
    }

    public LocalTime findLatestShow(String title) {
        LocalTime latest = LocalTime.of(0,0);
        for (Map.Entry<String, List<Movie>> m: shows.entrySet()) {
            List<Movie> value = m.getValue();
            for (Movie mk: value) {
                if (mk.getTitle().equals(title)) {
                   LocalTime l = mk.getStartTime();
                    if (latest.isBefore(l)) {
                        latest = l;
                    }
                }
            }

        }
        if (latest.equals(LocalTime.of(0,0))) {
            throw new IllegalArgumentException("Can't find movie!");
        }
        return latest;
    }

    public Map<String, List<Movie>> getShows() {
        return shows;
    }

    public void writeMap() {
        for (Map.Entry<String, List<Movie>> m: shows.entrySet()) {
            System.out.println(m.getKey());
            System.out.println(m.getValue());
        }
    }
}
