package main.solution;

public class BinarySearch {

    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        bs.searchRange(new int[]{2,2}, 1);
    }

    int counts(int[] weights, int mid) {
        int sum = 0;
        int dayCount = 0;
        for (int i = 0; i < weights.length; ++i) {
            sum += weights[i];
            if (sum > mid) {
                sum = weights[i];
                ++dayCount;
            }
        }
        if (sum != 0 && sum <= mid) {
            ++dayCount;
        }
        return dayCount;
    }

    private int bs(int lo, int hi, int[] weights, int days) {
        if (lo > hi) {
            return lo;
        }
        int mid = (hi + lo) / 2;
        int dayCount = this.counts(weights, mid);

        if (dayCount <= days) {
            return bs(lo, mid - 1, weights, days);
        } else {
            return bs(mid + 1, hi, weights, days);
        }
    }

    // 1011. Capacity To Ship Packages Within D Days
    public int shipWithinDays(int[] weights, int days) {
        int sum = 0, mx = Integer.MIN_VALUE;
        for (int i = 0; i < weights.length; ++i) {
            if (weights[i] > mx) {
                mx = weights[i];
            }
            sum += weights[i];
        }
        int lo = mx;
        return bs(lo, sum, weights, days);
    }

    int bsLow(int[] nums, int target, int lo, int hi) {
        if (lo == hi) {
            if (target == nums[lo])
                return lo;
            else return -1;
        }
        int mid = (lo + hi) / 2;
        if (nums[mid] == target) {
            return bsLow(nums, target, lo, mid);
        } else if (nums[mid] < target) {
            return bsLow(nums, target, mid + 1, hi);
        } else return bsLow(nums, target, lo, mid);
    }

    int bsHigh(int[] nums, int target, int lo, int hi) {
        if (lo == hi) {
            if (target == nums[hi])
                return hi;
            else return -1;
        }
        int mid = (int)Math.ceil((hi + lo) / 2.0);
        if (nums[mid] == target) {
            //System.out.println(mid + " " + hi);
            return bsHigh(nums, target, mid, hi);
        } else if (nums[mid] < target) {
            return bsHigh(nums, target, mid + 1, hi);
        } else return bsHigh(nums, target, lo, mid - 1);
    }

    // 34 Find first and last position of a sorted array
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if(nums.length == 0)
            return res;
        res[0] = bsLow(nums, target, 0, nums.length - 1);
        res[1] = bsHigh(nums, target, 0, nums.length - 1);

        System.out.println(res[0] + " " + res[1]);
        return res;
    }
}
