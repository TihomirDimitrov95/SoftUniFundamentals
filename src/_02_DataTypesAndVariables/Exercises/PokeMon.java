package _02_DataTypesAndVariables.Exercises;

import java.util.Scanner;

public class PokeMon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pokePower = Integer.parseInt(scanner.nextLine());
        int distance = Integer.parseInt(scanner.nextLine());
        int exhaustionFactor = Integer.parseInt(scanner.nextLine());
        int countOfPokes = 0;

        int originalPower = pokePower;

        while (pokePower>=distance) {
            pokePower -= distance;
            countOfPokes++;

            if ( pokePower == originalPower/2) {
                if (exhaustionFactor!=0) {
                    pokePower /= exhaustionFactor;
                }
            }
        }

        System.out.println(pokePower);
        System.out.println(countOfPokes);


    }
}
