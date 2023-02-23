package main.solution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/***************************
 * {@link Name: } Jobayed Ullah
 */

public class StringProcessing {

    private static final String NUMBER_PATTERN = "/^\\[+-]?d*\\.?\\d*$/";

    private static final Pattern pattern = Pattern.compile(NUMBER_PATTERN);

    public static boolean isValid(final String number) {
        Matcher matcher = pattern.matcher(number);
        return matcher.matches();
    }

    // 8. String to Integer (atoi)
    public int myAtoi(String s) {
        s = s.trim();

        int len = s.length();

        String convStr = "";
        int decCount = 0;
        for (int i = 0; i < len; ++i) {
            if (i == 0) {
                if ((s.charAt(i) >= '0' && s.charAt(i) <= '9')
                        || s.charAt(i) == '+'
                        || s.charAt(i) == '-') {
                    convStr += s.charAt(i);
                } else break;
            } else if (s.charAt(i) >= '0' && s.charAt(i) <= '9'
            ) {
                convStr += s.charAt(i);
            } else if (s.charAt(i) == '.') {
                if (decCount != 0) {
                    break;
                }
                convStr += s.charAt(i);
                ++decCount;
            } else {
                break;
            }
        }
        Double digit = null;
        try {
            digit = Double.parseDouble(convStr);
        } catch (NumberFormatException e) {
            return 0;
        }

        if (digit > 2147483647)
            digit = 2147483647.0;
        else if (digit < -2147483648) digit = -2147483648.0;

        return digit.intValue();
    }

    // 290. Word Pattern
    public boolean wordPattern(String pattern, String s) {
        int len = pattern.length();
        String str1 = "";
        int i = 1;
        HashMap<Character, Integer> mapPattern = new HashMap<>();
        for (int k = 0; k < len; ++k) {
            Character c = pattern.charAt(k);
            Integer x = mapPattern.get(c);
            if (x == null) {
                mapPattern.put(c, i++);
                x = mapPattern.get(c);
            }
            str1 += x;
        }

        String[] words = s.split("\\W");

        List<String> wordList = Arrays.stream(words)
                .filter(item -> !item.isEmpty())
                .collect(Collectors.toList());

        String str2 = "";
        i = 1;
        HashMap<String, Integer> mapWords = new HashMap<>();
        for (int j = 0; j < wordList.size(); ++j) {
            String word = wordList.get(j);
            Integer x = mapWords.get(word);
            if (x == null) {
                mapWords.put(word, i++);
                x = mapWords.get(word);
            }
            str2 += x;
        }

        return str1.equals(str2);
    }

}
