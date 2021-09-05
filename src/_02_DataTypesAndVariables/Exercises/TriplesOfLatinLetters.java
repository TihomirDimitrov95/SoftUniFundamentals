package _02_DataTypesAndVariables.Exercises;

import java.util.Scanner;

public class TriplesOfLatinLetters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int firstChar = 97; firstChar < 97+n; firstChar++) {
            for (int secondChar = 97; secondChar < 97+n; secondChar++) {
                for (int thirdChar = 97; thirdChar < 97+n; thirdChar++) {
                    String output = "";
                    output += (char)firstChar;
                    output += (char)secondChar;
                    output += (char)thirdChar;
                    System.out.println(output);
                }
            }
        }
    }
}
