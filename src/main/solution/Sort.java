package main.solution;

import java.util.*;

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

    class A implements Comparable<A> {
        int age;

        int score;

        A(int age, int score) {
            this.age = age;
            this.score = score;
        }


        @Override
        public int compareTo(A o) {
            if( this.score==o.score) return 0;
            else if( this.score<o.score) return -1;
            else return 1;
        }
    }

}
