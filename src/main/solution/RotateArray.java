package main.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 189. Rotate Array
public class RotateArray {
    public static void main(String[] args) {
        RotateArray r = new RotateArray();
        int[] arr = {1, 2, 3, 4, 101, 102, 103, 104, 5, 6, 7};
        Arrays.stream(arr).forEach(n -> System.out.printf("%5d", n));
        System.out.println();

        for (int i = 3; i < arr.length; ++i) {
            System.out.printf("%5d", arr[i]);
        }

        for (int i = 0; i < 3; ++i) {
            System.out.printf("%5d", arr[i]);
        }
        System.out.println();

        r.rotate(arr, 3);

        Arrays.stream(arr).forEach(n -> System.out.printf("%5d", n));
        System.out.println();

        List s = new ArrayList<Integer>();
    }

    public static void reverse(int[] nums, int i, int j) {
        while (i < j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;

            ++i;
            --j;
        }
    }

    // AC
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        if (len == 1 || len == 0) return;
        if (k > len) {
            k = k % len;
        }
        if (k < 0) {
            k = k + len;
        }

        reverse(nums, 0, len-k-1);
        reverse(nums, len -k, len-1);

        reverse(nums, 0, len-1);

    }
}
