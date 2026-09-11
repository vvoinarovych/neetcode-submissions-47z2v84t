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
        ListNode dummy = new ListNode(-1, head);
        ListNode nth = head;
        while(n > 0){
            nth = nth.next;
            n--;
        }
        ListNode target = dummy;

        while(nth != null){
            nth = nth.next;
            target = target.next;
        }
        target.next = target.next.next;
        return dummy.next;
    }
}
