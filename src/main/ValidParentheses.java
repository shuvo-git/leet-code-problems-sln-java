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
        int n = s.length();
        if (n == 0) {
            return 0;
        }
        int maxSum = Integer.MIN_VALUE;
        int maxSoFar = 0;

        int len = 0;
        int indx = 0;

        for (int i = 0; i < n; ++i) {
            maxSoFar += s.charAt(i) == '(' ? -1 : 1;

            if (maxSoFar > 0) {
                maxSoFar = 0;
                indx = i;
                continue;
            }

            if (maxSoFar > maxSum) {
                maxSum = maxSoFar;
            }

            //if (maxSum == 0) {
            len = Math.max(len, i - indx);
            indx = i;
            //}
        }

        if(maxSum<0)
        {
            len += maxSoFar;
        }
        return len+1;
    }
}
