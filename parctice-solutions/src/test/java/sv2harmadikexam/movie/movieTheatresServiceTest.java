package sv2harmadikexam.movie;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class movieTheatresServiceTest {

    MovieTheatreService mvs;

    @BeforeEach
    void init() {
        mvs = new MovieTheatreService();
        mvs.readFromFile(Path.of("src/test/resources/moviesintheaters.txt"));

    }


    @Test
    void testReadFromFile() {

        assertEquals(3, mvs.getShows().keySet().size());
        assertEquals(List.of("Puskin", "Duna Plaza", "WestEnd"), new ArrayList<>(mvs.getShows().keySet()));
        assertEquals(List.of("Paw Petrol", "Lord Of The Rings"), mvs.getShows().get("Puskin").stream().map(Movie::getTitle).toList());
    }

    @Test
    void testFindMovie() {
        assertEquals(List.of("Duna Plaza", "WestEnd"), mvs.findMovie("Star Wars"));
        assertTrue(mvs.findMovie("Indinana Jones").isEmpty());
    }

    @Test
    void testFindLatestShowTest() {
        assertEquals(LocalTime.of(20,45),mvs.findLatestShow("Lord Of The Rings"));
        assertEquals(LocalTime.of(19,45),mvs.findLatestShow("Star Wars"));
    }

    @Test
    void testFindLatestShowWithWrongName(){
        assertThrows(IllegalArgumentException.class,()->mvs.findLatestShow("Indiana Jones"));
    }

    @Test
    void testMakeMap() {
        //mvs.readFromFile(Path.of("src/test/resources/moviesintheaters.txt"));
        System.out.println(mvs.findLatestShow("Paw Petrol"));

    }

}