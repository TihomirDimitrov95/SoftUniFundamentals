package _04_Methods.Exercises;

import java.util.Scanner;

public class VowelsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        System.out.println(getCountOfVowels(input));
    }

    private static int getCountOfVowels(String input) {
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.toLowerCase().charAt(i);
            switch (currentChar) {
                case 'o':
                case 'u':
                case 'i':
                case 'a':
                case 'e':
                case 'y':
                    count++;
                    break;
            }
        }

        return count;
    }
}
