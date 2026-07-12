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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode r = head;
        ListNode dummy = new ListNode(-1, head);
        ListNode l = dummy;

        int steps = 0;
        while(r != null && steps < n){
            r = r.next;
            steps++;
        }
        while(r != null){
            r = r.next;
            l = l.next;
        }
        l.next = l.next.next;
        return dummy.next;
    }
}
