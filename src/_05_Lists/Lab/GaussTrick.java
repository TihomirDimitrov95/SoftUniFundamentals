package _05_Lists.Lab;

import java.util.List;
import java.util.*;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GaussTrick {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> inputList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        for (int i = 0; i < inputList.size()-1; i++) {
            int sum = inputList.get(i) + inputList.get(inputList.size()-1);
            inputList.set(i, sum);
            inputList.remove(inputList.size()-1);
        }

        System.out.println(inputList.toString().replaceAll("[\\[\\],]", ""));
    }
}
