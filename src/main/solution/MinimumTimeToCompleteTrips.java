package main.solution;

import java.util.Collections;

public class MinimumTimeToCompleteTrips {

    long counts(int[] time, int totalTrips, long mid) {
        long len = time.length;
        long cnt = 0;
        for (int i = 0; i < len; ++i) {
            cnt += mid / time[i];
        }
        return cnt;
    }

    long find(int[] time, int totalTrips, long lo, long hi) {
        if (lo > hi) {
            return lo;
        }
        long mid = (lo + hi) / 2;
        long cnt = this.counts(time, totalTrips, mid);

        if (cnt >= totalTrips) {
            return find(time, totalTrips, lo, mid - 1);
        } else return find(time, totalTrips, mid + 1, hi);

    }

    // 2187. Minimum Time to Complete Trips
    public long minimumTime(int[] time, int totalTrips) {

        long len = time.length, lo = Integer.MAX_VALUE;
        for (int i = 0; i < len; ++i) {
            if (time[i] < lo)
                lo = time[i];
        }
        long hi = lo * totalTrips;
        return find(time, totalTrips, lo, hi);
    }
}
