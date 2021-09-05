package _03_Arrays.Lab;

import java.util.Scanner;

public class EqualArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstInput = scanner.nextLine();
        String secondInput = scanner.nextLine();

        String[] firstArray = firstInput.split(" ");
        String[] secondArray = secondInput.split(" ");

        int sum = 0;
        for (int indexOfArray = 0; indexOfArray < firstArray.length; indexOfArray++) {
            int firstNum = Integer.parseInt(firstArray[indexOfArray]);
            int secondNum = Integer.parseInt(secondArray[indexOfArray]);
            if (firstNum==secondNum) {
                sum+=firstNum;
            } else {
                System.out.printf("Arrays are not identical. Found difference at %d index.", indexOfArray);
                break;
            }
            if (indexOfArray==firstArray.length-1) {
                System.out.printf("Arrays are identical. Sum: %d", sum);
            }
        }
    }
}
