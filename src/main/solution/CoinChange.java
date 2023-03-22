package main.solution;

import java.util.List;

public class CoinChange {
    private static final int MX = 50;
    int[] ways = new int[MX];

    public CoinChange() {
//        for (int i = 0; i < MX; ++i) {
//            ways[i] = -1;
//        }
//        ways[0] = 1;
    }

    // 39. Combination Sum
    public List<List<Integer>> combinationSum(int[] coins, int target) {
        return null;
    }

    public int combinationSumRec(int[] coins, int target, int n) {
        if (target == 0) return 1;
        if (target < 0 || n < 0) return 0;

        if (ways[target] != 0) {
            return ways[target];
        }

        int incl = combinationSumRec(coins, target - coins[n], n);
        int excl = combinationSumRec(coins, target, n - 1);

        ways[target] = incl + excl;
        return ways[target];
    }
}
