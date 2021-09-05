package _02_DataTypesAndVariables.Lab;

import java.util.Scanner;

public class PoundsToDollars {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        double poundsAvailable = Double.parseDouble(sc.nextLine());
        double poundToDollarsExchangeRate = 1.31;
        double moneyConvertedToDollars = poundsAvailable*poundToDollarsExchangeRate;

        String output = String.format("%.3f", moneyConvertedToDollars);

        System.out.println(output);
    }
}
