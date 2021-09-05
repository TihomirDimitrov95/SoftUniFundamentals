package _01_BasicSyntax.MoreExercises;

import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        String input = new Scanner(System.in).nextLine();

        for (int i = input.length()-1; i >= 0; i--) {
            System.out.print(input.charAt(i));
        }
    }
}
