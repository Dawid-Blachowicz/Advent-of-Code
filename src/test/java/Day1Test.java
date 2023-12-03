import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

public class Day1Test {
    @Test
    public void testNumericalDigits() throws FileNotFoundException {
        //given
        String inputPath = "src/test/resources/Day1Numerical.txt";
        int expectedCalibration = 142;

        //when
        int actualCalibration = Day1.findCalibrationValues(inputPath);

        //then
        Assertions.assertEquals(expectedCalibration, actualCalibration);
    }

    @Test
    public void testLetterDigits() throws FileNotFoundException {
        //given
        String inputPath = "src/test/resources/Day1Letters.txt";
        int expectedCalibration = 281;

        //when
        int actualCalibration = Day1.findCalibrationValues(inputPath);

        //then
        Assertions.assertEquals(expectedCalibration, actualCalibration);
    }
}
