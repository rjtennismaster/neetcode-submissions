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
        // A --> A' --> B --> B'
        if (head == null) {
            return null;
        }

        for (Node c = head; c != null; c = c.next.next) {
            Node copy = new Node(c.val);
            copy.next = c.next;
            c.next = copy;
        }

        // randoms
        for (Node c = head; c != null; c = c.next.next) {
            Node copy = c.next;
            copy.random = (c.random == null) ? null : c.random.next;
        }

        // split
        Node newHead = head.next;
        for (Node c = head; c != null; c = c.next) {
            Node copy = c.next;
            c.next = copy.next;
            copy.next = (copy.next == null) ? null : copy.next.next;
        }

        return newHead;
    }
}
