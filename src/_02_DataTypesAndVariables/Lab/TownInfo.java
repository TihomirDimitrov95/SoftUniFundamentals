package _02_DataTypesAndVariables.Lab;

import java.util.Scanner;

public class TownInfo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String townName = scanner.nextLine();
        int townPopulation = Integer.parseInt(scanner.nextLine());
        short townArea = Short.parseShort(scanner.nextLine());

        String outputFormatted = String.format("Town %s has population of %d and area %d square km.", townName, townPopulation, townArea);
        System.out.println(outputFormatted);

    }
}
