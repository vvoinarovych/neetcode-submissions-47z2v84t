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
        Map<Node, Node> pairs = new HashMap<>();
        Node start = head;
        while(head != null){
            pairs.put(head, new Node(head.val));
            head = head.next;
        }
        head = start;

        while(head != null){
            Node newNode = pairs.get(head);
            newNode.next = pairs.get(head.next);
            newNode.random = pairs.get(head.random);
            head = head.next;
        }
        return pairs.get(start);
    }
}
