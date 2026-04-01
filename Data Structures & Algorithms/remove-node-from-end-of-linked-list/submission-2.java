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
        ListNode slow = head;

        while(n > 0){
            slow = slow.next;
            n--;
        }
        ListNode slow2 = dummy;
        while(slow != null){
            slow = slow.next;
            slow2 = slow2.next;
        }        
        slow2.next = slow2.next.next;
        return dummy.next;
    }
}
