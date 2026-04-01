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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        for(ListNode node : lists){
            pq.offer(node);
        }
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        while(!pq.isEmpty()){
            ListNode node = pq.poll();
            tail.next = node;
            node = node.next;
            tail = tail.next;
            if(node != null){
                pq.offer(node);
            }
        }
        return dummy.next;
    }
}
