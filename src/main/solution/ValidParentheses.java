package main.solution;

import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        ValidParentheses v = new ValidParentheses();

        System.out.println(v.longestValidParentheses("))(())))(()())))((("));
//        System.out.println(v.longestValidParentheses("(()"));
//        System.out.println(v.longestValidParentheses(")()())"));
//        System.out.println(v.longestValidParentheses(""));
//        System.out.println(v.longestValidParentheses("()"));
//        System.out.println(v.longestValidParentheses("(()())"));
//        System.out.println(v.longestValidParentheses(")(((((()())()()))()(()))("));
//        System.out.println(v.longestValidParentheses("(()()"));
//        System.out.println(v.longestValidParentheses("()(()((("));

//        String s = "(()())";
//        int mx = v.rec(s, 0, 0, new Stack<Character>(), 0);
//        System.out.println(mx);
    }

    private void init(int trashIndx, int ii) {
        String s = "))(())))(()())))(((";
        System.out.println("......................... i-1 = " + (ii - 1) + "....................................................");

        for (int i = 0; i < s.length(); ++i) {
            if (i == trashIndx && i == ii)
                System.out.printf("%3s ", "t,i");
            else if (i == trashIndx)
                System.out.printf("%3c ", 't');
            else if (i == ii)
                System.out.printf("%3c ", 'i');
            else
                System.out.printf("%4c", ' ');
        }
        System.out.println();

        for (int i = 0; i < s.length(); ++i) {
            System.out.printf("%3d ", i);
        }
        System.out.println();
        for (int i = 0; i < s.length(); ++i) {
            System.out.printf("%3c ", s.charAt(i));
        }
        System.out.println();
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

    public int longestValidParentheses(String s) {
        int len = s.length();
        Stack<Integer> stack = new Stack<>();

        int ans = 0;
        int trashIndx = 0;
        for (int i = 1; i <= len; ++i) {

            init(trashIndx, i);
            if (s.charAt(i - 1) == '(') {
                System.out.printf("Found Opening curly brace at (i-1) = %d th  index.\n " +
                        "Pushing i = %d to Stack\n", i - 1, i);

                stack.push(i);
            } else {
                System.out.printf("Found Closing curly brace at (i-1) = %d th  index.\n", i - 1);
                if (stack.isEmpty()) {
                    System.out.printf("Try to pop but stack is empty.\n " +
                            "So changing TrashIndex to i = %d\n ", i);
                    trashIndx = i;
                    continue;
                } else {
                    System.out.println("Popped stack top = " + stack.peek());
                    stack.pop();
                }

                System.out.printf("Now stack is %s empty\n", stack.isEmpty() ? "" : "not");

                if (stack.isEmpty())
                    System.out.printf("So we will get the difference between i = %d and trashIndex = %d\n" +
                            "And This diff is (i-trashIndex) = (%d - %d) = %d\n", i, trashIndx, i, trashIndx, i - trashIndx);

                else
                    System.out.printf("So we will get the difference between i = %d and Stack Top = %d\n" +
                            "And This diff is (i-Stack Top) = (%d - %d) = %d\n", i, stack.peek(), i, stack.peek(), i - stack.peek());

                int tmp = stack.isEmpty() ? trashIndx : stack.peek();

                System.out.println("We will now find the maximum value between current answer and our probable answer");
                System.out.println("Our current answer is " + ans);
                System.out.println("our probable answer is " + (i - tmp));

                ans = Math.max(ans, i - tmp);

                System.out.println("So, maximum between this two is " + ans);
            }
        }
        System.out.println("**************************************************************************");
        System.out.println("**************************************************************************");
        return ans;
    }
}
