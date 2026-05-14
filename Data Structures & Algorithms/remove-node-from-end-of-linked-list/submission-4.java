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
        ListNode last = head;
        while(n > 0 && last != null){
            last = last.next;
            n--;
        }
        ListNode node = dummy;
        while(last != null){
            last = last.next;
            node = node.next;
        }
        node.next = node.next.next;
       
        return dummy.next;
    }
}
