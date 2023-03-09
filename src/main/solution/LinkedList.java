package main.solution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/***************************
 * {@link Name: } Jobayed Ullah
 */

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
            }
            else {
                current.next = listNode;
                current = current.next;

            }
        }
    }

    // 142. Linked List Cycle II
    public ListNode detectCycle(ListNode head) {
        Set< ListNode> visited = new HashSet<>();

        while (head != null) {
            ListNode next = head.next;
            if(visited.contains(next)){
                return next;
            }

            visited.add(head);
            head = head.next;
        }
        return head;
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
