package _02_DataTypesAndVariables.Exercises;

import java.util.Scanner;

public class BeerKegs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        double volumeOfBiggestKeg = 0;
        String modelOfBiggestKeg = "";

        for (int i = 0; i < n; i++) {
            String model = scanner.nextLine();
            double radius = Double.parseDouble(scanner.nextLine());
            int height = Integer.parseInt(scanner.nextLine());

            double volume = Math.PI * Math.pow(radius,2) * height;
            if (volume>volumeOfBiggestKeg) {
                modelOfBiggestKeg = "";
                modelOfBiggestKeg += model;
                volumeOfBiggestKeg = volume;
            }
        }

        System.out.println(modelOfBiggestKeg);

    }
}
