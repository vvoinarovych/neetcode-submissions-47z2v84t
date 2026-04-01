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
        PriorityQueue<ListNode> pq = new PriorityQueue<>( (a,b) -> a.val - b.val);
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        for(ListNode head : lists){
            while(head != null){
                pq.offer(head);
                head = head.next;
            }
        }
        while(!pq.isEmpty()){
            tail.next = pq.poll();
            tail = tail.next;
        }
        return dummy.next;
    }
}
