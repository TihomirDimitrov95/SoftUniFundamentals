package _07_ObjectsAndClasses.Lab.Songs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfSongs = Integer.parseInt(scanner.nextLine());

        List<Song> songList = new ArrayList<>();
        for (int i = 0; i < numberOfSongs; i++) {
            String[] tokens = scanner.nextLine().split("_");

            Song currentSong = new Song(tokens[0], tokens[1], tokens[2]);
            songList.add(currentSong);
        }

        String type = scanner.nextLine();
        if (type.equals("all")) {
            for (Song song : songList) {
                System.out.println(song.getName());
            }
        } else {
            for (Song song : songList) {
                if (type.equals(song.getTypeList())) {
                    System.out.println(song.getName());
                }
            }
        }
    }
}
