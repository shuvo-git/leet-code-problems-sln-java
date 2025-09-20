package main.leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {

    }

    // 1. Two Sum ::: SOLVED
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (indexMap.containsKey(target - nums[i]))
                return new int[]{i, indexMap.get(target - nums[i])};

            indexMap.put(nums[i], i);
        }

        return new int[]{};
    }

    //167. Two Sum II - Input Array Is Sorted ::: SOLVED
    public int[] twoSum2(int[] numbers, int target) {
        int i, j;
        for (i = 0, j = numbers.length - 1; i < j; ) {
            int left = numbers[i], right = numbers[j];
            if (left + right == target) {
                return new int[]{i + 1, j + 1};

            } else if (target > right + left) {  // target-left<right => target<sum
                i++;
            } else j--;
        }

        return new int[]{};
    }
}
