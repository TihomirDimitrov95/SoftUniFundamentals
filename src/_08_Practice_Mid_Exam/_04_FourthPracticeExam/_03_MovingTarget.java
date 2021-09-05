package _08_Practice_Mid_Exam._04_FourthPracticeExam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _03_MovingTarget {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> targetsList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());


        if (targetsList.size()>0) {
            String[] command = scanner.nextLine().split("\\s+");
            while (!command[0].equals("End")) {
                String actionRequired = command[0];
                int index = Integer.parseInt(command[1]);

                switch (actionRequired.toLowerCase()) {
                    case "shoot":
                        int power = Integer.parseInt(command[2]);
                        if (index>=0 && index<targetsList.size()) {
                            int shotValue = targetsList.get(index) - power;
                            if (shotValue<=0) {
                                targetsList.remove(index);
                            } else {
                                targetsList.set(index, shotValue);
                            }
                        }
                        break;
                    case "add":
                        int value = Integer.parseInt(command[2]);
                        if (index>=0 && index<targetsList.size()) {
                            targetsList.add(index, value);
                        } else {
                            System.out.println("Invalid placement!");
                        }
                        break;
                    case "strike":
                        int radius = Integer.parseInt(command[2]);
                        if (index>=0 && index<targetsList.size()) {
                            if (index - radius < 0 || index + radius >= targetsList.size()) {
                                System.out.println("Strike missed!");
                            } else {
                                int targetsToRemove = radius*2 + 1;
                                int indexToRemove = index-radius;
                                for (int i = 0; i < targetsToRemove; i++) {
                                    targetsList.remove(indexToRemove);
                                }
                            }
                        }
                        break;
                }
                command = scanner.nextLine().split("\\s+");
            }

            for (int i = 0; i < targetsList.size(); i++) {
                if (i<targetsList.size()-1) {
                    System.out.print(targetsList.get(i) + "|");
                } else {
                    System.out.print(targetsList.get(i));
                }
            }
        }


//        System.out.println(targetsList.toString().replaceAll("[\\[\\] ]", "").replaceAll(",", "|"));
    }
}
