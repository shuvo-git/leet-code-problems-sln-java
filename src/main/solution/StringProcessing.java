package main.solution;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

}
