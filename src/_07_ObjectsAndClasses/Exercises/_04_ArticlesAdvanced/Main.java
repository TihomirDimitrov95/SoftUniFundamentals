package _07_ObjectsAndClasses.Exercises._04_ArticlesAdvanced;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfArticles = Integer.parseInt(scanner.nextLine());

        List<Article> articleList = new ArrayList<>();
        for (int i = 0; i < numberOfArticles; i++) {
            String[] tokens = scanner.nextLine().split(", ");
            String title = tokens[0];
            String content = tokens[1];
            String author = tokens[2];

            Article article = new Article(title, content, author);
            articleList.add(article);
        }

        String typeOfInput = scanner.nextLine();
        switch (typeOfInput) {
            case "title":
//                people.sort(Comparator.comparing(p -> p.getName()))
                articleList.sort(Comparator.comparing(Article::GetTitle));
                break;
            case "content":
                articleList.sort(Comparator.comparing(Article::getContent));
                break;
            case "author":
                articleList.sort(Comparator.comparing(Article::getAuthor));
                break;
        }

        for (Article article :
                articleList) {
            String output = String.format("%s - %s: %s", article.GetTitle(), article.getContent(), article.getAuthor());
            System.out.println(output);
        }


    }
}
