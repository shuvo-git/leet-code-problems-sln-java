package main;

import java.util.Stack;

/***************************
 * {@link Name: } Jobayed Ullah
 */

public class ValidParentheses {

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

    // 32. Longest Valid Parenthesis
    public int longestValidParentheses(String s) {
        int len = s.length();
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(-1);

        int maxLen = 0;

        for (int i = 0; i < len; ++i) {
            if (s.charAt(i) == '(') {
                stack.push(-1);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                    continue;
                }
                int currLen = i - stack.peek();

                if (maxLen < currLen) {
                    maxLen = currLen;
                }
            }
        }
        return maxLen;
    }
}
