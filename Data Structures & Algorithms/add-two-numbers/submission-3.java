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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        while(l1 != null || l2 != null || carry > 0){
            int l1val = l1 == null? 0 : l1.val;
            int l2val = l2 == null? 0 : l2.val;
            int sum = carry + l1val + l2val;
            carry = sum / 10;
            int val = sum % 10;

            current.next = new ListNode(val);
            current = current.next;

            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        return dummy.next;
    }
}
