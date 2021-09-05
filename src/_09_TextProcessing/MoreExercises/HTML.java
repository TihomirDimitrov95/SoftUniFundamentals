package _09_TextProcessing.MoreExercises;

import java.util.Scanner;

public class HTML {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String titleOfArticle = scanner.nextLine();
        String contentOfArticle = scanner.nextLine();

        System.out.printf("<h1>%n\t%s%n</h1>%n", titleOfArticle);
        System.out.printf("<article>%n\t%s%n</article>%n", contentOfArticle);

        String comments = scanner.nextLine();
        while (!comments.equals("end of comments")) {
            System.out.printf("<div>%n\t%s%n</div>%n", comments);
            comments = scanner.nextLine();
        }
    }
}
