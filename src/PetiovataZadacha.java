import java.util.Scanner;

public class PetiovataZadacha {
    public static void main(String[] args) {
        String inputString = new Scanner(System.in).nextLine();

        int maxPalindromeLength = 0;
        int maxPalindromeStartingIndex = 0;

        for (int startOfPalindrome = 0; startOfPalindrome <= inputString.length()-1; startOfPalindrome++) {
            if (maxPalindromeLength > inputString.length()-1-startOfPalindrome) {
                break;
            }
            for (int endOfPalindrome = inputString.length()-1; endOfPalindrome >= startOfPalindrome; endOfPalindrome--) {
                String stringToCheck = inputString.substring(startOfPalindrome,endOfPalindrome+1);
                if (isParlindrome(stringToCheck)) {
                    if (stringToCheck.length()>maxPalindromeLength) {
                        maxPalindromeLength = endOfPalindrome+1-startOfPalindrome;
                        maxPalindromeStartingIndex = startOfPalindrome;
                        break;
                    }
                }
            }
        }

        if (maxPalindromeLength>0) {
            System.out.println("Max palindrome length is: " + maxPalindromeLength);
            System.out.printf("Max palindrome is: %s", inputString.substring(maxPalindromeStartingIndex, maxPalindromeStartingIndex+maxPalindromeLength));
        } else {
            System.out.println("There are no palindromes in the string provided");
        }

    }

    public static boolean isParlindrome (String str) {
        for (int i = 0; i < str.length()/2; i++) {
            if (str.charAt(i)!=str.charAt(str.length()-1-i)) {
                return false;
            }
        }
        return true;
    }
}
