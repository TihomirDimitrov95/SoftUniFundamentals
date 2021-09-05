package _09_TextProcessing.Lab;

import java.util.Scanner;

public class Substring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String wordToRemove = scanner.nextLine();
        String input = scanner.nextLine();

        while(input.contains(wordToRemove)) {
            input = input.replace(wordToRemove, "");

        }

        System.out.println(input);
    }
}
