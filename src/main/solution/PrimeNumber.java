package main.solution;

import java.util.Arrays;

public class PrimeNumber {
    private static final int N = 50000;
    int[] primeNums = new int[N];

    public PrimeNumber() {
        this.seive(N);
    }

    void seive(int n) {
        boolean prime[] = new boolean[n + 1];
        //Arrays.fill(prime, true);
        prime[2] = true;
        for (int i = 3; i < n; i += 2) {
            prime[i] = true;
        }

        int range = (int) Math.sqrt(n);
        for (int i = 3; i < range + 1; i += 2) {

            if (prime[i] == true) {
                for (int j = i * i; j < n; j += i) {
                    prime[j] = false;
                }
            }
        }

        for (int i = 2, j = 0; i < N; ++i) {
            if (prime[i] == true) {
                primeNums[j++] = i;
            }
        }
    }

    // 263. Ugly Number
    public boolean isUgly(int n) {

        int[] uglies = new int[]{2,3,5};

        for (int i = 0; i < 3 && n > 1; ) {
            int ugly = uglies[i];
            if (ugly != 0 && (n % ugly) == 0) {
                n /= ugly;
            } else {
                ++i;
            }
        }
        if (n == 1)
            return true;
        return false;
    }

    // 204. Count Primes
    public int countPrimes(int n) {
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);
        int count = 0;

        if (n == 0 || n == 1 || n == 2) {
            return 0;
        }
        prime[0] = prime[1] = false;

        for (int i = 2; i <= n; i++) {
            if (prime[i]) {
                ++count;
                for (int j = 2 * i; j < n; j += i)
                    prime[j] = false;
            }
        }
        return count;
    }
}
