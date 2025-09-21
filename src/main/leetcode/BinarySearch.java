package main.leetcode;

/**
 * Vantage Labs LLC.
 * User: Jobayed Ullah
 * Time: 9/21/25 4:36 PM
 */

public class BinarySearch {
    public static void main(String[] args) {

    }

    public int bs(int[] nums, int left, int right, int target) {
        if(left == right)
            return -1;

        int mid = (left + right) / 2;
        int val = nums[mid];

        if (target == val) {
            return mid;
        } else if (target < val) {
            return bs(nums, left, mid, target);
        } else
            return bs(nums, mid + 1, right, target);
    }

    // 704. Binary Search Solved
    public int search(int[] nums, int target) {
        return bs(nums, 0, nums.length, target);
    }
}
