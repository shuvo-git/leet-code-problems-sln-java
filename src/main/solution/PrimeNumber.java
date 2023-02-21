package main.solution;

import java.util.Arrays;

public class PrimeNumber {
    // 204. Count Primes
    public int countPrimes(int n) {
        boolean[] prime = new boolean[n+1];
        Arrays.fill(prime,true);
        int count = 0;

        if(n==0 || n==1 || n==2){
            return 0;
        }
        prime[0] = prime[1] = false;

        for (int i = 2; i <= n; i++) {
            if (prime[i] ) {
                ++count;
                for (int j = 2*i; j < n; j += i)
                    prime[j] = false;
            }
        }
        return count;
    }
}
