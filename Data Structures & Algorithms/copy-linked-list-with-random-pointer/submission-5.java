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
        Map<Node, Node> map = new HashMap<>();
        Node first = head;
        while(head != null){
            map.put(head, new Node(head.val));
            head = head.next;
        }
        head = first;
        while(head != null){
            Node node = map.get(head);
            node.next = map.get(head.next);
            node.random = map.get(head.random);
            head = head.next;
        }
        return map.get(first);
    }
}
