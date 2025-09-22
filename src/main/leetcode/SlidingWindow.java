package main.leetcode;

import java.util.HashSet;

/**
 * Vantage Labs LLC.
 * User: Jobayed Ullah
 * Time: 9/21/25 3:04 PM
 */

public class SlidingWindow {
    public static void main(String[] args) {
        SlidingWindow sw = new SlidingWindow();
//        System.out.println(sw.lengthOfLongestSubstring("abcabcbb"));
//        System.out.println(sw.lengthOfLongestSubstring("bbbbb"));
//        System.out.println(sw.lengthOfLongestSubstring("pwwkew"));
//        System.out.println(sw.lengthOfLongestSubstring());

//        System.out.println(sw.lengthOfLongestSubstringV2("abcabcbb"));
//        System.out.println(sw.lengthOfLongestSubstringV2("bbbbb"));
//        System.out.println(sw.lengthOfLongestSubstringV2("pwwkew"));
//        System.out.println(sw.lengthOfLongestSubstringV2("au"));
//        System.out.println(sw.lengthOfLongestSubstringV2("dvdf"));

        System.out.println(sw.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }

    // 3. Longest Substring Without Repeating Characters ::: SOLVED .Sliding window
    // 6ms
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        HashSet<Character> set = new HashSet<>();
        int left = 0, mx = 0;
        for (int right = 0; right < len; ++right) {
            char c = s.charAt(right);
            while (set.contains(c)) {
                set.remove(s.charAt(left++));
            }
            set.add(c);
            mx = Math.max(mx, right - left + 1);
        }
        return mx;
    }

    // 3. Longest Substring Without Repeating Characters ::: SOLVED .Sliding window
    // 2ms, [Improved] Jump instead of incremental while
    public int lengthOfLongestSubstringV2(String s) {
        int len = s.length();
        int[] index = new int[26];
        int left = 0, right = 0, mx = 0;
        for (; right < len; ++right) {
            char c = s.charAt(right);

            left = Math.max(left, index[c - 'a']);

            mx = Math.max(mx, right - left + 1);
            index[c - 'a'] = right + 1;
        }
        return mx;
    }


    // 209. Minimum Size Subarray Sum :: Solved
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0, minSize = Integer.MAX_VALUE, sum = 0;
        for (; right < nums.length; ++right) {
            sum += nums[right];
            while (sum >= target) {
                minSize = Math.min(minSize, right - left + 1);
                sum -= nums[left++];
            }
        }
        return minSize == Integer.MAX_VALUE ? 0 : minSize;
    }


}
