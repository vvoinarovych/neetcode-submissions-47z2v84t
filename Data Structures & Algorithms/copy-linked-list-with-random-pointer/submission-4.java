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
        Node current = head;
        while(current != null){
            Node newNode = new Node(current.val);
            pairs.put(current, newNode);
            current = current.next;
        }
        current = head;
        while(current != null){
            Node node = pairs.get(current);
            node.next = pairs.get(current.next);
            node.random = pairs.get(current.random);
            current = current.next;
        }
        return pairs.get(head);
    }
}
