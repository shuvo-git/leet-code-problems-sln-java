package main.solution;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

/***************************
 * @Author: Jobayed Ullah
 * @email: shuvo.pma@gmail.com
 * @date: 11/10/2023
 * @time: 11:24 AM
 */

class Node //implements Comparable<Node>
{
    int val;
    String name;

    public Node(int v, String n) {
        this.val = v;
        this.name = n;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", name='" + name + '\'' +
                '}';
    }

    public int getVal() {
        return val;
    }

    public String getName() {
        return name;
    }

    //    @Override
//    public int compareTo(Node o) {
//        return Integer.compare(this.val, o.val);
//    }
}

public class StreamPractice {
    public static void main(String[] args) {
        List<Node> nodes = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 20; ++i) {
            int rndNum = random.nextInt(20) + 1;
            char c1 = (char) (random.nextInt(3) + 65);
            char c2 = (char) (random.nextInt(3) + 65);
            Node node = new Node(rndNum, "" + c1 + c2);
            System.out.println(node);
            nodes.add(node);
        }

        List<Node> tmp = nodes.stream()
                .sorted(Comparator.comparing(Node::getName)
                                .thenComparing(Node::getVal))
                .collect(Collectors.toList());

        System.out.println();
        System.out.println();
        System.out.println();
        tmp.stream()
                .forEach(System.out::println);

        Function<Integer, Double> func = (n) -> {
            double sum = 0;
            for (int i = 0; i < n; ++i) {
                sum += i;
            }
            return sum;
        };
        System.out.println(func.apply(100));

    }
}
