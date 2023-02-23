package main.solution;

public class BinarySearch {

    private int bs(int lo, int hi, int[] weights, int days) {
        if (hi == lo) {
            return (int) hi;
        }
        int mid = (hi + lo) / 2;

        int dayCount = 0;
        int sum = 0;
        for (int i = 0; i < weights.length;++i) {
            sum += weights[i];
            if (sum > mid) {
                sum = weights[i];
                ++dayCount;
            }
        }
        if (sum != 0 && sum < mid) {
            ++dayCount;
        }

//        if(dayCount == days){
//            return (int) mid;
//        }
//        else
            if (dayCount < days) {
            return bs(lo, mid, weights, days);
        } else {
            return bs(mid+1, hi, weights, days);
        }
    }


    // 1011. [NOT SOLVED] Capacity To Ship Packages Within D Days
    public int shipWithinDays(int[] weights, int days) {
        int sum = 0;
        for (int i = 0; i < weights.length; ++i) {
            sum += weights[i];
        }
        return bs(1, sum, weights, days);
    }
}
