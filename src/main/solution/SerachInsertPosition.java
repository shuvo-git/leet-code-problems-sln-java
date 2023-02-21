package main.solution;

public class SerachInsertPosition {
    //35. Search Insert Position
    public int searchInsert(int[] nums, int target) {
        int len = nums.length, i = 0;
        for (; i < len; ++i) {
            if (target <= nums[i])
                return i;
        }
        return i;
    }
}
