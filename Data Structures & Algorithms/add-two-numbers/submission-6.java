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
        ListNode result = new ListNode(-1);
        ListNode toReturn = result;
        while(l1 != null || l2 != null || carry != 0){
            int l1val = l1 == null ? 0 : l1.val;
            int l2val = l2 == null ? 0 : l2.val;
            
            int sum = l1val + l2val + carry;
            carry = sum / 10;
            int toAdd = sum % 10;

            result.next = new ListNode(toAdd);
            result = result.next;

            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        return toReturn.next;
    }
}
