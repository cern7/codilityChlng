import java.util.*;
import java.util.stream.Collectors;

public class LongestPassword {
    public static void main(String[] args) {
        System.out.println(solution("0abd 0ab 0a 0"));
    }

    public static int solution(String S) {
        String[] p = S.split(" ");
        String res = getPassword(p);
        return !res.isEmpty() ? res.length() : -1;
    }

    private static boolean isValidPassword(String word) {
        int numberOfLetters = 0;
        int numberOfDigits = 0;
        for (char c : word.toCharArray()) {
            if (!Character.isLetterOrDigit(c)) {
                return false;
            }
            if (Character.isAlphabetic(c)) {
                numberOfLetters++;
            } else if (Character.isDigit(c)) {
                numberOfDigits++;
            }
        }
        return numberOfDigits % 2 != 0 && numberOfLetters % 2 == 0;
    }

    private static String getPassword(String[] words) {
        List<String> validWords = Arrays.stream(words)
                .filter(LongestPassword::isValidPassword)
                .toList();
        Optional<String> maxWord = validWords.stream().max(String::compareToIgnoreCase);

        return maxWord.orElse("");
    }
}
