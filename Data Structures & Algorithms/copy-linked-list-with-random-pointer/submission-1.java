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
        if (head == null) {
            return null;
        }

        // make the copy (A --> A' --> B --> B')
        Node l1 = head;

        while (l1 != null) {
            Node l2 = new Node(l1.val);
            l2.next = l1.next;
            l1.next = l2;
            l1 = l2.next;
        }

        l1 = head;
        Node newHead = l1.next;
        // insert random if it exists in the og
        while (l1 != null) {
            Node l2 = l1.next;
            if (l1.random != null) {
                l2.random = l1.random.next;
            }
            l1 = l2.next;
        }

        // disconnect the lists
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
