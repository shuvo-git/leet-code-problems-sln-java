package main.solution;

import java.util.List;

/***************************
 * {@link Name: } Jobayed Ullah
 */

public class CoinChange {
    // 39. Combination Sum
    public long combinationSum(int[] coins, int target) {
        return 0;
    }

    public List<List<Integer>> combinationSumRec(int[] coins, int target, List<List<Integer>> ways) {
        if (target < 0) {
            return null;
        }

        for (int i = 0; i < coins.length; ++i) {
            combinationSumRec(coins, target - coins[i], ways);
        }

        return ways;
    }
}
