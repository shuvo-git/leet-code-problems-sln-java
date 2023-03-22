package main.solution;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        String result = "";
        for (int indx = 0; indx < 200; ++indx) {
            boolean matched = true;
            char cur = 0;
            if (indx < strs[0].length()) {
                cur = strs[0].charAt(indx);
                for (int n = 1; n < len; ++n) {
                    if (indx >= strs[n].length()) {
                        matched = false;
                        break;
                    }
                    if (strs[n].charAt(indx) != cur) {
                        matched = false;
                        break;
                    }
                }
            } else matched = false;
            if (matched == false)
                break;
            else result += cur;
        }
        return result;
    }
}
