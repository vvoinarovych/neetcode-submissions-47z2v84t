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
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
        for(ListNode l : lists){
            pq.offer(l);
        }
        while(!pq.isEmpty()){
            ListNode poll = pq.poll();
            if(poll.next != null){
                pq.offer(poll.next);
            }
            
            tail.next = poll;
            tail = tail.next;
        }
        return dummy.next;
    }
}
