package main.solution;

public class KokoEatingBananas {
    private long countHour(int[] weights, int projectedHour) {
        int len = weights.length;
        long counts = 0;
        for (int i = 0; i < len; ++i) {
            counts +=   weights[i] /  projectedHour;
            if(weights[i] %  projectedHour != 0){
                ++counts;
            }
        }
        return counts;
    }

    private int bs(int[] weights, int hour, int lo, int hi) {
        if (lo > hi) {
            return lo;
        }
        int mid = (lo + hi) / 2;

        long countedHour = this.countHour(weights, mid);

        if (countedHour <= hour) {
            return bs(weights, hour, lo, mid - 1);
        } else return bs(weights, hour, mid + 1, hi);


    }

    // 875. Koko Eating Bananas
    public int minEatingSpeed(int[] piles, int h) {
        int len = piles.length, mx = Integer.MIN_VALUE;
        for (int i = 0; i < len; ++i) {
            if (piles[i] > mx) {
                mx = piles[i];
            }
        }
        return bs(piles, h, 1, mx);
    }
}
