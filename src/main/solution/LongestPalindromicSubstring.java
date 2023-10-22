package main.solution;

// 5. Longest Palindromic Substring
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        LongestPalindromicSubstring l = new LongestPalindromicSubstring();
        System.out.println(l.longestPalindrome("b"));
        System.out.println(l.longestPalindrome("cbbd"));
        System.out.println(l.longestPalindrome("kkabcbaddd"));
        System.out.println(l.longestPalindrome("ababa"));
    }

    public String longestPalindrome(String s) {
        int sLen = s.length();
        int[][] dp = new int[sLen][sLen];

        for (int i = 0; i < sLen; ++i) {
            dp[i][i] = 1;
            //System.out.print("("+i+","+i+") = " +dp[i][i]+", ");
        }
        //System.out.println();

        for (int i = 0; i < sLen; ++i) {
            for (int j = 0, k = i; j < sLen - i && j < k; j++, k++) {
                char jChar = s.charAt(j);
                char kChar = s.charAt(k);
                if (jChar == kChar && (j + 1 == k || dp[j + 1][k - 1] == 1))
                    dp[j][k] = 1;

                //System.out.print("("+j+","+k+") = " +dp[j][k]+", ");
            }
            //System.out.println();
        }

        for (int i = sLen - 1; i >= 0; --i) {
            for (int j = 0, k = i; j < sLen - i; j++, k++) {
                if (dp[j][k] == 1)
                    return s.substring(j, k + 1);
            }
        }
        return "";
    }

//    boolean isPalindrome(String s, int i, int j) {
//        for (; i < j; ++i, --j) {
//            if (s.charAt(i) != s.charAt(j))
//                return false;
//        }
//        return true;
//    }
//
//
//    public String longestPalindrome(String s) {
//        int maxLen = 0;
//        int start = 0, end = 1;
//
//        int sLen = s.length();
//        for (int i = 0; i < sLen; ++i) {
//            for (int j = 0; j < sLen; ++j) {
//                boolean palindrome = isPalindrome(s, i, j);
//                if (palindrome) {
//                    //System.out.println(palindrome);
//                    int tmp = j - i;
//                    if (tmp > maxLen) {
//                        maxLen = tmp;
//                        start = i;
//                        end = j + 1;
//                    }
//
//                }
//            }
//        }
//        return s.substring(start, end);
//    }
}
