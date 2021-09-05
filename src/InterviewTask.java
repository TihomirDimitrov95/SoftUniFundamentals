import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InterviewTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = new String[] {"University", "Java", "JavaScript", "PHP", "HTML", "CSS", "Spring", "Vue", "Angular", "CSS", "CSS"};

        String[] input = scanner.nextLine().split(", ");
        while (input.length<2 || input.length>3) {
            System.out.println("Incorrect input. Try again.");
            input = scanner.nextLine().split(", ");
        }
        int wordsPerPage = Integer.parseInt(input[0]);
        int desiredPage = Integer.parseInt(input[1]);
        String keyWord = "";
        if (input.length==3) {
            keyWord = input[2];
        }

        int startingIndex = wordsPerPage * (desiredPage-1);
        if (keyWord.length()>0) {
            int totalItems = 0;
            List<Integer> totalPages = new ArrayList<>();
            for (int i = startingIndex; i < words.length; i++) {
                if (words[i].equals(keyWord)) {
                    totalItems++;
                    int currentPage = (int) Math.ceil(i*1.0/wordsPerPage);
                    if (!totalPages.contains(currentPage)) {
                        totalPages.add(currentPage);
                    }
                }
            }

            if (totalItems>0) {
                System.out.printf("Items: %s ; Total Items: %d ; Total Pages : %d%n", keyWord, totalItems, totalPages.size());
            } else {
                System.out.println("No result");
            }
        } else {
            StringBuilder items = new StringBuilder();
            for (int i = startingIndex; i < startingIndex+wordsPerPage; i++) {
                items.append(words[i]).append(", ");
            }

            int totalItems = words.length;
            int totalPages = (int) Math.ceil(totalItems*1.0/wordsPerPage);

            System.out.printf("Items: %s ; Total Items: %d ; Total Pages: %d%n", items.substring(0, items.length()-2), totalItems, totalPages);
        }
    }
}
