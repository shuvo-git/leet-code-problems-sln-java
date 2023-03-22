package main.solution;

import java.util.HashSet;
import java.util.Set;

public class LinkedList {
    public ListNode linkedList;

    public LinkedList(int[] arr) {
        int len = arr.length;
        ListNode current = null;
        for (int i = 0; i < len; ++i) {
            ListNode listNode = new ListNode(arr[i]);
            if (i == 0) {
                linkedList = listNode;
                current = linkedList;
            } else {
                current.next = listNode;
                current = current.next;

            }
        }
    }

    // 142. Linked List Cycle II
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> visited = new HashSet<>();

        while (head != null) {
            ListNode next = head.next;
            if (visited.contains(next)) {
                return next;
            }

            visited.add(head);
            head = head.next;
        }
        return head;
    }
    // 141. Linked List Cycle
    public boolean hasCycle(ListNode head) {
        Set<ListNode> visited = new HashSet<>();

        while (head != null) {
            ListNode next = head.next;
            if (visited.contains(next)) {
                return true;
            }

            visited.add(head);
            head = head.next;
        }
        return false;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
