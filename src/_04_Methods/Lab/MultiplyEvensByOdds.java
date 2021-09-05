package _04_Methods.Lab;

import java.util.Scanner;

public class MultiplyEvensByOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());

        int sum = getSumOfEvens(num) * getSumOfOdds(num);
        System.out.println(sum);

    }

    public static int getSumOfEvens (int num) {
        num = Math.abs(num);
        int sum = 0;
        while (num>0) {
            int digit = num%10;
            if (digit%2==0) {
                sum += digit;
            }
            num /= 10;
        }
        return sum;
    }

    public static int getSumOfOdds(int num) {
        num = Math.abs(num);
        int sum = 0;
        while (num>0) {
            int digit = num%10;
            if (digit%2==1) {
                sum += digit;
            }
            num /= 10;
        }
        return sum;
    }
}
