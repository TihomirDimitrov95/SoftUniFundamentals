package _05_Lists.MoreExercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TakeSkipRope {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String encryptedMessage = scanner.nextLine();

        List<Character> nonNumbersList = new ArrayList<>();
        List<Integer> numbersList = new ArrayList<>();
        List<Integer> takeList = new ArrayList<>();
        List<Integer> skipList = new ArrayList<>();

        int count = 1;

        for (int i = 0; i < encryptedMessage.length(); i++) {

            if (Character.isDigit(encryptedMessage.charAt(i))) {
                int input = encryptedMessage.charAt(i) - '0';
                numbersList.add(input);

                if (count%2==1) {
                    takeList.add(input);
                    count++;
                } else {
                    skipList.add(input);
                    count = 1;
                }

            } else {
                nonNumbersList.add(encryptedMessage.charAt(i));
            }
        }

        String newMessage = "";
        for (char current :
                nonNumbersList) {
            newMessage+=current;
        }

        StringBuilder output = new StringBuilder();

        int index = 0;
        int counterForLists = 0;

        while (index<newMessage.length() && counterForLists<takeList.size()) {
            if (takeList.get(counterForLists)>0) {
                String toBeAdded = "";

                if (index+takeList.get(counterForLists)>=newMessage.length()) {
                    toBeAdded = newMessage.substring(index);

                } else {
                    toBeAdded = newMessage.substring(index, index + takeList.get(counterForLists));
                }
                output.append(toBeAdded);
                index += takeList.get(counterForLists);
            }

            index += skipList.get(counterForLists);

            counterForLists++;

        }

        System.out.println(output);

    }
}
