package _04_Methods.Lab;

import java.util.Scanner;

public class CalculateRectangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int widthOfTriangle = Integer.parseInt(scanner.nextLine());
        int lengthOfTriangle = Integer.parseInt(scanner.nextLine());

        int areaOfRectangle = getRectangleArea(widthOfTriangle, lengthOfTriangle);
        System.out.println(areaOfRectangle);
    }

    private static int getRectangleArea(int widthOfTriangle, int lengthOfTriangle) {
        return widthOfTriangle*lengthOfTriangle;
    }
}
