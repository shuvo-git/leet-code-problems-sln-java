package main.solution;

import java.util.*;

public class SqrtX {

    // 69. Sqrt(x)
    public int mySqrt(int x) {
        if (x == 0)
            return x;

        int i = 1;
        for (; i <= x / i; ++i) {
            int d = x / i;
            if (d == i)
                return i;
        }
        return i - 1;

    }
}
