package _03_Arrays.Exercises;

import java.util.Scanner;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfWagons = Integer.parseInt(scanner.nextLine());
        int[] peopleInEachWagon = new int[numberOfWagons];

        int sumOfPassengers = 0;
        for (int wagon = 0; wagon < numberOfWagons; wagon++) {
            peopleInEachWagon[wagon] = Integer.parseInt(scanner.nextLine());
        }

        for (int passengers : peopleInEachWagon) {
            sumOfPassengers+=passengers;
            System.out.print(passengers + " ");
        }
        System.out.println("\n" + sumOfPassengers);
    }
}
