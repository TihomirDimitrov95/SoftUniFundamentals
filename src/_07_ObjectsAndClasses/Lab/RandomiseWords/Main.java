package _07_ObjectsAndClasses.Lab.RandomiseWords;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> wordsList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        Random randomiser = new Random();
        for (int i = 0; i < wordsList.size(); i++) {
            int randomSwap = randomiser.nextInt(wordsList.size());

            String temp = wordsList.get(i);
            wordsList.set(i, wordsList.get(randomSwap));
            wordsList.set(randomSwap, temp);
        }

        String output = String.join(" ", wordsList);

        System.out.println(output);
    }
}
