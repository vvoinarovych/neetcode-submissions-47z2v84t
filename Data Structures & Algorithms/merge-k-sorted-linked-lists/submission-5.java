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
        if(lists.length == 0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.val, b.val));
        for(ListNode node : lists){
            pq.offer(node);
        }
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;

        while(!pq.isEmpty() && head != null){
            var pol = pq.poll();
            head.next = pol;
            head = head.next;
            if(pol.next != null){
                pq.offer(pol.next);
            }
        }
        return dummy.next;
    }
}
