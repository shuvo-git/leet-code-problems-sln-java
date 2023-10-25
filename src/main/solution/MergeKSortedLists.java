package main.solution;

import java.util.PriorityQueue;

/***************************
 * @Author: Jobayed Ullah
 * @email: shuvo.pma@gmail.com
 * @date: 10/25/2023
 * @time: 4:42 PM
 */
// 23. Merge k Sorted Lists
public class MergeKSortedLists {

    public static void main(String[] args) {

    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((S, E) -> {
            if (S.val < E.val) return -1;
            else if (S.val == E.val) return 0;
            else return 1;
        });

        for (ListNode node : lists) {
            while (node != null) {
                pq.add(node);
                node = node.next;
            }
        }

        return pq.peek();

    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

