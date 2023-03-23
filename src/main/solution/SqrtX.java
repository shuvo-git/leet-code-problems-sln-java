package main.solution;

import java.util.Arrays;

public class SqrtX {

    // 69. Sqrt(x)
    public int mySqrt(int x) {
        if (x == 0)
            return x;

        int i = 1;
        for (; i <= x / i; ++i) {
            int d = x / i;
            if (d == i)
                return i;
        }
        return i - 1;

    }

    // 367. Valid Perfect Square
    public boolean isPerfectSquare(int num) {
        int sqrt = (int) Math.sqrt(num);
        if (sqrt * sqrt == num) return true;
        return false;
    }

    String toHex(Long num) {
        if (num == 0)
            return "";

        if (num < 0) {
            num += 4294967296L;//2147483647;
        }
        Long x = num % 16;
        char c = (char) (x + '0');
        if (x >= 10 && x <= 15) {
            c = (char) ((x - 10) + 'a');
        }
        return toHex(num / 16) + c;
    }

    // 405. Convert a Number to Hexadecimal
    public String toHex(int num) {
        if (num == 0) return "0";
        return toHex(new Long(num));
    }

    public char[] addStrings(char[] result, char[] num) {
        int len = result.length, numLen = num.length;
        int i = numLen - 1, j = len - 1;
        int carry = 0;

        for (; i >= 0 && j >= 0; --i, --j) {
            int n = (result[j] - '0') + (num[i] - '0') + carry;
            carry = 0;
            if (n > 9) {
                carry = n / 10;
            }
            result[j] = (char) (n % 10 + (int) '0');
        }
        if (carry != 0) {
            for (; j >= 0; --j) {
                int n = (result[j] - '0') + carry;
                carry = 0;
                if (n > 9) {
                    carry = n / 10;
                }
                result[j] = (char) (n % 10 + '0');

                if (carry == 0) break;
            }
        }
        return result;
    }

    // 415. Add Strings
    public String addStrings(String num1, String num2) {
        if (num1.charAt(0) == '0' && num2.charAt(0) == '0') {
            return "0";
        }
        char[] result = new char[10005];
        Arrays.fill(result, '0');

        addStrings(result, num1.toCharArray());
        addStrings(result, num2.toCharArray());

        String str = new String(result);

        int i = 0;
        for (; i < str.length() && str.charAt(i) == '0'; ++i) {

        }

        return str.substring(i);

    }
}
