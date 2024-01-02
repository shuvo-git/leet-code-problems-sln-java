package main.solution;

/***************************
 * @Author: Jobayed Ullah
 * @email: shuvo.pma@gmail.com
 * @date: 1/1/2024
 * @time: 2:53 PM
 */

public class EditDistance {
    public static void main(String[] args) {
        System.out.println(EditDistance.minDistance("horse", "ros"));
    }

    public static int minDistance(String word1, String word2) {
        int w1Len = word1.length();
        int w2Len = word2.length();

        int[][] dp = new int[w2Len + 1][w1Len + 1];

        for (int i = 0; i <= w1Len; ++i)
            dp[0][i] = i;

        for (int i = 1; i <= w2Len; ++i)
            dp[i][0] = i;

        for (int i = 0, row = i + 1; i < w2Len; ++i, ++row) {
            char c2 = word2.charAt(i);
            for (int j = 0, col = j + 1; j < w1Len; ++j, ++col) {
                char c1 = word1.charAt(j);

                if (c1 == c2) { // No change
                    dp[row][col] = dp[row - 1][col - 1];
                }
                else {
                    int tmp = Math.min(dp[row - 1][col - 1], dp[row - 1][col]);
                    dp[row][col] = Math.min(tmp, dp[row][col - 1])+1;
                }
            }
        }

        return dp[w2Len][w1Len];
    }
}
