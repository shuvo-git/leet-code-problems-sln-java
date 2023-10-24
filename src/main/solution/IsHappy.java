package main.solution;

import java.util.HashSet;
import java.util.Set;

// 202. Happy Number
public class IsHappy {
    public static void main(String[] args) {
        IsHappy isHappy = new IsHappy();
        System.out.println(isHappy.isHappy(12));
    }

    int square(int n) {
        int sum = 0;

        while (n > 0) {
            int r = n % 10;
            sum = sum + r * r;
            n = n / 10;
        }
        return sum;
    }

    public boolean isHappy(int n) {
        Set<Integer> squares = new HashSet<>();

        do {
            if (squares.contains(n)) {
                return false;
            }

            squares.add(n);
            n = square(n);
        } while (n != 1);
        return true;
    }
}
