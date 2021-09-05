package _05_Lists.MoreExercises;

import java.util.List;
import java.util.Scanner;
import java.util.*;
import java.util.stream.Collectors;

public class Messaging {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> listOfNumbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        String message = scanner.nextLine();

        StringBuilder finalMessage = new StringBuilder();

        for (int num: listOfNumbers) {
            int sum = 0;
            while (num>0) {
                int lastDigit = num%10;
                sum+=lastDigit;
                num/=10;
            }

            while (sum>=message.length()) {
                sum -= message.length();
            }

            finalMessage.append(message.charAt(sum));
            message = message.substring(0, sum) + message.substring(sum+1);
        }

        System.out.println(finalMessage);
    }
}
