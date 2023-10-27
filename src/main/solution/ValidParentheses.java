package main.solution;

import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        ValidParentheses v = new ValidParentheses();
        System.out.println(v.longestValidParentheses("(()"));
        System.out.println(v.longestValidParentheses(")()())"));
        System.out.println(v.longestValidParentheses(""));
        System.out.println(v.longestValidParentheses("()"));
        System.out.println(v.longestValidParentheses("(()())"));
    }

    private char closing(char i) {
        if (i == '(') return ')';
        else if (i == '{') return '}';
        else if (i == '[') return ']';

        return i;
    }

    // 20. Valid Parenthesis
    public boolean isValid(String s) {

        Stack<Character> close = new Stack<Character>();
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '('
                    || s.charAt(i) == '['
                    || s.charAt(i) == '{')
                close.push(closing(s.charAt(i)));

            if (s.charAt(i) == ')'
                    || s.charAt(i) == ']'
                    || s.charAt(i) == '}') {
                if (close.empty())
                    return false;
                char c = close.pop();
                if (c != s.charAt(i))
                    return false;
            }
        }

        if (close.empty()) return true;
        return false;
    }

    public int validateParentheses(int i, int len, String s) {
        Stack<Character> stack = new Stack<>();
        int[] dp = new int[len];
        for (int j = i; j < len; ++j) {
            if (s.charAt(j) == '(') {
                stack.push('(');
            } else {
                if (stack.empty()) {
                    dp[j] = 0;
                    continue;
                }

                int k = j;
                while (k < len && s.charAt(k) == ')' && !stack.isEmpty()) {
                    stack.pop();
                    ++k;
                }

                if (stack.empty()) {
                    int tmp = (k - j) * 2;
                    int dpIndx = k - tmp - 1;
                    if (dpIndx >= 0 && dp[dpIndx] != 0)
                        dp[j] = dp[dpIndx] + tmp;
                    else dp[j] = tmp;
                    j = k - 1;
                }
            }
        }

        int max = 0;
        for (int m = 0; m < len; ++m) {
            if (dp[m] > max)
                max = dp[m];
        }
        return max;
    }

    // 32. Longest Valid Parenthesis
    public int longestValidParentheses(String s) {
        int len = s.length();
        int maxLen = 0;

        for (int i = 0; i < len; ++i) {
            int tmp = validateParentheses(i, len, s);
            maxLen = Math.max(tmp, maxLen);
        }
        return maxLen;

    }
}
