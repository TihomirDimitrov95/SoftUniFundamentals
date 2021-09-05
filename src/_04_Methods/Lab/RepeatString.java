package _04_Methods.Lab;

import java.util.Scanner;

public class RepeatString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        int repeatCount = Integer.parseInt(scanner.nextLine());

        String newString = getNewString(inputString, repeatCount);
        System.out.println(newString);

    }

    private static String getNewString(String inputString, int repeatCount) {
        StringBuilder newString = new StringBuilder();
        for (int i = 0; i < repeatCount; i++) {
            newString.append(inputString);
        }
        return newString.toString();
    }
}
