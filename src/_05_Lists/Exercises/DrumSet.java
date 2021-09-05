package _05_Lists.Exercises;

import java.util.List;
import java.util.Scanner;
import java.util.*;
import java.util.stream.Collectors;

public class DrumSet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double savings = Double.parseDouble(scanner.nextLine());
        List<Integer> drumSet = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> originalQuality = new ArrayList<>();
        for (int i = 0; i < drumSet.size(); i++) {
            int quality = drumSet.get(i);
            originalQuality.add(quality);
        }

        String command = scanner.nextLine();
        while (!command.equals("Hit it again, Gabsy!")) {
            int hitPower = Integer.parseInt(command);

            for (int i = 0; i < drumSet.size(); i++) {
                int qualityAfterHit = drumSet.get(i)-hitPower;
                if (qualityAfterHit<=0) {
                    int drumPrice = originalQuality.get(i)*3;
                    if (savings>=drumPrice) {
                        savings-=drumPrice;
                        drumSet.set(i, originalQuality.get(i));
                    } else {
                        drumSet.remove(i);
                        originalQuality.remove(i);
                        if (i<drumSet.size()-1) {
                            i--;
                        }
                    }
                } else {
                    drumSet.set(i, qualityAfterHit);
                }
            }
            command = scanner.nextLine();
        }

        if (drumSet.size()>0) {
            System.out.println(drumSet.toString().replaceAll("[\\[\\],]", ""));
        }
        System.out.printf("Gabsy has %.2flv.", savings);
    }
}
