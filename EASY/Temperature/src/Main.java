import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
public class Main {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // the number of temperatures to analyse
        int[] temperatureList = new int[n];
        in.nextLine();
        String temps = in.nextLine(); // the n temperatures expressed as integers ranging from -273 to 5526
        if (!temps.isEmpty()) {
            temperatureList = Arrays.stream(temps.split(" ")).mapToInt(Integer::parseInt).toArray();
            Integer[] ever = IntStream.of(temperatureList).boxed().toArray(Integer[]::new);

            ArrayList<Integer> positiveNumbers = Arrays.stream(ever).filter(integer -> integer > 0).collect(Collectors.toCollection(ArrayList::new));
            ArrayList<Integer> negativeNumbers = Arrays.stream(ever).filter(integer -> integer < 0).collect(Collectors.toCollection(ArrayList::new));

            Integer postiveClosestToZero = positiveNumbers.stream().sorted(Integer::compareTo).findFirst().orElse(null);
            Integer negativeClosestToZero = negativeNumbers.stream().sorted(Integer::compareTo).reduce((integer, integer2) -> integer2).orElse(null);

            Integer result = postiveClosestToZero;

            if (postiveClosestToZero == null) {
                result = negativeClosestToZero;
            } else if (negativeClosestToZero == null) {
                result = postiveClosestToZero;
            } else {
                if (postiveClosestToZero > negativeClosestToZero) {
                    result = postiveClosestToZero;
                } else {
                    result = negativeClosestToZero;
                }
            }

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");
            System.out.println(result);
        } else {
            System.out.println(0);
        }
    }
}