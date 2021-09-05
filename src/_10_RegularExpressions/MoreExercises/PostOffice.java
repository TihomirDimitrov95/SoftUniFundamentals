package _10_RegularExpressions.MoreExercises;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PostOffice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\|");

        String capitalLetters = getCapitalLetters(input[0]);
        Map<Character, Integer> wordLength = getWordLength(input[1], capitalLetters);
        List<String> validWords = getValidWords(input[2], wordLength);

        for (String validWord : validWords) {
            System.out.println(validWord);
        }

    }

    private static List<String> getValidWords(String part3, Map<Character, Integer> wordLengthMap) {
        String regex = "[A-Z][^ ]*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(part3);

        List<String> validWords = new ArrayList<>();

        while (matcher.find()) {
            String currentWord = matcher.group();

            char beginningChar = currentWord.charAt(0);

            if (wordLengthMap.containsKey(beginningChar) && currentWord.length()==wordLengthMap.get(beginningChar)) {
                validWords.add(currentWord);
            }

        }

        return validWords;
    }

    private static Map<Character, Integer> getWordLength(String part2, String capitalLetters) {
        Map<Character, Integer> wordLength = new LinkedHashMap<>();

        String regex = "(?<characterCode>[0-9]+):(?<length>\\d\\d)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(part2);

        while (matcher.find()) {
            char currentChar = (char) Integer.parseInt(matcher.group("characterCode"));
            int length = Integer.parseInt(matcher.group("length")) + 1;

            if (capitalLetters.contains("" + currentChar)) {
                wordLength.put(currentChar, length);
            }
        }


        return wordLength;
    }

    private static String getCapitalLetters(String part1) {
        String regexForCapitals = "(?<specialSymbol>[#$%*&])(?<capitalLetter>[A-Z]+)\\1";
        Pattern patternCapitalLetters = Pattern.compile(regexForCapitals);
        Matcher matcherForCapitals = patternCapitalLetters.matcher(part1);


        String capitalLetters = "";
        while (matcherForCapitals.find()) {
            capitalLetters += matcherForCapitals.group("capitalLetter");

        }

        return capitalLetters;
    }
}
