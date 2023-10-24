package main.solution;

public class UglyNumber {
    public static void main(String[] args) {

    }

    public boolean isUgly(int n) {
        if (n == 0) return false;
        if (n == 1) return true;
        int[] primes = new int[]{2, 3, 5};

        for (int i = 0; i < 3; ) {
            if (n % primes[i] == 0)
                n = n / primes[i];
            else ++i;
        }

        return n == 1;
    }
}
