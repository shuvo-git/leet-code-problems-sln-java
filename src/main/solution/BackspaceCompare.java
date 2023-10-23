package main.solution;

import java.util.Stack;

/***************************
 * @Author: Jobayed Ullah
 * @email: shuvo.pma@gmail.com
 * @date: 10/23/2023
 * @time: 3:25 PM
 */

public class BackspaceCompare {
    public static void main(String[] args) {
        BackspaceCompare backspaceCompare = new BackspaceCompare();
        // backspaceCompare.backspaceCompare("a##c","#a#c");
        System.out.println(backspaceCompare.backspaceCompare("y#fo##f", "y#f#o##f"));
    }

    public boolean backspaceCompare(String s, String t) {
        Stack<Character> sStack = new Stack<>();
        Stack<Character> tStack = new Stack<>();

        int sLen = s.length();
        int tLen = t.length();

        for (int i = 0; i < sLen; ++i) {
            char c = s.charAt(i);
            if (c == '#') {
                if (!sStack.isEmpty())
                    sStack.pop();
            } else sStack.push(c);
        }

        for (int i = 0; i < tLen; ++i) {
            char c = t.charAt(i);
            if (c == '#') {
                if (!tStack.isEmpty())
                    tStack.pop();
            } else tStack.push(c);
        }

        while (!sStack.isEmpty() && !tStack.isEmpty()) {
            char cS = sStack.pop();
            char cT = tStack.pop();

            if (cS != cT)
                return false;
        }

        return sStack.isEmpty() && tStack.isEmpty();
    }
}
