package _09_TextProcessing.Exercises;

import java.util.Scanner;

public class ExtractFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String filePath = scanner.nextLine();

        String fileName = extractFileName(filePath, filePath.lastIndexOf("\\")+1, filePath.lastIndexOf("."));
        String fileExtension = extractFileExtension(filePath, filePath.lastIndexOf(".")+1);

        System.out.println("File name: " + fileName);
        System.out.println("File extension: " + fileExtension);

    }

    private static String extractFileExtension(String filePath, int startIndex) {
        return filePath.substring(startIndex);
    }

    private static String extractFileName(String filePath, int startIndex, int endingIndex) {
        return filePath.substring(startIndex, endingIndex);
    }
}
