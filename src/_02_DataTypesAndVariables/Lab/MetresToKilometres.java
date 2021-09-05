package _02_DataTypesAndVariables.Lab;

import java.util.Scanner;

public class MetresToKilometres {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int distanceInMetres = Integer.parseInt(scanner.nextLine());
        double distanceInKilometres = distanceInMetres/1000.0;
        String output = String.format("%.2f", distanceInKilometres);
        System.out.println(output);
    }
}
