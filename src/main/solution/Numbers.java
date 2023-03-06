package main.solution;

import java.util.HashMap;
import java.util.Map;

/***************************
 * {@link Name: } Jobayed Ullah
 */

public class Numbers {
    int[] fib = new int[46];

    // 13. Roman to Integer
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int len = s.length();
        int result = 0;

        for (int i = 0; i < len; ++i) {
            Character c = s.charAt(i);
            result += map.get(c);

            if (i > 0) {
                Character cMinusOne = s.charAt(i - 1);
                switch (c) {
                    case 'V':
                        if (cMinusOne == 'I')
                            result -= 2;
                        break;
                    case 'X':
                        if (cMinusOne == 'I')
                            result -= 2;
                        break;
                    case 'L':
                        if (cMinusOne == 'X')
                            result -= 20;
                        break;
                    case 'C':
                        if (cMinusOne == 'X')
                            result -= 20;
                        break;
                    case 'D':
                        if (cMinusOne == 'C')
                            result -= 200;
                        break;
                    case 'M':
                        if (cMinusOne == 'C')
                            result -= 200;
                        break;
                    default:
                        break;
                }
            }


        }
        return result;
    }

    // 268. Missing Number
    public int missingNumber(int[] nums) {
        int[] sorted = new int[nums.length + 1];
        for (int i = 0; i < nums.length; ++i) {
            sorted[nums[i]] = 1;
        }

        int j = 0;
        for (; j < sorted.length; ++j) {
            if (sorted[j] != 1)
                return j;
        }
        return j;
    }


    // 70. Climbing Stairs
    public int climbStairs(int n) {
        if (n == 0 || n == 1 || n == 2 || n == 3)
            return n;

        if (fib[n] != 0)
            return fib[n];

        fib[n] = climbStairs(n - 1) + climbStairs(n - 2);

        return fib[n];
    }

    // NOT Solved 746. Min Cost Climbing Stairs
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int totCost = 0;
        for (int jump1 = 0; jump1 < len; ) {
            int jump2 = jump1 + 1;

            if (jump2 < len && cost[jump2] < cost[jump1]) {
                totCost += cost[jump2];
                jump1 += 2;
            } else {
                totCost += cost[jump1];
                ++jump1;
            }
        }
        return totCost;
    }

    // 1539. Kth Missing Positive Number
    public int findKthPositive(int[] arr, int k) {
        int len = arr.length, missingNum = 1;
        for (int i = 0; i < len && k > 0; ++missingNum) {
            if (arr[i] == missingNum) {
                ++i;
                continue;
            }
            --k;
        }

        if (k != 0) {
            missingNum = missingNum + k;
        }
        return missingNum - 1;
    }
}
