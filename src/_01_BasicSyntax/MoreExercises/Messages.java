package _01_BasicSyntax.MoreExercises;

import java.util.Scanner;

public class Messages {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = Integer.parseInt(sc.nextLine());
        String letter = "";
        String output = "";

        for (int i=0; i<length; i++) {
            String input = sc.nextLine();
            int currentDigit = Integer.parseInt(input.substring(0,1));
            int offSet = 0;
            if (currentDigit==8 || currentDigit ==9) {
                offSet = (currentDigit-2)*3+1;
            } else {
                offSet = (currentDigit-2)*3;
            }

            if (currentDigit==0) {
                letter = " ";
            } else {
                letter = Character.toString(97+(offSet+input.length()-1));
            }

            output += letter;
            letter = "";
        }
        System.out.print(output);

    }
}
