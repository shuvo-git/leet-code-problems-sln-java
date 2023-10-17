package main.solution;

/***************************
 * @Author: Jobayed Ullah
 * @email: shuvo.pma@gmail.com
 * @date: 10/17/2023
 * @time: 11:48 AM
 */

// leetcode 3
public class LongestSubStrWithoutRepeatingChar {
    public static void main(String[] args) {
        LongestSubStrWithoutRepeatingChar l = new LongestSubStrWithoutRepeatingChar();
        System.out.println(l.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(l.lengthOfLongestSubstring("bbbbb"));
        System.out.println(l.lengthOfLongestSubstring("pwwkew"));
    }

    public int maxi(int len, int i, int j) {
        int tmp = j - i;
        return tmp > len ? tmp : len;
    }

    public int lengthOfLongestSubstring(String s) {
        int len = 0, sLen
                = s.length();

        int[] freq = new int[130];
        int i = 0, j = 0;

        for (; i <= j && j < sLen; ++j) {
            int c = s.charAt(j);
            if (freq[c] == 1) {
                // System.out.println(len+", i="+i+", j="+j);
                len = maxi(len, i, j);

                while (s.charAt(i) != c) {
                    int p = s.charAt(i);
                    --freq[p];
                    ++i;
                }
                ++i;
                // System.out.println(len+", i="+i+", j="+j);

            } else ++freq[c];
        }

        // System.out.println(len+", i="+i+", j="+j);

        len = maxi(len, i, j);

        return len;
    }
}
