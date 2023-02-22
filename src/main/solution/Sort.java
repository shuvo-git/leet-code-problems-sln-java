package main.solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/***************************
 * {@link Name: } Jobayed Ullah
 */

public class Sort {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int[] number1 = new int[m];
        for (int i = 0; i < m; ++i) {
            number1[i] = nums1[i];
        }

        int i = 0, j = 0, k = 0;
        for (; i < m && j < n; ++k) {
            if (number1[i] < nums2[j]) {
                nums1[k] = number1[i++];
            } else {
                nums1[k] = nums2[j++];
            }
        }

        for (; i < m; ++i, ++k) {
            nums1[k] = number1[i];
        }

        for (; j < n; ++j, ++k) {
            nums1[k] = nums2[j];
        }
    }

    // 1626. Best Team With No Conflicts

    public int bestTeamScore(int[] scores, int[] ages) {
        List<A> aaaa = new ArrayList<>();
        for (int i = 0; i < scores.length; ++i) {
            A tmp = new A(ages[i], scores[i]);
            aaaa.add(tmp);
        }

        Collections.sort(aaaa);

        return 1;
    }

    private double findMedian(int num1, int num2, int mid1) {
        if (mid1 == -1)
            return num2;
        else return ((double) num1 + (double) num2) / 2.0;
    }

    // 4. Median of Two Sorted Arrays
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;

        int len = len1 + len2 - 1;
        int mid = len / 2;
        int mid1 = -1;
        if (len % 2 == 1) {
            mid1 = mid + 1;
        }


        int num1=0, num2=0;

        int i = 0, j = 0;
        for (; i < len1 && j < len2; ) {
            if (nums1[i] < nums2[j]) {
                num2 = num1;
                num1 = nums1[i++];
            } else {

                num2 = num1;
                num1 = nums2[j++];
            }

            if ((i + j - 1) == (mid + 1)) {
                return findMedian(num1, num2, mid1);
            }
        }

        for (; i < len1; ) {
            num2 = num1;
            num1 = nums1[i++];
            if ((i + j - 1) == (mid + 1)) {
                return findMedian(num1, num2, mid1);
            }
        }

        for (; j < len2; ) {
            num2 = num1;
            num1 = nums2[j++];
            if ((i + j - 1) == (mid + 1)) {
                return findMedian(num1, num2, mid1);
            }
        }
        return num1;

    }

    class A implements Comparable<A> {
        int age;

        int score;

        A(int age, int score) {
            this.age = age;
            this.score = score;
        }


        @Override
        public int compareTo(A o) {
            if (this.score == o.score) return 0;
            else if (this.score < o.score) return -1;
            else return 1;
        }
    }

}
