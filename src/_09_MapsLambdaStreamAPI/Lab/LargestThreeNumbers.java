package _09_MapsLambdaStreamAPI.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class LargestThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .sorted((n1, n2) -> n2.compareTo(n1))
                .limit(3)
                .forEach(e -> System.out.print(e + " "));

    }
}
