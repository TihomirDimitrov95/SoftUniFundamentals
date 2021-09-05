package _01_BasicSyntax.Lab;

import java.util.Scanner;

public class BackInThirtyMinutes {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int hours = sc.nextInt();
        int minutes = sc.nextInt();

        minutes+=30;
        if (minutes>=60) {
            minutes -= 60;
            hours++;
        }
        if (hours==24) {
            hours = 0;
        }

        System.out.printf("%d:%02d", hours, minutes);

    }
}
