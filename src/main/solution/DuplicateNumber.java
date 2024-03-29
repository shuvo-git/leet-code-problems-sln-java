package main.solution;

public class DuplicateNumber {
    //26. Remove Duplicates from Sorted Array
    public int removeDuplicates(int[] nums) {
        int len = nums.length, k = 0;

        for (int i = 0, j = 0; i < len && j < len && k < len; j++) {
            if (nums[i] == nums[j]) {
                continue;
            } else if (nums[i] != nums[j]) {
                ++k;
                nums[k] = nums[j];
                i = j;
            }
        }
        return k + 1;
    }

    public ListNode deleteDuplicates(ListNode head) {

        if (head == null) return head;


        ListNode current = head;
        int v = current.val;

        while (current.next != null) {
            ListNode tmp = current.next;

            if (tmp.val == v) {
                current.next = tmp.next;
            }
            else {
                v = tmp.val;
                current = current.next;
            }
        }
        return head;
    }

    /**
     * Definition for singly-linked list.
     */
    public class ListNode {
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
}
