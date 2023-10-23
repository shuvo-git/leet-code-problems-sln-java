package main.solution;

public class DuplicateNumber {
    //26. Remove Duplicates from Sorted Array
    public int removeDuplicates(int[] nums) {
        int len = nums.length, k = 0;

        for (int i = 0, j = 0; i < len && j < len && k < len; j++) {
            if (nums[i] == nums[j]) {
                continue;
            } else if (nums[i] != nums[j]) {
                ++k;
                nums[k] = nums[j];
                i = j;
            }
        }
        return k + 1;
    }
}
