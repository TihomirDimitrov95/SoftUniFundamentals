package _05_Lists.Lab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class RemoveNegativesAndReverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] array = scanner.nextLine().split(" ");

        List<Integer> listOfNumbers = new ArrayList<>();
        for (String s : array) {
            int currentNum = Integer.parseInt(s);
            listOfNumbers.add(currentNum);
        }

        for (int i = 0; i<listOfNumbers.size(); i++ ) {
            if (listOfNumbers.get(i) < 0) {
                listOfNumbers.remove(i);
                i--;
            }
        }

        Collections.reverse(listOfNumbers);

        if (listOfNumbers.size()==0) {
            System.out.println("empty");
        } else {
            System.out.println(listOfNumbers.toString().replaceAll("[\\[\\],]", ""));
        }


    }
}
