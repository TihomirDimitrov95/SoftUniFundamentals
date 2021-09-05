package _05_Lists.Lab;

import java.text.DecimalFormat;
import java.util.*;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SumAdjacent {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Double> inputList = Arrays.stream(scanner.nextLine().split(" ")).map(Double::parseDouble).collect(Collectors.toList());

        for (int i = 0; i < inputList.size() - 2; i++) {
            if (inputList.get(i).equals(inputList.get(i+1))) {
                double sum = inputList.get(i)*2;
                inputList.set(i, sum);
                inputList.remove(i+1);
                if (i>0) {
                    i-=2;
                } else {
                    i--;
                }
            }
        }

        DecimalFormat decimal = new DecimalFormat("0.#");

        for (double num :
                inputList) {
            System.out.print(decimal.format(num) + " ");
        }

//        System.out.println(inputList.toString().replaceAll("[\\[\\],]", ""));

    }
}
