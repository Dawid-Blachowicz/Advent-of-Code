import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day2 {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(findGamesIdsSum("src/main/resources/data/Day2.txt"));
        System.out.println(findSumOfPower("src/main/resources/data/Day2.txt"));
    }

    public static int findGamesIdsSum(String inputPath) throws FileNotFoundException {
        int gamesIdsSum = 0;
        Map<String, Integer> cubesCounterMap = new HashMap<>();
        clearCubesCounter(cubesCounterMap);

        Map<String, Integer> cubeBag = new HashMap<>();
        cubeBag.put("red", 12);
        cubeBag.put("green", 13);
        cubeBag.put("blue", 14);

        Scanner scanner = new Scanner(new File(inputPath));
        while(scanner.hasNext()) {
            String game = scanner.nextLine();
            String[] gameTable = game.split(":");
            int gameNumber = Integer.parseInt(gameTable[0].substring(5));

            findMostCubesForEachColor(cubesCounterMap, gameTable);

            boolean isGamePossible = cubeBag.entrySet().stream()
                    .allMatch(e -> e.getValue() >= cubesCounterMap.getOrDefault(e.getKey(), 0));
            if(isGamePossible) {
                gamesIdsSum += gameNumber;
            }

            clearCubesCounter(cubesCounterMap);
        }

        return gamesIdsSum;
    }

    public static int findSumOfPower(String inputPath) throws FileNotFoundException {
        int sumOfPower = 0;
        Map<String, Integer> cubesCounterMap = new HashMap<>();
        clearCubesCounter(cubesCounterMap);

        Scanner scanner = new Scanner(new File(inputPath));
        while(scanner.hasNext()) {
            String game = scanner.nextLine();
            String[] gameTable = game.split(":");

            findMostCubesForEachColor(cubesCounterMap, gameTable);

            int power = cubesCounterMap.values().stream()
                            .reduce(1, (value1, value2) -> value1 * value2);
            sumOfPower += power;

            clearCubesCounter(cubesCounterMap);
        }

        return sumOfPower;
    }

    private static void findMostCubesForEachColor(Map<String, Integer> cubesCounterMap, String[] gameTable) {
        String[] gameSubsets = gameTable[1].split(";");
        Arrays.stream(gameSubsets)
                .flatMap(subset -> Arrays.stream(subset.trim().split(",")))
                .map(cubeInfo -> cubeInfo.trim().split(" "))
                .forEach(cube -> {
                    String color = cube[1];
                    int count = Integer.parseInt(cube[0]);
                    cubesCounterMap.merge(color, count, Integer::max);
                });
    }

    public static void clearCubesCounter(Map<String, Integer> cubesCounterMap) {
        cubesCounterMap.put("red", 0);
        cubesCounterMap.put("green", 0);
        cubesCounterMap.put("blue", 0);
    }
}
