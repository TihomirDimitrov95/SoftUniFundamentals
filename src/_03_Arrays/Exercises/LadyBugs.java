package _03_Arrays.Exercises;

import java.util.Scanner;

public class LadyBugs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sizeOfField = Integer.parseInt(scanner.nextLine());
        int[] fieldOfBugsArray = new int[sizeOfField];

        String[] initialLadyBugs = scanner.nextLine().split(" ");
        int[] initialBugs = new int[initialLadyBugs.length];
        for (int i = 0; i < initialLadyBugs.length; i++) {
            initialBugs[i] = Integer.parseInt(initialLadyBugs[i]);
        }

        for (int i = 0; i < initialBugs.length; i++) {
            if (initialBugs[i] <= fieldOfBugsArray.length - 1 && initialBugs[i]>=0) {
                fieldOfBugsArray[initialBugs[i]] = 1;
            }
        }

        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String[] command = input.split(" ");
            int ladybugIndex = Integer.parseInt(command[0]);
            String direction = command[1];
            int flyLenght = Integer.parseInt(command[2]);

            if (direction.equals("right") && flyLenght > 0 || direction.equals("left") && flyLenght < 0) {
                if (ladybugIndex >= fieldOfBugsArray.length || ladybugIndex < 0) {
                    input = scanner.nextLine();
                    continue;
                } else {
                    if (fieldOfBugsArray[ladybugIndex] == 0) {
                        input = scanner.nextLine();
                        continue;
                    } else {
                        if (ladybugIndex + flyLenght >= fieldOfBugsArray.length) {
                            fieldOfBugsArray[ladybugIndex] = 0;
                        } else {
                            boolean isIndexAvailable = false;
                            int currentLadybugIndex = ladybugIndex;
                            while (isIndexAvailable == false) {
                                if (currentLadybugIndex + flyLenght < fieldOfBugsArray.length) {
                                    if (fieldOfBugsArray[currentLadybugIndex + flyLenght] == 0) {
                                        currentLadybugIndex+=flyLenght;
                                        isIndexAvailable = true;
                                    } else {
                                        currentLadybugIndex += flyLenght;
                                    }
                                } else {
                                    fieldOfBugsArray[currentLadybugIndex] = 0;
                                    break;
                                }
                            }
                            if (isIndexAvailable) {
                                fieldOfBugsArray[ladybugIndex] = 0;
                                fieldOfBugsArray[currentLadybugIndex] = 1;
                            }
                        }
                    }
                }
            } else if (direction.equals("left") && flyLenght > 0 || direction.equals("right") && flyLenght < 0) {
                if (ladybugIndex >= fieldOfBugsArray.length || ladybugIndex < 0) {
                    input = scanner.nextLine();
                    continue;
                } else {
                    if (fieldOfBugsArray[ladybugIndex] == 0) {
                        input = scanner.nextLine();
                        continue;
                    } else {
                        if (ladybugIndex - flyLenght < 0) {
                            fieldOfBugsArray[ladybugIndex] = 0;
                        } else {
                            boolean isIndexAvailable = false;
                            int currentLadybugIndex = ladybugIndex;
                            while (isIndexAvailable = false) {
                                if (currentLadybugIndex - flyLenght >= 0) {
                                    if (fieldOfBugsArray[currentLadybugIndex - flyLenght] == 0) {
                                        isIndexAvailable = true;
                                    } else {
                                        currentLadybugIndex -= flyLenght;
                                    }
                                } else {
                                    fieldOfBugsArray[currentLadybugIndex] = 0;
                                    break;
                                }
                            }
                            if (isIndexAvailable) {
                                fieldOfBugsArray[ladybugIndex] = 0;
                                fieldOfBugsArray[currentLadybugIndex] = 1;
                            }
                        }
                    }
                }
                input = scanner.nextLine();
            }
        }

         StringBuilder output = new StringBuilder();
         for (int ladyBugs : fieldOfBugsArray) {
                output.append(ladyBugs).append(" ");
            }

         System.out.println(output.toString().substring(0, output.length() - 1));
    }
}
