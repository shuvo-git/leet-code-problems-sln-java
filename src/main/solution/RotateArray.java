package main.solution;

// 189. Rotate Array
public class RotateArray {
    public static void main(String[] args) {
        RotateArray r = new RotateArray();
        r.rotate(new int[]{1, 2, 3, 4, 101, 102, 103, 104, 5, 6, 7}, 3);
    }

    public void rotate(int[] nums, int k) {
        int len = nums.length;
        if (len == 1 || len == 0) return;
        if (k > len) {
            k = k % len;
        }

        int[] tmp = new int[k];
        for (int i = 0, j = len - k; i < k; ++i, ++j) {
            tmp[i] = nums[i];
            nums[i] = nums[j];
        }

        for (int i = len - 1, j = i - k - 1; i > len - 1 - k; --i, --j) {
            nums[i] = nums[j];
        }

        for (int i = 0, j = i + k + 1; i < k; ++i, ++j) {
            nums[j] = tmp[i];
        }
    }
}
