package _08_Practice_Mid_Exam._05_FifthPracticeExam;

import java.util.*;
import java.util.stream.Collectors;

public class _03_Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        double averageValue = 0;
        for (int i = 0; i < numbersList.size(); i++) {
            averageValue += numbersList.get(i);
        }
        averageValue /= numbersList.size()*1.0;

        List<Integer> topNumbers = new ArrayList<>();
        for (int num : numbersList) {
            if (num > averageValue) {
                topNumbers.add(num);
            }
        }

        if (topNumbers.size()==0) {
            System.out.println("No");
        } else {
            Collections.sort(topNumbers);
            Collections.reverse(topNumbers);

            if (topNumbers.size()>5) {
                int elementsToRemove = topNumbers.size()-5;
                for (int i = 1; i <= elementsToRemove; i++) {
                    topNumbers.remove(5);
                }
            }

            System.out.println(topNumbers.toString().replaceAll("[\\[\\],]", ""));
        }


    }
}
