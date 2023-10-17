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

//    public int combinationSumRec(int[] coins, int target, int n) {
//        if (target == 0) return 1;
//        if (target < 0 || n < 0) return 0;
//
//        if (ways[target] != 0) {
//            return ways[target];
//        }
//
//        int incl = combinationSumRec(coins, target - coins[n], n);
//        int excl = combinationSumRec(coins, target, n - 1);
//
//        ways[target] = incl + excl;
//        return ways[target];
//    }

//    public int coinChange(int[] coins, int amount) {
//        int[] ways = new int[amount + 1];
//        ways[0] = 1;
//
//        for (int i = 0; i < coins.length; ++i) {
//            for (int j = coins[i]; j < ways.length; ++j) {
//                ways[j] += ways[j - coins[i]];
//            }
//        }
//        return ways[amount];
//    }

//    public int minCoins(int[] coins, int n, int v) {
//        if (v == 0) return 0;
//        int res = Integer.MAX_VALUE;
//        for (int i = 0; i < n; ++i) {
//            if (coins[i] <= v) {
//                int result = minCoins(coins, n, v - coins[i]);
//
//                if (result != Integer.MAX_VALUE && result + 1 < res) {
//                    res = result + 1;
//                }
//            }
//        }
//
//        return res;
//    }
//
//    public int coinChange(int[] coins, int amount) {
//        int res = minCoins(coins, coins.length, amount);
//        if (res == Integer.MAX_VALUE) return -1;
//        return res;
//    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;

        for (int i = 1; i <= amount; ++i) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i <= amount; ++i) {
            for (int coin : coins) {
                if (coin <= i) {
                    int tmp = dp[i - coin];
                    //System.out.println(tmp);
                    if (tmp != Integer.MAX_VALUE && tmp + 1 < dp[i]) {
                        dp[i] = tmp + 1;
                    }
                }
            }
        }
        if (dp[amount] == Integer.MAX_VALUE) return -1;
        return dp[amount];
    }
}
