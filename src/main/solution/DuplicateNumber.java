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

    // 34. Find First and Last Position of Element in Sorted Array
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length, j = 0, k = 0;

        int[] range = new int[]{-1, -1};
        boolean flag = false;
        for (int i = 0; i < len && j < len; j++) {

            if (nums[j] == target && !flag) {
                range[k++] = j;
                flag = true;
                i = j;
            }

            if (nums[i] != nums[j] && flag) {
                range[k] = j-1;
                break;
            }
        }

        if (flag && range[k] == -1) {
            range[k] = j - 1;
        }

        return range;
    }
}
