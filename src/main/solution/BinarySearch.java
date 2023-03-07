package main.solution;

public class BinarySearch {

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
}
