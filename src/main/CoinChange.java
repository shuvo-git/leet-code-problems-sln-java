package main;

/***************************
 * {@link Name: } Jobayed Ullah
 */

public class CoinChange {
    public long combinationSum(int[] coins, int target) {
        long[] ways = new long[(int) target + 1];
        ways[0] = 1;

        for (int indx = 0; indx < coins.length; ++indx) {
            for (int j = 0; j < ways.length; ++j) {
                if (coins[indx] <= j) {
                    ways[j] += ways[j - coins[indx]];
                }
            }
        }

        return ways[target];
    }
}
