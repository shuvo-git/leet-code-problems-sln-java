package main.solution;

public class MinimumTimeToCompleteTrips {

    long counts(int[] time, int totalTrips, long mid) {
        int len = time.length;
        int cnt = 0;
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
        long mx = Integer.MIN_VALUE;
        long len = time.length, lo = Integer.MAX_VALUE;
        for (int i = 0; i < len; ++i) {
            if (time[i] < lo)
                lo = time[i];
            if (time[i] > mx)
                mx = time[i];
        }
        long hi = mx * totalTrips;
        return find(time, totalTrips, lo, hi);
    }

    public long minimumTimeV1(int[] time, int totalTrips) {
        int len = time.length, t = 1;
        while (true) {
            int cnt = 0;
            for (int i = 0; i < len; ++i) {
                cnt += t / time[i];
            }
            if (cnt == totalTrips) {
                break;
            }
            ++t;
        }
        return t;
    }
}
