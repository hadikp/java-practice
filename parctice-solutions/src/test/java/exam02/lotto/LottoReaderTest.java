package exam02.lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class LottoReaderTest {

    LottoReader lottoReader;

    @BeforeEach
    void init() {
        lottoReader = new LottoReader();
        Path path = Path.of("src/test/resources/otos.csv");
        lottoReader.makeMapFromData(path);
    }

    @Test
    void testNumbers() {
        assertEquals(190, lottoReader.getNumbers().get(1));
        assertEquals(148, lottoReader.getNumbers().get(5));
        assertEquals(185, lottoReader.getNumbers().get(22));
        assertEquals(172, lottoReader.getNumbers().get(90));
    }

    @Test
    void testMaxNumbers() {
        assertEquals(3, lottoReader.maxNumbers());
    }

    @Test
    void testMinNumbers() {
        assertEquals(88, lottoReader.minNumbers());
    }

}