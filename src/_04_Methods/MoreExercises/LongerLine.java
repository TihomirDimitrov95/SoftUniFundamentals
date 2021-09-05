package _04_Methods.MoreExercises;

import java.util.Scanner;

public class LongerLine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstXOne = Integer.parseInt(scanner.nextLine());
        int firstYOne = Integer.parseInt(scanner.nextLine());
        int firstXTwo = Integer.parseInt(scanner.nextLine());
        int firstYTwo = Integer.parseInt(scanner.nextLine());

        int secondXOne = Integer.parseInt(scanner.nextLine());
        int secondYOne = Integer.parseInt(scanner.nextLine());
        int secondXTwo = Integer.parseInt(scanner.nextLine());
        int secondYTwo = Integer.parseInt(scanner.nextLine());

        String longerLine = getLongerLine(firstXOne, firstYOne, firstXTwo, firstYTwo, secondXOne, secondYOne, secondXTwo, secondYTwo);
        System.out.println(longerLine);

    }

    private static String getLongerLine(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        StringBuilder output = new StringBuilder("(");

        double firstLine = Math.sqrt(Math.pow(x1,2) +Math.pow(y1,2)) + Math.sqrt(Math.pow(x2,2)+Math.pow(y2,2));
        double secondLine = Math.sqrt(Math.pow(x3,2) + Math.pow(y3,2)) + Math.sqrt(Math.pow(x4,2)+Math.pow(y4,2));

        if (firstLine>=secondLine) {
            if (Math.sqrt(Math.pow(x1,2)+Math.pow(y1,2))<Math.sqrt(Math.pow(x2,2)+Math.pow(y2,2))) {
                output.append(x1).append(", ").append(y1).append(")(").append(x2).append(", ").append(y2).append(")");
            } else {
                output.append(x2).append(", ").append(y2).append(")(").append(x1).append(", ").append(y1).append(")");
            }
        } else {
            if (Math.sqrt(Math.pow(x3,2)+Math.pow(y3,2))<Math.sqrt(Math.pow(x4,2)+Math.pow(y4,2))) {
                output.append(x3).append(", ").append(y3).append(")(").append(x4).append(", ").append(y4).append(")");
            } else {
                output.append(x4).append(", ").append(y4).append(")(").append(x3).append(", ").append(y3).append(")");
            }
        }

        return output.toString();
    }
}
