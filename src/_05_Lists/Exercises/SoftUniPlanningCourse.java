package _05_Lists.Exercises;

import java.util.List;
import java.util.Scanner;
import java.util.*;
import java.util.stream.Collectors;

public class SoftUniPlanningCourse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> scheduledLessonsList = Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());

        String[] command = scanner.nextLine().split(":");
        while (!command[0].equals("course start")) {

            switch(command[0]) {
                case "Add":
                    if (!scheduledLessonsList.contains(command[1])) {
                        scheduledLessonsList.add(command[1]);
                    }
                    break;
                case "Insert":
                    int index = Integer.parseInt(command[2]);
                    if (!scheduledLessonsList.contains(command[1])) {
                        scheduledLessonsList.add(index, command[1]);
                    }
                    break;
                case "Remove":
                    String exercise = command[1] + "-Exercise";
                    if (scheduledLessonsList.contains(command[1])) {
                        scheduledLessonsList.remove(command[1]);
                    } else if (scheduledLessonsList.contains(exercise)) {
                        scheduledLessonsList.remove(exercise);
                    }
                    break;
                case "Swap":
                    if (scheduledLessonsList.contains(command[1]) && scheduledLessonsList.contains(command[2])) {
                        executeSwap(command[1], command[2], scheduledLessonsList);
                    }
                    break;
                case "Exercise":
                    String exercise1 = command[1] + "-Exercise";
                    if (scheduledLessonsList.contains(command[1])) {
                        if (!scheduledLessonsList.contains(exercise1)) {
                            for (int i = 0; i < scheduledLessonsList.size(); i++) {
                                if (scheduledLessonsList.get(i).equals(command[1])) {
                                    scheduledLessonsList.add(i+1, exercise1);
                                }
                            }
                        }
                    } else if (!scheduledLessonsList.contains(command[1]) && !scheduledLessonsList.contains(exercise1)){
                        scheduledLessonsList.add(command[1]);
                        scheduledLessonsList.add(exercise1);
                    }
                    break;
            }

            command = scanner.nextLine().split(":");
        }

        for (int i = 0; i < scheduledLessonsList.size(); i++) {
            System.out.printf("%d.%s%n",i+1, scheduledLessonsList.get(i));
        }



    }

    private static void executeSwap(String firstCourse, String secondCourse, List<String> scheduledLessonsList) {
        int indexOfFirstElement = -1;
        boolean firstExercise = false;
        String checkFirstExercise = firstCourse + "-Exercise";

        int indexOfSecondElement = -1;
        boolean secondExercise = false;
        String checkSecondExercise = secondCourse + "-Exercise";

        for (int i = 0; i < scheduledLessonsList.size(); i++) {
            if (scheduledLessonsList.get(i).equals(firstCourse)) {
                indexOfFirstElement = i;
                if (i<scheduledLessonsList.size()-1) {
                    if (scheduledLessonsList.get(i+1).equals(checkFirstExercise)) {
                        firstExercise = true;
                    }
                }
            } else if (scheduledLessonsList.get(i).equals(secondCourse)) {
                indexOfSecondElement = i;
                if (i<scheduledLessonsList.size()-1) {
                    if (scheduledLessonsList.get(i+1).equals(checkSecondExercise)) {
                        secondExercise = true;
                    }
                }
            }
        }

        scheduledLessonsList.set(indexOfFirstElement, secondCourse);
        if (secondExercise && !firstExercise) {
            scheduledLessonsList.add(indexOfFirstElement+1, checkSecondExercise);
        } else if (secondExercise && firstExercise) {
            scheduledLessonsList.set(indexOfFirstElement+1, checkSecondExercise);
        }

        if (secondExercise && !firstExercise) {
            scheduledLessonsList.set(indexOfSecondElement+1, firstCourse);
            scheduledLessonsList.remove(indexOfSecondElement+2);

        } else if (!secondExercise && !firstExercise) {
            scheduledLessonsList.set(indexOfSecondElement, firstCourse);

        } else if (secondExercise && firstExercise) {
            scheduledLessonsList.set(indexOfSecondElement, firstCourse);
            scheduledLessonsList.set(indexOfSecondElement+1, checkFirstExercise);
        }


    }
}
