package _04_Methods.MoreExercises;

import java.util.Scanner;

public class CenterPoint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x1 = Integer.parseInt(scanner.nextLine());
        int y1 = Integer.parseInt(scanner.nextLine());
        int x2 = Integer.parseInt(scanner.nextLine());
        int y2 = Integer.parseInt(scanner.nextLine());

        String centrePoint = getCentreOfCoordinateSystem(x1, y1, x2, y2);
        System.out.println(centrePoint);
    }

    private static String getCentreOfCoordinateSystem(int x1, int y1, int x2, int y2) {
        StringBuilder output = new StringBuilder("(");
        double sideOne = Math.pow(x1,2) + Math.pow(y1,2);
        double distanceFirstPoint = Math.sqrt(sideOne);

        double sideTwo = Math.pow(x2, 2) + Math.pow(y2, 2);
        double distanceSecondPoint = Math.sqrt(sideTwo);

        if (distanceFirstPoint<=distanceSecondPoint) {
            output.append(x1).append(", ").append(y1).append(")");
        } else {
            output.append(x2).append(", ").append(y2).append(")");
        }

        return output.toString();
    }
}
