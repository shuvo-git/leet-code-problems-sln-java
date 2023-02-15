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

        Stack<Character> stack = new Stack<Character>();
        int[] counts = new int[100000];
        int i = 0, j = 0;
        int tmpCount = 0;
        for (; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {
                stack.push(')');
                tmpCount = 0;
                continue;
            }
            if (stack.empty()) {
                counts[j] -= tmpCount;
                j = i + 1;
                stack.clear();
                continue;
            }
            char c = stack.pop();
            counts[j] += 2;
            tmpCount += 2;
        }

        int c = counts[0];
        for (int k = 0; k < s.length(); ++k) {
            if (counts[k] > c) {
                c = counts[k];
            }
        }

        return c;
    }
}
