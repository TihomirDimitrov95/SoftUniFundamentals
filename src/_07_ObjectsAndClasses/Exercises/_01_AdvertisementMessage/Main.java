package _07_ObjectsAndClasses.Exercises._01_AdvertisementMessage;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] phrases = new String[] {"Excellent product.", "Such a great product.", "I always use that product.", "Best product of its category.", "Exceptional product.", "I can't live without this product."};
        String[] events = new String[] {"Now I feel good.", "I have succeeded with this product.", "Makes miracles. I am happy of the result!", "I cannot believe but now I feel awesome.", "Try it yourself, I am very satisfied.", "I feel great!"};
        String[] authors = new String[] {"Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"};
        String[] cities = new String[] {"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"};

        int numberOfMessages = Integer.parseInt(scanner.nextLine());

        Random randomiser = new Random();
        for (int i = 0; i < numberOfMessages; i++) {
            int randomPhrase = randomiser.nextInt(phrases.length);
            int randomEvent = randomiser.nextInt(events.length);
            int randomAuthor = randomiser.nextInt(authors.length);
            int randomCity = randomiser.nextInt(cities.length);

            System.out.printf("%s %s %s - %s.%n", phrases[randomPhrase], events[randomEvent], authors[randomAuthor], cities[randomCity]);
        }
    }
}
