package _08_Practice_Mid_Exam._04_FourthPracticeExam;

import java.util.Scanner;

public class _02_ShootForTheWin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] arrayValuesInString = scanner.nextLine().split("\\s+");
        int[] targetsArray = new int[arrayValuesInString.length];
        for (int i = 0; i < targetsArray.length; i++) {
            targetsArray[i] = Integer.parseInt(arrayValuesInString[i]);
        }

        int countOfShotTargets = 0;
        String command = scanner.nextLine();
        while (!command.equals("End")) {
            int indexOfShotTarget = Integer.parseInt(command);

            if (indexOfShotTarget>=0 && indexOfShotTarget<targetsArray.length) {
                if (targetsArray[indexOfShotTarget] >= 0 ) {
                    int valueToCompare = targetsArray[indexOfShotTarget];
                    targetsArray[indexOfShotTarget] = -1;
                    countOfShotTargets++;

                    for (int i = 0; i < targetsArray.length; i++) {
                        if (targetsArray[i]>-1 && targetsArray[i]<=valueToCompare) {
                            targetsArray[i] += valueToCompare;
                        } else if (targetsArray[i]>valueToCompare) {
                            targetsArray[i] -= valueToCompare;
                        }
                    }
                }
            }
            command = scanner.nextLine();
        }

        System.out.printf("Shot targets: %d -> ", countOfShotTargets);
        for (int i = 0; i<targetsArray.length; i++) {
            if (i<targetsArray.length-1) {
                System.out.print(targetsArray[i] + " ");
            } else {
                System.out.print(targetsArray[i]);
            }
        }
    }
}
