package sv2harmadikexam.movie;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalTime;
import java.util.*;

public class MovieTheatreService {

    private Map<String, List<Movie>> shows = new HashMap<>();

    public void makeMap(Path path) {
        List<String> readFile = readFromFile(path);

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
            //List<Movie> movieListOrdered = movieList.stream().sorted(Comparator.comparing(Movie::getStartTime)).toList();
            // shows.put(theatre, movieListOrdered);
        }
    }

    public List<String> readFromFile(Path path) {
        try {
            return Files.readAllLines(path);
        }
        catch (IOException ioe) {
            throw new IllegalStateException("Can't read file!");
        }
    }

    public List<String> findMovie(String title) {
        List<String> result = new ArrayList<>();
        return result;
    }

    public LocalTime findLatestShow(String title) {
        for (Map.Entry<String, List<Movie>> m: shows.entrySet()) {
            List<Movie> value = m.getValue();
            if (value.contains(title)) {
                for (Movie mk: value) {
                    System.out.println(mk);
                }
            }
        }
        return null;
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
