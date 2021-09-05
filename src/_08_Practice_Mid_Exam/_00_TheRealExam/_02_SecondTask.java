package _08_Practice_Mid_Exam._00_TheRealExam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _02_SecondTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> oldFavouriteGenresList = Arrays.stream(scanner.nextLine().split(" \\| ")).collect(Collectors.toList());


        String command = scanner.nextLine();
        while (!command.equals("Stop!")) {
            String typeOfCommand = command.split("\\s+")[0];
            String genre = command.split("\\s+")[1];

            switch (typeOfCommand) {
                case "Join":
                    if (!oldFavouriteGenresList.contains(genre)) {
                        oldFavouriteGenresList.add(genre);
                    }
                    break;
                case "Drop":
                    if (oldFavouriteGenresList.contains(genre)) {
                        oldFavouriteGenresList.remove(genre);
                    }
                    break;
                case "Replace":
                    String newGenre = command.split("\\s+")[2];
                    if (oldFavouriteGenresList.contains(genre) && !oldFavouriteGenresList.contains(newGenre)) {
                        int index = 0;
                        for (int i = 0; i < oldFavouriteGenresList.size(); i++) {
                            if (oldFavouriteGenresList.get(i).equals(genre)) {
                                index = i;
                                break;
                            }
                        }
                        oldFavouriteGenresList.set(index, newGenre);
                    }
                    break;
            }

            command = scanner.nextLine();
        }

        for (String genre :
                oldFavouriteGenresList) {
            System.out.print(genre + " ");
        }
    }
}
