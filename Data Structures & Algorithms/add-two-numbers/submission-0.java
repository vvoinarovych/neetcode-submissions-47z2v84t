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
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        int carry = 0;

        while(l1 != null || l2 != null || carry != 0){
            int l1v = l1 == null ? 0 : l1.val;
            int l2v = l2 == null ? 0 : l2.val;

            int sum = l1v + l2v + carry;
            carry = sum / 10;
            int num = sum % 10;

            current.next = new ListNode(num);
            current = current.next;

            l1 = l1 == null? null : l1.next;
            l2 = l2 == null? null : l2.next;
        }
        return dummy.next;
    }
}
