package _07_ObjectsAndClasses.Exercises._02_Articles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] tokens = scanner.nextLine().split(", ");
        String title = tokens[0];
        String content = tokens[1];
        String author = tokens[2];

        Article article = new Article(title, content, author);

        int iterations = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < iterations; i++) {
            String[] command = scanner.nextLine().split(": ");

            switch (command[0]) {
                case "Edit":
                    article.setContent(command[1]);
                    break;
                case "ChangeAuthor":
                    article.setAuthor(command[1]);
                    break;
                case "Rename":
                    article.setTitle(command[1]);
                    break;
            }
        }

        System.out.printf("%s - %s: %s", article.getTitle(), article.getContent(), article.getAuthor());

    }
}
