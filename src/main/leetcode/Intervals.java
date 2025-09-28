package main.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Vantage Labs LLC.
 * User: Jobayed Ullah
 * Time: 9/28/25 6:29 PM
 */

public class Intervals {
    public String getStr(int tmp, int val) {
        if (tmp == val)
            return "" + tmp;
        return tmp + "->" + val;
    }

    // 136. Single Number :: solved 5ms
    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) return Collections.emptyList();
        if (nums.length == 1) return Collections.singletonList(nums[0] + "");

        List<String> res = new ArrayList<>();

        int tmp = nums[0];
        int val = tmp;
        for (int i = 1; i < nums.length; ++i) {
            if (val + 1 == nums[i]) {
                ++val;
                continue;
            }
            res.add(getStr(tmp, val));
            tmp = nums[i];
            val = tmp;

        }
        res.add(getStr(tmp, val));
        return res;
    }
}
