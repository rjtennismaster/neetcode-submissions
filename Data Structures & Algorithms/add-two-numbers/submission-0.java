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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // start cur at a dummy
        ListNode dummy = new ListNode(4);
        ListNode cur = dummy;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            // get the value, and the carry, but first check the condition of the lists
            int v1 = (l1 != null) ? l1.val : 0;
            int v2 = (l2 != null) ? l2.val : 0;

            int rawVal = v1 + v2 + carry;
            int valToInsert = rawVal % 10;
            // update the carry
            carry = rawVal / 10;

            // make the new node
            cur.next = new ListNode(valToInsert);
            cur = cur.next;

            // now move the list pointers
            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }
        return dummy.next;
    }
}
