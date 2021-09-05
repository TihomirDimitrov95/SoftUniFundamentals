package _11_FinalExam._01_FirstPracticeExam;

import java.math.BigInteger;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputText = scanner.nextLine();

        String regexForNumbers = "\\d";
        Pattern pattern = Pattern.compile(regexForNumbers);
        Matcher matcher = pattern.matcher(inputText);

        int[] coolThreshold = new int[1];
        coolThreshold[0] = 1;
        while (matcher.find()) {
            int currentNum = Integer.parseInt(matcher.group());
            coolThreshold[0] *= currentNum;
        }


        String regexForEmojis = "((\\*{2})|(:{2}))([A-Z][a-z][a-z][a-z]*)\\1";
        Pattern patternForEmojis = Pattern.compile(regexForEmojis);
        Matcher matcherForEmojis = patternForEmojis.matcher(inputText);

        Map<String, Integer> emojisMap = new LinkedHashMap<>();
        while (matcherForEmojis.find()) {
            String emoji = matcherForEmojis.group();
            int emojiCoolness = 0;
            for (int i = 2; i < emoji.length()-2; i++) {
                emojiCoolness += emoji.charAt(i);
            }

            emojisMap.putIfAbsent(emoji, emojiCoolness);
        }


        System.out.println("Cool threshold: " + coolThreshold[0]);
        System.out.printf("%d emojis found in the text. The cool ones are:%n", emojisMap.size());

        emojisMap.entrySet().stream()
                .filter(e -> e.getValue() > coolThreshold[0])
                .forEach(e -> System.out.println(e.getKey()));
    }
}
