package main.solution;

/***************************
 * {@link Name: } Jobayed Ullah
 */

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        String converted = "";
        int len = s.length();
        for (int i = 0; i < len; ++i) {
            if ((s.charAt(i) >= '0' && s.charAt(i) <= '9')
                    || (s.charAt(i) >= 'a' && s.charAt(i) <= 'z')
            ) converted += s.charAt(i);
            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')
                converted += (char)(s.charAt(i) + 32);
        }
        int len2 = converted.length();
        for (int i = 0,j=len2-1; i < j; ++i,--j) {
            if(converted.charAt(i) != converted.charAt(j))
                return false;
        }
        return true;
    }
}
