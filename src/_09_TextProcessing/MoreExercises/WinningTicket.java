package _09_TextProcessing.MoreExercises;

import java.util.Scanner;

public class WinningTicket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tickets = scanner.nextLine().split("(\\s*,\\s*)");
        String winningSymbols = "@#$^";

        for (String ticket : tickets) {
            if (ticket.length() != 20) {
                System.out.println("invalid ticket");
            } else {
                if (checkIfJackpot(ticket, winningSymbols)) {
                    System.out.printf("ticket \"%s\" - 10%c Jackpot!%n", ticket, ticket.charAt(0));
                } else {
                    int pointsInTicket = calculatePointsInTicket(ticket, winningSymbols);
                    char specialSymbol = getSpecialSymbolInTicket(ticket, winningSymbols);

                    if (pointsInTicket<6) {
                        System.out.printf("ticket \"%s\" - no match%n", ticket);
                    } else {
                        System.out.printf("ticket \"%s\" - %d%c%n", ticket, pointsInTicket, specialSymbol);
                    }
                }
            }
        }

    }

    private static char getSpecialSymbolInTicket(String ticket, String winningSymbols) {
        char specialSymbol = 0;

        for (int i = 0; i < ticket.length(); i++) {
            if (winningSymbols.contains("" + ticket.charAt(i))) {
                specialSymbol = ticket.charAt(i);
                break;
            }
        }

        return specialSymbol;
    }

    private static int calculatePointsInTicket(String ticket, String winningSymbols) {
        int result = 0;

        String leftHalf = ticket.substring(0, ticket.length()/2);
        String rightHalf = ticket.substring(ticket.length()/2);

        char leftSpecialSymbol = 0;
        for (int i = 0; i < leftHalf.length(); i++) {
            if (winningSymbols.contains("" + leftHalf.charAt(i))) {
                leftSpecialSymbol = leftHalf.charAt(i);
                break;
            }
        }

        int leftCounter = 1;
        int currentCount = 1;
        for (int i = 1; i < leftHalf.length(); i++) {
            if (leftHalf.charAt(i) == leftSpecialSymbol && leftHalf.charAt(i-1) == leftSpecialSymbol) {
                currentCount++;
                if (currentCount>leftCounter) {
                    leftCounter = currentCount;
                }
            } else {
                currentCount = 1;
            }
        }


        char rightSpecialSymbol = 0;
        for (int i = 0; i < rightHalf.length(); i++) {
            if (winningSymbols.contains("" + rightHalf.charAt(i))) {
                rightSpecialSymbol = rightHalf.charAt(i);
                break;
            }
        }

        int rightCounter = 1;
        int currentRightCounter = 1;
        for (int i = 1; i < rightHalf.length(); i++) {
            if (rightHalf.charAt(i) == rightSpecialSymbol && rightHalf.charAt(i-1)==rightSpecialSymbol) {
                currentRightCounter++;
                if (currentRightCounter>rightCounter) {
                    rightCounter = currentRightCounter;
                }
            } else {
                currentRightCounter = 1;
            }
        }

        if (leftCounter >= 6 && rightCounter >= 6 && leftSpecialSymbol==rightSpecialSymbol) {
            result = leftCounter;
        }

        return result;
    }

    private static boolean checkIfJackpot(String ticket, String winningSymbols) {
        boolean jackpot = true;

        for (int i = 0; i < ticket.length(); i++) {
            if (!winningSymbols.contains("" + ticket.charAt(i))) {
                jackpot = false;
                break;
            }
            if (ticket.charAt(i) != ticket.charAt(0)) {
                jackpot = false;
                break;
            }
        }

        return jackpot;
    }
}
