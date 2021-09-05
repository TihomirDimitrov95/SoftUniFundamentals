package _01_BasicSyntax.Exercises;

import java.util.Scanner;

public class RageExpenses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lostGames = scanner.nextInt();
        double headsetPrice = scanner.nextDouble();
        double mousePrice = scanner.nextDouble();
        double keyboardPrice = scanner.nextDouble();
        double displayPrice = scanner.nextDouble();

        double sum = 0;
        int count = 0;

        for (int i = 1; i <= lostGames; i++) {
            if (i%2==0) {
                if (i%3==0) {
                    count++;
                    if (count==2) {
                        sum+=displayPrice;
                        count=0;
                    }
                    sum+= keyboardPrice + mousePrice + headsetPrice;
                } else {
                    sum += headsetPrice;
                }
            } else if (i%3==0) {
                sum += mousePrice;
            }
        }
        System.out.printf("Rage expenses: %.2f lv.", sum);
    }
}
