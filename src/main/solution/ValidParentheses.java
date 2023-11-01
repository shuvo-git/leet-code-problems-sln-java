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
        System.out.println("........................." + (ii - 1) + "....................................................");

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

//    public int validateParentheses(int i, int len, String s) {
//        Stack<Character> stack = new Stack<>();
//        int[] dp = new int[len];
//        for (int j = i; j < len; ++j) {
//            if (s.charAt(j) == '(') {
//                stack.push('(');
//            } else {
//                if (stack.empty()) {
//                    dp[j] = 0;
//                    continue;
//                }
//
//                int k = j;
//                while (k < len && s.charAt(k) == ')' && !stack.isEmpty()) {
//                    stack.pop();
//                    ++k;
//                }
//
//                if (stack.empty()) {
//                    int tmp = (k - j) * 2;
//                    int dpIndx = k - tmp - 1;
//                    if (dpIndx >= 0 && dp[dpIndx] != 0)
//                        dp[j] = dp[dpIndx] + tmp;
//                    else dp[j] = tmp;
//                }
//                j = k - 1;
//            }
//        }
//
//        int max = 0;
//        for (int m = 0; m < len; ++m) {
//            if (dp[m] > max)
//                max = dp[m];
//        }
//        return max;
//    }

    // 32. Longest Valid Parenthesis
//    public int longestValidParentheses(String s) {
//        int len = s.length();
//        int ans = 0;
//
//        int maxLen = 0;
//        int tmp = 0;
//        Stack<Character> stack = new Stack<>();
//        for (int i = 0; i < len; ++i) {
//            char c = s.charAt(i);
//            if (c == '(') {
//                stack.push('(');
//            } else {
//                if (stack.isEmpty()) {
//                    maxLen += tmp;
//                    tmp = 0;
//                    ans = Math.max(ans, maxLen);
//                    maxLen = 0;
//                } else {
//                    tmp += 2;
//                }
//            }
//
//        }
//
//        //if(stack.isEmpty())
//            maxLen += tmp;
//        ans = Math.max(ans, maxLen);
//        return ans;
//
//    }

//    int recursiveCheckParenthesis(String s, int i, int j, Stack<Character> stack, int tmp, int max) {
//        if (i > j || j >= s.length())
//            return max;
//
//        char c = s.charAt(j);
//        if (c == '(') {
//            stack.push(c);
//        } else {
//            if (stack.isEmpty()) {
//                max = Math.max(max, tmp);
//                return Math.max(max, recursiveCheckParenthesis(s, j + 1, j + 1, stack, 0, max));
//            } else {
//                stack.pop();
//                tmp += 2;
//
//                if (j == s.length() - 1 && !stack.isEmpty()) {
//                    return Math.max(max, recursiveCheckParenthesis(s, i + 1, i + 1, new Stack<>(), 0, max));
//                }
//            }
//
//            if (stack.isEmpty()) {
//                max += tmp;
//            }
//        }
//        return Math.max(max, recursiveCheckParenthesis(s, i, j + 1, stack, tmp, max));
//    }


//    int recursiveCheckParenthesis(String s, int i, int j, Stack<Character> stack, int max) {
//        if (j >= s.length())
//            return 0;
//        char c = s.charAt(j);
//        if (c == '(') {
//            stack.push(c);
//        } else if (stack.isEmpty()) {
//            return 0;
//        } else {
//            stack.pop();
//        }
//
//        if (stack.empty()) {
//            max = Math.max(j - i + 1, max);
//        }
//        return Math.max(max, recursiveCheckParenthesis(s, i, j + 1, stack, max));
//    }

    public int longestValidParentheses(String s) {
        int len = s.length();
        Stack<Integer> stack = new Stack<>();

        int ans = 0;
        int trashIndx = 0;
        for (int i = 1; i <= len; ++i) {

            init(trashIndx, i);
            if (s.charAt(i - 1) == '(') {
                System.out.printf("(i-1) = %d, i = %d , trashIndx = %d, ans = %d\n", i - 1, i, trashIndx, ans);
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    System.out.printf("(i-1) = %d, i = %d , trashIndx = %d, ans = %d\n", i - 1, i, trashIndx, ans);
                    trashIndx = i;
                    System.out.println("Changed Trash Index");
                    System.out.printf("(i-1) = %d, i = %d , trashIndx = %d, ans = %d\n", i - 1, i, trashIndx, ans);
                    continue;
                } else {
                    System.out.printf("(i-1) = %d, i = %d , trashIndx = %d, ans = %d\n", i - 1, i, trashIndx, ans);
                    stack.pop();
                }

                System.out.printf("Stack Empty = %b , trashIndx = %d , Stack Top = %d\n", stack.isEmpty(), trashIndx,
                        stack.isEmpty() ? -1 : stack.peek());
                int tmp = stack.isEmpty() ? trashIndx : stack.peek();
                System.out.println("Tmp = " + tmp);
                System.out.printf("i - Tmp = (%d - %d) = %d\n", i, tmp, (i - tmp));


                System.out.printf("Ans = Max( %d , %d ) = %d\n", ans, i - tmp, Math.max(ans, i - tmp));
                ans = Math.max(ans, i - tmp);
            }
        }
        System.out.println("**************************************************************************");
        System.out.println("**************************************************************************");
        return ans;
    }
}
