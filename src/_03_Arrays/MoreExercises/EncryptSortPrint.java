package _03_Arrays.MoreExercises;

import java.util.Scanner;

public class EncryptSortPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfStrings = Integer.parseInt(scanner.nextLine());
        int[] stringCodes = new int[numberOfStrings];

        for (int i = 0; i < numberOfStrings; i++) {
            char[] currentArray = scanner.nextLine().toCharArray();
            for (char c : currentArray) {
                switch (c) {
                    case 'a':
                    case 'e':
                    case 'o':
                    case 'i':
                    case 'u':
                        stringCodes[i] += c * currentArray.length;
                        break;
                    default:
                        stringCodes[i] += c / currentArray.length;
                }
            }
        }


        for (int i = 0; i < stringCodes.length-1; i++) {
            for (int j = i+1; j < stringCodes.length; j++) {
                if (stringCodes[i] > stringCodes[j]) {
                    int temp = stringCodes[j];
                    for (int k = j; k > i; k--) {
                        stringCodes[k] = stringCodes[k-1];
                    }
                    stringCodes[i] =temp;
                }
            }
        }


        for (int code : stringCodes) {
            System.out.println(code);
        }
    }
}
