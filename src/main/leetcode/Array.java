package main.leetcode;

/**
 * Vantage Labs LLC.
 * User: Jobayed Ullah
 * Time: 9/23/25 8:00 PM
 */

public class Array {
    public static void main(String[] args) {
        Array a = new Array();
        System.out.println(a.majorityElement(new int[]{6,5,5}));
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
}
