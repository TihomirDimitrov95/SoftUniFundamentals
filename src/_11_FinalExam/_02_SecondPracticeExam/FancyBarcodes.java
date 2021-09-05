package _11_FinalExam._02_SecondPracticeExam;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancyBarcodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfBarcodes = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numOfBarcodes; i++) {
            String barcode = scanner.nextLine();

            String regex = "@#+(?<keyOfBarcode>[A-Z][A-Za-z0-9]{4}[A-Za-z0-9]*[A-Z])@#+";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(barcode);

            if (matcher.find()) {
                String productName = matcher.group("keyOfBarcode");

                StringBuilder productGroup = new StringBuilder();
                for (int j = 0; j < productName.length(); j++) {
                    if (Character.isDigit(productName.charAt(j))) {
                        productGroup.append(productName.charAt(j));
                    }
                }

                if (productGroup.length()==0) {
                    System.out.println("Product group: 00");
                } else {
                    System.out.printf("Product group: %s%n", productGroup.toString());
                }

            } else {
                System.out.println("Invalid barcode");
            }

        }

    }
}
