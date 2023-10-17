package main.solution;

/***************************
 * @Author: Jobayed Ullah
 * @email: shuvo.pma@gmail.com
 * @date: 10/16/2023
 * @time: 5:53 PM
 */

// 7
public class RevInt {
    public static void main(String[] args) {
        System.out.println(reverse(-123));
        System.out.println(reverse(1534236469));
    }

    static public int reverse(int x) {

        long y = x;
        int factor = 1;
        if (x < 0) {
            y = -x;
            factor = -1;
        }

        long sum = 0;
        while (y > 0) {
            sum = sum * 10 + y % 10;
            y = y / 10;
        }

        int sumInt32 = (int) sum;

        if (sum != sumInt32)
            return 0;

        return sumInt32 * factor;

    }
}
