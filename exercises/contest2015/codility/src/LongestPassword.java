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

    private static String getPassword(String[] words) {
        List<String> tempRes = new ArrayList<>();
        String maxLengthStr = "";

        for (String word : words) {
            int numberOfLetters = 0;
            int numberOfDigits = 0;
            boolean include = true;
            for (char c : word.toCharArray()) {
                if (!Character.isAlphabetic(c) && !Character.isDigit(c)) {
                    include = false;
                    break;
                }
                if (Character.isAlphabetic(c)) {
                    numberOfLetters++;
                } else if (Character.isDigit(c)) {
                    numberOfDigits++;
                }
            }
            if (include
                    && numberOfDigits % 2 != 0
                    && numberOfLetters % 2 == 0) {
                tempRes.add(word);
            }
        }
        if (tempRes.isEmpty()) {
            return "";
        }
        for (String word : tempRes) {
            maxLengthStr = maxLengthStr.length() > word.length()
                    ? maxLengthStr : word;
        }

        return maxLengthStr;
    }
}
