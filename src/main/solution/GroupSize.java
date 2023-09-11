package main.solution;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

/***************************
 * @Author: Jobayed Ullah
 * @email: shuvo.pma@gmail.com
 * @date: 9/11/2023
 * @time: 5:42 PM
 */

public class GroupSize {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < groupSizes.length; ++i) {
            nodes.add(new Node(groupSizes[i],i));
        }

    }

    static class Node {
        public int k;
        public int v;

        public int getK() {
            return k;
        }

        public int getV() {
            return v;
        }

        public Node(int k, int v) {
            this.k = k;
            this.v = v;
        }
    }
}
