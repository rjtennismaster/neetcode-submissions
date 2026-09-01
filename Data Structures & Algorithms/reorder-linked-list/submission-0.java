/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode mid = slow;

        // reverse 2nd half

        ListNode prev = null;
        ListNode curr = mid.next;
        mid.next = null;


        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        ListNode l1 = head;
        ListNode l2 = prev;
    

        // fill the new list
        while (l2 != null) {
            ListNode temp1 = l1.next;
            ListNode temp2 = l2.next;

            l1.next = l2;
            l2.next = temp1;
            l1 = temp1;
            l2 = temp2;
        }
    }
}
