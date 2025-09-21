package main.leetcode;

/**
 * Vantage Labs LLC.
 * User: Jobayed Ullah
 * Time: 9/21/25 8:24 PM
 */

public class PrefixSum {
    int[] nums;

    public PrefixSum(int[] nums) {
        for (int i = 1; i < nums.length; ++i) {
            nums[i] = nums[i - 1] + nums[i];
        }
        this.nums = nums;
    }

    public static void main(String[] args) {
        PrefixSum prefixSum = new PrefixSum(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(prefixSum.sumRange(0, 2));
        System.out.println(prefixSum.sumRange(2, 5));
        System.out.println(prefixSum.sumRange(0, 5));

    }

    // 303. Range Sum Query - Immutable
    public int sumRange(int left, int right) {
        if (left == 0) return nums[right];
        return nums[right] - nums[left - 1];
    }

//    S0 = 0  + A0
//    S1 = S0 + A1
//    S2 = S1 + A2
//    S3 = S2 + A3
//    S4 = S3 + A4
//    --------------------
//    Sum(A2, A3, A4) = S4 - S2 = S3+A4 - (S1+A2)=  A0+A1+A2+A3+A4-(A0+A1+A2)= A3+A4

}
