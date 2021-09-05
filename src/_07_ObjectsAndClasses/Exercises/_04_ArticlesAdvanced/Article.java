package _07_ObjectsAndClasses.Exercises._04_ArticlesAdvanced;

public class Article {
    private String title;
    private String content;
    private String author;

    public Article(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public String GetTitle() {
        return this.title;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }
}
