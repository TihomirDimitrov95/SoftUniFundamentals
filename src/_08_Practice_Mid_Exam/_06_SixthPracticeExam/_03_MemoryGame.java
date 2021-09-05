package _08_Practice_Mid_Exam._06_SixthPracticeExam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _03_MemoryGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> sequenceOfElements = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        int countOfMoves = 0;

        String command = scanner.nextLine();
        while (!command.equals("end")) {
            int firstIndex = Integer.parseInt(command.split("\\s+")[0]);
            int secondIndex = Integer.parseInt(command.split("\\s+")[1]);
            countOfMoves++;
            if (isIndexInvalid(firstIndex, secondIndex, sequenceOfElements.size())) {
                int middleIndex = sequenceOfElements.size()/2;
                if (sequenceOfElements.size()%2==1) {
                    middleIndex--;
                }
                String newElement = "-" + countOfMoves + "a";
                sequenceOfElements.add(middleIndex, newElement);
                sequenceOfElements.add(middleIndex, newElement);
                System.out.println("Invalid input! Adding additional elements to the board");
            } else {
                if (!sequenceOfElements.get(firstIndex).equals(sequenceOfElements.get(secondIndex))) {
                    System.out.println("Try again!");
                } else {
                    System.out.printf("Congrats! You have found matching elements - %s!%n", sequenceOfElements.get(firstIndex));
                    if (firstIndex<secondIndex) {
                        sequenceOfElements.remove(firstIndex);
                        sequenceOfElements.remove(secondIndex-1);
                    } else {
                        sequenceOfElements.remove(secondIndex);
                        sequenceOfElements.remove(firstIndex-1);
                    }
                }
            }

            if (sequenceOfElements.size()==0) {
                System.out.printf("You have won in %d turns!", countOfMoves);
                break;
            }

            command = scanner.nextLine();
        }

        if (sequenceOfElements.size()>0) {
            System.out.printf("Sorry you lose :(%n");
            System.out.println(sequenceOfElements.toString().replaceAll("[\\[\\],]", ""));
        }
    }

    private static boolean isIndexInvalid(int firstIndex, int secondIndex, int size) {
        boolean check = false;
        if (firstIndex==secondIndex) {
            check = true;
        }
        if (firstIndex<0 || firstIndex>=size) {
            check = true;
        }
        if (secondIndex<0 || secondIndex>=size) {
            check = true;
        }
        return check;
    }
}
