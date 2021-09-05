package _05_Lists;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] array = scanner.nextLine().split(" ");
        List<Integer> numbers = new ArrayList<>();

        for (String number : array) {
            int current = Integer.parseInt(number);
            numbers.add(current);
        }
        String command = scanner.nextLine();

        while(!command.equals("end")) {
            String[] tokens = command.split(" ");
            String type = tokens[0];


            if (type.equals("Contains")) {
                int numero = Integer.parseInt(tokens[1]);
                if(numbers.contains(numero)) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No such number");
                }
            } else if (type.equals("Print")) {

                if(tokens[1].equals("even")) {
                    for(int i = 0; i < numbers.size(); i++) {
                        int currentNumber = numbers.get(i);
                        if(currentNumber % 2 == 0) {
                            System.out.print(currentNumber + " ");
                        }
                    }
                    System.out.println();
                } else if(tokens[1].equals("odd")) {
                    for(int i = 0; i < numbers.size(); i++) {
                        int current = numbers.get(i);
                        if(current % 2 == 1) {
                            System.out.print(current + " ");
                        }
                    }
                    System.out.println();
                }
            }
            else if(type.equals("Get")) {
                int sum = 0;
                if(tokens[1].equals("sum")) {
                    for(int i = 0; i < numbers.size(); i++) {
                        int current = numbers.get(i);
                        sum += current;
                    }
                    System.out.println(sum);
                }
            } else if(type.equals("Filter")) {
                int number = Integer.parseInt(tokens[2]);
                if (tokens[1].equals(">=")) {
                    for (int i = 0; i < numbers.size(); i++) {
                        int current = numbers.get(i);
                        if (current >= number) {
                            System.out.print(current + " ");
                        }
                    }
                    System.out.println();
                } else if (tokens[1].equals("<=")) {
                    for (int i = 0; i < numbers.size(); i++) {
                        int current = numbers.get(i);
                        if (current <= number) {
                            System.out.print(current + " ");
                        }
                    }
                    System.out.println();
                } else if (tokens[1].equals("<")) {
                    for (int i = 0; i < numbers.size(); i++) {
                        int current = numbers.get(i);
                        if (current < number) {
                            System.out.print(current + " ");
                        }
                    }
                    System.out.println();
                } else if (tokens[1].equals(">")) {
                    for (int i = 0; i < numbers.size(); i++) {
                        int current = numbers.get(i);
                        if (current > number) {
                            System.out.print(current + " ");
                        }
                    }
                    System.out.println();
                }
            }

            command = scanner.nextLine();
        }
    }
}