package main.leetcode;

/**
 * Vantage Labs LLC.
 * User: Jobayed Ullah
 * Time: 9/23/25 8:00 PM
 */

public class Array {
    public static void main(String[] args) {
        Array a = new Array();
//        System.out.println(a.majorityElement(new int[]{6, 5, 5}));
        System.out.println(a.maxProfit(new int[]{2, 1, 2, 1, 0, 1, 2}));
    }

    // 169. Majority Element :: 2ms : Beats73.86%
    public int majorityElement(int[] nums) {
        int candidate = -1;
        int count = 0;

        for (int i = 0; i < nums.length; ++i) {
            if (count == 0) candidate = nums[i];
            count = nums[i] == candidate ? count + 1 : count - 1;
        }
        return candidate;
    }

    // 121. Best Time to Buy and Sell Stock :: 1ms
    public int maxProfit(int[] prices) {
        int buyingPrice = Integer.MIN_VALUE;
        int mxProfit = 0;
        for (int sellingPrice : prices) {
            int profit = sellingPrice - buyingPrice;
            if (profit > mxProfit) {
                mxProfit = profit;
            } else if (profit < 0)
                buyingPrice = sellingPrice;
        }
        return mxProfit;
    }

    // 122. Best Time to Buy and Sell Stock II :: 1ms
    public int maxProfit2(int[] prices) {
        int buyingPrice = Integer.MIN_VALUE;
        int mxProfit = 0;
        int sum = 0;
        for (int sellingPrice : prices) {
            int profit = sellingPrice - buyingPrice;
            if (profit > mxProfit) {
                mxProfit = profit;
            } else {
                sum += mxProfit;
                mxProfit = 0;
                buyingPrice = sellingPrice;
            }
        }
        return sum + mxProfit;
    }
}
