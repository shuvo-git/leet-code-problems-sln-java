package main.solution;

import java.util.List;

/***************************
 * {@link Name: } Jobayed Ullah
 */

public class CoinChange {
    public long combinationSum(int[] coins, int target) {
        long[] ways = new long[(int) target + 1];
        ways[0] = 1;

        for (int indx = 0; indx < coins.length; ++indx) {
            int coin = coins[indx];
            for (int j = coin; j < ways.length; ++j) {
                if (coin <= j && (j - coin) >= 0) {
                    ways[j] += ways[j - coin];
                }
            }
        }

        return ways[target];
    }

    public List<List<Integer>> combinationSumRec(int[] coins, int target, List<List<Integer>> ways) {
        if (target < 0) {
            return null;
        }

        for (int i = 0; i < coins.length; ++i) {
            combinationSumRec(  coins, target-coins[i], ways);
        }

        return ways;
    }
}
