import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

public class Day2Test {

    @Test
    public void shouldReturnSumOfIdsOfPossibleGames() throws FileNotFoundException {
        //given
        String inputPath = "src/test/resources/Day2.txt";
        int expectedSum = 8;

        //when
        int actualSum = Day2.findGamesIdsSum(inputPath);

        //then
        Assertions.assertEquals(expectedSum, actualSum);
    }

    @Test
    public void shouldReturnSumOfPowerSets() throws FileNotFoundException {
        //given
        String inputPath = "src/test/resources/Day2.txt";
        int expectedSum = 2286;

        //when
        int actualSum = Day2.findSumOfPower(inputPath);

        //then
        Assertions.assertEquals(expectedSum, actualSum);
    }
}
