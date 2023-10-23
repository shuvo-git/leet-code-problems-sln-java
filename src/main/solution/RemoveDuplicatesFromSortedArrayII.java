package main.solution;

/***************************
 * @Author: Jobayed Ullah
 * @email: shuvo.pma@gmail.com
 * @date: 10/23/2023
 * @time: 5:20 PM
 */

// 80. Remove Duplicates from Sorted Array II
public class RemoveDuplicatesFromSortedArrayII {
    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArrayII r = new RemoveDuplicatesFromSortedArrayII();
        System.out.println("\n" + r.removeDuplicates(new int[]{1, 2}));
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length == 1) return 1;
        int k = 0;
        int n = 1;
        for (int i = 0, j = 1; j < nums.length; ++j) {
            if (nums[i] != nums[j]) {
                nums[++k] = nums[j];
                i = j;
                n = 1;
            } else if (nums[i] == nums[j] && n > 0) {
                nums[++k] = nums[j];
                ++i;
                --n;
            }
        }
        return k + 1;
    }
}
