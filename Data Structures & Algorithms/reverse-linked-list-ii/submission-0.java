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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0, head);
        ListNode before = dummy;

        for (int i = 1; i < left; i++) {
            before = before.next;
        }

        ListNode prev = null;
        ListNode first = before.next;
        ListNode curr = first;

        for (int i = 0; i <= right - left; i++) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        before.next = prev;
        first.next = curr;

        return dummy.next;
    }
}