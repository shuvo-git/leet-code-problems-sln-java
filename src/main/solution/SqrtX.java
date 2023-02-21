package main.solution;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SqrtX {


    public SqrtX() {
        iniSqrt();
    }

    Map<Integer, Integer> numSqrtMap = new HashMap<>();
    List<Integer> revSorted = new ArrayList<>();


    private void iniSqrt() {
        for (int i = 0; i < 46342; ++i) {
            int p = i * i;
            numSqrtMap.put(p, i);
        }

        revSorted = numSqrtMap.keySet().stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());


    }

    private int getSqrt(int x) {
        Integer res = revSorted.stream()
                .filter(i -> x > i)
                .findFirst()
                .get();
        return  numSqrtMap.get(res);
    }

    // 69. Sqrt(x)
    public int mySqrt(int x) {
        if (x == 0 || x == 1)
            return x;

        Integer sqrt = numSqrtMap.get(x);
        if (sqrt != null) {
            return sqrt;
        } else {
            return getSqrt(x);
//            Integer res = numSqrtMap.keySet().stream()
//                    .sorted(Comparator.reverseOrder())
//                    .filter(i-> x > i)
//                    .findFirst()
//                    .get();
//            sqrt= numSqrtMap.get(res);
//            return sqrt;


        }

    }
}
