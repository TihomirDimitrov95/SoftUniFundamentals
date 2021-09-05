package _08_Practice_Mid_Exam._00_TheRealExam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _03_ThirdTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> allCards = Arrays.stream(scanner.nextLine().split(":")).collect(Collectors.toList());

        List<String> deck = new ArrayList<>();

        String[] command = scanner.nextLine().split("\\s+");
        while (!command[0].equals("Ready")) {
            String activity = command[0];
            String cardName = command[1];

            switch (activity) {
                case "Add":
                    if (!allCards.contains(cardName)) {
                        System.out.println("Card not found.");
                    } else {
                        deck.add(cardName);
                    }
                    break;
                case "Insert":
                    int index = Integer.parseInt(command[2]);
                    boolean isInvalidIndex = false;
                    if (index<0 || index >= deck.size()) {
                        isInvalidIndex = true;
                    }
                    if (!allCards.contains(cardName) || isInvalidIndex) {
                        System.out.println("Error!");
                    } else {
                        deck.add(index, cardName);
                    }
                    break;
                case "Remove":
                    if (!deck.contains(cardName)) {
                        System.out.println("Card not found.");
                    } else {
                        deck.remove(cardName);
                    }
                    break;
                case "Swap":
                    String secondCard = command[2];
                    int indexOfFirst = -1;
                    int indexOfSecond = -1;
                    for (int i = 0; i < deck.size(); i++) {
                        if (deck.get(i).equals(cardName)) {
                            indexOfFirst = i;
                        }
                        if (deck.get(i).equals(secondCard)) {
                            indexOfSecond = i;
                        }
                        if (indexOfFirst >= 0 && indexOfSecond >= 0) {
                            break;
                        }
                    }
                    deck.set(indexOfFirst, secondCard);
                    deck.set(indexOfSecond, cardName);
                    break;
                case "Shuffle":
                    for (int i = 0; i < deck.size() / 2; i++) {
                        String temp = deck.get(i);
                        deck.set(i, deck.get(deck.size()-1-i));
                        deck.set(deck.size()-1-i, temp);
                    }
                    break;
            }
            command = scanner.nextLine().split("\\s+");
        }
        System.out.println(deck.toString().replaceAll("[\\[\\],]", ""));
    }
}
