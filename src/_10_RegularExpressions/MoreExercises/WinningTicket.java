package _10_RegularExpressions.MoreExercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WinningTicket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tickets = scanner.nextLine().split("\\s*,+\\s*");

        for (String ticket : tickets) {
            if (ticket.length() != 20) {
                System.out.println("invalid ticket");
            } else {
                String leftHalf = ticket.substring(0, 10);
                String rightHalf = ticket.substring(10);

                String regex = "[@]{6,10}|[#]{6,10}|[$]{6,10}|[\\^]{6,10}";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcherLeft = pattern.matcher(leftHalf);
                Matcher matcherRight = pattern.matcher(rightHalf);

                String sequenceLeft = "";
                while (matcherLeft.find()) {
                    sequenceLeft = matcherLeft.group();
                }

                String sequenceRight = "";
                while (matcherRight.find()) {
                    sequenceRight = matcherRight.group();
                }

                if (sequenceLeft.equals(sequenceRight) && sequenceLeft.length()>5) {
                    if (sequenceLeft.length()==10) {
                        System.out.printf("ticket \"%s\" - %d%c Jackpot!%n", ticket, sequenceLeft.length(), sequenceLeft.charAt(0));
                    } else {
                        System.out.printf("ticket \"%s\" - %d%c%n", ticket, sequenceLeft.length(), sequenceLeft.charAt(0));
                    }
                } else {
                    System.out.printf("ticket \"%s\" - no match%n", ticket);
                }
            }
        }

    }
}
