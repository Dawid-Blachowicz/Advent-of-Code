import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day1 {
    public static void main(String[] args) throws FileNotFoundException {
        int result = findCalibrationValues("src/main/resources/data/Day1.txt");
        System.out.println(result);
    }

    public static int findCalibrationValues(String inputPath) throws FileNotFoundException {
        int calibrationSum = 0;

        Scanner scanner = new Scanner(new File(inputPath));

        Map<String, Integer> letterDigits = new HashMap<>();
        letterDigits.put("one", 1);
        letterDigits.put("two", 2);
        letterDigits.put("three", 3);
        letterDigits.put("four", 4);
        letterDigits.put("five", 5);
        letterDigits.put("six", 6);
        letterDigits.put("seven", 7);
        letterDigits.put("eight", 8);
        letterDigits.put("nine", 9);


        while(scanner.hasNext()) {
            String line = scanner.next();
            StringBuilder calibrationBuilder = new StringBuilder();

            String firstDigit = null;
            String lastDigit = null;
            String subLine;

            for(int i = 0; i < line.length(); i++) {
                if (Character.isDigit(line.charAt(i))) {
                    if (firstDigit == null) {
                        firstDigit = Character.toString(line.charAt(i));
                    }
                    lastDigit = Character.toString(line.charAt(i));

                } else {
                    subLine = line.substring(i);
                    for (Map.Entry<String, Integer> entry : letterDigits.entrySet()) {
                        if (subLine.startsWith(entry.getKey())) {
                            if (firstDigit == null) {
                                firstDigit = String.valueOf(entry.getValue());
                            }
                            else {
                                lastDigit = String.valueOf(entry.getValue());
                            }
                            break;
                        }
                    }
                }
            }

            calibrationBuilder.append(firstDigit);
            calibrationBuilder.append(lastDigit);
            int calibration = Integer.parseInt(calibrationBuilder.toString());
            calibrationSum += calibration;
        }

        return calibrationSum;
    }

}
