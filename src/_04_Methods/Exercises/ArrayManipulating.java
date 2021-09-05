package _04_Methods.Exercises;

import java.util.Scanner;

public class ArrayManipulating {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int[] array = new int[input.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(input[i]);
        }

        String[] manipulationCommand = scanner.nextLine().split(" ");
        while (!manipulationCommand[0].equals("end")) {
            switch (manipulationCommand[0]) {
                case "exchange":
                    array = executeExchange(manipulationCommand[1], array);
                    break;
                case "max":
                    executeMax(manipulationCommand[1], array);
                    break;
                case "min":
                    executeMin(manipulationCommand[1], array);
                    break;
                case "first":
                    executeFirst(manipulationCommand[1], manipulationCommand[2], array);
                    break;
                case "last":
                    executeLast(manipulationCommand[1], manipulationCommand[2], array);
                    break;
            }
            manipulationCommand = scanner.nextLine().split(" ");
        }

        StringBuilder output = new StringBuilder("[");
        for (int i = 0; i < array.length; i++) {
            if (i<array.length-1) {
                output.append(array[i]).append(", ");
            } else {
                output.append(array[i]).append("]");
            }
        }
        System.out.println(output);
    }

    private static int[] executeExchange(String indexRequired, int[] array) {
        int index = Integer.parseInt(indexRequired);
        int[] manipulatedArray = new int[array.length];

        if (index>=array.length) {
            System.out.println("Invalid index");
            return array;
        } else if (index==array.length-1) {
            return array;
        } else if (index==0) {
            for (int i = 0; i < array.length-1; i++) {
                manipulatedArray[i] = array[i+1];
            }
            manipulatedArray[array.length-1] = array[0];
        } else {
            int count = 0;

            for (int i = index+1; i < array.length ; i++) {
                manipulatedArray[count] = array[i];
                count++;
            }

            for (int i = 0; i <= index; i++) {
                manipulatedArray[count] = array[i];
                count++;
            }
        }
        return manipulatedArray;
    }

    private static void executeMax(String typeOfDigit, int[] array) {
        switch (typeOfDigit) {
            case "even":
                printMaxEven(array);
                break;
            case "odd":
                printMaxOdd(array);
                break;
        }
    }

    private static void printMaxOdd(int[] array) {
        int max = Integer.MIN_VALUE;
        int indexOfMax = -1;

        for (int i = 0; i < array.length; i++) {
            if (array[i]%2==1 && array[i]>max) {
                max = array[i];
                indexOfMax = i;
            } else if (array[i]%2==1 && array[i]==max) {
                indexOfMax = i;
            }
        }
        if (max==Integer.MIN_VALUE) {
            System.out.println("No matches");
        } else {
            System.out.println(indexOfMax);
        }
    }

    private static void printMaxEven(int[] array) {
        int max = Integer.MIN_VALUE;
        int indexOfMax = -1;

        for (int i = 0; i < array.length; i++) {
            if (array[i]%2==0 && array[i]>max) {
                max = array[i];
                indexOfMax = i;
            } else if (array[i]%2==0 && array[i]==max) {
                indexOfMax = i;
            }
        }
        if (max==Integer.MIN_VALUE) {
            System.out.println("No matches");
        } else {
            System.out.println(indexOfMax);
        }
    }

    private static void executeMin(String typeOfDigit, int[] array) {
        switch (typeOfDigit) {
            case "even":
                printMinEven(array);
                break;
            case "odd":
                printMinOdd(array);
                break;
        }
    }

    private static void printMinOdd(int[] array) {
        int min = Integer.MAX_VALUE;
        int indexOfMin = -1;

        for (int i = 0; i < array.length; i++) {
            if (array[i]%2==1 && array[i]<min) {
                min = array[i];
                indexOfMin = i;
            } else if (array[i]%2==1 && array[i]==min) {
                indexOfMin = i;
            }
        }
        if (min==Integer.MAX_VALUE) {
            System.out.println("No matches");
        } else {
            System.out.println(indexOfMin);
        }
    }

    private static void printMinEven(int[] array) {
        int min = Integer.MAX_VALUE;
        int indexOfMin = -1;

        for (int i = 0; i < array.length; i++) {
            if (array[i]%2==0 && array[i]<min) {
                min = array[i];
                indexOfMin = i;
            } else if (array[i]%2==0 && array[i]==min) {
                indexOfMin = i;
            }
        }
        if (min==Integer.MAX_VALUE) {
            System.out.println("No matches");
        } else {
            System.out.println(indexOfMin);
        }
    }

    private static void executeFirst(String countRequired, String typeOfDigit, int[] array) {
        int count = Integer.parseInt(countRequired);
        if (count>array.length) {
            System.out.println("Invalid count");
        } else {
            switch (typeOfDigit) {
                case "even":
                    printFirstEvenDigits(count, array);
                    break;
                case "odd":
                    printFirstOddDigits(count, array);
                    break;
            }
        }
    }

    private static void printFirstOddDigits(int countRequired, int[] array) {
        StringBuilder output = new StringBuilder("[");

        int counterOfOdd =0;
        StringBuilder allOddDigits = new StringBuilder();
        for (int num : array) {
            if (num%2==1) {
                counterOfOdd++;
                allOddDigits.append(num).append(" ");
            }
        }

        if (allOddDigits.length()==0) {
            output.append("]");
        } else {
            String[] oddDigits = allOddDigits.toString().split(" ");

            if (counterOfOdd>countRequired) {
                for (int i = 0; i < countRequired; i++) {
                    if (i<countRequired-1) {
                        output.append(oddDigits[i]).append(", ");
                    } else {
                        output.append(oddDigits[i]).append("]");
                    }
                }
            } else {
                for (int i = 0; i < counterOfOdd; i++) {
                    if (i<counterOfOdd-1) {
                        output.append(oddDigits[i]).append(", ");
                    } else {
                        output.append(oddDigits[i]).append("]");
                    }
                }
            }
        }

        System.out.println(output);
    }

    private static void printFirstEvenDigits(int countRequired, int[] array) {
        StringBuilder output = new StringBuilder("[");

        int counterOfEven =0;
        StringBuilder allEvenDigits = new StringBuilder();
        for (int num : array) {
            if (num%2==0) {
                counterOfEven++;
                allEvenDigits.append(num).append(" ");
            }
        }

        if (allEvenDigits.length()==0) {
            output.append("]");
        } else {
            String[] evenDigits = allEvenDigits.toString().split(" ");

            if (counterOfEven>countRequired) {
                for (int i = 0; i < countRequired; i++) {
                    if (i<countRequired-1) {
                        output.append(evenDigits[i]).append(", ");
                    } else {
                        output.append(evenDigits[i]).append("]");
                    }
                }
            } else {
                for (int i = 0; i < counterOfEven; i++) {
                    if (i<counterOfEven-1) {
                        output.append(evenDigits[i]).append(", ");
                    } else {
                        output.append(evenDigits[i]).append("]");
                    }
                }
            }
        }

        System.out.println(output);
    }

    private static void executeLast(String countRequired, String typeOfDigit, int[] array) {
        int count = Integer.parseInt(countRequired);
        if (count>array.length) {
            System.out.println("Invalid count");
        } else {
            switch (typeOfDigit) {
                case "even":
                    printLastEvenDigits(count, array);
                    break;
                case "odd":
                    printLastOddDigits(count, array);
                    break;
            }
        }
    }

    private static void printLastOddDigits(int count, int[] array) {
        StringBuilder output = new StringBuilder("[");

        StringBuilder allOddDigits = new StringBuilder();
        for (int num : array) {
            if (num % 2 == 1) {
                allOddDigits.append(num).append(" ");
            }
        }
        if (allOddDigits.length()==0) {
            output.append("]");
        } else {
            String[] oddDigits = allOddDigits.toString().split(" ");
            if (oddDigits.length<=count) {
                for (int i = 0; i < oddDigits.length; i++) {
                    if (i==oddDigits.length-1) {
                        output.append(oddDigits[i]).append("]");
                    } else {
                        output.append(oddDigits[i]).append(", ");
                    }
                }
            } else {
                for (int i = oddDigits.length-count; i < oddDigits.length; i++) {
                    if (i==oddDigits.length-1) {
                        output.append(oddDigits[i]).append("]");
                    } else {
                        output.append(oddDigits[i]).append(", ");
                    }
                }
            }
        }
        System.out.println(output);
    }

    private static void printLastEvenDigits(int count, int[] array) {
        StringBuilder output = new StringBuilder("[");

        StringBuilder allEvenDigits = new StringBuilder();
        for (int num : array) {
            if (num % 2 == 0) {
                allEvenDigits.append(num).append(" ");
            }
        }
        if (allEvenDigits.length()==0) {
            output.append("]");
        } else {
            String[] evenDigits = allEvenDigits.toString().split(" ");
            if (evenDigits.length<=count) {
                for (int i = 0; i < evenDigits.length; i++) {
                    if (i==evenDigits.length-1) {
                        output.append(evenDigits[i]).append("]");
                    } else {
                        output.append(evenDigits[i]).append(", ");
                    }
                }
            } else {
                for (int i = evenDigits.length-count; i < evenDigits.length; i++) {
                    if (i==evenDigits.length-1) {
                        output.append(evenDigits[i]).append("]");
                    } else {
                        output.append(evenDigits[i]).append(", ");
                    }
                }
            }
        }
        System.out.println(output);
    }
}
