package _08_Practice_Mid_Exam._03_ThirdPracticeExam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _02_EmojiDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<String> emojisList = new ArrayList<>();

        int coolThreshold = 1;
        for (int i = 0; i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i))) {
                coolThreshold *= Character.getNumericValue(input.charAt(i));
            }
        }

        int emojiCoolness = 0;

        while (input.length()>=7) {
            int semicolumn = input.indexOf(':');
            if (semicolumn<0) {
                semicolumn = Integer.MAX_VALUE;
            }
            int star = input.indexOf('*');
            if (star < 0 ) {
                star = Integer.MAX_VALUE;
            }

            String currentEmoji = "";
            if (semicolumn<star) {
                input = input.substring(semicolumn);
                if (input.charAt(1) == ':') {
                    if (input.charAt(2)>=65 && input.charAt(2)<=90) {
                        input = input.substring(2);
                        int secondSemi = input.indexOf(':');
                        if (secondSemi==-1) {
                            secondSemi = 100000;
                        }
                        int secondStar = input.indexOf('*');
                        if (secondStar == -1) {
                            secondStar = 100000;
                        }
                        if (secondSemi<secondStar) {
                            if (input.charAt(secondSemi+1) == ':') {
                                currentEmoji = input.substring(0, secondSemi);
                                boolean check = true;
                                for (int i = 1; i < currentEmoji.length(); i++) {
                                    if (input.charAt(i)<97 || input.charAt(i)>122) {
                                        check = false;
                                        break;
                                    }
                                }
                                if (check && currentEmoji.length()>=3) {
                                    StringBuilder newAddition = new StringBuilder();
                                    newAddition.append("::").append(currentEmoji).append("::");
                                    emojisList.add(newAddition.toString());
                                    for (int i = 0; i < currentEmoji.length(); i++) {
                                        emojiCoolness += currentEmoji.charAt(i);
                                    }
                                }
                            }
                        } else {
                            input = input.substring(secondStar);
                        }

                    } else {
                        input = input.substring(2);
                    }
                } else {
                    input = input.substring(1);
                }
            } else {
                input = input.substring(star);
                if (input.charAt(1) == '*') {
                    if (input.charAt(2)>=65 && input.charAt(2)<=90) {
                        input = input.substring(2);
                        int secondSemi = input.indexOf(':');
                        if (secondSemi==-1) {
                            secondSemi = 100000;
                        }
                        int secondStar = input.indexOf('*');
                        if (secondStar==-1) {
                            secondStar = 1000000;
                        }
                        if (secondSemi>secondStar) {
                            if (input.charAt(secondStar+1) == '*') {
                                currentEmoji = input.substring(0, secondStar);
                                boolean check = true;
                                for (int i = 1; i < currentEmoji.length(); i++) {
                                    if (input.charAt(i)<97 || input.charAt(i)>122) {
                                        check = false;
                                        break;
                                    }
                                }
                                if (check && currentEmoji.length()>=3) {
                                    StringBuilder newAdd = new StringBuilder();
                                    newAdd.append("::").append(currentEmoji).append("::");
                                    emojisList.add(newAdd.toString());
                                    for (int i = 0; i < currentEmoji.length(); i++) {
                                        emojiCoolness += currentEmoji.charAt(i);
                                    }
                                }
                            }
                        } else {
                            input = input.substring(secondSemi);
                        }
                    } else {
                        input = input.substring(2);
                    }
                } else {
                    input = input.substring(1);
                }
            }

            if (currentEmoji.length()>0) {
                input = input.substring(currentEmoji.length()+2);
            } else {
                int semi = input.indexOf(':');
                int starr = input.indexOf('*');
                if (semi<starr) {
                    input = input.substring(semi);
                } else {
                    input = input.substring(starr);
                }
            }
        }

        System.out.printf("Cool threshold: %d%n", coolThreshold);
        System.out.printf("%d emojis found in the text. The cool ones are:%n", emojisList.size());

        for (String emoji : emojisList) {
            int emojiCool = 0;
            for (int i = 2; i < emoji.length()-2; i++) {
                emojiCool += emoji.charAt(i);
            }
            if (emojiCool>=coolThreshold) {
                System.out.println(emoji);
            }
        }
    }
}
