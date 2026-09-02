/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        // make the copy (A --> A' --> B --> B')

        if (head == null) {
            return null;
        }

        Node l1 = head;

        while (l1 != null) {
            Node l2 = new Node(l1.val);
            // make l1 point to this, and make this point to l1.next
            l2.next = l1.next;
            l1.next = l2;
            l1 = l2.next;
        }

        Node newHead = head.next;

        // update copies' random field if it exists on the og
        l1 = head;
        while (l1 != null) {
            Node l2 = l1.next;
            if (l1.random != null) {
                l2.random = l1.random.next;
            }
            l1 = l1.next.next;
        }
        // de-interleave the lists
        l1 = head;
        while (l1 != null) {
            Node l2 = l1.next;
            l1.next = l2.next;
            if (l2.next != null) {
                l2.next = l2.next.next;
            }
            l1 = l1.next;
        }
        return newHead;
    }
}
