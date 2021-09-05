import java.util.Scanner;

public class ArrayManipulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int[] numsArray = new int[input.length];
        for (int i = 0; i < numsArray.length; i++) {
            numsArray[i] = Integer.parseInt(input[i]);
        }

        String command = scanner.nextLine();
        while (!command.equals("end")) {
            int indexOfSpace = command.indexOf(" ");
            String firstWordOfCommand = command.substring(0, indexOfSpace);
            String secondWordOfCommand = command.substring(indexOfSpace+1);

            switch (firstWordOfCommand) {
                case "exchange":
                    int exchangeIndex = Integer.parseInt(secondWordOfCommand);
                    if (exchangeIndex>numsArray.length || exchangeIndex<0) {
                        System.out.println("Invalid index");
                        break;
                    }
                    exchangeCommand(numsArray, exchangeIndex);
                    break;
                case "max":
                    if (secondWordOfCommand.equals("even")) {
                        int indexOfMaxEven = maxEven(numsArray);
                        if (indexOfMaxEven == -1){
                            System.out.println("No matches");
                        } else {
                            System.out.println(indexOfMaxEven);
                        }
                    } else {
                        int indexOfMaxOdd = maxOdd(numsArray);
                        if (indexOfMaxOdd == -1){
                            System.out.println("No matches");
                        } else {
                            System.out.println(indexOfMaxOdd);
                        }
                    }
                    break;
                case "min":
                    if (secondWordOfCommand.equals("even")) {
                        int indexOfMinEven = minEven(numsArray);
                        if (indexOfMinEven == -1){
                            System.out.println("No matches");
                        } else {
                            System.out.println(indexOfMinEven);
                        }
                    } else {
                        int indexOfMinOdd = minOdd(numsArray);
                        if (indexOfMinOdd == -1){
                            System.out.println("No matches");
                        } else {
                            System.out.println(indexOfMinOdd);
                        }
                    }
                    break;
                case "first":
                    int indexOfSecondSpace = secondWordOfCommand.indexOf(" ");
                    int countRequired = Integer.parseInt(secondWordOfCommand.substring(0, indexOfSecondSpace));
                    String thirdWordOfCommand = secondWordOfCommand.substring(indexOfSecondSpace+1);

                    if (countRequired>numsArray.length) {
                        System.out.println("Invalid count");
                        break;
                    }
                    String output = firstManipulation(thirdWordOfCommand, numsArray, countRequired);
                    System.out.println(output);
                    break;
                case "last":
                    int indexOfSecondSpaces = secondWordOfCommand.indexOf(" ");
                    int countRequiredLast = Integer.parseInt(secondWordOfCommand.substring(0, indexOfSecondSpaces));
                    String thirdWordOfCommandLast = secondWordOfCommand.substring(indexOfSecondSpaces+1);

                    if (countRequiredLast>numsArray.length) {
                        System.out.println("Invalid count");
                        break;
                    }
                    String outputForLast = lastManipulation(thirdWordOfCommandLast, numsArray, countRequiredLast);
                    System.out.println(outputForLast);
                    break;

            }
            command = scanner.nextLine();

        }

        StringBuilder output = new StringBuilder();
        output.append("[");
        for (int i = 0; i < numsArray.length; i++) {
            if (i<numsArray.length-1) {
                output.append(numsArray[i]).append(", ");
            } else {
                output.append(numsArray[i]).append("]");
            }
        }

        System.out.println(output);
    }


    public static int[] exchangeCommand (int[] numbers, int index) {
        int[] firstArray = new int[index+1];
        for (int i = 0; i < firstArray.length; i++) {
            firstArray[i] = numbers[i];
        }

        int[] secondArray = new int[numbers.length-1-index];
        for (int i = 0; i < secondArray.length; i++) {
            secondArray[i] = numbers[index+1+i];
        }

        int[] exchangedArray = new int[numbers.length];
        int count = secondArray.length;
        for (int i = 0; i < secondArray.length; i++) {
            exchangedArray[i] = secondArray[i];
        }

        for (int i = 0; i < firstArray.length; i++) {
            exchangedArray[secondArray.length+i] = firstArray[i];
        }

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = exchangedArray[i];
        }
        return numbers;
    }

    public static int maxEven (int[] numbers) {
        int maxIndex = Integer.MIN_VALUE;
        int maxInteger = Integer.MIN_VALUE;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i]%2==0) {
                if (numbers[i]>maxInteger) {
                    maxInteger = numbers[i];
                    maxIndex = i;
                }
            }
        }
        if (maxIndex==Integer.MIN_VALUE) {
            return -1;
        } else {
            return maxIndex;
        }
    }

    public static int minEven (int[] numbers) {
        int minIndex = Integer.MAX_VALUE;
        int minInteger = Integer.MAX_VALUE;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i]%2==0) {
                if (numbers[i]<minInteger) {
                    minInteger = numbers[i];
                    minIndex = i;
                }
            }
        }
        if (minIndex==Integer.MAX_VALUE) {
            return -1;
        } else {
            return minIndex;
        }
    }


    public static int maxOdd (int[] numbers) {
        int maxIndex = Integer.MIN_VALUE;
        int maxInteger = Integer.MIN_VALUE;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i]%2==1) {
                if (numbers[i]>maxInteger) {
                    maxInteger = numbers[i];
                    maxIndex = i;
                }
            }
        }
        if (maxIndex==Integer.MIN_VALUE) {
            return -1;
        } else {
            return maxIndex;
        }
    }

    public static int minOdd (int[] numbers) {
        int minIndex = Integer.MAX_VALUE;
        int minInteger = Integer.MAX_VALUE;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i]%2==1) {
                if (numbers[i]<minInteger) {
                    minInteger = numbers[i];
                    minIndex = i;
                }
            }
        }
        if (minIndex==Integer.MAX_VALUE) {
            return -1;
        } else {
            return minIndex;
        }
    }

    public static String firstManipulation (String command, int[] numbers, int count) {
        String output = "[";
        int counter = 0;

        if (command.equals("even")) {
            for (int num : numbers) {
                if (num%2==0) {
                    counter++;
                    output = output + num + ", ";
                    if (counter==count) {
                        break;
                    }
                }
            }
        } else {
            for (int num : numbers) {
                if (num%2==1) {
                    counter++;
                    output = output + num + ", ";
                    if (counter==count) {
                        break;
                    }
                }
            }
        }

        if (output.length()>1) {
            output = output.substring(0, output.length()-2);
        }
        output += "]";

        return output;
    }

    public static String lastManipulation (String command, int[] numbers, int countRequired) {
        String output = "[";

        if (command.equals("even")) {
            int counterOfEven = 0;
            for (int num : numbers) {
                if (num%2==0) {
                    counterOfEven++;
                }
            }
            int incramentCounterforEvenIntegers = 0;
            int[] arrayOfEven = new int[counterOfEven];
            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i]%2==0) {
                    arrayOfEven[incramentCounterforEvenIntegers] = numbers[i];
                    incramentCounterforEvenIntegers++;
                }
            }
            if (counterOfEven>countRequired) {
                for (int i = counterOfEven-countRequired; i < counterOfEven; i++) {
                    output += arrayOfEven[i] + ", ";
                }
            } else {
                for (int i = 0; i < counterOfEven; i++) {
                    output += arrayOfEven[i] + ", ";
                }
            }
        } else {
            int counterOfOdd = 0;
            for (int num : numbers) {
                if (num%2==1) {
                    counterOfOdd++;
                }
            }
            int incramentCounterForOddIntegers = 0;
            int[] arrayOfOdd = new int[counterOfOdd];
            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i]%2==1) {
                    arrayOfOdd[incramentCounterForOddIntegers] = numbers[i];
                    incramentCounterForOddIntegers++;
                }
            }
            if (counterOfOdd>countRequired) {
                for (int i = counterOfOdd-countRequired; i < counterOfOdd; i++) {
                    output += arrayOfOdd[i] + ", ";
                }
            } else if (counterOfOdd==countRequired){
                for (int i = 0; i < counterOfOdd; i++) {
                    output += arrayOfOdd[i] + ", ";
                }
            } else {
                for (int i = 0; i < counterOfOdd; i++) {
                    output+= arrayOfOdd[i] + ", ";
                }
            }
        }

        if (output.length()>1) {
            output = output.substring(0, output.length()-2);
        }
        output += "]";

        return output;
    }
}